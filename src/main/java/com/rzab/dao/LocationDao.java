package com.rzab.dao;

import com.rzab.pojo.Location;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-04-19 19:14
 **/

@Mapper
@Repository("locationDao")
public interface LocationDao {

    //根据城市名称来查找本条数据
    List<Location> selectLocByName(@Param("loc_name") String loc_name);

    //增加新地址
    void insertNewLocation(Location location);

    //查询全部城市
    @Select("select loc_id,loc_name,loc_risklevel from location")
    List<Location> selectAllLocation();

    //修改城市地址信息
    @Update("update location set loc_name = #{loc_name},loc_risklevel = #{loc_risklevel} where loc_id = #{loc_id}")
    void updateLocationById(Location location);

    //根据id删除地址
    @Delete("delete from location where loc_id = #{loc_id}")
    void delLocationById(Integer loc_id);
}
