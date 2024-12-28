package dev.retrotv.framework.foundation.cryptography.hash;

import dev.retrotv.crypto.enums.EHash;
import dev.retrotv.framework.foundation.cryptography.hash.Hash;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTest {

    @Test
    @DisplayName("Test digest")
    void test_digest() {

        // Given
        String input = "test";
        Hash hash = new Hash(EHash.SHA256);

        // When
        String result = hash.digest(input);

        // Then
        assertNotNull(result);
        assertNotEquals("test", result);
    }
}
