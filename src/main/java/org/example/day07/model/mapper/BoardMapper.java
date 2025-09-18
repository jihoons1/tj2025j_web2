package org.example.day07.model.mapper;

import org.apache.ibatis.annotations.*;
import org.example.day07.model.dto.BoardDto;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 게시물 등록
    @Insert("insert into board(bcontent ,bwriter )values( #{bcontent} , #{bwriter} ) ")
    public boolean boardWrite(BoardDto dto);
    // 게시물 전체 조회
    @Select("select * from board ")
    public List<BoardDto> boardPrint();
    // 특정 게시물 조회
    @Select("select * from board where bno = #{bno} ")
    public BoardDto boardFind(int bno);
    // 게시물 삭제
    @Delete("delete from board where bno = #{bno} ")
    public Boolean boardDelete(int bno);
    // 게시물 수정
    @Update("update board set bcontent = #{bcontent} where bno = #{bno}")
    public Boolean boardUpdate(BoardDto dto);
}
