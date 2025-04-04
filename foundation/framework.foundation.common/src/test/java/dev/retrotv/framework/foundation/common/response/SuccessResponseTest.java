package dev.retrotv.framework.foundation.common.response;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class SuccessResponseTest {

    @Test
    @DisplayName("SuccessResponse 기본 생성자 테스트")
    void test_successResponseConstructor1() {
        Response response = new SuccessResponse();
        assertTrue(response.isSuccess());
        assertEquals("정상적으로 처리되었습니다.", response.getMessage());
        assertEquals(HttpStatus.OK, response.getHttpStatus());
        assertEquals(200, response.getHttpStatusCode());
    }

    @Test
    @DisplayName("SuccessResponse(String message) 생성자 테스트")
    void test_successResponseConstructor2() {
        Response response = new SuccessResponse("테스트 메시지");
        assertTrue(response.isSuccess());
        assertEquals("테스트 메시지", response.getMessage());
        assertEquals(HttpStatus.OK, response.getHttpStatus());
        assertEquals(200, response.getHttpStatusCode());
    }

    @Test
    @DisplayName("SuccessResponse(String message, int httpStatusCode) 생성자 테스트")
    void test_successResponseConstructor3() {
        Response response = new SuccessResponse("테스트 메시지", HttpStatus.BAD_REQUEST.value());
        assertTrue(response.isSuccess());
        assertEquals("테스트 메시지", response.getMessage());
        assertEquals(HttpStatus.BAD_REQUEST, response.getHttpStatus());
        assertEquals(400, response.getHttpStatusCode());
    }

    @Test
    @DisplayName("SuccessResponse(String message, HttpStatus httpStatus) 생성자 테스트")
    void test_successResponseConstructor4() {
        Response response = new SuccessResponse("테스트 메시지", HttpStatus.BAD_REQUEST);
        assertTrue(response.isSuccess());
        assertEquals("테스트 메시지", response.getMessage());
        assertEquals(HttpStatus.BAD_REQUEST, response.getHttpStatus());
        assertEquals(400, response.getHttpStatusCode());
    }
}
