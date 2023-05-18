package com.rzab.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rzab.dao.AddressChangeDao;
import com.rzab.pojo.*;
import com.rzab.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.InputMismatchException;
import java.util.List;
import java.util.concurrent.BlockingDeque;

/**
 * @author 热着爱吧
 * @create 2021-04-11 11:57
 **/

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AddressChangeService addressChangeService;

    @Autowired
    private AbnormalService abnormalService;

    @Autowired
    private UserService userService;

    @Autowired
    private LocationService locationService;


    //跳转到admin首页
    @RequestMapping("/toIndex_admin")
    public String index_admin() {
        return "bgSystem";
    }


    //跳转到登录页面
    @RequestMapping("/toLogin_admin")
    public String login() {
        return "login_admin";
    }

    //退出登录
    @RequestMapping("/toSignOut")
    @ResponseBody
    public Msg signOut() {
        return Msg.success();
    }


    //admin登录ajax交互
    @RequestMapping("/adminIndex")
    @ResponseBody
    public Msg selectAdmin(String admin_name, String admin_password) {
        //如果用户名或密码为空值，则添加{"nullFlag","1"},前台接收值为1不提示，而!=='1'时提示密码错误
        if (admin_name.equals("") || admin_password.equals("")) {
            System.out.println("null");
            return Msg.fail().add("nullFlag", "1");
        }
        Admin admin = adminService.selectAdmin(admin_name, admin_password);
        if (admin != null) {
            System.out.println("###success###");
            //返回一个Msg的实例化对象
            return Msg.success().add("admin", admin);
        }
        System.out.println("###fail###");
        return Msg.fail();
    }


    //查询所有地址变化的人员
    @RequestMapping("/selectAllArsChange")
    @ResponseBody
    public Msg selectAllArsChange() {
        List<AddressChange> addressChanges = addressChangeService.selectAllArsChange();
        if (!addressChanges.isEmpty()) {
            return Msg.success().add("addressChanges", addressChanges);
        }
        return Msg.fail();
    }

    //查询所有温度异常的人员
    @RequestMapping("/selectAllAbnormal")
    @ResponseBody
    public Msg selectAllAbnormal() {
        List<Abnormal> abnormals = abnormalService.selectAllAbnormal();
        if (!abnormals.isEmpty()) {
            return Msg.success().add("abnormals", abnormals);
        }
        return Msg.fail();
    }

    //查询未打卡人员
    @RequestMapping("/selectNotCheckIn")
    @ResponseBody
    public Msg selectNotCheckIn() {
        List<User> userList = userService.selectNotCheckIn();
        if (!userList.isEmpty()) {
            return Msg.success().add("userList", userList);
        }
        return Msg.fail();
    }

    //查询未打卡人员
    @RequestMapping("/selectWhichUserNotCheckIn")
    @ResponseBody
    public Msg selectWhichUserNotCheckIn(String user_id) {
        List<User> userList = userService.selectNotCheckIn();
        if (!userList.isEmpty()) {
            for (User u : userList) {
                if (u.getUser_id() == Integer.parseInt(user_id))
                    return Msg.success();
            }
        }
        return Msg.fail();
    }

    //新增地址
    @RequestMapping("/insertNewLocation")
    @ResponseBody
    public Msg insertNewLocation(String loc_name, String loc_risklevel) {
        Location location = new Location();
        location.setLoc_name(loc_name);
        location.setLoc_risklevel(Integer.parseInt(loc_risklevel));
        locationService.insertNewLocation(location);
        return Msg.success();
    }

    //查询全部城市地址
    @RequestMapping("/selectAllLocation")
    @ResponseBody
    public Msg selectAllLocation(@RequestParam(required = true,defaultValue = "1")Integer page) {
        //page：当前页
        PageHelper.startPage(page,10);
        List<Location> locationList = locationService.selectAllLocation();
        //非空返回200，为空返回100
        if (!locationList.isEmpty()) {
            //封装即可
            PageInfo<Location> locationPageInfo = new PageInfo<>(locationList);
            return Msg.success().add("locationPageInfo",locationPageInfo);
        } else return Msg.fail();
    }

    //修改城市信息
    @RequestMapping("/updateLocationById")
    @ResponseBody
    public Msg updateLocationById(String loc_id, String loc_name, String loc_risklevel){
        Location location = new Location();
        location.setLoc_id(Integer.parseInt(loc_id));
        location.setLoc_name(loc_name);
        location.setLoc_risklevel(Integer.parseInt(loc_risklevel));
        locationService.updateLocationById(location);
        return Msg.success();
    }

    //修改城市信息
    @RequestMapping("/delLocationById")
    @ResponseBody
    public Msg updateLocationById(String loc_id){
        locationService.delLocationById(Integer.parseInt(loc_id));
        return Msg.success();
    }

}
