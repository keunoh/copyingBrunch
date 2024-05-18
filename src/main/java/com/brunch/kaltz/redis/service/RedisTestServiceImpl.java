package com.brunch.kaltz.redis.service;

import com.brunch.kaltz.redis.domain.Member;
import com.brunch.kaltz.redis.repo.RedisTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class RedisTestServiceImpl implements RedisTestService {

    // https://velog.io/@j3beom/SpringBoot-Redis-Redis%EB%A5%BC-%ED%99%9C%EC%9A%A9%ED%95%9C-Caching-%EA%B8%B0%EB%B3%B8-%EB%B0%8F-%ED%99%9C%EC%9A%A9-%EC%98%88%EC%A0%9C
    // 캐싱 안 됨 재확인 필요 - 완료
    // 레디스 캐시는 데이터 등록 시에는 DB에 등록 된다.
    // 그러나 조회 시에는 레디스 캐시에 등록되고 첫 번째는 SQL을 날리지만
    // 두 번째 조회될 시에는 캐시에 저장되어 있으므로 캐시에서 데이터를 가져온다.
    // 즉, 이때는 SQL을 날리지 않으므로 비용이 절감 된다.
    private final RedisTestRepository redisTestRepository;

    @Transactional
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

    @Cacheable(value = "Member", key = "#memberId", cacheManager = "cacheManager", unless = "#result == null")
    @Override
    public Member getMemberInfo(Long memberId) {
        return redisTestRepository.findOne(memberId);
    }

    @Transactional
    @CacheEvict(value = "Member", key = "#memberId", cacheManager = "cacheManager")
    @Override
    public void removeMember(Long memberId) {
        Member member = redisTestRepository.findOne(memberId);
        redisTestRepository.remove(member);
    }
}
