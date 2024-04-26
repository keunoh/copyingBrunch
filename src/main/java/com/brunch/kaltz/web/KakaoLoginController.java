package com.brunch.kaltz.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class KakaoLoginController {

    @GetMapping("/myRedirect")
    public String redirectKakao() {
        //홈으로 리다이렉트
        return "redirect:/";
    }

    @GetMapping("/showPage")
    public ModelAndView openDataLink(){

        //logic to get or construct the URL
        // 이렇게 하면 새로운 URL로 이동할 수 있다.
        return new ModelAndView(new RedirectView("http://www.google.com"));
    }
}
