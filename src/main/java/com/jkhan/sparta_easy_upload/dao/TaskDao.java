package com.jkhan.sparta_easy_upload.dao;

import com.jkhan.sparta_easy_upload.bean.TaskInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TaskDao {
    int insertTask(TaskInfo task);
    int deleteTaskById(Integer taskId);
    int updateTaskInfo(TaskInfo taskInfo);
    TaskInfo selectTaskById(Integer taskId);
    List<TaskInfo> selectPublishedTasks(Integer collectorId);
    List<TaskInfo> selectTasks();
    List<TaskInfo> selectSpecifyPresenters(Integer taskId);
}
