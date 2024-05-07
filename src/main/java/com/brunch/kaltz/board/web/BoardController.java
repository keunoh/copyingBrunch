package com.brunch.kaltz.board.web;

import com.brunch.kaltz.board.domain.Board;
import com.brunch.kaltz.board.domain.BoardDto;
import com.brunch.kaltz.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board")
    public String openBoard(Model model) {
        // Get Method : 리소스를 사용자에게 전달하라

        // 게시판의 모든 데이터를 조회해 오기
        List<Board> resultList = boardService.findAll();

        model.addAttribute("resultList", resultList);

        return "/board/Board";
    }

    @GetMapping("/saveBoard")
    public String openSaveBoard(Model model) {

        BoardDto boardDto = new BoardDto();

        model.addAttribute("boardDto", boardDto);

        return "/board/SaveBoard";
    }

    @PostMapping("/saveBoard")
    public String saveBoard(@ModelAttribute("boardDto") BoardDto boardDto) {

        boardService.saveBoard(boardDto);

        return "redirect:/board";
    }
}
