package dev.retrotv.framework.foundation.cryptography.digest.md;

import dev.retrotv.framework.foundation.cryptography.digest.GeneralDigest;
import dev.retrotv.framework.foundation.cryptography.digest.enums.DigestAlgorithm;

public class MD5 extends GeneralDigest {
    public MD5() {
        super();
        algorithmName = DigestAlgorithm.MD5.getName();
    }
}
