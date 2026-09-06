package dev.retrotv.framework.foundation.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AbstractServiceTest {

    static class SampleService extends AbstractService {
    }

    @Test
    @DisplayName("AbstractService를 상속받으면 구현 클래스 이름의 Logger를 가진다")
    void test_logIsInitializedWithConcreteClassName() {
        SampleService service = new SampleService();

        assertThat(service.log).isNotNull();
        assertThat(service.log.getName()).isEqualTo(SampleService.class.getName());
    }
}
