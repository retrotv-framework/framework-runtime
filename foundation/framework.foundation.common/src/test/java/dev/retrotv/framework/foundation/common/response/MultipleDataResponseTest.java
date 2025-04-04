package dev.retrotv.framework.foundation.common.response;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultipleDataResponseTest {

    @Test
    @DisplayName("MultipleDataResponse 기본 생성자 테스트")
    void test_multipleDataResponseConstructor1() {
        List<String> data = List.of("테스트 데이터1", "테스트 데이터2", "테스트 데이터3");
        MultipleDataResponse<List<String>, String> response = new MultipleDataResponse<>(data);
        assertTrue(response.isSuccess());
        assertEquals("정상적으로 처리되었습니다.", response.getMessage());
        assertIterableEquals(data, response.getData());
        assertEquals(HttpStatus.OK, response.getHttpStatus());
        assertEquals(200, response.getHttpStatusCode());
        assertEquals(3, response.getDataSize());
    }

    @Test
    @DisplayName("MultipleDataResponse(String message) 생성자 테스트")
    void test_multipleDataResponseConstructor2() {
        List<String> data = List.of("테스트 데이터1", "테스트 데이터2", "테스트 데이터3");
        MultipleDataResponse<List<String>, String> response = new MultipleDataResponse<>("테스트 메시지", data);
        assertTrue(response.isSuccess());
        assertEquals("테스트 메시지", response.getMessage());
        assertIterableEquals(data, response.getData());
        assertEquals(HttpStatus.OK, response.getHttpStatus());
        assertEquals(200, response.getHttpStatusCode());
        assertEquals(3, response.getDataSize());
    }

    @Test
    @DisplayName("MultipleDataResponse(String message, int httpStatusCode) 생성자 테스트")
    void test_multipleDataResponseConstructor3() {
        List<String> data = List.of("테스트 데이터1", "테스트 데이터2", "테스트 데이터3");
        MultipleDataResponse<List<String>, String> response = new MultipleDataResponse<>("테스트 메시지", HttpStatus.BAD_REQUEST.value(), data);
        assertTrue(response.isSuccess());
        assertEquals("테스트 메시지", response.getMessage());
        assertIterableEquals(data, response.getData());
        assertEquals(HttpStatus.BAD_REQUEST, response.getHttpStatus());
        assertEquals(400, response.getHttpStatusCode());
        assertEquals(3, response.getDataSize());
    }

    @Test
    @DisplayName("MultipleDataResponse(String message, HttpStatus httpStatus) 생성자 테스트")
    void test_multipleDataResponseConstructor4() {
        List<String> data = List.of("테스트 데이터1", "테스트 데이터2", "테스트 데이터3");
        MultipleDataResponse<List<String>, String> response = new MultipleDataResponse<>("테스트 메시지", HttpStatus.BAD_REQUEST, data);
        assertTrue(response.isSuccess());
        assertEquals("테스트 메시지", response.getMessage());
        assertIterableEquals(data, response.getData());
        assertEquals(HttpStatus.BAD_REQUEST, response.getHttpStatus());
        assertEquals(400, response.getHttpStatusCode());
        assertEquals(3, response.getDataSize());
    }
}
