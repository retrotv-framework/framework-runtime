package dev.retrotv.framework.foundation.common.util;

import jakarta.servlet.http.HttpServletRequest;

public class IPUtils {
    private IPUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * HttpServletRequest로 부터 클라이언트의 IP주소를 가져온다.
     *
     * @param request HttpServletRequest 객체
     * @return 클라이언트 IP주소
     */
    public static String getIPAddr(HttpServletRequest request) {
        final String UNKNOWN = "unknown";
        String ip = request.getHeader("X-Forwarded-For");

        if(ip == null || ip.isEmpty() || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if(ip == null || ip.isEmpty() || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if(ip == null || ip.isEmpty() || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }

        if(ip == null || ip.isEmpty() || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if(ip == null || ip.isEmpty() || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }
}
