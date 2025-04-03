package dev.retrotv.framework.foundation.cryptography.hash;

import java.io.IOException;

import dev.retrotv.framework.foundation.common.exception.BaseException;

public interface StringHash extends BinaryHash {
    default byte[] digest(String str) {
        try {
            return digest(str.getBytes());
        } catch (IOException ex) {
            throw new BaseException("문자열을 읽을 수 없습니다.", ex);
        }
    }
}
