package com.himark.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.dao.UserDAO;
import com.himark.data.User;
import com.himark.dss.MySqlSessionFactory;

public class UserService {
	
	private UserDAO userDao = UserDAO.getInstance();

	public int insertTemp(List<User> userList) {
		SqlSession session = MySqlSessionFactory.getSqlSession();
		int insertCount = 0; // 반환할 값
		
		try {
			insertCount = userDao.insertTemp(session, userList); // userDao에 SqlSession 전송
			session.commit();
			
		} finally {
			session.close(); // 세션 닫기
		}
		
		return insertCount;
	}
	
	public int deleteTemp(String companyName) {
		SqlSession session = MySqlSessionFactory.getSqlSession();
		int deleteCount = 0;
		
		try {
			deleteCount = userDao.deleteTemp(session, companyName);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return deleteCount;
	}
	
}
