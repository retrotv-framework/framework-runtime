package dev.retrotv.framework.persistence.jpa.embedded;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SoftDeletedTest {

    @Test
    @DisplayName("빌더로 값을 지정하지 않으면 삭제되지 않은 상태(false)가 기본값이다")
    void test_builder_defaultsToNotDeleted() {
        SoftDeleted softDeleted = SoftDeleted.builder().build();

        assertThat(softDeleted.getYn()).isFalse();
        assertThat(softDeleted.getReason()).isNull();
    }

    @Test
    @DisplayName("빌더로 삭제여부와 사유를 지정할 수 있다")
    void test_builder_withValues() {
        SoftDeleted softDeleted = SoftDeleted.builder()
            .yn(true)
            .reason("개인정보 삭제 요청")
            .build();

        assertThat(softDeleted.getYn()).isTrue();
        assertThat(softDeleted.getReason()).isEqualTo("개인정보 삭제 요청");
    }

    @Test
    @DisplayName("기본 생성자로 생성하면 삭제되지 않은 상태(false)가 기본값이다")
    void test_noArgsConstructor_defaultsToNotDeleted() {
        SoftDeleted softDeleted = new SoftDeleted();

        assertThat(softDeleted.getYn()).isFalse();
    }
}
