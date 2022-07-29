package com.ghkwhd.core.member;

import com.ghkwhd.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

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