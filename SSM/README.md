# Spring MVC

***Spring MVC容器依赖于Spring容器。先加载Spring容器再加载SpringMVC容器。***

## 容器Bean加载的优化

- @Controller：SpringMVC中的标签,标注于类上,将一个类声明为SpringMVC控制器类型的Bean。
- @RequestMapping：SpringMVC中的标签,可以标注于类上，也可以标注于方法名上，用来处理请求地址映射的注解。

**SpringMVC和Servlet相比的优势:**

- 加了@Controller注解,通过前端控制器DispatcherServlet,使用@RequestMapping注解进行路径分配,不需要像Servlet那样人为判断内部功能。
- SpringMVC配置简单,一个Servlet需要在web.xml中配置8行
- 一个Servlet只能处理一个请求,方法的入口只有一个,局限性太大。代码复用性不强。
- Servlet代码耦合高。
- Servlet获取表单中的入参需要编写大量的入参获取代码。
- Spring学习简单,并且提供了很多个性化的功能模块。

## 映射处理器

```
 <!--开启SpringMVC注解特性标签-->
    <mvc:annotation-driven></mvc:annotation-driven>

    <!--配置JSP类型的视图解析器-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <!--让SoringMVC能够支持JSTL表达式相关内容-->
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"></property>
        <!--前缀-->
        <property name="prefix">
            <value>/npage/</value>
        </property>
        <!--后缀-->
        <property name="suffix">
            <value>.jsp</value>
        </property>
    </bean>
```



`Spring MVC中的Controller进行页面处理的时候,默认是请求转发的原理。` 

### 参数绑定

- HttpServletRequest类型由Spring MVC自动提供
- HttpServletResponse类型由Spring MVC自动提供
- HttpSession类型由Spring MVC自动提供
- Spring MVC支持String类型以及基础数据类型的参数的绑定,要保证参数名称与请求报文当中的数据名称的一致,并且在一定程度上支持数据类型转换。
- Spring MVC支持POJO类型数据的参数绑定,要求页面上传入请求报文当中的数据名称与POJO类的属性名一致,如果能够从请求报文中获取POJO属性对应的值,则进行设置,否则设置默认值。
- 针对页面上存在的checkbox这种复选框的数据,Spring MVC同样支持以数组的方式进行参数绑定。
- Spring MVC支持List和Map的参数绑定。
- @RequestParam注解用来获取页面上与传入参数名字不一样的参数，map数据类型的绑定中也需要使用。
- Model和ModelMap数据类型的参数绑定，提供将一组值对添加到request作用域当中去。

***自定义参数绑定器***

1. 自定义转换器实现Converter类，需要转换什么类型则泛型写什么类型

   ```
   public class StringToDateConverter implements Converter<String, Date> {
   
       /**
        * 入参String类型的时间由SpringMVC容器负责传入
        * String数据来源于请求报文
        * convert方法负责将String时间转换成Date类型，之后进行返回
        * 返回后的Date同样由SpringMVC容器负责将其绑定到Controller方法的入参当中去。
        * @param dateString
        * @return
        */
       @Override
       public Date convert(String dateString) {
           Date date = null;
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
           try {
               date = dateFormat.parse(dateString);
           } catch (ParseException e) {
               e.printStackTrace();
           }
           return date;
       }
   }
   
   ```

2. 在spring mvc的配置文件中注册转换器

   ```
    <!--开启SpringMVC注解特性标签-->
       <mvc:annotation-driven conversion-service="conversionService"></mvc:annotation-driven>
   
   
   <bean id="conversionService"
             class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
           <property name="converters">
               <list>
                   <!--<ref bean="stringToDateConverter"></ref>-->
                   <bean class="com.ychs.ssm.day04.util.StringToDateConverter"></bean>
               </list>
           </property>
       </bean>
   ```

3. 把需要转换的入参数据类型写成需要转换的类型即可

***出参处理***

- Controller方法出参处理三种情况：重定向、请求转发、Ajax请求响应

1. void类型的出参
   - 使用request对象进行请求转发的响应,需要写完整的服务端相对路径。
   - 使用重定向response对象进行重定向响应，需要写客户端相对路径
   - 使用response对象的字节流进行响应，支持ajax的请求响应。
   - 使用response对象的字符流进行响应，支持文件下载操作。
2. String类型的出参
   - 直接返回一个字符串，该字符串代表Spring MVC视图解析器解析的路径。默认使用的是请求转发操作。
   - 当字符串以forward:开头，代表当前的响应方式为请求转发方式，冒号后面的路径为请求转发完整的服务端相对路径，视图解析器不进行解析。
   - 当返回字符串以redirect:开头的时候，代表当前请求以重定向的方式进行相应，重定向本质上是客户端请求，需要编写项目的项目名，但是Spring MVC默认帮我们编写了项目名（有局限性），所以不需要写项目名称，类似于服务端路径。
