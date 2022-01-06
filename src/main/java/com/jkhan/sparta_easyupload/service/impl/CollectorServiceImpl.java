package com.jkhan.sparta_easyupload.service.impl;

import com.jkhan.sparta_easyupload.bean.CollectorInfo;
import com.jkhan.sparta_easyupload.constant.CommonConstant;
import com.jkhan.sparta_easyupload.dao.CollectorDao;
import com.jkhan.sparta_easyupload.exception.BusinessException;
import com.jkhan.sparta_easyupload.service.CollectorService;
import com.jkhan.sparta_easyupload.util.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CollectorServiceImpl
 * @Description CollectorServiceImpl
 * @Author hjk
 * @Date 2021/12/31 21:33
 **/
@Service
@Slf4j
public class CollectorServiceImpl implements CollectorService {
    @Autowired
    private CollectorDao collectorDao;

    @Override
    public int insertCollector(String collectorName, String collectorTelNumber, String collectorEmail) throws BusinessException {
        try {
            return collectorDao.insertCollector(collectorName, collectorTelNumber, collectorEmail);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public CollectorInfo selectCollectorById(long collectorId) throws BusinessException {
        try {
            CollectorInfo collector = collectorDao.selectCollectorById(collectorId);
            AssertUtil.notNull(collector, CommonConstant.NOT_EXIST);
            return collector;
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<CollectorInfo> selectCollectors() {
        return collectorDao.selectCollectors();
    }

    @Override
    public int deleteCollectorById(long collectorId) throws BusinessException {
        try {
            if (isExist(collectorId)) {
                return collectorDao.deleteCollectorById(collectorId);
            }
            throw new BusinessException(CommonConstant.NOT_EXIST);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public int updateCollectorInfo(CollectorInfo collectorInfo) throws BusinessException {
        try {
            if (isExist(collectorInfo.getCollectorId())) {
                return collectorDao.updateCollectorInfo(collectorInfo);
            }
            throw new BusinessException(CommonConstant.NOT_EXIST);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public int insertCollectorList(List<CollectorInfo> collectorInfoList) throws BusinessException {
        try {
            return collectorDao.insertCollectorList(collectorInfoList);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    private boolean isExist(long id) {
        List<CollectorInfo> collectors = selectCollectors();
        for (CollectorInfo collector : collectors) {
            if (id == collector.getCollectorId()) {
                return true;
            }
        }
        return false;
    }
}
