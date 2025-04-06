package dev.retrotv.framework.foundation.cryptography.digest.crc;

import java.nio.ByteBuffer;

import dev.retrotv.framework.foundation.cryptography.digest.GeneralDigest;
import dev.retrotv.framework.foundation.cryptography.digest.enums.DigestAlgorithm;

public class CRC32C extends GeneralDigest{
    public CRC32C() {
        super();
        algorithmName = DigestAlgorithm.CRC32C.getName();
    }

    @Override
    public byte[] digest(byte[] data) {
        java.util.zip.CRC32C crc = new java.util.zip.CRC32C();
        crc.update(data);
        long checksum = crc.getValue();

        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(checksum);
        
        return buffer.array();
    }
}
