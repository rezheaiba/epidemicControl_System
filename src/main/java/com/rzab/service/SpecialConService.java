package com.rzab.service;

import com.rzab.dao.SpecialConDao;
import com.rzab.pojo.SpecialCon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author 热着爱吧
 * @create 2021-05-06 11:21
 **/

@Service
public class SpecialConService {

    @Qualifier("specialConDao")
    @Autowired
    private SpecialConDao specialConDao;

    public void insertSpecialCon(SpecialCon specialCon){
        specialConDao.insertSpecialCon(specialCon);
    }
}
