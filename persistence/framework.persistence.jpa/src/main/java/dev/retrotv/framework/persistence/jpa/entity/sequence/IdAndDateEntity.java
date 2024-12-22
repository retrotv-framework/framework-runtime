package dev.retrotv.framework.persistence.jpa.entity.sequence;

import dev.retrotv.framework.persistence.jpa.entity.DateEntity;
import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 식별자와 생성/수정일자 및 사용자 데이터를 가지는 엔티티
 *
 * @since 1.0.0
 * @version 1.0.0
 */
@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class IdAndDateEntity extends DateEntity {

    @Id
    @Comment("식별자")
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;
}
