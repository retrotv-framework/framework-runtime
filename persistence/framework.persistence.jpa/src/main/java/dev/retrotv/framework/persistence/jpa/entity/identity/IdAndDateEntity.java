package dev.retrotv.framework.persistence.jpa.entity.identity;

import dev.retrotv.framework.persistence.jpa.entity.DateEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class IdAndDateEntity extends DateEntity {

    @Id
    @Comment("식별자")
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
}
