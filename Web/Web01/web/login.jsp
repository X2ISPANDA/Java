<%--
  ~ Copyright (c) 2019.
  ~ All Rights Reserved,Designed By Mingyu Xiong
  --%>

<%--
  Created by IntelliJ IDEA.
  User: XMY
  Date: 2019/11/16
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/web01/login" method="post">
    用户名:<input type="text" name="username" placeholder="请输入合法用户名"><br/>
    密码:<input type="password" name="password"><br/>
    <input type="submit" value="登录">
</form>
</body>
</html>
