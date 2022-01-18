package com.jkhan.sparta_easy_upload.service;

import com.jkhan.sparta_easy_upload.bean.FileInfo;

import java.io.File;

/**
 * @ClassName FileService
 * @Description FileService
 * @Author hjk
 * @Date 2022/1/16 20:51
 **/
public interface FileService {
    int saveFile(File file);
    int deleteFile(Integer fileId);
    FileInfo findFileById(Integer fileId);
}
