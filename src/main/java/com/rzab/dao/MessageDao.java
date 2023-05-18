package com.rzab.dao;

import com.rzab.pojo.Message;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-05-06 21:58
 **/

@Mapper
@Repository("messageDao")
public interface MessageDao {

    //新增留言
    @Insert("insert into message(message_content,user_name,user_type) " +
            "values(#{message_content},#{user_name},#{user_type})")
    void insertMessage(Message message);

    //学生端查询所有学生留言
    @Select("select message_id,message_content,user_name,user_type from message where user_type = '学生'")
    List<Message> selectUserMessage();

    //EPC端查询所有学生留言
    @Select("select message_id,message_content,user_name,user_type from message where user_type = '防疫员'")
    List<Message> selectEpcMessage();

    //admin查询所有留言
    @Select("select message_id,message_content,user_name,user_type from message")
    List<Message> selectAllMessage();

    //根据id删除message
    @Delete("delete from message where message_id = #{message_id}")
    void delMessageById(Integer message_id);
}
