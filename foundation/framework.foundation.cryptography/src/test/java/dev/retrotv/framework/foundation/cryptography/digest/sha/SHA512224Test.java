package dev.retrotv.framework.foundation.cryptography.digest.sha;

import dev.retrotv.framework.foundation.cryptography.digest.StringDigest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class SHA512224Test {
    
    @Test
    @DisplayName("SHA512/224 해시 알고리즘 테스트")
    void test_SHA512224() {
        String input1 = "The quick brown fox jumps over the lazy dog";
        String input2 = "The quick brown fox jumps over the lazy dog!";
 
        SHA512224 sha512224 = new SHA512224();
        byte[] result1 = sha512224.digest(input1);
        byte[] result2 = sha512224.digest(input2);

        assertNotNull(result1);
        assertNotNull(result2);

        assertNotEquals(result1, result2);

        for (int i = 0; i < 1000; i++) {
            byte[] result3 = sha512224.digest(input1);
            assertNotNull(result3);
            assertArrayEquals(result1, result3);
        }
    }

    @Test
    @DisplayName("SHA512/224 해시 알고리즘 테스트 - 문자열")
    void test_SHA512224_String() {
        String input1 = "The quick brown fox jumps over the lazy dog";
        String input2 = "The quick brown fox jumps over the lazy dog!";

        StringDigest sha512224 = new SHA512224();
        byte[] result1 = sha512224.digest(input1);
        byte[] result2 = sha512224.digest(input2, "UTF-8");
        byte[] result3 = sha512224.digest(input1, StandardCharsets.UTF_8);

        assertNotNull(result1);
        assertNotNull(result2);
        assertNotNull(result3);

        assertArrayEquals(result1, result3);

        for (int i = 0; i < 1000; i++) {
            byte[] result4 = sha512224.digest(input1);
            assertNotNull(result4);
            assertArrayEquals(result1, result4);
        }
    }
} 