package com.himark.dao;

import org.apache.ibatis.session.SqlSession;

public class UserDAO {
	
	private static UserDAO userDao = new UserDAO();

	public static UserDAO getInstance() {
		return userDao;
	}
	
	// temp 테이블에 insert
	public int insertTempId(SqlSession session, String table) {
		int insertCount = 0; 
		insertCount = session.insert("user.insertTempId", table);
		
		return insertCount;
	}
	
	public int insertTempName(SqlSession session, String table) {
		int insertCount = 0; 
		insertCount = session.insert("user.insertTempName", table);
		
		return insertCount;
	}
	
	public int insertTempPosId(SqlSession session, String table) {
		int insertCount = 0; 
		insertCount = session.insert("user.insertTempPosId", table);
		
		return insertCount;
	}
	
	public int insertTempDutyId(SqlSession session, String table) {
		int insertCount = 0; 
		insertCount = session.insert("user.insertTempDutyId", table);
		
		return insertCount;
	}
	
	public int insertTempDeptId(SqlSession session, String table) {
		int insertCount = 0; 
		insertCount = session.insert("user.insertTempDeptId", table);
		
		return insertCount;
	}
	
	public int insertTempAc(SqlSession session, String table) {
		int insertCount = 0; 
		insertCount = session.insert("user.insertTempAc", table);
		
		return insertCount;
	}
	
	// temp 테이블 비우기
	public int deleteTemp(SqlSession session) {
		int deleteCount = 0; 
		deleteCount = session.delete("user.deleteTemp");
		
		return deleteCount;
	}

	public int insertUser(SqlSession session) {
		int insertCount = 0;
		insertCount = session.insert("user.insertUser"); 
		
		return insertCount;
	}

	public int selectUser(SqlSession session) {
		int insertCount = 0;
		insertCount = session.insert("selectUser");
		
		return insertCount;
	}
	
}
