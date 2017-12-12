$(function () {
    // 初始显示翻页列表
    listPaging("car/countCarAjax.action");

});

//翻页
function filpPage(page) {
    $.ajax({
        type: "post",
        url: "car/findCarListAjax.action?page=" + page,
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            $(".tbody").empty("");
            showInfoList(data.cars);
        }
    })
}


function showInfoList(info) {
    for (var i = 0; i < info.length; i++) {
        var tr = $("<tr></tr>");// tr节点对象
        tr.append("<td align='center'>" + info[i].carPlate + "</td>");
        tr.append("<td align='center'>" + info[i].carMark + "</td>");
        tr.append("<td align='center'>" + info[i].carLimit + "</td>");
        tr.append("<td align='center'>" + info[i].userName + "</td>");

        var $td = $("<td align='center'></td>");
        //详情按钮
        var $detail = $("<a cid='" + info[i].carId + "' title='查看详情' class='iconfont hovera' >&#xe600;</a>");
        //修改按钮
        var $update = $("<a cid='" + info[i].carId + "' title='修改' class='iconfont hovera'>&#xe615;</a>");
        //删除按钮
        var $delete = $("<a cid='" + info[i].carId + "' title='删除' class='iconfont hovera'>&#xe603;</a>");
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
        infoDeatil($detail);
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
    $("#titleInfo").append("添加车辆");
    $("#animateContent").empty("");// 清空再加

    var $carPlate = $('<div class="textarea"><label class="lab">车牌号:</label><input id="sb" class="info" name="carPlate"/></div>');
    var $carMark = $('<div class="textarea"><label class="lab">车辆品牌:</label><input class="info" name="carMark" /></div>');
    var $carColor = $('<div class="textarea"><label class="lab">颜色:</label><input class="info" name="carColor"/></div>');
    var $carMileage = $('<div class="textarea"><label class="lab">车辆总行程:</label><input class="info"name="carMileage"/></div>');
    var $carAge = $('<div class="textarea"><label class="lab">车龄:</label>' +
        '<input class="info Wdate" name="carAge" type="text" onClick="WdatePicker()" /></div>');
    var $carLimit = $('<div class="textarea"><label class="lab">车辆荷载人数:</label><input class="info" name="carLimit" /></div>');
    var $fileUpload = $('<a class="fileUpload" id="fileUpload">点击选择图片</a>');
    var $carPhoto = $('<div class="textarea"><label class="lab">上传图片</label> ' +
        '<input type="file" class="hide" name="multipartFile"></div>');
    var $img = $("<img display='hide' class='img' onerror='' height='100px' width='100px'>");

    $carPhoto.append($fileUpload);


    $("#animateContent").append($carPlate);
    $("#animateContent").append($carMark);
    $("#animateContent").append($carColor);
    $("#animateContent").append($carMileage);
    $("#animateContent").append($carAge);
    $("#animateContent").append($carLimit);
    $("#animateContent").append($carPhoto);
    $("#animateContent").append($img);

    // 添加按钮
    var $addbtn = $("<a class='addbtn btn'>确认添加</a>");
    $("#animateContent").append($addbtn);
    $("#animateDIV").slideDown();
    //添加信息按钮
    addInfo($addbtn);

    $fileUpload.click(function () {
        $("input[name=multipartFile]").click();

    });

    $carPhoto.change(function () {
        uploadImg();
    })

}


function infoDeatil($a) {
    // 详细信息点击事件
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
                //获得id
                var cid = $delete.attr("cid");
                //获得当前页
                var $currentPage = $(".pages>ul>li>a[index='1']").text();
                $.post("car/ss.action?carId=" + cid,
                    {},
                    function (data) {
                        if (data > 0) {
                            swal("删除成功！", "", "success");
                            //自动刷新翻页
                            filpPage($("li>a[index=1]").text() - 1);
                            listPaging("car/countCarAjax.action", $currentPage);
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
        var $carId = $(this).attr("cid");
        $.ajax({
            type: "post",
            url: "car/findCarByIdAjax.action",
            data: "carId=" + $carId,
            success: function (data) {
                console.log(data);
                var $car = data.car;
                $("#titleInfo").empty("");// 更改标题
                $("#titleInfo").append("更新车辆信息");
                $("#animateContent").empty("");// 清空再加

                var $id = $('<input name="carId" style="display:none" value="' + $carId + '" />');
                var $carPlate = $('<div class="textarea"><label class="lab">车牌号:</label>' +
                    '<input id="sb" class="info" name="carPlate" value="' + $car.carPlate + '"/></div>');
                var $carMark = $('<div class="textarea"><label class="lab">车辆品牌:</label>' +
                    '<input class="info" name="carMark" value="' + $car.carMark + '"/></div>');
                var $carColor = $('<div class="textarea"><label class="lab">颜色:</label>' +
                    '<input class="info" name="carColor"value="' + $car.carColor + '"/></div>');
                var $carMileage = $('<div class="textarea"><label class="lab">车辆总行程:</label>' +
                    '<input class="info"name="carMileage" value="' + $car.carMileage + '"/></div>');
                var $carAge = $('<div class="textarea"><label class="lab">车龄:</label>' +
                    '<input class="info Wdate" name="carAge" type="text" value="'
                    + $car.carAge + '" onClick="WdatePicker()" /></div>');
                var $carLimit = $('<div class="textarea"><label class="lab">车辆荷载人数:</label>' +
                    '<input class="info" name="carLimit" value="' + $car.carLimit + '"/></div>');
                var $img = $("<img class='img' src='../pic/" + $car.carPhoto + "' onerror='' height='100px' width='100px'>");

                $("#animateContent").append($id);
                $("#animateContent").append($carPlate);
                $("#animateContent").append($carMark);
                $("#animateContent").append($carColor);
                $("#animateContent").append($carMileage);
                $("#animateContent").append($carAge);
                $("#animateContent").append($carLimit);
                $("#animateContent").append($img);

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
                        success: function (data) {
                            if (data > 0) {
                                // 刷新列表页面
                                filpPage($("li>a[index=1]").text() - 1);
                                $("#animateDIV").hide();
                            } else {
                                swal("更新失败");
                            }
                            swal("更新成功！");
                        }
                    })
                })
            }
        });
    })
}


