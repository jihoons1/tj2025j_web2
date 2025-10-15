package org.example.실습.실습5;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/xml")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    // 조회
    @GetMapping("/print")
    public ResponseEntity< ? > printstock(@RequestParam String title ,@RequestParam int stock){
        List<BookDto> dto = bookService.printstock(title , stock);
        return ResponseEntity.ok(dto);
    }

}
