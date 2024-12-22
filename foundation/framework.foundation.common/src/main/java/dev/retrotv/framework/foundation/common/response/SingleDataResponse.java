package dev.retrotv.framework.foundation.common.response;

import lombok.Getter;

/**
 * 단일 데이터를 반환할 때 사용하는 응답 클래스
 *
 * @since 1.0.0
 * @version 1.0.0
 */
@Getter
public class SingleDataResponse<T> extends BasicResponse {
    private final T data;

    public SingleDataResponse(T data) {
        this.data = data;
    }

    public SingleDataResponse(String message, T data) {
        super(message);
        this.data = data;
    }

    public SingleDataResponse(String message, T data, int httpStatusCode) {
        super(message, httpStatusCode);
        this.data = data;
    }
}
