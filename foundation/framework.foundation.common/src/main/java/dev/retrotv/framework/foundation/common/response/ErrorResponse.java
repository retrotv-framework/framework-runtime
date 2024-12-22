package dev.retrotv.framework.foundation.common.response;

import org.springframework.http.HttpStatus;

/**
 * 에러 응답을 위한 클래스
 *
 * @since 1.0.0
 * @version 1.0.0
 */
public class ErrorResponse extends BasicResponse {
    public ErrorResponse() {
        super("요청을 처리하는 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        this.success = false;
    }

    public ErrorResponse(String message) {
        super(message, 500);
        this.success = false;
    }

    public ErrorResponse(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
        this.success = false;
    }
}
