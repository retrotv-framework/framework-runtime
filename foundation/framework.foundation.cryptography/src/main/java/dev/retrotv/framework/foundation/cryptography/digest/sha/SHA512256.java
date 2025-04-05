package dev.retrotv.framework.foundation.cryptography.digest.sha;

import dev.retrotv.framework.foundation.cryptography.digest.GeneralDigest;
import dev.retrotv.framework.foundation.cryptography.digest.enums.DigestAlgorithm;

public class SHA512256 extends GeneralDigest {
    public SHA512256() {
        super();
        algorithmName = DigestAlgorithm.SHA512256.getName();
    }
}
