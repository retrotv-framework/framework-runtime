package dev.retrotv.framework.persistence.jpa.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import jakarta.persistence.AttributeConverter;

/**
 * 데이터베이스에 저장되는 LocalDateTime 값을 'yyyy-MM-dd HH:mm:ss' 포맷으로 저장하고 읽어오는 컨버터
 */
public class LocalDateTimeStringConverter implements AttributeConverter<LocalDateTime, String> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String convertToDatabaseColumn(LocalDateTime attribute) {
        return attribute != null ? attribute.format(formatter) : null;
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String dbData) {
        try {
            return dbData != null ? LocalDateTime.parse(dbData, formatter) : null;
        } catch (DateTimeParseException ex) {
            return null;
        }
    }
}
