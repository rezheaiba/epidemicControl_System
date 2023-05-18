package com.rzab.pojo;

/**
 * @author 热着爱吧
 * @create 2021-04-16 13:11
 **/

public class Message {
    private int message_id;
    private String message_content;
    private String user_name;
    private String user_type;

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public Message(String message_content, String user_name, String user_type) {
        this.message_content = message_content;
        this.user_name = user_name;
        this.user_type = user_type;
    }

    @Override
    public String toString() {
        return "message{" +
                "message_id=" + message_id +
                ", message_content='" + message_content + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_type='" + user_type + '\'' +
                '}';
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getMessage_content() {
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    public Message() {
    }

}
