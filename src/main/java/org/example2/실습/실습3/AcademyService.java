package org.example2.실습.실습3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AcademyService {

    private final CourseRepository courseRepository;

    public CourseEntity saveCourse(CourseEntity course) {
        return courseRepository.save(course);
    }

    public List<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }
}
