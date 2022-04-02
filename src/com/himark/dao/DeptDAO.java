package com.himark.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.data.Dept;
import com.himark.service.DeptService;

public class DeptDAO {
	
	private static DeptDAO deptDao = new DeptDAO();

	public static DeptDAO getInstance() {
		return deptDao;
	}
	
	public List<Dept> selectAll(SqlSession session) { 
		List<Dept> deptList = session.selectList("selectAll"); 
		
		return deptList;
	}
	
}
