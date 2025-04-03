package dev.retrotv.framework.foundation.cryptography.digest;

import dev.retrotv.data.utils.ByteUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Digest {
    private static dev.retrotv.crypto.hash.Hash h = null;

    private Digest() {}

    private static class DigestInstanceHolder {
        private static final Digest INSTANCE = new Digest();
    }

    /**
     * 해시 알고리즘을 선택하여 Digest 객체를 생성합니다.
     *
     * @param hashAlgorithm 해시 알고리즘
     * @return Hash 객체
     */
    public static Digest getInstance(EHash hashAlgorithm) {
        Digest instance = DigestInstanceHolder.INSTANCE;
        dev.retrotv.framework.foundation.cryptography.digest.Digest.h = dev.retrotv.crypto.hash.Hash.getInstance(selectHashAlgorithm(hashAlgorithm));

        return instance;
    }

    /**
     * 데이터를 해시하고 HEX 문자열 형식으로 반환합니다.
     *
     * @param data 해시할 데이터
     * @return 해시 결과
     */
    public String digest(String data) {
        return digest(data, EFormat.HEX);
    }

    /**
     * 데이터를 UTF-8 문자셋으로 해시하고, 지정한 문자열 형식으로 반환합니다.
     *
     * @param data 해시할 데이터
     * @param format 포맷 방식
     * @return 해시 결과
     */
    public String digest(String data, String format) {
        return digest(data, format, StandardCharsets.UTF_8);
    }

    /**
     * 데이터를 UTF-8 문자셋으로 해시하고, 지정한 문자열 형식으로 반환합니다.
     *
     * @param data 해시할 데이터
     * @param format 포맷 방식
     * @return 해시 결과
     */
    public String digest(String data, EFormat format) {
        return digest(data, format, StandardCharsets.UTF_8);
    }

    /**
     * 데이터를 지정한 문자셋으로 해시하고, 지정한 문자열 형식으로 반환합니다.
     *
     * @param data 해시할 데이터
     * @param format 포맷 방식
     * @param charset 문자셋
     * @return 해시 결과
     */
    public String digest(String data, String format, Charset charset) {
        if ("BASE64".equals(format)) {
            return digest(data, EFormat.BASE64, charset);
        } else if ("HEX".equals(format)) {
            return digest(data, EFormat.HEX, charset);
        } else {
            throw new IllegalArgumentException("Invalid format");
        }
    }

    /**
     * 데이터를 지정한 문자셋으로 해시하고, 지정한 문자열 형식으로 반환합니다.
     *
     * @param data 해시할 데이터
     * @param format 포맷 방식
     * @param charset 문자셋
     * @return 해시 결과
     */
    public String digest(String data, EFormat format, Charset charset) {
        if (EFormat.BASE64.equals(format)) {
            return ByteUtils.toBase64String(
                h.hashing(data.getBytes(charset))
            );
        } else if (EFormat.HEX.equals(format)) {
            return ByteUtils.toHexString(
                h.hashing(data.getBytes(charset))
            );
        } else {
            throw new IllegalArgumentException("Invalid format");
        }
    }

    /**
     * 해시 알고리즘을 표현하기 열거형 클래스 입니다.
     *
     * @author  yjj8353
     * @since   1.0.0
     */
    public enum EHash {
        CRC32("CRC-32"),
        MD2("MD2"),
        MD5("MD5"),
        SHA1("SHA-1"),
        SHA224("SHA-224"),
        SHA256("SHA-256"),
        SHA384("SHA-384"),
        SHA512("SHA-512"),
        SHA512224("SHA-512/224"),
        SHA512256("SHA-512/256"),
        SHA3224("SHA3-224"),
        SHA3256("SHA3-256"),
        SHA3384("SHA3-384"),
        SHA3512("SHA3-512");

        private final String label;

        EHash(String label) {
            this.label = label;
        }

        /**
         * 알고리즘의 label(이름)을 반환합니다.
         *
         * @return 알고리즘 명
         */
        public String label() {
            return label;
        }
    }

    /**
     * 해시 결과물의 포맷 방식을 표현하기 위한 열거형 클래스 입니다.
     *
     * @author yjj8353
     * @since 1.0.0
     */
    public enum EFormat {
        HEX("HEX"),
        BASE64("BASE64");

        private final String label;

        EFormat(String label) {
            this.label = label;
        }

        /**
         * 포맷방식의 label(이름)을 반환합니다.
         *
         * @return 포맷방식 명
         */
        public String label() {
            return label;
        }
    }

    private static dev.retrotv.crypto.enums.EHash selectHashAlgorithm(EHash hashAlgorithm) {
        return switch (hashAlgorithm) {
            case CRC32 -> dev.retrotv.crypto.enums.EHash.CRC32;
            case MD2 -> dev.retrotv.crypto.enums.EHash.MD2;
            case MD5 -> dev.retrotv.crypto.enums.EHash.MD5;
            case SHA1 -> dev.retrotv.crypto.enums.EHash.SHA1;
            case SHA224 -> dev.retrotv.crypto.enums.EHash.SHA224;
            case SHA256 -> dev.retrotv.crypto.enums.EHash.SHA256;
            case SHA384 -> dev.retrotv.crypto.enums.EHash.SHA384;
            case SHA512 -> dev.retrotv.crypto.enums.EHash.SHA512;
            case SHA512224 -> dev.retrotv.crypto.enums.EHash.SHA512224;
            case SHA512256 -> dev.retrotv.crypto.enums.EHash.SHA512256;
            case SHA3224 -> dev.retrotv.crypto.enums.EHash.SHA3224;
            case SHA3256 -> dev.retrotv.crypto.enums.EHash.SHA3256;
            case SHA3384 -> dev.retrotv.crypto.enums.EHash.SHA3384;
            case SHA3512 -> dev.retrotv.crypto.enums.EHash.SHA3512;
        };
    }
}
