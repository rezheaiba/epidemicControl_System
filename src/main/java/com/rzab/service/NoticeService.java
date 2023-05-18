package com.rzab.service;

import com.rzab.dao.NoticeDao;
import com.rzab.pojo.Notice;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-04-25 16:26
 **/

@Service
public class NoticeService {

    @Qualifier("noticeDao")
    @Autowired
    private NoticeDao noticeDao;

    //插入一条信息
    public void insertNotice(Notice notice){
        noticeDao.insertNotice(notice);
    }

    //查找所有发布的通知
    public List<Notice> selectAllNotice(){
        return noticeDao.selectAllNotice();
    }

    //查询最近日期的疫苗数量还有没有了
    public Notice selectVaccine_count(){
        return noticeDao.selectVaccine_count();
    }

    //疫苗-1
    public void updateVaccine_count(Integer notice_id){
        noticeDao.updateVaccine_count(notice_id);
    }

    //修改notice
    public void updateNoticeById(Notice notice){
        noticeDao.updateNoticeById(notice);
    }

    //根据id删除
    public void delNoticeById(Integer notice_id){
        noticeDao.delNoticeById(notice_id);
    }

}

