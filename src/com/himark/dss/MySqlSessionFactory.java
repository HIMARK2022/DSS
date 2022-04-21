package com.himark.dss;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFactory {
	
	static SqlSessionFactory m_ssf = null;
	static SqlSessionFactory c_ssf = null;
	
	static {
		String resource = "com/himark/dss/Configuration.xml";
		InputStream inputStream = null;

		try {
			inputStream = Resources.getResourceAsStream(resource);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		m_ssf = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	static {
		String resource = "com/himark/dss/Configuration.xml";
		InputStream inputStream = null;

		try {
			inputStream = Resources.getResourceAsStream(resource);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		c_ssf = new SqlSessionFactoryBuilder().build(inputStream, "client");
	}
	
	// SqlSessionFactory 반환
	public static SqlSessionFactory getClientSqlSessionFactory() {
		return c_ssf;
	}
	
	// SqlSession 반환
	public static SqlSession getMarkanySqlSession() {
		SqlSession session = m_ssf.openSession();
		
		return session;
	}
	
	public static SqlSession getClientSqlSession() {
		SqlSession session = c_ssf.openSession();
		
		return session;
	}
	
}
