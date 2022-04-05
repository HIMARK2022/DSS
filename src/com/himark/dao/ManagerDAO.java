package com.himark.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.data.Manager;

public class ManagerDAO {
	
	private static ManagerDAO managerDao = new ManagerDAO();

	public static ManagerDAO getInstance() {
		return managerDao;
	}
	
	public List<Manager> setApprover(SqlSession session, String userId) {
		String approval_target = userId;
		List<Manager> list = session.selectList("setApprover", approval_target);
		
		return list;
	}

}
