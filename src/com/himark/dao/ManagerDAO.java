package com.himark.dao;

import org.apache.ibatis.session.SqlSession;


public class ManagerDAO {
	
	private static ManagerDAO managerDao = new ManagerDAO();

	public static ManagerDAO getInstance() {
		return managerDao;
	}
	
	public int insertManager(SqlSession session, String userId) {
		int insertCount = 0; 
		insertCount = session.insert("manager.insertManager", userId);
		
		return insertCount;
	}

}
