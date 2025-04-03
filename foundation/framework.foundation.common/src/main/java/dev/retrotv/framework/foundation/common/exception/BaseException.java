package dev.retrotv.framework.foundation.common.exception;

public class BaseException extends RuntimeException {

    /**
     * 기본 생성자
     */
    public BaseException() {
        super();
    }

    /**
     * 메시지를 받아 예외를 생성
     *
     * @param message 메시지
     */
    public BaseException(String message) {
        super(message);
    }

    /**
     * 메시지와 예외를 받아 예외를 생성
     *
     * @param message 메시지
     * @param cause 예외
     */
    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
