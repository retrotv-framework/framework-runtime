package dev.retrotv.framework.foundation.common.exception;

/**
 * 접근 권한이 없을 때 발생하는 예외
 *
 * @since 1.0.0
 * @version 1.0.0
 */
public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException() {
        super();
    }
    
    public AccessDeniedException(String message) {
        super(message);
    }

    public AccessDeniedException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
