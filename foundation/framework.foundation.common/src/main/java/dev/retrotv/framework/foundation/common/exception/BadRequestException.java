package dev.retrotv.framework.foundation.common.exception;

/**
 * 잘못된 요청이 있을 때 발생하는 예외
 *
 * @since 1.0.0
 * @version 1.0.0
 */
public class BadRequestException extends RuntimeException {

    /**
     * 기본 생성자
     */
    public BadRequestException() {
        super();
    }

    /**
     * 메시지를 받아 예외를 생성
     *
     * @param message 메시지
     */
    public BadRequestException(String message) {
        super(message);
    }

    /**
     * 메시지와 예외를 받아 예외를 생성
     *
     * @param message 메시지
     * @param cause 예외
     */
    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
