<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加院系</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/layui-v2.5.5/layui/css/layui.css" >
    <script src="${pageContext.request.contextPath}/js/layui-v2.5.5/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body style="padding: 10px;padding-top: 30px">
<form class="layui-form" action="${pageContext.request.contextPath}/dept/addDept">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">部门名称</label>
            <div class="layui-input-inline">
                <input type="text" name="deptName" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">所属学校</label>
            <div class="layui-input-inline">
                <select name="schoolId" id="schoolId" lay-verify="required" lay-search="">
                </select>
            </div>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" name="remark" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">添加</button>
        </div>
    </div>
</form>
</body>
<script>
    layui.use(['layer','form'],function() {
        var layer = layui.layer;
        var form = layui.form;
        //访问页面加载学校下拉列表
        $.ajax({
            url:"${pageContext.request.contextPath}/school/getSchoolList",
            type:"post",
            success:function (result) {
                var r = eval('(' + result + ')');
                $.each(r, function(index, item) {
                    $("#schoolId").append("<option value="+item.id+">"+item.schoolName+"</option>");// 下拉菜单里添加元素
                });
                form.render("select");
            }
        });

        //监听提交
        /*form.on('submit(demo1)', function(data){
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            });
            return false;
        });*/

    });
</script>
</html>
