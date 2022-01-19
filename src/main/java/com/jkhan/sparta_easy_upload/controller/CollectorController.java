package com.jkhan.sparta_easy_upload.controller;

import com.jkhan.sparta_easy_upload.bean.CollectorInfo;
import com.jkhan.sparta_easy_upload.bean.ResponseEntity;
import com.jkhan.sparta_easy_upload.enumeration.CommonResponseEnum;
import com.jkhan.sparta_easy_upload.exception.BusinessException;
import com.jkhan.sparta_easy_upload.service.CollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CollectorController
 * @Description CollectorController
 * @Author hjk
 * @Date 2021/12/31 21:45
 **/
@RestController
@RequestMapping("/v1")
public class CollectorController {
    @Autowired
    private CollectorService collectorService;

    @PostMapping("/collector")
    public ResponseEntity<Integer> addCollector(CollectorInfo collector) throws BusinessException {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, collectorService.insertCollector(collector));
    }

    @PostMapping("/collectors")
    public ResponseEntity<Integer> addCollectors(List<CollectorInfo> collectorInfoList) throws BusinessException {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, collectorService.insertCollectorList(collectorInfoList));
    }

    @DeleteMapping("/collectors/{collectorId}")
    public ResponseEntity<Integer> deleteCollector(@PathVariable("collectorId") Integer collectorId) throws BusinessException {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, collectorService.deleteCollectorById(collectorId));
    }

    @PutMapping("/collectors")
    public ResponseEntity<Integer> updateCollectorInfo(CollectorInfo collectorInfo) throws BusinessException {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, collectorService.updateCollectorInfo(collectorInfo));
    }

    @GetMapping("/collectors/{collectorId}")
    public ResponseEntity<CollectorInfo> getCollector(@PathVariable("collectorId") Integer collectorId) throws BusinessException {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, collectorService.selectCollectorById(collectorId));
    }

    @GetMapping("/collectors")
    public ResponseEntity<List<CollectorInfo>> getCollectors() {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, collectorService.selectCollectors());
    }

    @GetMapping("/collectors/{collectorId}/presenters")
    public ResponseEntity<CollectorInfo> getMyPresenters(@PathVariable("collectorId") Integer collectorId) {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, collectorService.selectMyPresenters(collectorId));
    }

    @GetMapping("/collectors/{collectorId}/published-tasks")
    public ResponseEntity<CollectorInfo> getPublishedTasks(@PathVariable("collectorId") Integer collectorId) {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, collectorService.selectPublishedTasks(collectorId));
    }
}
