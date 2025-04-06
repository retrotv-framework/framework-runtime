package dev.retrotv.framework.foundation.cryptography.digest.crc;

import java.nio.ByteBuffer;

import dev.retrotv.framework.foundation.cryptography.digest.GeneralDigest;
import dev.retrotv.framework.foundation.cryptography.digest.enums.DigestAlgorithm;

public class CRC32 extends GeneralDigest {
    public CRC32() {
        super();
        algorithmName = DigestAlgorithm.CRC32.getName();
    }

    @Override
    public byte[] digest(byte[] data) {
        java.util.zip.CRC32 crc = new java.util.zip.CRC32();
        crc.update(data);
        long checksum = crc.getValue();

        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(checksum);
        
        return buffer.array();
    }
}
