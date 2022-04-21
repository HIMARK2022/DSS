package com.himark.dao;

import org.apache.ibatis.session.SqlSession;

public class MarkanyDAO {
	
	private static MarkanyDAO markanyDao = new MarkanyDAO();
	
	public static MarkanyDAO getInstance() {
		return markanyDao;
	}
	
	public void dropTable(SqlSession session, String tempTable) {
		
		session.update("markany.dropTable", tempTable);
		
	}
	
	public void createTable(SqlSession session, String tempTable) {
		
		session.update("markany.createTable", tempTable);
		
	}
	
	public int insertTable(SqlSession session, String insertTable) {
		
		int insertCount = 0;
		
		insertCount = session.insert("markany.insertTable", insertTable);
		
		return insertCount;
		
	}
	
}
