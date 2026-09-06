package dev.retrotv.framework.foundation.common.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseRuntimeExceptionTest {

    @Test
    @DisplayName("메시지를 받아 예외를 생성한다")
    void test_messageConstructor() {
        BaseRuntimeException ex = new BaseRuntimeException("에러 발생");

        assertThat(ex).isInstanceOf(RuntimeException.class);
        assertThat(ex.getMessage()).isEqualTo("에러 발생");
        assertThat(ex.getCause()).isNull();
    }

    @Test
    @DisplayName("메시지와 원인 예외를 받아 예외를 생성한다")
    void test_messageAndCauseConstructor() {
        Throwable cause = new IllegalStateException("원인");
        BaseRuntimeException ex = new BaseRuntimeException("에러 발생", cause);

        assertThat(ex.getMessage()).isEqualTo("에러 발생");
        assertThat(ex.getCause()).isSameAs(cause);
    }
}
