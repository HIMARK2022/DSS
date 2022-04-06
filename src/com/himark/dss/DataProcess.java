package com.himark.dss;

import java.util.Properties;

import org.apache.ibatis.session.SqlSessionFactory;

import com.himark.service.DeptService;
import com.himark.service.DutyService;
import com.himark.service.PosService;
import com.himark.service.UserService;

public class DataProcess {
	
	// 프로퍼티 파일 읽기
	public static String getProperty(String property) {
		
		SqlSessionFactory c_ssf = MySqlSessionFactory.getClientSqlSessionFactory();
		Properties properties = c_ssf.getConfiguration().getVariables();
		
		String table = properties.getProperty(property).split("\\.")[0];
		
		return table;
	}
	
	
	// 고객사 데이터를 마크애니 DB의 temp 테이블에 저장
	public static void saveTempUser(String[] table) {
		UserService userService = new UserService();
		
		int deleteCount = userService.deleteTemp();
		System.out.println(deleteCount + "건이 temp_user에서 삭제되었습니다.");
		
		int insertCount = 0;
		
		if(!table[0].equals("")) {
			insertCount = userService.insertTempId(table[0]);
			System.out.println(insertCount + "건이 temp_user의 user_id 컬럼에 추가되었습니다.");
		}
		
		if(!table[1].equals("")) {
			insertCount = userService.insertTempName(table[1]);
			System.out.println(insertCount + "건이 temp_user의 user_name 컬럼에 추가되었습니다.");
		}
		
		if(!table[2].equals("")) {
			insertCount = userService.insertTempPosId(table[2]);
			System.out.println(insertCount + "건이 temp_user의 pos_id 컬럼에 추가되었습니다.");
		}
		
		if(!table[3].equals("")) {
			insertCount = userService.insertTempDutyId(table[3]);
			System.out.println(insertCount + "건이 temp_user의 duty_id 컬럼에 추가되었습니다.");
		}
		
		if(!table[4].equals("")) {
			insertCount = userService.insertTempDeptId(table[4]);
			System.out.println(insertCount + "건이 temp_user의 dept_id 컬럼에 추가되었습니다.");
		}
		
		if(!table[5].equals("")) {
			insertCount = userService.insertTempAc(table[5]);
			System.out.println(insertCount + "건이 temp_user의 authority_code 컬럼에 추가되었습니다.");
		}

	}
	
	public static void saveTempPos(String[] table) {
		PosService posService = new PosService();
		
		int deleteCount = posService.deleteTemp();
		System.out.println(deleteCount + "건이 temp_pos에서 삭제되었습니다.");
		
		int insertCount = 0;
		
		if(!table[0].equals("")) {
			insertCount = posService.insertTempId(table[0]);	
			System.out.println(insertCount + "건이 temp_pos의 pos_id 컬럼에 추가되었습니다.");
		}
		
		if(!table[1].equals("")) {
			insertCount = posService.insertTempName(table[1]);
			System.out.println(insertCount + "건이 temp_pos의 pos_name 컬럼에 추가되었습니다.");
		}
	}
	
	public static void saveTempDuty(String[] table) {
		DutyService dutyService = new DutyService();
		
		int deleteCount = dutyService.deleteTemp();
		System.out.println(deleteCount + "건이 temp_duty에서 삭제되었습니다.");
		
		int insertCount = 0;
		
		if(!table[0].equals("")) {
			insertCount = dutyService.insertTempId(table[0]);
			System.out.println(insertCount + "건이 temp_duty의 duty_id 컬럼에 추가되었습니다.");
		}
		
		if(!table[1].equals("")) {
			insertCount = dutyService.insertTempName(table[1]);
			System.out.println(insertCount + "건이 temp_duty의 duty_name 컬럼에 추가되었습니다.");
		}
	}
	
	public static void saveTempDept(String[] table) {
		DeptService deptService = new DeptService();
		
		int deleteCount = deptService.deleteTemp();
		System.out.println(deleteCount + "건이 temp_dept에서 삭제되었습니다.");
		
		int insertCount = 0;
		
		if(!table[0].equals("")) {
			insertCount = deptService.insertTempId(table[0]);
			System.out.println(insertCount + "건이 temp_dept의 dept_id 컬럼에 추가되었습니다.");
		}
		
		if(!table[1].equals("")) {
			insertCount = deptService.insertTempName(table[1]);
			System.out.println(insertCount + "건이 temp_dept의 dept_name 컬럼에 추가되었습니다.");
		}
		
		if(!table[2].equals("")) {
			insertCount = deptService.insertTempUpperId(table[2]);
			System.out.println(insertCount + "건이 temp_dept의 upper_dept_id 컬럼에 추가되었습니다.");
		}
	}
	/*
	public static void copyDept() {
		DeptService service = new DeptService();
		service.insertDept();
	}
	
	public static void copyDuty() {
		DutyService service = new DutyService();
		service.insertDuty();
	}
	
	public static void copyPos() {
		PosService service = new PosService();
		service.insertPos();
	}
	
	public static void copyUser() {
		UserService service = new UserService();
		service.insertUser();
	}
	
	public static void setApprover() {
		UserService service = new UserService();
		ManagerService service_manager = new ManagerService();
		List<User> list = service.selectUser();
		
		for(User user : list) {
			service_manager.setApprover(user.getUserId());
		}
	}
	*/
	
}
