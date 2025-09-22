package org.example.실습.평가5.model.mapper;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.실습.평가5.model.dto.UserDto;

import java.util.List;

@Mapper
public interface UserMapper {

    // 등록
    @Insert("insert into product(mno,spwd,tabletext,smovie)values(#{mno} , #{spwd} , #{tabletext} , #{smovie}")
    public boolean userAdd(UserDto dto);
    // 조회
    @Select("select * from where mno")
    public List<UserDto> userPrint();
    // 토론 조회
    @Select("select * from where mno and mgenre and tabletext")
    public List<UserDto> userPrint2(int mno, String mgenre);
    // 삭제
    @Delete("delete from product where mno and spwd = #{spwd} ")
    public boolean userDel(int sno , String spwd);
    //
}
