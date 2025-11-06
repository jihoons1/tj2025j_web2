package org.example2.day03._연관관계;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ereplay" )
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyEntity {

    @Id
    private int rno; // 댓글번호
    private String rcontent; // 댓글내용
    // 단방향 연결
    @ManyToOne( cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn( name = "bno" ) // fk 필드명
    private BoardEntity boardEntity;



}


// 카테고리 <--- 게시물 <--- 댓글