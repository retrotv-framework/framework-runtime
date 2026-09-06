package dev.retrotv.framework.foundation.common.response;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

class SingleDataResponseTest {

    @Test
    @DisplayName("데이터만 받으면 기본 메시지, 200 OK, 데이터를 반환한다")
    void test_dataOnlyConstructor() {
        SingleDataResponse<String> response = new SingleDataResponse<>("hello");

        assertThat(response.isSuccess()).isTrue();
        assertThat(response.getMessage()).isEqualTo("정상적으로 처리되었습니다.");
        assertThat(response.getReasonPhrase()).isEqualTo(HttpStatus.OK.getReasonPhrase());
        assertThat(response.getData()).isEqualTo("hello");
    }

    @Test
    @DisplayName("메시지와 데이터를 받으면 해당 메시지와 데이터를 반환한다")
    void test_messageAndDataConstructor() {
        SingleDataResponse<Integer> response = new SingleDataResponse<>("조회 완료", 42);

        assertThat(response.getMessage()).isEqualTo("조회 완료");
        assertThat(response.getData()).isEqualTo(42);
    }

    @Test
    @DisplayName("메시지, 데이터, int형 상태코드를 받으면 해당 값으로 응답을 생성한다")
    void test_messageDataAndIntStatusConstructor() {
        SingleDataResponse<String> response = new SingleDataResponse<>("생성됨", "data", 201);

        assertThat(response.getMessage()).isEqualTo("생성됨");
        assertThat(response.getData()).isEqualTo("data");
        assertThat(response.getReasonPhrase()).isEqualTo(HttpStatus.CREATED.getReasonPhrase());
    }

    @Test
    @DisplayName("메시지, 데이터, HttpStatus를 받으면 해당 값으로 응답을 생성한다")
    void test_messageDataAndHttpStatusConstructor() {
        SingleDataResponse<String> response = new SingleDataResponse<>("생성됨", "data", HttpStatus.CREATED);

        assertThat(response.getMessage()).isEqualTo("생성됨");
        assertThat(response.getData()).isEqualTo("data");
        assertThat(response.getReasonPhrase()).isEqualTo(HttpStatus.CREATED.getReasonPhrase());
    }

    @Test
    @DisplayName("데이터가 null이어도 예외없이 처리된다")
    void test_nullData() {
        SingleDataResponse<String> response = new SingleDataResponse<>(null);

        assertThat(response.getData()).isNull();
    }
}
