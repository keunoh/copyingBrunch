package com.brunch.kaltz.redis.repo;

import com.brunch.kaltz.redis.domain.Member;

public interface RedisTestRepository {
    Member save(Member member);

    Member findOne(Long memberId);

    void remove(Member member);
}
