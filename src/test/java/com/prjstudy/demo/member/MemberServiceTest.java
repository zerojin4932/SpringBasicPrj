package com.prjstudy.demo.member;

import com.prjstudy.demo.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given : ~ 이런게 주워졌을때
        Member member = new Member(1L,"memberA",Grade.VIP);

        //when : 서비스를 불러오는 곳
        memberService.join(member);
        Member findMember = memberService.findMember(1L);


        //then : 테스트를 하는 곳
        Assertions.assertThat(member).isEqualTo(findMember); //assertThat 멤버의 서비스와 같은지 확인
    }
}
