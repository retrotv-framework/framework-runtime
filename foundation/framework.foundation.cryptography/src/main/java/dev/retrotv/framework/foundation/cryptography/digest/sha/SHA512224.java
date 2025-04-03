package dev.retrotv.framework.foundation.cryptography.digest.sha;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import dev.retrotv.framework.foundation.common.exception.BaseRuntimeException;
import dev.retrotv.framework.foundation.cryptography.digest.GeneralDigest;
import dev.retrotv.framework.foundation.cryptography.digest.enums.DigestAlgorithm;

public class SHA512224 extends GeneralDigest {
    public SHA512224() {
        super();
        algorithmName = DigestAlgorithm.SHA512224.getName();
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    @Override
    public byte[] digest(byte[] data) throws IOException {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithmName);
            md.update(data);
            return md.digest();
        } catch (NoSuchAlgorithmException ex) {
            throw new BaseRuntimeException("이 예외는 발생하면 안됩니다. 이 예외가 발생한 경우, 즉시 로직을 확인하시기 바랍니다.", ex);
        }
    }
}
