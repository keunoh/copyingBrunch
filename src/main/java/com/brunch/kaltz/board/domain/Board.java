package com.brunch.kaltz.board.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "DEVELOPER_ID")
    Developer developer;    // 개발자 객체 참조, M : 1

}
