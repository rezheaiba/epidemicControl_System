package com.rzab.pojo;

/**
 * @author 热着爱吧
 * @create 2021-04-11 11:04
 **/

public class Location {
    private Integer loc_id;
    private String loc_name;
    private Integer loc_risklevel;

    @Override
    public String toString() {
        return "Location{" +
                "loc_id=" + loc_id +
                ", loc_name='" + loc_name + '\'' +
                ", loc_risklevel=" + loc_risklevel +
                '}';
    }

    public Location(String loc_name, Integer loc_risklevel) {
        this.loc_name = loc_name;
        this.loc_risklevel = loc_risklevel;
    }

    public Integer getLoc_id() {
        return loc_id;
    }

    public void setLoc_id(Integer loc_id) {
        this.loc_id = loc_id;
    }

    public String getLoc_name() {
        return loc_name;
    }

    public void setLoc_name(String loc_name) {
        this.loc_name = loc_name;
    }

    public Integer getLoc_risklevel() {
        return loc_risklevel;
    }

    public void setLoc_risklevel(Integer loc_risklevel) {
        this.loc_risklevel = loc_risklevel;
    }

    public Location() {
    }

    public Location(Integer loc_id, String loc_name, Integer loc_risklevel) {
        this.loc_id = loc_id;
        this.loc_name = loc_name;
        this.loc_risklevel = loc_risklevel;
    }
}
