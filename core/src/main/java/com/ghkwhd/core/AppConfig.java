package com.ghkwhd.core;

import com.ghkwhd.core.discount.DiscountPolicy;
import com.ghkwhd.core.discount.FixDiscountPolicy;
import com.ghkwhd.core.discount.RateDiscountPolicy;
import com.ghkwhd.core.member.MemberRepository;
import com.ghkwhd.core.member.MemberService;
import com.ghkwhd.core.member.MemberServiceImpl;
import com.ghkwhd.core.member.MemoryMemberRepository;
import com.ghkwhd.core.order.OrderService;
import com.ghkwhd.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
