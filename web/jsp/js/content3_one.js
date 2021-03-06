$(function () {
    // 初始显示翻页列表
    listPagingFlash();
});

//翻页
function filpPage(page) {
    $.ajax({
        type: "post",
        url: "annualcheck/listAnnualcheckByPageAjax.action?page=" + page,
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            $(".tbody").empty("");
            showInfoList(data.annualcheckList);
        }
    })
}


function showInfoList(info) {
    for (var i = 0; i < info.length; i++) {
        var tr = $("<tr></tr>");// tr节点对象
        tr.append("<td align='center'>" + info[i].carPlate + "</td>");
        tr.append("<td align='center'>" + info[i].deptname + "</td>");
        tr.append("<td align='center'>" + info[i].lastannualcheckdate + "</td>");
        tr.append("<td align='center'>" + info[i].nextannualcheckdate + "</td>");

        var $td = $("<td align='center'></td>");
        //详情按钮
        var $detail = $("<a cid='" + info[i].carId + "' title='查看详情' class='iconfont hovera'>&#xe61c;</a>");
        //修改按钮
        var $update = $("<a annualcheckId=' " + info[i].annualcheckId + "' title='修改' class='iconfont hovera'>&#xe615;</a>");
        //删除按钮
        var $delete = $("<a annualcheckId='" + info[i].annualcheckId + "' title='删除' class='iconfont hovera' >&#xe603;</a>");
        $td.append($detail);
        tr.append($td);

        $td = $("<td align='center'></td>");
        $td.append($update);
        $td.append($delete);
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

        // 详细信息点击事件
        infoDetail($detail);
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
    $("#titleInfo").append("添加车辆年检");
    $("#animateContent").empty("");// 清空再加

    $.ajax({
        type: "post",
        url: "car/findAllCarPlateAjax.action",
        success: function (data) {
            var $plate = $('<select name="carId" class="selectOption info"></select>');
            //显示车牌号
            for (var i = 0; i < data.length; i++) {
                $plate.append($("<option value='" + data[i].carId + "'>" + data[i].carPlate + "</option>"));
            }

            var $carPlate = $('<div class="textarea"><label class="lab">车牌号:</label></div>');
            var $deptname = $('<div class="textarea"><label class="lab">车辆单位:</label>' +
                '<input class="info" name="deptname"/></div>');
            var $lastannualcheckdate = $('<div class="textarea"><label class="lab">上次年检时间:</label>' +
                '<input class="info Wdate" name="lastannualcheckdate" onClick="WdatePicker()" /></div>');
            var $nextannualcheckdate = $('<div class="textarea"><label class="lab">下次年检时间:</label>' +
                '<input class="info Wdate" name="nextannualcheckdate" onClick="WdatePicker()" /></div>');

            $carPlate.append($plate);
            $("#animateContent").append($carPlate);
            $("#animateContent").append($deptname);
            $("#animateContent").append($lastannualcheckdate);
            $("#animateContent").append($nextannualcheckdate);
            // 添加按钮
            var $addbtn = $("<a class='addbtn btn'>确认添加</a>");
            $("#animateContent").append($addbtn);
            $("#animateDIV").slideDown();

            addInfo($addbtn);
        }
    });


}


function infoDetail($a) {// 详细信息点击事件
    $a.click(function () {
        var $carId = $(this).attr("cid");
        $.ajax({
            type: "post",
            url: "car/findCarByIdAjax.action",
            data: "carId=" + $carId,
            success: function (data) {
                console.log(data);
                var $car = data.car;

                $("#titleInfo").empty("");// 更改标题
                $("#titleInfo").append("详细信息");
                $("#animateContent").empty("");// 清空再加
                var $carPlate = $('<div class="textarea"><label class="lab">车牌号:</label><span class="info">'
                    + $car.carPlate + '</span></div>');
                var $carMark = $('<div class="textarea"><label class="lab">车辆品牌:</label><span class="info">'
                    + $car.carMark + '</span></div>');
                var $carColor = $('<div class="textarea"><label class="lab">颜色:</label><span class="info">'
                    + $car.carColor + '</span></div>');
                var $carMileage = $('<div class="textarea"><label class="lab">车辆总行程:</label><span class="info">'
                    + $car.carMileage + '</span></div>');
                var $carAge = $('<div class="textarea"><label class="lab">车龄:</label><span class="info">'
                    + $car.carAge + '</span></div>');
                var $carLimit = $('<div class="textarea"><label class="lab">车辆荷载人数:</label><span class="info">'
                    + $car.carLimit + '</span></div>');
                var $img = $("<img class='img' src='../pic/" + $car.carPhoto + "' onerror='' height='100px' width='100px'>");

                $("#animateContent").append($carPlate);
                $("#animateContent").append($carMark);
                $("#animateContent").append($carColor);
                $("#animateContent").append($carMileage);
                $("#animateContent").append($carAge);
                $("#animateContent").append($carLimit);
                $("#animateContent").append($img);
                $("#animateDIV").slideDown();
            }
        });
    })
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
                var annualcheckId = $delete.attr("annualcheckId");
                $.post("annualcheck/deleteAnnualcheckAjax.action",
                    {annualcheckId: annualcheckId},
                    function (data) {
                        if (data > 0) {
                            swal("删除成功！", "", "success");
                            //自动刷新翻页
                            filpPage($("li>a[index=1]").text() - 1);
                            listPagingFlash();
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
        var $annualcheckid = $(this).attr("annualcheckid");
        $.ajax({
            type: "post",
            url: "annualcheck/findAnnualcheckByIdAjax.action",
            data: "annualcheckId=" + $annualcheckid,
            success: function (data) {
                $annualcheck = data.annualcheck;
                $("#titleInfo").empty("");// 更改标题
                $("#titleInfo").append("更新车辆年检信息");
                $("#animateContent").empty("");// 清空再加


                var $carPlate = $('<div class="textarea"><label class="lab">车牌号:</label><span class="info">' + $annualcheck.carPlate + '</span></div>');
                var $deptname = $('<div class="textarea"><label class="lab">车辆单位:</label><span class="info">'
                    + ' <input name="deptname" value="' + $annualcheck.deptname + '"/></span></div>');
                var $lastannualcheckdate = $('<div class="textarea"><label class="lab">上次年检时间:</label><span class="info">'
                    + ' <input class="Wdate" name="lastannualcheckdate" onClick="WdatePicker()" value="' + $annualcheck.lastannualcheckdate + '"/></span></div>');
                var $nextannualcheckdate = $('<div class="textarea"><label class="lab">下次年检时间:</label><span class="info">'
                    + ' <input class="Wdate" name="nextannualcheckdate" onClick="WdatePicker()" value="' + $annualcheck.nextannualcheckdate + '"/></span></div>');

                $("#animateContent").append($carPlate);
                $("#animateContent").append($deptname);
                $("#animateContent").append($lastannualcheckdate);
                $("#animateContent").append($nextannualcheckdate);
                // 添加修改按钮
                var $updateBtn = $("<a class='update'>确认修改</a>");
                $("#animateContent").append($updateBtn);
                $("#animateDIV").slideDown();

                // 添加修改按钮事件
                $updateBtn.click(function () {
                    var $insureTypeofinsurance = $("input[name='insureTypeofinsurance']").val();
                    var $insuranceStarttime = $("input[name='insuranceStarttime']").val();
                    var $insuranceEndtime = $("input[name='insuranceEndtime']").val();
                    var $filepath = $("input[name='filepath']").val();
                    var $deptname = $("input[name='deptname']").val();
                    var $insureType = $("input[name='insureType']").val();

                    var $data = '{"insureTypeofinsurance":"' + $insureTypeofinsurance + '","insuranceStarttime":"' + $insuranceStarttime
                        + '","insuranceEndtime":"' + $insuranceEndtime + '","insureId":"' + $insuranceId + '","filepath":"' + $filepath
                        + '","deptname":"' + $deptname + '","insureType":"' + $insureType + '"}';
                    $.ajax({
                        type: "post",
                        url: "insurance/updateInsuranceAjax.action",
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
        var $carId = $(".info[name='carId']").val();
        var $lastannualcheckdate = $(".info[name='lastannualcheckdate']").val();
        var $nextannualcheckdate = $(".info[name='nextannualcheckdate']").val();
        var $deptname = $(".info[name='deptname']").val();

        var $data = '{"carId":' + $carId + ',"lastannualcheckdate":"' + $lastannualcheckdate + '","nextannualcheckdate":"' + $nextannualcheckdate
            + '","deptname":"' + $deptname + '"}';
        //获得当前页
        var $currentPage = $(".pages>ul>li>a[index='1']").text();
        $.ajax({
            type: "post",
            url: "annualcheck/addAnnualcheckAjax.action",
            contentType: "application/json;charset=utf-8",
            data: $data,
            success: function (data) {
                if (data > 0) {
                    // 刷新列表页面
                    listPagingFlash($currentPage);
                    filpPage($("li>a[index=1]").text() - 1);
                    $("#animateDIV").hide();
                    swal("添加年检成功！");
                } else {
                    swal("添加年检失败");
                }
            }
        })
    })
}

function listPagingFlash($currentPage) {
    listPaging("annualcheck/countAnnualcheckAjax.action", $currentPage);
}