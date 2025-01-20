package dev.retrotv.framework.foundation.common.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class RequestLoggingFilter extends OncePerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    protected void doFilterInternal(
        @NonNull HttpServletRequest request,
        @NonNull HttpServletResponse response,
        @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        if (isAsyncDispatch(request)) {
            filterChain.doFilter(request, response);
        } else {
            doFilterWrapped(new RequestWrapper(request), new ContentCachingResponseWrapper(response), filterChain);
        }
    }

    protected void doFilterWrapped(
        RequestWrapper request,
        ContentCachingResponseWrapper response,
        FilterChain filterChain
    ) throws IOException, ServletException {
        try {
            filterChain.doFilter(request, response);
            logRequest(request);
        } finally {
            logResponse(response);
            response.copyBodyToResponse();
        }
    }

    private static void logRequest(RequestWrapper request) throws IOException {
        String queryString = request.getQueryString();

        log.debug(
            "Request : {} uri=[{}] content-type[{}]", request.getMethod(),
            queryString == null ? request.getRequestURI() : request.getRequestURI() + queryString,
            request.getContentType()
        );

        logPayload("Request", request.getContentType(), request.getInputStream());
    }

    private static void logResponse(ContentCachingResponseWrapper response) throws IOException {
        logPayload("Response", response.getContentType(), response.getContentInputStream());
    }

    private static void logPayload(String prefix, String contentType, InputStream inputStream) throws IOException {
        boolean visible = isVisible(MediaType.valueOf(contentType == null ? "application/json" : contentType));

        if (visible) {
            byte[] content = StreamUtils.copyToByteArray(inputStream);

            if (content.length > 0) {
                String contentString = new String(content);
                log.debug("{} Payload: {}", prefix, contentString);
            }
        } else {
            log.debug("{} Payload: Binary Content", prefix);
        }
    }

    private static boolean isVisible(MediaType mediaType) {
        final List<MediaType> visibleTypes = Arrays.asList(
            MediaType.valueOf("text/*"),
            MediaType.APPLICATION_FORM_URLENCODED,
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.valueOf("application/*+json"),
            MediaType.valueOf("application/*+xml"),
            MediaType.MULTIPART_FORM_DATA
        );

        return visibleTypes.stream()
                .anyMatch(visibleType -> visibleType.includes(mediaType));
    }

    static class RequestWrapper extends HttpServletRequestWrapper {
        private final byte[] cachedBody;

        public RequestWrapper(HttpServletRequest request) throws IOException {
            super(request);
            this.cachedBody = StreamUtils.copyToByteArray(request.getInputStream());
        }

        @Override
        public BufferedReader getReader() {
            return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(this.cachedBody)));
        }

        @Override
        public ServletInputStream getInputStream() {
            final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cachedBody);

            return new ServletInputStream() {

                @Override
                public boolean isFinished() {
                    return byteArrayInputStream.available() == 0;
                }

                @Override
                public boolean isReady() {
                    return true;
                }

                @Override
                public void setReadListener(ReadListener readListener) {
                    throw new UnsupportedOperationException();
                }

                @Override
                public int read() {
                    return byteArrayInputStream.read();
                }
            };
        }
    }
}
