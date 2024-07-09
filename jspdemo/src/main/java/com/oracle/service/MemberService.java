package com.oracle.service;

import com.oracle.mapper.MemberMapper;
import com.oracle.pojo.Member;
import com.oracle.utils.DBUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

public class MemberService {

    public boolean  login(Member member) {

        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        MemberMapper memberMapper=sqlSession.getMapper(MemberMapper.class);
        Member memberPo=memberMapper.selectMemberByUserName(member.getUsername());
        if(memberPo==null){
            return false;
        }
        String password=DigestUtils.md5Hex(member.getPassword());
        if(!memberPo.getPassword().equals(password)){
            return false;
        }
        member.setId(memberPo.getId());
        member.setPassword(null);
        return true;
    }


    public boolean existUserName(String userName)
    {
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        MemberMapper memberMapper=sqlSession.getMapper(MemberMapper.class);
        return memberMapper.selectMemberCountByUserName(userName) > 0;
    }


    public Integer registry(Member member){
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        MemberMapper memberMapper=sqlSession.getMapper(MemberMapper.class);
        int i=memberMapper.selectMemberCountByUserName(member.getUsername());
        if(i>0){
            return 1;
        }
        member.setPassword(DigestUtils.md5Hex(member.getPassword()));
        member.setCreateDate(new Date());
        member.setModifyDate(new Date());
        memberMapper.insertMember(member);
        sqlSession.commit();
        return 0;
    }
}
