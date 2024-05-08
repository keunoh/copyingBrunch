package com.brunch.kaltz.picture.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PictureController {

    @GetMapping("/picture")
    public String getPicturePage() {
        return "/picture/Picture";
    }
}
