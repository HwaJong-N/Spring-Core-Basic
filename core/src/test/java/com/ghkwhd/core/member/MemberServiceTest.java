package com.ghkwhd.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {

        // given : 어떤 환경이 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);
        
        // when : 이렇게 하면
        memberService.join(member);
        Member findMember = memberService.findMember(1L);


        // then : 어떤 결과가 나온다 (검증)
        Assertions.assertThat(member).isEqualTo(findMember);

    }

}