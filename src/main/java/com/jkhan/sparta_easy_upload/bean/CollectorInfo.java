package com.jkhan.sparta_easy_upload.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName CollectorInfo
 * @Description collector information
 * @Author hjk
 * @Date 2021/12/31 10:49
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectorInfo {
    private Integer collectorId;
    private String collectorName;
    private String collectorTelNumber;
    private String collectorEmail;
    private List<PresenterInfo> presenters;
    private List<TaskInfo> tasks;
}
