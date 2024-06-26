package com.brunch.kaltz.board.service;


import com.brunch.kaltz.board.domain.Board;
import com.brunch.kaltz.board.domain.BoardDto;
import com.brunch.kaltz.board.domain.Developer;
import com.brunch.kaltz.board.repo.JpaBoardRepository;
import com.brunch.kaltz.board.repo.JpaDeveloperRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final JpaBoardRepository jpaBoardRepository;
    private final JpaDeveloperRepository jpaDeveloperRepository;

    public BoardService(JpaBoardRepository jpaBoardRepository
                      , JpaDeveloperRepository jpaDeveloperRepository) {
        this.jpaBoardRepository = jpaBoardRepository;
        this.jpaDeveloperRepository = jpaDeveloperRepository;
    }

    public void saveBoard(BoardDto dto) {
        // 1. 해당 개발자를 조회
        Developer developer = jpaDeveloperRepository.findById(dto.getDeveloperId()).get();

        // 2. 해당 개발자를 가진 게시판 객체 생성
        Board board = new Board(developer);
        board.setInterest(dto.getInterest());

        // 3. 생성된 board를 저장
        jpaBoardRepository.save(board);
    }

    // 전체 조회
    public List<Board> findAll() {
        return jpaBoardRepository.findAll();
    }

    // 삭제
    public void delete(Long boardId) {
        jpaBoardRepository.delete(boardId);
    }

    // 수정
    public void update(BoardDto dto) {
        jpaBoardRepository.update(dto);
    }
}
