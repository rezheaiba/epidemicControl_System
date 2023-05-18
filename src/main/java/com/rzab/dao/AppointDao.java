package com.rzab.dao;

import com.rzab.pojo.Appoint;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-04-26 9:24
 **/

@Mapper
@Repository("appointDao")
public interface AppointDao {

    //插入预约信息
    @Insert("insert into appoint(appoint_userid,appoint_username,appoint_phonenum,appoint_project,appoint_time,appoint_status) " +
            "values(#{appoint_userid},#{appoint_username},#{appoint_phonenum},#{appoint_project},#{appoint_time},#{appoint_status})")
    void insertAppoint(Appoint appoint);

    //根据id查询是否有此人的预约信息
    @Select("select appoint_id,appoint_userid,appoint_username,appoint_phonenum,appoint_project,appoint_time,appoint_status" +
            " from appoint where appoint_userid = #{appoint_userid} and appoint_project = '接种疫苗' and appoint_status = '预约成功'")
    Appoint selectAppointById(Integer appoint_userid);

    //admin预约信息查看
    @Select("select appoint_id,appoint_userid,appoint_username,appoint_phonenum,appoint_project,appoint_time,appoint_status from appoint")
    List<Appoint> selectAllAppoint();
}
