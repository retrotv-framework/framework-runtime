package dev.retrotv.framework.foundation.cryptography.digest.sha;

import dev.retrotv.framework.foundation.cryptography.digest.GeneralDigest;
import dev.retrotv.framework.foundation.cryptography.digest.enums.DigestAlgorithm;

public class SHA3512 extends GeneralDigest {
    public SHA3512() {
        super();
        algorithmName = DigestAlgorithm.SHA3_512.getName();
    }
}
