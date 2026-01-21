package dev.retrotv.framework.persistence.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 생성/수정일자 및 사용자 데이터를 가지는 엔티티
 *
 * @since 1.0.0
 * @version 1.0.0
 */
@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class DateEntity implements Serializable {

    @CreatedDate
    @Column(name = "CREATED_AT", comment = "등록일시", nullable = false, updatable = false)
    protected LocalDateTime createdAt;

    @CreatedBy
    @Column(name = "CREATED_ID", comment = "등록자", nullable = false, updatable = false)
    protected String createdId;

    @LastModifiedDate
    @Column(name = "MODIFIED_AT", comment = "수정일시", nullable = false)
    protected LocalDateTime modifiedAt;

    @LastModifiedBy
    @Column(name = "MODIFIED_ID", comment = "수정자", nullable = false)
    protected String modifiedId;
}
