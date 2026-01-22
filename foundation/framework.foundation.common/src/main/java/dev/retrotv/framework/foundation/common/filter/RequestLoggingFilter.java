package dev.retrotv.framework.foundation.common.filter;

import dev.retrotv.framework.foundation.common.util.IPUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.util.ContentCachingRequestWrapper;
import tools.jackson.databind.ObjectMapper;

import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * HttpServletRequest/HttpServletResponse의 요청/응답을 로깅하는 필터
 */
public class RequestLoggingFilter extends OncePerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(RequestLoggingFilter.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doFilterInternal(
        @NonNull HttpServletRequest request,
        @NonNull HttpServletResponse response,
        @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        if (isAsyncDispatch(request)) {
            filterChain.doFilter(request, response);
        } else {

            // request와 response가 Wrapper로 감싸져 있는지 확인하고, 그렇지 않으면 스프링에서 제공하는 Wapper로 감싼다
            ContentCachingRequestWrapper requestWrapper = request instanceof ContentCachingRequestWrapper ?
                (ContentCachingRequestWrapper) request : new ContentCachingRequestWrapper(request, 1024);

            ContentCachingResponseWrapper responseWrapper = response instanceof ContentCachingResponseWrapper ?
                (ContentCachingResponseWrapper) response : new ContentCachingResponseWrapper(response);

            doFilterWrapped(requestWrapper, responseWrapper, filterChain);
        }
    }

    protected void doFilterWrapped(
        ContentCachingRequestWrapper request,
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

    // Request(요청)을 로깅함
    private static void logRequest(ContentCachingRequestWrapper request) throws IOException {
        String method = request.getMethod();
        String queryString = request.getQueryString();
               queryString = queryString == null ? request.getRequestURI() : request.getRequestURI() + queryString;
        String contentType = request.getContentType() == null ? "" : request.getContentType();
        String ipAddress = IPUtils.getIPAddr(request);

        log.debug(
            """
            ========================================================================================================
            | Method Type : {}
            | URI         : {}
            | Content-Type: {}
            | IP Address  : {}
            ========================================================================================================
            """
            , method
            , queryString
            , contentType
            , ipAddress
        );

        logPayload("Request", contentType, request.getInputStream());
    }

    // Response(응답)을 로깅함
    private static void logResponse(ContentCachingResponseWrapper response) throws IOException {
        String contentType = response.getContentType() == null ? "" : response.getContentType();
        logPayload("Response", contentType, response.getContentInputStream());
    }

    // Request, Response의 Payload(본문 내용)를 로깅함
    private static void logPayload(String prefix, String contentType, InputStream inputStream) throws IOException {
        boolean visible = isVisible(
            MediaType.valueOf(
                contentType == null || contentType.isEmpty() ? "application/json" : contentType
            )
        );

        if (visible) {
            byte[] content = StreamUtils.copyToByteArray(inputStream);

            if (content.length > 0) {
                String contentString = new String(content);
                Object jsonObject = objectMapper.readValue(contentString, Object.class);
                String jsonContentString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);

                log.debug(
                     """
                     ========================================================================================================
                     {}
                     
                     Payload:
                     {}
                     ========================================================================================================
                     """
                   , prefix
                   , jsonContentString
                );
            }
        } else {
            log.debug(
                  """
                  {}
                  
                  Payload:
                  Binary Content
                  """
                , prefix
            );
        }
    }

    // Payload(본문 내용)을 로깅 여부를 판단함
    private static boolean isVisible(MediaType mediaType) {

        // 로깅 가능한 미디어 타입 목록, 이 외에는 로깅하지 않음
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
}
