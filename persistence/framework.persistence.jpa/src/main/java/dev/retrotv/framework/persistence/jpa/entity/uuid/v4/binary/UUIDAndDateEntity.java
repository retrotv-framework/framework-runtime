package dev.retrotv.framework.persistence.jpa.entity.uuid.v4.binary;

import dev.retrotv.framework.persistence.jpa.entity.DateEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.BinaryJdbcType;

/**
 * UUID 형식의 식별자와 생성/수정일자 및 사용자 데이터를 가지는 엔티티
 */
@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class UUIDAndDateEntity extends DateEntity {

    @Id
    @Column(name = "ID", comment = "식별자")
    @JdbcType(BinaryJdbcType.class)
    protected UUID id;

    @PrePersist
    protected void onPrePersist() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
    }
}