package org.example.day09;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
@Log4j2 // ====== 로그(기록) 처리하는 어노테이션 제공 ==========
public class BookController {
    private final BookService bookService;

    // 2. print 함수 대신에 로그함수 사용해보기 = 부가기능 제공,  제약조건 등
    @GetMapping("/log") public void log(){
        System.out.println("개발단계 에서는 print 정말 많이 작성하자...");
        // log.XXXX : 출력함수 처럼 출력하는 메세지 함수 이면서 부가기능(파일처리/제약조건)
        log.debug("테스트 과정 사용된다."); // 테스트(개발)과정 에서 메세지
        log.info("서비스의 흐름/데이터 상태 사용된다. "); // 운용 과정 메세지
        log.warn("잠재적 문제 사용된다."); // 유지보수 과정 메세지
        log.error("예외/실패 상황 사용된다."); // 운용/유지보수 과정 메세지
    }
    // 1.
    @PostMapping("/rend")
    public ResponseEntity<Boolean> rend(@RequestBody Map<String , Object> body){
        log.debug("[대여신청]" + body);
        boolean result = false;
        try{
            result = bookService.rend(body); // 만약에 커밋이면
            log.debug("[대여성공] "+ body);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e){ // 만약에 롤백이면 , e.getMessage() : 예외 메세지
            log.debug("[대여실패] "+ body + e.getMessage() );
            // 만약에 롤백이면
            return ResponseEntity.status(405).body(result);
        }

    }
}
