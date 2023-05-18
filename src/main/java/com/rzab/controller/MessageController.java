package com.rzab.controller;


import com.rzab.pojo.Message;
import com.rzab.pojo.Msg;
import com.rzab.service.MessageService;
import com.rzab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-05-06 22:02
 **/

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    //新增留言
    @RequestMapping("/insertMessage")
    @ResponseBody
    public Msg insertMessage(String message_content, String user_name, String user_id) {
        Message message = new Message();
        message.setMessage_content(message_content);
        message.setUser_name(user_name);
        message.setUser_type(userService.selectUserById(Integer.parseInt(user_id)).getUser_type());
        messageService.insertMessage(message);
        return Msg.success();
    }

    //user查询留言
    @RequestMapping("/selectUserMessage")
    @ResponseBody
    public Msg selectUserMessage() {
        List<Message> messageList = messageService.selectUserMessage();
        //不为空
        if (!messageList.isEmpty()) {
            return Msg.success().add("messageList", messageList);
        } else return Msg.fail();
    }

    //epc查询留言
    @RequestMapping("/selectEpcMessage")
    @ResponseBody
    public Msg selectEpcMessage() {
        List<Message> messageList = messageService.selectEpcMessage();
        //不为空
        if (!messageList.isEmpty()) {
            return Msg.success().add("messageList", messageList);
        } else return Msg.fail();
    }

    //admin查询留言
    @RequestMapping("/selectAllMessage")
    @ResponseBody
    public Msg selectAllMessage() {
        List<Message> messageList = messageService.selectAllMessage();
        //不为空
        if (!messageList.isEmpty()) {
            return Msg.success().add("messageList", messageList);
        } else return Msg.fail();
    }


    //admin删除留言byid
    @RequestMapping("/delMessageById")
    @ResponseBody
    public Msg delMessageById(String message_id) {
        messageService.delMessageById(Integer.parseInt(message_id));
        return Msg.success();
    }
}
