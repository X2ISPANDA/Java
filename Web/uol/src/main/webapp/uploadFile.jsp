<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+
            request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>"/>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet"></head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>上传文件</h5>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal m-t" id="commentForm" action="${pageContext.request.contextPath}/file" method="post" enctype="multipart/form-data">
                        <div class="form-group" >
                            <label class="col-sm-3 control-label">文件名称：</label>
                            <div class="col-sm-8">
                                名称：<input type="text" name="name" id="name" value="${name}" class="form-control"><br/>
                                文件：<input type="file" name="file1" required/><br/>
                                <input type="submit" value="提交"/>
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

</body>

</html>



