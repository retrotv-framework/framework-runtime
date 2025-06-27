package dev.retortv.framework.foundation.file.rename;

import com.github.f4b6a3.uuid.UuidCreator;
import org.apache.commons.fileupload2.core.DiskFileItem;
import org.apache.commons.fileupload2.core.FileItem;

import java.util.UUID;

public class UUIDFileRenamePolicy implements FileRenamePolicy {

    @Override
    public String rename(FileItem<DiskFileItem> file) {
        UUID uuid = UuidCreator.getTimeOrderedEpoch();
        return uuid.toString();
    }
}
