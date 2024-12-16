package dev.retrotv.framework.foundation.common.exception;

/**
 * 인증/인가에 실패할 때 발생하는 예외
 */
public class AuthFailException extends RuntimeException {
    public AuthFailException() {
        super();
    }
    
    public AuthFailException(String message) {
        super(message);
    }

    public AuthFailException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
}
