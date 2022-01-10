package com.jkhan.sparta_easy_upload.service.impl;

import com.jkhan.sparta_easy_upload.bean.CollectorInfo;
import com.jkhan.sparta_easy_upload.constant.CommonConstant;
import com.jkhan.sparta_easy_upload.dao.CollectorDao;
import com.jkhan.sparta_easy_upload.exception.BusinessException;
import com.jkhan.sparta_easy_upload.service.CollectorService;
import com.jkhan.sparta_easy_upload.util.AssertUtil;
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
    public int insertCollector(CollectorInfo collector) throws BusinessException {
        log.info(CommonConstant.INSERT_INTO_DB, collector.toString());
        try {
            return collectorDao.insertCollector(collector);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public int insertCollectorList(List<CollectorInfo> collectorInfoList) throws BusinessException {
        log.info(CommonConstant.INSERT_INTO_DB, collectorInfoList.toString());
        try {
            return collectorDao.insertCollectorList(collectorInfoList);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public int deleteCollectorById(Integer collectorId) throws BusinessException {
        log.info(CommonConstant.DELETE_FROM_DB, "collector: " + collectorId);
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
        log.info(CommonConstant.UPDATE_FROM_DB, collectorInfo.toString());
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
    public CollectorInfo selectCollectorById(Integer collectorId) throws BusinessException {
        log.info(CommonConstant.SELECT_FORM_DB, "collector: " + collectorId);
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
        log.info(CommonConstant.SELECT_FORM_DB, "collectors");
        return collectorDao.selectCollectors();
    }

    private boolean isExist(Integer id) {
        List<CollectorInfo> collectors = selectCollectors();
        for (CollectorInfo collector : collectors) {
            if (id == collector.getCollectorId()) {
                return true;
            }
        }
        return false;
    }
}
