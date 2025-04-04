package dev.retrotv.framework.foundation.cryptography.digest;

import lombok.Getter;

@Getter
abstract public class GeneralDigest implements FileDigest, StringDigest {
    protected String algorithmName;
}
