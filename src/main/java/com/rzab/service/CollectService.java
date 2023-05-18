package com.rzab.service;

import com.rzab.dao.CollectDao;
import com.rzab.pojo.Collect;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-05-09 9:01
 **/

@Service
public class CollectService {

    @Qualifier("collectDao")
    @Autowired
    private CollectDao collectDao;

    //查找上一次的收集，如果没有，从1开始
    public List<Collect> selectPreCollect(){
        return collectDao.selectPreCollect();
    }

    //插入：插入前需要查找最大id，插入的id比最大id大1
    public void insertCollect(Collect collect){
        collectDao.insertCollect(collect);
    }

    //查看所有收集
    public List<Collect> selectAllCollect(){
        return collectDao.selectAllCollect();
    }
}
