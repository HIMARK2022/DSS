package com.himark.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.dao.DutyDAO;
import com.himark.data.Duty;
import com.himark.dss.MySqlSessionFactory;

public class DutyService {
	
	private DutyDAO dutyDao = DutyDAO.getInstance();

	public int insertTemp(List<Duty> dutyList) {
		SqlSession session = MySqlSessionFactory.getSqlSession();
		int insertCount = 0; // 반환할 값
		
		try {
			insertCount = dutyDao.insertTemp(session, dutyList); // dutyDao에 SqlSession 전송
			session.commit();
			
		} finally {
			session.close(); // 세션 닫기
		}
		
		return insertCount;
	}
}
