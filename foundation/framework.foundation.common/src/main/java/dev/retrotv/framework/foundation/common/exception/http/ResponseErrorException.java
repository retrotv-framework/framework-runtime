package dev.retrotv.framework.foundation.common.exception.http;

/**
 * HTTP 응답 오류에 대한 추상 예외
 * !중요: 모든 HTTP 응답 오류 예외는 이 클래스를 상속받아 구현해야 함
 * X) class AccessDeniedException extends ResponseErrorException { ... }
 *
 * @since 1.0.0
 * @version 1.0.0
 */
public abstract class ResponseErrorException extends RuntimeException {

    /**
     * 기본 생성자
     */
    ResponseErrorException() {
        super();
    }

    /**
     * 메시지를 받아 예외를 생성
     *
     * @param message 메시지
     */
    ResponseErrorException(String message) {
        super(message);
    }

    /**
     * 메시지와 예외를 받아 예외를 생성
     *
     * @param message 메시지
     * @param throwable 예외
     */
    ResponseErrorException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
