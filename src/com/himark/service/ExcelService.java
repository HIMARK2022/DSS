package com.himark.service;

import org.apache.ibatis.session.SqlSession;

import com.himark.dao.ExcelDAO;
import com.himark.dss.MySqlSessionFactory;

public class ExcelService {
	
	private ExcelDAO excelDao = ExcelDAO.getInstance();
	
	public void createTable(String createTable) {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		
		try {
			excelDao.createTable(session, createTable); // posDao에 SqlSession 전송
			session.commit();
			
		} finally {
			session.close(); // 세션 닫기
		}
	}
	
	public void dropTable(String dropTable) {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		
		try {
			excelDao.dropTable(session, dropTable); // posDao에 SqlSession 전송
			session.commit();
			
		} finally {
			session.close(); // 세션 닫기
		}
	}
	
	public void insertTable(String insertTable) {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		
		try {
			excelDao.insertTable(session, insertTable); // posDao에 SqlSession 전송
			session.commit();
			
		} finally {
			session.close(); // 세션 닫기
		}
	}
	
}
