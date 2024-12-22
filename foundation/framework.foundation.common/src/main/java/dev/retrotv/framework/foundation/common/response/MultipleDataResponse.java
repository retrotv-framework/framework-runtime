package dev.retrotv.framework.foundation.common.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Collection;

/**
 * 여러 개의 데이터를 반환할 때 사용하는 응답 클래스
 *
 * @since 1.0.0
 * @version 1.0.0
 * @param <T> 데이터 타입
 */
@Getter
public class MultipleDataResponse<T> extends BasicResponse {
    private final Collection<T> data;

    /**
     * 데이터를 받아 응답 객체를 생성합니다.
     *
     * @param data 응답 데이터
     */
    public MultipleDataResponse(Collection<T> data) {
        this.data = data;
    }

    /**
     * 데이터와 메시지를 받아 응답 객체를 생성합니다.
     *
     * @param message 응답 메시지
     * @param data    응답 데이터
     */
    public MultipleDataResponse(String message, Collection<T> data) {
        super(message);
        this.data = data;
    }

    /**
     * 데이터와 메시지, HTTP 상태 코드를 받아 응답 객체를 생성합니다.
     *
     * @param message        응답 메시지
     * @param data           응답 데이터
     * @param httpStatusCode HTTP 상태 코드 (int)
     */
    public MultipleDataResponse(String message, Collection<T> data, int httpStatusCode) {
        super(message, httpStatusCode);
        this.data = data;
    }

    /**
     * 데이터와 메시지, HTTP 상태 코드를 받아 응답 객체를 생성합니다.
     *
     * @param message     응답 메시지
     * @param data        응답 데이터
     * @param httpStatus  HTTP 상태 코드 (HttpStatus enum)
     */
    public MultipleDataResponse(String message, Collection<T> data, HttpStatus httpStatus) {
        super(message, httpStatus);
        this.data = data;
    }
}
