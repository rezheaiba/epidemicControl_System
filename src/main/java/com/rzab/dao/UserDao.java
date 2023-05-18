package com.rzab.dao;

import com.rzab.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-04-11 11:28
 **/

@Mapper
@Repository("userDao")
public interface UserDao {

    //user登录,根据userid和password查找
    User selectUser(@Param("user_name") String user_name, @Param("user_password") String user_password);

    //epc登录,根据userid和password查找
    User selectEpc(@Param("user_name") String user_name, @Param("user_password") String user_password);

    //查询所有用户
    List<User> selectAllUser();

    //根据当前user_id来改变user_checkin(0：未打卡1：已打卡)
    void updateUserCheckInTo0(Integer user_id);

    //根据当前user_id来改变user_checkin(0：未打卡1：已打卡)
    void updateUserCheckInTo1(Integer user_id);

    //查询未打卡人员
    List<User> selectNotCheckIn();

    //根据user_id查询签到状态
    Integer selectCheckInById(Integer user_id);

    //查看个人信息，根据user_id
    @Select("select user_id,user_password,user_name,user_type,user_checkin,applyStatus from user where user_id = #{user_id}")
    User selectUserById(Integer user_id);

    //user根据id修改密码
    @Update("update user set user_password = #{user_password} where user_id = #{user_id}")
    void updatePassById(@Param("user_password") String user_password, @Param("user_id") Integer user_id);

    //用户更新申请防疫员状态——>1
    @Update("update user set applyStatus = 1 where user_id = #{user_id}")
    void updateApplyStatus(Integer user_id);

    //管理员查看申请的user
    @Select("select user_id,user_password,user_name,user_type,user_checkin,applyStatus from user where user_type = '学生' " +
            "and applyStatus = 1")
    List<User> selectUserApply();

    //管理员同意，修改user类型并将状态置0
    @Update("update user set applyStatus = 0,user_type = '防疫员' where user_id = #{user_id}")
    void updateAgree(Integer user_id);

    //管理员不同意，将状态置0
    @Update("update user set applyStatus = 0 where user_id = #{user_id}")
    void updateDisagree(Integer user_id);

    //admin根据id修改用户名或密码
    @Update("update user set user_name = #{user_name},user_password = #{user_password} where user_id = #{user_id}")
    void updateNameOrPassById(User user);
}
