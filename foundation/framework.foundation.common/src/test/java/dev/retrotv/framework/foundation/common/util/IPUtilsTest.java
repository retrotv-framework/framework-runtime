package dev.retrotv.framework.foundation.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;

class IPUtilsTest {

    @Test
    void testGetIPAddr() {
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getHeader("X-Forwarded-For")).thenReturn(null);
        when(request.getHeader("Proxy-Client-IP")).thenReturn(null);
        when(request.getHeader("WL-Proxy-Client-IP")).thenReturn(null);
        when(request.getHeader("HTTP_CLIENT_IP")).thenReturn(null);
        when(request.getHeader("HTTP_X_FORWARDED_FOR")).thenReturn(null);
        when(request.getRemoteAddr()).thenReturn("192.168.1.1");

        String ip = IPUtils.getIPAddr(request);
        assertEquals("192.168.1.1", ip);
    }

    @Test
    void testGetIPAddrWithXForwardedFor() {
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getHeader("X-Forwarded-For")).thenReturn("203.0.113.1");

        String ip = IPUtils.getIPAddr(request);
        assertEquals("203.0.113.1", ip);
    }

    @Test
    void testGetIPAddrWithProxyClientIP() {
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getHeader("X-Forwarded-For")).thenReturn(null);
        when(request.getHeader("Proxy-Client-IP")).thenReturn("203.0.113.2");

        String ip = IPUtils.getIPAddr(request);
        assertEquals("203.0.113.2", ip);
    }
}