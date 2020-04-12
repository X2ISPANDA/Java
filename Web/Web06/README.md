# Cookie和Session

***会话跟踪技术概述***

> 什么是会话？
> 				可以把会话理解为客户端与服务器之间的一次会晤，在一次会晤中可能包含多次请求和响应，例如你给10086打电话，你就是客服端，而10086服务人员就是服务器了。从双方接通电话那一刻起，会话就开始了，到某一方挂断电话表示会话结束。在通话过程中，你会向10086发出多个请求，那么这多个请求都在你一个会话中。
> 在JavaWeb中，客户向某一服务器发出第一个请求开始，会话就开始了，直到客户关闭了浏览器会话结束。
> 在一个会话的多个请求中共享数据，这就是会话跟踪技术，例如在一个会话中的请求如下：
> 请求银行主页
> 请求登录（请求参数是用户名和密码）
> 请求转账（请求参数与转出相关的数据）
> 请求信用卡还款（请求参数与还款相关的数据）
> 在这上会话中当前用户信息必须在这个会话中共享的，因为登录的是张三，那么在转账和还款时一定是相对张三的转账和还款！这就说明我们必须在一个会话过程中有共享数据的能力。
>
> Cookie与Session
> 				我们知道HTTP协议是无状态协议，也就是说每个请求都是独立的！无法记录前一次请求的状态。但HTTP协议中可以使用Cookie来完成会话跟踪！
> 				在JavaWeb中，使用session来完成会话跟踪，session底层依赖Cookie技术。

## Cookie

> Cookie是1993年由网景公司（Netscape）前雇员发明的一种进行网络会话状态跟踪的技术。	
>
> ​	Cookie翻译成中文是小甜点，小饼干的意思。在HTTP中它表示服务器发送给客户端浏览器的小甜点。Cookie本质上就是一个Map结构的键值对，随着服务器端的响应发送给客户端浏览器。然后客户端浏览器会把Cookie保存起来，当下一次再访问服务器时把Cookie再发送给服务器。
> ​	Cookie是由服务器创建，然后通过响应发送给客户端的一个键值对。客户端会保存Cookie，并会标注出Cookie的来源（哪个服务器的Cookie）。当客户端向服务器发出请求时会把所有这个服务器Cookie包含在请求中发送给服务器，这样服务器就可以识别客户端了。

*Cookie的规范*

> 1、Cookie大小上限为4KB。
> 2、一个服务器最多在客户端浏览器上保存20个Cookie。
> 3、一个浏览器最多保存300个Cookie。
> 在浏览器大战的今天，一些浏览器为了打败对手，为了展现自己更加强大的能力，可能会对Cookie规范进行一些扩展，例如每个Cookie的大小为8KB，最多可保存500个Cookie等！但即便这样也不会出现把你硬盘占满！
> 注意：不同浏览器之间是不共享Cookie的。也就是说在你使用IE访问服务器时，服务器会把Cookie发给IE，然后由IE保存起来，当你在使用FireFox访问服务器时，不可能把IE保存的Cookie发送给服务器。
>
>
> 注意：cookie不能跨浏览器

**Cookie是通过Http请求和响应头在客户端和服务器端传递的**

### Cookie的覆盖

如果服务器端发送重复的Cookie那么会覆盖原有的Cookie，例如客户端的第一个请求服务器端发送的Cookie是：Set-Cookie: a=A；第二请求服务器端发送的是：Set-Cookie: a=AA，那么客户端只留下一个Cookie，即：a=AA。

### Cookie的方法

- 新建cookie

  ```
  Cookie cookie = new Cookie("name", "wrx");
  ```

- 写回浏览器

  ```
  response.addCookie(cookie);
  ```

- 获取Cookie

  ```
  Cookie[] cookies = request.getCookies();
  ```

- 获取Cookie的key（即name）和值(value)

  ```
  if(cookies!=null&&cookies.length>0){
      for(Cookie c:cookies){
          PrintWriter writer = response.getWriter();
          writer.write("cookie是："+c.getName()+","+c.getValue()+",");
      }
  }
  ```


