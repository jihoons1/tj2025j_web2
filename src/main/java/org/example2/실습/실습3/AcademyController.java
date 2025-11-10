package org.example2.실습.실습3;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/academy")
@CrossOrigin(origins = "*")
public class AcademyController {

    private final AcademyService academyService;

    @PostMapping("/course")
    public ResponseEntity<?> createCourse(@RequestBody CourseEntity course) {
        return ResponseEntity.ok(academyService.saveCourse(course));
    }

    @GetMapping("/course")
    public ResponseEntity<List<CourseEntity>> getCourses() {
        return ResponseEntity.ok(academyService.getAllCourses());
    }
}
