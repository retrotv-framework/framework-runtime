package dev.retrotv.framework.foundation.common.exception.property;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IllegalPropertyExceptionTest {

    @Test
    @DisplayName("기본 생성자는 기본 메시지를 가진다")
    void test_defaultConstructor() {
        IllegalPropertyException ex = new IllegalPropertyException();

        assertThat(ex).isInstanceOf(RuntimeException.class);
        assertThat(ex.getMessage()).isEqualTo("잘못된 프로퍼티 값 입니다.");
    }

    @Test
    @DisplayName("메시지를 받아 예외를 생성한다")
    void test_messageConstructor() {
        IllegalPropertyException ex = new IllegalPropertyException("커스텀 메시지");

        assertThat(ex.getMessage()).isEqualTo("커스텀 메시지");
    }

    @Test
    @DisplayName("메시지와 원인 예외를 받아 예외를 생성한다")
    void test_messageAndCauseConstructor() {
        Throwable cause = new RuntimeException("원인");
        IllegalPropertyException ex = new IllegalPropertyException("커스텀 메시지", cause);

        assertThat(ex.getMessage()).isEqualTo("커스텀 메시지");
        assertThat(ex.getCause()).isSameAs(cause);
    }
}
