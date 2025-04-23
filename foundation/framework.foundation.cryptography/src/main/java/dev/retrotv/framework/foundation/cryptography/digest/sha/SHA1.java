package dev.retrotv.framework.foundation.cryptography.digest.sha;

import dev.retrotv.framework.foundation.cryptography.digest.GeneralDigest;
import dev.retrotv.framework.foundation.cryptography.digest.enums.DigestAlgorithm;

public class SHA1 extends GeneralDigest {
    public SHA1() {
        super();
        algorithmName = DigestAlgorithm.SHA1.getName();
    }
}
