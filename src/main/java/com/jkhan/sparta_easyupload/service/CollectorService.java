package com.jkhan.sparta_easyupload.service;

import com.jkhan.sparta_easyupload.bean.CollectorInfo;
import com.jkhan.sparta_easyupload.exception.BusinessException;

import java.util.List;

public interface CollectorService {
    int insertCollector(CollectorInfo collector) throws BusinessException;
    CollectorInfo selectCollectorById(long collectorId) throws BusinessException;
    List<CollectorInfo> selectCollectors();
    int deleteCollectorById(long collectorId) throws BusinessException;
    int updateCollectorInfo(CollectorInfo collectorInfo) throws BusinessException;
    int insertCollectorList(List<CollectorInfo> collectorInfoList) throws BusinessException;
}
