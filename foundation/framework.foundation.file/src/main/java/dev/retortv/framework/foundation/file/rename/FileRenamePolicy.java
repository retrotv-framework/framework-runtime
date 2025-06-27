package dev.retortv.framework.foundation.file.rename;

import org.apache.commons.fileupload2.core.DiskFileItem;
import org.apache.commons.fileupload2.core.FileItem;

public interface FileRenamePolicy {
    String rename(FileItem<DiskFileItem> file);
}
