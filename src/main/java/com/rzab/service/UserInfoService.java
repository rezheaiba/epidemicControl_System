package com.rzab.service;

import com.rzab.dao.UserInfoDao;
import com.rzab.pojo.User;
import com.rzab.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-04-19 16:00
 **/

@Service
public class UserInfoService {
    @Qualifier("userInfoDao")

    @Autowired
    private UserInfoDao userInfoDao;

    //1.将用户填写的打卡信息填入表中
    public void insertUserInfo(UserInfo userInfo) {
        userInfoDao.insertUserInfo(userInfo);
    }

    //2.首先查找用户是否打过第一次卡，打过的话才能查看上一次打卡位置,按日期倒序
    public List<UserInfo> selectUserInfoById(Integer user_id) {
        return userInfoDao.selectUserInfoById(user_id);
    }

    //3.查找用户上一次打卡的位置
    public String selectPreLoc(Integer user_id) {
        return userInfoDao.selectPreLoc(user_id);
    }

    //4.根据time倒序全部
    public List<UserInfo> selectUserInfoByIdOrderByTime(Integer user_id) {
        return userInfoDao.selectUserInfoByIdOrderByTime(user_id);
    }

    //5.admin查询所有userinfo根据日期倒序
    public List<UserInfo> selectAllUserInfo(){
        return userInfoDao.selectAllUserInfo();
    }
}
