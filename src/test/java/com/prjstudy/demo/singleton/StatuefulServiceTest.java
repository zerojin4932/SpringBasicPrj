package com.prjstudy.demo.singleton;

import com.prjstudy.demo.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

public class StatuefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatuefulService statuefulService1 = ac.getBean(StatuefulService.class);
        StatuefulService statuefulService2 = ac.getBean(StatuefulService.class);

        //ThreadA:A사용자 만원을 주문했을 경우
        int userAPrice = statuefulService1.order("userA", 10000);
        //ThreadB:B사용자 이만원을 주문했을 경우
        int userBPrice = statuefulService2.order("userB", 20000);

        assertThat(statuefulService1).isEqualTo(statuefulService2);

        //ThreadA : 사용자A 주문 금액 조회
//        int price = statuefulService1.getPrice();
        System.out.println("price = " + userAPrice);
        System.out.println("userBPrice = " + userBPrice);

//        assertThat(statuefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StatuefulService statuefulService() {
            return new StatuefulService();
        }
    }
}
