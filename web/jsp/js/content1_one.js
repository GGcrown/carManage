$(function () {
    // 初始显示翻页列表
    listPaging("insurance/countInsuranceAjax.action");

});

//翻页
function filpPage(page) {
    $.ajax({
        type: "post",
        url: "insurance/findInsuranceListAjax.action?page=" + page,
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            $(".tbody").empty("");
            showInfoList(data.insurances);
        }
    })
}


function showInfoList(info) {
    for (var i = 0; i < info.length; i++) {
        var tr = $("<tr></tr>");// tr节点对象
        tr.append("<td align='center'>" + info[i].insureTypeofinsurance + "</td>");
        tr.append("<td align='center'>" + info[i].insureTypeofinsurance + "</td>");
        tr.append("<td align='center'>" + info[i].insureCompany + "</td>");
        tr.append("<td align='center'>" + info[i].insuranceEndtime + "</td>");
        tr.append("<td align='center'>" + info[i].deptname + "</td>");

        var $td = $("<td align='center'></td>");
        //详情按钮
        var $detail = $("<a insureId='" + info[i].insureId + "' title='查看详情' class='iconfont hovera'>&#xe600;</a>");
        //修改按钮
        var $update = $("<a insureId=' " + info[i].insureId + "' title='修改' class='iconfont hovera'>&#xe615;</a>");
        //删除按钮
        var $delete = $("<a insureId='" + info[i].insureId + "' title='删除' class='iconfont hovera' >&#xe603;</a>");
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
    $("#titleInfo").append("添加车辆保险");
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
            var $insureTypeofinsurance = $('<div class="textarea"><label class="lab">保险类型:</label><input class="info" name="insureTypeofinsurance"/></div>');
            var $insuranceStarttime = $('<div class="textarea"><label class="lab">保险开始时间:</label><input class="info Wdate" name="insuranceStarttime" onClick="WdatePicker()" /></div>');
            var $insuranceEndtime = $('<div class="textarea"><label class="lab">保险失效时间:</label><input class="info Wdate" name="insuranceEndtime" onClick="WdatePicker()" /></div>');
            var $insureCompany = $('<div class="textarea"><label class="lab">车辆单位:</label><input class="info" name="insureCompany" type="text"/></div>');
            var $deptname = $('<div class="textarea"><label class="lab">保险公司:</label><input class="info" name="deptname" /></div>');
            $carPlate.append($plate);

            $("#animateContent").append($carPlate);
            $("#animateContent").append($insureTypeofinsurance);
            $("#animateContent").append($insuranceStarttime);
            $("#animateContent").append($insuranceEndtime);
            $("#animateContent").append($insureCompany);
            $("#animateContent").append($deptname);
            // 添加按钮
            var $addbtn = $("<a class='addbtn btn'>确认添加</a>");
            $("#animateContent").append($addbtn);
            $("#animateDIV").slideDown();

            addInfo($addbtn);
        }
    });


}


