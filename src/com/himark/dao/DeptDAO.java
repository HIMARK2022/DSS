package com.himark.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.data.Dept;

public class DeptDAO {
	
	private static DeptDAO deptDao = new DeptDAO();

	public static DeptDAO getInstance() {
		return deptDao;
	}
	
	public int insertTemp(SqlSession session, List<Dept> deptList) {
		int insertCount = 0; 
		insertCount = session.insert("dept.insertTemp", deptList);
		
		return insertCount;
	}
	

	public int deleteTemp(SqlSession session, String companyName) {
		int deleteCount = 0; 
		deleteCount = session.delete("dept.deleteTemp", companyName);
		
		return deleteCount;
	}

	public List<Dept> insertDept(SqlSession session) { 
		List<Dept> list = session.selectList("insertDept"); 
		
		return list;

	}
	
}
