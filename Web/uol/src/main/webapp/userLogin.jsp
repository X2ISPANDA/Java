<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <script>
        var ctx = "${ctx}";

    </script>
    <title>登录</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="layui-v2.5.5/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="css/login.css" media="all"/>
</head>
<body>
<div id="jsi-snow-container" class="container"></div>
<div class="login">
    <h1>联合开放实验室</h1>
    <div class="layui-form-item">
        <input class="layui-input" name="username" placeholder="用户名" lay-verify="required" type="text" id="username"
               autocomplete="off">
    </div>
    <div class="layui-form-item">
        <input class="layui-input" name="password" id="password" placeholder="密码" lay-verify="required" type="password"
               autocomplete="off">
    </div>
    <div class="layui-form-item form_code" style="display: flex;">
        <input class="layui-input" id="code" name="code" placeholder="验证码" lay-verify="required" type="text"
               autocomplete="off">
        <canvas id="canvas" width="116" height="36"></canvas>
    </div>
    <button class="layui-btn login_btn" id="loginBt">登录</button>

</div>
<div style="text-align:center;background-color:whitesmoke">© wrx.com - 王睿希人生有限公司</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="layui-v2.5.5/layui/layui.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/snow_canvas.js"></script>
<script>
    var jieguo = "<%=request.getAttribute("result")%>";
    console.log(jieguo);
</script>
</body>
</html>