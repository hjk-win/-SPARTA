package com.jkhan.sparta_easy_upload.service;

import com.jkhan.sparta_easy_upload.bean.CollectorInfo;
import com.jkhan.sparta_easy_upload.exception.BusinessException;

import java.util.List;

public interface CollectorService {
    int insertCollector(CollectorInfo collector) throws BusinessException;
    int insertCollectorList(List<CollectorInfo> collectorInfoList) throws BusinessException;
    int deleteCollectorById(Integer collectorId) throws BusinessException;
    int updateCollectorInfo(CollectorInfo collectorInfo) throws BusinessException;
    CollectorInfo selectCollectorById(Integer collectorId) throws BusinessException;
    List<CollectorInfo> selectCollectors();
    CollectorInfo selectMyPresenters(Integer collectorId);
    CollectorInfo selectPublishedTasks(Integer collectorId);
}
