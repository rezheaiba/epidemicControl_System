package com.rzab.pojo;

/**
 * @author 热着爱吧
 * @create 2021-04-23 14:16
 **/

public class Appoint {
    private Integer appoint_id;
    private Integer appoint_userid;
    private String appoint_username;
    private String appoint_phonenum;

    public Appoint(Integer appoint_userid, String appoint_username, String appoint_phonenum, String appoint_project, String appoint_time, String appoint_status) {
        this.appoint_userid = appoint_userid;
        this.appoint_username = appoint_username;
        this.appoint_phonenum = appoint_phonenum;
        this.appoint_project = appoint_project;
        this.appoint_time = appoint_time;
        this.appoint_status = appoint_status;
    }

    @Override
    public String toString() {
        return "Appoint{" +
                "appoint_id=" + appoint_id +
                ", appoint_userid=" + appoint_userid +
                ", appoint_username='" + appoint_username + '\'' +
                ", appoint_phonenum='" + appoint_phonenum + '\'' +
                ", appoint_project='" + appoint_project + '\'' +
                ", appoint_time='" + appoint_time + '\'' +
                ", appoint_status='" + appoint_status + '\'' +
                '}';
    }

    public String getAppoint_phonenum() {
        return appoint_phonenum;
    }

    public void setAppoint_phonenum(String appoint_phonenum) {
        this.appoint_phonenum = appoint_phonenum;
    }

    public Appoint(Integer appoint_id, Integer appoint_userid, String appoint_username, String appoint_phonenum, String appoint_project, String appoint_time, String appoint_status) {
        this.appoint_id = appoint_id;
        this.appoint_userid = appoint_userid;
        this.appoint_username = appoint_username;
        this.appoint_phonenum = appoint_phonenum;
        this.appoint_project = appoint_project;
        this.appoint_time = appoint_time;
        this.appoint_status = appoint_status;
    }

    private String appoint_project;
    private String appoint_time;
    private String appoint_status;

    public Integer getAppoint_id() {
        return appoint_id;
    }

    public void setAppoint_id(Integer appoint_id) {
        this.appoint_id = appoint_id;
    }

    public Integer getAppoint_userid() {
        return appoint_userid;
    }

    public void setAppoint_userid(Integer appoint_userid) {
        this.appoint_userid = appoint_userid;
    }

    public String getAppoint_username() {
        return appoint_username;
    }

    public void setAppoint_username(String appoint_username) {
        this.appoint_username = appoint_username;
    }

    public String getAppoint_project() {
        return appoint_project;
    }

    public void setAppoint_project(String appoint_project) {
        this.appoint_project = appoint_project;
    }

    public String getAppoint_time() {
        return appoint_time;
    }

    public void setAppoint_time(String appoint_time) {
        this.appoint_time = appoint_time;
    }

    public String getAppoint_status() {
        return appoint_status;
    }

    public void setAppoint_status(String appoint_status) {
        this.appoint_status = appoint_status;
    }

    public Appoint() {
    }

    public Appoint(Integer appoint_id, Integer appoint_userid, String appoint_username, String appoint_project, String appoint_time, String appoint_status) {
        this.appoint_id = appoint_id;
        this.appoint_userid = appoint_userid;
        this.appoint_username = appoint_username;
        this.appoint_project = appoint_project;
        this.appoint_time = appoint_time;
        this.appoint_status = appoint_status;
    }
}
