package org.example.실습.실습3.controller;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Select;
import org.example.실습.실습3.model.dto.SpringwebDto;
import org.example.실습.실습3.service.SpringwebService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/springweb")
@RequiredArgsConstructor
@CrossOrigin( value = "http://localhost:5173") // 이서버 허용
public class SpringwebController {
    private final SpringwebService springwebService;

    // 등록
    @PostMapping("")
    public ResponseEntity<Boolean> springadd(@RequestBody SpringwebDto dto){
        boolean result = springwebService.springadd(dto);
        return ResponseEntity.status(200).body(result);
    }

    // 조회
    @GetMapping("")
    public ResponseEntity<List<SpringwebDto> > springprint(){
        List<SpringwebDto> list = springwebService.springprint();
        return ResponseEntity.status(200).body(list);
    }

    // 삭제
    @DeleteMapping("")
    public ResponseEntity<Boolean> springdel(int sno){
        boolean result = springwebService.springdel(sno);
        return ResponseEntity.ok().body(result);
    }

    // 개인
    @GetMapping("/aa")
    public ResponseEntity<SpringwebDto> springprint2(@RequestParam int sno){
        SpringwebDto dto = springwebService.springprint2(sno);
        return ResponseEntity.status(200).body(dto);
    }

    // update
    @PutMapping("/bb")
    public ResponseEntity<Boolean> springup(@RequestBody SpringwebDto dto){
        boolean result = springwebService.springup(dto);
        return ResponseEntity.ok().body(result);
    }
}
