package com.himark.service;

import org.apache.ibatis.session.SqlSession;

import com.himark.dao.PosDAO;
import com.himark.dss.MySqlSessionFactory;
import com.himark.vo.JoinVO;

public class PosService {

	private PosDAO posDao = PosDAO.getInstance();
	
	public int deleteTemp() {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int deleteCount = 0;
		
		try {
			deleteCount = posDao.deleteTemp(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return deleteCount;
	}
	
	public int insertTemp(JoinVO joinPos) {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0;
		
		try {
			insertCount = posDao.insertTemp(session, joinPos);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return insertCount;
	}
	
	public int insertPos() {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0;
		
		try {
			insertCount = posDao.insertPos(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return insertCount;
		
	}
	
	public int deletePos() {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int deleteCount = 0;
		
		try {
			deleteCount = posDao.deletePos(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return deleteCount;
	}
	
	public int updatePos() {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int updateCount = 0;
		
		try {
			updateCount = posDao.updatePos(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return updateCount;
	}
	
}
