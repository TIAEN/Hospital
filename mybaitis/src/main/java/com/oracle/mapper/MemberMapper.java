package com.oracle.mapper;

import com.oracle.pojo.Member;
import com.oracle.pojo.ParamObj;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.ognl.MemberAccess;

import java.util.List;

public interface MemberMapper {
    public Member SelectMemberById(Integer id);

    List<Member> SelectMemberAll();

    List<Member> SelectMemberParam(@Param("userName") String userName,@Param("age") Integer age);

    List<Member> SelectMemberParamObj(ParamObj parmObj);

    List<Member> SelectMemberByAge(@Param("minage") Integer minage,@Param("maxage") Integer maxage);

    List<Member> SelectMemberLike(String name);

    int insertMember(Member member);
}
