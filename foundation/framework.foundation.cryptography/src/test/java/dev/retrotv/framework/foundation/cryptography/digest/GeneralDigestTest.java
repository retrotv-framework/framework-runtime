package dev.retrotv.framework.foundation.cryptography.digest;

import dev.retrotv.framework.foundation.common.exception.BaseRuntimeException;
import dev.retrotv.framework.foundation.cryptography.digest.enums.Format;
import dev.retrotv.framework.foundation.cryptography.digest.md.MD5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GeneralDigestTest {

    private final MD5 md5 = new MD5();
    private final byte[] data = "The quick brown fox jumps over the lazy dog".getBytes();

    @Test
    @DisplayName("포맷을 지정하지 않으면(null) HEX 포맷으로 반환한다")
    void test_digest_nullStringFormatDefaultsToHex() {
        String withNull = md5.digest(data, (String) null);
        String withHex = md5.digest(data, "HEX");

        assertThat(withNull).isEqualTo(withHex);
    }

    @Test
    @DisplayName("Format이 null이면 HEX 포맷으로 반환한다")
    void test_digest_nullFormatEnumDefaultsToHex() {
        String withNull = md5.digest(data, (Format) null);
        String withHex = md5.digest(data, Format.HEX);

        assertThat(withNull).isEqualTo(withHex);
    }

    @Test
    @DisplayName("문자열 포맷과 열거형 포맷은 대소문자에 관계없이 동일한 결과를 반환한다")
    void test_digest_stringAndEnumFormatsMatch() {
        assertThat(md5.digest(data, "hex")).isEqualTo(md5.digest(data, Format.HEX));
        assertThat(md5.digest(data, "base64")).isEqualTo(md5.digest(data, Format.BASE64));
    }

    @Test
    @DisplayName("HEX 포맷은 16진수 문자열을 반환한다")
    void test_digest_hexFormat() {
        String hex = md5.digest(data, Format.HEX);

        assertThat(hex).matches("^[0-9a-fA-F]+$");
        assertThat(hex.length()).isEqualTo(32);
    }

    @Test
    @DisplayName("BASE64 포맷은 base64 문자열을 반환한다")
    void test_digest_base64Format() {
        String base64 = md5.digest(data, Format.BASE64);

        assertThat(base64).matches("^[A-Za-z0-9+/]+=*$");
    }

    @Test
    @DisplayName("지원하지 않는 문자열 포맷을 전달하면 예외가 발생한다")
    void test_digest_unsupportedStringFormatThrows() {
        assertThatThrownBy(() -> md5.digest(data, "unknown-format"))
            .isInstanceOf(BaseRuntimeException.class);
    }
}
