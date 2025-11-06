package org.example2.실습.실습3;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "student")

public class StudentEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )// 자동 증가
    private int studentId; // 학생번호

    private String studentName; // 학생명

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn( name = "enrollId")
    private EnrollEntity enrollEntity;
}
