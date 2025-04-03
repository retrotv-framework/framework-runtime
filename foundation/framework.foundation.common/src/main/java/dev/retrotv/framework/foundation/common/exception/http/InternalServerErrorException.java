package dev.retrotv.framework.foundation.common.exception.http;

/**
 * 500 Internal Server Error
 * 서버 내부에서 로직 처리과정 중, 오류가 있을 때 발생하는 예외
 *
 * @since 1.0.0
 * @version 1.0.0
 */
public class InternalServerErrorException extends ResponseErrorException {

    /**
     * 기본 생성자
     */
    public InternalServerErrorException() {
        super("원인을 알 수 없는 오류가 발생했습니다.\n해당 오류가 지속적으로 발생할 경우, 관리자에게 문의해 주십시오.");
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
     * @param cause 예외
     */
    public InternalServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}

