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
public class MultipleDataResponse<C extends Collection<T>, T> extends DataResponse<C> {

    /**
     * 데이터를 받아 응답 객체를 생성합니다.
     *
     * @param data 응답 데이터
     */
    public MultipleDataResponse(C data) {
        super(data);
    }

    /**
     * 데이터와 메시지를 받아 응답 객체를 생성합니다.
     *
     * @param message 응답 메시지
     * @param data    응답 데이터
     */
    public MultipleDataResponse(String message, C data) {
        super(message, data);
    }

    /**
     * 데이터와 메시지, HTTP 상태 코드를 받아 응답 객체를 생성합니다.
     *
     * @param message        응답 메시지
     * @param data           응답 데이터
     * @param httpStatusCode HTTP 상태 코드 (int)
     */
    public MultipleDataResponse(String message, int httpStatusCode, C data) {
        super(message, httpStatusCode, data);
    }

    /**
     * 데이터와 메시지, HTTP 상태 코드를 받아 응답 객체를 생성합니다.
     *
     * @param message     응답 메시지
     * @param data        응답 데이터
     * @param httpStatus  HTTP 상태 코드 (HttpStatus enum)
     */
    public MultipleDataResponse(String message, HttpStatus httpStatus, C data) {
        super(message, httpStatus, data);
    }

    /**
     * 데이터의 개수를 반환합니다.
     *
     * @return 데이터 개수
     */
    public int getDataSize() {
        return data != null ? data.size() : 0;
    }
}
