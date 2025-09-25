package org.example.실습.평가5.model.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.실습.평가5.model.dto.UserDto;

import java.util.List;

@Mapper
public interface UserMapper {

    // 1. 영화 등록
    @Insert("insert into movie(mname, mgenre, mcontent) values(#{mname}, #{mgenre}, #{mcontent})")
    public boolean movieAdd(UserDto dto);

    // 2. 영화 삭제 (비밀번호 기반은 없으니, movie 테이블에도 spwd 컬럼을 추가하거나 따로 처리 필요)
    @Delete("delete from movie where mno = #{mno}")
    public boolean movieDel(int mno);

    // 3. 영화 목록 조회
    @Select("select * from movie")
    public List<UserDto> moviePrint();

    /* -------------------- 토론 글 관련 -------------------- */

    // 4. 토론 글 작성
    @Insert("insert into product(mno, spwd, tabletext, smovie) " +
            "values(#{mno}, #{spwd}, #{tabletext}, #{smovie})")
    public boolean userAdd(UserDto dto);

    // 5. 토론 글 삭제 (비밀번호 기반)
    @Delete("delete from product where sno = #{sno} and spwd = #{spwd}")
    public boolean userDel(int sno, String spwd);

    // 6. 영화별 토론 전체 조회
    @Select("select p.sno, p.mno, p.spwd, p.tabletext, p.smovie, " +
            "m.mname, m.mgenre, m.mcontent " +
            "from product p join movie m on p.mno = m.mno " +
            "where p.mno=#{mno}")
    public List<UserDto> userPrint2(int mno);
}
