package org.example2.실습.실습3;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "student")

public class StudentEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )// 자동 증가
    private int studentId; // 학생번호

    private String studentName; // 학생명

    @OneToMany( mappedBy = "studentEntity" , cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private List<EnrollEntity>
            enrollList = new ArrayList<>();
}
