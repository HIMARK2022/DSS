package com.himark.dao;

import org.apache.ibatis.session.SqlSession;

import com.himark.vo.CreateVO;
import com.himark.vo.InsertVO;

public class MarkanyDAO {
	
	private static MarkanyDAO markanyDao = new MarkanyDAO();
	
	public static MarkanyDAO getInstance() {
		return markanyDao;
	}
	
	public void dropTable(SqlSession session, String tempTable) {
		
		session.update("markany.dropTable", tempTable);
		
	}
	
	public void createTable(SqlSession session, CreateVO createTable) {
		
		/* session.update("markany.createTable", tempTable); */
		session.update("markany.createTable", createTable);
		
	}
	
	public int insertTable(SqlSession session, String insertTable) {
		
		int insertCount = 0;
		
		insertCount = session.insert("markany.insertTable", insertTable);
		
		return insertCount;
		
	}
	
	public int insertData(SqlSession session, InsertVO insertData) {
		
		int insertCount = 0;
		insertCount = session.insert("markany.insertData", insertData);
		
		return insertCount;
	}
	
}
