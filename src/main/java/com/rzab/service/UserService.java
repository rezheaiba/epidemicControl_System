package com.rzab.service;

import com.rzab.dao.UserDao;
import com.rzab.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-04-11 11:31
 **/

@Service
public class UserService {

    @Qualifier("userDao")
    @Autowired
    private UserDao userDao;

    //user登录,根据userid和password查找
    public User selectUser(String user_name, String user_password) {
        return userDao.selectUser(user_name, user_password);
    }

    //uepc登录,根据userid和password查找
    public User selectEpc(String user_name, String user_password) {
        return userDao.selectEpc(user_name, user_password);
    }

    //查询所有用户
    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }

    //根据当前user_id来改变user_checkin(0：未打卡1：已打卡)
    public void updateUserCheckInTo0(Integer user_id) {
        userDao.updateUserCheckInTo0(user_id);
    }

    //根据当前user_id来改变user_checkin(0：未打卡1：已打卡)
    public void updateUserCheckInTo1(Integer user_id) {
        userDao.updateUserCheckInTo1(user_id);
    }

    //查询未打卡人员
    public List<User> selectNotCheckIn() {
        return userDao.selectNotCheckIn();
    }

    //根据user_id查询签到状态
    public Integer selectCheckInById(Integer user_id) {
        return userDao.selectCheckInById(user_id);
    }

    //根据id查找user
    public User selectUserById(Integer user_id) {
        return userDao.selectUserById(user_id);
    }

    //user修改密码
    public void updatePassById(String user_password, Integer user_id){
        userDao.updatePassById(user_password,user_id);
    }

    //用户更新申请防疫员状态——>1
    public void updateApplyStatus(Integer user_id){
        userDao.updateApplyStatus(user_id);
    }

    //管理员查看申请的user
    public List<User> selectUserApply(){
        return userDao.selectUserApply();
    }

    //管理员同意，修改user类型并将状态置0
    public void updateAgree(Integer user_id){
        userDao.updateAgree(user_id);
    }

    //管理员不同意，将状态置0
    public void updateDisagree(Integer user_id){
        userDao.updateDisagree(user_id);
    }

    //admin根据id修改用户名或密码
    public void updateNameOrPassById(User user){
        userDao.updateNameOrPassById(user);
    }
}