3. ModelAndView类型的出参
   - setViewName方法设置视图解析器解析的转发路径。以转发的方式进行请求的响应；addObject方法在request域中添加域属性，要求两个入参，一个代表request域属性的名称，一个代表域属性的值。
4. pojo类型的出参
   - 将POJO对象转换为JSON格式的字符串,进行流的响应,提供Ajax的请求支持。
5. List/Map类型的出参
   - 将List/Map转换为JSON格式的字符串,进行流的响应,提供Ajax的请求支持。
6. 一个Controller方法可以转发到另一个方法当中去

### Spring MVC数据回显的支持

- 对于基础数据类型以及String类型的数据回显,需要通过request对象的域功能来实现。
- 对于POJO类型的数据，在进行参数绑定的时候，默认就会将该对象添加到Request对象的域当中，该域属性的属性名为当前对象类型的首字母小写。

> @ModelAttribute注解在数据回显当中的使用：
>
> - 用于明确指定将POJO对象设置到Request域当中时的属性名。
> - 定义在方法声明上面,要求当前的方法要求当前的方法必须要有一个返回值,@ModelAttribute注解用来指定返回值的域属性名称,将该返回值存入Request对象的域当中,当当前Controller类中的其他请求方法被调用之前,@ModelAttribute注解定义的方法会提前执行,设置相关的域属性。

### Spring MVC提供的乱码过滤器

```
<filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
    </init-param>
    <init-param>
      <param-name>forceEncoding</param-name>
      <param-value>true</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
```

### Spring MVC处理AJAX请求的入门案例

Spring MVC以Jaskson组件来处理JSON数据的返回。

- 如果直接以response对象的字符串流来做响应，那Spring MVC在做响应报文的处理时，响应体的类型为默认的字符串形式，jQuery接收到响应报文之后，需要将JSON格式的字符串手动转换成了JSON对象，之后再去做相关处理。
- 如果以@ResponseBody注解来进行AJAX响应，该注解会默认调用第三方的JSON格式转换组件，去转换返参对象，将返参对象转换为JSON格式字符串，并且会设置Response响应体的类型为application/json。之后，客户端jQuery得到响应报文之后，发现该响应报文默认为json报文，会直接转换成功方法当中的入参，无需手动进行JSON数据的转换。 

Spring MVC接收JSON格式字符串的处理

### Spring MVC对于RESTful风格的支持

***RESTful设计风格 的要求：***

- 请求路径当中不允许出现.do等请求标识，只允许出现/这类型的路径。
- RESTful请求的响应必须是JSON格式的数据。
- 对于RESTful风格的POST请求,要求入参必须是JSON格式的数据,出参也必须是JSON格式的数据。
- 对于RESTful风格的GET请求，一般来说不允许携带数据，也就是说不允许通过？来带数据，如果一定要携带数据，也是通过/路径的方式来携带。出参也必须为JSON格式的数据。

### Spring MVC自带的统一异常处理的使用

- 1. 编写自定义异常类然后再spring MVC的配置文件中配置

```
 <bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
        <!--配置出现绝大多数异常时，处理的页面-->
        <property name="defaultErrorView" value="/error/unitedError"></property>
        <!--当出现异常时，异常处理页面当中想要获取异常信息通过哪个对象名来获取-->
        <property name="exceptionAttribute" value="exception"/>

        <!--定义需要特殊处理的异常，这是重点-->
        <property name="exceptionMappings">
            <props>
                <prop key="com.ychs.ssm.day04.util.BusiException">/error/busiError</prop>
            </props>
            <!--还可以定义其他的自定义异常-->
        </property>
    </bean>
```

- 2. 实现HandlerExceptionResolver接口,再在spring MVC中加入bean

```
package com.ychs.ssm.day04.util;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mingyu Xiong
 * @description:自定义异常处理器
 * @date 2020/3/21 0:38
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o,
                                         Exception exception) {
        ModelAndView modelAndView = new ModelAndView();

        if (exception instanceof BusiException) {
            modelAndView.setViewName("error/bussiError");
            modelAndView.addObject("exception", (BusiException)exception);
        } else {
            modelAndView.setViewName("error/unitedError");
        }
        return modelAndView;
    }
}

```

```
<bean class="com.ychs.ssm.day04.util.MyExceptionResolver"></bean>
```



<hr/>



# Spring MVC

***Spring MVC容器依赖于Spring容器。先加载Spring容器再加载SpringMVC容器。***

## 容器Bean加载的优化

- @Controller：SpringMVC中的标签,标注于类上,将一个类声明为SpringMVC控制器类型的Bean。
- @RequestMapping：SpringMVC中的标签,可以标注于类上，也可以标注于方法名上，用来处理请求地址映射的注解。

**SpringMVC和Servlet相比的优势:**

