package com.jkhan.sparta_easy_upload.bean;

import lombok.Data;

/**
 * @ClassName Admin
 * @Description Admin
 * @Author hjk
 * @Date 2022/1/6 19:53
 **/
@Data
public class AdminInfo {
    private long adminId;
    private String adminTelNumber;
    private String password;
    private String salt;
}
