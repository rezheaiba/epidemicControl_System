package com.rzab.controller;

import com.rzab.pojo.Msg;
import com.rzab.pojo.SpecialCon;
import com.rzab.service.SpecialConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 热着爱吧
 * @create 2021-05-06 11:26
 **/

@Controller
@RequestMapping("/specialCon")
public class SpecialConController {

    @Autowired
    private SpecialConService specialConService;

    @RequestMapping("/insertSpecialCon")
    @ResponseBody
    public Msg insertSpecialCon(String specialCon_content){
        SpecialCon specialCon = new SpecialCon(specialCon_content);
        specialConService.insertSpecialCon(specialCon);
        return Msg.success();
    }
}