- 加了@Controller注解,通过前端控制器DispatcherServlet,使用@RequestMapping注解进行路径分配,不需要像Servlet那样人为判断内部功能。
- SpringMVC配置简单,一个Servlet需要在web.xml中配置8行
- 一个Servlet只能处理一个请求,方法的入口只有一个,局限性太大。代码复用性不强。
- Servlet代码耦合高。
- Servlet获取表单中的入参需要编写大量的入参获取代码。
- Spring学习简单,并且提供了很多个性化的功能模块。

## 映射处理器

```
 <!--开启SpringMVC注解特性标签-->
    <mvc:annotation-driven></mvc:annotation-driven>

    <!--配置JSP类型的视图解析器-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <!--让SoringMVC能够支持JSTL表达式相关内容-->
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"></property>
        <!--前缀-->
        <property name="prefix">
            <value>/npage/</value>
        </property>
        <!--后缀-->
        <property name="suffix">
            <value>.jsp</value>
        </property>
    </bean>
```



`Spring MVC中的Controller进行页面处理的时候,默认是请求转发的原理。` 

### 参数绑定

- HttpServletRequest类型由Spring MVC自动提供
- HttpServletResponse类型由Spring MVC自动提供
- HttpSession类型由Spring MVC自动提供
- Spring MVC支持String类型以及基础数据类型的参数的绑定,要保证参数名称与请求报文当中的数据名称的一致,并且在一定程度上支持数据类型转换。
- Spring MVC支持POJO类型数据的参数绑定,要求页面上传入请求报文当中的数据名称与POJO类的属性名一致,如果能够从请求报文中获取POJO属性对应的值,则进行设置,否则设置默认值。
- 针对页面上存在的checkbox这种复选框的数据,Spring MVC同样支持以数组的方式进行参数绑定。
- Spring MVC支持List和Map的参数绑定。
- @RequestParam注解用来获取页面上与传入参数名字不一样的参数，map数据类型的绑定中也需要使用。
- Model和ModelMap数据类型的参数绑定，提供将一组值对添加到request作用域当中去。

***自定义参数绑定器***

1. 自定义转换器实现Converter类，需要转换什么类型则泛型写什么类型

   ```
   public class StringToDateConverter implements Converter<String, Date> {
   
       /**
        * 入参String类型的时间由SpringMVC容器负责传入
        * String数据来源于请求报文
        * convert方法负责将String时间转换成Date类型，之后进行返回
        * 返回后的Date同样由SpringMVC容器负责将其绑定到Controller方法的入参当中去。
        * @param dateString
        * @return
        */
       @Override
       public Date convert(String dateString) {
           Date date = null;
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
           try {
               date = dateFormat.parse(dateString);
           } catch (ParseException e) {
               e.printStackTrace();
           }
           return date;
       }
   }
   
   ```

2. 在spring mvc的配置文件中注册转换器

   ```
    <!--开启SpringMVC注解特性标签-->
       <mvc:annotation-driven conversion-service="conversionService"></mvc:annotation-driven>
   
   
   <bean id="conversionService"
             class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
           <property name="converters">
               <list>
                   <!--<ref bean="stringToDateConverter"></ref>-->
                   <bean class="com.ychs.ssm.day04.util.StringToDateConverter"></bean>
               </list>
           </property>
       </bean>
   ```

3. 把需要转换的入参数据类型写成需要转换的类型即可

***出参处理***

- Controller方法出参处理三种情况：重定向、请求转发、Ajax请求响应

1. void类型的出参
   - 使用request对象进行请求转发的响应,需要写完整的服务端相对路径。
   - 使用重定向response对象进行重定向响应，需要写客户端相对路径
   - 使用response对象的字节流进行响应，支持ajax的请求响应。
   - 使用response对象的字符流进行响应，支持文件下载操作。
2. String类型的出参
   - 直接返回一个字符串，该字符串代表Spring MVC视图解析器解析的路径。默认使用的是请求转发操作。
   - 当字符串以forward:开头，代表当前的响应方式为请求转发方式，冒号后面的路径为请求转发完整的服务端相对路径，视图解析器不进行解析。
   - 当返回字符串以redirect:开头的时候，代表当前请求以重定向的方式进行相应，重定向本质上是客户端请求，需要编写项目的项目名，但是Spring MVC默认帮我们编写了项目名（有局限性），所以不需要写项目名称，类似于服务端路径。
3. ModelAndView类型的出参
   - setViewName方法设置视图解析器解析的转发路径。以转发的方式进行请求的响应；addObject方法在request域中添加域属性，要求两个入参，一个代表request域属性的名称，一个代表域属性的值。
4. pojo类型的出参
   - 将POJO对象转换为JSON格式的字符串,进行流的响应,提供Ajax的请求支持。
5. List/Map类型的出参
   - 将List/Map转换为JSON格式的字符串,进行流的响应,提供Ajax的请求支持。
6. 一个Controller方法可以转发到另一个方法当中去

