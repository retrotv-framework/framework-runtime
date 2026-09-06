package dev.retrotv.framework.foundation.common.exception.http;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccessDeniedExceptionTest {

    @Test
    @DisplayName("기본 생성자는 기본 메시지를 가지며 ResponseErrorException을 상속한다")
    void test_defaultConstructor() {
        AccessDeniedException ex = new AccessDeniedException();

        assertThat(ex).isInstanceOf(ResponseErrorException.class);
        assertThat(ex.getMessage()).isEqualTo("접근 권한이 없습니다.");
    }

    @Test
    @DisplayName("메시지를 받아 예외를 생성한다")
    void test_messageConstructor() {
        AccessDeniedException ex = new AccessDeniedException("관리자만 접근 가능");

        assertThat(ex.getMessage()).isEqualTo("관리자만 접근 가능");
    }

    @Test
    @DisplayName("메시지와 원인 예외를 받아 예외를 생성한다")
    void test_messageAndCauseConstructor() {
        Throwable cause = new SecurityException("원인");
        AccessDeniedException ex = new AccessDeniedException("관리자만 접근 가능", cause);

        assertThat(ex.getMessage()).isEqualTo("관리자만 접근 가능");
        assertThat(ex.getCause()).isSameAs(cause);
    }
}
