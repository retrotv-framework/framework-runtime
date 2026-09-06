package dev.retrotv.framework.foundation.common.util;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPUtilsTest {

    @Test
    @DisplayName("유틸리티 클래스는 인스턴스화할 수 없다")
    void test_cannotInstantiate() throws NoSuchMethodException {
        Constructor<IPUtils> constructor = IPUtils.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        assertThatThrownBy(constructor::newInstance)
            .isInstanceOf(InvocationTargetException.class)
            .cause()
            .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("X-Forwarded-For 헤더가 있으면 해당 값을 반환한다")
    void test_getIPAddr_XForwardedFor() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeader("X-Forwarded-For")).thenReturn("192.168.0.1");

        assertThat(IPUtils.getIPAddr(request)).isEqualTo("192.168.0.1");
    }

    @Test
    @DisplayName("X-Forwarded-For 헤더가 unknown이면 Proxy-Client-IP 헤더를 확인한다")
    void test_getIPAddr_ProxyClientIP() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeader("X-Forwarded-For")).thenReturn("unknown");
        when(request.getHeader("Proxy-Client-IP")).thenReturn("192.168.0.2");

        assertThat(IPUtils.getIPAddr(request)).isEqualTo("192.168.0.2");
    }

    @Test
    @DisplayName("모든 헤더가 없으면 WL-Proxy-Client-IP 헤더를 확인한다")
    void test_getIPAddr_WLProxyClientIP() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeader("WL-Proxy-Client-IP")).thenReturn("192.168.0.3");

        assertThat(IPUtils.getIPAddr(request)).isEqualTo("192.168.0.3");
    }

    @Test
    @DisplayName("모든 헤더가 없으면 HTTP_CLIENT_IP 헤더를 확인한다")
    void test_getIPAddr_HttpClientIP() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeader("HTTP_CLIENT_IP")).thenReturn("192.168.0.4");

        assertThat(IPUtils.getIPAddr(request)).isEqualTo("192.168.0.4");
    }

    @Test
    @DisplayName("모든 헤더가 없으면 HTTP_X_FORWARDED_FOR 헤더를 확인한다")
    void test_getIPAddr_HttpXForwardedFor() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeader("HTTP_X_FORWARDED_FOR")).thenReturn("192.168.0.5");

        assertThat(IPUtils.getIPAddr(request)).isEqualTo("192.168.0.5");
    }

    @Test
    @DisplayName("모든 헤더가 비어있으면 request의 RemoteAddr를 반환한다")
    void test_getIPAddr_RemoteAddr() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRemoteAddr()).thenReturn("127.0.0.1");

        assertThat(IPUtils.getIPAddr(request)).isEqualTo("127.0.0.1");
    }

    @Test
    @DisplayName("헤더 값이 빈 문자열이면 다음 헤더를 확인한다")
    void test_getIPAddr_emptyHeaderFallsThrough() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeader("X-Forwarded-For")).thenReturn("");
        when(request.getHeader("Proxy-Client-IP")).thenReturn("");
        when(request.getHeader("WL-Proxy-Client-IP")).thenReturn("");
        when(request.getHeader("HTTP_CLIENT_IP")).thenReturn("");
        when(request.getHeader("HTTP_X_FORWARDED_FOR")).thenReturn("");
        when(request.getRemoteAddr()).thenReturn("10.0.0.1");

        assertThat(IPUtils.getIPAddr(request)).isEqualTo("10.0.0.1");
    }
}
