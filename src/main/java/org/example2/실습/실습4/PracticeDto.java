package org.example2.실습.실습4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PracticeDto {

    private int pid;
    private String ptitle;
    private String pcontent;
    private String update_p;
    private String create_p;


    public PracticeEntity toEntity(){
        return PracticeEntity.builder()
                .pid(this.pid)
                .ptitle(this.ptitle)
                .pcontent(this.pcontent)
                // 수정 날짜는 자동이니
                .build();
    }
}
