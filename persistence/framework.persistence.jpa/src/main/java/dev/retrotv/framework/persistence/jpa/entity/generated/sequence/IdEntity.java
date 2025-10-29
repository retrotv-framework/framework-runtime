package dev.retrotv.framework.persistence.jpa.entity.generated.sequence;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 식별자를 가지는 엔티티
 *
 * @since 1.0.0
 * @version 1.0.0
 */
@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class IdEntity {
    
    @Id
    @Comment("식별자")
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;
}
