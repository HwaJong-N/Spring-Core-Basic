package com.ghkwhd.core.discount;

import com.ghkwhd.core.member.Member;

public interface DiscountPolicy {

    // 할인 대상에 따른 할인 가격 반환
    int discount(Member member, int price);
}
