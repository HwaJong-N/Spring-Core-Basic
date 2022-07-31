package com.ghkwhd.core.order;

import com.ghkwhd.core.annotation.MainDiscountPolicy;
import com.ghkwhd.core.discount.DiscountPolicy;
import com.ghkwhd.core.discount.FixDiscountPolicy;
import com.ghkwhd.core.discount.RateDiscountPolicy;
import com.ghkwhd.core.member.Member;
import com.ghkwhd.core.member.MemberRepository;
import com.ghkwhd.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor    // final이 붙은 필드를 모아서 생성자를 자동으로 만들어준다
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;


    public OrderServiceImpl(MemberRepository memberRepository,
                            @MainDiscountPolicy DiscountPolicy discountPolicy) {
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

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

