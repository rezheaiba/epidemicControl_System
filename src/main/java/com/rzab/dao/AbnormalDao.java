package com.rzab.dao;

import com.rzab.pojo.Abnormal;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-04-23 14:21
 **/

@Mapper
@Repository("abnormalDao")
public interface AbnormalDao {

    //将异常温度（>37.3摄氏度）放到异常表中
    @Insert("insert into abnormal values(#{abnormal_id}, #{abnormal_name},#{abnormal_time},#{abnormal_comment})")
    void insertAbnormal(Abnormal abnormal);

    //查询所有异常信息
    @Select("select abnormal_id,abnormal_name,abnormal_time,abnormal_comment from abnormal order by abnormal_time desc")
    List<Abnormal> selectAllAbnormal();

}
