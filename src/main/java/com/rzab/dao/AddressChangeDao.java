package com.rzab.dao;

import com.rzab.pojo.AddressChange;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-04-19 19:01
 **/

@Mapper
@Repository("addressChangeDao")
public interface AddressChangeDao {

    //将位置变化异常添加到addressChange表中
    @Insert("insert into addresschange values(#{change_userid},#{change_username},#{change_time},#{changeto_loc},#{loc_risklevel})")
    void insertAddressChange(AddressChange addressChange);

    //查询所有地质变化的学生
    @Select("select change_userid,change_username,change_time,changeto_loc,loc_risklevel from addresschange order by change_time desc")
    List<AddressChange> selectAllArsChange();
}
