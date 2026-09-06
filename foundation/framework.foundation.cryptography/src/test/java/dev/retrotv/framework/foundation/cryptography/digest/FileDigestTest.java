package dev.retrotv.framework.foundation.cryptography.digest;

import dev.retrotv.framework.foundation.common.exception.BaseRuntimeException;
import dev.retrotv.framework.foundation.cryptography.digest.md.MD5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FileDigestTest {

    @TempDir
    Path tempDir;

    private final MD5 md5 = new MD5();

    @Test
    @DisplayName("파일의 내용을 읽어 바이트 배열과 동일한 다이제스트를 계산한다")
    void test_digest_file() throws IOException {
        String content = "The quick brown fox jumps over the lazy dog";
        Path file = tempDir.resolve("sample.txt");
        Files.writeString(file, content, StandardCharsets.UTF_8);

        byte[] fromFile = md5.digest(file.toFile());
        byte[] fromBytes = md5.digest(content.getBytes(StandardCharsets.UTF_8));

        assertThat(fromFile).isEqualTo(fromBytes);
    }

    @Test
    @DisplayName("존재하지 않는 파일을 전달하면 예외가 발생한다")
    void test_digest_fileNotFoundThrows() {
        File notExist = new File(tempDir.toFile(), "does-not-exist.txt");

        assertThatThrownBy(() -> md5.digest(notExist))
            .isInstanceOf(BaseRuntimeException.class);
    }
}
