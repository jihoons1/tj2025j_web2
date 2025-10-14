package org.example.실습.실습4;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/xml")
@RequiredArgsConstructor
public class XmlController {
    private final XmlMapper xmlMapper;

    // 책 등록
    @PostMapping("")
    public ResponseEntity< ? > bookadd(@RequestBody BookDto bookDto){
        xmlMapper.bookadd(bookDto);
        return ResponseEntity.ok(bookDto);
    }

    // 대출 기록 검색
    // 대출한 사람 또는 대출한도서명 으로 조회
    //   - 조건이 없을 경우 전체 조회
    @GetMapping("/print")
    public ResponseEntity< ? > loanbook(@RequestParam String member , String title){
        BookDto bookDto = xmlMapper.loanbook(member,title);
        return ResponseEntity.ok(bookDto);
    }

    // 책 일괄 등록
    @PostMapping("add")
    public ResponseEntity< ? > addbo(@RequestBody List<BookDto> dtos){
        int re = xmlMapper.addbo(dtos);
        return ResponseEntity.ok(re);
    }


    //
}
