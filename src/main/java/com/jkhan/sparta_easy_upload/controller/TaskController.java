package com.jkhan.sparta_easy_upload.controller;

import com.jkhan.sparta_easy_upload.bean.ResponseEntity;
import com.jkhan.sparta_easy_upload.bean.TaskInfo;
import com.jkhan.sparta_easy_upload.enumeration.CommonResponseEnum;
import com.jkhan.sparta_easy_upload.exception.BusinessException;
import com.jkhan.sparta_easy_upload.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName TaskController
 * @Description TaskController
 * @Author hjk
 * @Date 2022/1/11 22:21
 **/
@RestController
@RequestMapping("/v1")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/task")
    public ResponseEntity<Integer> addTask(TaskInfo task) throws BusinessException {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, taskService.insertTask(task));
    }

    @DeleteMapping("/task/{taskId}")
    public ResponseEntity<Integer> deleteTask(@PathVariable("taskId") Integer taskId) throws BusinessException {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, taskService.deleteTaskById(taskId));
    }

    @PutMapping("/task")
    public ResponseEntity<Integer> updateTaskInfo(TaskInfo taskInfo) throws BusinessException {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, taskService.updateTaskInfo(taskInfo));
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<TaskInfo> getTask(@PathVariable("taskId") Integer taskId) throws BusinessException {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, taskService.selectTaskById(taskId));
    }

    @GetMapping("/published-tasks/{collectorId}")
    public ResponseEntity<List<TaskInfo>> getPublishedTasks(@PathVariable("collectorId") Integer collectorId) {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, taskService.selectPublishedTasks(collectorId));
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskInfo>> getTasks() {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, taskService.selectTasks());
    }

    @GetMapping("/task/presenters/{taskId}")
    public ResponseEntity<List<TaskInfo>> getSpecifyPresenters(@PathVariable("taskId") Integer taskId) {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, taskService.selectSpecifyPresenters(taskId));
    }
}
