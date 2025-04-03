package dev.retrotv.framework.foundation.cryptography.digest.sha;

import dev.retrotv.framework.foundation.cryptography.digest.enums.DigestAlgorithm;

public class SHA1 {
    private static final String algorithm = DigestAlgorithm.SHA1.getName();

    public SHA1() {

    }

    public String getAlgorithmName() {
        return algorithm;
    }
}
