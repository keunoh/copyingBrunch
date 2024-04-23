package com.brunch.kaltz.web;

import com.brunch.kaltz.domain.JpaSearchRepository;
import com.brunch.kaltz.domain.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
public class SearchController {

    private final JpaSearchRepository repository;

    public SearchController(JpaSearchRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/search")
    public String search() {
        return "/search/search";
    }

    @GetMapping("/newSearch")
    public String newSearch(@RequestParam(value = "q") String q, Model model) {
        System.out.println("q = " + q);

        Optional<Search> findSearch = repository.findById(Long.parseLong(q));
        Search search = findSearch.get();
        model.addAttribute(search);

        return "/search/newSearch";
    }
}
