package com.brunch.kaltz.redis.service;

import com.brunch.kaltz.redis.domain.Member;

public interface RedisTestService {
    void joinMember(Member member);

    Member updateMember(Member member, Long memberId);

    Member getMemberInfo(Long memberId);

    void removeMember(Long memberId);
}
