package dev.retrotv.framework.foundation.common.response;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

class ErrorResponseTest {

    @Test
    @DisplayName("기본 생성자는 실패, 기본 메시지, 500 오류를 반환한다")
    void test_defaultConstructor() {
        ErrorResponse response = new ErrorResponse();

        assertThat(response.isSuccess()).isFalse();
        assertThat(response.getMessage()).isEqualTo("요청을 처리하는 중 오류가 발생했습니다.");
        assertThat(response.getReasonPhrase()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    @Test
    @DisplayName("메시지를 받으면 해당 메시지와 500 오류를 반환한다")
    void test_messageConstructor() {
        ErrorResponse response = new ErrorResponse("커스텀 에러");

        assertThat(response.isSuccess()).isFalse();
        assertThat(response.getMessage()).isEqualTo("커스텀 에러");
        assertThat(response.getReasonPhrase()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    @Test
    @DisplayName("메시지와 int형 상태코드를 받으면 해당 값으로 응답을 생성한다")
    void test_messageAndIntStatusConstructor() {
        ErrorResponse response = new ErrorResponse("잘못된 요청", 400);

        assertThat(response.isSuccess()).isFalse();
        assertThat(response.getMessage()).isEqualTo("잘못된 요청");
        assertThat(response.getReasonPhrase()).isEqualTo(HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @Test
    @DisplayName("메시지와 HttpStatus를 받으면 해당 값으로 응답을 생성한다")
    void test_messageAndHttpStatusConstructor() {
        ErrorResponse response = new ErrorResponse("권한 없음", HttpStatus.FORBIDDEN);

        assertThat(response.isSuccess()).isFalse();
        assertThat(response.getMessage()).isEqualTo("권한 없음");
        assertThat(response.getReasonPhrase()).isEqualTo(HttpStatus.FORBIDDEN.getReasonPhrase());
    }
}
