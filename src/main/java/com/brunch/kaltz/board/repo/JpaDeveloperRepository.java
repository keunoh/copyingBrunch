package com.brunch.kaltz.board.repo;

import com.brunch.kaltz.board.domain.Developer;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Transactional
@Repository
public class JpaDeveloperRepository implements  DeveloperRepository {

    private final EntityManager em;

    public JpaDeveloperRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<Developer> findById(Long id) {
        Developer developer = em.find(Developer.class, id);
        return Optional.ofNullable(developer);
    }
}
