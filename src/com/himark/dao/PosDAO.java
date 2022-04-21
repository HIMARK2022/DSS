package com.himark.dao;

import org.apache.ibatis.session.SqlSession;

import com.himark.vo.JoinVO;

public class PosDAO {
	
	private static PosDAO posDao = new PosDAO();

	public static PosDAO getInstance() {
		return posDao;
	}
	
	public int deleteTemp(SqlSession session) {
		
		int deleteCount = 0;
		deleteCount = session.delete("pos.deleteTemp");
		
		return deleteCount;
	}
	
	public int insertTemp(SqlSession session, JoinVO joinPos) {
		
		int insertCount = 0;
		insertCount = session.insert("pos.insertTemp", joinPos);
		
		return insertCount;	
	}
	
	public int insertPos(SqlSession session) {
		
		int insertCount = 0;
		insertCount = session.insert("pos.insertPos"); 
		
		return insertCount;
	}
	
	public int deletePos(SqlSession session) {
		
		int deleteCount = 0; 
		deleteCount = session.delete("pos.deletePos");
		
		return deleteCount;
	}
	
	public int updatePos(SqlSession session) {
		
		int updateCount = 0;
		updateCount = session.update("pos.updatePos");
		
		return updateCount;
	}
	
}
