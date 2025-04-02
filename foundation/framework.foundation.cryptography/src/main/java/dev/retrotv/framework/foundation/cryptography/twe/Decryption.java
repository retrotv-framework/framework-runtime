package dev.retrotv.framework.foundation.cryptography.twe;

import dev.retrotv.framework.foundation.cryptography.twe.param.Param;
import dev.retrotv.framework.foundation.cryptography.twe.result.Result;

public interface Decryption {
    Result decrypt(Param params, byte[] encryptedData);
}
