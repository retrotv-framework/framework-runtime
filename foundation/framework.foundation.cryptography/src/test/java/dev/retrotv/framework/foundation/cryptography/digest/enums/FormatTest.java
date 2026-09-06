package dev.retrotv.framework.foundation.cryptography.digest.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FormatTest {

    @Test
    @DisplayName("Format 상수는 각자의 이름을 가진다")
    void test_names() {
        assertThat(Format.HEX.getName()).isEqualTo("HEX");
        assertThat(Format.BASE64.getName()).isEqualTo("BASE64");
    }

    @Test
    @DisplayName("2개의 포맷 상수를 가진다")
    void test_valuesCount() {
        assertThat(Format.values()).hasSize(2);
    }
}
