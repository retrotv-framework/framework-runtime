package dev.retrotv.framework.persistence.jpa.entity.uuid.v7.string;

import com.github.f4b6a3.uuid.UuidCreator;
import dev.retrotv.framework.persistence.jpa.converter.UUIDStringConverter;
import dev.retrotv.framework.persistence.jpa.entity.DateEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

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
    @Convert(converter = UUIDStringConverter.class)
    protected UUID id;

    @PrePersist
    protected void onPrePersist() {
        if (this.id == null) {
            this.id = UuidCreator.getTimeOrderedEpoch();
        }
    }
}