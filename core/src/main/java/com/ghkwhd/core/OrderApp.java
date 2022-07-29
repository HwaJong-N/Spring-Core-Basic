package com.ghkwhd.core;

import com.ghkwhd.core.member.Grade;
import com.ghkwhd.core.member.Member;
import com.ghkwhd.core.member.MemberService;
import com.ghkwhd.core.member.MemberServiceImpl;
import com.ghkwhd.core.order.Order;
import com.ghkwhd.core.order.OrderService;
import com.ghkwhd.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
