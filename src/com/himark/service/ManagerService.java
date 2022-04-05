package com.himark.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.data.Manager;
import com.himark.dss.MySqlSessionFactory;
import com.himark.dao.ManagerDAO;

public class ManagerService {
	private ManagerDAO managerDao = ManagerDAO.getInstance();
	
	public List<Manager> setApprover(String userId) {
		SqlSession session = MySqlSessionFactory.getSqlSession();
		List<Manager> list = null; // 반환할 값
		
		try {
			list = managerDao.setApprover(session, userId); // dao에 SqlSession 전송
		} finally {
			session.close(); // 세션 닫기
		}
		
		return list;
	}

}
