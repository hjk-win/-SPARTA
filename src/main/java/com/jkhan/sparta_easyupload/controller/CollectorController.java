package com.jkhan.sparta_easyupload.controller;

import com.jkhan.sparta_easyupload.bean.CollectorInfo;
import com.jkhan.sparta_easyupload.bean.ResponseEntity;
import com.jkhan.sparta_easyupload.enumeration.CommonResponseEnum;
import com.jkhan.sparta_easyupload.exception.BusinessException;
import com.jkhan.sparta_easyupload.service.CollectorService;
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

    @GetMapping("/collector/{collectorId}")
    public ResponseEntity<CollectorInfo> getCollector(@PathVariable("collectorId") long collectorId) throws BusinessException {
        return new ResponseEntity<CollectorInfo>(CommonResponseEnum.SUCCESS, collectorService.selectCollectorById(collectorId));
    }

    @PostMapping("/collector")
    public ResponseEntity<Integer> addCollector(String collectorName, String collectorTelNumber, String collectorEmail) throws BusinessException {
        return new ResponseEntity<Integer>(CommonResponseEnum.SUCCESS, collectorService.insertCollector(collectorName, collectorTelNumber, collectorEmail));
    }

    @PutMapping("/collector")
    public ResponseEntity<Integer> updateCollectorInfo(CollectorInfo collectorInfo) throws BusinessException {
        return new ResponseEntity<Integer>(CommonResponseEnum.SUCCESS, collectorService.updateCollectorInfo(collectorInfo));
    }

    @DeleteMapping("/collector/{collectorId}")
    public ResponseEntity<Integer> deleteCollector(@PathVariable("collectorId") long collectorId) throws BusinessException {
        return new ResponseEntity<Integer>(CommonResponseEnum.SUCCESS, collectorService.deleteCollectorById(collectorId));
    }

    @PostMapping("/collectors")
    public ResponseEntity<Integer> addCollectors(List<CollectorInfo> collectorInfoList) throws BusinessException {
        return new ResponseEntity<Integer>(CommonResponseEnum.SUCCESS, collectorService.insertCollectorList(collectorInfoList));
    }

    @GetMapping("collectors")
    public ResponseEntity<List<CollectorInfo>> selectAllCollector() {
        return new ResponseEntity<List<CollectorInfo>>(CommonResponseEnum.SUCCESS, collectorService.selectCollectors());
    }
}
