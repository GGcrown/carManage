$(function () {
    // 初始显示翻页列表
    listPaging("user/countUserAjax.action");

});

//翻页
function filpPage(page) {
    $.ajax({
        type: "post",
        url: "user/findUserListAjax.action?page=" + page,
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            $(".tbody").empty("");
            showInfoList(data.users);
        }
    })
}


function showInfoList(info) {
    for (var i = 0; i < info.length; i++) {
        var tr = $("<tr></tr>");// tr节点对象
        tr.append("<td align='center'>" + info[i].userid + "</td>");
        tr.append("<td align='center'>" + info[i].username + "</td>");
        if (info[i].usertype == 0) {
            tr.append("<td align='center'>管理员用户</td>");
        } else {
            tr.append("<td align='center'>普通用户</td>");
        }

        //修改按钮
        var $update = $("<a userid='" + info[i].userid + "' title='添加用户' class='iconfont hovera'>&#xe615;</a>");
        //删除按钮
        var $delete = $("<a userid='" + info[i].userid + "' title='删除用户' class='iconfont hovera'>&#xe603;</a>");
        //重置按钮
        var $reset = $("<a userid=' " + info[i].userid
            + "' title='重置用户密码' class='iconfont hovera hint' style='color: #ff5555;font-size: 20px'>&#xe629;</a>");
        //todo
        $td = $("<td align='center'></td>");
        $td.append($update);
        $td.append($delete);
        $td.append($reset);
        tr.append($td);


        $(".tbody").append(tr);
        tr.mouseenter(function () {
            var index = $(this).index();
            if (index % 2 == 1) {
                $(this).css("background-color", "#F5F5F5");
            }
        });
        tr.mouseout(function () {
            var index = $(this).index();
            if (index % 2 == 1) {
                $(this).css("background-color", "#FFFFFF");
            }
        });

        // 修改信息点击事件
        infoUpdate($update);
        //删除信息点击事件
        infoDelete($delete);
    }
    addHoverA($(".hovera"));
}

// 清除所有index
function cleanIndex(page) {
    page.attr("index", 0);
}

// 显示
function showAddInfo() {
    $("#titleInfo").empty("");// 更改标题
    $("#titleInfo").append("添加用户");
    $("#animateContent").empty("");// 清空再加

    var $username = $('<div class="textarea"><label class="lab">账号:</label>' +
        '<input class="info" name="username"/></div>');
    var $password = $('<div class="textarea"><label class="lab">密码:</label>' +
        '<input class="info Wdate" name="password" type="password"  /></div>');
    var $repassword = $('<div class="textarea"><label class="lab">确认密码:</label>' +
        '<input class="info Wdate" name="repassword" type="password"  /></div>');

    var $usertype = $('<div class="textarea"><label class="lab">用户类型:</label>' +
        '<select name="usertype" class="selectOption info"><option value="1">普通用户</option>' +
        '<option value="0">管理员用户</option></select></div>');

    // var $usertype = $('<div class="textarea"><label class="lab">账号类型:</label>' +
    //     '<input class="info" name="usertype" type="text"/></div>');

    $("#animateContent").append($username);
    $("#animateContent").append($password);
    $("#animateContent").append($repassword);
    $("#animateContent").append($usertype);
    // 添加按钮
    var $addbtn = $("<a class='addbtn btn'>确认添加</a>");
    $("#animateContent").append($addbtn);
    $("#animateDIV").slideDown()
    addInfo($addbtn);
}


function infoDelete($delete) {
    //删除信息点击事件
    $delete.click(function () {
        swal({
            title: "确认删除吗？",
            text: "你将无法恢复此信息",
            type: "warning",
            showCancelButton: true,
            confirmButtonText: "确认删除",
            cancelButtonText: "取消删除",
            closeOnConfirm: false
        }).then(function (isConfirm) {
            if (isConfirm == true) {
                //获得当前页
                var $currentPage = $(".pages>ul>li>a[index='1']").text();
                var userid = $delete.attr("userid");
                $.post("user/deleteUserByIdAjax.action",
                    {userid: userid},
                    function (data) {
                        if (data > 0) {
                            swal("删除成功！", "", "success");
                            //自动刷新翻页
                            filpPage($("li>a[index=1]").text() - 1);
                            listPaging("user/countUserAjax.action", $currentPage);
                            $("#animateDIV").slideUp();
                        } else {
                            swal("删除失败！", "", "error");
                        }
                    }
                )
            }
        })
    })
}


function infoUpdate($update) {
    // 修改信息点击事件
    $update.click(function () {
        var $userid = $(this).attr("userid");
        $.ajax({
            type: "post",
            url: "user/findUserByIdAjax.action",
            data: "userid=" + $userid,
            success: function (data) {
                $user = data.user;
                $("#titleInfo").empty("");// 更改标题
                $("#titleInfo").append("更新车辆信息");
                $("#animateContent").empty("");// 清空再加


                var $username = $('<div class="textarea"><label class="lab">账号:</label><span class="info">'
                    + ' <input name="username" value="' + $user.username + '"/></span></div>');
                var $usertype = $('<div class="textarea"><label class="lab">用户类型:</label>' +
                    '<select name="usertype" class="selectOption info"><option value="1">普通用户</option>' +
                    '<option value="0">管理员用户</option></select></div>');
                $("#animateContent").append($username);
                $("#animateContent").append($usertype);

                // 添加修改按钮
                var $updateBtn = $("<a class='update'>确认修改</a>");
                $("#animateContent").append($updateBtn);
                $("#animateDIV").slideDown();

                // 添加修改按钮事件
                $updateBtn.click(function () {
                    var $username = $("input[name='username']").val();
                    var $usertype = $("select[name='usertype']").val();

                    var $data = '{"userid":"' + $userid + '","username":"' + $username + '","usertype":"' + $usertype + '"}';
                    $.ajax({
                        type: "post",
                        url: "user/updateUserAjax.action",
                        contentType: "application/json;charset=utf-8",
                        data: $data,
                        success: function (data) {
                            if (data > 0) {
                                // 刷新列表页面
                                filpPage($("li>a[index=1]").text() - 1);
                                $("#animateDIV").hide();
                                swal("更新", "更新成功", "success");
                            } else {
                                swal("更新失败", "出错了！", "error");
                            }
                        }
                    })
                })
            }
        });
    })
}


function addInfo($addbtn) {
    $addbtn.click(function () {
        var $username = $(".info[name='username']").val();
        var $password = $(".info[name='password']").val();
        var $usertype = $(".info[name='usertype']").val();


        var $data = '{"username":"' + $username + '","password":"' + $password + '","usertype":' + $usertype + '}';
        //获得当前页
        var $currentPage = $(".pages>ul>li>a[index='1']").text();
        $.ajax({
            type: "post",
            url: "user/addUserAjax.action",
            contentType: "application/json;charset=utf-8",
            data: $data,
            success: function (data) {
                if (data > 0) {
                    // 刷新列表页面
                    listPaging("user/countUserAjax.action", $currentPage);
                    filpPage($("li>a[index=1]").text() - 1);
                    $("#animateDIV").hide();
                    swal("添加用户成功！");
                } else if (data == -1) {
                    swal("此账户已存在，请重新输入！");
                } else {
                    swal("添加用户失败");
                }
            }
        })
    })
}