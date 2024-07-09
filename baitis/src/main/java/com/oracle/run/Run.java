package com.oracle.run;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Run
{
    public static void main(String[] args) {
        String resource = "mybatis.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = ssf.openSession();


        sqlSession.close();
    }
}
