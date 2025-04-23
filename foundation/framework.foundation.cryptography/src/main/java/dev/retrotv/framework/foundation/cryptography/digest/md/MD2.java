package dev.retrotv.framework.foundation.cryptography.digest.md;

import dev.retrotv.framework.foundation.cryptography.digest.GeneralDigest;
import dev.retrotv.framework.foundation.cryptography.digest.enums.DigestAlgorithm;

public class MD2 extends GeneralDigest {
    public MD2() {
        super();
        algorithmName = DigestAlgorithm.MD2.getName();
    }
}
