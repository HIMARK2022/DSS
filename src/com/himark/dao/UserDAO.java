package com.himark.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.vo.JoinVO;
import com.himark.vo.UserVO;

public class UserDAO {
	
	private static UserDAO userDao = new UserDAO();

	public static UserDAO getInstance() {
		return userDao;
	}
	
	public int deleteTemp(SqlSession session) {
		
		int deleteCount = 0;
		deleteCount = session.delete("user.deleteTemp");
		
		return deleteCount;
	}
	
	public int insertTemp(SqlSession session, JoinVO joinUser) {
		
		int insertCount = 0;
		insertCount = session.insert("user.insertTemp", joinUser);
		
		return insertCount;	
	}
	
	public int updateTempAc(SqlSession session) {
		
		int updateCount = 0;
		updateCount = session.update("user.updateTempAc");
		
		return updateCount;
	}
	
	public int insertUser(SqlSession session) {
		
		int insertCount = 0;
		insertCount = session.insert("user.insertUser"); 
		
		return insertCount;
	}

	public List<UserVO> selectUser(SqlSession session) {
		
		List<UserVO> list = session.selectList("user.selectUser");
		
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
