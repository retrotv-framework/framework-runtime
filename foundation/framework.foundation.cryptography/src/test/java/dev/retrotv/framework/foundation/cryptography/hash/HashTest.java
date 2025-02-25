package dev.retrotv.framework.foundation.cryptography.hash;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTest {

    @Test
    @DisplayName("getInstance 싱글톤 테스트")
    void test_getInstance() {
        String input = "test";

        Hash hash1 = Hash.getInstance(Hash.EHash.SHA256);
        assertNotNull(hash1);
        String output1 = hash1.digest(input);

        Hash hash2 = Hash.getInstance(Hash.EHash.SHA256);
        assertNotNull(hash2);
        String output2 = hash2.digest(input);

        assertSame(hash1, hash2);
        assertEquals(output1, output2);

        Hash hash3 = Hash.getInstance(Hash.EHash.SHA512);
        assertNotEquals(output1, hash3.digest(input));
        assertNotEquals(output2, hash3.digest(input));
    }

    @Test
    @DisplayName("Test digest")
    void test_digest() {
        String input = "test";
        Hash hash = Hash.getInstance(Hash.EHash.SHA256);

        String result = hash.digest(input);

        assertNotNull(result);
        assertNotEquals("test", result);

        result = hash.digest(input, Hash.EFormat.HEX);

        assertNotNull(result);
        assertNotEquals("test", result);

        result = hash.digest(input, Hash.EFormat.BASE64);

        assertNotNull(result);
        assertNotEquals("test", result);

        result = hash.digest(input, "BASE64");

        assertNotNull(result);
        assertNotEquals("test", result);

        result = hash.digest(input, "HEX");

        assertNotNull(result);
        assertNotEquals("test", result);
    }
}
