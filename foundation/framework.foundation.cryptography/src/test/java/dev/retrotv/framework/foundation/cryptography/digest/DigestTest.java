package dev.retrotv.framework.foundation.cryptography.digest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigestTest {

    @Test
    @DisplayName("getInstance 싱글톤 테스트")
    void test_getInstance() {
        String input = "test";

        Digest digest1 = Digest.getInstance(Digest.EHash.SHA256);
        assertNotNull(digest1);
        String output1 = digest1.digest(input);

        Digest digest2 = Digest.getInstance(Digest.EHash.SHA256);
        assertNotNull(digest2);
        String output2 = digest2.digest(input);

        assertSame(digest1, digest2);
        assertEquals(output1, output2);

        Digest digest3 = Digest.getInstance(Digest.EHash.SHA512);
        assertNotEquals(output1, digest3.digest(input));
        assertNotEquals(output2, digest3.digest(input));
    }

    @Test
    @DisplayName("Test digest")
    void test_digest() {
        String input = "test";
        Digest digest = Digest.getInstance(Digest.EHash.SHA256);

        String result = digest.digest(input);

        assertNotNull(result);
        assertNotEquals("test", result);

        result = digest.digest(input, Digest.EFormat.HEX);

        assertNotNull(result);
        assertNotEquals("test", result);

        result = digest.digest(input, Digest.EFormat.BASE64);

        assertNotNull(result);
        assertNotEquals("test", result);

        result = digest.digest(input, "BASE64");

        assertNotNull(result);
        assertNotEquals("test", result);

        result = digest.digest(input, "HEX");

        assertNotNull(result);
        assertNotEquals("test", result);
    }
}
