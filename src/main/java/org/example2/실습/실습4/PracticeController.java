package org.example2.실습.실습4;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/practice")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PracticeController {

    private PracticeService practiceService;

    // 저장
    @PostMapping
    public ResponseEntity< ? > practicesave(@RequestBody PracticeDto practiceDto){
        return ResponseEntity.ok(practiceService.practicesave(practiceDto));

    }

    // 조회
    @GetMapping("/list")
    public ResponseEntity< ? > practiceget(){
        return ResponseEntity.ok(practiceService.practiceget());
    }

    @PutMapping
    public ResponseEntity< ? > practiceupdate(@RequestBody PracticeDto practiceDto){
        return ResponseEntity.ok(practiceService.practiceupdate(practiceDto));
    }

}
