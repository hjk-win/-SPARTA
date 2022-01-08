package com.jkhan.sparta_easyupload.controller;

import com.jkhan.sparta_easyupload.bean.ResponseEntity;
import com.jkhan.sparta_easyupload.enumeration.CommonResponseEnum;
import com.jkhan.sparta_easyupload.exception.BusinessException;
import com.jkhan.sparta_easyupload.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AdminController
 * @Description AdminController
 * @Author hjk
 * @Date 2022/1/6 20:35
 **/
@RestController
@RequestMapping("/v1")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/admin")
    public ResponseEntity<String> checkIdentity(String adminTelNumber, String password) throws BusinessException {
        adminService.checkIdentity(adminTelNumber, password);
        return new ResponseEntity<>(CommonResponseEnum.SUCCESS, adminTelNumber);
    }
}
