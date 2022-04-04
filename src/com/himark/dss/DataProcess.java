package com.himark.dss;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.himark.data.Dept;
import com.himark.data.Duty;
import com.himark.data.Pos;
import com.himark.data.User;
import com.himark.service.DeptService;
import com.himark.service.DutyService;
import com.himark.service.ManagerService;
import com.himark.service.PosService;
import com.himark.service.UserService;

public class DataProcess {
	
	// 고객사 데이터 리스트에 저장
	public static List<User> saveClientUser(Connection conn, List<String> user) {
		
		List<User> userList = new LinkedList<User>();
		
		String sql = "select " + user.get(6) 
					+ "," + user.get(7) 
					+ "," + user.get(8) 
					+ "," + user.get(9) 
					+ "," + user.get(10)
					+ "," + user.get(11)
					+ " from " + user.get(5);
		
		System.out.println(sql);
		
		try {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				userList.add(new User(user.get(0), rs.getString(1), rs.getString(2), rs.getString(3),
						              rs.getString(4), rs.getString(5), rs.getString(6)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
	}
	
	public static List<Pos> saveClientPos(Connection conn, List<String> pos) {
		
		List<Pos> posList = new LinkedList<Pos>();
		
		String sql = "select " + pos.get(13) 
					+ "," + pos.get(14) 
					+ " from " + pos.get(12);
		
		System.out.println(sql);
		
		try {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				posList.add(new Pos(pos.get(0), rs.getString(1), rs.getString(2)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return posList;
	}
	
	public static List<Duty> saveClientDuty(Connection conn, List<String> duty) {
		
		List<Duty> dutyList = new LinkedList<Duty>();
		
		String sql = "select " + duty.get(16) 
					+ "," + duty.get(17)
					+ " from " + duty.get(15);
		
		System.out.println(sql);
		
		try {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dutyList.add(new Duty(duty.get(0), rs.getString(1), rs.getString(2)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dutyList;
	}
	
	public static List<Dept> saveClientDept(Connection conn, List<String> dept) {
		
		List<Dept> deptList = new LinkedList<Dept>();
		
		String sql = "select " + dept.get(19) 
					+ "," + dept.get(20) 
					+ "," + dept.get(21)
					+ " from " + dept.get(18);
		
		System.out.println(sql);
		
		try {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				deptList.add(new Dept(dept.get(0), rs.getString(1), rs.getString(2), rs.getString(3)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return deptList;
	}
	
	// 고객사 데이터를 마크애니 DB의 temp 테이블에 저장
	public static int saveTempUser(List<User> userList) {
		UserService userService = new UserService();
		
		int deleteCount = userService.deleteTemp(userList.get(0).getCompanyName());
		System.out.println(deleteCount + "건이 temp_user에서 삭제되었습니다.");
		
		int insertCount = userService.insertTemp(userList);
		
		return insertCount;
	}
	
	public static int saveTempPos(List<Pos> posList) {
		PosService posService = new PosService();
		
		int deleteCount = posService.deleteTemp(posList.get(0).getCompanyName());
		System.out.println(deleteCount + "건이 temp_pos에서 삭제되었습니다.");
		
		int insertCount = posService.insertTemp(posList);
		
		return insertCount;
	}
	
	public static int saveTempDuty(List<Duty> dutyList) {
		DutyService dutyService = new DutyService();
		
		int deleteCount = dutyService.deleteTemp(dutyList.get(0).getCompanyName());
		System.out.println(deleteCount + "건이 temp_duty에서 삭제되었습니다.");
		
		int insertCount = dutyService.insertTemp(dutyList);
		
		return insertCount;
	}

	public static int saveTempDept(List<Dept> deptList) {
		DeptService deptService = new DeptService();
		
		int deleteCount = deptService.deleteTemp(deptList.get(0).getCompanyName());
		System.out.println(deleteCount + "건이 temp_dept에서 삭제되었습니다.");
		
		int insertCount = deptService.insertTemp(deptList);
		
		return insertCount;
	}
	
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
	
}
