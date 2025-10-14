package org.example.실습.실습4;

import lombok.*;

@Setter @Getter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
public class BookDto {
    private int id;
    private int book_id;
    private String member;
    private int title;
    private int stock;
}