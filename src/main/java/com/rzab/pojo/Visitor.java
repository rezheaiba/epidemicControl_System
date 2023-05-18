package com.rzab.pojo;

/**
 * @author 热着爱吧
 * @create 2021-04-14 14:03
 **/

public class Visitor {
    private Integer visitor_id;
    private String visitor_name;
    private String visitor_sex;
    private String visitor_temperature;
    private String visitor_phone_num;
    private String visitor_car_num;
    private String visitor_time;

    public Visitor() {
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "visitor_id=" + visitor_id +
                ", visitor_name='" + visitor_name + '\'' +
                ", visitor_sex='" + visitor_sex + '\'' +
                ", visitor_temperature='" + visitor_temperature + '\'' +
                ", visitor_phone_num='" + visitor_phone_num + '\'' +
                ", visitor_car_num='" + visitor_car_num + '\'' +
                ", visitor_time='" + visitor_time + '\'' +
                '}';
    }

    public Integer getVisitor_id() {
        return visitor_id;
    }

    public void setVisitor_id(Integer visitor_id) {
        this.visitor_id = visitor_id;
    }

    public String getVisitor_name() {
        return visitor_name;
    }

    public void setVisitor_name(String visitor_name) {
        this.visitor_name = visitor_name;
    }

    public String getVisitor_sex() {
        return visitor_sex;
    }

    public void setVisitor_sex(String visitor_sex) {
        this.visitor_sex = visitor_sex;
    }

    public String getVisitor_temperature() {
        return visitor_temperature;
    }

    public void setVisitor_temperature(String visitor_temperature) {
        this.visitor_temperature = visitor_temperature;
    }

    public String getVisitor_phone_num() {
        return visitor_phone_num;
    }

    public void setVisitor_phone_num(String visitor_phone_num) {
        this.visitor_phone_num = visitor_phone_num;
    }

    public String getVisitor_car_num() {
        return visitor_car_num;
    }

    public void setVisitor_car_num(String visitor_car_num) {
        this.visitor_car_num = visitor_car_num;
    }

    public String getVisitor_time() {
        return visitor_time;
    }

    public void setVisitor_time(String visitor_time) {
        this.visitor_time = visitor_time;
    }

    public Visitor(String visitor_name, String visitor_sex, String visitor_temperature, String visitor_phone_num, String visitor_car_num, String visitor_time) {
        this.visitor_name = visitor_name;
        this.visitor_sex = visitor_sex;
        this.visitor_temperature = visitor_temperature;
        this.visitor_phone_num = visitor_phone_num;
        this.visitor_car_num = visitor_car_num;
        this.visitor_time = visitor_time;
    }

    public Visitor(Integer visitor_id, String visitor_name, String visitor_sex, String visitor_temperature, String visitor_phone_num, String visitor_car_num, String visitor_time) {
        this.visitor_id = visitor_id;
        this.visitor_name = visitor_name;
        this.visitor_sex = visitor_sex;
        this.visitor_temperature = visitor_temperature;
        this.visitor_phone_num = visitor_phone_num;
        this.visitor_car_num = visitor_car_num;
        this.visitor_time = visitor_time;
    }
}
