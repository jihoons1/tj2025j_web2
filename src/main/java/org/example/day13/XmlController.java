package org.example.day13;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/xml")
@RequiredArgsConstructor
public class XmlController {
    // #
    private final XmlMapper xmlMapper;

    // # 1. 등록 , { "name" : "유재석" , "kor" : "98" , "math" : "70" }
    @PostMapping("") // http://localhost:8080/xml
    public ResponseEntity< ? > save(@RequestBody StudentDto dto){
        // < ? > : 제네릭타입에 ? 넣으면 모든 타입을 지칭한다. 와일드카드
        System.out.println("dto = " + dto ); // soutp , save 하기전
        xmlMapper.save( dto );
        System.out.println("dto = " + dto); // 후
        return ResponseEntity.ok( dto ); // 제네릭 ? 이므로 모든 자료가 대입된다.
    }

    // # 2. 전체조회
    @GetMapping("")
    public  ResponseEntity< ? > findAll() {
        List< StudentDto > result = xmlMapper.findAll();
        return ResponseEntity.ok(result);
    }

    // # 3. 개별 조회
    @GetMapping("/a")
    public ResponseEntity< ? > find(@RequestParam int sno){
        StudentDto result = xmlMapper.find(sno);
        return ResponseEntity.ok(result);
    }

    // # 4. 개별 삭제
    @DeleteMapping("")
    public ResponseEntity< ? > delete(@RequestParam int sno){
        int re = xmlMapper.delete(sno);
        return ResponseEntity.ok(re);
    }

    // # 5. 개별 수정
    @PutMapping("")
    public ResponseEntity< ? > update(@RequestBody StudentDto studentDto){
        int re = xmlMapper.update(studentDto);
        return ResponseEntity.ok(re);
    }

    // # 6-1
    @GetMapping("/b")
    public ResponseEntity< ? > query1(@RequestParam int kor){
        StudentDto dto = xmlMapper.query1(kor);
        return ResponseEntity.ok(dto);
    }

    // # 6-2 XML
    @GetMapping("/c")
    public ResponseEntity< ? > query2(@RequestParam int kor){
        StudentDto dto = xmlMapper.query2(kor);
        return ResponseEntity.ok(dto);
    }

    // # 7 이름 or 수학점수 검색
    @GetMapping("/d")
    public ResponseEntity< ? > query3(@RequestParam String name , int math){
        StudentDto dto = xmlMapper.query3(name,math);
        return ResponseEntity.ok(dto);
    }

    // # 8 여러개 학생 등록
    @PostMapping("/e")
    public ResponseEntity< ? > saveAll(@RequestBody List<StudentDto> dtos){
        int re = xmlMapper.saveAll(dtos);
        return ResponseEntity.ok(re);
    }

} // class end
