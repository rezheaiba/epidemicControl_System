package com.rzab.dao;

import com.rzab.pojo.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-04-19 15:55
 **/

@Mapper
@Repository("userInfoDao")
public interface UserInfoDao {

    //将用户填写的打卡信息填入表中
    @Insert("insert into userinfo values(#{user_id},#{user_name},#{user_temperature},#{physical_condition},#{contact_condition},#{user_loc},#{operate_time})")
    void insertUserInfo(UserInfo userInfo);

    //查看是否有userinfo
    @Select("select user_id,user_name,user_temperature,physical_condition,contact_condition,user_loc,operate_time from userinfo where user_id = #{user_id}")
    List<UserInfo> selectUserInfoById(Integer user_id);

    //查找用户上一次打卡的位置
    @Select("select user_loc from userinfo where user_id = #{user_id} order by operate_time desc limit 1")
    String selectPreLoc(Integer user_id);

    //首先查找用户是否打过第一次卡，打过的话才能查看上一次打卡位置,按日期倒序
    @Select("select user_id,user_name,user_temperature,physical_condition,contact_condition,user_loc,operate_time from userinfo where user_id = #{user_id} order by operate_time desc")
    List<UserInfo> selectUserInfoByIdOrderByTime(Integer user_id);

    //admin查询所有userinfo根据日期倒序
    @Select("select user_id,user_name,user_temperature,physical_condition,contact_condition,user_loc,operate_time from userinfo order by operate_time desc")
    List<UserInfo> selectAllUserInfo();
}
