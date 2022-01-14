package com.jkhan.sparta_easy_upload.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName PresenterTaskDetail
 * @Description PresenterTaskDetail
 * @Author hjk
 * @Date 2022/1/12 20:43
 **/
@Data
@NoArgsConstructor
public class PresenterTaskDetail {
    private int id;
    private int presenterId;
    private int taskId;
    private String finishStatus;
    private int fileId;
    private List<PresenterInfo> presenters;
    private List<TaskInfo> tasks;
}
