package com.jkhan.sparta_easy_upload.service.impl;

import com.jkhan.sparta_easy_upload.bean.LabelInfo;
import com.jkhan.sparta_easy_upload.constant.CommonConstant;
import com.jkhan.sparta_easy_upload.dao.LabelDao;
import com.jkhan.sparta_easy_upload.exception.BusinessException;
import com.jkhan.sparta_easy_upload.service.LabelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName LabelServiceImpl
 * @Description LabelServiceImpl
 * @Author hjk
 * @Date 2022/1/13 21:36
 **/
@Service
@Slf4j
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelDao labelDao;

    @Override
    public int insertLabel(LabelInfo label) throws BusinessException {
        log.info(CommonConstant.INSERT_INTO_DB, label.toString());
        try {
            return labelDao.insertLabel(label);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public int deleteLabelById(Integer labelId) throws BusinessException {
        log.info(CommonConstant.DELETE_FROM_DB, "label: " + labelId);
        try {
            return labelDao.deleteLabelById(labelId);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public int updateLabelInfo(LabelInfo labelInfo) throws BusinessException {
        log.info(CommonConstant.UPDATE_FROM_DB, labelInfo.toString());
        try {
            return labelDao.updateLabelInfo(labelInfo);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public LabelInfo selectLabelPresenters(Integer labelId) throws BusinessException {
        log.info(CommonConstant.SELECT_FORM_DB, "presenters from label" + labelId);
        try {
            return labelDao.selectLabelPresenters(labelId);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
