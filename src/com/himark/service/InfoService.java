package com.himark.service;

import org.apache.ibatis.session.SqlSession;

import com.himark.dao.InfoDAO;
import com.himark.dss.MySqlSessionFactory;
import com.himark.vo.InfoVO;

public class InfoService {
	
	private InfoDAO infoDao = InfoDAO.getInstance();
	
	public int delete() {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int deleteCount = 0;
		
		try {
			deleteCount = infoDao.delete(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return deleteCount;
	}
	
	public int insert(InfoVO info) {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0;
		
		try {
			insertCount = infoDao.insert(session, info);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return insertCount;
	}
	
}
