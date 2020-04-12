<%--
  Created by IntelliJ IDEA.
  User: XMY
  Date: 2020/3/17
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC对RESTful风格的支持</title>
    <script src="/SSM-SpringMVC-Day04/js/jquery-3.3.1.min.js"></script>
</head>
<body>
    <h1>Spring MVC对RESTful风格的支持</h1>
    <button type="button" id="buttonId">点击发起ajax请求</button>
    <script>
        $("#buttonId").click(function () {
            var userInfo = {
                username:"zhangsan",
                password:"123",
                age:"18"
            }
            $.ajax({
                type:"post",
                url:"/SSM-SpringMVC-Day04/test05/restTest",
                contentType: 'application/json;charset=utf-8',
                data: JSON.stringify(userInfo),
                success:function (result) {
                    alert(result.username + "---" + result.password);
                },
                error: function () {
                    alert("请求出现异常,请联系管理员!");
                }
            });
        });
    </script>
</body>
</html>
