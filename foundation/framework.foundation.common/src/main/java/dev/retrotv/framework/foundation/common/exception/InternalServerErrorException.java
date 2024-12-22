package dev.retrotv.framework.foundation.common.exception;

/**
 * 서버 내부에서 로직 처리과정 중, 오류가 있을 때 발생하는 예외
 *
 * @since 1.0.0
 * @version 1.0.0
 */
public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException() {
        super();
    }

    public InternalServerErrorException(String message) {
        super(message);
    }

    public InternalServerErrorException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

