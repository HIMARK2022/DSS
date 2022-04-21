package com.himark.dss;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.session.SqlSessionFactory;

import com.himark.service.ClientService;
import com.himark.service.DeptService;
import com.himark.service.DutyService;
import com.himark.service.InfoService;
import com.himark.service.ManagerService;
import com.himark.service.MarkanyService;
import com.himark.service.PosService;
import com.himark.service.UserService;
import com.himark.vo.CreateVO;
import com.himark.vo.InfoVO;
import com.himark.vo.InsertVO;
import com.himark.vo.JoinVO;
import com.himark.vo.UserVO;

public class DataProcess {
	
	// 프로퍼티 파일 읽어오기
	public static String getProperty(String property) {
		
		SqlSessionFactory c_ssf = MySqlSessionFactory.getClientSqlSessionFactory();
		Properties properties = c_ssf.getConfiguration().getVariables();
		
		String ppt = null;
		try {
			ppt = new String(properties.getProperty(property).getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return ppt;
	}
	
	public static String getSplitProperty(String property, int index) {
		
		SqlSessionFactory c_ssf = MySqlSessionFactory.getClientSqlSessionFactory();
		Properties properties = c_ssf.getConfiguration().getVariables();
		
		String ppt = null;
		try {
			ppt = new String(properties.getProperty(property).getBytes("ISO-8859-1"), "UTF-8").split("\\.")[index];
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return ppt;
	}
	
	public static String[] getProperties(String property) {
		
		SqlSessionFactory c_ssf = MySqlSessionFactory.getClientSqlSessionFactory();
		Properties properties = c_ssf.getConfiguration().getVariables();
		
		String[] ppts = properties.getProperty(property).split(",");
		
		return ppts;
	}
	
	public static void copyDB(String[] tempTables, MarkanyService markanyService, ClientService clientService) {
		
		Map<String, String> tables = new HashMap<String, String>();
		
		for(String tempTable : tempTables) {
			String originTable = tempTable.substring(2);
			
			tables.put("originTable", originTable);
			tables.put("tempTable", tempTable);
			
			// DROP TABLE
			markanyService.dropTable(tempTable);
			
			// CREATE TABLE
			List<String> columnList = clientService.selectColumn(originTable);
			markanyService.createTable(new CreateVO(tempTable, columnList));
						
			// INSERT
			List<Map<String, Object>> dataList = clientService.selectData(originTable);
			Map<String, Object> keyMap = dataList.get(0);
			markanyService.insertData(new InsertVO(tempTable, keyMap, dataList));
			
		}
	}
	
	public static void copyCSV(String[] tempTables, String filePath, MarkanyService markanyService) {
		
		for(String tempTable : tempTables) {
			
			List<String> columnList = new ArrayList<String>();
			BufferedReader br = null;
			String line = "";
			
			// DROP TABLE
			markanyService.dropTable(tempTable);
			
			String fileName = tempTable.substring(2);
			
			try {
				br = Files.newBufferedReader(Paths.get(filePath + "/" + fileName + ".csv"));
				Charset.forName("UTF-8");
				columnList = Arrays.asList(br.readLine().split(",")); // 컬럼

				// CREATE TABLE
				markanyService.createTable(new CreateVO(tempTable, columnList));

				// INSERT
				List<String> tmpList = new ArrayList<String>();
				for (int i = 0; i < columnList.size(); i++) {
					while ((line = br.readLine()) != null) {
						String array[] = line.split(",", -1);
						tmpList = Arrays.asList(array);
						String insertTable = "INSERT INTO `" + tempTable + "` VALUES (";
						for (int j = 0; j < columnList.size(); j++) {
							if (j == columnList.size() - 1) {
								if (tmpList.get(j).equals("")) {
									insertTable += "''";
								} else {
									insertTable += "'" + tmpList.get(j) + "'";
								}
							} else {
								if (tmpList.get(j).equals("")) {
									insertTable += "''" + ",";
								} else {
									insertTable += "'" + tmpList.get(j) + "',";
								}
							}
						}
						insertTable += ")";
						markanyService.insertTable(insertTable);
						System.out.println(insertTable);
					}
				}

				System.out.println("데이터 삽입 완료");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null) {
						br.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}
	
	// temp에 구조 맞춰서 저장
	public static void saveTempUser() {
		
		UserService userService = new UserService();
		
		userService.deleteTemp();
		
		// 조인할 때 기준이 되는 테이블과 컬럼
		String userTable = DataProcess.getSplitProperty("user.user_id", 0);
		String userColumn = DataProcess.getSplitProperty("user.user_id", 1);
		
		// 조인할 테이블
		List<String> user = new ArrayList<String>();
		user.add(DataProcess.getSplitProperty("user.user_name", 0));
		user.add(DataProcess.getSplitProperty("user.pos_id", 0));
		user.add(DataProcess.getSplitProperty("user.duty_id", 0));
		user.add(DataProcess.getSplitProperty("user.dept_id", 0));
		user.add(DataProcess.getSplitProperty("user.authority_code", 0));
		
		// 리스트 내 중복 제거
		HashSet<String> tmpList = new HashSet<String>(user);
		List<String> userList = new ArrayList<String>(tmpList);
		
		// 기준 테이블과 중복되는 테이블 및 존재하지 않는 테이블 제거
		for(int i = 0; i < userList.size(); i++) {
			if(userTable.equals(userList.get(i)) || "".equals(userList.get(i))) {
				userList.remove(i);
			}
		}
		
		// temp에 넣기
		JoinVO joinUser = new JoinVO(userTable, userColumn, userList);
		userService.insertTemp(joinUser);
		
		userService.updateTempAc();

	}
	
	public static void saveTempPos() {
		
		PosService posService = new PosService();
		
		posService.deleteTemp();
		
		// 조인할 때 기준이 되는 테이블과 컬럼
		String posTable = DataProcess.getSplitProperty("pos.pos_id", 0);
		String posColumn = DataProcess.getSplitProperty("pos.pos_id", 1);
		
		// 조인할 테이블
		List<String> pos = new ArrayList<String>();
		pos.add(DataProcess.getSplitProperty("pos.pos_name", 0));
		
		// 리스트 내 중복 제거
		HashSet<String> tmpList = new HashSet<String>(pos);
		List<String> posList = new ArrayList<String>(tmpList);
		
		// 기준 테이블과 중복되는 테이블 및 존재하지 않는 테이블 제거
		for(int i = 0; i < posList.size(); i++) {
			if(posTable.equals(posList.get(i)) || "".equals(posList.get(i))) {
				posList.remove(i);
			}
		}
		
		// temp에 넣기
		JoinVO joinPos = new JoinVO(posTable, posColumn, posList);
		posService.insertTemp(joinPos);
		
	}
	
	public static void saveTempDuty() {
		
		DutyService dutyService = new DutyService();
		
		dutyService.deleteTemp();
		
		// 조인할 때 기준이 되는 테이블과 컬럼
		String dutyTable = DataProcess.getSplitProperty("duty.duty_id", 0);
		String dutyColumn = DataProcess.getSplitProperty("duty.duty_id", 1);
		
		// 조인할 테이블
		List<String> duty = new ArrayList<String>();
		duty.add(DataProcess.getSplitProperty("duty.duty_name", 0));
		
		// 리스트 내 중복 제거
		HashSet<String> tmpList = new HashSet<String>(duty);
		List<String> dutyList = new ArrayList<String>(tmpList);
		
		// 기준 테이블과 중복되는 테이블 및 존재하지 않는 테이블 제거
		for(int i = 0; i < dutyList.size(); i++) {
			if(dutyTable.equals(dutyList.get(i)) || "".equals(dutyList.get(i))) {
				dutyList.remove(i);
			}
		}
		
		// temp에 넣기
		JoinVO joinDuty = new JoinVO(dutyTable, dutyColumn, dutyList);
		dutyService.insertTemp(joinDuty);
		
	}
	
	public static void saveTempDept() {
		
		DeptService deptService = new DeptService();
		
		deptService.deleteTemp();
		
		// 조인할 때 기준이 되는 테이블과 컬럼
		String deptTable = DataProcess.getSplitProperty("dept.dept_id", 0);
		String deptColumn = DataProcess.getSplitProperty("dept.dept_id", 1);
		
		// 조인할 테이블
		List<String> dept = new ArrayList<String>();
		dept.add(DataProcess.getSplitProperty("dept.dept_name", 0));
		dept.add(DataProcess.getSplitProperty("dept.upper_dept_id", 0));
		
		// 리스트 내 중복 제거
		HashSet<String> tmpList = new HashSet<String>(dept);
		List<String> deptList = new ArrayList<String>(tmpList);
		
		// 기준 테이블과 중복되는 테이블 및 존재하지 않는 테이블 제거
		for(int i = 0; i < deptList.size(); i++) {
			if(deptTable.equals(deptList.get(i)) || "".equals(deptList.get(i))) {
				deptList.remove(i);
			}
		}
		
		for(String d : deptList) {
			System.out.println("[" + d + "]");
		}
		
		// temp에 넣기
		JoinVO joinDept = new JoinVO(deptTable, deptColumn, deptList);
		deptService.insertTemp(joinDept);
		
	}
	
	// temp와 비교해서 insert/update/delete
	public static int insertUser() {
		
		UserService userService = new UserService();
		int insertCount = userService.insertUser();
		
		return insertCount;
	}
	
	public static int insertPos() {
		
		PosService posService = new PosService();
		int insertCount = posService.insertPos();
		
		return insertCount;
	}
	
	public static int insertDuty() {
		
		DutyService dutyService = new DutyService();
		int insertCount = dutyService.insertDuty();
		
		return insertCount;
	}
	
	public static int insertDept() {
		
		DeptService deptService = new DeptService();
		int insertCount = deptService.insertDept();
		
		return insertCount;
	}
	
	public static int insertManager() {
		
		UserService service = new UserService();
		ManagerService service_manager = new ManagerService();
		List<UserVO> list = service.selectUser();
		
		int insertCount = 0;
		
		for(UserVO user : list) {
			insertCount += service_manager.insertManager(user.getUserId());
		}
		
		return insertCount;
	}
	
	public static int deletePos() {
		
		PosService service = new PosService();
		int deleteCount = service.deletePos();
		
		return deleteCount;
	}
	
	public static int deleteDuty() {
		
		DutyService service = new DutyService();
		int deleteCount = service.deleteDuty();
		
		return deleteCount;
	}

	public static int deleteDept() {
		
		DeptService service = new DeptService();
		int deleteCount = service.deleteDept();
		
		return deleteCount;
	}

	public static int deleteManager() {
		
		ManagerService service = new ManagerService();
		int deleteCount = service.deleteManager();
		
		return deleteCount;
	}
	
	public static int deleteUser() {
		
		UserService service = new UserService();
		int deleteCount = service.deleteUser();
		
		return deleteCount;
	}
	
	public static int updateUser() {
		
		UserService userService = new UserService();
		int updateCount = userService.updateUser();
		
		return updateCount;
	}
	
	public static int updatePos() {
		
		PosService posService = new PosService();
		int updateCount = posService.updatePos();
		
		return updateCount;
	}
	
	public static int updateDuty() {
		
		DutyService dutyService = new DutyService();
		int updateCount = dutyService.updateDuty();
		
		return updateCount;
	}
	
	public static int updateDept() {
		
		DeptService deptService = new DeptService();
		int updateCount = deptService.updateDept();
		
		return updateCount;
	}
	
	// DB에 로그 저장
	public static int insertInfo(InfoVO info) {
		
		InfoService infoService = new InfoService();
		infoService.delete();
		
		int insertCount = infoService.insert(info);
		
		return insertCount;
	}
	
}
