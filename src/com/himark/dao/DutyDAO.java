package com.himark.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.data.Duty;

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
		insertCount = session.insert("duty.insertTempName", table);
		
		return insertCount;
	}
	
	// temp 테이블 비우기
	public int deleteTemp(SqlSession session) {
		int deleteCount = 0; 
		deleteCount = session.delete("duty.deleteTemp");
		
		return deleteCount;
	}

	public List<Duty> insertDuty(SqlSession session) { 
		List<Duty> list = session.selectList("insertDuty"); 
		
		return list;
	}
	
}
