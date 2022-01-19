package com.jkhan.sparta_easy_upload.controller;

import com.jkhan.sparta_easy_upload.bean.LabelInfo;
import com.jkhan.sparta_easy_upload.bean.ResponseEntity;
import com.jkhan.sparta_easy_upload.enumeration.CommonResponseEnum;
import com.jkhan.sparta_easy_upload.exception.BusinessException;
import com.jkhan.sparta_easy_upload.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName LabelController
 * @Description LabelController
 * @Author hjk
 * @Date 2022/1/15 19:13
 **/
@RestController
@RequestMapping("/v1")
public class LabelController {
    @Autowired
    private LabelService labelService;

    @PostMapping("/labels")
    public ResponseEntity<Integer> addLabel(LabelInfo label) throws BusinessException {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, labelService.insertLabel(label));
    }

    @DeleteMapping("/labels/{labelId}")
    public ResponseEntity<Integer> deleteLabel(@PathVariable("labelId") Integer labelId) throws BusinessException {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, labelService.deleteLabelById(labelId));
    }

    @PutMapping("/labels/{labelId}")
    public ResponseEntity<Integer> updateLabelInfo(LabelInfo labelInfo) throws BusinessException {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, labelService.updateLabelInfo(labelInfo));
    }

    @GetMapping("/labels//{labelId}/presenters")
    public ResponseEntity<LabelInfo> getLabelPresenters(@PathVariable("labelId") Integer labelId) throws BusinessException {
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, labelService.selectLabelPresenters(labelId));
    }
}
