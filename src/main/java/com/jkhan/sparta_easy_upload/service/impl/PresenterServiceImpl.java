package com.jkhan.sparta_easy_upload.service.impl;

import com.jkhan.sparta_easy_upload.bean.PresenterInfo;
import com.jkhan.sparta_easy_upload.constant.CommonConstant;
import com.jkhan.sparta_easy_upload.dao.PresenterDao;
import com.jkhan.sparta_easy_upload.exception.BusinessException;
import com.jkhan.sparta_easy_upload.service.PresenterService;
import com.jkhan.sparta_easy_upload.util.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PresenterServiceImpl
 * @Description PresenterServiceImpl
 * @Author hjk
 * @Date 2022/1/8 20:37
 **/
@Service
@Slf4j
public class PresenterServiceImpl implements PresenterService {
    @Autowired
    private PresenterDao presenterDao;

    @Override
    public int insertPresenter(PresenterInfo presenter) throws BusinessException {
        log.info(CommonConstant.INSERT_INTO_DB, presenter.toString());
        try {
            return presenterDao.insertPresenter(presenter);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public int insertPresenterList(List<PresenterInfo> presenterInfoList) throws BusinessException {
        log.info(CommonConstant.INSERT_INTO_DB, presenterInfoList.toString());
        try {
            return presenterDao.insertPresenterList(presenterInfoList);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public int deletePresenterById(Integer presenterId) throws BusinessException {
        log.info(CommonConstant.DELETE_FROM_DB, "presenter: " + presenterId);
        try {
            if (isExist(presenterId)) {
                return presenterDao.deletePresenterById(presenterId);
            }
            throw new BusinessException(CommonConstant.NOT_EXIST);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public int updatePresenterInfo(PresenterInfo presenterInfo) throws BusinessException {
        log.info(CommonConstant.UPDATE_FROM_DB, presenterInfo.toString());
        try {
            if (isExist(presenterInfo.getPresenterId())) {
                return presenterDao.updatePresenterInfo(presenterInfo);
            }
            throw new BusinessException(CommonConstant.NOT_EXIST);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public PresenterInfo selectPresenterById(Integer presenterId) throws BusinessException {
        log.info(CommonConstant.SELECT_FORM_DB, "presenter: " + presenterId);
        try {
            PresenterInfo presenter = presenterDao.selectPresenterById(presenterId);
            AssertUtil.notNull(presenter, CommonConstant.NOT_EXIST);
            return presenter;
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<PresenterInfo> selectPresenters() {
        log.info(CommonConstant.SELECT_FORM_DB, "presenters");
        return presenterDao.selectPresenters();
    }

    @Override
    public List<PresenterInfo> selectMyTasks(Integer presenterId) {
        log.info(CommonConstant.SELECT_FORM_DB, "presenter" + presenterId + ":tasks");
        return presenterDao.selectMyTasks(presenterId);
    }

    private boolean isExist(Integer id) {
        List<PresenterInfo> presenters = selectPresenters();
        for (PresenterInfo presenter : presenters) {
            if (id == presenter.getPresenterId()) {
                return true;
            }
        }
        return false;
    }
}
