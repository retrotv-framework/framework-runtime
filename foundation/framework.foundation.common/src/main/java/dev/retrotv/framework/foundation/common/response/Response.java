package dev.retrotv.framework.foundation.common.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class Response {
    protected Response(boolean success, String message, HttpStatus httpStatus) {
        this.success = success;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    /**
     * 응답 성공 여부
     */
    protected boolean success;

    /**
     * 응답 메시지
     */
    protected String message;

    /**
     * HTTP 상태 코드
     */
    protected HttpStatus httpStatus;

    /**
     * HTTP 상태 코드를 int형으로 반환합니다.
     *
     * @return int형 HTTP 상태 코드
     */
    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
