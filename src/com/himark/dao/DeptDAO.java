package com.himark.dao;

import org.apache.ibatis.session.SqlSession;

import com.himark.vo.JoinVO;

public class DeptDAO {

	private static DeptDAO deptDao = new DeptDAO();

	public static DeptDAO getInstance() {
		return deptDao;
	}
	
	public int deleteTemp(SqlSession session) {
		
		int deleteCount = 0;
		deleteCount = session.delete("dept.deleteTemp");
		
		return deleteCount;
	}
	
	public int insertTemp(SqlSession session, JoinVO joinDept) {
		
		int insertCount = 0;
		insertCount = session.insert("dept.insertTemp", joinDept);
		
		return insertCount;	
	}
	
	public int insertDept(SqlSession session) {
		
		int insertCount = 0;
		insertCount = session.insert("dept.insertDept"); 
		
		return insertCount;
	}
	
	public int deleteDept(SqlSession session) {
		
		int deleteCount = 0; 
		deleteCount = session.delete("dept.deleteDept");
		
		return deleteCount;
	}
	
	public int updateDept(SqlSession session) {
		
		int updateCount = 0;
		updateCount = session.update("dept.updateDept");
		
		return updateCount;
	}
	
}
