package org.example.실습.실습5;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface XmlMapper {

    // 조회
    List<BookDto> printstock(String title, int stock);
}
