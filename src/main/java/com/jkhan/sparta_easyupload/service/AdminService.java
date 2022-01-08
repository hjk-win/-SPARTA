package com.jkhan.sparta_easyupload.service;

import com.jkhan.sparta_easyupload.bean.AdminInfo;
import com.jkhan.sparta_easyupload.exception.BusinessException;

import java.util.List;

public interface AdminService {
    AdminInfo checkIdentity(String adminTelNumber, String password) throws BusinessException;
    List<String> selectAdmins();
}
