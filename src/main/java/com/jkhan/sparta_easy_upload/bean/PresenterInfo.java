package com.jkhan.sparta_easy_upload.bean;

import lombok.Data;

/**
 * @ClassName PresenterInfo
 * @Description PresenterInfo
 * @Author hjk
 * @Date 2022/1/8 17:09
 **/
@Data
public class PresenterInfo {
    private Integer presenterId;
    private String presenterName;
    private String presenterTelNumber;
    private String presenterEmail;
    private String presenterWechat;
    private Integer collectorId;
}
