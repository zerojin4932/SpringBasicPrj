package com.prjstudy.demo.order;

import com.prjstudy.demo.AppConfig;
import com.prjstudy.demo.member.Grade;
import com.prjstudy.demo.member.Member;
import com.prjstudy.demo.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTests {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beForeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {

        //when
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId,"itemA",10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
