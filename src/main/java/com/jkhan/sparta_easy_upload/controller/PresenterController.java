package com.jkhan.sparta_easy_upload.controller;

import com.jkhan.sparta_easy_upload.bean.PresenterInfo;
import com.jkhan.sparta_easy_upload.bean.ResponseEntity;
import com.jkhan.sparta_easy_upload.enumeration.CommonResponseEnum;
import com.jkhan.sparta_easy_upload.exception.BusinessException;
import com.jkhan.sparta_easy_upload.service.PresenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName PresenterController
 * @Description PresenterController
 * @Author hjk
 * @Date 2022/1/8 20:58
 **/
@RestController
@RequestMapping("/v1")
public class PresenterController {
    @Autowired
    private PresenterService presenterService;

    @PostMapping("/presenter")
    public ResponseEntity<Integer> addPresenter(PresenterInfo presenter) throws BusinessException {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, presenterService.insertPresenter(presenter));
    }

    @PostMapping("/presenters")
    public ResponseEntity<Integer> addPresenters(List<PresenterInfo> presenterInfoList) throws BusinessException {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, presenterService.insertPresenterList(presenterInfoList));
    }

    @DeleteMapping("/presenters/{presenterId}")
    public ResponseEntity<Integer> deletePresenter(@PathVariable("presenterId") Integer presenterId) throws BusinessException {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, presenterService.deletePresenterById(presenterId));
    }

    @PutMapping("/presenters")
    public ResponseEntity<Integer> updatePresenterInfo(PresenterInfo presenterInfo) throws BusinessException {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, presenterService.updatePresenterInfo(presenterInfo));
    }

    @GetMapping("/presenters/{presenterId}")
    public ResponseEntity<PresenterInfo> getPresenter(@PathVariable("presenterId") Integer presenterId) throws BusinessException {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, presenterService.selectPresenterById(presenterId));
    }

    @GetMapping("/presenters")
    public ResponseEntity<List<PresenterInfo>> getPresenters() {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, presenterService.selectPresenters());
    }

    @GetMapping("/presenters/{presenterId}/tasks")
    public ResponseEntity<List<PresenterInfo>> getMyTasks(@PathVariable("presenterId") Integer presenterId) {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, presenterService.selectMyTasks(presenterId));
    }
}
