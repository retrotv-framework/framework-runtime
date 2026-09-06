package dev.retortv.framework.foundation.file.rename;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class UUIDFileRenamePolicyTest {

    @Test
    @DisplayName("유효한 UUID 문자열을 반환한다")
    void test_rename_returnsValidUUID() {
        UUIDFileRenamePolicy policy = new UUIDFileRenamePolicy();

        String renamed = policy.rename(null);

        assertThatCode(() -> UUID.fromString(renamed)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("호출할 때마다 서로 다른 값을 반환한다")
    void test_rename_returnsUniqueValues() {
        UUIDFileRenamePolicy policy = new UUIDFileRenamePolicy();

        String first = policy.rename(null);
        String second = policy.rename(null);

        assertThat(first).isNotEqualTo(second);
    }
}
