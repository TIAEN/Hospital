package com.oracle.service;

import com.oracle.pojo.Member;
import org.junit.Test;

public class MemberServiceTest {
    @Test
    public void testRegistryMember(){
        Member member=new Member();
        MemberService memberService=new MemberService();
        member.setUsername("admin");
        member.setPassword("123");
        Integer i=memberService.registry(member);
        System.out.println(i);
    }
}
