<%--
  ~ Copyright (c) 2019.
  ~ All Rights Reserved,Designed By Mingyu Xiong
  --%>

<%--
  Created by IntelliJ IDEA.
  User: XMY
  Date: 2019/11/24
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp页面</title>
</head>
    <body>
    <%--jsp页面中能嵌套java代码--%>
    <%!
        String s = "aaa";
    %>
    <%=s%><br/>
    <%
        /*定义java的代码片段*/
        response.getWriter().write("hello zs");
        out.write("hello jsp");
        out.write(s);
        out.print(request.getAttribute("name"));
    %>
</body>
</html>
