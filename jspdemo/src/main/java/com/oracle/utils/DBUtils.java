package com.oracle.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class DBUtils {
	//不可实例化 (单利)
	private static DBUtils dbUtils;
	
	private DBUtils() {}
	
	//懒汉 
	public static DBUtils createDbUtils(){
		if(dbUtils==null){
			dbUtils=new DBUtils();
		}
		return dbUtils;
	}
	
	private static final String MYBATIS_FILE="mybatis.xml";
	
	static SqlSession sqlSession=null;
	
	private static Reader reader=null;
	
	private static SqlSessionFactory ssf=null;
	
	static{
		try {
			reader=Resources.getResourceAsReader(MYBATIS_FILE);
			ssf = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SqlSession getSQLSession(){
		sqlSession=ssf.openSession();
		return sqlSession;
	}
	
}
