package dev.retrotv.framework.foundation.cryptography.hash;

import dev.retrotv.crypto.enums.EHash;
import dev.retrotv.crypto.util.CodecUtils;
import org.springframework.util.StringUtils;

public class Hash {
    private final dev.retrotv.crypto.hash.Hash hash;

    public Hash(EHash hashAlgorithm) {
        this.hash = dev.retrotv.crypto.hash.Hash.getInstance(hashAlgorithm);
    }

    public String digest(String input) {
        return CodecUtils.encode(this.hash.hash(input));
    }
}
