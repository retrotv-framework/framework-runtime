package dev.retrotv.framework.foundation.common.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

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
