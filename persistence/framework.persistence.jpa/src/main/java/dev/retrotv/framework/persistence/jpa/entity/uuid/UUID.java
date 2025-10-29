package dev.retrotv.framework.persistence.jpa.entity.uuid;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

/**
 * UUID 형식의 식별자를 가지는 엔티티
 */
@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class UUID {

    @Id
    @Comment("식별자")
    @Column(name = "ID")
    protected UUID id;
}