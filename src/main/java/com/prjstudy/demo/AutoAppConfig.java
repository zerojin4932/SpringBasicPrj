package com.prjstudy.demo;

import com.prjstudy.demo.member.MemberRepository;
import com.prjstudy.demo.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class),
        basePackages = "com.prjstudy.demo.member"
)
public class AutoAppConfig {
    //기존의 예제코드를 최대한 유지

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
