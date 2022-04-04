package com.himark.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.data.Duty;

public class DutyDAO {
	
	private static DutyDAO dutyDao = new DutyDAO();

	public static DutyDAO getInstance() {
		return dutyDao;
	}
	
	public int insertTemp(SqlSession session, List<Duty> dutyList) {
		int insertCount = 0; 
		insertCount = session.insert("duty.insertTemp", dutyList);
		
		return insertCount;
	}
}