### Spring MVC数据回显的支持

- 对于基础数据类型以及String类型的数据回显,需要通过request对象的域功能来实现。
- 对于POJO类型的数据，在进行参数绑定的时候，默认就会将该对象添加到Request对象的域当中，该域属性的属性名为当前对象类型的首字母小写。

> @ModelAttribute注解在数据回显当中的使用：
>
> - 用于明确指定将POJO对象设置到Request域当中时的属性名。
> - 定义在方法声明上面,要求当前的方法要求当前的方法必须要有一个返回值,@ModelAttribute注解用来指定返回值的域属性名称,将该返回值存入Request对象的域当中,当当前Controller类中的其他请求方法被调用之前,@ModelAttribute注解定义的方法会提前执行,设置相关的域属性。

### Spring MVC提供的乱码过滤器

```
<filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
    </init-param>
    <init-param>
      <param-name>forceEncoding</param-name>
      <param-value>true</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
```

### Spring MVC处理AJAX请求的入门案例

Spring MVC以Jaskson组件来处理JSON数据的返回。

- 如果直接以response对象的字符串流来做响应，那Spring MVC在做响应报文的处理时，响应体的类型为默认的字符串形式，jQuery接收到响应报文之后，需要将JSON格式的字符串手动转换成了JSON对象，之后再去做相关处理。
- 如果以@ResponseBody注解来进行AJAX响应，该注解会默认调用第三方的JSON格式转换组件，去转换返参对象，将返参对象转换为JSON格式字符串，并且会设置Response响应体的类型为application/json。之后，客户端jQuery得到响应报文之后，发现该响应报文默认为json报文，会直接转换成功方法当中的入参，无需手动进行JSON数据的转换。 

Spring MVC接收JSON格式字符串的处理

### Spring MVC对于RESTful风格的支持

***RESTful设计风格 的要求：***

- 请求路径当中不允许出现.do等请求标识，只允许出现/这类型的路径。
- RESTful请求的响应必须是JSON格式的数据。
- 对于RESTful风格的POST请求,要求入参必须是JSON格式的数据,出参也必须是JSON格式的数据。
- 对于RESTful风格的GET请求，一般来说不允许携带数据，也就是说不允许通过？来带数据，如果一定要携带数据，也是通过/路径的方式来携带。出参也必须为JSON格式的数据。

### Spring MVC自带的统一异常处理的使用

- 1. 编写自定义异常类然后再spring MVC的配置文件中配置

```
 <bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
        <!--配置出现绝大多数异常时，处理的页面-->
        <property name="defaultErrorView" value="/error/unitedError"></property>
        <!--当出现异常时，异常处理页面当中想要获取异常信息通过哪个对象名来获取-->
        <property name="exceptionAttribute" value="exception"/>

        <!--定义需要特殊处理的异常，这是重点-->
        <property name="exceptionMappings">
            <props>
                <prop key="com.ychs.ssm.day04.util.BusiException">/error/busiError</prop>
            </props>
            <!--还可以定义其他的自定义异常-->
        </property>
    </bean>
```

- 2. 实现HandlerExceptionResolver接口,再在spring MVC中加入bean

```
package com.ychs.ssm.day04.util;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mingyu Xiong
 * @description:自定义异常处理器
 * @date 2020/3/21 0:38
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o,
                                         Exception exception) {
        ModelAndView modelAndView = new ModelAndView();

        if (exception instanceof BusiException) {
            modelAndView.setViewName("error/bussiError");
            modelAndView.addObject("exception", (BusiException)exception);
        } else {
            modelAndView.setViewName("error/unitedError");
        }
        return modelAndView;
    }
}

```

```
<bean class="com.ychs.ssm.day04.util.MyExceptionResolver"></bean>
```

<hr/>

# Mybatis

***什么是ORM类型框架?***

> ORM:Object Relational Mapping，对象关系映射结构技术，一种框架设计思想，用于实现面向对象编程语言里不同类型系统数据之间的转换。从效果上说，它其实是创建了一个可在编程语言里使用的"虚拟对象数据库”。将数据库数据模型以简单的方式映射为Java对象(POJO),通过操作Java对象来进行数据库操作，取代了复杂的sq|语句编写过程。
> 知识扩展: Hibernate (全自动数据模型映射框架)

## Mybatis框架与Spring的整合

***SSM框架中如何使用Druid连接池***

1. pom.xml中导入jar包

   ```
    <!-- 阿里德鲁伊连接池 -->
       <dependency>
         <groupId>com.alibaba</groupId>
         <artifactId>druid</artifactId>
         <version>1.1.21</version>
       </dependency>
   ```

   

