package org.example.실습.실습6;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/xml")
@RequiredArgsConstructor

public class ViewController {

    private final ViewService viewService;

    // 조회
    @GetMapping("/print")
    public ResponseEntity< ? > printstock(@RequestParam String title , @RequestParam int stock){
        List<ViewDto> dto = viewService.printstock(title , stock);
        return ResponseEntity.ok(dto);
    }

}
