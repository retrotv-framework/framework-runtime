package dev.retrotv.framework.foundation.common.exception;

/**
 * 인증/인가에 실패할 때 발생하는 예외
 *
 * @since 1.0.0
 * @version 1.0.0
 */
public class AuthFailException extends RuntimeException {

    /**
     * 기본 생성자
     */
    public AuthFailException() {
        super();
    }

    /**
     * 메시지를 받아 예외를 생성
     *
     * @param message 메시지
     */
    public AuthFailException(String message) {
        super(message);
    }

    /**
     * 메시지와 예외를 받아 예외를 생성
     *
     * @param message 메시지
     * @param throwable 예외
     */
    public AuthFailException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
}
