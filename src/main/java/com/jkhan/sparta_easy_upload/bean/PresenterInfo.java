package com.jkhan.sparta_easy_upload.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName PresenterInfo
 * @Description PresenterInfo
 * @Author hjk
 * @Date 2022/1/8 17:09
 **/
@Data
@NoArgsConstructor
public class PresenterInfo {
    private Integer presenterId;
    private String presenterName;
    private String presenterTelNumber;
    private String presenterEmail;
    private String presenterWechat;
    private Integer collectorId;
    private Integer labelId;
    private List<PresenterTaskDetail> presenterTaskDetails;
}
