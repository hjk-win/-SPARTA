package com.jkhan.sparta_easy_upload.service.impl;

import com.jkhan.sparta_easy_upload.bean.AdminInfo;
import com.jkhan.sparta_easy_upload.constant.CommonConstant;
import com.jkhan.sparta_easy_upload.dao.AdminDao;
import com.jkhan.sparta_easy_upload.exception.BusinessException;
import com.jkhan.sparta_easy_upload.service.AdminService;
import com.jkhan.sparta_easy_upload.util.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AdminServiceImpl
 * @Description AdminServiceImpl
 * @Author hjk
 * @Date 2022/1/6 20:13
 **/
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public AdminInfo checkIdentity(String adminTelNumber, String password) throws BusinessException {
        log.info(CommonConstant.SELECT_FORM_DB, "admin: " + adminTelNumber);
        if (!isExist(adminTelNumber)) {
            throw new BusinessException(CommonConstant.NOT_EXIST);
        }
        AdminInfo admin = adminDao.checkIdentity(adminTelNumber, password);
        AssertUtil.notNull(admin, CommonConstant.PASSWORD_ERROR);
        return admin;
    }

    @Override
    public List<String> selectAdmins() {
        log.info(CommonConstant.SELECT_FORM_DB, "admins");
        return adminDao.selectAdmins();
    }

    private boolean isExist(String tel) {
        List<String> list = selectAdmins();
        for (String str : list) {
            if (tel.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
