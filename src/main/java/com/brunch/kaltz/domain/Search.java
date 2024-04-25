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

    // 기본 생성자가 없으면 JPA 조회 시 오류 발생
    public Search() {
    }

    public Search(String q) {
        this.q = q;
    }
}
