package com.himark.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.data.Dept;

public class DeptDAO {
	
	private static DeptDAO deptDao = new DeptDAO();

	public static DeptDAO getInstance() {
		return deptDao;
	}
	
	// temp 테이블에 insert
	public int insertTempId(SqlSession session, String table) {
		int insertCount = 0; 
		insertCount = session.insert("dept.insertTempId", table);
		
		return insertCount;
	}
	
	public int insertTempName(SqlSession session, String table) {
		int insertCount = 0; 
		insertCount = session.insert("dept.insertTempName", table);
		
		return insertCount;
	}
	
	public int insertTempUpperId(SqlSession session, String table) {
		int insertCount = 0; 
		insertCount = session.insert("dept.insertTempUpperId", table);
		
		return insertCount;
	}
	
	// temp 테이블 비우기
	public int deleteTemp(SqlSession session) {
		int deleteCount = 0; 
		deleteCount = session.delete("dept.deleteTemp");
		
		return deleteCount;
	}

	public List<Dept> insertDept(SqlSession session) { 
		List<Dept> list = session.selectList("insertDept"); 
		
		return list;

	}
	
}
