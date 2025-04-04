package dev.retrotv.framework.foundation.common.response;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SingleDataResponseTest {

    @Test
    @DisplayName("SingleDataResponse 기본 생성자 테스트")
    void test_singleDataResponseConstructor1() {
        DataResponse<String> response = new SingleDataResponse<>("테스트 데이터");
        assertTrue(response.isSuccess());
        assertEquals("정상적으로 처리되었습니다.", response.getMessage());
        assertEquals("테스트 데이터", response.getData());
        assertEquals(HttpStatus.OK, response.getHttpStatus());
        assertEquals(200, response.getHttpStatusCode());
    }

    @Test
    @DisplayName("SingleDataResponse(String message) 생성자 테스트")
    void test_singleDataResponseConstructor2() {
        DataResponse<String> response = new SingleDataResponse<>("테스트 메시지", "테스트 데이터");
        assertTrue(response.isSuccess());
        assertEquals("테스트 메시지", response.getMessage());
        assertEquals("테스트 데이터", response.getData());
        assertEquals(HttpStatus.OK, response.getHttpStatus());
        assertEquals(200, response.getHttpStatusCode());
    }

    @Test
    @DisplayName("SingleDataResponse(String message, int httpStatusCode) 생성자 테스트")
    void test_singleDataResponseConstructor3() {
        DataResponse<String> response = new SingleDataResponse<>("테스트 메시지", "테스트 데이터", HttpStatus.BAD_REQUEST.value());
        assertTrue(response.isSuccess());
        assertEquals("테스트 메시지", response.getMessage());
        assertEquals("테스트 데이터", response.getData());
        assertEquals(HttpStatus.BAD_REQUEST, response.getHttpStatus());
        assertEquals(400, response.getHttpStatusCode());
    }

    @Test
    @DisplayName("SingleDataResponse(String message, HttpStatus httpStatus) 생성자 테스트")
    void test_singleDataResponseConstructor4() {
        DataResponse<String> response = new SingleDataResponse<>("테스트 메시지", "테스트 데이터", HttpStatus.BAD_REQUEST);
        assertTrue(response.isSuccess());
        assertEquals("테스트 메시지", response.getMessage());
        assertEquals("테스트 데이터", response.getData());
        assertEquals(HttpStatus.BAD_REQUEST, response.getHttpStatus());
        assertEquals(400, response.getHttpStatusCode());
    }

    @Test
    @DisplayName("SingleDataResponse 제네릭 테스트")
    void test_singleDataResponseGeneric() {
        DataResponse<String> response = new SingleDataResponse<>("테스트 데이터");
        assertEquals("테스트 데이터", response.getData());
        assertEquals(String.class, response.getData().getClass());

        DataResponse<Integer> intResponse = new SingleDataResponse<>(123);
        assertEquals(123, intResponse.getData());
        assertEquals(Integer.class, intResponse.getData().getClass());

        DataResponse<Double> doubleResponse = new SingleDataResponse<>(123.45);
        assertEquals(123.45, doubleResponse.getData());
        assertEquals(Double.class, doubleResponse.getData().getClass());

        DataResponse<Boolean> booleanResponse = new SingleDataResponse<>(true);
        assertEquals(true, booleanResponse.getData());
        assertEquals(Boolean.class, booleanResponse.getData().getClass());

        DataResponse<Map<String, String>> mapResponse = new SingleDataResponse<>(Map.of("key", "value"));
        assertEquals(Map.of("key", "value"), mapResponse.getData());
        assertInstanceOf(Map.class, mapResponse.getData());

        DataResponse<Object> objectResponse = new SingleDataResponse<>(new Object());
        assertEquals(Object.class, objectResponse.getData().getClass());
    }
}
