package com.jkhan.sparta_easy_upload.util;

import com.jkhan.sparta_easy_upload.constant.CommonConstant;
import com.jkhan.sparta_easy_upload.constant.FileConstant;
import com.jkhan.sparta_easy_upload.exception.FileException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName UploadUtil
 * @Description UploadUtil
 * @Author hjk
 * @Date 2022/1/18 20:36
 **/
@Slf4j
public class UploadFileUtil {
    private UploadFileUtil() {
    }

    public static File uploadFile(MultipartFile multipartFile, String dir) throws FileException {
        if (multipartFile.isEmpty()) {
            throw new FileException(CommonConstant.NOT_EXIST);
        }

        String newFileName = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "_" + multipartFile.getOriginalFilename();
        String path = dir + newFileName;

        File file = new File(path);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        try {
            multipartFile.transferTo(file);
            log.info(FileConstant.UPLOAD_SUCCESS, file.getName());
            return file;
        } catch (IOException e) {
            log.error(FileConstant.UPLOAD_ERROR, e.getMessage());
            throw new FileException(e);
        }
    }
}
