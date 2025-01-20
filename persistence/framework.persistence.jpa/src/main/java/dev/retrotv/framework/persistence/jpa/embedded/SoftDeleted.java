package dev.retrotv.framework.persistence.jpa.embedded;

import dev.retrotv.framework.persistence.jpa.converter.BooleanYNConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;

/**
 * 데이터를 소프트하게 삭제하기 위한 임베디드 필드
 *
 * @since 1.0.0
 * @version 1.0.0
 */
@Getter
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class SoftDeleted {

    @Builder.Default
    @Comment("사용여부")
    @Column(name = "DELETED_YN", length = 1)
    @Convert(converter = BooleanYNConverter.class)
    private Boolean yn = false;

    @Comment("삭제사유")
    @Column(name = "DELETED_REASON", length = 200)
    private String reason;
}
