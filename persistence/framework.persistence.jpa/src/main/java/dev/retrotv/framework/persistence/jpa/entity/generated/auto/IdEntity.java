package dev.retrotv.framework.persistence.jpa.entity.generated.auto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

import java.io.Serializable;

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
public abstract class IdEntity implements Serializable {

    @Id
    @Column(name = "ID", comment = "식별자")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
}
