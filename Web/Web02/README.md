# Http协议

<b>什么是协议
</b>

> 双方在交互通讯的时候,遵守的一种规范、规则。
- Http协议
> 针对网络上的客户端 与 服务器端在执行http请求的时候，遵守的一种规范。 其实就是规定了客户端在访问服务器端的时候，要带上哪些东西， 服务器端返回数据的时候，也要带上什么东西。 

- 版本

  - 1.0

    > 请求数据，服务器返回后， 将会断开连接

  - 1.1

    > 请求数据，服务器返回后， 连接还会保持着。 除非服务器 | 客户端 关掉。 有一定的时间限制，如果都空着这个连接，那么后面会自己断掉。

### Http数据包

> 请求的数据里面包含三个部分内容:请求行、请求头、请求体

- 请求行

  POST /examples/servlets/servlet/RequestParamExample HTTP/1.1 

  > POST ： 请求方式 ，以post去提交数据
  > /examples/servlets/servlet/RequestParamExample
  > 请求的地址路径 ， 就是要访问哪个地方。
  >
  > HTTP/1.1 协议版本

- 请求头

  Accept: application/x-ms-application, image/jpeg, application/xaml+xml, image/gif, image/pjpeg, application/x-ms-xbap, */*
  	Referer: http://localhost:8080/examples/servlets/servlet/RequestParamExample
  	Accept-Language: zh-CN
  	User-Agent: Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E)
  	Content-Type: application/x-www-form-urlencoded
  	Accept-Encoding: gzip, deflate
  	Host: localhost:8080
  	Content-Length: 31
  	Connection: Keep-Alive
  	Cache-Control: no-cache

  > Accept: 客户端向服务器端表示，我能支持什么类型的数据。 
  > Referer ： 真正请求的地址路径，全路径
  > Accept-Language: 支持语言格式
  > User-Agent: 用户代理 向服务器表明，当前来访的客户端信息。 
  > Content-Type： 提交的数据类型。经过urlencoding编码的form表单的数据
  > Accept-Encoding： gzip, deflate ： 压缩算法 。 
  > Host ： 主机地址
  > Content-Length： 数据长度
  > Connection : Keep-Alive 保持连接
  > Cache-Control ： 对缓存的操作

- 请求体

  > 浏览器真正发送给服务器的数据
  >
  > 发送的数据呈现的是key=value ,如果存在多个数据，那么使用 &
  >
  > `firstname=zhang&lastname=sansan`

### Http相应数据

> 请求的数据里面包含三个部分内容 ： 响应行 、 响应头 、响应体

- 响应行

  > 协议版本  
  >
  > 状态码 
  >
  > 	咱们这次交互到底是什么样结果的一个code. 
  > 	
  > 	200 : 成功，正常处理，得到数据。
  > 	
  > 	403  : for bidden  拒绝
  > 	404 ： Not Found
  > 	500 ： 服务器异常
  >
  > OK
  >
  > 	对应前面的状态码  

- 响应头

  > Server:  服务器是哪一种类型。  Tomcat
  >
  > Content-Type ： 服务器返回给客户端你的内容类型
  >
  > Content-Length ： 返回的数据长度
  >
  > Date ： 通讯的日期，响应的时间

# Get/Post请求

<span style="font-size:40px;color:red">区别:</span>

- GET产生一个TCP数据包；POST产生两个TCP数据包。并不是所有浏览器都会在POST中发送两次包，Firefox就只发送一次。

- duiGET在浏览器回退时是无害的，而POST会再次提交请求。

   

- GET产生的URL地址可以被Bookmark，而POST不可以。

   

- GET请求会被浏览器主动cache，而POST不会，除非手动设置。

   

- GET请求只能进行url编码，而POST支持多种编码方式。

   

- GET请求参数会被完整保留在浏览器历史记录里，而POST中的参数不会被保留。

   

- GET请求在URL中传送的参数是有长度限制的，而POST没有。

   

- 对参数的数据类型，GET只接受ASCII字符，而POST没有限制。

   

- GET比POST更不安全，因为参数直接暴露在URL上，所以不能用来传递敏感信息。

   

- GET参数通过URL传递，POST放在Request body中。

[GET和POST请求的区别](https://www.cnblogs.com/logsharing/p/8448446.html)

# Request

`作用:获取浏览器发过来的数据`

![image-20191219154425060](C:\Users\XMY\AppData\Roaming\Typora\typora-user-images\image-20191219154425060.png)

- String getMethod():获取请求方式
- String getRemoteAddr():获取ip地址
- String getContextPath() :在java中获取项目名称
- String getRequestURI():获取的是 从项目名到参数之前的内容
- String getServletPath()：返回Servlet路径
- StringBuffer getRequestURL():获取的带协议的完整路径
- String getQueryString():get请求的所有参数  
- String getProtocol():获取协议和版本
- Strig getParameter(String key):获取一个值
- String[] getParameterValues(String key):通过一个key获取多个值
- String getHeader(String key):通过请求头key获取指定的value(一个)
- Enumeration getHeaders(String name) :通过key获取指定的value(多个)
- Enumeration getHeaderNames() :获取所有的请求头的名称

## 中文乱码

> 对于get请求:参数追加到地址栏,会使用utf-8编码,服务器(tomcat7)接受到请求之后,使用iso-8859-1解码,所以会出现乱码。
>
> 对于post请求,参数是放在请求体中,服务器获取请求体的时候使用iso-8859-1解码,也会出现乱码。

解决方案：

- 通用方案

  new String(参数.getBytes("iso-8859-1"),"utf-8");

- 针对于post请求来说:只需要将请求流的编码设置成utf-8即可

  request.setCharacterEncoding("utf-8");

- 修改server.xml

  `<Connector URIEncoding="utf-8" connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443"/>`



# Response

`作用：往浏览器写东西`

- setHeader():设置响应头信息

  response.setHeader(“content-type”, “text/html;charset=utf-8”)：设置content-type响应头，该头的作用是告诉浏览器响应内容为html类型，编码为utf-8。而且同时会设置response的字符流编码为utf-8，即response.setCharaceterEncoding(“utf-8”)；
  response.setHeader(“Refresh”,”5; URL=http://www.ychs168.com“ )：5秒后自动跳转到英才科技主页。

- response.setContentType(“text/html;charset=utf-8”)：等同与调用response.setHeader(“content-type”, “text/html;charset=utf-8”)；

- response.setCharacterEncoding(“utf-8”)：设置字符响应流的字符编码为utf-8；

- response.setStatus(200)：设置状态码；

- response.sendError(404, “您要查找的资源不存在”)：当发送错误状态码时，Tomcat会跳转到固定的错误页面去，但可以显示错误信息。



## 重定向

`重定向是客户端通过一个路径访问服务器，服务器通知浏览器去访问另一个地址，浏览器再发出另一个地址的请求。`

第一步：设置响应码为302

第二步：设置新请求的URL

```java
		//设置响应码为302，表示重定向
        response.setStatus(302);
        //设置新请求的URL
        response.setHeader("Location", "http://www.ychs168.com");
```

便捷实现：

```
response.sendRedirect("http://www.ychs168.com");
```

> response.sendRedirect()方法会设置响应头为302，以设置Location响应头。

总结：

- 重定向是两次请求
- 重定向的URL可以是其他服务器的应用，不局限于当前服务器。
- 重定向的响应头为302，并且必须要有Location响应头。
- 重定向就不要再使用response.getWriter()或response.getOutputStream()输出数据，不然可能会出现异常。

<span style="font-size:32px;font-weight:bold;color:red">转发和重定向的区别:</span>

1. 转发的地址栏是不变的，重定向的地址栏发生变化的。
2. 转发是一次请求一次响应，重定向是两次请求两次响应。
3. 转发的路径不需要加工程名，重定向的路径需要加工程名。
4. request域对象存取的值在转发中是有效的，在重定向中是无效的。

# HTTP协议（HyperText Transfer Protocol，超文本传输协议）

<b>什么是协议 ？</b>

> 双方在交互通讯的时候,遵守的一种规范、规则。

<b>Http协议</b>

> 针对网络上的客户端 与 服务器端在执行http请求的时候，遵守的一种规范。 其实就是规定了客户端在访问服务器端的时候，要带上哪些东西， 服务器端返回数据的时候，也要带上什么东西。 

<b>传输过程</b>

1. 浏览器建立和服务器的链接
2. 浏览器将请求数据打包发送请求
3. 服务器将处理结果打包发送
4. n次请求响应之后关闭连接



<b>Http相应数据</b>

`请求的数据包里面包含三个部分内容 ：请求行、请求头、请求体`

- 请求行
- 请求头
- 请求体

![image-20191219195024338](C:\Users\XMY\AppData\Roaming\Typora\typora-user-images\image-20191219195024338.png)

`响应的数据包里面同样包含三个部分内容 ：响应行、响应头、响应体`

- 响应行

  - 协议版本

  - 状态码

    `咱们这次交互到底是什么样的结果`

    - 200 ：请求成功，浏览器会把响应体内容（通常是html）显示在浏览器中；
    - 403 ：for bidden  拒绝访问
    - 404 ：请求的资源没有找到，说明客户端错误的请求了不存在的资源；
    - 302：重定向，当响应码为302时，表示服务器要求浏览器重新再发一个请求，服务器会发送一个响应头Location，它指定了新请求的URL地址；
    - 500：请求资源找到了，但服务器内部出现了错误；
    - 304：缓存响应，第一次响应成功之后，会缓存响应页面。

- 响应头

  - Server:  服务器是哪一种类型。  Tomcat
  - Content-Type ： 服务器返回给客户端你的内容类型
  - Content-Length ： 返回的数据长度
  - Date ： 通讯的日期，响应的时间

- 响应体

![image-20191219195034532](C:\Users\XMY\AppData\Roaming\Typora\typora-user-images\image-20191219195034532.png)