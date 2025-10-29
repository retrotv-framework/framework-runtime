package dev.retrotv.framework.persistence.jpa.entity.uuid.v4.binary;

import dev.retrotv.framework.persistence.jpa.converter.UUIDBytesConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

import java.util.UUID;

/**
 * UUID 형식의 식별자를 가지는 엔티티
 */
@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class UUIDEntity {

    @Id
    @Comment("식별자")
    @Column(name = "ID", nullable = false)
    @Convert(converter = UUIDBytesConverter.class)
    protected UUID id;

    @PrePersist
    protected void onPrePersist() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
    }
}