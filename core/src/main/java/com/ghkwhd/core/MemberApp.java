package com.ghkwhd.core;

import com.ghkwhd.core.member.Grade;
import com.ghkwhd.core.member.Member;
import com.ghkwhd.core.member.MemberService;
import com.ghkwhd.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        
        // 자바 코드로 회원가입, 회원 조회 테스트

        MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}
