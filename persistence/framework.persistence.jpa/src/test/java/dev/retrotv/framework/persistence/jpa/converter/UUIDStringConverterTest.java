package dev.retrotv.framework.persistence.jpa.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class UUIDStringConverterTest {

    private final UUIDStringConverter converter = new UUIDStringConverter();

    @Test
    @DisplayName("UUID를 문자열로 변환한다")
    void test_convertToDatabaseColumn() {
        UUID uuid = UUID.randomUUID();

        assertThat(converter.convertToDatabaseColumn(uuid)).isEqualTo(uuid.toString());
    }

    @Test
    @DisplayName("null은 null로 변환된다")
    void test_convertToDatabaseColumn_null() {
        assertThat(converter.convertToDatabaseColumn(null)).isNull();
    }

    @Test
    @DisplayName("문자열을 UUID로 변환한다")
    void test_convertToEntityAttribute() {
        UUID uuid = UUID.randomUUID();

        assertThat(converter.convertToEntityAttribute(uuid.toString())).isEqualTo(uuid);
    }

    @Test
    @DisplayName("null 또는 빈 문자열은 null로 변환된다")
    void test_convertToEntityAttribute_nullOrEmpty() {
        assertThat(converter.convertToEntityAttribute(null)).isNull();
        assertThat(converter.convertToEntityAttribute("")).isNull();
    }
}
