package com.himark.service;

import org.apache.ibatis.session.SqlSession;

import com.himark.dao.InfoDAO;
import com.himark.data.Info;
import com.himark.dss.MySqlSessionFactory;

public class InfoService {
	private InfoDAO infoDao = InfoDAO.getInstance();
	
	public int delete() {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int deleteCount = 0;
		
		try {
			deleteCount = infoDao.delete(session);
			session.commit();
			
		} finally {
			session.close(); // 세션 닫기
		}
		
		return deleteCount;
	}
	
	public int insert(Info info) {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0;
		
		try {
			insertCount = infoDao.insert(session, info);
			session.commit();
			
		} finally {
			session.close(); // 세션 닫기
		}
		
		return insertCount;
	}
}
