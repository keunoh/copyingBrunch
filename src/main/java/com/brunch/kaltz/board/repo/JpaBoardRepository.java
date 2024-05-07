package com.brunch.kaltz.board.repo;

import com.brunch.kaltz.board.domain.Board;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class JpaBoardRepository implements BoardRepository {

    private final EntityManager em;

    public JpaBoardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Board save(Board board) {

        em.persist(board);
        return null;
    }

    @Override
    public List<Board> findAll() {
        return em.createQuery("select b from Board as b", Board.class)
                .getResultList();
    }
}
