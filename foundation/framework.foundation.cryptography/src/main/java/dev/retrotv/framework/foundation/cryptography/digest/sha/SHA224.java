package dev.retrotv.framework.foundation.cryptography.digest.sha;

import dev.retrotv.framework.foundation.cryptography.digest.GeneralDigest;
import dev.retrotv.framework.foundation.cryptography.digest.enums.DigestAlgorithm;

public class SHA224 extends GeneralDigest {
    public SHA224() {
        super();
        algorithmName = DigestAlgorithm.SHA224.getName();
    }
}
