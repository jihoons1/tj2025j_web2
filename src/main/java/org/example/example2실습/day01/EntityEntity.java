package org.example.example2실습.day01;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EntityEntity {

    @Id
    private int bookid; // 도서ID
    private String bookname; // 도서명
    private String bname; // 저자
    private String publisher; // 출판사
}
