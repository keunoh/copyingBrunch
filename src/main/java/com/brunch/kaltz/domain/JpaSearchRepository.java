package com.brunch.kaltz.domain;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@Repository
public class JpaSearchRepository implements SearchRepository {

    private final EntityManager em;

    public JpaSearchRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Search save(Search search) {
        em.persist(search);
        return search;
    }

    @Override
    public Optional<Search> findById(Long id) {
        Search search = em.find(Search.class, id);
        return Optional.ofNullable(search);
    }
}
