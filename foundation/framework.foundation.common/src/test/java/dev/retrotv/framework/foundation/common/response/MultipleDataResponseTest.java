package dev.retrotv.framework.foundation.common.response;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MultipleDataResponseTest {

    @Test
    @DisplayName("데이터 리스트를 받으면 개수와 데이터를 정상적으로 반환한다")
    void test_dataOnlyConstructor() {
        List<String> data = List.of("a", "b", "c");
        MultipleDataResponse<List<String>, String> response = new MultipleDataResponse<>(data);

        assertThat(response.isSuccess()).isTrue();
        assertThat(response.getData()).containsExactly("a", "b", "c");
        assertThat(response.getDataSize()).isEqualTo(3);
    }

    @Test
    @DisplayName("데이터가 null이면 개수는 0을 반환한다")
    void test_nullData_dataSizeIsZero() {
        MultipleDataResponse<List<String>, String> response = new MultipleDataResponse<>(null);

        assertThat(response.getData()).isNull();
        assertThat(response.getDataSize()).isZero();
    }

    @Test
    @DisplayName("메시지, 데이터, int형 상태코드를 받으면 해당 값으로 응답을 생성한다")
    void test_messageDataAndIntStatusConstructor() {
        List<Integer> data = List.of(1, 2);
        MultipleDataResponse<List<Integer>, Integer> response =
            new MultipleDataResponse<>("조회 완료", 200, data);

        assertThat(response.getMessage()).isEqualTo("조회 완료");
        assertThat(response.getDataSize()).isEqualTo(2);
        assertThat(response.getReasonPhrase()).isEqualTo(HttpStatus.OK.getReasonPhrase());
    }

    @Test
    @DisplayName("메시지, 데이터, HttpStatus를 받으면 해당 값으로 응답을 생성한다")
    void test_messageDataAndHttpStatusConstructor() {
        List<Integer> data = List.of(1, 2, 3);
        MultipleDataResponse<List<Integer>, Integer> response =
            new MultipleDataResponse<>("조회 완료", HttpStatus.OK, data);

        assertThat(response.getDataSize()).isEqualTo(3);
        assertThat(response.getReasonPhrase()).isEqualTo(HttpStatus.OK.getReasonPhrase());
    }
}
