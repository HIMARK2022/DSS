package com.himark.dao;

import org.apache.ibatis.session.SqlSession;

public class DutyDAO {
	
	private static DutyDAO dutyDao = new DutyDAO();

	public static DutyDAO getInstance() {
		return dutyDao;
	}
	
	// temp 테이블에 insert
	public int insertTempId(SqlSession session, String table) {
		int insertCount = 0; 
		insertCount = session.insert("duty.insertTempId", table);
		
		return insertCount;
	}
	
	public int insertTempName(SqlSession session, String table) {
		int insertCount = 0; 
		insertCount = session.update("duty.insertTempName", table);
		
		return insertCount;
	}
	
	// temp 테이블 비우기
	public int deleteTemp(SqlSession session) {
		int deleteCount = 0; 
		deleteCount = session.delete("duty.deleteTemp");
		
		return deleteCount;
	}

	public int insertDuty(SqlSession session) {
		int insertCount = 0;
		insertCount = session.insert("duty.insertDuty"); 
		
		return insertCount;
	}

	public int deleteDuty(SqlSession session) {
		int deleteCount = 0; 
		deleteCount = session.delete("duty.deleteDuty");
		
		return deleteCount;
	}
	
	public int updateDuty(SqlSession session) {
		int updateCount = 0;
		updateCount = session.update("duty.updateDuty");
		
		return updateCount;
	}
	
}
