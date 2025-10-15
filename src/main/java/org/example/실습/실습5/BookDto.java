package org.example.실습.실습5;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class BookDto {
    private int id;
    private int book_id;
    private String member;
    private String title;
    private int price;
    private int stock;
}
