<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  ~ Copyright (c) 2019.
  ~ All Rights Reserved,Designed By Mingyu Xiong
  --%>

<%--
  Created by IntelliJ IDEA.
  User: XMY
  Date: 2019/12/21
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>联动下拉</title>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script>
        function selectDept() {
            let school = $("#school").val();
            $.post(
                "${pageContext.request.contextPath}/ldservlet",
                {"schoolId":school},
                function (result) {
                    let d = eval("(" + result + ")");
                    var option = "";
                    for (let i = 0; i < d.length; i++) {
                        option += "<option value='" + d[i].id + "'>" + d[i].name + "</option>";
                        $("#dept").html(option);
                    }
                }
            );

        }
    </script>
</head>
<body>
    学校:<select name="school" id="school" onchange="selectDept();">
        <option></option>
        <c:forEach var="school" items="${list}">
            <option value="${school.id}">${school.name}</option>
        </c:forEach>
    院系:<select id="dept"></select>
</body>
</html>
