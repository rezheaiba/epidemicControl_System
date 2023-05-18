package com.rzab.service;

import com.rzab.dao.AbnormalDao;
import com.rzab.pojo.Abnormal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-04-23 14:25
 **/

@Service
public class AbnormalService {

    @Qualifier("abnormalDao")
    @Autowired
    private AbnormalDao abnormalDao;

    //insertAbnormal
    public void insertAbnormal(Abnormal abnormal) {
        abnormalDao.insertAbnormal(abnormal);
    }

    //selectAllAbnormal
    public List<Abnormal> selectAllAbnormal(){
        return abnormalDao.selectAllAbnormal();
    }
}
