package dev.retrotv.framework.foundation.cryptography.digest.sha;

import dev.retrotv.framework.foundation.cryptography.digest.GeneralDigest;
import dev.retrotv.framework.foundation.cryptography.digest.enums.DigestAlgorithm;

public class SHA256 extends GeneralDigest {
    public SHA256() {
        super();
        algorithmName = DigestAlgorithm.SHA256.getName();
    }
}
