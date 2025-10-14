package org.example.실습.실습4;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface XmlMapper {

    // 책 등록
    int bookadd(BookDto dto);

    // 대출 기록 검색
    BookDto loanbook(String member ,String title);

    // 일괄 등록
    int addbo(List<BookDto> dtos);
}
