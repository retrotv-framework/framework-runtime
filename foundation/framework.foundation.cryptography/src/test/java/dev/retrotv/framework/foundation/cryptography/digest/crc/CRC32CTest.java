package dev.retrotv.framework.foundation.cryptography.digest.crc;

import dev.retrotv.data.utils.ByteUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.retrotv.framework.foundation.cryptography.digest.StringDigest;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.StandardCharsets;

public class CRC32CTest {
    
    @Test
    @DisplayName("CRC32C 체크섬 알고리즘 테스트")
    void test_CRC32C() throws Exception {
        String input1 = "The quick brown fox jumps over the lazy dog";
        String input2 = "The quick brown fox jumps over the lazy dog!";
 
        CRC32C crc32c = new CRC32C();
        byte[] result1 = crc32c.digest(input1);
        byte[] result2 = crc32c.digest(input2);

        assertNotNull(result1);
        assertNotNull(result2);

        assertNotEquals(result1, result2);

        for (int i = 0; i < 1000; i++) {
            byte[] result3 = crc32c.digest(input1);
            assertNotNull(result3);
            assertArrayEquals(result1, result3);
        }
    }

    @Test
    @DisplayName("CRC32C 체크섬 알고리즘 테스트 - 문자열")
    void test_CRC32C_String() throws Exception {
        String input1 = "The quick brown fox jumps over the lazy dog";
        String input2 = "The quick brown fox jumps over the lazy dog!";

        StringDigest crc32c = new CRC32C();
        byte[] result1 = crc32c.digest(input1);
        byte[] result2 = crc32c.digest(input2, "UTF-8");
        byte[] result3 = crc32c.digest(input1, StandardCharsets.UTF_8);

        assertNotNull(result1);
        assertNotNull(result2);
        assertNotNull(result3);

        assertArrayEquals(result1, result3);

        for (int i = 0; i < 1000; i++) {
            byte[] result4 = crc32c.digest(input1);
            assertNotNull(result4);
            assertArrayEquals(result1, result4);
        }
    }
}
