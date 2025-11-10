package org.example2.실습.실습3;


import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "enroll")

public class EnrollEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동증가
    private int enrollId; // 수강번호

    private boolean status; // 수강 상태

    // 단방향 (Enroll → Course)
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "courseId")
    private CourseEntity courseEntity;

    // 단방향 (Enroll → Student)
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "studentId")
    private StudentEntity studentEntity;

}
