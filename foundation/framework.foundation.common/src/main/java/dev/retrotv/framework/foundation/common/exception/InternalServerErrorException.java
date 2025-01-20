package dev.retrotv.framework.foundation.common.exception;

/**
 * 서버 내부에서 로직 처리과정 중, 오류가 있을 때 발생하는 예외
 *
 * @since 1.0.0
 * @version 1.0.0
 */
public class InternalServerErrorException extends RuntimeException {

    /**
     * 기본 생성자
     */
    public InternalServerErrorException() {
        super();
    }

    /**
     * 메시지를 받아 예외를 생성
     *
     * @param message 메시지
     */
    public InternalServerErrorException(String message) {
        super(message);
    }

    /**
     * 메시지와 예외를 받아 예외를 생성
     *
     * @param message 메시지
     * @param throwable 예외
     */
    public InternalServerErrorException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

