$(function () {
    $("#iconfontX").click(function () {
        $("#animateDIV").slideUp();
    })
    // 第一页异步查询显示
    filpPage(0);
    // 默认第一页选择
    clickpage($(".pages>ul>li>a[default='t']"));
    // 初始显示翻页列表
    listPaging();

    $(".tbody>tr").mouseenter(function () {
        var index = $(this).index();
        if (index % 2 == 1) {
            $(this).css("background-color", "#F5F5F5");
        }
    })

    $(".tbody>tr").mouseout(function () {
        var index = $(this).index();
        if (index % 2 == 1) {
            $(this).css("background-color", "#FFFFFF");
        }
    })

    // 分页点击
    $(".pages>ul>li>a").click(function () {
        if ($(this).attr("cancel") != "1" && $(this).attr("cancel") != "2") {
            pageout($(".pages>ul>li>a"));
            cleanIndex($(".pages>ul>li>a"));
            var liIndex = $(this).parent().index();
            var a = $(".pages>ul>li:eq(" + liIndex + ")").children();
            clickpage(a);
            // 页数-1
            filpPage(liIndex - 1);
        } else if ($(this).attr("cancel") == "1") { // 向左翻页
            // 获取选择的li下标
            var liIndex = $(".pages>ul>li>a[index=1]").parent().index() - 1;
            if (liIndex > 0) {
                filpPage(liIndex - 1);// 异步显示
                pageout($(".pages>ul>li>a"));
                cleanIndex($(".pages>ul>li>a"));
                var a = $(".pages>ul>li:eq(" + liIndex + ")").children();
                clickpage(a);
            }

        } else if ($(this).attr("cancel") == "2") { // 向右翻页
            // 最大下标
            var maxIndex = $(".pages>ul>li").length - 1;
            var liIndex = $(".pages>ul>li>a[index=1]").parent().index() + 1;
            if (liIndex < maxIndex) {
                filpPage(liIndex - 1);// 异步显示
                pageout($(".pages>ul>li>a"));
                cleanIndex($(".pages>ul>li>a"));
                var a = $(".pages>ul>li:eq(" + liIndex + ")").children();
                clickpage(a);
            }
        }
    })

    // 分页鼠标进入
    $(".pages>ul>li>a").mouseenter(function () {
        if ($(this).attr("index") != 1) {
            pageenter($(this));
        }
    })

    // 分页鼠标离开
    $(".pages>ul>li>a").mouseout(function () {
        if ($(this).attr("index") != 1) {
            pageout($(this));
        }
    })

    // 显示添加汽车
    $("#addCar").click(function () {
        showAddInsurance();
    });

})

function filpPage(page) {
    $.ajax({
        type: "post",
        url: "insurance/findInsuranceListAjax.action?page=" + page,
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            $(".tbody").empty("");
            showInsuranceList(data.insurances);
        }
    })
}

