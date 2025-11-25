package dev.retortv.framework.foundation.file;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.fileupload2.core.DiskFileItem;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.io.FilenameUtils;

/**
 * 파일 정보를 담는 VO 클래스
 *
 * @since 1.0.0
 * @version 1.0.0
 */
@Getter
@AllArgsConstructor
public class FileVO {

    // 파일 확장자
    private String fileExt;

    // 파일 타입 (MIME 타입)
    private String fileType;

    // 원본 파일 이름
    private String originalFileName;

    // 실제 저장된 파일 이름
    private String savedFileName;

    // 파일 크기 (바이트 단위)
    private long fileSize;

    // 파일 경로 (서버 내 저장 경로)
    private String filePath;

    /**
     * FileItem&lt;DiskFileItem&gt;을 이용하여 FileVO 객체를 생성
     *
     * @param item FileItem&lt;DiskFileItem&gt; 객체
     * @param subDir 파일이 저장될 하위 디렉토리
     */
    public FileVO(FileItem<DiskFileItem> item, String subDir) {
        this.fileExt = FilenameUtils.getExtension(item.getName());
        this.fileType = item.getContentType();
        this.originalFileName = item.getName();
        this.fileSize = item.getSize();
        this.filePath = subDir;
    }
}

