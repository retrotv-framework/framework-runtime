package dev.retrotv.framework.foundation.common.exception;

/**
 * 잘못된 요청이 있을 때 발생하는 예외
 *
 * @since 1.0.0
 * @version 1.0.0
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException() {
        super();
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
