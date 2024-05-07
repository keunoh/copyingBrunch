package com.brunch.kaltz.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "DEVELOPER_ID")
    Developer developer;    // 개발자 객체 참조, M : 1

    @Column
    private String interest;

    public Board() {
    }

    public Board(Developer developer) {
        this.developer = developer;
    }

//    public Board makeNewPost(BoardDto boardDto) {
//        Board board = new Board();
//        board.setInterest(boardDto.getInterest());
//        // board.getDeveloper().getId() = boardDto.getDeveloperId();
//        Developer developer = Developer.whoAreYou(boardDto);
//        board.setDeveloper(developer);
//        return board;
//    }

}
