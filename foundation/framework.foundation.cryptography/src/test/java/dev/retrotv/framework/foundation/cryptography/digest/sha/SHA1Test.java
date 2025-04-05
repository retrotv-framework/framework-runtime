package dev.retrotv.framework.foundation.cryptography.digest.sha;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SHA1Test {
    
    @Test
    @DisplayName("SHA1 해시 알고리즘 테스트")
    void test_SHA1() throws Exception {
        String input1 = "The quick brown fox jumps over the lazy dog";
        String input2 = "The quick brown fox jumps over the lazy dog!";
 
        SHA1 sha1 = new SHA1();
        byte[] result1 = sha1.digest(input1);
        byte[] result2 = sha1.digest(input2);

        assertNotNull(result1);
        assertNotNull(result2);

        assertNotEquals(result1, result2);

        for (int i = 0; i < 1000; i++) {
            byte[] result3 = sha1.digest(input1);
            assertNotNull(result3);
            assertArrayEquals(result1, result3);
        }
    }
} 