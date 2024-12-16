package dev.retrotv.framework.persistence.jpa.entity;

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

@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class DateEntity {

    @CreatedDate
    @Comment("등록일시")
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    protected LocalDateTime createdDate;

    @CreatedBy
    @Comment("등록한 유저")
    @Column(name = "CREATED_ID", length = 50, nullable = false, updatable = false)
    protected String createdId;

    @LastModifiedDate
    @Comment("수정일시")
    @Column(name = "MODIFIED_DATE", nullable = false)
    protected LocalDateTime modifiedDate;

    @LastModifiedBy
    @Comment("수정한 유저")
    @Column(name = "MODIFIED_ID", length = 50, nullable = false)
    protected String modifiedId;
}
