package dev.retrotv.framework.foundation.cryptography.hash;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTest {

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
