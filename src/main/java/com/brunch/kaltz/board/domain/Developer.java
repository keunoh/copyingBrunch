package com.brunch.kaltz.board.domain;

import jakarta.persistence.*;

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
}
