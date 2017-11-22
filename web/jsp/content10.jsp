<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<link rel="stylesheet" href="jsp/css/content_one.css" />
<link rel="stylesheet" href="jsp/css/font.css" />
<link rel="stylesheet" href="jsp/css/icon.css" />
<%--
filename: file_name
author:crown 
email:1084961504@qq.com
createtime：Oct 23, 2017 4:43:03 PM
--%>
</head>
<body>
	<ul>
		<li class="index"><a class="indexhome" href="#">首页</a></li>
		<li class="index"><span class="fontawesome">&#xf105;</span>停车场管理</li>
		<li class="index"><span class="fontawesome">&#xf105;</span>停车场管理</li>
		<li class="index"><span class="fontawesome">&#xf105;</span>车辆调配</li>
		<li class="index"><span class="fontawesome">&#xf105;</span>停车管理</li>
	</ul>
	<hr style="height: 1px; border: none; border-top: 1px dotted #e2e2e2; width: 92%;" />
	<h1>一条大河</h1>
	${ cars}
</body>
</html>