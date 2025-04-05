package dev.retrotv.framework.foundation.cryptography.digest.sha;

import dev.retrotv.framework.foundation.cryptography.digest.GeneralDigest;
import dev.retrotv.framework.foundation.cryptography.digest.enums.DigestAlgorithm;

public class SHA512224 extends GeneralDigest {
    public SHA512224() {
        super();
        algorithmName = DigestAlgorithm.SHA512224.getName();
    }
}
