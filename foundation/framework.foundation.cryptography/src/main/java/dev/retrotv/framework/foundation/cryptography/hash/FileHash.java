package dev.retrotv.framework.foundation.cryptography.hash;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileHash extends BinaryHash {
    default byte[] digest(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] data = fis.readAllBytes();
            return digest(data);
        } catch (FileNotFoundException ex) {
            // throw new BaseException("File not found: " + file.getAbsolutePath(), ex);
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
}
