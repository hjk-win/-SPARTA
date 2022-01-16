package com.jkhan.sparta_easy_upload.dao;

import com.jkhan.sparta_easy_upload.bean.LabelInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LabelDao {
    int insertLabel(LabelInfo label);
    int deleteLabelById(Integer labelId);
    int updateLabelInfo(LabelInfo labelInfo);
    LabelInfo selectLabelPresenters(Integer labelId);
}
