package dev.retrotv.framework.foundation.cryptography.digest.enums;

import lombok.Getter;

@Getter
public enum DigestAlgorithm {
    CRC32("CRC-32"),
    CRC32C("CRC-32C"),
    MD2("MD2"),
    MD5("MD5"),
    SHA1("SHA-1"),
    SHA224("SHA-224"),
    SHA256("SHA-256"),
    SHA384("SHA-384"),
    SHA512("SHA-512"),
    SHA512224("SHA-512/224"),
    SHA512256("SHA-512/256"),
    SHA3_224("SHA3-224"),
    SHA3_256("SHA3-256"),
    SHA3_384("SHA3-384"),
    SHA3_512("SHA3-512");

    private final String name;

    DigestAlgorithm(String name) {
        this.name = name;
    }
}
