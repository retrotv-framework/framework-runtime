package dev.retrotv.framework.foundation.common.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 데이터를 반환할 때 사용하는 응답 추상 클래스
 * 데이터를 반환하는 응답 클래스를 생성할 때, 이 클래스를 상속받아 구현해야 함
 *
 * @since 1.0.0
 * @version 1.0.0
 * @param <T> 데이터 타입
 */
@Getter
public abstract class DataResponse<T> extends Response {
    protected final T data;

    /**
     * 데이터를 받아 응답 객체를 생성합니다.
     *
     * @param data 응답 데이터
     */
    DataResponse(T data) {
        super(true, "정상적으로 처리되었습니다.", HttpStatus.OK);
        this.data = data;
    }

    /**
     * 데이터와 메시지를 받아 응답 객체를 생성합니다.
     *
     * @param message 응답 메시지
     * @param data    응답 데이터
     */
    DataResponse(String message, T data) {
        super(true, message, HttpStatus.OK);
        this.data = data;
    }

    /**
     * 데이터와 메시지, HTTP 상태 코드를 받아 응답 객체를 생성합니다.
     *
     * @param message        응답 메시지
     * @param httpStatusCode HTTP 상태 코드 (int)
     * @param data           응답 데이터
     */
    DataResponse(String message, int httpStatusCode, T data) {
        super(true, message, HttpStatus.valueOf(httpStatusCode));
        this.data = data;
    }

    /**
     * 데이터와 메시지, HTTP 상태 코드를 받아 응답 객체를 생성합니다.
     *
     * @param message    응답 메시지
     * @param httpStatus HTTP 상태 코드 (HttpStatus enum)
     * @param data       응답 데이터
     */
    DataResponse(String message, HttpStatus httpStatus, T data) {
        super(true, message, httpStatus);
        this.data = data;
    }
}
