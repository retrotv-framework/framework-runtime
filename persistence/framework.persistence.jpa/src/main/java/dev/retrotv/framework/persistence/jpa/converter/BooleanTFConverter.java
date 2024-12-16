package dev.retrotv.framework.persistence.jpa.converter;

import jakarta.persistence.AttributeConverter;

/**
 * 데이터베이스에 저장되는 Boolean 값을 'T'/'F'로 저장하고 읽어오는 컨버터
 */
public class BooleanTFConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return (attribute != null && attribute) ? "T" : "F";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "T".equalsIgnoreCase(dbData);
    }
}
