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
import java.time.LocalDate;

/**
 * 데이터 사용여부 및 사용가능 기간을 지정하기 위한 임베디드 필드
 *
 * @since 1.0.0
 * @version 1.0.0
 */
@Getter
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Use implements Serializable {

    @Builder.Default
    @Column(name = "USE_YN", comment = "사용여부", length = 1)
    @Convert(converter = BooleanYNConverter.class)
    private Boolean yn = true;

    @Column(name = "USE_START_DATE", comment = "사용시작일")
    private LocalDate startDate;

    @Column(name = "USE_END_DATE", comment = "사용종료일")
    private LocalDate endDate;
}
