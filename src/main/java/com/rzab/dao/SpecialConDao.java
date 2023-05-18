package com.rzab.dao;

import com.rzab.pojo.SpecialCon;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 热着爱吧
 * @create 2021-05-06 11:19
 **/

@Mapper
@Repository("specialConDao")
public interface SpecialConDao {

    //新增特殊事项
    @Insert("insert into specialCon(specialCon_content) values(#{specialCon_content})")
    void insertSpecialCon(SpecialCon specialCon);
}
