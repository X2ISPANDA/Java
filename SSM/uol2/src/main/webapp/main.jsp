<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>联合开放实验室</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/layui-v2.5.5/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/js/layui-v2.5.5/layui/layui.js"></script>
    <script>
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;

        });
    </script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">联合开放实验室</div>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
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
                    <a class="" href="javascript:;">院系管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/school/querySchool.jsp" target="Jiframe">学校信息维护</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/dept/queryDept.jsp" target="Jiframe">院系信息维护</a></dd>
                        <dd><a href="javascript:;" target="Jiframe">专业信息维护</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">上传管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="" target="Jiframe">上传文件</a></dd>
                        <dd><a href="" target="Jiframe">下载文件</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe name="Jiframe" width="100%" height="100%" src="right.jsp" frameborder="0"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © copyright 版权
    </div>
</div>

</body>
</html>