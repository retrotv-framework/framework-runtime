package dev.retrotv.framework.foundation.cryptography.digest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import dev.retrotv.framework.foundation.common.exception.BaseRuntimeException;

public interface FileDigest extends BinaryDigest {
    default byte[] digest(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] data = fis.readAllBytes();
            return digest(data);
        } catch (FileNotFoundException ex) {
            throw new BaseRuntimeException("파일이 존재하지 않습니다.", ex);
        } catch (IOException ex) {
            throw new BaseRuntimeException("파일을 읽을 수 없습니다.", ex);
        }
    }
}
