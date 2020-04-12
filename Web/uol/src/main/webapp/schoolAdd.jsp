<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  ~ Copyright (c) 2019.
  ~ All Rights Reserved,Designed By Mingyu Xiong
  --%>

<!DOCTYPE html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+
            request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="<%=basePath%>"/>
    <title>添加学校</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    <%--    <link href="css/plugins/datapicker/datepicker3.css" rel="stylesheet">--%>

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>添加学校</h5>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal m-t" id="commentForm" action="school">
                        <input type="hidden" name="method" value="addSchool"/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学校名称：</label>
                            <div class="col-sm-8">
                                <input id="schoolName" name="schoolName" type="text" required class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">地址：</label>
                            <div class="col-sm-8">
                                <input id="qq" name="qq" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">备注：</label>
                            <div class="col-sm-8">
                                <textarea id="ccomment" name="remark" required minlength="10" class="form-control"  aria-required="true"></textarea>
                            </div>
                        </div>
                        <!--<div class="form-group" id="data_1">
                            <label class="col-sm-3 control-label">时间：</label>
                            <div class="col-sm-8 input-group date" style="padding: 0px 15px;">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                <input type="text" class="form-control" value="2019-09-04">
                            </div>
                        </div>-->
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-3">
                                <span style="color: red;">${message}</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-3">
                                <button class="btn btn-info" type="submit">提交</button>
                                <button class="btn btn-white" type="reset">重置</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</div>
<!-- 全局js -->
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>

<!-- jQuery Validation plugin javascript-->
<script src="js/plugins/validate/jquery.validate.js"></script>
<script src="js/plugins/validate/messages_zh.js"></script>
<script src="js/plugins/validate/validate.js"></script>
<%--
<!-- Data picker -->
<script src="js/plugins/datapicker/bootstrap-datepicker.js"></script>--%>

</body>

</html>
