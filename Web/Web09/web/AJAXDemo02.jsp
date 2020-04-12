<%--
  ~ Copyright (c) 2019.
  ~ All Rights Reserved,Designed By Mingyu Xiong
  --%>

<%--
  Created by IntelliJ IDEA.
  User: XMY
  Date: 2019/12/21
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jquery的异步</title>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script>
        function checkName() {
            let name = $("#name").val();
            alert(obj.val());
            alert(name);
            $.ajax({
                type:"get",
                async:true,
                url:"${pageContext.request.contextPath}/checkName?name="+name,
                success:function (result) {
                    alert(result);
                    if (result == "y") {
                        alert("用户名重复");
                    } else {
                        alert("用户名可以使用");
                    }

                },
                error:function () {

                }});
            alert("异步之后的代码");

        }

        function checkNameGet() {
            let name = $("#name").val();
            $.get(
                "${pageContext.request.contextPath}/checkName",
                {name: name},
                function (result) {
                    alert(result);

                }
            );

        }
    </script>
</head>
<body>
用户名:<input type="text" name="name" id="name" onblur="checkName(this);">
</body>
</html>
