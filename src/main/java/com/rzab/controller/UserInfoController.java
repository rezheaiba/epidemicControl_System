package com.rzab.controller;

import com.rzab.dao.LocationDao;
import com.rzab.pojo.*;
import com.rzab.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-04-19 16:02
 **/

@Controller
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private AddressChangeService addressChangeService;

    @Autowired
    private AbnormalService abnormalService;

    @Autowired
    private UserService userService;

    @RequestMapping("/insertUserInfo")
    @ResponseBody
    public Msg insertUserInfo(String user_id, String user_name, String user_temperature, String physical_condition, String contact_condition, String user_loc, String operate_time) {

        //格式化时间格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        /**
         * 先查找用户打没打过第一次卡
         *对比上一次打卡位置是否变化
         * 查找上一次的位置
         */
        List<UserInfo> userInfo_0 = userInfoService.selectUserInfoById(Integer.parseInt(user_id));
        //分析比对现在填写的位置和之前的位置最后三个字符是否一样，就可以判断是否变化了
        String nowLoc = user_loc.substring(user_loc.length() - 3, user_loc.length());
        //构造一个addressChange
        AddressChange addressChange = new AddressChange();
        if (!userInfo_0.isEmpty()) {
            String PreLoc = userInfoService.selectPreLoc(Integer.parseInt(user_id));
            //如果比对结果为：两次地址发生变化,存入表中
            if (!PreLoc.contains(nowLoc)) {
                addressChange.setChange_userid(Integer.parseInt(user_id));
                addressChange.setChange_username(user_name);
                addressChange.setChange_time(formatter.format(new Date()));
                //存的是当前输入进来的地址
                addressChange.setChangeto_loc(user_loc);
                //调用selectLocByName方法返回location后get地区风险等级
                addressChange.setLoc_risklevel(locationService.selectLocByName(nowLoc).get(0).getLoc_risklevel());
                addressChangeService.insertAddressChange(addressChange);
            }
        } else {
            int level = locationService.selectLocByName(nowLoc).get(0).getLoc_risklevel();
            if (level > 0) {
                addressChange.setChange_userid(Integer.parseInt(user_id));
                addressChange.setChange_username(user_name);
                addressChange.setChange_time(formatter.format(new Date()));
                //存的是当前输入进来的地址
                addressChange.setChangeto_loc(user_loc);
                //调用selectLocByName方法返回location后get地区风险等级
                addressChange.setLoc_risklevel(locationService.selectLocByName(nowLoc).get(0).getLoc_risklevel());
                addressChangeService.insertAddressChange(addressChange);
            }
        }


        //构造对象
        UserInfo userInfo = new UserInfo();
        userInfo.setUser_id(Integer.parseInt(user_id));
        userInfo.setUser_name(user_name);
        userInfo.setUser_temperature(Double.parseDouble(user_temperature));
        userInfo.setPhysical_condition(physical_condition);
        userInfo.setContact_condition(contact_condition);
        userInfo.setUser_loc(user_loc);
        userInfo.setOperate_time(formatter.format(new Date()));
        //调用方法将用户刚刚输入的信息存入userinfo表
        userInfoService.insertUserInfo(userInfo);

        //记录当前用户的登录状态
        userService.updateUserCheckInTo1(Integer.parseInt(user_id));

        //如果温度异常放入温度异常表中
        if (Double.parseDouble(user_temperature) > 37.3){
        Abnormal abnormal = new Abnormal(Integer.parseInt(user_id),user_name,formatter.format(new Date()),"体温异常:"+user_temperature+"摄氏度");
        abnormalService.insertAbnormal(abnormal);
        }


        //返回Msg
        return Msg.success();
    }

    //根据日期返回
    @RequestMapping("/selectSignInRecords")
    @ResponseBody
    public Msg selectSignInRecords(String user_id){
        List<UserInfo> userInfos = userInfoService.selectUserInfoByIdOrderByTime(Integer.parseInt(user_id));
        if (!userInfos.isEmpty()){
        return Msg.success().add("userInfos",userInfos);
        }else
            return Msg.fail();
    }

    //根据日期返回所有登录记录，供管理员查看
    @RequestMapping("/selectAllSignInRecords")
    @ResponseBody
    public Msg selectAllSignInRecords(){
        List<UserInfo> userInfos = userInfoService.selectAllUserInfo();
        if (!userInfos.isEmpty()){
            return Msg.success().add("userInfos",userInfos);
        }else
            return Msg.fail();
    }

}
