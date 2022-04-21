package com.himark.service;

import org.apache.ibatis.session.SqlSession;

import com.himark.dao.DeptDAO;
import com.himark.dss.MySqlSessionFactory;
import com.himark.vo.JoinVO;

public class DeptService {

	private DeptDAO deptDao = DeptDAO.getInstance();
	
	public int deleteTemp() {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int deleteCount = 0;
		
		try {
			deleteCount = deptDao.deleteTemp(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return deleteCount;
	}
	
	public int insertTemp(JoinVO joinDept) {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0;
		
		try {
			insertCount = deptDao.insertTemp(session, joinDept);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return insertCount;
	}
	
	public int insertDept() {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0;
		
		try {
			insertCount = deptDao.insertDept(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return insertCount;
		
	}
	
	public int deleteDept() {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int deleteCount = 0;
		
		try {
			deleteCount = deptDao.deleteDept(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return deleteCount;
	}
	
	public int updateDept() {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int updateCount = 0;
		
		try {
			updateCount = deptDao.updateDept(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return updateCount;
	}
	
}
