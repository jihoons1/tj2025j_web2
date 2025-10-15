package org.example.실습.실습5;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final XmlMapper xmlMapper;

    // 조회하기
    @Transactional
    public List<BookDto> printstock(String title, int stock) {
        System.out.println("BookService.printstock");
        List<BookDto> dto = xmlMapper.printstock(title,stock);
        return dto;

    }


}
