package dev.retortv.framework.foundation.file;

import org.apache.commons.fileupload2.core.DiskFileItem;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.io.FilenameUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 파일 정보를 담는 VO 클래스
 *
 * @since 1.0.0
 * @version 1.0.0
 */
@Getter
@AllArgsConstructor
public class FileVO {

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

    private String fileExt;
    private String fileType;
    private String originalFileName;
    private long fileSize;
    private String filePath;
}

