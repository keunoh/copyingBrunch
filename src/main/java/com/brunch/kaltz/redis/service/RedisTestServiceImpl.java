package com.brunch.kaltz.redis.service;

import com.brunch.kaltz.redis.domain.Member;
import com.brunch.kaltz.redis.repo.RedisTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
//@Transactional(readOnly = true)
@Service
public class RedisTestServiceImpl implements RedisTestService {

    // https://velog.io/@j3beom/SpringBoot-Redis-Redis%EB%A5%BC-%ED%99%9C%EC%9A%A9%ED%95%9C-Caching-%EA%B8%B0%EB%B3%B8-%EB%B0%8F-%ED%99%9C%EC%9A%A9-%EC%98%88%EC%A0%9C
    // 캐싱 안 됨 재확인 필요
    private final RedisTestRepository redisTestRepository;

    @Override
    public void joinMember(Member member) {
        redisTestRepository.save(member);
    }

    @Transactional
    @CachePut(value = "Member", key = "#memberId", cacheManager = "cacheManager")
    @Override
    public Member updateMember(Member member, Long memberId) {
        return redisTestRepository.save(member);
    }

    @CachePut(value = "Member", key = "#memberId", cacheManager = "cacheManager", unless = "#result == null")
    @Override
    public Member getMemberInfo(Long memberId) {
        return redisTestRepository.findOne(memberId);
    }

    @Transactional
    @CachePut(value = "Member", key = "#memberId", cacheManager = "cacheManager")
    @Override
    public void removeMember(Long memberId) {
        Member member = redisTestRepository.findOne(memberId);
        redisTestRepository.remove(member);
    }
}
