<%--
  Created by IntelliJ IDEA.
  User: XMY
  Date: 2020/2/27
  Time: 1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC的参数绑定功能测试</title>
</head>
<body>
    <h1>Spring MVC的参数绑定功能测试</h1>
    <%
        session.setAttribute("sessionName", "sessionValue");
    %>
    <%--此处为请求转发,没有更换路径,没有到success.jsp中去--%>
    <a href="/SSM-SpringMVC-Day04/test01/requestTest.do?username=zhangsan&password=123">请求requestTest.do,get类型的请求</a>
    <br/>
    <a href="/SSM-SpringMVC-Day04/test01/responseTest.do">请求responseTest.do</a>
    <br/>
    <a href="/SSM-SpringMVC-Day04/test01/sessionTest.do">请求sessionTest.do</a>

    <br/>
    <h1>form表单的请求</h1>
    <%--<form action="/SSM-SpringMVC-Day04/test01/formTest.do" method="post">--%>
    <form action="/SSM-SpringMVC-Day04/test01/modelTest.do" method="post">
        用户名:<input type="text" name="username" /><br/><br/>
        密  码:<input type="password" name="password" /><br/><br/>
        姓  名:<input type="text" name="name" /><br/><br/>
        年  龄:<input type="text" name="age" /><br/><br/>
        性  别:<input type="radio" name="sex" value="true"/>男
              <input type="radio" name="sex" value="false"/>女
        <br/><br/>
        爱  好:<input type="checkbox" name="hobby" value="reading"/>读书
              <input type="checkbox" name="hobby" value="drinking"/>喝茶
              <input type="checkbox" name="hobby" value="newspaper"/>看报
        <br/><br/>
        <input type="submit" value="提交" /><br/><br/>
    </form>

    <h1>测试Spring MVC对Map数据类型的绑定支持</h1>
    <form action="/SSM-SpringMVC-Day04/test01/mapTest.do" method="post">
        用户名:<input type="text" name="map['username']" /><br/><br/>
        密  码:<input type="password" name="map['password']" /><br/><br/>
        姓  名:<input type="text" name="map['name']" /><br/><br/>
        年  龄:<input type="text" name="map['age']" /><br/><br/>
        <br/><br/>
        <input type="submit" value="提交" /><br/><br/>
    </form>

    <a href="/SSM-SpringMVC-Day04/test01/paramTest.do?name=zhangsan">测试RequestParam注解的使用</a>
    <a href="/SSM-SpringMVC-Day04/test01/modelMapTest.do?username=zhangsan&password=123">测试model的参数绑定的使用</a>

    <form action="/SSM-SpringMVC-Day04/test01/dateTest.do" method="post">
        请输入时间：<input type="text" name="date"><br/><br/>
        请输入姓名：<input type="text" name="name"><br/><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
