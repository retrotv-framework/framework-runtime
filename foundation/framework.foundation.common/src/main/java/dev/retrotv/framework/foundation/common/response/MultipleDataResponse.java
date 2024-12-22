package dev.retrotv.framework.foundation.common.response;

import lombok.Getter;

import java.util.Collection;

/**
 * 여러 개의 데이터를 반환할 때 사용하는 응답 클래스
 *
 * @since 1.0.0
 * @version 1.0.0
 */
@Getter
public class MultipleDataResponse<T> extends BasicResponse {
    private final Collection<T> data;

    public MultipleDataResponse(Collection<T> data) {
        this.data = data;
    }

    public MultipleDataResponse(String message, Collection<T> data) {
        super(message);
        this.data = data;
    }

    public MultipleDataResponse(String message, Collection<T> data, int httpStatusCode) {
        super(message, httpStatusCode);
        this.data = data;
    }
}
