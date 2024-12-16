package dev.retrotv.framework.common.response;

public class SingleDataResponse<T> extends BasicResponse {
    private T data;

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

    public T getData() {
        return data;
    }
}
