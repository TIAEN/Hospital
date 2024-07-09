package com.oracle.mapper;

import com.oracle.pojo.Member;

public interface MemberMapper {
    int selectMemberCountByUserName(String userName);
    void insertMember(Member member);
    Member selectMemberByUserName(String userName);
}
