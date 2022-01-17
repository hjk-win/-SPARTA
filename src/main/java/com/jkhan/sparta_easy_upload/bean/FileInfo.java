package com.jkhan.sparta_easy_upload.bean;

import lombok.Data;

/**
 * @ClassName FileInfo
 * @Description FileInfo
 * @Author hjk
 * @Date 2022/1/16 20:31
 **/
@Data
public class FileInfo {
    private Integer fileId;
    private String fileName;
    private String fileUrl;
}
