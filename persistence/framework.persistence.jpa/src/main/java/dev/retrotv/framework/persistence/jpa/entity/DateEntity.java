package dev.retrotv.framework.persistence.jpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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
    @Column(name = "CREATED_DATE", comment = "등록일시", nullable = false, updatable = false)
    protected LocalDateTime createdDate;

    @CreatedBy
    @Column(name = "CREATED_ID", comment = "등록한 유저", nullable = false, updatable = false)
    protected String createdId;

    @LastModifiedDate
    @Column(name = "MODIFIED_DATE", comment = "수정일시", nullable = false)
    protected LocalDateTime modifiedDate;

    @LastModifiedBy
    @Column(name = "MODIFIED_ID", comment = "수정한 유저", nullable = false)
    protected String modifiedId;
}