function infoDetail($a) {
    // 详细信息点击事件
    $a.click(function () {
        var $insuranceId = $(this).attr("insureid");
        $d = 'insuranceId =' + $insuranceId;
        $.ajax({
            type: "post",
            url: "insurance/findByInsureIdAjax.action?insuranceId=" + $insuranceId,
            // data : $d ,
            success: function (d) {
                var data = d.insurance;
                $("#titleInfo").empty("");// 更改标题
                $("#titleInfo").append("详细信息");
                $("#animateContent").empty("");// 清空再加
                var $type = $('<div class="textarea"><label class="lab">保险类型:</label><span class="info">'
                    + data.insureTypeofinsurance + '</span></div>');
                var $sTime = $('<div class="textarea"><label class="lab">保险生效时间:</label><span class="info">'
                    + data.insuranceStarttime + '</span></div>');
                var $eTime = $('<div class="textarea"><label class="lab">保险失效时间:</label><span class="info">'
                    + data.insuranceEndtime + '</span></div>');
                var $filepath = $('<div class="textarea"><label class="lab">图片:</label><span class="info">'
                    + data.filepath + '</span></div>');
                var $deptname = $('<div class="textarea"><label class="lab">车辆单位:</label><span class="info">'
                    + data.deptname + '</span></div>');

                $("#animateContent").append($type);
                $("#animateContent").append($sTime);
                $("#animateContent").append($eTime);
                $("#animateContent").append($filepath);
                $("#animateContent").append($deptname);
                $("#animateDIV").slideDown();
            }
        });
    });
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
                var insureId = $delete.attr("insureId");
                $.post("insurance/deleteInsuranceAjax.action",
                    {insureId: insureId},
                    function (data) {
                        if (data > 0) {
                            swal("删除成功！", "", "success");
                            //自动刷新翻页
                            filpPage($("li>a[index=1]").text() - 1);
                            listPaging("insurance/countInsuranceAjax.action", $currentPage);
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
        var $insuranceId = $(this).attr("insureid");
        $.ajax({
            type: "post",
            url: "insurance/findByInsureIdAjax.action",
            data: "insuranceId=" + $insuranceId,
            success: function (data) {
                $insurance = data.insurance;
                $("#titleInfo").empty("");// 更改标题
                $("#titleInfo").append("更新车辆信息");
                $("#animateContent").empty("");// 清空再加

                var $id = $('<input name="insuranceId" style="display:none" value="' + $insuranceId + '" />');
                var $type = $('<div class="textarea"><label class="lab">保险类型:</label><span class="info">'
                    + ' <input name="insureTypeofinsurance" value="' + $insurance.insureTypeofinsurance + '"/></span></div>');
                var $sTime = $('<div class="textarea"><label class="lab">保险生效时间:</label><span class="info"> '
                    + '<input name="insuranceStarttime" class="Wdate" value="' + $insurance.insuranceStarttime
                    + '" onClick="WdatePicker()"/></span></div>');
                var $eTime = $('<div class="textarea"><label class="lab">保险失效时间:</label><span class="info"> '
                    + '<input name="insuranceEndtime" class="Wdate" value="' + $insurance.insuranceEndtime
                    + '"  onClick="WdatePicker()"/></span></div>');
                var $filepath = $('<div class="textarea"><label class="lab">图片:</label><span class="info"> ' + '<input name="filepath" value="'
                    + $insurance.filepath + '"/></span></div>');
                var $deptname = $('<div class="textarea"><label class="lab">车辆单位:</label><span class="info"> '
                    + '<input name="deptname" value="' + $insurance.deptname + '"/></span></div>');
                var $insureType = $('<div class="textarea"><label class="lab">保险类型:</label><span class="info"> '
                    + '<input name="insureType" value="' + $insurance.insureType + '"/></span></div>');

                $("#animateContent").append($type);
                $("#animateContent").append($sTime);
                $("#animateContent").append($eTime);
                $("#animateContent").append($filepath);
                $("#animateContent").append($deptname);
                $("#animateContent").append($insureType);
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
        var $insureTypeofinsurance = $(".info[name='insureTypeofinsurance']").val();
        var $insuranceStarttime = $(".info[name='insuranceStarttime']").val();
        var $insuranceEndtime = $(".info[name='insuranceEndtime']").val();
        var $carMileage = $(".info[name='carMileage']").val();
        var $insureCompany = $(".info[name='insureCompany']").val();
        var $deptname = $(".info[name='deptname']").val();

        var $data = '{"carid":' + $carId + ',"insureTypeofinsurance":"' + $insureTypeofinsurance + '","insuranceStarttime":"' + $insuranceStarttime
            + '","insuranceEndtime":"' + $insuranceEndtime + '","carMileage":"' + $carMileage + '","insureCompany":"' + $insureCompany
            + '","deptname":"' + $deptname + '"}';
        //获得当前页
        var $currentPage = $(".pages>ul>li>a[index='1']").text();
        $.ajax({
            type: "post",
            url: "insurance/addInsuranceAjax.action",
            contentType: "application/json;charset=utf-8",
            data: $data,
            success: function (data) {
                if (data > 0) {
                    // 刷新列表页面
                    listPaging("insurance/countInsuranceAjax.action", $currentPage);
                    filpPage($("li>a[index=1]").text() - 1);
                    $("#animateDIV").hide();
                    swal("添加车辆保险成功！");
                } else {
                    swal("添加车辆保险失败");
                }
            }
        })
    })
}