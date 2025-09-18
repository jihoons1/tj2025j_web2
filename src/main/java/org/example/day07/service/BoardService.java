package org.example.day07.service;

import lombok.RequiredArgsConstructor;
import org.example.day07.model.dto.BoardDto;
import org.example.day07.model.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    // 게시물 등록
    public boolean boardWrite(BoardDto dto){
        System.out.println("BoardController.boardWrite");
        boolean result = boardMapper.boardWrite(dto);
        return result;
    }
    // 게시물 전체 조회
    public List<BoardDto> boardPrint(){
        System.out.println("BoardService.boardPrint");
        List<BoardDto> result = boardMapper.boardPrint();
        return result;
    }
    // 특정 게시물 조회
    public BoardDto boardFind(int bno){
        System.out.println("BoardService.boardFind");
        BoardDto dto = boardMapper.boardFind(bno);
        return dto;
    }
    // 게시물 삭제
    public Boolean boardDelete(int bno){
        System.out.println("BoardService.boardDelete");
        Boolean result = boardMapper.boardDelete(bno);
        return result;
    }
    // 게시물 수정
    public Boolean boardUpdate(BoardDto dto){
        System.out.println("BoardService.boardUpdate");
        Boolean result = boardMapper.boardUpdate(dto);
        return result;
    }
}
