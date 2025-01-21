package dev.retrotv.framework.foundation.common.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 기본적인 응답을 위한 클래스
 * !중요: 모든 응답을 위한 클래스는 이 클래스를 상속받아 구현해야 함
 * EX) class SampleResponse extends BasicResponse { ... }
 *
 * @since 1.0.0
 * @version 1.0.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BasicResponse {

    /**
     * 응답 성공 여부 (기본값: true)
     */
    protected boolean success = true;

    /**
     * 응답 메시지 (기본값: "정상적으로 처리되었습니다.")
     */
    protected String message = "정상적으로 처리되었습니다.";

    /**
     * HTTP 상태 코드 (기본값: HttpStatus.OK)
     */
    protected HttpStatus httpStatus = HttpStatus.OK;

    /**
     * 응답 메시지를 받아 응답 객체를 생성합니다.
     *
     * @param message 응답 메시지
     */
    public BasicResponse(String message) {
        this.message = message;
    }

    /**
     * 응답 메시지와 HTTP 상태 코드를 받아 응답 객체를 생성합니다.
     *
     * @param message 응답 메시지
     * @param httpStatusCode HTTP 상태 코드 (int)
     */
    public BasicResponse(String message, int httpStatusCode) {
        this.message = message;
        this.httpStatus = HttpStatus.valueOf(httpStatusCode);
    }

    /**
     * 응답 메시지와 HTTP 상태 코드를 받아 응답 객체를 생성합니다.
     *
     * @param message 응답 메시지
     * @param httpStatus HTTP 상태 코드 (HttpStatus enum)
     */
    public BasicResponse(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    /**
     * HTTP 상태 코드를 반환합니다.
     *
     * @return HTTP 상태 코드
     */
    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
