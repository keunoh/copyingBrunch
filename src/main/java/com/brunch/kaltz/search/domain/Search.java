package com.brunch.kaltz.search.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Entity
public class Search {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String q;

    //MySQL에서 decimal(12, 6) 타입으로 만들기 위한 컬럼 속성
    @Column(precision = 12, scale = 6)
    private BigDecimal myprice;

    // 기본 생성자가 없으면 JPA 조회 시 오류 발생
    public Search() {
    }

    public Search(String q) {
        this.q = q;
    }

    public Search(String q, BigDecimal myprice) {
        this.q = q;
        this.myprice = myprice;
    }
}
