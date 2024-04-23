package com.brunch.kaltz.domain;

import lombok.Getter;

@Getter
public class Search {
    String q;

    public Search(String q) {
        this.q = q;
    }
}
