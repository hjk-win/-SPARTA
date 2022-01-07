package com.jkhan.sparta_easyupload.dao;

import com.jkhan.sparta_easyupload.bean.CollectorInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CollectorDao {
    int insertCollector(CollectorInfo collector);
    CollectorInfo selectCollectorById(long collectorId);
    List<CollectorInfo> selectCollectors();
    int deleteCollectorById(long collectorId);
    int updateCollectorInfo(CollectorInfo collectorInfo);
    int insertCollectorList(List<CollectorInfo> collectorInfoList);
}
