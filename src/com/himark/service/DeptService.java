package com.himark.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.dao.DeptDAO;
import com.himark.data.Dept;
import com.himark.dss.MySqlSessionFactory;

public class DeptService {
	
	private DeptDAO deptDao = DeptDAO.getInstance();

//	public List<Dept> select() {
//		SqlSession session = MySqlSessionFactory.getSqlSession();
//		List<Dept> deptList = null; // 반환할 값
//		
//		try {
//			deptList = deptDao.selectAll(session); // deptDao에 SqlSession 전송
//		
//		} finally {
//			session.close(); // 세션 닫기
//		}
//		
//		return deptList;
//	}
	
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
	
}
