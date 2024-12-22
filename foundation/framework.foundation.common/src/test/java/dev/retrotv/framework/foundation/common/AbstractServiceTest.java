package dev.retrotv.framework.foundation.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AbstractServiceTest {

    private static class TestService extends AbstractService {
    }

    @Test
    @DisplayName("AbstractService 상속 테스트")
    void test() {
        TestService testService = new TestService();
        assertThat(testService).isInstanceOf(AbstractService.class);
    }
}
