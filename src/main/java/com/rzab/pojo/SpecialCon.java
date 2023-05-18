package com.rzab.pojo;

/**
 * @author 热着爱吧
 * @create 2021-05-06 11:17
 **/

public class SpecialCon {
    private Integer specialCon_id;
    private String specialCon_content;

    public SpecialCon() {
    }

    public SpecialCon(String specialCon_content) {
        this.specialCon_content = specialCon_content;
    }

    public SpecialCon(Integer specialCon_id, String specialCon_content) {
        this.specialCon_id = specialCon_id;
        this.specialCon_content = specialCon_content;
    }

    public Integer getSpecialCon_id() {
        return specialCon_id;
    }

    public void setSpecialCon_id(Integer specialCon_id) {
        this.specialCon_id = specialCon_id;
    }

    public String getSpecialCon_content() {
        return specialCon_content;
    }

    public void setSpecialCon_content(String specialCon_content) {
        this.specialCon_content = specialCon_content;
    }

    @Override
    public String toString() {
        return "SpecialCon{" +
                "specialCon_id=" + specialCon_id +
                ", specialCon_content='" + specialCon_content + '\'' +
                '}';
    }
}
