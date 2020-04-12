<%--
  ~ Copyright (c) 2019.
  ~ All Rights Reserved,Designed By Mingyu Xiong
  --%>

<%--
  Created by IntelliJ IDEA.
  User: XMY
  Date: 2019/12/21
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script>
        function getUser() {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/jsonUser",
                data:"name="+$("#name").val(),
                success: function (result) {
                    alert(typeof result);
                    let eval1 = eval("(" + result + ")");
                    alert(eval1.name);
                    alert(eval1.age);
                    alert(eval1.sex);

                }

            });

        }
    </script>
</head>
<body>
    <input type="text" name="name" id="name" onblur="getUser();">
</body>
</html>
