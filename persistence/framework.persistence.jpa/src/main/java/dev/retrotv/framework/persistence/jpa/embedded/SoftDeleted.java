package dev.retrotv.framework.persistence.jpa.embedded;

import dev.retrotv.framework.persistence.jpa.converter.BooleanYNConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
public class SoftDeleted implements Serializable {

    @Builder.Default
    @Column(name = "DELETED_YN", comment = "삭제여부", length = 1)
    @Convert(converter = BooleanYNConverter.class)
    private Boolean yn = false;

    @Column(name = "DELETED_REASON", comment = "삭제사유")
    private String reason;
}
