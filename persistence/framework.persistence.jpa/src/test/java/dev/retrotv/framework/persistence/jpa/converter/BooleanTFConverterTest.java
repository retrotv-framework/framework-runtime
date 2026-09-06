package dev.retrotv.framework.persistence.jpa.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BooleanTFConverterTest {

    private final BooleanTFConverter converter = new BooleanTFConverter();

    @Test
    @DisplayName("true는 'T'로 변환된다")
    void test_convertToDatabaseColumn_true() {
        assertThat(converter.convertToDatabaseColumn(true)).isEqualTo("T");
    }

    @Test
    @DisplayName("false 또는 null은 'F'로 변환된다")
    void test_convertToDatabaseColumn_falseOrNull() {
        assertThat(converter.convertToDatabaseColumn(false)).isEqualTo("F");
        assertThat(converter.convertToDatabaseColumn(null)).isEqualTo("F");
    }

    @Test
    @DisplayName("'T'(대소문자 무관)는 true로 변환된다")
    void test_convertToEntityAttribute_tToTrue() {
        assertThat(converter.convertToEntityAttribute("T")).isTrue();
        assertThat(converter.convertToEntityAttribute("t")).isTrue();
    }

    @Test
    @DisplayName("'T'가 아닌 값(null 포함)은 false로 변환된다")
    void test_convertToEntityAttribute_notTToFalse() {
        assertThat(converter.convertToEntityAttribute("F")).isFalse();
        assertThat(converter.convertToEntityAttribute(null)).isFalse();
        assertThat(converter.convertToEntityAttribute("")).isFalse();
    }
}
