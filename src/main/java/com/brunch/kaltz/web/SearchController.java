package com.brunch.kaltz.web;

import com.brunch.kaltz.domain.Search;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @GetMapping("/search")
    public String search() {
        return "/search/search";
    }

    @GetMapping("/newSearch")
    public String newSearch(@RequestParam(value = "q") String q, Model model) {
        System.out.println("q = " + q);

        Search search = new Search(q);
        model.addAttribute(search);

        return "/search/newSearch";
    }
}
