package dev.retortv.framework.foundation.file.rename;

import org.apache.commons.fileupload2.core.DiskFileItem;
import org.apache.commons.fileupload2.core.FileItem;

public class DefaultFileRenamePolicy implements FileRenamePolicy {

    @Override
    public String rename(FileItem<DiskFileItem> file) {
        return String.valueOf(System.currentTimeMillis());
    }
}
