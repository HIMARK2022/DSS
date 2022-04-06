package com.himark.service;

import org.apache.ibatis.session.SqlSession;

import com.himark.dss.MySqlSessionFactory;
import com.himark.dao.ManagerDAO;

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

}
