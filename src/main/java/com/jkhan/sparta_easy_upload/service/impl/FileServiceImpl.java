package com.jkhan.sparta_easy_upload.service.impl;

import com.jkhan.sparta_easy_upload.bean.FileInfo;
import com.jkhan.sparta_easy_upload.constant.CommonConstant;
import com.jkhan.sparta_easy_upload.dao.FileDao;
import com.jkhan.sparta_easy_upload.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @ClassName FileServiceImpl
 * @Description FileServiceImpl
 * @Author hjk
 * @Date 2022/1/16 20:54
 **/
@Service
@Slf4j
public class FileServiceImpl implements FileService {
    @Value("${file.dir}")
    private String baseDir;

    @Autowired
    private FileDao fileDao;

    @Override
    public int saveFile(File file) {
        FileInfo fileInfo = new FileInfo();
        String fileName = file.getName();

        fileInfo.setFileName(fileName);
        fileInfo.setFileUrl(baseDir + fileName);

        log.info(CommonConstant.INSERT_INTO_DB, fileInfo.toString());
        return fileDao.saveFile(fileInfo);
    }

    @Override
    public int deleteFile(Integer fileId) {
        log.info(CommonConstant.DELETE_FROM_DB, "file" + fileId);
        return fileDao.deleteFile(fileId);
    }

    @Override
    public FileInfo findFileById(Integer fileId) {
        log.info(CommonConstant.SELECT_FORM_DB, "file" + fileId);
        return fileDao.findFileById(fileId);
    }
}
