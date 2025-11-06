package org.example2.실습.실습3;


import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 엔티티 상속 속도
@EntityListeners(AuditingEntityListener.class) // 자동 감시 적용

public class BaseTime {

    // 자동으로 시간 기록

    @CreatedDate // 생성일자
    private LocalDateTime createdDate;

    @LastModifiedDate // 수정일자
    private LocalDateTime updatedDate;
}
