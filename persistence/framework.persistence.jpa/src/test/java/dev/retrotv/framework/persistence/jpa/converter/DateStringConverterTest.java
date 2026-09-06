package dev.retrotv.framework.persistence.jpa.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class DateStringConverterTest {

    private final DateStringConverter converter = new DateStringConverter();

    @Test
    @DisplayName("Date를 'yyyy-MM-dd HH:mm:ss' 포맷 문자열로 변환한다")
    void test_convertToDatabaseColumn() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse("2026-01-15 13:30:00");

        assertThat(converter.convertToDatabaseColumn(date)).isEqualTo("2026-01-15 13:30:00");
    }

    @Test
    @DisplayName("null Date는 null로 변환된다")
    void test_convertToDatabaseColumn_null() {
        assertThat(converter.convertToDatabaseColumn(null)).isNull();
    }

    @Test
    @DisplayName("포맷 문자열을 Date로 변환한다")
    void test_convertToEntityAttribute() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date expected = format.parse("2026-01-15 13:30:00");

        assertThat(converter.convertToEntityAttribute("2026-01-15 13:30:00")).isEqualTo(expected);
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
