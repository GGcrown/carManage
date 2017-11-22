$(function () {
    // alert(222);
    filpPage(0);
})

function filpPage(page) {
    var a = $.ajax({
        type: "post",
        url: "car/findCarListAjax.action?page=" + page,
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            showCarList(data.cars);
        }
    })
}

function showCarList(cars) {
    for (var i = 0; i < cars.length; i++) {
        var tr = $("<tr></tr>");// tr节点对象
        tr.append("<td align='center'>" + cars[i].carPlate + "</td>");
        tr.append("<td align='center'>" + cars[i].carMark + "</td>");
        tr.append("<td align='center'>" + cars[i].carLimit + "</td>");
        tr.append("<td align='center'>" + cars[i].userName + "</td>");
        $(".tbody").append(tr);
        if (i % 2 == 1) {

        }
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
    }
}
