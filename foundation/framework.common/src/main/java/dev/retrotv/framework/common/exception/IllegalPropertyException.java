package dev.retrotv.framework.common.exception;

/**
 * application.yml 및 application.properties에 잘못된 프로퍼티 값이 있을 때 발생하는 예외
 */
public class IllegalPropertyException extends RuntimeException {
    public IllegalPropertyException() {
        super("잘못된 프로퍼티 값 입니다.");
    }

    public IllegalPropertyException(String message) {
        super(message);
    }

    public IllegalPropertyException(String message, Throwable cause) {
        super(message, cause);
    }
}