2. 在jdbc.properties资源配置文件中添加数值

   ```
   filters=stat
   maxActive=20
   initialSize=1
   maxWait=60000
   minIdle=10
   timeBetweenEvictionRunsMillis=60000
   minEvictableIdleTimeMillis=300000
   validationQuery=SELECT 'x' FROM dual
   testWhileIdle=true
   testOnBorrow=false
   testOnReturn=false
   maxOpenPreparedStatements=20
   removeAbandoned=true
   removeAbandonedTimeout=1800
   logAbandoned=true
   ```

3. 修改数据源配置Bean

   ```
   <bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource" destroy-method="close" >
           <!-- 数据库基本信息配置 -->
           <property name="url" value="${url}" />
           <property name="username" value="${username}" />
           <property name="password" value="${password}" />
           <property name="driverClassName" value = "${driver}" />
           <property name="filters" value="${filters}" />
           <!-- 最大并发连接数 -->
           <property name="maxActive" value="${maxActive}" />
           <!-- 初始化连接数量 -->
           <property name="initialSize" value="${initialSize}" />
           <!-- 配置获取连接等待超时的时间 -->
           <property name="maxWait" value="${maxWait}" />
           <!-- 最小空闲连接数 -->
           <property name="minIdle" value="${minIdle}" />
           <!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
           <property name="timeBetweenEvictionRunsMillis" value="${timeBetweenEvictionRunsMillis}" />
           <!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
           <property name="minEvictableIdleTimeMillis" value="${minEvictableIdleTimeMillis}" />
           <property name="validationQuery" value="${validationQuery}" />
           <property name="testWhileIdle" value="${testWhileIdle}" />
           <property name="testOnBorrow" value="${testOnBorrow}" />
           <property name="testOnReturn" value="${testOnReturn}" />
           <property name="maxOpenPreparedStatements" value="${maxOpenPreparedStatements}" />
           <!-- 打开 removeAbandoned 功能 -->
           <property name="removeAbandoned" value="${removeAbandoned}" />
           <!-- 1800 秒，也就是 30 分钟 -->
           <property name="removeAbandonedTimeout" value="${removeAbandonedTimeout}" />
           <!-- 关闭 abanded 连接时输出错误日志 -->
           <property name="logAbandoned" value="${logAbandoned}" />
       </bean>
   ```

4. 通过以上配置就已经启用了Druid连接池功能,但Druid连接池还提供了相应的监控视图页面。

   ```
     <!--启用Druid连接池监控-->
     <filter>
       <filter-name>DruidWebStatFilter</filter-name>
       <filter-class>com.alibaba.druid.support.http.WebStatFilter</filter-class>
       <init-param>
         <param-name>exclusions</param-name>
         <param-value>*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*</param-value>
       </init-param>
     </filter>
     <filter-mapping>
       <filter-name>DruidWebStatFilter</filter-name>
       <url-pattern>/*</url-pattern>
     </filter-mapping>
     <servlet>
       <servlet-name>DruidStatView</servlet-name>
       <servlet-class>com.alibaba.druid.support.http.StatViewServlet</servlet-class>
     </servlet>
     <servlet-mapping>
       <servlet-name>DruidStatView</servlet-name>
       <url-pattern>/druid/*</url-pattern>
     </servlet-mapping>
   ```

   

### Mybatis配置文件

- configuration：配置头，表示MyBatis相关设置开始
  - properties：引入外部资源文件，将外部配置文件的信息变成全局变量或单独配置全局变量
  - settings：设置MyBatis框架内部属性
  - typeAlias：类型别名
  - typeHandles：类型转换器
  - objectFactory：对象工厂
  - plugins：插件配置
  - environments：环境配置
    - environment：环境标识
      - transactionManager：事务管理器
      - dataSource：数据源配置
  - mappers：映射器

### MyBatis的SQL映射

- Mapper

  > 有一个namespace属性，用来指定当前这个SQL映射文件转换成一个类时，这个类它所实现的接口类型，写的是接口的类的全限定名。

- resultMap

  > 用来处理POJO类型与SQL语句查询出的字段值之间的映射关系。一般情况下，POJO的属性名和表的字段名是一致的，在特殊情况下，POJO的属性名和表的字段名不一致的时候，可以通过resultMap的column来进行适配。

- select

  > 支持查询语句。
  >
  > 结果集的处理方式有两种：
  >
  > 1. resultMap方式，resultMap必须指定为resultMap标签的id；
  > 2. resultType方式，resultType一般用来指定一个POJO的类型，使用Java当中的类来处理结果集。
  >
  > 对于入参的处理方式也有两种方式：
  >
  > 1. parameterType方式，用来指定Java当中的类型，可以是普通的基础数据类型的包装类，也可以是String类型，还可以是POJO类型和Map类型。
  > 2. parameterMap方式，也能用来处理入参，但其使用方式极其复杂，一般不使用它来处理，在高版本当中已经弃用。

