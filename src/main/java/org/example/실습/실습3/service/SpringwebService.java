package org.example.실습.실습3.service;

import lombok.RequiredArgsConstructor;
import org.example.실습.실습3.model.dto.SpringwebDto;
import org.example.실습.실습3.model.mapper.SpringwebMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpringwebService {

    private final SpringwebMapper springwebMapper;

    // 등록
    public boolean springadd(SpringwebDto dto){
        System.out.println("SpringwebService.springadd");
        boolean result = springwebMapper.springadd(dto);
        return result;
    }
    // 조회
    public List<SpringwebDto> springprint(){
        System.out.println("SpringwebService.springprint");
        List<SpringwebDto> list = springwebMapper.springprint();
        return list;

    }
    // 삭제
    public boolean springdel(int sno){
        System.out.println("SpringwebService.springdel");
        boolean result = springwebMapper.springdel(sno);
        return result;
    }
    // 개인
    public SpringwebDto springprint2(int sno){
        System.out.println("SpringwebService.springprint2");
        SpringwebDto dto = springwebMapper.springprint2(sno);
        return dto;
    }
    // 수정
    public boolean springup(SpringwebDto dto){
        System.out.println("SpringwebService.springup");
        boolean result = springwebMapper.springup(dto);
        return result;
    }

}
