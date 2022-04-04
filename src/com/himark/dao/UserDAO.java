package com.himark.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.data.User;

public class UserDAO {
	
	private static UserDAO userDao = new UserDAO();

	public static UserDAO getInstance() {
		return userDao;
	}
	
	public int insertTemp(SqlSession session, List<User> userList) {
		int insertCount = 0; 
		insertCount = session.insert("user.insertTemp", userList);
		
		return insertCount;
	}
	
	public int deleteTemp(SqlSession session, String companyName) {
		int deleteCount = 0; 
		deleteCount = session.delete("user.deleteTemp", companyName);
		
		return deleteCount;
	}

	public List<User> insertUser(SqlSession session) {
		List<User> list = session.selectList("insertUser"); 
		
		return list;
	}

	public List<User> selectUser(SqlSession session) {
		List<User> list = session.selectList("selectUser");
		
		return list;
	}
	
}
