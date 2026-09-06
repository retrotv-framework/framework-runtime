package dev.retrotv.framework.persistence.jpa.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BooleanYNConverterTest {

    private final BooleanYNConverter converter = new BooleanYNConverter();

    @Test
    @DisplayName("true는 'Y'로 변환된다")
    void test_convertToDatabaseColumn_true() {
        assertThat(converter.convertToDatabaseColumn(true)).isEqualTo("Y");
    }

    @Test
    @DisplayName("false 또는 null은 'N'으로 변환된다")
    void test_convertToDatabaseColumn_falseOrNull() {
        assertThat(converter.convertToDatabaseColumn(false)).isEqualTo("N");
        assertThat(converter.convertToDatabaseColumn(null)).isEqualTo("N");
    }

    @Test
    @DisplayName("'Y'(대소문자 무관)는 true로 변환된다")
    void test_convertToEntityAttribute_yToTrue() {
        assertThat(converter.convertToEntityAttribute("Y")).isTrue();
        assertThat(converter.convertToEntityAttribute("y")).isTrue();
    }

    @Test
    @DisplayName("'Y'가 아닌 값(null 포함)은 false로 변환된다")
    void test_convertToEntityAttribute_notYToFalse() {
        assertThat(converter.convertToEntityAttribute("N")).isFalse();
        assertThat(converter.convertToEntityAttribute(null)).isFalse();
        assertThat(converter.convertToEntityAttribute("")).isFalse();
    }
}
