package com.prjstudy.demo.member.discount;

import com.prjstudy.demo.member.Member;

public interface DiscountPolicy {
    /*
    * @return 할인 대상 금액
    * */
    int discount(Member member, int price);
}
