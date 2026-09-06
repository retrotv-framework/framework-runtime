package dev.retrotv.framework.foundation.common.exception.http;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BadRequestExceptionTest {

    @Test
    @DisplayName("기본 생성자는 기본 메시지를 가지며 ResponseErrorException을 상속한다")
    void test_defaultConstructor() {
        BadRequestException ex = new BadRequestException();

        assertThat(ex).isInstanceOf(ResponseErrorException.class);
        assertThat(ex.getMessage()).isEqualTo("잘못된 요청입니다.");
    }

    @Test
    @DisplayName("메시지를 받아 예외를 생성한다")
    void test_messageConstructor() {
        BadRequestException ex = new BadRequestException("파라미터 누락");

        assertThat(ex.getMessage()).isEqualTo("파라미터 누락");
    }

    @Test
    @DisplayName("메시지와 원인 예외를 받아 예외를 생성한다")
    void test_messageAndCauseConstructor() {
        Throwable cause = new IllegalArgumentException("원인");
        BadRequestException ex = new BadRequestException("파라미터 누락", cause);

        assertThat(ex.getMessage()).isEqualTo("파라미터 누락");
        assertThat(ex.getCause()).isSameAs(cause);
    }
}
