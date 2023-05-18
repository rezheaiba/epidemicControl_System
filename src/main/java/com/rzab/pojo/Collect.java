package com.rzab.pojo;

/**
 * @author 热着爱吧
 * @create 2021-04-11 11:06
 **/

public class Collect {
    private Integer id;
    private String name;
    private String sex;
    private String class_grade;
    private String idcard_number;
    private String phone_number;
    private String parent_phone_number;
    private String dormitory;
    private String home_loc;
    private String traveling_loc;

    public Collect() {
    }

    public Collect(Integer id, String name, String sex, String class_grade, String idcard_number, String phone_number, String parent_phone_number, String dormitory, String home_loc, String traveling_loc) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.class_grade = class_grade;
        this.idcard_number = idcard_number;
        this.phone_number = phone_number;
        this.parent_phone_number = parent_phone_number;
        this.dormitory = dormitory;
        this.home_loc = home_loc;
        this.traveling_loc = traveling_loc;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", class_grade='" + class_grade + '\'' +
                ", idcard_number='" + idcard_number + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", parent_phone_number='" + parent_phone_number + '\'' +
                ", dormitory='" + dormitory + '\'' +
                ", home_loc='" + home_loc + '\'' +
                ", traveling_loc='" + traveling_loc + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClass_grade() {
        return class_grade;
    }

    public void setClass_grade(String class_grade) {
        this.class_grade = class_grade;
    }

    public String getIdcard_number() {
        return idcard_number;
    }

    public void setIdcard_number(String idcard_number) {
        this.idcard_number = idcard_number;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getParent_phone_number() {
        return parent_phone_number;
    }

    public void setParent_phone_number(String parent_phone_number) {
        this.parent_phone_number = parent_phone_number;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public String getHome_loc() {
        return home_loc;
    }

    public void setHome_loc(String home_loc) {
        this.home_loc = home_loc;
    }

    public String getTraveling_loc() {
        return traveling_loc;
    }

    public void setTraveling_loc(String traveling_loc) {
        this.traveling_loc = traveling_loc;
    }

    public Collect(String name, String sex, String class_grade, String idcard_number, String phone_number, String parent_phone_number, String dormitory, String home_loc, String traveling_loc) {
        this.name = name;
        this.sex = sex;
        this.class_grade = class_grade;
        this.idcard_number = idcard_number;
        this.phone_number = phone_number;
        this.parent_phone_number = parent_phone_number;
        this.dormitory = dormitory;
        this.home_loc = home_loc;
        this.traveling_loc = traveling_loc;
    }
}
