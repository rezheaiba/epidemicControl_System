package com.rzab.pojo;

/**
 * @author 热着爱吧
 * @create 2021-04-11 10:53
 **/

public class UserInfo {
    private Integer user_id;
    private String user_name;
    private Double user_temperature;
    private String physical_condition;
    private String contact_condition;
    private String user_loc;
    private String operate_time;

    @Override
    public String toString() {
        return "UserInfo{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_temperature=" + user_temperature +
                ", physical_condition='" + physical_condition + '\'' +
                ", contact_condition='" + contact_condition + '\'' +
                ", user_loc='" + user_loc + '\'' +
                ", operate_time='" + operate_time + '\'' +
                '}';
    }

    public String getOperate_time() {
        return operate_time;
    }

    public void setOperate_time(String operate_time) {
        this.operate_time = operate_time;
    }

    public UserInfo(Integer user_id, String user_name, Double user_temperature, String physical_condition, String contact_condition, String user_loc, String operate_time) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_temperature = user_temperature;
        this.physical_condition = physical_condition;
        this.contact_condition = contact_condition;
        this.user_loc = user_loc;
        this.operate_time = operate_time;
    }

    public UserInfo() {
    }

    public Integer getUser_id() {
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

    public Double getUser_temperature() {
        return user_temperature;
    }

    public void setUser_temperature(Double user_temperature) {
        this.user_temperature = user_temperature;
    }

    public String getPhysical_condition() {
        return physical_condition;
    }

    public void setPhysical_condition(String physical_condition) {
        this.physical_condition = physical_condition;
    }

    public String getContact_condition() {
        return contact_condition;
    }

    public void setContact_condition(String contact_condition) {
        this.contact_condition = contact_condition;
    }

    public String getUser_loc() {
        return user_loc;
    }

    public void setUser_loc(String user_loc) {
        this.user_loc = user_loc;
    }
}
