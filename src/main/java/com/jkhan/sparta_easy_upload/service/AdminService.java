package com.jkhan.sparta_easy_upload.service;

import com.jkhan.sparta_easy_upload.bean.AdminInfo;
import com.jkhan.sparta_easy_upload.exception.BusinessException;

import java.util.List;

public interface AdminService {
    AdminInfo checkIdentity(String adminTelNumber, String password) throws BusinessException;
    List<String> selectAdmins();
}
