package org.example2.실습.실습3;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "enroll")

public class EnrollEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY); //자동증가
    private int enrollId; // 수강번호

    private boolean status; // 수강 상태

    // 단방향
    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER);
    // All 부모가 삭제 / 수정/ 저장시 같이 변경
    @JoinColumn( name = "courseId")
    private CourseEntity courseEntity;

    // 양방향
    @OneToMany(mappedBy = "enrollEntity")
    @ToString.Exclude
    @Builder.Default
    private List<CourseEntity>
            courseEntityList = new ArrayList<>();
    private List<StudentEntity>
            studentEntityList = new ArrayList<>();
}
