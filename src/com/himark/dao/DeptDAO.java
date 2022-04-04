package com.himark.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.data.Dept;

public class DeptDAO {
	
	private static DeptDAO deptDao = new DeptDAO();

	public static DeptDAO getInstance() {
		return deptDao;
	}
	
//	public List<Dept> selectAll(SqlSession session) { 
//		List<Dept> deptList = session.selectList("selectAll"); 
//		
//		return deptList;
//	}
	
	public int insertTemp(SqlSession session, List<Dept> deptList) {
		int insertCount = 0; 
		insertCount = session.insert("dept.insertTemp", deptList);
		
		return insertCount;
	}
	
}
