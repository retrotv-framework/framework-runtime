package dev.retrotv.framework.foundation.cryptography.digest.sha;

import dev.retrotv.framework.foundation.cryptography.digest.GeneralDigest;
import dev.retrotv.framework.foundation.cryptography.digest.enums.DigestAlgorithm;

public class SHA512 extends GeneralDigest {
    public SHA512() {
        super();
        algorithmName = DigestAlgorithm.SHA512.getName();
    }
}
