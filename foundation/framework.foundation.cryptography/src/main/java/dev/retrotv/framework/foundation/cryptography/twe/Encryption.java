package dev.retrotv.framework.foundation.cryptography.twe;

import dev.retrotv.framework.foundation.cryptography.twe.param.Param;
import dev.retrotv.framework.foundation.cryptography.twe.result.Result;

public interface Encryption {
    Result encrypt(Param params, byte[] data);
    boolean verify();
}
