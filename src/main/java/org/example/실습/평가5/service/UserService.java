package org.example.실습.평가5.service;

import lombok.RequiredArgsConstructor;
import org.example.실습.평가5.controller.UserController;
import org.example.실습.평가5.model.dto.UserDto;
import org.example.실습.평가5.model.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    // 1. 영화 등록
    public boolean movieAdd(UserDto dto){
        return userMapper.movieAdd(dto);
    }

    // 2. 영화 삭제
    public boolean movieDel(int mno){
        return userMapper.movieDel(mno);
    }

    // 3. 영화 목록 조회
    public List<UserDto> moviePrint(){
        return userMapper.moviePrint();
    }

    // 4. 토론 글 작성
    public boolean userAdd(UserDto dto){
        return userMapper.userAdd(dto);
    }

    // 5. 토론 글 삭제
    public boolean userDel(int sno, String spwd){
        return userMapper.userDel(sno, spwd);
    }

    // 6. 영화별 토론 조회
    public List<UserDto> userPrint2(int mno){
        return userMapper.userPrint2(mno);
    }
}
