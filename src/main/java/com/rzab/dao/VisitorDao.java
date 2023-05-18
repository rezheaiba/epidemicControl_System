package com.rzab.dao;

import com.rzab.pojo.Visitor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-05-05 23:01
 **/

@Mapper
@Repository("visitorDao")
public interface VisitorDao {

    //添加访客信息
    @Insert("insert into visitor(visitor_name,visitor_sex,visitor_temperature,visitor_phone_num," +
            "visitor_car_num,visitor_time) values(#{visitor_name},#{visitor_sex}," +
            "#{visitor_temperature},#{visitor_phone_num},#{visitor_car_num},#{visitor_time})")
    void insertVisitor(Visitor visitor);

    //查询所有访客信息
    @Select("select visitor_id,visitor_name,visitor_sex,visitor_temperature,visitor_phone_num,visitor_car_num,visitor_time from visitor")
    List<Visitor> selectAllVisitor();

    //删除visitor
    @Delete("delete from visitor where visitor_id = #{visitor_id}")
    void delVisitor(Integer visitor_id);
}
