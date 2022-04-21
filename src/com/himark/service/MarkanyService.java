package com.himark.service;

import org.apache.ibatis.session.SqlSession;

import com.himark.dao.MarkanyDAO;
import com.himark.dss.MySqlSessionFactory;
import com.himark.vo.CreateVO;
import com.himark.vo.InsertVO;

public class MarkanyService {
	
	private MarkanyDAO markanyDao = MarkanyDAO.getInstance();
	
	public void dropTable(String tempTable) {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		
		try {
			markanyDao.dropTable(session, tempTable); 
			session.commit();
			
		} finally {
			session.close();
		}
		
	}
	
	public void createTable(CreateVO createTable) {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		
		try {
			markanyDao.createTable(session, createTable); 
			session.commit();
			
		} finally {
			session.close();
		}
		
	}
	
	public int insertTable(String insertTable) {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0;
		
		try {
			insertCount = markanyDao.insertTable(session, insertTable); 
			session.commit();
			
		} finally {
			session.close();
		}
		
		return insertCount;
		
	}
	
	public int insertData(InsertVO insertData) {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0;
		
		try {
			insertCount = markanyDao.insertData(session, insertData);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return insertCount;
		
	}

}
