package dev.retrotv.framework.persistence.jpa.embedded;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class UseTest {

    @Test
    @DisplayName("빌더로 값을 지정하지 않으면 사용중인 상태(true)가 기본값이다")
    void test_builder_defaultsToInUse() {
        Use use = Use.builder().build();

        assertThat(use.getYn()).isTrue();
        assertThat(use.getStartDate()).isNull();
        assertThat(use.getEndDate()).isNull();
    }

    @Test
    @DisplayName("빌더로 사용여부와 사용기간을 지정할 수 있다")
    void test_builder_withValues() {
        LocalDate start = LocalDate.of(2026, 1, 1);
        LocalDate end = LocalDate.of(2026, 12, 31);

        Use use = Use.builder()
            .yn(false)
            .startDate(start)
            .endDate(end)
            .build();

        assertThat(use.getYn()).isFalse();
        assertThat(use.getStartDate()).isEqualTo(start);
        assertThat(use.getEndDate()).isEqualTo(end);
    }

    @Test
    @DisplayName("기본 생성자로 생성하면 사용중인 상태(true)가 기본값이다")
    void test_noArgsConstructor_defaultsToInUse() {
        Use use = new Use();

        assertThat(use.getYn()).isTrue();
    }
}
