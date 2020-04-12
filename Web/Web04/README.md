# JSP(Java Server Page)

> 	本质上jsp就是一个servlet,在页面嵌套java代码,运行在服务器端,能处理请求,生成动态的内容.
> 	对应的java和class文件在tomcat目录下的work目录
> 	后缀名 *.jsp

**作用：将内容的生成和信息的展示相分离,servlet写内容的生成，jsp展示信息到页面**

## JSP基础语法

1. JSP头文件

   > <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

2. JSP脚本

   - <%!..%>:定义成员变量
   - <%=...%>:向页面输出内容(固定值,变量)
   - <%...%>:书写java代码片段

3. 注释

   - html注释 <!--  -->

     > 注释的内容只在页面上看不到  java代码和html源代码都有

   - java注释 

     > 只在java源代码中存在

   - jsp注释 <%--  --%>

     > 只在jsp页面中存在,翻译成java文件之后就没有了

4. 转发和重定向

   > JSP本质上就是一个Servlet，Servlet之间能够进行转发与重定向，那么，Servlet也同样能够转发、重定向到JSP页面上去。

> # JSP中out.write()和out.print()的区别
>
>  1）print方法是子类JspWriter，write是Writer类中定义的方法；
>
> 2）重载的print方法可将各种类型的数据转换成字符串的形式输出，而重载的write方法只能输出字符、字符数组和字符串等与字符相关的数据；
>
> 3）JspWriter类型的out对象使用print方法和write方法都可以输出字符串，但是，如果字符串对象的值为null时，print方法将输出内容为“null”的字符串，而write方法则是抛出NullPointerException异常。例如： 

## JSP实现原理

> JSP的本质就是Servlet，它只是一种特殊的Servlet。
> 执行流程:
> 		1.浏览器发送请求,访问jsp页面
> 		2.服务器接受请求,JspSerlvet会帮我们查找对应的jsp文件
> 		3.服务器将jsp页面翻译成java文件.
> 		4.jvm会将java编译成.class文件
> 		5.服务器运行class文件,生成动态的内容.
> 		6.服务器组成响应信息,发送给浏览器
> 		7.浏览器接受数据,解析展示

## JSP的指令

- ▲contentType:设置响应流的编码,及浏览器用什么编码打开，设置文件的mimeType类型
- ▲pageEncoding:设置页面编码格式
- ▲import:在jsp中导入包
- language:jsp支持的语言类型
- extends:jsp编译成servlet继承的类,默认继承的是HttpJspBase
- session:在jsp中是否可以直接使用session对象,默认值是true
- buffer:设置jsp页面流的缓冲区大小,默认值是8kb
- autoFlush:如果内容超出缓冲区是否会正确输出,默认值是true
- errorPage:如果jsp页面出现异常,设置跳转到错误页面
- isErrorPage:当前jsp页面是否是一个错误页面
- web.xml中配置错误页面
- isELIgnored：是否忽略el表达式，默认不忽略false
- include静态包含:<%@include  file="要包含的页面路径"%>
- taglib: <%@taglib prefix="前缀名" uri="名称空间" %>

## JSP九大内置对象

在JSP中无需创建就能使用的Java对象就是JSP内置对象，共包含九个内置对象。

### 域对象

- application:即ServletContext类的对象,整个项目

- session:HttpSession类的对象,一次会话

- request:即HttpServletRequest类的对象,一次请求

- pageContext:页面上下文对象,一个页面

  **主要功能：**

  - 域对象功能
  - 获取其他内置对象
  - 代理其它域对象功能

  一个pageContext对象等于所有内置对象，即1个当9个。这是因为可以使用pageContext对象可以获取其它8个内置对象。

### 普通对象

- page:this,当前对象
- out:等同与response.getWriter()，用来向客户端发送文本数据。
- response:即HttpServletResponse类的对象
- config:对应“真身”中的ServletConfig
- exception:只有在错误页面（设置isErrorPage属性）中可以使用这个对象

## JSP的动作标签

- &lt;jsp:forward>:请求转发

- &lt;jsp:include>:动态包含   