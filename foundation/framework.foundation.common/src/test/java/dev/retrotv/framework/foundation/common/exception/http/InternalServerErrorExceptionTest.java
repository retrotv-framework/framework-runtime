package dev.retrotv.framework.foundation.common.exception.http;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InternalServerErrorExceptionTest {

    @Test
    @DisplayName("기본 생성자는 기본 메시지를 가지며 ResponseErrorException을 상속한다")
    void test_defaultConstructor() {
        InternalServerErrorException ex = new InternalServerErrorException();

        assertThat(ex).isInstanceOf(ResponseErrorException.class);
        assertThat(ex.getMessage())
            .isEqualTo("원인을 알 수 없는 오류가 발생했습니다.\n해당 오류가 지속적으로 발생할 경우, 관리자에게 문의해 주십시오.");
    }

    @Test
    @DisplayName("메시지를 받아 예외를 생성한다")
    void test_messageConstructor() {
        InternalServerErrorException ex = new InternalServerErrorException("DB 연결 실패");

        assertThat(ex.getMessage()).isEqualTo("DB 연결 실패");
    }

    @Test
    @DisplayName("메시지와 원인 예외를 받아 예외를 생성한다")
    void test_messageAndCauseConstructor() {
        Throwable cause = new RuntimeException("원인");
        InternalServerErrorException ex = new InternalServerErrorException("DB 연결 실패", cause);

        assertThat(ex.getMessage()).isEqualTo("DB 연결 실패");
        assertThat(ex.getCause()).isSameAs(cause);
    }
}