function addInfo($addbtn) {
    $addbtn.click(function () {
        var $carPlate = $(".info[name='carPlate']").val();
        var $carMark = $(".info[name='carMark']").val();
        var $carColor = $(".info[name='carColor']").val();
        var $carMileage = $(".info[name='carMileage']").val();
        var $carAge = $(".info[name='carAge']").val();
        var $carLimit = $(".info[name='carLimit']").val();
        var $carPhoto = $('.img').prop('src');
        $carPhoto = $carPhoto.substring($carPhoto.indexOf("/temp/") + 6);

        var $data = '{"carPlate":"' + $carPlate + '","carMark":"' + $carMark + '","carColor":"' + $carColor
            + '","carMileage":"' + $carMileage + '","carAge":"' + $carAge + '","carLimit":' + $carLimit
            + ',"carPhoto":"' + $carPhoto + '"}';
        $.ajax({
            type: "post",
            url: "car/addCarAjax.action",
            contentType: "application/json;charset=utf·-8",
            data: $data,
            success: function (data) {
                if (data > 0) {
                    // 刷新列表页面
                    listPaging("car/countCarAjax.action");
                    filpPage($("li>a[index=1]").text() - 1);
                    $("#animateDIV").hide();
                    swal("添加车辆成功！", "", "success");
                } else {
                    swal("添加车辆失败", "", "error");
                }
            }
        })
    })
}

function uploadImg() {
    var url = '/carManage/car/uplodingFileAjax.action';
    var formData = new FormData($(".uploadForm")[0]);
    $.ajax({
        url: url,
        type: "post",
        data: formData,
        cache: false,
        contentType: false,
        processData: false,
        success: function (data) {
            // console.log(data);
            $(".img").prop("src", "http://localhost:8080/pic/temp/" + data.car.carPhoto);
        },
        error: function (returndata) {
            console.log("error");
//                  alert(returndata)
        }
    })
}