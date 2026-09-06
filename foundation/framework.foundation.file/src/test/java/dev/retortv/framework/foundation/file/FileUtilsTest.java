package dev.retortv.framework.foundation.file;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FileUtilsTest {

    @Test
    @DisplayName("유틸리티 클래스는 인스턴스화할 수 없다")
    void test_cannotInstantiate() throws NoSuchMethodException {
        Constructor<FileUtils> constructor = FileUtils.class.getDeclaredConstructor();
        assertThat(Modifier.isPublic(constructor.getModifiers())).isFalse();
        constructor.setAccessible(true);

        assertThatThrownBy(constructor::newInstance)
            .isInstanceOf(InvocationTargetException.class)
            .cause()
            .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("Content-Type이 multipart/form-data인 POST 요청은 Multipart로 판별한다")
    void test_isMultipartContent_true() {
        MockHttpServletRequest request = new MockHttpServletRequest("POST", "/upload");
        request.setContentType("multipart/form-data; boundary=----boundary");

        assertThat(FileUtils.isMultipartContent(request)).isTrue();
    }

    @Test
    @DisplayName("Content-Type이 multipart가 아니면 Multipart로 판별하지 않는다")
    void test_isMultipartContent_false() {
        MockHttpServletRequest request = new MockHttpServletRequest("POST", "/upload");
        request.setContentType("application/json");

        assertThat(FileUtils.isMultipartContent(request)).isFalse();
    }
}
