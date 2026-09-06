package dev.retortv.framework.foundation.file;

import org.apache.commons.fileupload2.core.DiskFileItem;
import org.apache.commons.fileupload2.core.FileItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FileVOTest {

    @SuppressWarnings("unchecked")
    @Test
    @DisplayName("FileItem과 저장경로를 받아 FileVO를 생성한다")
    void test_constructFromFileItem() {
        FileItem<DiskFileItem> item = mock(FileItem.class);
        when(item.getName()).thenReturn("document.PDF");
        when(item.getContentType()).thenReturn("application/pdf");
        when(item.getSize()).thenReturn(1024L);

        FileVO fileVO = new FileVO(item, "/data/upload");

        assertThat(fileVO.getFileExt()).isEqualTo("PDF");
        assertThat(fileVO.getFileType()).isEqualTo("application/pdf");
        assertThat(fileVO.getOriginalFileName()).isEqualTo("document.PDF");
        assertThat(fileVO.getFileSize()).isEqualTo(1024L);
        assertThat(fileVO.getFilePath()).isEqualTo("/data/upload");
    }

    @Test
    @DisplayName("모든 필드를 직접 받아 FileVO를 생성한다")
    void test_allArgsConstructor() {
        FileVO fileVO = new FileVO("txt", "text/plain", "a.txt", "saved-a.txt", 10L, "/tmp");

        assertThat(fileVO.getFileExt()).isEqualTo("txt");
        assertThat(fileVO.getFileType()).isEqualTo("text/plain");
        assertThat(fileVO.getOriginalFileName()).isEqualTo("a.txt");
        assertThat(fileVO.getSavedFileName()).isEqualTo("saved-a.txt");
        assertThat(fileVO.getFileSize()).isEqualTo(10L);
        assertThat(fileVO.getFilePath()).isEqualTo("/tmp");
    }
}
