package dev.retrotv.framework.common.response;

import org.springframework.http.HttpStatus;

public class ErrorResponse extends BasicResponse {
    public ErrorResponse() {
        super(false, "요청을 처리하는 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ErrorResponse(String message) {
        super(message);
    }

    public ErrorResponse(String message, HttpStatus httpStatus) {
        super(false, message, httpStatus);
    }
}
