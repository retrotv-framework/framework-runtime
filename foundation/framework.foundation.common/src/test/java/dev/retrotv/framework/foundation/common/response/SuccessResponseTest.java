package dev.retrotv.framework.foundation.common.response;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

class SuccessResponseTest {

    @Test
    @DisplayName("기본 생성자는 성공, 기본 메시지, 200 OK를 반환한다")
    void test_defaultConstructor() {
        SuccessResponse response = new SuccessResponse();

        assertThat(response.isSuccess()).isTrue();
        assertThat(response.getMessage()).isEqualTo("정상적으로 처리되었습니다.");
        assertThat(response.getReasonPhrase()).isEqualTo(HttpStatus.OK.getReasonPhrase());
    }

    @Test
    @DisplayName("메시지를 받으면 해당 메시지와 200 OK를 반환한다")
    void test_messageConstructor() {
        SuccessResponse response = new SuccessResponse("처리 완료");

        assertThat(response.isSuccess()).isTrue();
        assertThat(response.getMessage()).isEqualTo("처리 완료");
        assertThat(response.getReasonPhrase()).isEqualTo(HttpStatus.OK.getReasonPhrase());
    }

    @Test
    @DisplayName("메시지와 int형 상태코드를 받으면 해당 값으로 응답을 생성한다")
    void test_messageAndIntStatusConstructor() {
        SuccessResponse response = new SuccessResponse("생성됨", 201);

        assertThat(response.isSuccess()).isTrue();
        assertThat(response.getMessage()).isEqualTo("생성됨");
        assertThat(response.getReasonPhrase()).isEqualTo(HttpStatus.CREATED.getReasonPhrase());
    }

    @Test
    @DisplayName("메시지와 HttpStatus를 받으면 해당 값으로 응답을 생성한다")
    void test_messageAndHttpStatusConstructor() {
        SuccessResponse response = new SuccessResponse("생성됨", HttpStatus.CREATED);

        assertThat(response.isSuccess()).isTrue();
        assertThat(response.getMessage()).isEqualTo("생성됨");
        assertThat(response.getReasonPhrase()).isEqualTo(HttpStatus.CREATED.getReasonPhrase());
    }
}
