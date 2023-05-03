package kr.ming9.boot.doamin;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass       // jpa entity 클래스들이 baseTimeEntity를 상속할 경우 필드들도 컬럼으로 인식하도록 함(createdDate, modifiedDate)
@EntityListeners(AuditingEntityListener.class)  // BaseTimeEntity 클래스에서 Auditing 기능을 포함
public class BaseTimeEntity {

    @CreatedDate    // entity가 생설될 떄 시간이 자동으로 저장
    private LocalDateTime createdDate;

    @LastModifiedDate   // 조회된 entity의 값을 변경할 때 시간이 자동으로 저장
    private LocalDateTime modifiedDate;
}
