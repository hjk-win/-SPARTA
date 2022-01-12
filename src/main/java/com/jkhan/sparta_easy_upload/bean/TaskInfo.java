package com.jkhan.sparta_easy_upload.bean;

import lombok.Data;

/**
 * @ClassName TaskInfo
 * @Description TaskInfo
 * @Author hjk
 * @Date 2022/1/10 21:01
 **/
@Data
public class TaskInfo {
    private Integer taskId;
    private String taskName;
    private String taskDescribe;
    private String taskStatus;
    private String startTime;
    private String endTime;
    private Integer collectorId;
}
