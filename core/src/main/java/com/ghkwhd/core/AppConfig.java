package com.ghkwhd.core;

import com.ghkwhd.core.discount.FixDiscountPolicy;
import com.ghkwhd.core.member.MemberService;
import com.ghkwhd.core.member.MemberServiceImpl;
import com.ghkwhd.core.member.MemoryMemberRepository;
import com.ghkwhd.core.order.OrderService;
import com.ghkwhd.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
