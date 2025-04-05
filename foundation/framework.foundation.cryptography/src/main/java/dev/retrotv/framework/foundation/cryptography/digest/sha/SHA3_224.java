package dev.retrotv.framework.foundation.cryptography.digest.sha;

import dev.retrotv.framework.foundation.cryptography.digest.GeneralDigest;
import dev.retrotv.framework.foundation.cryptography.digest.enums.DigestAlgorithm;

public class SHA3_224 extends GeneralDigest {
    public SHA3_224() {
        super();
        algorithmName = DigestAlgorithm.SHA3_224.getName();
    }
}
