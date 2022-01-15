package com.jkhan.sparta_easy_upload.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName TaskInfo
 * @Description TaskInfo
 * @Author hjk
 * @Date 2022/1/10 21:01
 **/
@Data
@NoArgsConstructor
public class TaskInfo extends PresenterTaskDetail{
    private Integer taskId;
    private String taskName;
    private String taskDescribe;
    private String taskStatus;
    private String startTime;
    private String endTime;
    private Integer collectorId;
    private List<PresenterInfo> presenters;
}