### Cookie的生命时长

> Cookie对象不只是有name和value，Cookie还是生命时长属性。
> 所谓生命时长就是指Cookie在客户端的有效时间，可以通过setMaxAge(int)来设置Cookie的有效时间。
>
> ```
> 设置cookie的有效期，这个值为一个整形值，单位为秒
> 值>0,表示将cookie存放到客户端的硬盘
> 值<0，与不设置效果相同，会将Cookie放到浏览器缓存
> 值=0,表示cookie一生成即马上失效
> ```
>
> 前提必须路径一致
>

### Cookie的path路径

cookie默认绑定为同一资源路径下。但可以通过setPath指定Cookie绑定的路径。

```
cookie.setPath(request.getContextPath()+"/aaa");
cookie1.setPath(request.getContextPath()+"/bbb");
```

> 扩展：Cookie的domain属性可以让网站中二级域共享Cookie。
>
> 以百度网站为例，我们知道百度搜索引擎的地址为：http://www.baidu.com/ 。但百度贴吧、百度学术、百度视频等网站的地址却不是如此，他们如下：
> 												http://zhidao.baidu.com
> 												http://news.baidu.com
> 												http://tieba.baidu.com
>
> 	不同的域名，实际上代表了不同的应用节点，如何让不同应用节点共享相同的Cookie呢？这就需要使用Cookie的domain属性。
> 	想完成这样操作实际也是比较简单，只需要完成如下的两步：
> 	设置Cookie的path为“/”：c.setPath(“/”)。
> 	设置Cookie的domain为“.baidu.com”：c.setDomain(“.baidu.com”)。
> 	当domain为“.baidu.com”时，无论前缀是什么，只要后缀为“.baidu.com”，都会共享Cookie。

### Cookie中保存中文

> 	注意：cookie不能跨浏览器
> 	          cookie中不支持中文要想支持中文必须编码
>
> Cookie的name和value默认是不能使用中文，如果希望在Cookie中使用中文，name需要先对中文进行URL编码，然后把编码后的字符串放到Cookie中。
>
> 案例
> @WebServlet(name = "DServlet",urlPatterns = "/dservlet")
> public class DServlet extends HttpServlet {
>     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
>         response.setContentType("text/html;charset=utf-8");
>         String name = URLEncoder.encode("姓名", "utf-8");
>         String value = URLEncoder.encode("张三","utf-8");
>         Cookie cookie = new Cookie(name,value);
>         response.addCookie(cookie);
>         response.getWriter().write("name:"+name+"<br/>value:"+value);
>     }
>
>     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
>         doPost(request,response);
>     }
> }
>
> 
>
>
> @WebServlet(name = "EServlet",urlPatterns = "/eservlet")
> public class EServlet extends HttpServlet {
>     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
>         response.setContentType("text/html;charset=utf-8");
>         Cookie[] cookies = request.getCookies();
>         for(Cookie c:cookies){
>             String name = URLDecoder.decode(c.getName(), "utf-8");
>             String value = URLDecoder.decode(c.getValue(),"utf-8");
>             response.getWriter().write(name+","+value);
>         }
>     }
>
>     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
>         doPost(request,response);
>     }
> }

### JSP页面中Cookie的使用

> 在JSP页面中，我们同样可以使用Cookie，一种方式就是通过哦<%%>标签编写相关的Cookie的代码，另一种就是使用EL表达式内置的Cookie对象。
> 	
>
> 相比于第一种编写java代码的方式，EL表达式的使用相对简单一些，但是EL只能获取Cookie信息，不能设置Cookie信息。
>
> 		如果想设置Cookie信息，只能使用java代码片的方式
> 		<%
> 					response.addCookie(new Cookie("name","zs"));
> 					response.addCookie(new Cookie("age","18"));
> 		%>			
>
>
> 通过EL表达式怎么获取Cookie的值
> 			${cookie.name.name}:${cookie.name.value}<br/>
> 			${cookie.age.name}:${cookie.age.value}<br/>
>
> 
>
> 案例：
> <body>
>     <%
>         response.addCookie(new Cookie("name","zs"));
>     %>
>     ${cookie.name.name}:${cookie.name.value}<br/>
>     ${cookie.age.name}:${cookie.age.value}
> </body>

