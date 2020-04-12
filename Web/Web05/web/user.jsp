<%--
  ~ Copyright (c) 2020.
  ~ All Rights Reserved,Designed By Mingyu Xiong
  --%>

<%--
  Created by IntelliJ IDEA.
  User: XMY
  Date: 2020/1/18
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取pojo</title>
</head>
<body>
用户id：${user.userId} <br/>
用户名：${user.username}<br/>
性别：${user.password}<br/>
用户id：${userList[0].userId} <br/>
用户名：${userList[0].username}<br/>
性别：${userList[0].password}<br/>
用户id：${userList[1].userId} <br/>
用户名：${userList[1].username}<br/>
性别：${userList[1].password}<br/>
${map["list"][0].id}<br/>
${map["list"][1].name}<br/>
用户：${map1['num']}
</body>
</html>
