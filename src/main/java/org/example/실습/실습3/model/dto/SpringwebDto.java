package org.example.실습.실습3.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class SpringwebDto {
    private int sno; // 번호
    private int age; // 나이
    private String sname; // 이름
    private String sphone; // 전화번호
}
