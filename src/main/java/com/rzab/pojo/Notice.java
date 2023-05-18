package com.rzab.pojo;

/**
 * @author 热着爱吧
 * @create 2021-04-11 11:09
 **/

public class Notice {
    //该条通知的编号
    private Integer notice_id;
    //通知内容
    private String notice_content;
    //通知的重要程度(等级)
    private Integer notice_level;

    private String vaccine_date;

    private Integer vaccine_count;

    public Notice(Integer notice_id, Integer vaccine_count) {
        this.notice_id = notice_id;
        this.vaccine_count = vaccine_count;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "notice_id=" + notice_id +
                ", notice_content='" + notice_content + '\'' +
                ", notice_level=" + notice_level +
                ", vaccine_date='" + vaccine_date + '\'' +
                ", vaccine_count=" + vaccine_count +
                '}';
    }

    public Integer getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(Integer notice_id) {
        this.notice_id = notice_id;
    }

    public String getNotice_content() {
        return notice_content;
    }

    public void setNotice_content(String notice_content) {
        this.notice_content = notice_content;
    }

    public Integer getNotice_level() {
        return notice_level;
    }

    public void setNotice_level(Integer notice_level) {
        this.notice_level = notice_level;
    }

    public String getVaccine_date() {
        return vaccine_date;
    }

    public void setVaccine_date(String vaccine_date) {
        this.vaccine_date = vaccine_date;
    }

    public Integer getVaccine_count() {
        return vaccine_count;
    }

    public void setVaccine_count(Integer vaccine_count) {
        this.vaccine_count = vaccine_count;
    }

    public Notice(String notice_content, Integer notice_level, String vaccine_date, Integer vaccine_count) {
        this.notice_content = notice_content;
        this.notice_level = notice_level;
        this.vaccine_date = vaccine_date;
        this.vaccine_count = vaccine_count;
    }

    public Notice(Integer notice_id, String notice_content, Integer notice_level, String vaccine_date, Integer vaccine_count) {
        this.notice_id = notice_id;
        this.notice_content = notice_content;
        this.notice_level = notice_level;
        this.vaccine_date = vaccine_date;
        this.vaccine_count = vaccine_count;
    }

    public Notice() {
    }
}
