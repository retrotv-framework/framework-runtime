package dev.retortv.framework.foundation.file;

import org.apache.commons.fileupload2.core.DiskFileItem;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.io.FilenameUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FileVO {
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

