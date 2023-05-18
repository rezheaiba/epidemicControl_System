package com.rzab.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rzab.pojo.Location;
import com.rzab.pojo.Msg;
import com.rzab.pojo.Visitor;
import com.rzab.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * @author 热着爱吧
 * @create 2021-05-05 23:06
 **/

@Controller
@RequestMapping("/visitor")
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @RequestMapping("/insertVisitor")
    @ResponseBody
    public Msg insertVisitor(String visitor_name, String visitor_sex,
                             String visitor_temperature, String visitor_phone_num, String visitor_car_num) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Visitor visitor = new Visitor(visitor_name, visitor_sex, visitor_temperature,
                visitor_phone_num, visitor_car_num, formatter.format(new Date()));
        visitorService.insertVisitor(visitor);
        return Msg.success();
    }

    @RequestMapping("/selectAllVisitor")
    @ResponseBody
    public Msg selectAllVisitor(@RequestParam(required = true, defaultValue = "1") Integer page) {
        //page：当前页
        PageHelper.startPage(page, 10);
        List<Visitor> visitorList = visitorService.selectAllVisitor();
        //非空返回200，为空返回100
        if (!visitorList.isEmpty()) {
            //封装即可
            PageInfo<Visitor> visitorPageInfo = new PageInfo<>(visitorList);
            return Msg.success().add("visitorPageInfo", visitorPageInfo);
        } else return Msg.fail();
    }


    @RequestMapping("/delVisitor")
    @ResponseBody
    public Msg delVisitor(String visitor_id) {
        visitorService.delVisitor(Integer.parseInt(visitor_id));
        return Msg.success();
    }

}
