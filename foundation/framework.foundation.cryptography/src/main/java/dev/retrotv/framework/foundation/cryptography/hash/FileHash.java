package dev.retrotv.framework.foundation.cryptography.hash;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import dev.retrotv.framework.foundation.common.exception.BaseException;

public interface FileHash extends BinaryHash {
    default byte[] digest(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] data = fis.readAllBytes();
            return digest(data);
        } catch (FileNotFoundException ex) {
            throw new BaseException("파일이 존재하지 않습니다.", ex);
        } catch (IOException ex) {
            throw new BaseException("파일을 읽을 수 없습니다.", ex);
        }
    }
}
