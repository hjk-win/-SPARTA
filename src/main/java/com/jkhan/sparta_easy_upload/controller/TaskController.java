package com.jkhan.sparta_easy_upload.controller;

import com.jkhan.sparta_easy_upload.bean.ResponseEntity;
import com.jkhan.sparta_easy_upload.bean.TaskInfo;
import com.jkhan.sparta_easy_upload.enumeration.ResponseEnum;
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

    @PostMapping("/tasks")
    public ResponseEntity<Integer> addTask(TaskInfo task) throws BusinessException {
        return new ResponseEntity<>(ResponseEnum.SUCCESS, taskService.insertTask(task));
    }

    @DeleteMapping("/tasks/{taskId}")
    public ResponseEntity<Integer> deleteTask(@PathVariable("taskId") Integer taskId) throws BusinessException {
        return new ResponseEntity<>(ResponseEnum.SUCCESS, taskService.deleteTaskById(taskId));
    }

    @PutMapping("/tasks/{taskId}")
    public ResponseEntity<Integer> updateTaskInfo(@PathVariable("taskId") Integer taskId, TaskInfo taskInfo) throws BusinessException {
        return new ResponseEntity<>(ResponseEnum.SUCCESS, taskService.updateTaskInfo(taskInfo));
    }

    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<TaskInfo> getTask(@PathVariable("taskId") Integer taskId) throws BusinessException {
        return new ResponseEntity<>(ResponseEnum.SUCCESS, taskService.selectTaskById(taskId));
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskInfo>> getTasks() {
        return new ResponseEntity<>(ResponseEnum.SUCCESS, taskService.selectTasks());
    }

    @GetMapping("/tasks/{taskId}/presenters")
    public ResponseEntity<List<TaskInfo>> getSpecifyPresenters(@PathVariable("taskId") Integer taskId) {
        return new ResponseEntity<>(ResponseEnum.SUCCESS, taskService.selectSpecifyPresenters(taskId));
    }
}
