package com.himark.service;

import org.apache.ibatis.session.SqlSession;

import com.himark.dao.ManagerDAO;
import com.himark.dss.MySqlSessionFactory;

public class ManagerService {
	
	private ManagerDAO managerDao = ManagerDAO.getInstance();
	
	public int insertManager(String userId) {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0; // 반환할 값
		
		try {
			insertCount = managerDao.insertManager(session, userId); // dao에 SqlSession 전송
			session.commit();
		} finally {
			session.close(); // 세션 닫기
		}
		
		return insertCount;
	}

	public int deleteManager() {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int deleteCount = 0;
		
		try {
			deleteCount = managerDao.deleteManager(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return deleteCount;
	}
	
}
