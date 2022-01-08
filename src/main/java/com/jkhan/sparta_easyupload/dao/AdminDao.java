package com.jkhan.sparta_easyupload.dao;

import com.jkhan.sparta_easyupload.bean.AdminInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdminDao {
    AdminInfo checkIdentity(String adminTelNumber, String password);
    List<String> selectAdmins();
}
