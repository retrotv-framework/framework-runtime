package dev.retrotv.framework.foundation.common.exception;

/**
 * 접근 권한이 없을 때 발생하는 예외
 *
 * @since 1.0.0
 * @version 1.0.0
 */
public class AccessDeniedException extends RuntimeException {

    /**
     * 기본 생성자
     */
    public AccessDeniedException() {
        super();
    }

    /**
     * 메시지를 받아 예외를 생성
     *
     * @param message 메시지
     */
    public AccessDeniedException(String message) {
        super(message);
    }

    /**
     * 메시지와 예외를 받아 예외를 생성
     *
     * @param message 메시지
     * @param throwable 예외
     */
    public AccessDeniedException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
