package com.brunch.kaltz.board.repo;

import com.brunch.kaltz.board.domain.Board;

import java.util.List;

public interface BoardRepository {

    Board save(Board board);

    List<Board> findAll();

}
