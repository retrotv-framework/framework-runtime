package dev.retrotv.framework.persistence.jpa.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class LocalDateTimeStringConverterTest {

    private final LocalDateTimeStringConverter converter = new LocalDateTimeStringConverter();

    @Test
    @DisplayName("LocalDateTime을 'yyyy-MM-dd HH:mm:ss' 포맷 문자열로 변환한다")
    void test_convertToDatabaseColumn() {
        LocalDateTime dateTime = LocalDateTime.of(2026, 1, 15, 13, 30, 0);

        assertThat(converter.convertToDatabaseColumn(dateTime)).isEqualTo("2026-01-15 13:30:00");
    }

    @Test
    @DisplayName("null LocalDateTime은 null로 변환된다")
    void test_convertToDatabaseColumn_null() {
        assertThat(converter.convertToDatabaseColumn(null)).isNull();
    }

    @Test
    @DisplayName("포맷 문자열을 LocalDateTime으로 변환한다")
    void test_convertToEntityAttribute() {
        assertThat(converter.convertToEntityAttribute("2026-01-15 13:30:00"))
            .isEqualTo(LocalDateTime.of(2026, 1, 15, 13, 30, 0));
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
