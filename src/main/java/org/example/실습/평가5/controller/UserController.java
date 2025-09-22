package org.example.실습.평가5.controller;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
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

    // 등록
    @PostMapping("")
    public ResponseEntity<Boolean> userAdd(@RequestBody UserDto dto){
        System.out.println("UserController.userAdd");
        boolean result = userService.userAdd(dto);
        return ResponseEntity.status(200).body(result);
    }
    // 조회
    @GetMapping("")
    public ResponseEntity<List<UserDto > > userPrint(){
        System.out.println("UserController.userPrint");
        List<UserDto> dto = userService.userPrint();
        return ResponseEntity.status(200).body(dto);
    }
    // 토론 조회
    @GetMapping("")
    public ResponseEntity<List<UserDto>> userPrint2(int mno , String mgenre){
        System.out.println("UserController.userPrint2");
        List<UserDto> dto = userService.userPrint2(mno , mgenre);
        return ResponseEntity.status(200).body(dto);
    }
    // 삭제
    @DeleteMapping("")
    public ResponseEntity<Boolean> userDel(@RequestParam int sno , String spwd){
        System.out.println("UserController.userPrint");
        boolean result = userService.userDel(sno,spwd);
        return ResponseEntity.ok().body(result);
    }
}
