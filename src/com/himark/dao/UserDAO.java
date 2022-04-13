package com.himark.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.data.User;

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
		insertCount = session.update("user.insertTempName", table);
		
		return insertCount;
	}
	
	public int insertTempPosId(SqlSession session, String table) {
		int insertCount = 0; 
		insertCount = session.update("user.insertTempPosId", table);
		
		return insertCount;
	}
	
	public int insertTempDutyId(SqlSession session, String table) {
		int insertCount = 0; 
		insertCount = session.update("user.insertTempDutyId", table);
		
		return insertCount;
	}
	
	public int insertTempDeptId(SqlSession session, String table) {
		int insertCount = 0; 
		insertCount = session.update("user.insertTempDeptId", table);
		
		return insertCount;
	}
	
	public int insertTempAc(SqlSession session, String table) {
		int insertCount = 0; 
		insertCount = session.update("user.insertTempAc", table);
		
		return insertCount;
	}
	
	public int updateTempAc(SqlSession session) {
		int updateCount = 0;
		updateCount = session.update("user.updateTempAc");
		
		return updateCount;
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

	public List<User> selectUser(SqlSession session) {
		List<User> list = session.selectList("user.selectUser");
		
		return list;
	}

	public int deleteUser(SqlSession session) {
		int deleteCount = 0; 
		deleteCount = session.delete("user.deleteUser");
		
		return deleteCount;
	}
	
	public int updateUser(SqlSession session) {
		int updateCount = 0;
		updateCount = session.update("user.updateUser");
		
		return updateCount;
	}
	
}
