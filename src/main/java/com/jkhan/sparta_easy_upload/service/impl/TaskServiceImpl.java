package com.jkhan.sparta_easy_upload.service.impl;

import com.jkhan.sparta_easy_upload.bean.TaskInfo;
import com.jkhan.sparta_easy_upload.constant.CommonConstant;
import com.jkhan.sparta_easy_upload.dao.TaskDao;
import com.jkhan.sparta_easy_upload.exception.BusinessException;
import com.jkhan.sparta_easy_upload.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TaskServiceImpl
 * @Description TaskServiceImpl
 * @Author hjk
 * @Date 2022/1/11 22:04
 **/
@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public int insertTask(TaskInfo task) throws BusinessException {
        log.info(CommonConstant.INSERT_INTO_DB, task.toString());
        try {
            return taskDao.insertTask(task);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public int deleteTaskById(Integer taskId) throws BusinessException {
        log.info(CommonConstant.DELETE_FROM_DB, "task: " + taskId);
        try {
            if (isExist(taskId)) {
                return taskDao.deleteTaskById(taskId);
            }
            throw new BusinessException(CommonConstant.NOT_EXIST);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public int updateTaskInfo(TaskInfo taskInfo) throws BusinessException {
        log.info(CommonConstant.UPDATE_FROM_DB, taskInfo.toString());
        try {
            if (isExist(taskInfo.getTaskId())) {
                return taskDao.updateTaskInfo(taskInfo);
            }
            throw new BusinessException(CommonConstant.NOT_EXIST);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public TaskInfo selectTaskById(Integer taskId) throws BusinessException {
        log.info(CommonConstant.SELECT_FORM_DB, "task: " + taskId);
        try {
            if (isExist(taskId)) {
                return taskDao.selectTaskById(taskId);
            }
            throw new BusinessException(CommonConstant.NOT_EXIST);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<TaskInfo> selectPublishedTasks(Integer collectorId) {
        log.info(CommonConstant.SELECT_FORM_DB, "collector" + collectorId + " published tasks");
        return taskDao.selectPublishedTasks(collectorId);
    }

    @Override
    public List<TaskInfo> selectTasks() {
        log.info(CommonConstant.SELECT_FORM_DB, "tasks");
        return taskDao.selectTasks();
    }

    private boolean isExist(Integer id) {
        List<TaskInfo> tasks = selectTasks();
        for (TaskInfo task : tasks) {
            if (id == task.getTaskId()) {
                return true;
            }
        }
        return false;
    }
}
