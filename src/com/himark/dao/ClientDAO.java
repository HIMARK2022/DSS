package com.himark.dao;

import java.util.List;
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
	
	public List<String> selectColumn(SqlSession session, String originTable) {
		
		List<String> columnList = session.selectList("client.selectColumn", originTable);
		
		return columnList;
	}
	
	public List<Map<String, Object>> selectData(SqlSession session, String originTable) {
		
		List<Map<String, Object>> dataList = session.selectList("client.selectData", originTable);
		
		return dataList;
	}
	
}