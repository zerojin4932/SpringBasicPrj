package com.prjstudy.demo.order;

import com.prjstudy.demo.member.Member;
import com.prjstudy.demo.member.MemberRepository;
import com.prjstudy.demo.member.discount.DiscountPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //회원 정보를 불러오고
        int discountPrice = discountPolicy.discount(member,itemPrice); // 할인 정책을 만든뒤

        return new Order(memberId,itemName,itemPrice,discountPrice); // 객체로 반환한다.
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
