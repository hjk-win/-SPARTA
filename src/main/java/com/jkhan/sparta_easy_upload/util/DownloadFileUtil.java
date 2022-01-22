package com.jkhan.sparta_easy_upload.util;

import com.jkhan.sparta_easy_upload.constant.CommonConstant;
import com.jkhan.sparta_easy_upload.constant.FileConstant;
import com.jkhan.sparta_easy_upload.exception.FileException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @ClassName DownloadFileUtil
 * @Description DownloadFileUtil
 * @Author hjk
 * @Date 2022/1/18 20:45
 **/
@Slf4j
public class DownloadFileUtil {
    private DownloadFileUtil() {
    }

    public static void downloadFile(String dir, String fileName, HttpServletResponse response) throws FileException {
        File file = new File(dir + fileName);

        if (!file.exists()) {
            throw new FileException(CommonConstant.NOT_EXIST);
        }

        OutputStream outputStream = null;
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;

        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "utf-8"));

            outputStream = response.getOutputStream();
            inputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bytes = new byte[1024];
            while (inputStream.read(bytes) != -1){
                outputStream.write(bytes);
            }

            log.info(FileConstant.DOWNLOAD_SUCCESS, fileName);
            bufferedInputStream.close();
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            log.error(FileConstant.DOWNLOAD_ERROR, e.getMessage());
            throw new FileException(e);
        }
    }
}
