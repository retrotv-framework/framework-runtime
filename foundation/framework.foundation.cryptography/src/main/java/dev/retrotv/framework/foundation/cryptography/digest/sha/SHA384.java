package dev.retrotv.framework.foundation.cryptography.digest.sha;

import dev.retrotv.framework.foundation.cryptography.digest.GeneralDigest;
import dev.retrotv.framework.foundation.cryptography.digest.enums.DigestAlgorithm;

public class SHA384 extends GeneralDigest {
    public SHA384() {
        super();
        algorithmName = DigestAlgorithm.SHA384.getName();
    }
}
