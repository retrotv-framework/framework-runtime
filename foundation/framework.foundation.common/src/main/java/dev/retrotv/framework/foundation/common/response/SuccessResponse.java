package dev.retrotv.framework.foundation.common.response;

import org.springframework.http.HttpStatus;

/**
 * 성공 응답을 위한 클래스
 * EX) class SampleResponse extends BasicResponse { ... }
 *
 * @since 1.0.0
 * @version 1.0.0
 */
public class SuccessResponse extends Response {

    /**
     * 성공 응답 객체를 생성합니다.
     * 기본 메시지와 HTTP 상태 코드를 사용합니다.
     */
    public SuccessResponse() {
        super(true, "정상적으로 처리되었습니다.", HttpStatus.OK);
    }

    /**
     * 응답 메시지를 받아 응답 객체를 생성합니다.
     *
     * @param message 응답 메시지
     */
    public SuccessResponse(String message) {
        super(true, message, HttpStatus.OK);
    }

    /**
     * 응답 메시지와 HTTP 상태 코드를 받아 응답 객체를 생성합니다.
     *
     * @param message 응답 메시지
     * @param httpStatusCode HTTP 상태 코드 (int)
     */
    public SuccessResponse(String message, int httpStatusCode) {
        super(true, message, HttpStatus.valueOf(httpStatusCode));
    }

    /**
     * 응답 메시지와 HTTP 상태 코드를 받아 응답 객체를 생성합니다.
     *
     * @param message 응답 메시지
     * @param httpStatus HTTP 상태 코드 (HttpStatus enum)
     */
    public SuccessResponse(String message, HttpStatus httpStatus) {
        super(true, message, httpStatus);
    }
}
