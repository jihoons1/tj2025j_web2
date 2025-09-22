package org.example.실습.평가5.service;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.example.실습.평가5.controller.UserController;
import org.example.실습.평가5.model.dto.UserDto;
import org.example.실습.평가5.model.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    // 등록
    public boolean userAdd(UserDto dto){
        System.out.println("UserService.userAdd");
        boolean result = userMapper.userAdd(dto);
        return result;
    }

    // ㅈ회
    public List<UserDto> userPrint(){
        System.out.println("UserService.userPrint");
        List<UserDto> dto = userMapper.userPrint();
        return dto;
    }
    // ㅌ론 조회
    public List<UserDto> userPrint2(int mno, String mgenre){
        System.out.println("UserService.userPrint2");
        List<UserDto> dto = userMapper.userPrint2(mno , mgenre);
        return dto;
    }

    // 삭제
    public boolean userDel(int sno, String spwd){
        System.out.println("UserService.userDel");
        boolean result = userMapper.userDel(sno,spwd);
        return result;
    }
}
