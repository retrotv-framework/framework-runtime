package dev.retortv.framework.foundation.file.rename;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class DefaultFileRenamePolicyTest {

    @Test
    @DisplayName("현재 시각(epoch millis)을 문자열로 반환한다")
    void test_rename_returnsCurrentTimeMillis() {
        DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();

        long before = System.currentTimeMillis();
        String renamed = policy.rename(null);
        long after = System.currentTimeMillis();

        assertThatCode(() -> Long.parseLong(renamed)).doesNotThrowAnyException();
        long value = Long.parseLong(renamed);
        assertThat(value).isBetween(before, after);
    }
}
