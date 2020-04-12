<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1px">
        <tr>
            <th>序号</th>
            <th>名称</th>
        </tr>
        <c:forEach items="${list}" var="stu" varStatus="vs">
            <tr>
                <td>${vs.index+1}</td>
                <td>${stu.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
