package com.rzab.dao;

import com.rzab.pojo.Notice;
import org.apache.ibatis.annotations.*;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-04-25 16:20
 **/

@Mapper
@Repository("noticeDao")
public interface NoticeDao {

    //插入一条信息
    @Insert("insert into notice(notice_content, notice_level, vaccine_date, vaccine_count) values(#{notice_content}, #{notice_level}, #{vaccine_date}, #{vaccine_count})")
    void insertNotice(Notice notice);

    //查找所有发布的通知
    @Select("select notice_id,notice_content,notice_level,vaccine_date,vaccine_count from notice")
    List<Notice> selectAllNotice();

    //查询最近日期的疫苗数量还有没有了
    @Select("select notice_id,vaccine_count from notice order by vaccine_date desc limit 1")
    Notice selectVaccine_count();

    //疫苗数目-1
    @Update("update notice set vaccine_count = vaccine_count - 1 where notice_id = #{notice_id}")
    void updateVaccine_count(Integer notice_id);

    //admin修改notice
    @Update("update notice set " +
            "notice_content = #{notice_content},notice_level = #{notice_level},vaccine_date = #{vaccine_date}, vaccine_count = #{vaccine_count} " +
            "where notice_id = #{notice_id}")
    void updateNoticeById(Notice notice);

    //根据id来删除notice
    @Delete("delete from notice where notice_id = #{notice_id}")
    void delNoticeById(Integer notice_id);
}
