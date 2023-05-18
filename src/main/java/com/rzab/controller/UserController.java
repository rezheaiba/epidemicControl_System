package com.rzab.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rzab.pojo.Location;
import com.rzab.pojo.Msg;
import com.rzab.pojo.User;
import com.rzab.pojo.getPublic;
import com.rzab.service.UserService;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-04-11 11:57
 **/

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //启动Tomcat跳转到user首页
    @RequestMapping("/toIndex_user")
    public String index_user() {
        return "index_user";
    }

    //跳转到防疫员首页
    @RequestMapping("/toIndex_epc")
    public String index_epc() {
        return "index_epc";
    }

    //跳转到user登录页面
    @RequestMapping("/toLogin")
    public String login() {
        return "login_user";
    }

    //跳转到防疫员登录页面
    @RequestMapping("/toLogin_epc")
    public String login_epc() {
        return "login_epc";
    }

    //跳转到user_appointNa页面
    @RequestMapping("/toUser_appointNa")
    public String user_appointNa() {
        return "user_appointNa";
    }

    //跳转到user_appointVac页面
    @RequestMapping("/toUser_appointVac")
    public String user_appointVac() {
        return "user_appointVac";
    }

    //跳转到user_info页面
    @RequestMapping("/toUser_info")
    public String user_info() {
        return "user_info";
    }

    //跳转到user_repass页面
    @RequestMapping("/toUser_repass")
    public String user_repass() {
        return "user_repass";
    }

    //跳转到user_message页面
    @RequestMapping("/toUser_message")
    public String user_message() {
        return "user_message";
    }

    //跳转到user_collect页面
    @RequestMapping("/toUser_collect")
    public String user_collect() {
        return "user_collect";
    }

    //跳转到user_applyForEpc.html页面
    @RequestMapping("/toUser_applyForEpc")
    public String user_applyForEpc() {
        return "user_applyForEpc";
    }

    //跳转到user_signIn
    @RequestMapping("/toUser_signIn")
    public String user_signIn() {
        return "user_signIn";
    }


    //跳转到epc_signIn
    @RequestMapping("/toEpc_signIn")
    public String epc_signIn() {
        return "epc_signIn";
    }

    //跳转到epc_info页面
    @RequestMapping("/toEpc_info")
    public String epc_info() {
        return "epc_info";
    }

    //跳转到epc_repass页面
    @RequestMapping("/toEpc_repass")
    public String ecp_repass() {
        return "epc_repass";
    }


    //跳转到epc_applyForCon页面
    @RequestMapping("/toEpc_applyForCon")
    public String epc_applyForCon() {
        return "epc_applyForCon";
    }

    //跳转到epc_applyForSpecialCon页面
    @RequestMapping("/toEpc_applyForSpecialCon")
    public String epc_applyForSpecialCon() {
        return "epc_applyForSpecialCon";
    }

    //跳转到epc_message页面
    @RequestMapping("/toEpc_message")
    public String epc_message() {
        return "epc_message";
    }

    //退出登录
    @RequestMapping("/toSignOut")
    @ResponseBody
    public Msg signOut() {
        return Msg.success();
    }


    //user登录ajax交互
    @RequestMapping("/userIndex")
    @ResponseBody
    public Msg selectUser(String user_name, String user_password, HttpServletRequest request) throws IOException {
        //如果用户名或密码为空值，则添加{"nullFlag","1"},前台接收值为1不提示，而!=='1'时提示密码错误
        if (user_name.equals("") || user_password.equals("")) {
            System.out.println("null");
            return Msg.fail().add("nullFlag", "1");
        }
        User user = userService.selectUser(user_name, user_password);
        if (user != null) {
            System.out.println("###success###");

            //返回一个Msg的实例化对象
            return Msg.success().add("user", user).add("user_id", user.getUser_id());
        }
        System.out.println("###fail###");
        return Msg.fail();
    }

    //防疫员登录ajax交互
    @RequestMapping("/epcIndex")
    @ResponseBody
    public Msg selectEpc(String user_name, String user_password) {
        //如果用户名或密码为空值，则添加{"nullFlag","1"},前台接收值为1不提示，而!=='1'时提示密码错误
        if (user_name.equals("") || user_password.equals("")) {
            System.out.println("notnull");
            return Msg.fail().add("nullFlag", "1");
        }
        User epc = userService.selectEpc(user_name, user_password);
        if (epc != null) {
            System.out.println("###success###");
            //返回一个Msg的实例化对象
            return Msg.success().add("epc", epc).add("epc_id", epc.getUser_id());
        }
        System.out.println("###fail###");
        return Msg.fail();
    }

    //查询是否已经签到
    @RequestMapping("/selectCheckInById")
    @ResponseBody
    public Msg selectCheckInById(String user_id) {
        Integer temp = userService.selectCheckInById(Integer.parseInt(user_id));
        if (temp == 1) {
            return Msg.success();
        } else return Msg.fail();
    }

    //查询user
    @RequestMapping("/selectUserById")
    @ResponseBody
    public Msg selectUserById(String user_id) {
        User user = userService.selectUserById(Integer.parseInt(user_id));
        return Msg.success().add("user", user);
    }

    //user修改密码
    @RequestMapping("/updatePassById")
    @ResponseBody
    public Msg updatePassById(String user_id, String prior_userPass, String user_password) {
        //先查询原密码是否正确
        User user1 = userService.selectUserById(Integer.parseInt(user_id));
        if (prior_userPass.equals(user1.getUser_password())) {
            userService.updatePassById(user_password, Integer.parseInt(user_id));
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //user申请防疫员
    @RequestMapping("/updateApplyStatus")
    @ResponseBody
    public Msg updatePassById(String user_id) {
        User user = userService.selectUserById(Integer.parseInt(user_id));
        //未申请过
        if (user.getApplyStatus().equals("0")) {
            //修改申请状态
            userService.updateApplyStatus(Integer.parseInt(user_id));
            return Msg.success();
        } else return Msg.fail();
    }

    //管理员查找所有user
    @RequestMapping("/adminselectAllUser")
    @ResponseBody
    public Msg adminselectAllUser(@RequestParam(required = true,defaultValue = "1")Integer page) {
        //page：当前页
        PageHelper.startPage(page,10);
        List<User> userList = userService.selectAllUser();
        if (!userList.isEmpty()) {
            PageInfo<User> userPageInfo  = new PageInfo<>(userList);
            return Msg.success().add("userPageInfo", userPageInfo);
        } else return Msg.fail();
    }

    //管理员查看申请的user
    @RequestMapping("/selectUserApply")
    @ResponseBody
    public Msg selectUserApply() {
        List<User> userList = userService.selectUserApply();
        if (!userList.isEmpty()) {
            return Msg.success().add("userList", userList);
        } else return Msg.fail();
    }

    //管理员同意，修改user类型并将状态置0
    @RequestMapping("/updateAgree")
    @ResponseBody
    public Msg updateAgree(String user_id) {
        userService.updateAgree(Integer.parseInt(user_id));
        return Msg.success();
    }

    //管理员不同意
    @RequestMapping("/updateDisagree")
    @ResponseBody
    public Msg updateDisagree(String user_id) {
        userService.updateDisagree(Integer.parseInt(user_id));
        return Msg.success();
    }

    //admin根据id修改用户名或密码
    @RequestMapping("/updateNameOrPassById")
    @ResponseBody
    public Msg updateNameOrPassById(String user_id, String user_name, String user_password) {
        User user = new User(Integer.parseInt(user_id), user_name, user_password);
        userService.updateNameOrPassById(user);
        return Msg.success();
    }


}