function listPaging() {
    $.ajax({
        url: "insurance/countInsuranceAjax.action",
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            var one = $("#one");
            for (var i = 2; i <= data.pageSum; i++) {
                var $li = $("<li></li>");
                var $a = $("<a>" + i + "</a>");
                $li.append($a);
                one.after($li);
                one = $li;
                // 新建节点事件也需要重写
                $a.mouseenter(function () {
                    if ($(this).attr("index") != 1) {
                        pageenter($(this));
                    }
                })
                $a.mouseout(function () {
                    if ($(this).attr("index") != 1) {
                        pageout($(this));
                    }
                })
                $a.click(function () {
                    if ($(this).attr("cancel") != "1" && $(this).attr("cancel") != "2") {
                        pageout($(".pages>ul>li>a"));
                        cleanIndex($(".pages>ul>li>a"));
                        var liIndex = $(this).parent().index();
                        var a = $(".pages>ul>li:eq(" + liIndex + ")").children();
                        clickpage(a);
                        // 页数-1
                        filpPage(liIndex - 1);
                    } else if ($(this).attr("cancel") == "1") { // 向左翻页
                        // 获取选择的li下标
                        var liIndex = $(".pages>ul>li>a[index=1]").parent().index() - 1;
                        if (liIndex > 0) {
                            filpPage(liIndex - 1);// 异步显示
                            pageout($(".pages>ul>li>a"));
                            cleanIndex($(".pages>ul>li>a"));
                            var a = $(".pages>ul>li:eq(" + liIndex + ")").children();
                            clickpage(a);
                        }

                    } else if ($(this).attr("cancel") == "2") { // 向右翻页
                        // 最大下标
                        var maxIndex = $(".pages>ul>li").length - 1;
                        var liIndex = $(".pages>ul>li>a[index=1]").parent().index() + 1;
                        if (liIndex < maxIndex) {
                            filpPage(liIndex - 1);// 异步显示
                            pageout($(".pages>ul>li>a"));
                            cleanIndex($(".pages>ul>li>a"));
                            var a = $(".pages>ul>li:eq(" + liIndex + ")").children();
                            clickpage(a);
                        }
                    }
                })
            }
        }
    })
}

