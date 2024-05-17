package com.brunch.kaltz.redis.repo;

import com.brunch.kaltz.redis.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional
@Repository
public class RedisTestRepositoryImpl implements RedisTestRepository {

    private final EntityManager em;

    @Override
    public Member save(Member member) {
        if (member.getId() == null) {
            em.persist(member);
        }
        else {
            Member findMember = em.find(Member.class, member.getId());
            findMember.setName(member.getName());
        }

        return member;
    }

    @Override
    public Member findOne(Long memberId) {
        return em.find(Member.class, memberId);
    }

    @Override
    public void remove(Member member) {
        em.remove(member);
    }
}
