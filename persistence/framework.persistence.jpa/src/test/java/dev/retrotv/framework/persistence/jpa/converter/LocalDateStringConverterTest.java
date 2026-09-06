package dev.retrotv.framework.persistence.jpa.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class LocalDateStringConverterTest {

    private final LocalDateStringConverter converter = new LocalDateStringConverter();

    @Test
    @DisplayName("LocalDate를 'yyyy-MM-dd' 포맷 문자열로 변환한다")
    void test_convertToDatabaseColumn() {
        LocalDate date = LocalDate.of(2026, 1, 15);

        assertThat(converter.convertToDatabaseColumn(date)).isEqualTo("2026-01-15");
    }

    @Test
    @DisplayName("null LocalDate는 null로 변환된다")
    void test_convertToDatabaseColumn_null() {
        assertThat(converter.convertToDatabaseColumn(null)).isNull();
    }

    @Test
    @DisplayName("포맷 문자열을 LocalDate로 변환한다")
    void test_convertToEntityAttribute() {
        assertThat(converter.convertToEntityAttribute("2026-01-15")).isEqualTo(LocalDate.of(2026, 1, 15));
    }

    @Test
    @DisplayName("null 문자열은 null로 변환된다")
    void test_convertToEntityAttribute_null() {
        assertThat(converter.convertToEntityAttribute(null)).isNull();
    }

    @Test
    @DisplayName("포맷에 맞지 않는 문자열은 null로 변환된다")
    void test_convertToEntityAttribute_invalidFormat() {
        assertThat(converter.convertToEntityAttribute("invalid-date")).isNull();
    }
}
