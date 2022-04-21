package com.himark.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.himark.dao.UserDAO;
import com.himark.dss.MySqlSessionFactory;
import com.himark.vo.JoinVO;
import com.himark.vo.UserVO;

public class UserService {
	
	private UserDAO userDao = UserDAO.getInstance();
	
	public int deleteTemp() {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int deleteCount = 0;
		
		try {
			deleteCount = userDao.deleteTemp(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return deleteCount;
	}
	
	public int insertTemp(JoinVO joinUser) {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0;
		
		try {
			insertCount = userDao.insertTemp(session, joinUser);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return insertCount;
	}
	
	public int updateTempAc() {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int updateCount = 0;
		
		try {
			updateCount = userDao.updateTempAc(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return updateCount;
	}
	
	public int insertUser() {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int insertCount = 0;
		
		try {
			insertCount = userDao.insertUser(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return insertCount;
		
	}
	
	public List<UserVO> selectUser() {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		List<UserVO> list = null;
		
		try {
			list = userDao.selectUser(session);
			session.commit();
		} finally {
			session.close();
		}
		
		return list;
	}
	
	public int deleteUser() {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int deleteCount = 0;
		
		try {
			deleteCount = userDao.deleteUser(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return deleteCount;
	}
	
	public int updateUser() {
		
		SqlSession session = MySqlSessionFactory.getMarkanySqlSession();
		int updateCount = 0;
		
		try {
			updateCount = userDao.updateUser(session);
			session.commit();
			
		} finally {
			session.close();
		}
		
		return updateCount;
	}
	
}
