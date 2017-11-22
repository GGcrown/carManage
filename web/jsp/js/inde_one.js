$(function() {

	$(".leftul")
	//	alert("are you ready?");
	$(".menu").mouseenter(function() {
		$(this).css("color", "#4B9CDE");
		$(this).children("span").css("color", "#4B9CDE");
	})
	$(".menu").mouseleave(function() {
		$(this).css("color", "#FFFFFF");
		$(this).children("span").css("color", "#FFFFFF");
	})

	//上方菜单点击事件
	$(".menuClick").click(function() {
		var a = $(this).index();
		//		console.log(a);
		$(".mainleftspan").hide();
		//动画显示
		$(".mainleftspan:eq(" + a + ")").slideDown();
		$(".mainleftspan:eq(" + a + ")>ul:eq(1)").fadeIn();
		$(".mainleftspan:eq(" + a + ")>ul:eq(0)>li:eq(0)").css("color", "#23B7E5")
		$(".mainleftspan:eq(" + a + ")>ul:eq(1)>li:eq(0)").css("color", "#23B7E5")

	})
	//左侧列表变色
	$(".mainleftspan>ul>li").mouseenter(function() {
		$(this).css("color", "#23B7E5");
	})
	$(".mainleftspan>ul>li").mouseleave(function() {
		if($(this).val() < 1) {
			$(this).css("color", "#555");
		}
	})

	//点击左主菜单
	$(".mainleftul>li").click(function() {
		$(this).css("color", "#23B7E5");
		$(this).prop("value", 2);
		$(".leftul").slideUp();
		$(this).parent().next().slideToggle();
	})

	//点击左菜单
	$(".mainleftspan>.leftul>li").click(function() {
		//		console.log(111);
		$(".leftul>li").css("color", "#555555");
		$(".leftul>li").prop("value", 0);
		$(".mainleftul>li").css("color", "#555555")
		$(".mainleftul>li").prop("value", 0);

		$(this).parent().prev().children().css({
			"color": "#23B7E5"
		});
		$(this).parent().prev().children().prop("value", 1);
		$(this).css("color", "#23B7E5");
		$(this).prop("value", 1);
		//边框属性类
		$(".leftul").removeClass("leftselectul");
		$(this).parent().addClass("leftselectul");
		$(this).parent().prev().addClass("leftselectmain");
		$(".mainFrame").hide();
		var val = $(this).attr("index");
		$(".mainFrame:eq(" + val + ")").show();

	})

	//清空leftul的css和value
	function cleanLeftul() {
		$(".leftul>li").css("color", "#555555")
		$(".leftul>li").prop("value", 0);
	}

	//清空左边的css和value
	function cleanLeft() {
		//TODO
	}

	//显示第一个和第二个
	$(".mainleftspan:eq(0)").show();
	$(".mainleftspan>ul:eq(0)>li:eq(0)").css("color", "#23B7E5")
	$(".mainleftspan>ul:eq(1)>li:eq(0)").css("color", "#23B7E5")
	$(".mainleftspan>ul:eq(0)>li:eq(0)").prop("value", 1);
	$(".mainleftspan>ul:eq(1)>li:eq(0)").prop("value", 1);
	$(".mainleftspan>ul:eq(1)").slideDown();
	//显示第一个iframe
	$(".mainFrame:eq(0)").show();
})