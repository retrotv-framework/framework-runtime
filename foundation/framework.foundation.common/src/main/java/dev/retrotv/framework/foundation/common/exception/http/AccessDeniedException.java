package dev.retrotv.framework.foundation.common.exception.http;

/**
 * 403 Forbidden
 * 접근 권한이 없을 때 발생하는 예외
 *
 * @since 1.0.0
 * @version 1.0.0
 */
public class AccessDeniedException extends ResponseErrorException {

    /**
     * 기본 생성자
     */
    public AccessDeniedException() {
        super("접근 권한이 없습니다.");
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
     * @param cause 예외
     */
    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }
}
