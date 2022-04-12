package com.himark.dao;

import org.apache.ibatis.session.SqlSession;

import com.himark.data.Info;

public class InfoDAO {
	private static InfoDAO infoDao = new InfoDAO();

	public static InfoDAO getInstance() {
		return infoDao;
	}
	
	public int delete(SqlSession session) {
		int deleteCount = 0;
		deleteCount = session.delete("info.delete");
		
		return deleteCount;
	}
	
	public int insert(SqlSession session, Info info) {
		int insertCount = 0; 
		insertCount = session.insert("info.insert", info);
		
		return insertCount;
	}
}
