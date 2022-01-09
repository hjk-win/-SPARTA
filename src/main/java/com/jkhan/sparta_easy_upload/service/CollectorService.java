package com.jkhan.sparta_easy_upload.service;

import com.jkhan.sparta_easy_upload.bean.CollectorInfo;
import com.jkhan.sparta_easy_upload.exception.BusinessException;

import java.util.List;

public interface CollectorService {
    int insertCollector(CollectorInfo collector) throws BusinessException;
    int insertCollectorList(List<CollectorInfo> collectorInfoList) throws BusinessException;
    int deleteCollectorById(long collectorId) throws BusinessException;
    int updateCollectorInfo(CollectorInfo collectorInfo) throws BusinessException;
    CollectorInfo selectCollectorById(long collectorId) throws BusinessException;
    List<CollectorInfo> selectCollectors();
}