- insert、delete、update

  > 支持插入语句。
  >
  > 只存在parameterType属性，用于指定入参的值，不存在resultMap和resultType属性，因为更新语句没有结果集。只有操作之后影响的记录数，要想获取影像记录数，直接在接口方法处声明int类型的返回值即可。
  >
  > insert语句，如果是MySQL数据库，主键自增，不需要在SQL语句中写明主键字段，就能够完成主键自增的添加功能；如果是Oracle数据库，主键值通过Oracle的序列来获取，有两种办法解决：第一种先编写一个查询主键序列的SQL，得到主键序列值之后，将其设置到POJO当中去，之后再执行insert语句，需要些两个抽象方法；另一种方法使用MyBatis提供的selectKey标签来直接完成方法一当中的整个操作。
  >
  > insert语句对于MySQL而言，要想获取插入语句执行后的自增主键值，需要通过useGeneratedKeys和keyProperty配合来获取，获取之后设置到了入参POJO对象对应的属性当中去，Map不支持。

- SQL

  > 用来定义可重用的SQL代码段，之后通过include标签为其它SQL语句所使用

  ```
  <sql id="userInfoColumn">
          id,
          name,
          username,
          password,
          sex
   </sql>
   
   <select id="selectUserInfo" resultType="UserInfo">
          SELECT
          <include refid="userInfoColumn" />
          FROM
          user_info
  </select>
  ```

- cache和cache-ref

  > cache用来开启当前页面缓存。
  >
  > - 映射语句文件中的所有select 语句将会被缓存。
  >
  > - 映射语句文件中的所有insert,update和delete语句调用会刷新缓存。
  >
  > - cache中有一个flushInterval属性， 用来设置缓存收集时间间隔，每隔多长时间进行一-次收集。
  >
  > cache-ref标签用于参照缓存配置，例如A命名空间配置了一个cache缓存，B命名空间想要参考A的配置，直接使用如下语句：
  >
  > <cache-ref namespace="A">

- choose、when、otherwise

  > 当SQL语句传入一个Java对象的null空时，在数据库当中一条记录也查不出来，无法匹配数据库的字段空NULL、字符串null以及空字符串。
  >
  > choose标签是按顺序判断其内部when标签中的test条件出否成立，如果有一个成立，则 choose 结束。当 choose 中所有 when 的条件都不满则时，则执行 otherwise 中的sql。

- trim、where、set

  > **一、**
  >
  > &lt;trim prefix="1=1" suffix="" suffixOverrides="AND | OR" prefixOverrides="">&lt;/trim>
  >
  > prefix:在trim标签内sql语句加上前缀。
  >
  > suffix:在trim标签内sql语句加上后缀。
  >
  > prefixOverrides:指定去除多余的前缀内容
  >
  > suffixOverrides:指定去除多余的后缀内容，如：suffixOverrides=","，去除trim标签内sql语句多余的后缀","。
  >
  > **二、**
  >
  > 1. 只有在一个以上的if条件有值的情况下才去插入“WHERE”开头的子句
  >
  > 2. 若其后是“AND”或“OR”为首的，where 元素也会将他们去除
  
- foreach

  > foreach元素的属性主要有item，index，collection，open，separator，close。
  >
  > - **item：**集合中元素迭代时的别名，该参数为必选。
  > - **index**：在list和数组中,index是元素的序号，在map中，index是元素的key，该参数可选
  > - **open**：foreach代码的开始符号，一般是(和close=")"合用。常用在in(),values()时。该参数可选
  > - **separator**：元素之间的分隔符，例如在in()的时候，separator=","会自动在元素中间用“,“隔开，避免手动输入逗号导致sql错误，如in(1,2,)这样。该参数可选。
  > - **close:** foreach代码的关闭符号，一般是)和open="("合用。常用在in(),values()时。该参数可选。
  > - **collection:** 要做foreach的对象，作为入参时，List对象默认用"list"代替作为键，数组对象有"array"代替作为键，Map对象没有默认的键。当然在作为入参时可以使用@Param("keyName")来设置键，设置keyName后，list,array将会失效。 除了入参这种情况外，还有一种作为参数对象的某个字段的时候。举个例子：如果User有属性List ids。入参是User对象，那么这个collection = "ids".***如果User有属性Ids ids;其中Ids是个对象，Ids有个属性List id;入参是User对象，那么collection = "ids.id"***

  ```
  <select id="selectUserByIdList" parameterType="list" resultType="UserInfo">
          SELECT
          <include refid="userInfoColumn"></include>
          FROM
          user_info
          WHERE
          id in
          <foreach collection="list"
                   item="id"
                   open="("
                   close=")"
                   separator=",">
              #{id}
          </foreach>
      </select>
  ```

