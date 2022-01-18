package com.jkhan.sparta_easy_upload.dao;

import com.jkhan.sparta_easy_upload.bean.FileInfo;
import org.springframework.stereotype.Component;

@Component
public interface FileDao {
    int saveFile(FileInfo fileInfo);
    int deleteFile(Integer fileId);
    FileInfo findFileById(Integer fileId);
}
