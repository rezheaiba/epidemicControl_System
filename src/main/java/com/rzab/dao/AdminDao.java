package com.rzab.dao;

import com.rzab.pojo.Admin;
import com.rzab.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 热着爱吧
 * @create 2021-04-18 13:45
 **/

@Mapper
@Repository("adminDao")
public interface AdminDao {
    //admin登录,根据admin_name和admin_password查找
    Admin selectAdmin(@Param("admin_name")String admin_name, @Param("admin_password")String admin_password);

}
