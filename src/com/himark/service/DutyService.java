package com.himark.service;

import org.apache.ibatis.session.SqlSession;

import com.himark.dao.DutyDAO;
import com.himark.dss.MySqlSessionFactory;
import com.himark.vo.JoinVO;

public class DutyService {

	private DutyDAO dutyDao = DutyDAO.getInstance();
	
	public int deleteTemp() {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int deleteCount = 0;
		
		try {
			deleteCount = dutyDao.deleteTemp(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return deleteCount;
	}
	
	public int insertTemp(JoinVO joinDuty) {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0;
		
		try {
			insertCount = dutyDao.insertTemp(session, joinDuty);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return insertCount;
	}
	
	public int insertDuty() {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0;
		
		try {
			insertCount = dutyDao.insertDuty(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return insertCount;
		
	}
	
	public int deleteDuty() {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int deleteCount = 0;
		
		try {
			deleteCount = dutyDao.deleteDuty(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return deleteCount;
	}
	
	public int updateDuty() {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int updateCount = 0;
		
		try {
			updateCount = dutyDao.updateDuty(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return updateCount;
	}
	
}
