package com.himark.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.data.Pos;

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

	public List<Pos> insertPos(SqlSession session) {
		List<Pos> list = session.selectList("insertPos"); 
		
		return list;
	}
	
}
