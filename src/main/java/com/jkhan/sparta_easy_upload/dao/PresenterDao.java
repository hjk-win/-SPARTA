package com.jkhan.sparta_easy_upload.dao;

import com.jkhan.sparta_easy_upload.bean.PresenterInfo;
import com.jkhan.sparta_easy_upload.bean.TaskInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PresenterDao {
    int insertPresenter(PresenterInfo presenter);
    int insertPresenterList(List<PresenterInfo> presenterInfoList);
    int deletePresenterById(Integer presenterId);
    int updatePresenterInfo(PresenterInfo presenterInfo);
    PresenterInfo selectPresenterById(Integer presenterId);
    List<PresenterInfo> selectPresenters();
    List<PresenterInfo> selectMyTasks(Integer presenterId);
}
