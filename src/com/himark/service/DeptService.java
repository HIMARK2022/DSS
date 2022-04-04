package com.himark.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.dao.DeptDAO;
import com.himark.data.Dept;
import com.himark.dss.MySqlSessionFactory;

public class DeptService {
	
	private DeptDAO deptDao = DeptDAO.getInstance();
	
	public int insertTemp(List<Dept> deptList) {
		SqlSession session = MySqlSessionFactory.getSqlSession();
		int insertCount = 0; // 반환할 값
		
		try {
			insertCount = deptDao.insertTemp(session, deptList); // deptDao에 SqlSession 전송
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
			deleteCount = deptDao.deleteTemp(session, companyName);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return deleteCount;
	}
	
	public List<Dept> insertDept() {
		SqlSession session = MySqlSessionFactory.getSqlSession();
		List<Dept> list = null; // 반환할 값
		
		try {
			list = deptDao.insertDept(session); // dao에 SqlSession 전송
		} finally {
			session.close(); // 세션 닫기
		}
		
		return list;
	}
	
}
