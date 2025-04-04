package dev.retrotv.framework.foundation.common.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 단일 데이터를 반환할 때 사용하는 응답 클래스
 *
 * @since 1.0.0
 * @version 1.0.0
 * @param <T> 데이터 타입
 */
@Getter
public class SingleDataResponse<T> extends DataResponse<T> {

    /**
     * 데이터를 받아 응답 객체를 생성합니다.
     *
     * @param data 응답 데이터
     */
    public SingleDataResponse(T data) {
        super(data);
    }

    /**
     * 데이터와 메시지를 받아 응답 객체를 생성합니다.
     *
     * @param message 응답 메시지
     * @param data 응답 데이터
     */
    public SingleDataResponse(String message, T data) {
        super(message, data);
    }

    /**
     * 데이터와 메시지, HTTP 상태 코드를 받아 응답 객체를 생성합니다.
     *
     * @param message 응답 메시지
     * @param data 응답 데이터
     * @param httpStatusCode HTTP 상태 코드 (int)
     */
    public SingleDataResponse(String message, T data, int httpStatusCode) {
        super(message, httpStatusCode, data);
    }

    /**
     * 데이터와 메시지, HTTP 상태 코드를 받아 응답 객체를 생성합니다.
     *
     * @param message 응답 메시지
     * @param data 응답 데이터
     * @param httpStatus HTTP 상태 코드 (HttpStatus enum)
     */
    public SingleDataResponse(String message, T data, HttpStatus httpStatus) {
        super(message, httpStatus, data);
    }
}
