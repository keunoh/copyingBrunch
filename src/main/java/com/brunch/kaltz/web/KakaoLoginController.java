package com.brunch.kaltz.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KakaoLoginController {

    @GetMapping("/myRedirect")
    public String redirectKakao() {

        return "/redirect/redirect";
    }
}
