package dev.retrotv.framework.common.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class BasicResponse {
    boolean success = true;
    String message = "정상적으로 처리되었습니다.";
    HttpStatus httpStatus = HttpStatus.OK;

    public BasicResponse(String message) {
        this.message = message;
    }

    public BasicResponse(String message, int httpStatusCode) {
        this.message = message;
        this.httpStatus = HttpStatus.valueOf(httpStatusCode);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
