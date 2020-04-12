<%--
  Created by IntelliJ IDEA.
  User: XMY
  Date: 2020/3/25
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>通过用户名查询用户信息</title>
</head>
<body>
    <h1>通过用户名查询用户信息</h1>
    <form action="/SSM-Day07/user/queryUserByName.do" method="post">
        用户名:<input type="text" name="username" placeholder="请输入用户名进行查询">
        <input type="submit" value="查询">
    </form>
    <hr/>
id:${userInfo.id}<br/>
name:${userInfo.name}<br/>
username:${userInfo.username}<br/>
password:${userInfo.password}<br/>
sex:${userInfo.sex}<br/>

</body>
</html>
