<%--
  Created by IntelliJ IDEA.
  User: XMY
  Date: 2020/3/16
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC处理Ajax请求的测试</title>
    <script src="/SSM-SpringMVC-Day04/js/jquery-3.3.1.min.js"></script>
</head>
<body>
    <h1>Spring MVC处理Ajax请求的测试</h1>
    <button type="button" id="buttonId01">点击发起AJAX请求（普通）</button>
    <button type="button" id="buttonId02">点击发起AJAX请求（Jackson）</button>
    <button type="button" id="buttonId03">点击发起AJAX请求（JSON数据的请求）</button>
    <script>
        $("#buttonId01").click(function () {
            $.ajax({
                type:"post",
                url:"/SSM-SpringMVC-Day04/test04/ajaxString.do",

                data:"username=zhangsan&password=123&age=18",
                success:function (result) {
                    var resultObj = JSON.parse(result);
                    alert(resultObj.username + "---" + resultObj.password);
                },
                error:function () {
                    alert("请求出现异常,请联系管理员!");
                }
            });
        });

        $("#buttonId02").click(function () {
            $.ajax({
                type:"post",
                url:"/SSM-SpringMVC-Day04/test04/ajaxJackson.do",
                data:"username=zhangsan&password=123&age=18",
                success:function (result) {
                    alert(result.username + "---" + result.password);
                },
                error:function () {
                    alert("请求出现异常,请联系管理员!");
                }
            });
        });

        $("#buttonId03").click(function () {
            var userInfo = {
                username:"zhangsan",
                password:"123",
                age:"18"
            }
            $.ajax({
                type:"post",
                url:"/SSM-SpringMVC-Day04/test04/ajaxInJSON.do",
                contentType: 'application/json;charset=utf-8',
                data: JSON.stringify(userInfo),
                success:function (result) {
                    alert(result.username + "---" + result.password);
                },
                error:function () {
                    alert("请求出现异常,请联系管理员!");
                }
            });
        });
    </script>
</body>
</html>
