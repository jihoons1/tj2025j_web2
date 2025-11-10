package org.example2.실습.실습4;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "pentity")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PracticeEntity extends BaseTime{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY) // 자동 증가
    private int pid;

    private String ptitle; // 제목

    private String pcontent; // 내용

    public PracticeDto toDto(){
        return PracticeDto.builder()
                .pid(this.pid)
                .ptitle(this.ptitle)
                .pcontent(this.pcontent)
                .update_p(this.getUpdatedDate().toString())
                .create_p(this.getCreatedDate().toString())
                .build();
    }
}
