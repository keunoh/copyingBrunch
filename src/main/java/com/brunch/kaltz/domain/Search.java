package com.brunch.kaltz.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Search {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String q;

    public Search(String q) {
        this.q = q;
    }
}
