package dev.retrotv.framework.persistence.jpa.entity.identity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
}
