package com.himark.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.himark.dao.ClientDAO;
import com.himark.dss.MySqlSessionFactory;

public class ClientService {
	
	private ClientDAO clientDao = ClientDAO.getInstance();
	
	public int createTable(Map<String, String> tables) {
		
		SqlSession session = MySqlSessionFactory.getClientSqlSession();
		
		int insertCount = 0;
		
		try {
			insertCount = clientDao.createTable(session, tables); 
			session.commit();
			
		} finally {
			session.close();
		}
		
		return insertCount;
	}
	
	public List<String> selectColumn(String originTable) {
		
		SqlSession session = MySqlSessionFactory.getClientSqlSession();
		List<String> columnList = null;
		
		try {
			columnList = clientDao.selectColumn(session, originTable);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return columnList;
	}
	
	public List<Map<String, Object>> selectData(String originTable) {
		
		SqlSession session = MySqlSessionFactory.getClientSqlSession();
		List<Map<String, Object>> dataList = null;
		
		try {
			dataList = clientDao.selectData(session, originTable);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return dataList;
	}

}
