package dev.retrotv.framework.foundation.common.exception;

/**
 * application.yml 및 application.properties에 잘못된 프로퍼티 값이 있을 때 발생하는 예외
 *
 * @since 1.0.0
 * @version 1.0.0
 */
public class IllegalPropertyException extends RuntimeException {

    /**
     * 기본 생성자
     */
    public IllegalPropertyException() {
        super("잘못된 프로퍼티 값 입니다.");
    }

    /**
     * 메시지를 받아 예외를 생성
     *
     * @param message 메시지
     */
    public IllegalPropertyException(String message) {
        super(message);
    }

    /**
     * 메시지와 예외를 받아 예외를 생성
     *
     * @param message 메시지
     * @param cause 예외
     */
    public IllegalPropertyException(String message, Throwable cause) {
        super(message, cause);
    }
}
