package com.brunch.kaltz.board.repo;

import com.brunch.kaltz.board.domain.Board;
import com.brunch.kaltz.board.domain.BoardDto;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class JpaBoardRepository implements BoardRepository {

    // 엔티티 매니저는 데이터 변경 시 트랜잭션을 시작해야하는데
    // 나는 하지 않았다 근데 db 반영됨. 확인해봐야함
    // 커밋시점에 db에 sql을 보내는지 확인

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
    public Board findById(Long boardId) {
        return em.find(Board.class, boardId);
    }

    @Override
    public List<Board> findAll() {
        return em.createQuery("select b from Board as b", Board.class)
                .getResultList();
    }

    @Override
    public void delete(Long boardId) {
        Board board = em.find(Board.class, boardId);
        em.remove(board);
    }

    @Override
    public void update(BoardDto dto) {
        Board board = em.find(Board.class, dto.getDeveloperId());
        board.setInterest(dto.getInterest());
    }
}
