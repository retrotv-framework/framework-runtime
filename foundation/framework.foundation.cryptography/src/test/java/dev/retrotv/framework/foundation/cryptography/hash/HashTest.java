package dev.retrotv.framework.foundation.cryptography.hash;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTest {

    @Test
    @DisplayName("Test digest")
    void test_digest() {

        // Given
        String input = "test";
        Hash hash = Hash.getInstance(Hash.EHash.SHA256);

        // When
        String result = hash.digest(input);

        // Then
        assertNotNull(result);
        assertNotEquals("test", result);
    }
}
