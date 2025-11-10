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
@Table( name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY) // 자동으로 값 증가
    private int courseId; // 과정 번호

    @Column( nullable = false , length = 50) // null 제한 , 글자수 최대 50글자
    private String courseName; // 과정명


    @OneToMany( mappedBy = "courseEntity" , cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private List<EnrollEntity>
            enrollList = new ArrayList<>();
}
