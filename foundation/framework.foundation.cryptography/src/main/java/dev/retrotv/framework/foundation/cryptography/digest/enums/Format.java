package dev.retrotv.framework.foundation.cryptography.digest.enums;

import lombok.Getter;

@Getter
public enum Format {
    HEX("HEX"),
    BASE64("BASE64");

    private final String name;

    Format(String name) {
        this.name = name;
    }
}
