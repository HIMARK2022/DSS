package com.himark.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.dao.DeptDAO;
import com.himark.data.Dept;
import com.himark.dss.MySqlSessionFactory;

public class DeptService {
	
	private DeptDAO deptDao = DeptDAO.getInstance();
	
	public int insertTempId(String table) {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0; // 반환할 값
		
		try {
			insertCount = deptDao.insertTempId(session, table); // deptDao에 SqlSession 전송
			session.commit();
			
		} finally {
			session.close(); // 세션 닫기
		}
		
		return insertCount;
	}
	
	public int insertTempName(String table) {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0; // 반환할 값
		
		try {
			insertCount = deptDao.insertTempName(session, table);
			session.commit();
			
		} finally {
			session.close(); // 세션 닫기
		}
		
		return insertCount;
	}
	
	public int insertTempUpperId(String table) {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0; // 반환할 값
		
		try {
			insertCount = deptDao.insertTempUpperId(session, table);
			session.commit();
			
		} finally {
			session.close(); // 세션 닫기
		}
		
		return insertCount;
	}
	
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
	
	public List<Dept> insertDept() {
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		List<Dept> list = null; // 반환할 값
		
		try {
			list = deptDao.insertDept(session); // dao에 SqlSession 전송
		} finally {
			session.close(); // 세션 닫기
		}
		
		return list;
	}
	
}
