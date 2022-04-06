package com.himark.dao;

import org.apache.ibatis.session.SqlSession;

public class PosDAO {
	
	private static PosDAO posDao = new PosDAO();

	public static PosDAO getInstance() {
		return posDao;
	}
	
	// temp 테이블에 insert
	public int insertTempId(SqlSession session, String table) {
		int insertCount = 0; 
		insertCount = session.insert("pos.insertTempId", table);
		
		return insertCount;
	}
	
	public int insertTempName(SqlSession session, String table) {
		int insertCount = 0; 
		insertCount = session.insert("pos.insertTempName", table);
		
		return insertCount;
	}
	
	// temp 테이블 비우기
	public int deleteTemp(SqlSession session) {
		int deleteCount = 0; 
		deleteCount = session.delete("pos.deleteTemp");
		
		return deleteCount;
	}

	public int insertPos(SqlSession session) {
		int insertCount = 0;
		insertCount = session.insert("pos.insertPos"); 
		
		return insertCount;
	}

	public int deleteUser(SqlSession session) {
		int deleteCount = 0; 
		deleteCount = session.delete("pos.deletePos");
		
		return deleteCount;
	}
	
}
