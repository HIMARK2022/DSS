package com.himark.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.data.Pos;

public class PosDAO {
	
	private static PosDAO posDao = new PosDAO();

	public static PosDAO getInstance() {
		return posDao;
	}
	
	public int insertTemp(SqlSession session, List<Pos> posList) {
		int insertCount = 0; 
		insertCount = session.insert("pos.insertTemp", posList);
		
		return insertCount;
	}
}
