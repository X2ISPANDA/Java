<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script>
        function fun1() {
            var name=$("#name").val();
            alert(name);
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/fastJsonDemo/fun1',
                data:'name='+name+"&age=12",
                contentType:'application/x-www-form-urlencoded',
                dataType:'json',
                success:function(data) {
                    /*var data = eval("("+data+")");*/
                    alert("data:"+data.name);
                    alert(data.age);
                }
            });
        }
        function fun2() {
            var name=$("#name").val();
            var s = JSON.stringify({"name":name,"age":20});
            alert(name);
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/fastJsonDemo/fun2",
                contentType:"application/json;charset=UTF-8",
                data:s,
                dataType:"json",
                success:function(data){
                    alert(data.name);
                    alert(data.age);
                }
            });
        }
    </script>
</head>
<body>
    名称：<input type="text" id="name"><br/>
    <input type="button" value="提交key/value" onclick="fun1()"><br/>
    <input type="button" value="提交json串" onclick="fun2()"><br/>
</body>
</html>
