package com.jkhan.sparta_easy_upload.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName LabelInfo
 * @Description LabelInfo
 * @Author hjk
 * @Date 2022/1/13 21:25
 **/
@Data
@NoArgsConstructor
public class LabelInfo {
    private Integer labelId;
    private String labelName;
    private String labelDescribe;
    private Integer collectorId;
    private List<PresenterInfo> presenters;
}
