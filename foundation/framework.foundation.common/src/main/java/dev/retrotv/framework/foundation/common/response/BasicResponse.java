package dev.retrotv.framework.foundation.common.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 기본적인 응답을 위한 클래스
 * !중요: 모든 응답을 위한 클래스는 이 클래스를 상속받아 구현해야 합니다
 * EX) class SampleResponse extends BasicResponse { ... }
 *
 * @since 1.0.0
 * @version 1.0.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BasicResponse {
    protected boolean success = true;
    String message = "정상적으로 처리되었습니다.";
    HttpStatus httpStatus = HttpStatus.OK;

    public BasicResponse(String message) {
        this.message = message;
    }

    public BasicResponse(String message, int httpStatusCode) {
        this.message = message;
        this.httpStatus = HttpStatus.valueOf(httpStatusCode);
    }

    public BasicResponse(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
