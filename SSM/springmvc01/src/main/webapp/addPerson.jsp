<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="js/layui-v2.5.5/layui/css/layui.css"  media="all">
    <script src="js/layui-v2.5.5/layui/layui.js" charset="utf-8"></script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/addPerson" method="post">
        姓名：<input type="text" name="name" value="${p.name}"><br/>
        年龄：<input type="text" name="age" value="${p.age}"><br/>
        日期： <input type="text" name="curDate" value="${p.curDate}" class="layui-input" id="curDate" placeholder="yyyy-MM-dd HH:mm:ss"><br/>
        爱好：<input type="checkbox" name="hobby" value="eat">吃
              <input type="checkbox" name="hobby" value="drink">喝
              <input type="checkbox" name="hobby" value="play">玩
              <input type="checkbox" name="hobby" value="happy">乐<br/>
        <input type="submit" value="添加">
    </form>
    <script>
        layui.use('laydate', function(){
            var laydate = layui.laydate;
            //日期时间选择器
            laydate.render({
                elem: '#curDate'
                ,type: 'datetime'
            });
        });
    </script>
</body>
</html>