function showInsuranceList(insurances) {
    for (var i = 0; i < insurances.length; i++) {
        var tr = $("<tr></tr>");// tr节点对象
        tr.append("<td align='center'>" + insurances[i].insureTypeofinsurance + "</td>");
        tr.append("<td align='center'>" + insurances[i].insureTypeofinsurance + "</td>");
        tr.append("<td align='center'>" + insurances[i].insureCompany + "</td>");
        tr.append("<td align='center'>" + insurances[i].insuranceEndtime + "</td>");
        tr.append("<td align='center'>" + insurances[i].deptname + "</td>");

        var $td = $("<td align='center'></td>");
        var $a = $("<a insureId='" + insurances[i].insureId + "' class='iconfont hovera'>&#xe600;</a>");
        $td.append($a);
        tr.append($td);

        $td = $("<td align='center'></td>");
        var $a2 = $("<a insureId=' " + insurances[i].insureId + "'class='iconfont hovera'>&#xe615;</a>");
        var $a3 = $("<a insureId='" + insurances[i].insureId + "' class='iconfont hovera'    >&#xe603;</a>");
        $td.append($a2);
        $td.append($a3);
        tr.append($td);

        // tr.append("<td align='center' ><a>更改信息</a></td>");
        $(".tbody").append(tr);
        tr.mouseenter(function () {
            var index = $(this).index();
            if (index % 2 == 1) {
                $(this).css("background-color", "#F5F5F5");
            }
        })
        tr.mouseout(function () {
            var index = $(this).index();
            if (index % 2 == 1) {
                $(this).css("background-color", "#FFFFFF");
            }
        })
        // 详细信息点击事件
        $a.click(function () {
            var $insuranceId = $(this).attr("insureid");
            $d = 'insuranceId =' + $insuranceId;
            $
                .ajax({
                    type: "post",
                    url: "insurance/findByInsureIdAjax.action?insuranceId=" + $insuranceId,
                    // data : $d ,
                    success: function (d) {
                        var data = d.insurance;
                        $("#titleInfo").empty("");// 更改标题
                        $("#titleInfo").append("详细信息");
                        $("#animateContent").empty("");// 清空再加
                        $type = $('<div class="textarea"><label class="lab">保险类型:</label><span class="info">' + data.insureTypeofinsurance
                            + '</span></div>');
                        $sTime = $('<div class="textarea"><label class="lab">保险生效时间:</label><span class="info">' + data.insuranceStarttime
                            + '</span></div>');
                        $eTime = $('<div class="textarea"><label class="lab">保险失效时间:</label><span class="info">' + data.insuranceEndtime
                            + '</span></div>');
                        $filepath = $('<div class="textarea"><label class="lab">图片:</label><span class="info">' + data.filepath
                            + '</span></div>');
                        $deptname = $('<div class="textarea"><label class="lab">车辆单位:</label><span class="info">' + data.deptname
                            + '</span></div>');
                        $insureType = $('<div class="textarea"><label class="lab">保险类型:</label><span class="info">' + data.insureType
                            + '</span></div>');

                        $("#animateContent").append($type);
                        $("#animateContent").append($sTime);
                        $("#animateContent").append($eTime);
                        $("#animateContent").append($filepath);
                        $("#animateContent").append($deptname);
                        $("#animateContent").append($insureType);
                        $("#animateDIV").slideDown();
                    }
                });
        })

        // 修改信息点击事件
        $a2.click(function () {
            var $carId = $(this).attr("cid");
            $d = "{'carId':" + $carId + "}";
            $.ajax({
                type: "post",
                url: "car/findCarByIdAjax.action",
                data: "carId=" + $carId,
                success: function (data) {
                    $("#titleInfo").empty("");// 更改标题
                    $("#titleInfo").append("更新车辆信息");
                    $("#animateContent").empty("");// 清空再加

                    var $id = $('<input name="carId" style="display:none" value="' + $carId + '" />');
                    var $carPlate = $('<div class="textarea"><label class="lab">车牌号:</label><input id="sb" class="info" name="carPlate"  value="'
                        + data.carPlate + '"/></div>');
                    var $carMark = $('<div class="textarea"><label class="lab">车辆品牌:</label><input class="info" name="carMark" value="'
                        + data.carMark + '"/></div>');
                    var $carColor = $('<div class="textarea"><label class="lab">颜色:</label><input class="info" name="carColor"value="'
                        + data.carColor + '"/></div>');
                    var $carMileage = $('<div class="textarea"><label class="lab">车辆总行程:</label><input class="info"name="carMileage" value="'
                        + data.carMileage + '"/></div>');
                    var $carAge = $('<div class="textarea"><label class="lab">车龄:</label><input class="info Wdate" name="carAge" type="text" value="'
                        + data.carAge + '"  onClick="WdatePicker()" /></div>');
                    var $carLimit = $('<div class="textarea"><label class="lab">车辆荷载人数:</label><input class="info" name="carLimit" value="'
                        + data.carLimit + '"/></div>');

                    $("#animateContent").append($id);
                    $("#animateContent").append($carPlate);
                    $("#animateContent").append($carMark);
                    $("#animateContent").append($carColor);
                    $("#animateContent").append($carMileage);
                    $("#animateContent").append($carAge);
                    $("#animateContent").append($carLimit);
                    // 添加修改按钮
                    var $update = $("<a class='update'>确认修改</a>");
                    $("#animateContent").append($update);
                    $("#animateDIV").slideDown();

                    // 添加修改按钮事件
                    $update.click(function () {
                        var $carId = $("input[name='carId']").val();
                        var $carPlate = $(".info[name='carPlate']").val();
                        var $carMark = $(".info[name='carMark']").val();
                        var $carColor = $(".info[name='carColor']").val();
                        var $carMileage = $(".info[name='carMileage']").val();
                        var $carAge = $(".info[name='carAge']").val();
                        var $carLimit = $(".info[name='carLimit']").val();

                        var $data = '{"carId":"' + $carId + '","carPlate":"' + $carPlate + '","carMark":"' + $carMark
                            + '","carColor":"' + $carColor + '","carMileage":"' + $carMileage + '","carAge":"' + $carAge
                            + '","carLimit":' + $carLimit + '}';
                        $.ajax({
                            type: "post",
                            url: "car/updateCarAjax.action",
                            contentType: "application/json;charset=utf-8",
                            data: $data,
                            // data :
                            // '{"carPlate":"湘C-12345"}',//外面是双引号的会报错400
                            // data : "{'carPlate':'湘C-12345'}",
                            success: function (data) {
                                if (data > 0) {
                                    // 刷新列表页面
                                    filpPage($("li>a[index=1]").text() - 1);
                                    $("#animateDIV").hide();
                                } else {
                                    // sweat("更新失败");
                                    sweetAlert("哎呦……", "出错了！", "error");
                                }
                                swal("更新", "更新成功", "success");
                            }
                        })
                    })
                }
            });
        })

        $a3.click(function () {
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
                    var insureId = $a3.attr("insureId");
                    // TODO
                    $.post("insurance/deleteInsuranceAjax.action",
                        {insureId:insureId},
                        function (data) {
                            if (data > 0) {
                                swal("删除成功！", "", "success");
                                filpPage($("li>a[index=1]").text() - 1);
                                $("#animateDIV").slideUp();
                            } else {
                                swal("删除失败！", "", "error");
                            }
                        })
                }
            })
        })
    }
}

