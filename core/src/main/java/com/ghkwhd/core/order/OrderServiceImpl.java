package com.ghkwhd.core.order;

import com.ghkwhd.core.discount.DiscountPolicy;
import com.ghkwhd.core.discount.FixDiscountPolicy;
import com.ghkwhd.core.discount.RateDiscountPolicy;
import com.ghkwhd.core.member.Member;
import com.ghkwhd.core.member.MemberRepository;
import com.ghkwhd.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 주문 결과 반환
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 회원 조회
        Member member  = memberRepository.findById(memberId);
        
        // 할인 정책에 따라 고객 별 할인 금액 반환
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
