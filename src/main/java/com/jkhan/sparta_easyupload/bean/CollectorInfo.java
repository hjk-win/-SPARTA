package com.jkhan.sparta_easyupload.bean;

import lombok.Data;

/**
 * @ClassName CollectorInfo
 * @Description collector information
 * @Author hjk
 * @Date 2021/12/31 10:49
 **/
@Data
public class CollectorInfo {
    private long collectorId;
    private String collectorName;
    private String collectorTelNumber;
    private String collectorEmail;
}
