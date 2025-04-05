package dev.retrotv.framework.foundation.cryptography.digest.sha;

import dev.retrotv.framework.foundation.cryptography.digest.GeneralDigest;
import dev.retrotv.framework.foundation.cryptography.digest.enums.DigestAlgorithm;

public class SHA3384 extends GeneralDigest {
    public SHA3384() {
        super();
        algorithmName = DigestAlgorithm.SHA3_384.getName();
    }
}
