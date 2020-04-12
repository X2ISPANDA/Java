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