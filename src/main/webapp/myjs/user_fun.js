$(function () {
    /**
     * 登陆状态201
     */

    if (sessionStorage.getItem("login_msg") == "201") {
        //首先清空节点
        $("#login_user").empty();
        //添加节点
        var htmladd = "";
        htmladd = '<a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">' +
            '<img src="../../images/photos/user-avatar.png" alt="" />' +
            sessionStorage.getItem("user_name") +
            '<span class="caret"></span>' +
            '</a>' +
            '<ul class="dropdown-menu dropdown-menu-usermenu pull-right">' +
            '<li><a href="/user/toUser_info"><i class="fa fa-user"></i>  个人简介</a></li>' +
            '<li><a href="#"><i class="fa fa-cog"></i>  设置</a></li>' +
            '<li><a href="#" onclick="signOut()" id="signOut"><i class="fa fa-sign-out"></i> 退出登录</a></li>' +
            '</ul>';
        $("#login_user").append(htmladd);
    }
    if (sessionStorage.getItem("login_msg") == "202") {
        $("#login_user").empty();
        var htmlAdd = "";
        htmlAdd = '<a href="/user/toLogin" class="btn btn-default dropdown-toggle">' +
            '登&nbsp;&nbsp;录' +
            '<span class="glyphicon glyphicon-new-window"></span>' +
            '</a>';
        $("#login_user").append(htmlAdd);
    }

    /**
     *点击打卡记录的总操作
     * 在不同的页面中，有对点击操作具体增加了一些操作
     */

    $("#SignInRecords").click(function () {
        $("ul#ul_1 li").attr('class', '');
        $("ul#ul_2 li").attr('class', '');
        $("ul#ul_3 li").attr('class', '');
        $("ul#ul_4 li").attr('class', '');
        //触发一次点击事件

        $("ul#ul_1").children("li:eq(2)").attr('class', 'active');
        $.ajax({
            url: "/userinfo/selectSignInRecords",
            type: "get",
            data: {"user_id": sessionStorage.getItem("user_id")},
            success: function (result) {
                $("div#main").empty();
                var htmlAddOne = '';
                htmlAddOne = '<section class="panel">\n' +
                    '            <header class="panel-heading">\n' +
                    '                打卡记录\n' +
                    '            </header>\n' +
                    '            <table class="table" id="RecordTable">\n' +
                    '                <tr>\n' +
                    '                    <th>用户编号</th>\n' +
                    '                    <th>姓名</th>\n' +
                    '                    <th>温度</th>\n' +
                    '                    <th>身体状况</th>\n' +
                    '                    <th>接触情况</th>\n' +
                    '                    <th>地址</th>\n' +
                    '                    <th>提交时间</th>\n' +
                    '                </tr>\n' +
                    '            </table>\n' +
                    '        </section>';
                $("div#main").append(htmlAddOne);
                $.each(result.extend.userInfos, function (index, item) {
                    var user_idTd = $("<td></td>").append(item.user_id);
                    var user_nameTd = $("<td></td>").append(item.user_name);
                    var user_temperatureTd = $("<td></td>").append(item.user_temperature);
                    var physical_conditionTd = $("<td></td>").append(item.physical_condition);
                    var contact_conditionTd = $("<td></td>").append(item.contact_condition);
                    var user_locTd = $("<td></td>").append(item.user_loc);
                    var operate_timeTd = $("<td></td>").append(item.operate_time);
                    $("<tr></tr>")
                        .append(user_idTd)
                        .append(user_nameTd)
                        .append(user_temperatureTd)
                        .append(physical_conditionTd)
                        .append(contact_conditionTd)
                        .append(user_locTd)
                        .append(operate_timeTd)
                        .appendTo("#RecordTable tbody");
                });
            }, error: function (result) {
                alert("please Sign in firstly!");
            }
        });
    });
});


//登出
function signOut() {
    $.ajax({
        url: "/user/toSignOut",
        type: "get",
        data: {},
        success: function (result) {
            if (result.code == 200) {
                window.sessionStorage.setItem("login_msg", "202");
                window.location.href = '/user/toIndex_user';
            }
        },
        error: function (result) {
            alert("error");
        }
    });
}

