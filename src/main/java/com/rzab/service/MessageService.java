package com.rzab.service;

import com.rzab.dao.MessageDao;
import com.rzab.pojo.Message;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-05-06 22:01
 **/

@Service
public class MessageService {

    @Qualifier("messageDao")
    @Autowired
    private MessageDao messageDao;

    public void insertMessage(Message message) {
        messageDao.insertMessage(message);
    }

    //学生端查询所有学生留言
    public List<Message> selectUserMessage() {
        return messageDao.selectUserMessage();
    }

    //epc端查询所有学生留言
    public List<Message> selectEpcMessage() {
        return messageDao.selectEpcMessage();
    }

    //admin查询全部
    public List<Message> selectAllMessage(){
        return messageDao.selectAllMessage();
    }

    //根据id删除message
    public void delMessageById(Integer message_id){
    messageDao.delMessageById(message_id);
    }
}
