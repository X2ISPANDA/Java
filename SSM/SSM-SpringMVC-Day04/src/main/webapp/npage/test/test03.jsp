<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: XMY
  Date: 2020/3/14
  Time: 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC的数据回显支持测试</title>
</head>
<body>
    <h1>Spring MVC的数据回显支持测试</h1>
    <%--<form action="/SSM-SpringMVC-Day04/test03/baseDataTest.do" method="post">
        用户名:<input type="text" name="username" value="${username}"/><br/><br/>
        密  码:<input type="password" name="password" value="${password}"/><br/><br/>
        姓  名:<input type="text" name="name" value="${name}"/><br/><br/>
        年  龄:<input type="text" name="age"  value="${age}"/><br/><br/>
        <br/><br/>
        <input type="submit" value="提交" /><br/><br/>
    </form>--%>

    <%
        List<String> hobbyList = (List<String>) request.getAttribute("hobbyList");
        System.out.println(hobbyList);
    %>
    <form action="/SSM-SpringMVC-Day04/test03/pojoTest.do" method="post">
        用户名:<input type="text" name="username" value="${userInfo.username}"/><br/><br/>
        密  码:<input type="password" name="password" value="${userInfo.password}"/><br/><br/>
        姓  名:<input type="text" name="name" value="${userInfo.name}"/><br/><br/>
        年  龄:<input type="text" name="age"  value="${userInfo.age}"/><br/><br/>
        <br/><br/>
        <input type="submit" value="提交" /><br/><br/>
    </form>
</body>
</html>
