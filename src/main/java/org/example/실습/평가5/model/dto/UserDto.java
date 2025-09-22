package org.example.실습.평가5.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class UserDto {
    private int sno; // 익명-- 게시글 번호
    private int mno; // 영화 번호
    private String spwd; // 익명/게시글 비번
    private String tabletext; // 게시물1 내용
    private String smovie; // 게시물2 내용
    private String mname; // 영화 감독
    private String mgenre; // 영화 장르
    private String mcontent; // 영화 소개



}
