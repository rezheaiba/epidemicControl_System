package com.rzab.service;

import com.rzab.dao.AppointDao;
import com.rzab.pojo.Appoint;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-04-26 9:29
 **/

@Service
public class AppointService {

    @Qualifier("appointDao")
    @Autowired
    private AppointDao appointDao;
    //插入预约信息
    public void insertAppoint(Appoint appoint) {
        appointDao.insertAppoint(appoint);
    }

    //根据id查询是否有此人的预约信息
    public Appoint selectAppointById(Integer appoint_userid){
        return appointDao.selectAppointById(appoint_userid);
    }

    //admin预约信息查看
    public List<Appoint> selectAllAppoint(){
        return appointDao.selectAllAppoint();
    }
}
