package dev.retrotv.framework.foundation.common.exception.http;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AuthFailExceptionTest {

    @Test
    @DisplayName("기본 생성자는 기본 메시지를 가지며 ResponseErrorException을 상속한다")
    void test_defaultConstructor() {
        AuthFailException ex = new AuthFailException();

        assertThat(ex).isInstanceOf(ResponseErrorException.class);
        assertThat(ex.getMessage()).isEqualTo("접근하기 위한 인증 자격이 없습니다.");
    }

    @Test
    @DisplayName("메시지를 받아 예외를 생성한다")
    void test_messageConstructor() {
        AuthFailException ex = new AuthFailException("토큰 만료");

        assertThat(ex.getMessage()).isEqualTo("토큰 만료");
    }

    @Test
    @DisplayName("메시지와 원인 예외를 받아 예외를 생성한다")
    void test_messageAndCauseConstructor() {
        Throwable cause = new IllegalStateException("원인");
        AuthFailException ex = new AuthFailException("토큰 만료", cause);

        assertThat(ex.getMessage()).isEqualTo("토큰 만료");
        assertThat(ex.getCause()).isSameAs(cause);
    }
}
