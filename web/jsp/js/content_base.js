$(function () {

    // 第一页异步查询显示
    filpPage(0);
    // 默认第一页选择
    clickpage($(".pages>ul>li>a[default='t']"));


    // mouse enter change color
    $(".tbody>tr").mouseenter(function () {
        var index = $(this).index();
        if (index % 2 == 1) {
            $(this).css("background-color", "#F5F5F5");
        }
    });

    // mouse enter change color
    $(".tbody>tr").mouseout(function () {
        var index = $(this).index();
        if (index % 2 == 1) {
            $(this).css("background-color", "#FFFFFF");
        }
    });

    // 分页鼠标进入
    $(".pages>ul>li>a").mouseenter(function () {
        if ($(this).attr("index") != 1) {
            pageenter($(this));
        }
    });

    // 分页鼠标离开
    $(".pages>ul>li>a").mouseout(function () {
        if ($(this).attr("index") != 1) {
            pageout($(this));
        }
    });

    // 显示添加汽车
    $("#addCar").click(function () {
        showAddInfo();
    });

    $("#iconfontX").click(function () {
        $("#animateDIV").slideUp();
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

});

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

// 显示翻页按钮
function listPaging($urlPath, $currentPage) {
    var $defaultPage = $(".pages>ul>li>a[index='1']").text();
    $.ajax({
        url: $urlPath,
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            //先删除原来的，防止追加
            $(".page-append").remove();
            var one = $("#one");
            for (var i = 2; i <= data.pageSum; i++) {
                var $li = $("<li class='page-append'></li>");
                var $a = $("<a>" + i + "</a>");
                $li.append($a);
                one.after($li);
                one = $li;
                //模仿点击
                if ($currentPage == i) {
                    clickpage($a);
                }
                // 新建节点事件也需要重写
                $a.mouseenter(function () {
                    if ($(this).attr("index") != 1) {
                        pageenter($(this));
                    }
                });
                $a.mouseout(function () {
                    if ($(this).attr("index") != 1) {
                        pageout($(this));
                    }
                });
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
            //如果默认页大于总页数
            if ($defaultPage > data.pageSum) {
                clickpage($(".last").prev().children());
                filpPage($(".last").prev().children().text() - 1);
                // filpPage($defaultPage - 1);
            }
        }
    });
    return 100;
}

function addHoverA($select) {
    // $(".hovera").hover(function () {
    $select.hover(function () {
        //进入
        $(this).prop("id", "hovera");
    }, function () {
        //离开
        $(this).prop("id", "");
    });
}

