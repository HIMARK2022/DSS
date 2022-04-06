package com.himark.service;

import org.apache.ibatis.session.SqlSession;

import com.himark.dao.UserDAO;
import com.himark.dss.MySqlSessionFactory;

public class UserService {
	
	private UserDAO userDao = UserDAO.getInstance();

	public int insertTempId(String table) {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0; // 반환할 값
		
		try {
			insertCount = userDao.insertTempId(session, table); // userDao에 SqlSession 전송
			session.commit();
			
		} finally {
			session.close(); // 세션 닫기
		}
		
		return insertCount;
	}
	
	public int insertTempName(String table) {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0; // 반환할 값
		
		try {
			insertCount = userDao.insertTempName(session, table);
			session.commit();
			
		} finally {
			session.close(); // 세션 닫기
		}
		
		return insertCount;
	}
	
	public int insertTempPosId(String table) {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0; // 반환할 값
		
		try {
			insertCount = userDao.insertTempPosId(session, table);
			session.commit();
			
		} finally {
			session.close(); // 세션 닫기
		}
		
		return insertCount;
	}
	
	public int insertTempDutyId(String table) {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0; // 반환할 값
		
		try {
			insertCount = userDao.insertTempDutyId(session, table);
			session.commit();
			
		} finally {
			session.close(); // 세션 닫기
		}
		
		return insertCount;
	}
	
	public int insertTempDeptId(String table) {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0; // 반환할 값
		
		try {
			insertCount = userDao.insertTempDeptId(session, table);
			session.commit();
			
		} finally {
			session.close(); // 세션 닫기
		}
		
		return insertCount;
	}
	
	public int insertTempAc(String table) {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0; // 반환할 값
		
		try {
			insertCount = userDao.insertTempAc(session, table);
			session.commit();
			
		} finally {
			session.close(); // 세션 닫기
		}
		
		return insertCount;
	}
	
	public int deleteTemp() {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int deleteCount = 0;
		
		try {
			deleteCount = userDao.deleteTemp(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return deleteCount;
	}
	
	public int insertUser() {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0;
		
		try {
			insertCount = userDao.insertUser(session); // dao에 SqlSession 전송
			session.commit();
			
		} finally {
			session.close(); // 세션 닫기
		}
		
		return insertCount;
		
	}
	/*
	public List<User> selectUser() {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		List<User> list = null; // 반환할 값
		
		try {
			list = userDao.selectUser(session); // dao에 SqlSession 전송
		} finally {
			session.close(); // 세션 닫기
		}
		
		return list;
	}
	*/
	
}
