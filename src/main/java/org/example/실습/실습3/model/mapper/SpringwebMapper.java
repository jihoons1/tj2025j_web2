package org.example.실습.실습3.model.mapper;

import org.apache.ibatis.annotations.*;
import org.example.실습.실습3.model.dto.SpringwebDto;

import java.util.List;

@Mapper
public interface SpringwebMapper {

    // 등록
    @Insert("insert into product5(sname,sphone,age)values(#{sname} , #{sphone} , #{age})")
    public boolean springadd(SpringwebDto dto);

    // 조회
    @Select("select * from product5")
    public List<SpringwebDto> springprint();

    // 삭제
    @Delete("delete from product5 where sno = #{sno}")
    public boolean springdel(int sno);

    // 개인
    @Select("select * from product5 where sno = #{sno}")
    public SpringwebDto springprint2(int sno);

    // 수정
    @Update("update product5 set sname = #{sname} , sphone = #{sphone} , age = #{age} where sno = #{sno} ")
    public boolean springup(SpringwebDto dto);



} // interface end
