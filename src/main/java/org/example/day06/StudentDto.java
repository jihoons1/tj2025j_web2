package org.example.day06;

import lombok.*;

@Setter @Getter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
public class StudentDto {
    private int sno;    // 학생 번호
    private String name; // 학생 이름
    private int kor;    // 국어 점수
    private int math; // 수학 점수
}