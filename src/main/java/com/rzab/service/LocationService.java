package com.rzab.service;

import com.rzab.dao.LocationDao;
import com.rzab.pojo.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-04-19 19:19
 **/

@Service
public class LocationService {

    @Qualifier("locationDao")

    @Autowired
    private LocationDao locationDao;

    //根据城市名称来查找本条数据
    public List<Location> selectLocByName(String loc_name) {
        return locationDao.selectLocByName(loc_name);
    }

    //增加新地址
    public void insertNewLocation(Location location) {
        locationDao.insertNewLocation(location);
    }

    //查询全部城市
    public List<Location> selectAllLocation() {
        return locationDao.selectAllLocation();
    }

    //修改城市信息
    public void updateLocationById(Location location) {
        locationDao.updateLocationById(location);
    }

    //删除byid
    public void delLocationById(Integer loc_id) {
        locationDao.delLocationById(loc_id);
    }
}
