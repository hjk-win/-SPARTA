package com.jkhan.sparta_easy_upload.service;

import com.jkhan.sparta_easy_upload.bean.TaskInfo;
import com.jkhan.sparta_easy_upload.exception.BusinessException;

import java.util.List;

public interface TaskService {
    int insertTask(TaskInfo task) throws BusinessException;
    int deleteTaskById(Integer taskId) throws BusinessException;
    int updateTaskInfo(TaskInfo taskInfo) throws BusinessException;
    TaskInfo selectTaskById(Integer taskId) throws BusinessException;
    List<TaskInfo> selectPublishedTasks(Integer collectorId);
    List<TaskInfo> selectTasks();
    List<TaskInfo> selectSpecifyPresenters(Integer taskId);
}
