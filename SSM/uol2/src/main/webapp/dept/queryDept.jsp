<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询院系</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/layui-v2.5.5/layui/css/layui.css" >
    <script src="${pageContext.request.contextPath}/js/layui-v2.5.5/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body style="padding: 10px">
    <div class="layui-form">
        学校名称：
        <div class="layui-inline">
<%--            <input class="layui-input" name="schoolName" id="sn" autocomplete="off">--%>
            <div class="layui-input-inline">
                <select name="schoolId" id="schoolId" lay-filter="choseSchool">
                    <option value="">请选择</option>
                </select>
            </div>
        </div>
        院系名称：
        <div class="layui-inline">
            <div class="layui-input-inline">
                <select name="deptId" id="deptId" lay-filter="choseDept">
                    <option value="">请选择</option>
                </select>
            </div>
        </div>
        <%--执行重载表格数据reload方法--%>
        <button class="layui-btn" data-type="reload">查询</button>
    </div>
    <!--根据table id 来展示表格数据 -->
    <table class="layui-hide" id="deptTable" lay-filter="test"></table>
    <script type="text/html" id="toolbar">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm" lay-event="addData">添加</button>
            <button class="layui-btn layui-btn-sm" lay-event="editData">修改</button>
            <button class="layui-btn layui-btn-sm" lay-event="deleteData">删除</button>
        </div>
    </script>
</body>
<script>
    layui.use(['table','layer','form'],function() {
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;
        /*展示数据表格  */
        table.render({
            elem:'#deptTable'//表格id
            ,url:'${pageContext.request.contextPath}/dept/getDepts'//所对应调用的接口
            ,toolbar: '#toolbar' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: []
            ,method:'post'		//提交方式
            ,cols:[[
                /*根据数据库的表格所对应的名称  */
                {type: 'checkbox', fixed: 'left'}
                ,{align:'center', title: '编号', sort: true,type:'numbers',width:100}
                ,{field:'id',height:80, title: 'id'}
                ,{field:'deptName', height:80,width:150, title: '院系名称'}
                ,{field:'school', height:80,width:300, title: '所属学校'
                    ,templet: '<div>{{d.school.schoolName}}</div>'}
                ,{field:'remark', height:80,width:500, title: '备注'}
            ]]
            ,done:function(res,curr,count){ // 隐藏列
                $(".layui-table-box").find("[data-field='id']").css("display","none");
            }
            ,page:true// 分页
            , id: 'deptReload'
        });
        var $ = layui.$, active = {
            //点击上面的按钮查询
            reload: function(){ //重新加载表格数据
                var schoolId = $('#schoolId').val();
                var deptId = $('#deptId').val();
                //执行重载
                table.reload('deptReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        schoolId:schoolId,
                        id:deptId
                    }
                });
            }
        };
        $('.layui-form .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        //头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id); //获取选中行状态
            if(obj.event=='addData'){//添加数据
                window.location.href="${pageContext.request.contextPath}/dept/addDept.jsp";
            }else if(obj.event=='editData'){//修改数据
                var data = checkStatus.data;  //获取选中行数据
                if(data.length==1){

                }else{
                    layer.alert("请选中要修改的一条数据");
                }
            }else if(obj.event=='deleteData'){//删除数据
                var data = checkStatus.data;  //获取选中行数据
                if(data.length>=1){
                    var ids = [];
                    for(i=0;i<data.length;i++){
                        ids.push(data[i].id);
                    }
                    layer.confirm('确定删除吗？',{title:'删除'}, function(index){
                        //批量删除
                        $.post(
                            "${pageContext.request.contextPath}/dept/deleteDeptByIds",
                            {ids:ids},
                            function (result) {
                                if(result>0){
                                    layer.alert("删除成功");
                                    table.reload('deptReload', {
                                        page: {
                                            curr: 1 //重新从第 1 页开始
                                        }
                                    });
                                }else{
                                    layer.alert("删除失败");
                                }
                            }
                        );
                        layer.close(index);
                    });
                }else{
                    layer.alert("请选中要删除的数据");
                }
            }

        });
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
        //通过选中学校下拉查询院系下拉加载数据  二级联动
        form.on('select(choseSchool)', function(data){
            if(data.value!==""){
                //data.value 得到被选中的值
                var url = '${pageContext.request.contextPath}/dept/getDeptBySchoolId?schoolId=' + data.value;
                $.get(url,function(data){
                    $("#deptId").empty();
                    $("#deptId").append(new Option("请选择",""));
                    data = eval('(' + data + ')');
                    $.each(data,function(index,item){
                        $("#deptId").append(new Option(item.deptName,item.id));
                        // console.log(index,item);
                    });
                    layui.form.render("select");
                });
            }else{
                $("#deptId").empty();
                $("#deptId").append(new Option("请选择",""));
                layui.form.render("select");
            }

        });

    });

</script>
</html>
