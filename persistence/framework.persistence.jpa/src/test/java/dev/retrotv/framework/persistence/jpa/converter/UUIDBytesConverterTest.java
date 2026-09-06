package dev.retrotv.framework.persistence.jpa.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class UUIDBytesConverterTest {

    private final UUIDBytesConverter converter = new UUIDBytesConverter();

    @Test
    @DisplayName("UUID를 16바이트 배열로 변환하고 다시 동일한 UUID로 복원한다")
    void test_roundTrip() {
        UUID uuid = UUID.randomUUID();

        byte[] bytes = converter.convertToDatabaseColumn(uuid);

        assertThat(bytes).hasSize(16);
        assertThat(converter.convertToEntityAttribute(bytes)).isEqualTo(uuid);
    }

    @Test
    @DisplayName("null UUID는 빈 바이트 배열로 변환된다")
    void test_convertToDatabaseColumn_null() {
        assertThat(converter.convertToDatabaseColumn(null)).isEmpty();
    }

    @Test
    @DisplayName("null이거나 길이가 16이 아닌 바이트 배열은 null로 변환된다")
    void test_convertToEntityAttribute_invalidInput() {
        assertThat(converter.convertToEntityAttribute(null)).isNull();
        assertThat(converter.convertToEntityAttribute(new byte[0])).isNull();
        assertThat(converter.convertToEntityAttribute(new byte[8])).isNull();
    }
}
