package com.himark.service;

import org.apache.ibatis.session.SqlSession;

import com.himark.dao.DutyDAO;
import com.himark.dss.MySqlSessionFactory;

public class DutyService {
	
	private DutyDAO dutyDao = DutyDAO.getInstance();

	public int insertTempId(String table) {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0; // 반환할 값
		
		try {
			insertCount = dutyDao.insertTempId(session, table); // dutyDao에 SqlSession 전송
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
			insertCount = dutyDao.insertTempName(session, table);
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
			deleteCount = dutyDao.deleteTemp(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return deleteCount;
	}
	
	public int insertDuty() {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0; // 반환할 값
		
		try {
			insertCount = dutyDao.insertDuty(session); // dao에 SqlSession 전송
			session.commit();
			
		} finally {
			session.close(); // 세션 닫기
		}
		
		return insertCount;
	}

	public int deleteDuty() {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int deleteCount = 0;
		
		try {
			deleteCount = dutyDao.deleteDuty(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return deleteCount;
	}
	
	public int updateDuty() {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int updateCount = 0;
		
		try {
			updateCount = dutyDao.updateDuty(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return updateCount;
	}
	
}
