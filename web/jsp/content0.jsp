<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <link rel="stylesheet" href="jsp/css/content_one.css"/>
    <link rel="stylesheet" href="jsp/css/font.css"/>
    <link rel="stylesheet" href="jsp/css/icon.css"/>
    <link rel="stylesheet" href="jsp/css/content_0.css">
    <link rel="stylesheet" href="jsp/css/content_base.css">
    <link rel="stylesheet" href="jsp/sweetallert/dist/sweetalert2.css">
    <script type="text/javascript" src="jsp/sweetallert/dist/sweetalert2.min.js"></script>
    <script type="text/javascript" src="jsp/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="jsp/js/content0_one.js"></script>
    <script type="text/javascript" src="jsp/js/content_base.js"></script>
    <script type="text/javascript" src="/carManage/jsp/My97DatePicker/WdatePicker.js"></script>

    <%--
    filename: file_name
    author:crown
    email:1084961504@qq.com
    createtime：Oct 30, 2017 12:22:02 PM
    --%>
</head>
<body>
<ul>
    <li class="index"><a class="indexhome">首页</a></li>
    <li class="index"><span class="fontawesome">&#xf105;</span>停车场管理</li>
    <li class="index"><span class="fontawesome">&#xf105;</span>停车场管理</li>
    <li class="index"><span class="fontawesome">&#xf105;</span>车辆调配</li>
    <li class="index"><span class="fontawesome">&#xf105;</span>停车管理</li>
</ul>

<hr style="height: 1px; border: none; border-top: 1px dotted #e2e2e2; width: 92%;"/>
<div class="divcontent">
    <div class="manage">
        <a class="btn query" id="addCar">添加车辆</a>
    </div>
    <div class="divtbl">
        <table class="tblcontent">
            <thead>
            <tr>
                <th>车牌号</th>
                <th>车辆品牌</th>
                <th>核载人数</th>
                <th>使用人</th>
                <th>查看</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody class="tbody">
            <!-- js生成 -->
            </tbody>
        </table>
    </div>
    <div id="contentdiv">
        <div id="animateDIV">
            <div id="animateDIVTitle">
                <!-- js生成 -->
                <div id="titleDIV">
                    <span id="titleInfo">详细信息</span><a id="iconfontX" class="iconfont">&#xe638;</a>
                </div>
            </div>
            <form id="animateContent" class="uploadForm">
                <!-- js生成 -->
            </form>
        </div>
    </div>

    <div class="pages">
        <ul>
            <li><a cancel="1"> <</a></li>
            <li id="one"><a default="t">1</a></li>
            <!-- js生成 -->
            <!-- <li><a>2</a></li> -->
            <li class="last"><a cancel="2">></a></li>
        </ul>
    </div>
</div>
</body>
</html>