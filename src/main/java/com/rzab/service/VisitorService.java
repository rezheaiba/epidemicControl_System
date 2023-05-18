package com.rzab.service;

import com.rzab.dao.VisitorDao;
import com.rzab.pojo.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-05-05 23:04
 **/

@Service
public class VisitorService {

    @Qualifier("visitorDao")
    @Autowired
    private VisitorDao visitorDao;

    //添加访客信息
    public void insertVisitor(Visitor visitor) {
        visitorDao.insertVisitor(visitor);
    }

    public List<Visitor> selectAllVisitor(){
        return visitorDao.selectAllVisitor();
    }

    public void delVisitor(Integer visitor_id){
        visitorDao.delVisitor(visitor_id);
    }
}
