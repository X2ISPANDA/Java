<%--
  ~ Copyright (c) 2019.
  ~ All Rights Reserved,Designed By Mingyu Xiong
  --%>

<%--
  Created by IntelliJ IDEA.
  User: XMY
  Date: 2019/12/21
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>js异步</title>
    <script>
        //创建异步交互的对象
        function createXMLHTTPRequest() {
            let xmlHttp;
            try {
                xmlHttp = new XMLHttpRequest();
            } catch (e) {
                try {
                    //IE6
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e) {
                    //IE5.5
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
            }
            return xmlHttp;
        }

        function checkName() {
            //1.获取异步交互的对象
            let xmlhttpRequest = createXMLHTTPRequest();
            //2.打开和服务器的连接
            var name = document.getElementById("name").value;
            let url = "${pageContext.request.contextPath}/checkName?name="+name;
            xmlhttpRequest.open("GET",url);
            //3、发送请求
            xmlhttpRequest.send();
            //4、接收服务器的响应
            xmlhttpRequest.onreadystatechange = function () {
                    // alert(xmlhttpRequest.readyState);
                    // alert(xmlhttpRequest.status);
                    // alert(xmlhttpRequest.responseText);
                if (xmlhttpRequest.readyState == 4 && xmlhttpRequest.status == 200) {
                    if (xmlhttpRequest.responseText == "y") {
                        alert("用户名重复");
                        document.getElementById("msg").innerHTML = "用户名重复";
                    } else {
                        document.getElementById("msg").innerHTML = "";
                    }
                }
            };
        }

        function checkNamePost() {
            let xmlhttpRequest = createXMLHTTPRequest();
            let url = "${pageContext.request.contextPath}/checkName";
            xmlhttpRequest.open("POST", url);
            xmlhttpRequest.setRequestHeader("Contenr-Type", "application/x-www-form-urlencoded");
            xmlhttpRequest.send("name" + document.getElementById("name").value);
            xmlhttpRequest.onreadystatechange = function () {
                // alert(xmlhttpRequest.readyState);
                // alert(xmlhttpRequest.status);
                // alert(xmlhttpRequest.responseText);
                if (xmlhttpRequest.readyState == 4 && xmlhttpRequest.status == 200) {
                    if (xmlhttpRequest.responseText == "y") {
                        alert("用户名重复");
                        document.getElementById("msg").innerHTML = "用户名重复";
                    } else {
                        document.getElementById("msg").innerHTML = "";
                    }
                }
        }

    </script>
</head>
<body>
    用户名:<input tyep="text" name="name" id="name" onblur="checkName();">
    <span id="msg"></span>
</body>
</html>
