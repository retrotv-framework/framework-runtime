package dev.retrotv.framework.foundation.cryptography.digest;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import dev.retrotv.framework.foundation.common.exception.BaseRuntimeException;

public interface StringDigest extends BinaryDigest {
    default byte[] digest(String str) {
        return digest(str.getBytes(StandardCharsets.UTF_8));
    }

    default byte[] digest(String str, String charset) {
        try {
            return digest(str.getBytes(charset));
        } catch (UnsupportedEncodingException ex ) {
            throw new BaseRuntimeException("지원하지 않는 캐릭터 셋 입니다", ex);
        }
    }

    default byte[] digest(String str, Charset charset) {
        return digest(str.getBytes(charset));
    }
}
