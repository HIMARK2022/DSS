package com.himark.service;

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
	
}
