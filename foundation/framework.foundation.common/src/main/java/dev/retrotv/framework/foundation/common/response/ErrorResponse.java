package dev.retrotv.framework.foundation.common.response;

import org.springframework.http.HttpStatus;

/**
 * 에러 응답을 위한 클래스
 *
 * @since 1.0.0
 * @version 1.0.0
 */
public class ErrorResponse extends Response {

    /**
     * 기본 에러 응답 객체 생성
     */
    public ErrorResponse() {
        super(false, "요청을 처리하는 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 에러 메시지를 받아 응답 객체를 생성
     *
     * @param message 응답 메시지
     */
    public ErrorResponse(String message) {
        super(false, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 에러 메시지와 HTTP 상태 코드를 받아 응답 객체를 생성
     *
     * @param message 응답 메시지
     * @param httpStatusCode HTTP 상태 코드 (int)
     */
    public ErrorResponse(String message, int httpStatusCode) {
        super(false, message, HttpStatus.valueOf(httpStatusCode));
    }

    /**
     * 에러 메시지와 HTTP 상태 코드 객체를 받아 응답 객체를 생성
     *
     * @param message 응답 메시지
     * @param httpStatus HTTP 상태 코드 (HttpStatus enum)
     */
    public ErrorResponse(String message, HttpStatus httpStatus) {
        super(false, message, httpStatus);
    }
}
