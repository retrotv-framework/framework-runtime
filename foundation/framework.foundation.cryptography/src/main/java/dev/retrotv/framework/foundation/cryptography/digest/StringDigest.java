package dev.retrotv.framework.foundation.cryptography.digest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import dev.retrotv.framework.foundation.common.exception.BaseRuntimeException;

public interface StringDigest extends BinaryDigest {
    default byte[] digest(String str) {
        try {
            return digest(str.getBytes(StandardCharsets.UTF_8));
        } catch (IOException ex) {
            throw new BaseRuntimeException("문자열을 읽을 수 없습니다.", ex);
        }
    }

    default byte[] digest(String str, String charset) {
        try {
            return digest(str.getBytes(charset));
        } catch (UnsupportedEncodingException ex ) {
            throw new BaseRuntimeException("지원하지 않는 캐릭터 셋 입니다", ex);
        } catch (IOException ex) {
            throw new BaseRuntimeException("문자열을 읽을 수 없습니다.", ex);
        }
    }

    default byte[] digest(String str, Charset charset) {
        try {
            return digest(str.getBytes(charset));
        } catch (IOException ex) {
            throw new BaseRuntimeException("문자열을 읽을 수 없습니다.", ex);
        }
    }
}
