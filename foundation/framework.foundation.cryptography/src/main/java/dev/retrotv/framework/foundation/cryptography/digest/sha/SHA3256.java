package dev.retrotv.framework.foundation.cryptography.digest.sha;

import dev.retrotv.framework.foundation.cryptography.digest.GeneralDigest;
import dev.retrotv.framework.foundation.cryptography.digest.enums.DigestAlgorithm;

public class SHA3256 extends GeneralDigest {
    public SHA3256() {
        super();
        algorithmName = DigestAlgorithm.SHA3_256.getName();
    }
}
