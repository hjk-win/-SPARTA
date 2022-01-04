package com.jkhan.sparta_easyupload.dao;

import com.jkhan.sparta_easyupload.bean.CollectorInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CollectorDao {
    int insertCollector(String collectorName, String collectorTelNumber, String collectorMail);
    CollectorInfo selectCollectorById(long collectorId);
    List<CollectorInfo> selectCollectors();
    int deleteCollectorById(long collectorId);
    int updateCollectorInfo(CollectorInfo collectorInfo);
    int insertCollectorList(List<CollectorInfo> collectorInfoList);
}
