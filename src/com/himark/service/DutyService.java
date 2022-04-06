package com.himark.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.dao.DutyDAO;
import com.himark.data.Duty;
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
	
	public List<Duty> insertDuty() {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		List<Duty> list = null; // 반환할 값
		
		try {
			list = dutyDao.insertDuty(session); // dao에 SqlSession 전송
		} finally {
			session.close(); // 세션 닫기
		}
		
		return list;
	}
	
}
