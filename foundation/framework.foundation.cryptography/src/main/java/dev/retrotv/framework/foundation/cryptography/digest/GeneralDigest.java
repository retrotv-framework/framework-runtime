package dev.retrotv.framework.foundation.cryptography.digest;

abstract public class GeneralDigest implements FileDigest, StringDigest {
    protected String algorithmName;

    public String getAlgorithmName() {
        return algorithmName;
    }
}
