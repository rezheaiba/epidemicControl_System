package com.rzab.pojo;

/**
 * @author 热着爱吧
 * @create 2021-04-10 23:30
 **/

public class User {
    private Integer user_id;
    private String user_name;
    private String user_password;
    private String user_type;
    private Integer user_checkin;

    public User(Integer user_id, String user_name, String user_password) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
    }

    private String applyStatus;

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_type='" + user_type + '\'' +
                ", user_checkin=" + user_checkin +
                ", applyStatus='" + applyStatus + '\'' +
                '}';
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public User(String user_name, String user_password, String user_type, Integer user_checkin, String applyStatus) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_type = user_type;
        this.user_checkin = user_checkin;
        this.applyStatus = applyStatus;
    }

    public User(Integer user_id, String user_name, String user_password, String user_type, Integer user_checkin, String applyStatus) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_type = user_type;
        this.user_checkin = user_checkin;
        this.applyStatus = applyStatus;
    }

    public Integer getUser_checkin() {
        return user_checkin;
    }

    public void setUser_checkin(Integer user_checkin) {
        this.user_checkin = user_checkin;
    }

    public User(Integer user_id, String user_name, String user_password, String user_type, Integer user_checkin) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_type = user_type;
        this.user_checkin = user_checkin;
    }

    public User() {
    }

    public User(Integer user_id, String user_name, String user_password, String user_type) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_type = user_type;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

}