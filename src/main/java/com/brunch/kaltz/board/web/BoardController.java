package com.brunch.kaltz.board.web;

import com.brunch.kaltz.board.domain.Board;
import com.brunch.kaltz.board.domain.BoardDto;
import com.brunch.kaltz.board.service.BoardService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@Slf4j
@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board")
    public String openBoard(Model model, HttpServletResponse response) {
        // Get Method : 리소스를 사용자에게 전달하라

        // header 조작
        /**
         * 내가 설정해주는 헤더의 이름이 기존 헤더의 이름과 같다면
         * 내가 설정해준 값을 대체 된다.
         */
        response.addHeader("addBasic", "world"); // 응답 헤더에 Hello : world 를 추가
        response.addDateHeader("addDate", 20L);
        Cookie cookie = new Cookie("myCookie", "myCookieValue");
        response.addCookie(cookie);
        response.addIntHeader("addInt", 10);
        boolean isContainsHeader = response.containsHeader("Host");
        log.info("isContainsHeader = {}", isContainsHeader);
        String encodeRedirectURL = response.encodeRedirectURL("https://speakerdeck.com/weirdx/99con-junieo-gaebaljayi-iryeogseo-sseugi-idongug?slide=51");
        log.info("encodeRedirectURL = {}", encodeRedirectURL);
        String encodeURL = response.encodeURL("https://speakerdeck.com/weirdx/99con-junieo-gaebaljayi-iryeogseo-sseugi-idongug?slide=51");
        log.info("encodeURL = {}", encodeURL);

        /*
        try {
            // 리다이렉트 코드
            response.sendRedirect("https://speakerdeck.com/weirdx/99con-junieo-gaebaljayi-iryeogseo-sseugi-idongug?slide=51");
        } catch (IOException e) {
            String message = e.getMessage();
            log.error("message={}", message);
        }
        */
        response.setStatus(301);

        /**
         * Lazy Evaluation : "게으른 연산"으로, 불필요한 연산을 피하기 위해
         * 연산을 지연시키는 것
         * 즉 불필요한 연산을 피한다
          */
        Supplier<Map<String, String>> mapSupplier =
                () -> new HashMap<>();
        response.setTrailerFields(mapSupplier);

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

    @GetMapping("/deleteBoard")
    public String deleteBoard(@RequestParam("id") Long boardId) {
        boardService.delete(boardId);

        return "redirect:/board";
    }

    @GetMapping("/updateBoard")
    public String getUpdateBoard(@RequestParam("id") Long boardId, Model model) {


        BoardDto boardDto = new BoardDto();
        boardDto.setDeveloperId(boardId);
        model.addAttribute("boardDto", boardDto);

        return "board/UpdateBoard";
    }

    @PostMapping("/updateBoard")
    public String updateBoard(@ModelAttribute("boardDto") BoardDto boardDto) {

        boardService.update(boardDto);

        return "redirect:/board";
    }

}
