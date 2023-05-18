package com.rzab.service;

import com.rzab.dao.AdminDao;
import com.rzab.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-04-11 11:31
 **/

@Service
public class AdminService {

    @Qualifier("adminDao")
    @Autowired
    private AdminDao adminDao;

    public Admin selectAdmin(String admin_name, String admin_password) {
        return adminDao.selectAdmin(admin_name, admin_password);
    }

}
