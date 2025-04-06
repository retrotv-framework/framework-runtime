package dev.retrotv.framework.foundation.cryptography.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import dev.retrotv.data.utils.ByteUtils;
import dev.retrotv.framework.foundation.common.exception.BaseRuntimeException;
import dev.retrotv.framework.foundation.cryptography.digest.enums.Format;
import lombok.Getter;

@Getter
public abstract class GeneralDigest implements FileDigest, StringDigest {
    protected String algorithmName;

    @Override
    public byte[] digest(byte[] data) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithmName);
            md.update(data);
            return md.digest();
        } catch (NoSuchAlgorithmException ex) {
            throw new BaseRuntimeException("이 예외는 기본적으로 발생하면 안됩니다. 이 예외가 발생한 경우, 즉시 로직을 확인하시기 바랍니다.", ex);
        }
    }

    @Override
    public String digest(byte[] data, String format) {
        if (format == null) {
            format = Format.HEX.getName();
        }

        if (format.equalsIgnoreCase(Format.HEX.getName())) {
            return ByteUtils.toHexString(this.digest(data));
        } else if (format.equalsIgnoreCase(Format.BASE64.getName())) {
            return ByteUtils.toBase64String(this.digest(data));
        } else {
            throw new BaseRuntimeException("지원하지 않는 포맷입니다.");
        }
    }

    @Override
    public String digest(byte[] data, Format format) {
        if (format == null) {
            format = Format.HEX;
        }

        if (format == Format.HEX) {
            return ByteUtils.toHexString(this.digest(data));
        } else if (format == Format.BASE64) {
            return ByteUtils.toBase64String(this.digest(data));
        } else {
            throw new BaseRuntimeException("지원하지 않는 포맷입니다.");
        }
    }
}
