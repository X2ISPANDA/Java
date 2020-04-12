<%--
  Created by IntelliJ IDEA.
  User: XMY
  Date: 2020/3/20
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>业务异常处理页面</title>
</head>
<body>
    <h1>业务异常处理页面</h1>
    错误编码为：${exception.errorCode}<br/><br/>
    错误信息为：${exception.errorMessage}
</body>
</html>
