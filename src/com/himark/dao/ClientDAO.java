package com.himark.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class ClientDAO {
	
	private static ClientDAO clientDao = new ClientDAO();
	
	public static ClientDAO getInstance() {
		return clientDao;
	}
	
	public int createTable(SqlSession session, Map<String, String> tables) {
		int insertCount = 0;
		insertCount = session.update("client.createTable", tables);
		
		return insertCount;
	}
	
}
