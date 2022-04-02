package com.himark.dss;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFactory {
	
	static SqlSessionFactory sqlSessionFactory = null;
	
	static {
		String resource = "com/himark/dss/Configuration.xml";
		InputStream inputStream = null;

		try {
			inputStream = Resources.getResourceAsStream(resource);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	// SqlSession 반환
	public static SqlSession getSqlSession() {
		SqlSession session = sqlSessionFactory.openSession();
		
		return session;
	}
	
}
