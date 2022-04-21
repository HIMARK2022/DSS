package com.himark.dao;

import org.apache.ibatis.session.SqlSession;

import com.himark.vo.JoinVO;

public class DutyDAO {

	private static DutyDAO dutyDao = new DutyDAO();

	public static DutyDAO getInstance() {
		return dutyDao;
	}
	
	public int deleteTemp(SqlSession session) {
		
		int deleteCount = 0;
		deleteCount = session.delete("duty.deleteTemp");
		
		return deleteCount;
	}
	
	public int insertTemp(SqlSession session, JoinVO joinDuty) {
		
		int insertCount = 0;
		insertCount = session.insert("duty.insertTemp", joinDuty);
		
		return insertCount;	
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
