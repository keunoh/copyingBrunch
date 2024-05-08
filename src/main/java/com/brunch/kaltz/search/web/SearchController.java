package com.brunch.kaltz.search.web;

import com.brunch.kaltz.search.domain.JpaSearchRepository;
import com.brunch.kaltz.search.domain.Search;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Slf4j
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

    @GetMapping("/save")
    public String goToSavePage() {
        return "/search/save";
    }

    @PostMapping("/save")
    public String saveData(@RequestParam(value = "dataname") String dataname,
                           @RequestParam(value = "datanumber") String datanumber) {
        SearchDto searchDto = new SearchDto(dataname, datanumber);
        Search search = searchDto.makeSearchObj();

        repository.save(search);

        return "/search/afterSave";

    }

    @GetMapping("/newSearch")
    public String newSearch(@RequestParam(value = "q") String q, Model model) {

        Optional<Search> findSearch = repository.findById(Long.parseLong(q));

        Search search = findSearch.orElse(null);

        if (search == null) {
            // 검색 시 받아오는 객체가 없다면 검색 창으로 리다이렉트
            return "redirect:/search";
        } else {
            model.addAttribute(search);
            return "/search/newSearch";
        }
    }
}
