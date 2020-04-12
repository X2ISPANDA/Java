<%--
  Created by IntelliJ IDEA.
  User: XMY
  Date: 2020/2/27
  Time: 1:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>访问成功页面</title>
</head>
<body>
    <h1>访问成功页面</h1>
    <%
        System.out.println(request);
        System.out.println(request.getAttribute("username"));
    %>
    <h1>${username}---${password}---${name}</h1>
</body>
</html>
