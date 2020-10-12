package com.example.demo;

import com.example.demo.enums.BoardType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Board {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키가 자동으로 할당되도록 설정하는 어노테이션, 기본키 할당 전략을 선택할 수 있는데, 키 생성을 데이터베이스에 위임하는 IDENTITY 전략 사용
    private Long idx;

    @Column
    private String title;

    @Column
    private String subTitle;

    @Column
    private String content;

    @Column
    @Enumerated(EnumType.STRING)    // Enum 타입 매핑용 어노테이션, 자바 enum형과 데이터베이스 변환을 지원, 실제로 자바 enum형이지만 데이터베이스의 String형으로 변환하여 저장하겠다고 선언한 것
    private BoardType boardType;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @OneToOne(fetch = FetchType.LAZY)   // Board와 Board가 필드값으로 갖고 있는 User 도메인을 1:1 관계로 설정하는 어노테이션, 실제로 DB에 저장될 때 User 객체가 저장되는 것이 아니라 User PK인 user_idx 값이 저장된다. fetch 는 eager와 laze  종류가 있는데
    private User user;

    @Builder
    public Board(String title, String subTitle, String content, BoardType boardType, LocalDateTime createdDate, LocalDateTime updatedDate, User user){
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.boardType = boardType;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.user = user;
    }


}
