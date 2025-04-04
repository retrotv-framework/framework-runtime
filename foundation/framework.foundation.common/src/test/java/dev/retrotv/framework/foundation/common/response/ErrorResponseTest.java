package dev.retrotv.framework.foundation.common.response;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class ErrorResponseTest {

    @Test
    @DisplayName("ErrorResponse 기본 생성자 테스트")
    void test_errorResponseConstructor1() {
        ErrorResponse response = new ErrorResponse();
        assertFalse(response.isSuccess());
        assertEquals("요청을 처리하는 중 오류가 발생했습니다.", response.getMessage());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getHttpStatus());
        assertEquals(500, response.getHttpStatusCode());
    }

    @Test
    @DisplayName("ErrorResponse(String message) 생성자 테스트")
    void test_errorResponseConstructor2() {
        ErrorResponse response = new ErrorResponse("테스트 메시지");
        assertFalse(response.isSuccess());
        assertEquals("테스트 메시지", response.getMessage());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getHttpStatus());
        assertEquals(500, response.getHttpStatusCode());
    }

    @Test
    @DisplayName("ErrorResponse(String message, int httpStatusCode) 생성자 테스트")
    void test_errorResponseConstructor3() {
        ErrorResponse response = new ErrorResponse("테스트 메시지", HttpStatus.BAD_REQUEST.value());
        assertFalse(response.isSuccess());
        assertEquals("테스트 메시지", response.getMessage());
        assertEquals(HttpStatus.BAD_REQUEST, response.getHttpStatus());
        assertEquals(400, response.getHttpStatusCode());
    }

    @Test
    @DisplayName("ErrorResponse(String message, HttpStatus httpStatus) 생성자 테스트")
    void test_errorResponseConstructor4() {
        ErrorResponse response = new ErrorResponse("테스트 메시지", HttpStatus.BAD_REQUEST);
        assertFalse(response.isSuccess());
        assertEquals("테스트 메시지", response.getMessage());
        assertEquals(HttpStatus.BAD_REQUEST, response.getHttpStatus());
        assertEquals(400, response.getHttpStatusCode());
    }
}
