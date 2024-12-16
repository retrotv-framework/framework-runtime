package dev.retrotv.framework.common.response;

import java.util.Collection;

public class MultipleDataResponse<T> extends BasicResponse {
    private Collection<T> data;

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

    public Collection<T> getData() {
        return data;
    }
}
