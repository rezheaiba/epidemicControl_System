package com.rzab.controller;

import com.rzab.pojo.*;
import com.rzab.service.*;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-04-11 11:57
 **/

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;


    //新建一条信息
    @RequestMapping("/insertNotice")
    @ResponseBody
    public Msg insertNotice(String notice_content, String notice_level, String vaccine_date, String vaccine_count) {
        Notice notice = new Notice();
        if (vaccine_date.equals("无")) {
            //格式化时间格式
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            String date = formatter.format(new Date());
            notice.setNotice_content(notice_content);
            notice.setNotice_level(Integer.parseInt(notice_level));
            notice.setVaccine_date(date);
            notice.setVaccine_count(Integer.parseInt(vaccine_count));
        } else
            notice = new Notice(notice_content, Integer.parseInt(notice_level), vaccine_date, Integer.parseInt(vaccine_count));
        noticeService.insertNotice(notice);
        return Msg.success();
    }

    //查找所有发布的通知
    @RequestMapping("/selectAllNotice")
    @ResponseBody
    public Msg selectAllNotice() {
        List<Notice> noticeList = noticeService.selectAllNotice();
        if (!noticeList.isEmpty()) {
            return Msg.success().add("noticeList", noticeList);
        }
        return Msg.fail();
    }

    //修改通知
    @RequestMapping("/updateNoticeById")
    @ResponseBody
    public Msg updateNoticeById(String notice_id, String notice_content, String notice_level, String vaccine_date, String vaccine_count) {
        Notice notice = new Notice();
        if (vaccine_date.equals("无")) {
            notice.setNotice_id(Integer.parseInt(notice_id));
            //格式化时间格式
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            String date = formatter.format(new Date());
            notice.setNotice_content(notice_content);
            notice.setNotice_level(Integer.parseInt(notice_level));
            notice.setVaccine_date(date);
            notice.setVaccine_count(Integer.parseInt(vaccine_count));
        } else
            notice = new Notice(Integer.parseInt(notice_id), notice_content, Integer.parseInt(notice_level), vaccine_date, Integer.parseInt(vaccine_count));
        noticeService.updateNoticeById(notice);
        return Msg.success();
    }

    //删除通知
    @RequestMapping("/delNoticeById")
    @ResponseBody
    public Msg delNoticeById(String notice_id) {
        noticeService.delNoticeById(Integer.parseInt(notice_id));
        return Msg.success();
    }
}
