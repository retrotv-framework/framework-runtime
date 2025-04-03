package dev.retrotv.framework.foundation.cryptography.hash;

import java.io.IOException;

public interface BinaryHash {
    byte[] digest(byte[] data) throws IOException;
}
