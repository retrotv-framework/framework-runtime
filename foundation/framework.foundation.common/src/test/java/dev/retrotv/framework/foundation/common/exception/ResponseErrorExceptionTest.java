package dev.retrotv.framework.foundation.common.exception;

import dev.retrotv.framework.foundation.common.exception.http.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResponseErrorExceptionTest {

    @Test
    @DisplayName("AccessDeniedException 테스트")
    void testAccessDeniedException() {
        String message = "접근 권한이 없습니다.";

        ResponseErrorException exception = new AccessDeniedException();
        assertEquals(message, exception.getMessage());

        exception = new AccessDeniedException(message);
        assertEquals(message, exception.getMessage());

        Throwable cause = new Throwable("Cause");
        exception = new AccessDeniedException(message, cause);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    @DisplayName("AuthFailException 테스트")
    void testAuthFailException() {
        String message = "접근하기 위한 인증 자격이 없습니다.";

        AuthFailException exception = new AuthFailException();
        assertEquals(message, exception.getMessage());

        exception = new AuthFailException(message);
        assertEquals(message, exception.getMessage());

        Throwable cause = new Throwable("Cause");
        exception = new AuthFailException(message, cause);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    @DisplayName("BadRequestException 테스트")
    void testBadRequestException() {
        String message = "잘못된 요청입니다.";

        BadRequestException exception = new BadRequestException();
        assertEquals(message, exception.getMessage());

        exception = new BadRequestException(message);
        assertEquals(message, exception.getMessage());

        Throwable cause = new Throwable("Cause");
        exception = new BadRequestException(message, cause);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    @DisplayName("InternalServerErrorException 테스트")
    void testInternalServerErrorException() {
        String message = "원인을 알 수 없는 오류가 발생했습니다.\n해당 오류가 지속적으로 발생할 경우, 관리자에게 문의해 주십시오.";

        InternalServerErrorException exception = new InternalServerErrorException();
        assertEquals(message, exception.getMessage());

        exception = new InternalServerErrorException(message);
        assertEquals(message, exception.getMessage());

        Throwable cause = new Throwable("Cause");
        exception = new InternalServerErrorException(message, cause);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}
