<%--
  ~ Copyright (c) 2019.
  ~ All Rights Reserved,Designed By Mingyu Xiong
  --%>

<%--
  Created by IntelliJ IDEA.
  User: XMY
  Date: 2019/11/24
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>输出表格</title>
</head>
<body>
    <table>
        <tr>
            <th>序号</th>
            <th>用户名</th>
            <th>密码</th>
        </tr>
        <tr>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <%
            for (int i = 0; i < 10; i++) {
        %>
        <tr>
            <td><%=i%></td>
            <td><%=i+1%></td>
            <td><% out.print(i + 1);%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
