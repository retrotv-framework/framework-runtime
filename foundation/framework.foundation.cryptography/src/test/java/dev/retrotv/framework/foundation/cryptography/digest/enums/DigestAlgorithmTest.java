package dev.retrotv.framework.foundation.cryptography.digest.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DigestAlgorithmTest {

    @Test
    @DisplayName("각 알고리즘 상수는 MessageDigest에서 사용하는 표준 이름을 가진다")
    void test_algorithmNames() {
        assertThat(DigestAlgorithm.CRC32.getName()).isEqualTo("CRC-32");
        assertThat(DigestAlgorithm.CRC32C.getName()).isEqualTo("CRC-32C");
        assertThat(DigestAlgorithm.MD2.getName()).isEqualTo("MD2");
        assertThat(DigestAlgorithm.MD5.getName()).isEqualTo("MD5");
        assertThat(DigestAlgorithm.SHA1.getName()).isEqualTo("SHA-1");
        assertThat(DigestAlgorithm.SHA224.getName()).isEqualTo("SHA-224");
        assertThat(DigestAlgorithm.SHA256.getName()).isEqualTo("SHA-256");
        assertThat(DigestAlgorithm.SHA384.getName()).isEqualTo("SHA-384");
        assertThat(DigestAlgorithm.SHA512.getName()).isEqualTo("SHA-512");
        assertThat(DigestAlgorithm.SHA512224.getName()).isEqualTo("SHA-512/224");
        assertThat(DigestAlgorithm.SHA512256.getName()).isEqualTo("SHA-512/256");
        assertThat(DigestAlgorithm.SHA3_224.getName()).isEqualTo("SHA3-224");
        assertThat(DigestAlgorithm.SHA3_256.getName()).isEqualTo("SHA3-256");
        assertThat(DigestAlgorithm.SHA3_384.getName()).isEqualTo("SHA3-384");
        assertThat(DigestAlgorithm.SHA3_512.getName()).isEqualTo("SHA3-512");
    }

    @Test
    @DisplayName("15개의 알고리즘 상수를 가진다")
    void test_valuesCount() {
        assertThat(DigestAlgorithm.values()).hasSize(15);
    }
}
