package dev.retrotv.framework.persistence.jpa.embedded;

import java.time.LocalDate;

import dev.retrotv.framework.persistence.jpa.converter.BooleanYNConverter;
import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
public class Use {
    
    @Builder.Default
    @Comment("사용여부")
    @Column(name = "USE_YN", length = 1)
    @Convert(converter = BooleanYNConverter.class)
    private Boolean yn = true;

    @Comment("사용시작일")
    @Column(name = "USE_START_DATE")
    private LocalDate startDate;

    @Comment("사용종료일")
    @Column(name = "USE_END_DATE")
    private LocalDate endDate;
}
