package dev.retrotv.framework.data.jpa.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.AttributeConverter;

/**
 * 데이터베이스에 저장되는 Date 값을 'yyyy-MM-dd HH:mm:ss' 포맷으로 저장하고 읽어오는 컨버터
 */
public class DateStringConverter implements AttributeConverter<Date, String> {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String convertToDatabaseColumn(Date attribute) {
        return attribute != null ? dateFormat.format(attribute) : null;
    }

    @Override
    public Date convertToEntityAttribute(String dbData) {
        try {
            return dbData != null ? dateFormat.parse(dbData) : null;
        } catch (ParseException ex) {
            return null;
        }
    }
}