// 进入
function pageenter(page) {
    if (page.prop("index") != 1) {
        page.css("background-color", "#eaeff2");
        page.css("color", "#23527c");
        page.css("border-color", "#ddd");
    }
}

// 滑出
function pageout(page) {
    if (page.attr("index") != 1) {
        page.css("background-color", "#fafafa");
        page.css("color", "#2283c5");
        page.css("border-color", "#ddd");
    }
}

// 点击
function clickpage(page) {
    page.css("background-color", "#6faed9");
    page.css("color", "#fff");
    page.css("border-color", "#6faed9");
    page.attr("index", 1);
}

// 清除所有index
function cleanIndex(page) {
    page.attr("index", 0);
}

// 显示
function showAddInsurance() {
    $("#titleInfo").empty("");// 更改标题
    $("#titleInfo").append("添加车辆保险");
    $("#animateContent").empty("");// 清空再加

    var $carPlate = $('<div class="textarea"><label class="lab">车牌号:</label><input id="sb" class="info" name="carPlate"/></div>');
    var $carMark = $('<div class="textarea"><label class="lab">车辆品牌:</label><input class="info" name="carMark" /></div>');
    var $carColor = $('<div class="textarea"><label class="lab">颜色:</label><input class="info" name="carColor"/></div>');
    var $carMileage = $('<div class="textarea"><label class="lab">车辆总行程:</label><input class="info"name="carMileage"/></div>');
    var $carAge = $('<div class="textarea"><label class="lab">车龄:</label><input class="info Wdate" name="carAge" type="text" onClick="WdatePicker()" /></div>');
    var $carLimit = $('<div class="textarea"><label class="lab">车辆荷载人数:</label><input class="info" name="carLimit" /></div>');

    $("#animateContent").append($carPlate);
    $("#animateContent").append($carMark);
    $("#animateContent").append($carColor);
    $("#animateContent").append($carMileage);
    $("#animateContent").append($carAge);
    $("#animateContent").append($carLimit);
    // 添加按钮
    var $addbtn = $("<a class='addbtn btn'>确认添加</a>");
    $("#animateContent").append($addbtn);
    $("#animateDIV").slideDown();

    $addbtn.click(function () {
        var $carPlate = $(".info[name='carPlate']").val();
        var $carMark = $(".info[name='carMark']").val();
        var $carColor = $(".info[name='carColor']").val();
        var $carMileage = $(".info[name='carMileage']").val();
        var $carAge = $(".info[name='carAge']").val();
        var $carLimit = $(".info[name='carLimit']").val();

        var $data = '{"carPlate":"' + $carPlate + '","carMark":"' + $carMark + '","carColor":"' + $carColor + '","carMileage":"' + $carMileage
            + '","carAge":"' + $carAge + '","carLimit":' + $carLimit + '}';
        $.ajax({
            type: "post",
            url: "car/addCarAjax.action",
            contentType: "application/json;charset=utf-8",
            data: $data,
            success: function (data) {
                if (data > 0) {
                    // 刷新列表页面
                    filpPage($("li>a[index=1]").text() - 1);
                    $("#animateDIV").hide();
                    swal("添加车辆成功！");
                } else {
                    swal("添加车辆失败");
                }
            }
        })
    })
}