<%--
  User: crown
  Date: 2017/12/13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>

    <link rel="stylesheet" href="jsp/css/style.css">
    <script src="jsp/js/jquery-3.2.1.js"></script>
</head>

<body>

<!-- demo content -->
<div class="loginform cf">
    <form name="loginForm" action="user/userlogin.action" method="post" accept-charset="utf-8">
        <ul>
            <li>
                <label for="username">账号：</label>
                <input type="text" name="username" oninvalid="setCustomValidity('用户名不能为空')"
                       oninput="setCustomValidity('')" placeholder="username" required>
            </li>
            <li>
                <label for="password">密码：</label>
                <input type="password" name="password" oninvalid="setCustomValidity('密码不能为空')"
                       oninput="setCustomValidity('')" placeholder="password" required></li>
            <li>
                <input type="submit" id="login" value="登录">
            </li>
        </ul>
    </form>
</div>

</body>