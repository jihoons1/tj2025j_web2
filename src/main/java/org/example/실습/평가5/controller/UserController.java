package org.example.실습.평가5.controller;

import lombok.RequiredArgsConstructor;
import org.example.실습.평가5.model.dto.UserDto;
import org.example.실습.평가5.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    // 1. 영화 등록
    @PostMapping("/movie")
    public ResponseEntity<Boolean> movieAdd(@RequestBody UserDto dto){
        boolean result = userService.movieAdd(dto);
        return ResponseEntity.ok(result);
    }

    // 2. 영화 삭제
    @DeleteMapping("/movie")
    public ResponseEntity<Boolean> movieDel(@RequestParam int mno){
        boolean result = userService.movieDel(mno);
        return ResponseEntity.ok(result);
    }

    // 3. 영화 목록 조회
    @GetMapping("/movie")
    public ResponseEntity<List<UserDto>> moviePrint(){
        List<UserDto> list = userService.moviePrint();
        return ResponseEntity.ok(list);
    }

    // 4. 토론 글 작성
    @PostMapping("/product")
    public ResponseEntity<Boolean> userAdd(@RequestBody UserDto dto){
        boolean result = userService.userAdd(dto);
        return ResponseEntity.ok(result);
    }

    // 5. 토론 글 삭제
    @DeleteMapping("/product")
    public ResponseEntity<Boolean> userDel(@RequestParam int sno, @RequestParam String spwd){
        boolean result = userService.userDel(sno, spwd);
        return ResponseEntity.ok(result);
    }

    // 6. 영화별 토론 전체 조회
    @GetMapping("/product")
    public ResponseEntity<List<UserDto>> userPrint2(@RequestParam int mno){
        List<UserDto> list = userService.userPrint2(mno);
        return ResponseEntity.ok(list);
    }
}
