package com.rzab.dao;

import com.rzab.pojo.Collect;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-05-09 8:51
 **/

@Mapper
@Repository("collectDao")
public interface CollectDao {

    //查找上一次的收集，如果没有，从1开始
    @Select("select id,name,sex,class_grade,idcard_number,phone_number,parent_phone_number,dormitory,home_loc,traveling_loc " +
            "from collect where id = (select max(id) from collect)")
    List<Collect> selectPreCollect();

    //插入：插入前需要查找最大id，插入的id比最大id大1
    @Insert("insert into collect values(#{id},#{name},#{sex},#{class_grade},#{idcard_number},#{phone_number}," +
            "#{parent_phone_number},#{dormitory},#{home_loc},#{traveling_loc})")
    void insertCollect(Collect collect);

    //查看所有收集
    @Select("select id,name,sex,class_grade,idcard_number,phone_number,parent_phone_number,dormitory,home_loc,traveling_loc " +
            "from collect")
    List<Collect> selectAllCollect();
}
