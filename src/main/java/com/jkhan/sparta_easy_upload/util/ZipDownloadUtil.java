package com.jkhan.sparta_easy_upload.util;

import com.jkhan.sparta_easy_upload.constant.FileConstant;
import com.jkhan.sparta_easy_upload.exception.FileException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @ClassName ZipDownloadUtil
 * @Description ZipDownloadUtil
 * @Author hjk
 * @Date 2022/1/18 21:09
 **/
@Slf4j
public class ZipDownloadUtil {
    private static final int ZIP_BUFFER_SIZE = 8192;
    private static final String FILE_PATH = System.getProperty("java.io.tmpdir") + File.separator;

    private ZipDownloadUtil() {
    }

    public static void deleteFile(List<File> files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void zipDownload(String fileName, List<File> fileList, HttpServletResponse response) throws FileException {
        String zipPath = FILE_PATH + fileName;

        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipPath));
            byte[] bytes = new byte[1024];
            for (int i = 0; i < fileList.size(); i++) {
                File file = fileList.get(i);
                FileInputStream fileInputStream = new FileInputStream(file);
                zipOutputStream.putNextEntry(new ZipEntry(file.getName()));

                while (fileInputStream.read(bytes) != -1) {
                    zipOutputStream.write(bytes);
                }
                zipOutputStream.flush();
            }

            DownloadFileUtil.downloadFile(FILE_PATH, fileName, response);
            log.info(FileConstant.DOWNLOAD_SUCCESS, fileName);
        } catch (IOException e) {
            log.error(FileConstant.DOWNLOAD_ERROR, fileName);
            throw new FileException(e);
        } finally {
            fileList.add(new File(zipPath));
            deleteFile(fileList);
        }
    }
}
