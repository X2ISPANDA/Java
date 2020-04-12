<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XMY
  Date: 2020/3/27
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>多条件动态查询用户信息</title>
</head>
<body>
    <h1>多条件动态查询用户信息</h1>
    <form action="/SSM-Day07/user/queryUserMultiple.do" method="post">
        姓名：<input type="text" name="name"/>
        用户名：<input type="text" name="username"/>
        密码：<input type="text" name="password"/>
        <input type="submit" name="查询"/>
    </form>
    <hr/>
    <c:forEach var="userInfo" items="${userInfoList}">
        id:${userInfo.id},
        name:${userInfo.name},
        username:${userInfo.username},
        password:${userInfo.password},
        sex:${userInfo.sex}<br/>
    </c:forEach>
</body>
</html>
