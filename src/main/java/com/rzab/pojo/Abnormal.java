package com.rzab.pojo;

/**
 * @author 热着爱吧
 * @create 2021-04-11 10:57
 **/

public class Abnormal {
    private Integer abnormal_id;
    private String abnormal_name;
    private String abnormal_time;
    private String abnormal_comment;

    @Override
    public String toString() {
        return "Abnormal{" +
                "abnormal_id=" + abnormal_id +
                ", abnormal_name='" + abnormal_name + '\'' +
                ", abnormal_time='" + abnormal_time + '\'' +
                ", abnormal_comment='" + abnormal_comment + '\'' +
                '}';
    }

    public Integer getAbnormal_id() {
        return abnormal_id;
    }

    public void setAbnormal_id(Integer abnormal_id) {
        this.abnormal_id = abnormal_id;
    }

    public String getAbnormal_name() {
        return abnormal_name;
    }

    public void setAbnormal_name(String abnormal_name) {
        this.abnormal_name = abnormal_name;
    }

    public String getAbnormal_time() {
        return abnormal_time;
    }

    public void setAbnormal_time(String abnormal_time) {
        this.abnormal_time = abnormal_time;
    }

    public String getAbnormal_comment() {
        return abnormal_comment;
    }

    public void setAbnormal_comment(String abnormal_comment) {
        this.abnormal_comment = abnormal_comment;
    }

    public Abnormal(Integer abnormal_id, String abnormal_name, String abnormal_time, String abnormal_comment) {
        this.abnormal_id = abnormal_id;
        this.abnormal_name = abnormal_name;
        this.abnormal_time = abnormal_time;
        this.abnormal_comment = abnormal_comment;
    }

    public Abnormal() {
    }
}
