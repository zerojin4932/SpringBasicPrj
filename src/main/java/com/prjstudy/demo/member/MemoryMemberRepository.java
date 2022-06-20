package com.prjstudy.demo.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{

    //보통 동시성 이슈가 있을 수 있어서 ConcurrentHashMap을 많이 쓰임
    private static Map<Long,Member> store = new HashMap<>();

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }
}
