package com.rzab.pojo;

/**
 * @author 热着爱吧
 * @create 2021-04-11 11:02
 **/

public class AddressChange {
    private Integer change_userid;
    private String change_username;
    private String change_time;
    private String changeto_loc;
    private Integer loc_risklevel;

    public String getChangeto_loc() {
        return changeto_loc;
    }

    public void setChangeto_loc(String changeto_loc) {
        this.changeto_loc = changeto_loc;
    }

    @Override
    public String toString() {
        return "AddressChange{" +
                "change_userid=" + change_userid +
                ", change_username='" + change_username + '\'' +
                ", change_time='" + change_time + '\'' +
                ", changeto_loc='" + changeto_loc + '\'' +
                ", loc_risklevel=" + loc_risklevel +
                '}';
    }

    public Integer getChange_userid() {
        return change_userid;
    }

    public void setChange_userid(Integer change_userid) {
        this.change_userid = change_userid;
    }

    public String getChange_username() {
        return change_username;
    }

    public void setChange_username(String change_username) {
        this.change_username = change_username;
    }

    public String getChange_time() {
        return change_time;
    }

    public void setChange_time(String change_time) {
        this.change_time = change_time;
    }


    public Integer getLoc_risklevel() {
        return loc_risklevel;
    }

    public void setLoc_risklevel(Integer loc_risklevel) {
        this.loc_risklevel = loc_risklevel;
    }


    public AddressChange() {
    }
}
