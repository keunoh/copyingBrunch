package com.brunch.kaltz.board.web;

import com.brunch.kaltz.board.domain.BoardDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @GetMapping("/board")
    public String openBoard() {
        // Get Method : 리소스를 사용자에게 전달하라

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

        // TODO: Board 객체를 만들어서 Repo 저장한다.

        return "redirect:/board/Board";
    }
}
