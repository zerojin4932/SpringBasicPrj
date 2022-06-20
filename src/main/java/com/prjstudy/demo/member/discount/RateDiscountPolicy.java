package com.prjstudy.demo.member.discount;

import com.prjstudy.demo.member.Grade;
import com.prjstudy.demo.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPersent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPersent / 100;
        }else {
            return 0;
        }
    }
}