## Session

> Session：服务器端会话技术，是指javax.servlet.http.HttpSession接口，表示一次会话，我们可以把一次会话内需要共享的数据保存到HttpSession对象中。

### Session对象的获取

> 1、HttpSession request.getSesssion()：如果当前会话已经有了session对象那么直接返回，如果当前会话还不存在会话，那么应用创建session并返回。
> 2、HttpSession request.getSession(boolean)：当参数为true时，与requeset.getSession()相同。当参数为false时，如果当前会话中存在session则返回，不存在返回null。

对于request的getSession()的用法：
一般情况下，若要向Session中写入数据，则需使用getSession(true)，即getSession()方法。意义是，有老的用老的，没老的建新的。若要从Session中读取数据，则需要使用getSession(false)。意义是，有老的用老的，没老的返回null。因为要读取数据，只有老的Session中才有可能存在你要查找的数据。新建的Session中是不可能有这些数据的。

### HttpSession

> 1、HttpServletRequest：一个请求创建一个request对象，所以在同一个请求中可以共享request，例如一个请求从AServlet转发到BServlet，那么AServlet和BServlet可以共享request域中的数据.
> 2、ServletContext：一个应用只创建一个ServletContext对象，所以在ServletContext中的数据可以在整个应用中共享，只要不重新启动服务器，那么ServletContext中的数据就可以共享。
> 3、PageContext：在一个JSP中的域对象，代表当前JSP页面的范围。
> 4、HttpSession：一个会话创建一个HttpSession对象，同一会话中的多个请求中可以共享session中的数据（即多个无关的Request对象也可以进行数据共享）。

#### 域方法

- void setAttribute(String name, Object value)
- Object getAttribute(String name)
- void removeAttribute(String name)
- Enumeration getAttributeNames()

### ▲Session的工作原理

> 当首次使用session时，服务器端要创建session，session是保存在服务器端，而给客户端的session的id（一个cookie中保存了sessionId）。客户端带走的是sessionId，而数据是保存在session中。当客户端再次访问服务器时，在请求中会带上sessionId，而服务器会通过sessionId找到对应的session，而无需再创建新的session。

### Session的失效时间

默认为30分钟

可通过如下操作自行配置：

<session-config>
    <session-timeout>30</session-timeout>
</session-config>

### ▲Session的生命周期

> session的生命周期	
> 			创建:第一次调用request.getsession()创建
> 			销毁:
> 						服务器非正常关闭(断电)
> 						session超时
> 									默认时间超时:30分钟  web.xml有配置 
> 						手动设置超时:setMaxInactiveInterval(int 秒) 了解
> 						手动干掉session
> 								★session.invalidate()
> 		存放的私有的数据.

### Session中其他常用API

1. String getId()：获取sessionId。
2. int getMaxInactiveInterval()：获取session的最大不活动时间（秒），默认为30分钟。当session在30分钟内没有使用，那么Tomcat会在session池中移除这个session。
3. void setMaxInactiveInterval(int interval)：设置session允许的最大不活动时间（秒），如果设置为1秒，那么只要session在1秒内不被使用，那么session就会被移除。
4. long getCreationTime()：返回session的创建时间，返回值为当前时间的毫秒值。
5. long getLastAccessedTime()：返回session的最后活动时间，返回值为当前时间的毫秒值。
6. void invalidate()：让session失效！调用这个方法会被session失效，当session失效后，客户端再次请求，服务器会给客户端创建一个新的session，并在响应中给客户端新session的sessionId。
7. boolean isNew()：查看session是否为状态新。当客户端第一次请求时，服务器为客户端创建session，但这时服务器还没有响应客户端，也就是还没有把sessionId响应给客户端时，这时session的状态为新。