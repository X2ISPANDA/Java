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
            <th>id</th>
            <th>名称</th>
            <th>年龄</th>
            <th>日期</th>
        </tr>
        <c:forEach items="${list}" var="p" varStatus="vs">
            <tr>
                <td>${vs.index+1}</td>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.age}</td>
                <td>${p.curDate}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
