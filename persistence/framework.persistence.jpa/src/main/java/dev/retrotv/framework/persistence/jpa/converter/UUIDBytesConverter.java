package dev.retrotv.framework.persistence.jpa.converter;

import jakarta.persistence.AttributeConverter;

import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * 데이터베이스에 저장되는 UUID 값을 바이너리로 저장하고 읽어오는 컨버터
 *
 * @since 1.0.0
 * @version 1.0.0
 */
public class UUIDBytesConverter implements AttributeConverter<UUID, byte[]> {

    @Override
    public byte[] convertToDatabaseColumn(UUID attribute) {
        if (attribute == null) {
            return new byte[0];
        }

        ByteBuffer bb = ByteBuffer.allocate(16);
        bb.putLong(attribute.getMostSignificantBits());
        bb.putLong(attribute.getLeastSignificantBits());
        return bb.array();
    }

    @Override
    public UUID convertToEntityAttribute(byte[] dbData) {
        if (dbData == null || dbData.length != 16) {
            return null;
        }

        ByteBuffer bb = ByteBuffer.wrap(dbData);
        long most = bb.getLong();
        long least = bb.getLong();
        return new UUID(most, least);
    }
}
