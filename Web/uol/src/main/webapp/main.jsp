<%--
  ~ Copyright (c) 2019. 
  ~ All Rights Reserved,Designed By Mingyu Xiong
  --%>

<%--
  Created by IntelliJ IDEA.
  User: XMY
  Date: 2019/12/22
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>联合开放实验室</title>
    <link rel="stylesheet" href="layui-v2.5.5/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">联合开放实验室</div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    张三
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">基本信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/school?method=querySchool" target="JIFrame">学校管理</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/dept?method=querySchool" target="JIFrame">院系管理</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/major?method=querySchool" target="JIFrame">专业管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">上传下载</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/file?method=uploadFile" target="JIFrame">上传文件</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/file?method=downloadFile" target="JIFrame">下载文件</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">云市场</a></li>
                <li class="layui-nav-item"><a href="">发布商品</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <iframe name="JIFrame" width="100%" height="100%" frameborder="0" src="index.jsp"></iframe>
        </div>

    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © wrx.com - 王睿希人生有限公司
    </div>
</div>
<script src="layui-v2.5.5\layui\layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>
