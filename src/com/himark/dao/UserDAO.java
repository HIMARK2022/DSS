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
}
