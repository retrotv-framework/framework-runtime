package dev.retrotv.framework.foundation.common.exception;

/**
 * 기본 예외 클래스
 * RuntimeException을 상속받은 기본적인 예외 클래스.
 * 보안상의 문제로 RuntimeException을 던질 수 없거나 (EX. 정적 분석), 예외처리가 강제되는 예외를 전환할 때 사용한다.
 *
 * @since 1.0.0
 * @version 1.0.0
 * @author yjj8353
 */
public class BaseRuntimeException extends RuntimeException {

    /**
     * 기본 생성자
     */
    public BaseRuntimeException() {
        super();
    }

    /**
     * 메시지를 받아 예외를 생성
     *
     * @param message 메시지
     */
    public BaseRuntimeException(String message) {
        super(message);
    }

    /**
     * 메시지와 예외를 받아 예외를 생성
     *
     * @param message 메시지
     * @param cause 예외
     */
    public BaseRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
