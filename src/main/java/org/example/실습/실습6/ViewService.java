package org.example.실습.실습6;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@AllArgsConstructor
public class ViewService {
    private final XmlMapper xmlMapper;



    // 조회하기
    @Transactional
    public List<ViewDto> printstock(String title, int stock) {
        System.out.println("BookService.printstock");
        List<ViewDto> dto = xmlMapper.printstock(title,stock);
        return dto;

    }


}
