package com.jkhan.sparta_easy_upload.bean;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @ClassName PresenterTaskDetail
 * @Description PresenterTaskDetail
 * @Author hjk
 * @Date 2022/1/12 20:43
 **/
@Data
@NoArgsConstructor
public class PresenterTaskDetail {
    private Integer id;
    private Integer presenterId;
    private Integer taskId;
    private String finishStatus;
    private Integer fileId;
}
