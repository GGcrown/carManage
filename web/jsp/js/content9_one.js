$(function() {
			$(".send").click(function() {
						filpPage();

					})
		})

function filpPage() {
	var a = $.ajax({
				type : "post",
				url : "car/findCarListAjax.action?page=0",
				contentType : "application/json;charset=utf-8",
				success : function(data) {
					console.log(data.cars[0].carId);
					showCarList(data.cars);
				}
			})
	// alert(a.cars);
}

function showCarList(cars) {
	for (var i = 0; i < cars.length; i++) {
		var tr = $("<tr></tr>");// tr节点对象
		tr.append("<td>" + cars[i].carId + "<td>");
		$(".tbody").append(tr);
	}

}
