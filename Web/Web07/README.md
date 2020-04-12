# 监听器和过滤器

## 监听器

`Listener:JavaWeb中的三大组件之一，称之为监听器，用于事件的监听以及事件触发之后的操作。`

监听器使用规则：

1. 他是一个接口，内容由我们来实现。

2. 它需要注册，例如注册在按钮上。
3. 监听器中的方法，会在特殊事件发生时被调用。		

作用：监听web中的域对象 ServletContext ServletRequest HttpSession

监听内容：

1. 监听三个对象的创建和销毁
   ```
   ServletContextListener
   ServletRequestListener
   HttpSessionListener
   ```
2. 监听三个对象属性的变化

   ```
   ServletContextAttributeListener
   ServletRequestAttributeListener
   HttpSessionAttributeListener
   ```

### 编写步骤

1. 写一个监听器类：要求必须去实现某个监听器接口

2. 重写里面的方法

3. 注册，是在web.xml中配置来完成注册（通过@WebListener注解也可）

   注意：上述三个监听器都是接口，我们可以实现其相应的方法，在发生相应的事件时，完成相关方法的调用。

### 实现方法

- ServletContext的监听

  > 生命周期监听：ServletContextListener，它有两个方法，一个在出生时调用，一个在死亡时调用。即Tomcat启动应用时，我们调用contextInitialized方法，Tomcat关闭应用之前，我们调用contextDestroyed方法。
  >
  > 	void contextInitialized(ServletContextEvent sce)：创建SErvletcontext时。
  > 	void contextDestroyed(ServletContextEvent sce)：销毁Servletcontext时。
  >
  > 属性监听：ServletContextAttributeListener，它有三个方法，一个在添加属性时调用，一个在替换属性时调用，最后一个是在移除属性时调用。
  >
  > ```
  > void attributeAdded(ServletContextAttributeEvent event)：添加属性时。
  > void attributeReplaced(ServletContextAttributeEvent event)：替换属性时。
  > void attributeRemoved(ServletContextAttributeEvent event)：移除属性时。
  > ```

- HttpSession的监听

  > 生命周期监听：HttpSessionListener，它有两个方法，一个在出生时调用，一个在死亡时调用。
  >
  > ```
  > void sessionCreated(HttpSessionEvent se)：创建session时
  > void sessionDestroyed(HttpSessionEvent se)：销毁session时
  > ```
  >
  > 属性监听：HttpSessioniAttributeListener，它有三个方法，一个在添加属性时调用，一个在替换属性时调用，最后一个是在移除属性时调用。
  >
  > 	void attributeAdded(HttpSessionBindingEvent event)：添加属性时；
  > 	void attributeReplaced(HttpSessionBindingEvent event)：替换属性时
  > 	void attributeRemoved(HttpSessionBindingEvent event)：移除属性时
  > JavaWeb监听器还有两个与HttpSession相关的特殊的监听器，这两个监听器的特点如下：
  >
  > 1. 不用在web.xml文件中进行注册。
  > 2. 这两个监听器让某个JavaBean类实现监听器接口，然后再把Bean对象添加到session域中，添加该Bean或者销毁该Bean时，触发监听事件。
  >
  > 这两个特殊的HttpSession监听器如下：
  > 				HttpSessionBindingListener。
  > 				HttpSessionActivationListener。
  >
  > 

- ServletRequest的监听

  > 生命周期监听：ServletRequestListener，它有两个方法，一个在出生时调用，一个在死亡时调用。
  > 						void requestInitialized(ServletRequestEvent sre)：创建request时
  > 						void requestDestroyed(ServletRequestEvent sre)：销毁request时
  >
  > 属性监听：ServletRequestAttributeListener，它有三个方法，一个在添加属性时调用，一个在替换属性时调用，最后一个是在移除属性时调用。
  > 						void attributeAdded(ServletRequestAttributeEvent srae)：添加属性时
  > 						void attributeReplaced(ServletRequestAttributeEvent srae)：替换属性时
  > 						void attributeRemoved(ServletRequestAttributeEvent srae)：移除属性时

## 过滤器

过滤器Filter是JavaWeb三大组件之一，它与Servlet很相似！不过它是用来拦截请求的，而不是处理请求的。
当用户请求某个Servlet时，会先执行部署在这个请求上的Filter，如果Filter“放行”，那么会继承执行用户请求的Servlet；如果Filter不“放行”，那么就不会执行用户请求的Servlet。

### 编写步骤

1. 编写一个类
   - 实现filter接口
   - 重写方法
2. 编写配置文件
   - 注册filter
   - 绑定路径

### 过滤器的生命周期

- init(FilterConfig config)

  在服务器启动时会创建Filter实例，并且每个类型的Filter只创建一个实例，从此不再创建！在创建完Filter实例后，会马上调用init()方法完成初始化工作，这个方法只会被执行一次。

- doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)

  这个方法会在用户每次访问“目标资源（<url-pattern>/index.jsp</url-pattern>）”时执行，如果需要“放行”，那么需要调用FilterChain的doFilter(ServletRequest,ServletResponse)方法，如果不调用FilterChain的doFilter()方法，那么目标资源将无法执行。

- destory()

  服务器会在创建Filter对象之后，把Filter放到缓存中一直使用，通常不会销毁它。一般会在服务器关闭时销毁Filter对象，在销毁Filter对象之前，服务器会调用Filter对象的destory()方法

### FilterConfig

- ServletContext getServletContext()：获取ServletContext的方法。
- String getFilterName()：获取Filter的配置名称，与<filter-name>元素对应。
- String getInitParameter(String name)：获取Filter的初始化配置，与<init-param>元素对应；
- Enumeration getInitParameterNames()：获取所有初始化参数的名称。

### 多个过滤器的执行顺序

web.xml注册方式：根据web.xml中的注册顺序

### 四种拦截方式

- ▲REQUEST：直接访问目标资源时执行过滤器。包括：在地址栏中直接访问、表单提交、超链接、重定向，只要在地址栏中可以看到目标资源的路径，就是REQUEST；
- ▲FORWARD：转发访问执行过滤器。包括RequestDispatcher#forward()方法、&lt;jsp:forward>标签都是转发访问；
- INCLUDE:包含访问执行过滤器。包括RequestDispatcher#include()方法、&lt;jsp:include>标签都是包含访问；
- ERROR:当目标资源在web.xml中配置为<error-page>中时，并且真的出现了异常，转发到目标资源时，会执行过滤器。