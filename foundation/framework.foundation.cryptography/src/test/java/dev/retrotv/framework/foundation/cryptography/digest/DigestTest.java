package dev.retrotv.framework.foundation.cryptography.digest;

import dev.retrotv.framework.foundation.common.exception.BaseRuntimeException;
import dev.retrotv.framework.foundation.cryptography.digest.sha.SHA1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigestTest {

    @Test
    @DisplayName("StringDigest 예외처리 테스트")
    void test_StringDigestException() {
        SHA1 sha1 = new SHA1();
        String input = "The quick brown fox jumps over the lazy dog";

        assertThrows(BaseRuntimeException.class, () ->
            sha1.digest(input, "unknown-charset")
        );
    }
}
