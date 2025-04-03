package dev.retrotv.framework.foundation.cryptography.digest;

import java.io.IOException;

public interface BinaryDigest {
    byte[] digest(byte[] data) throws IOException;
}
