package com.himark.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class ExcelDAO {
	
	private static ExcelDAO excelDao = new ExcelDAO();

	public static ExcelDAO getInstance() {
		return excelDao;
	}
	
	public void createTable(SqlSession session, String createTable) {
		session.update("excel.createTable", createTable);
	}
	
	public void dropTable(SqlSession session, String dropTable) {
		session.update("excel.dropTable", dropTable);
	}
	
	public void insertTable(SqlSession session, String insertTable) {
		session.insert("excel.insertTable", insertTable);
	}
	
}
