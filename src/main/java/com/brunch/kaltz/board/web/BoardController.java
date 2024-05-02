package com.brunch.kaltz.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/board")
    public String openBoard() {
        // Get Method : 리소스를 사용자에게 전달하라

        return "/board/Board";
    }
}
