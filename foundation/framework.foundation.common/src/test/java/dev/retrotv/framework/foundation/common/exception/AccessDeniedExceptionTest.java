package dev.retrotv.framework.foundation.common.exception;

import dev.retrotv.framework.foundation.common.exception.http.AccessDeniedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccessDeniedExceptionTest {

    @Test
    @DisplayName("예외 메시지 테스트")
    void testAccessDeniedExceptionMessage() {
        String message = "접근 권한이 없습니다.";
        AccessDeniedException exception = new AccessDeniedException(message);

        assertEquals(message, exception.getMessage());
    }
}
