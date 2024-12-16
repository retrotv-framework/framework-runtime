package dev.retortv.framework.foundation.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dev.retrotv.framework.foundation.common.exception.InternalServerErrorException;
import org.apache.commons.fileupload2.jakarta.servlet6.JakartaServletFileUpload;
import org.apache.commons.fileupload2.core.DiskFileItem;
import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.io.IOUtils;

import jakarta.servlet.http.HttpServletRequest;

public class FileUtil {
    FileUtil() {
        throw new IllegalStateException("유틸리티성 클래스 입니다.");
    }

    /**
     * Request가 Multipart인지 여부를 반환.
     *
     * @param request HttpServletRequest 객체
     * @return Multipart 여부
     */
    public static boolean isMultipartContent(HttpServletRequest request) {
        return JakartaServletFileUpload.isMultipartContent(request);
    }

    /**
     * HttpServletRequest에서 파일을 추출하여 반환.
     *
     * @param request HttpServletRequest 객체
     * @return 파일 리스트
     */
    public static List<DiskFileItem> getFiles(HttpServletRequest request) throws IOException{
        var factory = DiskFileItemFactory.builder().get();
        var upload = new JakartaServletFileUpload<>(factory);

        try {
            return upload.parseRequest(request);
        } catch (IOException ex) {
            throw new IOException("파일을 가져올 수 없습니다.", ex);
        }
    }

    /**
     * HttpServletRequest에서 상세경로를 추출하여 반환.
     *
     * @param files HttpServletRequest에서 추출한 파일 목록
     * @return 상세경로
     */
    public static String getSubDir(List<DiskFileItem> files) {
        String subDir = "";
        Iterator<DiskFileItem> iter = files.iterator();
        while (iter.hasNext()) {
            FileItem<DiskFileItem> item = iter.next();
            if (item.isFormField() && "subDir".equals(item.getFieldName())) {
                try {
                    subDir = item.getString(StandardCharsets.UTF_8);
                } catch (IOException ex) {
                    throw new InternalServerErrorException("상세경로를 가져올 수 없습니다.", ex);
                }
            }
        }

        return subDir;
    }

    /**
     * 파일을 물리적으로 저장하고, 저장된 파일들의 정보를 List<FileInfoVO> 형식으로 반환.
     *
     * @param files HttpServletRequest에서 추출한 파일 목록
     * @param subDir 상세경로
     * @return 저장된 파일 정보가 담긴 리스트
     * @throws IOException 파일 저장 도중 오류가 발생하면 던져짐
     */
    public static List<FileVO> saveFiles(List<DiskFileItem> files, String subDir) throws IOException {

        // 경로가 존재하지 않으면 디렉터리 생성
        Path dir = Paths.get(subDir);
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }

        List<FileVO> attachFileInfos = new ArrayList<>();
        for (FileItem<DiskFileItem> item : files) {
            if (!item.isFormField()) {
                attachFileInfos.add(new FileVO(item, subDir));
                String filename = item.getName();
                String path = Paths.get(subDir, filename).toString();
                try (
                    InputStream in = item.getInputStream();
                    OutputStream out = new FileOutputStream(path)
                ) {
                    IOUtils.copy(in, out);
                }
            }
        }

        return attachFileInfos;
    }
}
