package dev.retrotv.framework.foundation.cryptography.digest;

import dev.retrotv.framework.foundation.cryptography.digest.enums.Format;

public interface BinaryDigest {
    byte[] digest(byte[] data);
    String digest(byte[] data, String format);
    String digest(byte[] data, Format format);
}
