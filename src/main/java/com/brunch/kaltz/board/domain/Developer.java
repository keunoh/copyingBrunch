package com.brunch.kaltz.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Long age;

    public Developer() {
    }

//    public static Developer whoAreYou(BoardDto boardDto) {
//        Developer developer = new Developer();
//        developer.setId(boardDto.getDeveloperId());
//        return developer;
//    }
}
