package com.himark.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.dao.PosDAO;
import com.himark.data.Pos;
import com.himark.dss.MySqlSessionFactory;

public class PosService {
	
	private PosDAO posDao = PosDAO.getInstance();

	public int insertTemp(List<Pos> posList) {
		SqlSession session = MySqlSessionFactory.getSqlSession();
		int insertCount = 0; // 반환할 값
		
		try {
			insertCount = posDao.insertTemp(session, posList); // posDao에 SqlSession 전송
			session.commit();
			
		} finally {
			session.close(); // 세션 닫기
		}
		
		return insertCount;
	}
	
	public int deleteTemp(String companyName) {
		SqlSession session = MySqlSessionFactory.getSqlSession();
		int deleteCount = 0;
		
		try {
			deleteCount = posDao.deleteTemp(session, companyName);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return deleteCount;
	}
	public List<Pos> insertPos() {
		SqlSession session = MySqlSessionFactory.getSqlSession();
		List<Pos> list = null; // 반환할 값
		
		try {
			list = posDao.insertPos(session); // dao에 SqlSession 전송
		} finally {
			session.close(); // 세션 닫기
		}
		
		return list;
	}
	
}
