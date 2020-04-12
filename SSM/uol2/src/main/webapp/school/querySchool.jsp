<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询学校</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/layui-v2.5.5/layui/css/layui.css" >
    <script src="${pageContext.request.contextPath}/js/layui-v2.5.5/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

</head>
<body style="padding: 10px">
    <div class="layui-form">
        学校名称：
        <div class="layui-inline">
            <input class="layui-input" name="schoolName" id="sn" autocomplete="off">
        </div>
        <button class="layui-btn" data-type="reload">查询</button>
        <button class="layui-btn" data-type="add">添加</button>
    </div>
    <!--根据table id 来展示表格数据 -->
    <table class="layui-hide" id="schoolTable" lay-filter="test"></table>

    <!--行内样式按钮 -->
    <script type="text/html" id="lineBtns">
        <a class="layui-btn layui-btn-xs" lay-event="edit"><i class="layui-icon">&#xe642;</i>编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>

    <!--添加弹出层 -->
    <div class="site-text" style="margin: 5%; display: none" id="box1" target="test123">
        <form class="layui-form layui-form-pane" onsubmit="return false" id="addSchool">
            <div class="layui-form-item">
                <label class="layui-form-label">学校名称</label>
                <div class="layui-input-block">
                    <input type="text" class="layui-input" id="schoolName" name="schoolName" lay-verify="schoolName">
                </div> <br>
                <label class="layui-form-label">学校的地址</label>
                <div class="layui-input-block">
                    <input type="text" class="layui-input" id="address" name="address" lay-verify="required"><br>
                </div>
            </div>
        </form>
    </div>

</body>

<script>
    layui.use(['table','layer','form'],function(){
        var table =layui.table;
        var layer=layui.layer;
        var form = layui.form;

        /*展示数据表格  */
        table.render({
            elem:'#schoolTable'//表格id
            ,url:'${pageContext.request.contextPath}/school/getSchools'//所对应调用的接口
            ,method:'post'		//提交方式
            ,cols:[[
                /*根据数据库的表格所对应的名称  */
                // {type: 'checkbox', fixed: 'left'}
                {align:'center', title: '编号', sort: true,type:'numbers',width:100}
                ,{field:'id',height:80, title: 'id'}
                ,{field:'schoolName', height:80,width:300, title: '学校名称'}
                ,{field:'address', height:80,width:500, title: '学校地址'}
                // ,{field:'createtime',height:80, width:300, title: '当前时间',templet:"&lt;div&gt;{{layui.util.toDateString(d.createtime, 'yyyy-MM-dd HH:mm:ss')}}&lt;/div&gt;"}
                ,{field:'right',height:80, title: '操作', toolbar:'#lineBtns'}//操作栏
            ]]
            ,done:function(res,curr,count){ // 隐藏列
                $(".layui-table-box").find("[data-field='id']").css("display","none");
            }
            ,page:true// 分页
            , id: 'schoolReload'
        });

        //上方菜单操作栏(查询、以及  增加  按钮  )
        var $ = layui.$, active = {
            //查询
            reload: function () {
                var schoolName = $('#sn');//书籍类别名称 根据 id来取值
                console.log(schoolName.val());
                // 执行重载
                table.reload('schoolReload', {
                    page: {
                        curr: 1
                        // 重新从第 1 页开始
                    },
                    where: {
                        key: 'schoolName',
                        schoolName: schoolName.val(),
                    }
                });
            }, add: function () { //添加
                layer.open({//弹出框
                    type: 1,
                    title: '添加学校',
                    maxmin: false,
                    shadeClose: true, //点击遮罩关闭层
                    area: ['60%', '60%'],
                    content: $('#box1'),
                    btn: ['确定', '取消'],
                    success: function (layero, index) {
                        layero.addClass('layui-form');//添加form标识
                        layero.find('.layui-layer-btn0').attr('lay-filter', 'fromContent').attr('lay-submit', '');//将按钮弄成能提交的
                        form.render();
                    },
                    yes: function (index, layero) {//确定执行函数
                        console.log(layero);
                        form.verify({
                            schoolName: function (value) { //项目名称
                                if (!value) {
                                    return '学校名称不能为空';
                                }
                                if (value.length < 10) {
                                    return '学校名称大于10个字';
                                }
                            }
                        });
                        form.on('submit(fromContent)', function (data) {
                            //执行添加方法
                            $.getJSON(
                                "${pageContext.request.contextPath}/school/addSchool",
                                {
                                    schoolName: $("#schoolName").val(), ///角色名
                                    address:$("#address").val()
                                    /* booktypename: $("input[ name='booktypename1']").val(), *///角色名
                                },
                                function (data) {
                                    /*根据后台返回的参数来进行判断  */
                                    if (data==1) {
                                        layer.alert('添加成功', {icon: 1, title: '提示'}, function (i) {
                                            layer.close(i);
                                            layer.close(index);//关闭弹出层
                                            $("#addSchool")[0].reset()//重置form
                                        });
                                        table.reload('schoolReload', {//重载表格
                                            page: {
                                                curr: 1
                                                // 重新从第 1 页开始
                                            }
                                        });
                                    } else {
                                        layer.msg('添加失败')
                                    }
                                });
                        });
                        }, cancel: function (index, layero) {//取消
                            $("#addSchool")[0].reset()//重置form  根据id
                            layer.close(index)
                        }
                });
            }
        }
        $('.layui-form .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });



        /*表格 行内操作(编辑  以及  删除 按钮操作)  */
        table.on('tool(test)', function(obj){
            var data = obj.data; //获得当前行数据
            var tr=obj.tr//活动当前行tr 的  DOM对象
            console.log(data);
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            if(layEvent === 'del'){ //删除
                layer.confirm('确定删除吗？',{title:'删除'}, function(index){
                    //向服务端发送删除指令og
                    $.getJSON(
                        '${pageContext.request.contextPath}/school/delSchool',
                        {id:data.id},
                        function(data){
                            if(data==1){
                                layer.close(index);//关闭弹窗
                                table.reload('schoolReload', {//重载表格
                                    page: {
                                        curr: 1
                                        // 重新从第 1 页开始
                                    }
                                })
                            }else {
                                layer.msg('添加失败')
                            }

                    });
                    layer.close(index);
                });
            } else if(layEvent === 'edit'){ //编辑
                layer.open({
                    type: 1 //Page层类型
                    // ,skin: 'layui-layer-molv'
                    ,area: ['60%', '60%']
                    ,title: ['修改学校信息','font-size:18px']
                    ,btn: ['确定', '取消']
                    ,shadeClose: true
                    ,shade: 0 //遮罩透明度
                    // ,maxmin: true //允许全屏最小化
                    ,content:$('#box1')  //弹窗id
                    ,success:function(layero,index){
                        $('#schoolName').val(data.schoolName);
                        $('#address').val(data.address);
                        $('#id').val(data.id);
                    },yes:function(index,layero){
                          // $.ajaxSettings.async = false;
                        $.getJSON(
                            '${pageContext.request.contextPath}/school/editSchool',
                            {id: data.id,
                             schoolName: $('#schoolName').val(),
                             address: $('#address').val()},
                            function(data){
                            //根据后台返回的参数，来进行判断
                                if(data>0){
                                    layer.alert('编辑成功',{icon:1,title:'提示'},function(i){
                                        layer.close(i);
                                        layer.close(index);//关闭弹出层
                                        $("#addSchool")[0].reset()//重置form
                                    })
                                    table.reload('schoolReload',{//重载表格
                                        page:{
                                            curr:1
                                        }
                                    })
                                }
                            });
                    }


                });
            }

        });

    });
</script>
</html>
