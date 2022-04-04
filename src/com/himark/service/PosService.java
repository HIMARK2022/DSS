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
}
