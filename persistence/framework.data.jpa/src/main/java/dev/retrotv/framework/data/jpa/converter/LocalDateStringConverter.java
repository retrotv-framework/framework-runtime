package dev.retrotv.framework.data.jpa.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import jakarta.persistence.AttributeConverter;

/**
 * 데이터베이스에 저장되는 LocalDate 값을 'yyyy-MM-dd' 포맷으로 저장하고 읽어오는 컨버터
 */
public class LocalDateStringConverter implements AttributeConverter<LocalDate, String> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public String convertToDatabaseColumn(LocalDate attribute) {
        return attribute != null ? attribute.format(formatter) : null;
    }

    @Override
    public LocalDate convertToEntityAttribute(String dbData) {
        try {
            return dbData != null ? LocalDate.parse(dbData, formatter) : null;
        } catch (DateTimeParseException ex) {
            return null;
        }
    }
}
