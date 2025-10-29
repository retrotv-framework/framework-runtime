package dev.retrotv.framework.persistence.jpa.converter;

import jakarta.persistence.AttributeConverter;

import java.util.UUID;

/**
 * 데이터베이스에 저장되는 UUID 값을 String으로 저장하고 읽어오는 컨버터
 *
 * @since 1.0.0
 * @version 1.0.0
 */
public class UUIDStringConverter implements AttributeConverter<UUID, String> {

    @Override
    public String convertToDatabaseColumn(UUID attribute) {
        return attribute == null ? null : attribute.toString();
    }

    @Override
    public UUID convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }

        return UUID.fromString(dbData);
    }
}
