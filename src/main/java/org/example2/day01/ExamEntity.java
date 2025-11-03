package org.example2.day01;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamEntity { // 클래스

    // DTO 처럼 데이터베이스에서 사용될 테이블과 속성(열) 일치
    @Id // primary key
    private int col1;
    private String col2;
    private double col3;
} // class end
