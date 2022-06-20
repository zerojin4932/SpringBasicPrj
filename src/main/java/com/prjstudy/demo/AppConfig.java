package com.prjstudy.demo;


import com.prjstudy.demo.member.MemberRepository;
import com.prjstudy.demo.member.MemberService;
import com.prjstudy.demo.member.MemberServiceImpl;
import com.prjstudy.demo.member.MemoryMemberRepository;
import com.prjstudy.demo.member.discount.DiscountPolicy;
import com.prjstudy.demo.member.discount.RateDiscountPolicy;
import com.prjstudy.demo.order.OrderService;
import com.prjstudy.demo.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//애플리케이션의 실제 동작에 필요한 구현할 객체를 생성한다.
//객체의 생성과 연결은 AppConfig가 담당한다.


@Configuration //컨테이너
public class AppConfig {

    //@Bean memberService = new MemoryMemberRepository()
    //@Bean orderService = new MemoryMemberRepository()
    //생성자 주입
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    //생성자 주입
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
