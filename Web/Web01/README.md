# 软件开发体系架构

- C/S结构:客户端/服务器

  优点: 有一部分代码写在客户端,用户体验比较好

  缺点:服务器更新,客户端也要随着更新,占用资源大

- B/S结构:浏览器/服务器

  优点:客户端只要有浏览器就可以了,占用资源小,不用更新.

  缺点:用户体验不佳.

Web通信机制:基于请求响应的机制。一次请求，一次响应。

> 应用技术
>
> 客户端技术：html、css、js、jquery、bootstrap、easyui...

# Tomcat

1. 目录结构

   > bin:可执行的文件
   > conf:配置文件
   > lib:jar包
   > logs:日志文件
   > temp:临时文件
   > webapps:项目部署后的class文件
   > work:jsp页面生成的文件

2. Tomcat安装
   1. 直接解压,然后找到bin/startup.bat
   2. 可以安装
   3. 驱动之后,如果能正常看到黑窗口,表明已经安装成功.为了确保万无一失,最好在浏览器的地址栏输入:`http://localhost:8080` ,如果有看到内容就代表成功了.
   4. 如果一闪而过,则是jdk环境变量没有配置

# Servlet

> 一个运行在我们的Web服务器上,用于接收和响应客户端发来的请求，处理业务逻辑的Java程序。

- Hello Servlet编写

  1. 编写一个类

     - 继承HttpServlet
     - 重写doGet或doPost方法

  2. 编写配置文件web.xml

     - 注册Servlet
     - 绑定路径

  3. 通过ip访问

     http://主机：端口号/项目名称/路径

  > web.xml中配置文件的写法：

  ```xml
  <servlet>
      <servlet-name>别名</servlet-name>
      <servlet-class>全类名</servlet-class>
  </servlet>
  <servlet-mapping>
      <servlet-name>别名</servlet-name>
      <url-pattern>需要Servlet处理的请求地址</url-pattern>
   </servlet-mapping>
  ```

- 常见错误

  - 404路径不正常
  - 405找不到service方法
  - 500系统出错

<b>Servlet体系结构</b>

Servlet接口->GenericServlet抽象类->HttpServlet抽象类->自定义servlet

<span style="font-size:32px;font-weight:bold;color:red">Servlet的生命周期</span>

- init()

  服务器进行初始化，只执行一次，默认第一次访问的时候执行

- service()

  服务器处理业务逻辑，请求来的时候即执行，请求一次执行一次

- destroy()

  服务器进行销毁，当servlet被移除或服务器正常关闭的时候执行，只执行一次

> 默认第一次访问的时候，服务器创建servlet，并调用init实现初始化操作，并调用一次service方法，每当请求来的时候，服务器创建一个线程，调用service方法执行自己的业务逻辑，当servlet被移除的时候或服务器正常关闭的时候，服务器调用servlet的destory方法实现销毁操作。

<b>load-on-startup</b>

`作用：修改servlet的初始化时机`

1. load-on-startup 元素标记容器是否应该在启动的时候加载这个servlet，(实例化并调用其init()方法)。
2. 它的值必须是一个整数，表示servlet应该被载入的顺序
3. 如果该元素不存在或者这个数为负时，则容器会当该Servlet被请求时，再加载。
4. 当值为0或者大于0时，表示容器在应用启动时就加载并初始化这个servlet；
5. 正数的值越小，该servlet的优先级越高，应用启动时就越先加载。
6. 当值相同时，容器就会自己选择顺序来加载

<b>url-pattern的配置</b>

- 完全匹配

   必须以"/"开始 例如: /hello /a/b/c

- 目录匹配

  必须"/"开始  以"*"结束   例如: /a/*  /*

- 后缀名匹配

  以"*"开始 以字符结尾 例如: *.jsp  *.do *.action

> 优先级：完全匹配>目录匹配>后缀名匹配

## ServletConfig对象

<b>作用：</b>

1. 获取当前servlet的名称
2. 获取当前servlet的初始化参数
3. 获取全局管理者

- String getServletName()：获取当前servlet的名称(web.xml配置的servlet-name)
- String  getInitParameter(String key):通过名称获取指定的参数值
- Enumeration getInitParameterNames() :获取所有的参数名称
- getServletContext():获取全局管理者

> 初始化参数是指放在web.xml文件servlet标签下的子标签init-param

ServletConfig对象是由服务器创建的,在创建servlet的同时也创建了它,通过servlet的init(ServletConfig config)将config对象传递给servlet,由servlet的getServletConfig方法获取

## ServletContext上下文（全局管理者）

> ServletContext是一个项目的引用.代表了当前项目，表述该项目的上下文信息。
> ServletContext对象的作用是在整个Web应用的动态资源之间共享数据。我们可以在N多个Servlet中来获取这个唯一的对象，使用它可以给多个Servlet传递数据。例如在AServlet中向ServletContext对象中保存一个值，然后在BServlet中就可以获取这个值，这就是共享数据了。

<b>服务器会为每个应用创建一个ServletContext对象：当项目启动的时候,服务器为每一个web项目创建一个ServletContext对象，当项目被移除的时候或者服务器关闭的时候，ServletContext销毁。</b>

<b>作用：</b>

1. 获取全局的初始化参数
2. 共享资源(xxxAttribute)
3. 获取文件资源
4. 其他操作

<span style="font-size:25px;font-weight:bold;color:red">获取ServletContext</span>

1. getServletConfig().getServletContext()
2. getServletContext()

#### 常用方法：

- String  getInitParameter(String key):通过名称获取指定的参数值

- Enumeration getInitParameterNames() :获取所有的参数名称

  `在根标签下有一个 context-param子标签 用来存放初始化参数`

  ```xml
  <context-param>
  	<param-name>encoding</param-name>
  	<param-value>utf-8</param-value>
  </context-param>
  ```

- void setAttribute(String name, Object value)：用来存储一个对象，也可以称之为存储一个域属性。如果多次调用该方法，并且使用相同的name，那么会覆盖上一次的值，这一特性与Map相同。在一个Servlet中设置数据后，其他Servlet都可以获取该数据。

- Object getAttribute(String name)：用来获取ServletContext中的数据，当前在获取之前需要先去存储才行。

- void removeAttribute(String name)：用来移除ServletContext中的域属性，如果参数name指定的域属性不存在，那么本方法什么都不做。

- Enumeration getAttributeNames()：获取所有域属性的名称，获取到的对象是一个枚举集合，该集合能够进行遍历。

- String getRealPath(String path):获取文件部署到tomcat上的真实路径(带tomcat路径)

- String getMimeType(String 文件名称)：获取文件的MIME类型。

  MIME是邮件和HTTP协议中用来标注网络数据的。常见形式是一个主类型加一个子类型，用斜线分隔。比如text/html、application/javascript、image/png等。

  在访问网页时，MIME type帮助浏览器识别一个HTTP请求返回的是什么内容的数据，应该如何打开、如何显示

## 路径的写法

- 相对路径

  当前路径    ./ 或者 什么都不写，上一级路径 ../

- 绝对路径

  带主机和协议的绝对路径(访问站外资源)：http://域名/xxxx，http://localhost:80/day01/hello

  不带主机和协议的绝对路径：/day01/hello

- 内部路径

  不带协议和主机的绝对路径去掉项目名