- #{}与${}

  > 模糊查询的SQL编写方式:
  >
  > - username LIKE '%${username}%'
  > - username LIKE CONCAT('%',#{username},'%')
  >
  > 1、#对传入的参数视为字符串，也就是它会预编译，select * from user where name = #{name}，比如我传一个aaa，那么传过来就是 select * from user where name = 'aaa'；
  >
  > 2、$将不会将传入的值进行预编译，select * from user where name=${name}，比如我传一个aaa，那么传过来就是 select * from user where name = aaa；
  >
  > 3、#的优势就在于它能很大程度的防止sql注入，而$则不行。比如：用户进行一个登录操作，后台sql验证式样的：select * from user where username=#{name} and password = #{pwd}，如果前台传来的用户名是“wang”，密码是 “1 or 1=1”，用#的方式就不会出现sql注入，而如果换成$方式，sql语句就变成了 select * from user where username=wang and password = 1 or 1=1。这样的话就形成了sql注入。
  >
  > 4、MyBatis排序时使用order by 动态参数时需要注意，用$而不是#

- <![CDATA[]]>

  > 特殊符号原样输出功能。
  >
  > 经测试\&lt;和\&gt;照样可行。

### MyBatis的关联映射

#### 一对一映射处理

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.ychs.ssm.day07.mapper.StudentMapper">
    <resultMap id="addressInfoMap" type="AddressInfo">
        <id property="addressId" column="addressId" javaType="int"></id>
        <result property="addressInfo" column="addressInfo" javaType="string"></result>
        <result property="remark" column="remark" javaType="string"></result>
    </resultMap>
    <resultMap id="studentInfoMap" type="StudentInfo">
        <id property="stuId" column="stuId" javaType="int"></id>
        <result property="name" column="name" javaType="string"></result>
        <result property="sex" column="sex" javaType="string"></result>
        <result property="age" column="age" javaType="int"></result>
        <association property="addressInfo" resultMap="addressInfoMap"></association>
    </resultMap>

    <select id="selectStudentById" parameterType="int" resultMap="studentInfoMap">
        SELECT
        a.stu_id stuId,
        a.name,
        a.age,
        a.address_id addressId,
        b.address_info addressInfo,
        b.remark
        FROM
        student_info a,address_info b
        WHERE
        a.address_id = b.address_id
        AND
        stu_id = #{stuId}
    </select>

</mapper>
```

#### 一对多映射处理

```
<mapper namespace="com.ychs.ssm.day07.mapper.Student01Mapper">
    <resultMap id="studentMap" type="Student">
        <id property="stuId" column="stuId" javaType="int"></id>
        <result property="name" column="name" javaType="string"></result>
        <result property="sex" column="sex" javaType="string"></result>
        <result property="age" column="age" javaType="int"></result>
        <collection property="addressList" ofType="Address">
            <id property="addressId" column="addressId" javaType="int"></id>
            <result property="addressInfo" column="addressInfo" javaType="string"></result>
            <result property="remark" column="remark" javaType="string"></result>
        </collection>
    </resultMap>
    <select id="selectStudentById" parameterType="int" resultMap="studentMap">
        SELECT
        a.stu_id stuId,
        a.name,
        a.sex,
        a.age,
        b.address_id addressId,
        b.address_info addressInfo,
        b.remark
        FROM
        student a,
        address b
        WHERE
        a.stu_id = b.stu_id
        AND a.stu_id = #{stuId}
    </select>

    <select id="selectStudentByMap" parameterType="int" resultType="map">
         SELECT
        a.stu_id stuId,
        a.name,
        a.sex,
        a.age,
        b.address_id addressId,
        b.address_info addressInfo,
        b.remark
        FROM
        student a,
        address b
        WHERE
        a.stu_id = b.stu_id
        AND a.stu_id = #{stuId}
    </select>
</mapper>
```

实际开发选用第二种方式,无需配置更简单方便。

### MyBatis Generator组件的使用

1. 在pom.xml中导入组件

```
<build>
    <finalName>SSM-Day07</finalName>
    <resources>
      <resource>
        <directory>src/main/java</directory>
        <includes>
          <include>**/*.xml</include>
        </includes>
      </resource>
      <resource>
        <directory>src/main/resources</directory>
      </resource>
    </resources>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-war-plugin</artifactId>
          <version>3.2.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
      </plugins>
    </pluginManagement>
    <!--MyBatis Generator组件-->
    <plugins>
      <plugin>
        <groupId>org.mybatis.generator</groupId>
        <artifactId>mybatis-generator-maven-plugin</artifactId>
        <version>1.4.0</version>
        <configuration>
          <configurationFile>src/main/resources/mybatis-generator-config.xml</configurationFile>
          <verbose>true</verbose>
          <overwrite>true</overwrite>
        </configuration>
        <dependencies>
          <dependency>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-core</artifactId>
            <version>1.4.0</version>
          </dependency>
        </dependencies>
      </plugin>
    </plugins>
  </build>
</project>
```

2. 编写配置文件

   ```
   <?xml version="1.0" encoding="UTF-8"?>
   <!DOCTYPE generatorConfiguration
           PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
           "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
   <generatorConfiguration>
   
       <!-- 本地数据库驱动程序jar包的全路径 -->
       <classPathEntry location="E:/Usual/mavenRepository/mysql/mysql-connector-java/8.0.19/mysql-connector-java-8.0.19.jar" />
   
   
       <context id="context" targetRuntime="MyBatis3">
   
           <!--定义生成的java类的编码格式-->
           <property name="javaFileEncoding" value="UTF-8"/>
   
           <commentGenerator>
               <property name="suppressAllComments" value="true" />
           </commentGenerator>
   
           <!-- 数据库的相关配置-->
           <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver"
                           connectionURL="jdbc:mysql://localhost:3306/springtest?serverTimezone=UTC"
                           userId="root"
                           password="root">
           </jdbcConnection>
   
           <javaTypeResolver>
               <property name="forceBigDecimals" value="false" />
           </javaTypeResolver>
   
           <!--java实体类生成的位置-->
           <javaModelGenerator targetPackage="com.ychs.ssm.day07.model" targetProject="src/main/java">
               <property name="enableSubPackages" value="true" />
               <!-- 从数据库返回的值被清理前后的空格  -->
               <property name="trimStrings" value="true" />
           </javaModelGenerator>
   
           <!--对应的mapper.xml文件  -->
           <sqlMapGenerator targetPackage="com.ychs.ssm.day07.mapper" targetProject="src/main/java">
               <property name="enableSubPackages" value="true" />
           </sqlMapGenerator>
   
           <!-- 对应的Mapper接口类文件 -->
           <javaClientGenerator type="XMLMAPPER" targetPackage="com.ychs.ssm.day07.mapper" targetProject="src/main/java">
               <property name="enableSubPackages" value="true" />
           </javaClientGenerator>
   
           <!-- 相关表的配置，tableName对应数据库表，domainObjectName对应实体类名 -->
           <table tableName="teacher_info" domainObjectName="TeacherInfo"
                  enableCountByExample="true" enableUpdateByExample="true"
                  enableDeleteByExample="true" enableSelectByExample="true"
                  selectByExampleQueryId="true">
               <property name="ignoreQualifiersAtRuntime" value="false"/>
               <property name="useActualColumnNames" value="false"/>
           </table>
   
       </context>
   </generatorConfiguration>
   
   ```

3. 测试

   ```
   package com.ychs.ssm.day08.test;
   
   import com.ychs.ssm.day07.mapper.TeacherInfoMapper;
   import com.ychs.ssm.day07.model.TeacherInfo;
   import com.ychs.ssm.day07.model.TeacherInfoExample;
   import org.junit.Test;
   import org.junit.runner.RunWith;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.test.context.ContextConfiguration;
   import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
   
   import java.util.List;
   
   /**
    * @author Mingyu Xiong
    * @description:测试MybatisGenerator
    * @date 2020/4/1 17:22
    */
   @RunWith(SpringJUnit4ClassRunner.class)
   @ContextConfiguration(locations = "classpath:spring-config.xml")
   public class TeacherInfoMapperTest {
   
       @Autowired
       private TeacherInfoMapper teacherInfoMapper;
   
       @Test
       public void insertTest() {
           TeacherInfo teacherInfo = new TeacherInfo();
           teacherInfo.setName("李四");
           teacherInfo.setAge(18);
           teacherInfo.setSex("男");
   /*        teacherInfo.setTeacherType("java");
           teacherInfo.setRemark("张三");*/
           //teacherInfoMapper.insert(teacherInfo);
           teacherInfoMapper.insertSelective(teacherInfo);
       }
   
       @Test
       public void updateTest() {
           TeacherInfo teacherInfo = new TeacherInfo();
           teacherInfo.setName("王睿希");
           teacherInfo.setTeacherId(2);
           teacherInfo.setAge(19);
           teacherInfo.setSex("女");
           //teacherInfoMapper.updateByPrimaryKey(teacherInfo);
           //teacherInfoMapper.updateByPrimaryKeySelective(teacherInfo);
           //teacherInfoMapper.updateByExample();
           //teacherInfoMapper.updateByExampleSelective();/**/
       }
   
       @Test
       public void deleteTest() {
           //teacherInfoMapper.deleteByPrimaryKey(1);
           //teacherInfoMapper.deleteByExample();
       }
   
       @Test
       public void selectTest() {
           /*TeacherInfo teacherInfo = teacherInfoMapper.selectByPrimaryKey(3);
           System.out.println(teacherInfo);*/
           TeacherInfoExample example = new TeacherInfoExample();
          // example.createCriteria().andNameEqualTo("王睿希").andSexEqualTo("女").andAgeEqualTo(19);
           //example.createCriteria().andAgeBetween(18, 20);
           example.createCriteria().andNameLike("%王%");
           List<TeacherInfo> teacherInfos = teacherInfoMapper.selectByExample(example);
           System.out.println(teacherInfos);
       }
   }
   
   ```

   