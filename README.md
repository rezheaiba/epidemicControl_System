### 本系统个人设置的代码
###### 本系统js所存全局变量sessionStorage域内

201：正在登陆状态

202：未登陆状态
登录状态：login_msg(用户)，login_epc_msg(防疫员),login_admin_msg(管理员)

用户名：user_name(用户姓名)，epc_name(防疫员姓名)，admin_name(管理员姓名)
，user_id(用户编号)

### 用户今日打卡页面
tem_judge:判断温度是否合法
loc_judge:判断地址是否合法
con_SignIn:是否已打卡
epc_con_SignIn:epc是否打卡
specialCon_judge:特殊情况字数要求
pass_judge:user修改密码是否合法
epcPass_judge:epc修改密码是否合法
## 管理员页面
一件提醒按钮点击后所致存值：remind_judge:201(已经点击)

处理当前通知：notice_id  
edit_notice_content
edit_notice_content

处理当前地址：loc_id
edit_loc_name

[comment]: <> (通过sessionStorage存值来切换不同界面，触发不同ajax（所有页面都需要有这个js）)

[comment]: <> (**存键为：bgclick**)

[comment]: <> (点击体温异常人员:303)

[comment]: <> (点击地址发生变化人员:304)

[comment]: <> (因为目前已将js放到html页面，忽略这个问题)

# 真分页
信息收集中查看
人员信息管理中用户信息管理和访客信息管理
修改地址信息