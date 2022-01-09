package com.jkhan.sparta_easy_upload.dao;

import com.jkhan.sparta_easy_upload.bean.CollectorInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CollectorDao {
    int insertCollector(CollectorInfo collector);
    int insertCollectorList(List<CollectorInfo> collectorInfoList);
    int deleteCollectorById(long collectorId);
    int updateCollectorInfo(CollectorInfo collectorInfo);
    CollectorInfo selectCollectorById(long collectorId);
    List<CollectorInfo> selectCollectors();
}
