package dev.retrotv.framework.foundation.common.filter;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class RequestLoggingFilterTest {

    private final RequestLoggingFilter filter = new RequestLoggingFilter();

    @Test
    @DisplayName("정상적인 요청/응답은 필터 체인을 거쳐 응답 바디가 그대로 전달된다")
    void test_doFilter_passesThroughRequestAndCopiesResponseBody() throws ServletException, IOException {
        MockHttpServletRequest request = new MockHttpServletRequest("POST", "/api/sample");
        request.setContentType("application/json");
        request.setContent("{\"name\":\"retrotv\"}".getBytes(StandardCharsets.UTF_8));

        MockHttpServletResponse response = new MockHttpServletResponse();
        AtomicInteger chainInvocations = new AtomicInteger();

        FilterChain chain = (req, res) -> {
            chainInvocations.incrementAndGet();
            HttpServletResponse httpResponse = (HttpServletResponse) res;
            httpResponse.setContentType("application/json");
            httpResponse.getWriter().write("{\"result\":\"ok\"}");
        };

        filter.doFilter(request, response, chain);

        assertThat(chainInvocations.get()).isEqualTo(1);
        assertThat(new String(response.getContentAsByteArray(), StandardCharsets.UTF_8)).isEqualTo("{\"result\":\"ok\"}");
    }

    @Test
    @DisplayName("비동기 디스패치인 경우 요청/응답을 감싸지 않고 체인만 호출한다")
    void test_doFilter_asyncDispatchSkipsWrapping() throws ServletException, IOException {
        MockHttpServletRequest request = new MockHttpServletRequest("POST", "/api/sample");
        request.setDispatcherType(DispatcherType.ASYNC);

        MockHttpServletResponse response = new MockHttpServletResponse();
        AtomicInteger chainInvocations = new AtomicInteger();

        FilterChain chain = (req, res) -> chainInvocations.incrementAndGet();

        filter.doFilter(request, response, chain);

        assertThat(chainInvocations.get()).isEqualTo(1);
    }

    @Test
    @DisplayName("체인 실행 중 예외가 발생해도 응답 바디는 복사되고 예외는 전파된다")
    void test_doFilter_exceptionInChainIsPropagatedAndResponseStillCopied() {
        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/api/sample");
        MockHttpServletResponse response = new MockHttpServletResponse();

        FilterChain chain = new FilterChain() {
            @Override
            public void doFilter(ServletRequest req, ServletResponse res) throws IOException {
                HttpServletResponse httpResponse = (HttpServletResponse) res;
                httpResponse.setContentType("text/plain");
                httpResponse.getWriter().write("partial");
                throw new IOException("다운스트림 오류");
            }
        };

        org.junit.jupiter.api.Assertions.assertThrows(IOException.class, () ->
            filter.doFilter(request, response, chain)
        );

        assertThat(new String(response.getContentAsByteArray(), StandardCharsets.UTF_8)).isEqualTo("partial");
    }
}
