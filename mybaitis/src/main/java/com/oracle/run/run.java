package com.oracle.run;

import com.oracle.mapper.MemberMapper;
import com.oracle.pojo.Member;
import com.oracle.pojo.ParamObj;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class run {
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
        MemberMapper mapper=sqlSession.getMapper(MemberMapper.class);
        //Member member= mapper.SelectMemberById(4);
        //System.out.println(member);
        //List<Member> memberList=mapper.SelectMemberParam("name1",87);
        //System.out.println(memberList);
//        ParamObj paramObj=new ParamObj();
//        paramObj.setAge(20);
//        paramObj.setPwd("jabctest");
//        paramObj.setUserName("test");
        List<Member>memberList=mapper.SelectMemberLike("tom");
        System.out.println(memberList);
        sqlSession.close();
    }
}
