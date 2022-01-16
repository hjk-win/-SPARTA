package com.jkhan.sparta_easy_upload.service;

import com.jkhan.sparta_easy_upload.bean.LabelInfo;
import com.jkhan.sparta_easy_upload.exception.BusinessException;

import java.util.List;

public interface LabelService {
    int insertLabel(LabelInfo label) throws BusinessException;
    int deleteLabelById(Integer labelId) throws BusinessException;
    int updateLabelInfo(LabelInfo labelInfo) throws BusinessException;
    LabelInfo selectLabelPresenters(Integer labelId) throws BusinessException;
}
