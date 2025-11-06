package org.example2.day03._연관관계;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity @Data @Builder
@Table( name = "ecategory")
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // PK
    private int cno;
    private String cname;
    // * 양방향 연결 ** //
    // 상위; 엔티티가 하위 엔티티 참조 관계
    @OneToMany( mappedBy = "categoryEntity") // 1:M , 하나 PK 가 다수 FK 에게
    // JAP 양방향 사용하고 DB에서는 양방향 하지 않는다.
    @ToString.Exclude // 순환참조 방지
    @Builder.Default // 빌더패턴 사용시 초기값 사용
    private List<BoardEntity>
            boardEntityList = new ArrayList<>();

}
