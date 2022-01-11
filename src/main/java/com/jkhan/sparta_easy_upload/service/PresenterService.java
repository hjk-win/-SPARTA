package com.jkhan.sparta_easy_upload.service;

import com.jkhan.sparta_easy_upload.bean.PresenterInfo;
import com.jkhan.sparta_easy_upload.exception.BusinessException;

import java.util.List;

public interface PresenterService {
    int insertPresenter(PresenterInfo presenter) throws BusinessException;
    int insertPresenterList(List<PresenterInfo> presenterInfoList) throws BusinessException;
    int deletePresenterById(Integer presenterId) throws BusinessException;
    int updatePresenterInfo(PresenterInfo presenterInfo) throws BusinessException;
    PresenterInfo selectPresenterById(Integer presenterId) throws BusinessException;
    List<PresenterInfo> selectPresenters();
}
