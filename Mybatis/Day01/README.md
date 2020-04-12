# Mybatis

# 框架

框架是我们软件开发中的一套解决方案.

## 三层架构

1. 表现层:是用于展示数据的
2. 业务层:是处理业务需求的
3. 持久层:是和数据库交互的

## MyBatis框架

Mybatis是一个持久层框架,它封装了jdbc操作的很多细节,是开发者只需要关注sql语句本身,而无需关注注册驱动,创建连接等繁杂过程它使用了ORM思想实现了结果集的封装.

ORM: Object Relational Mapping对象关系映射

## Mybatis入门

- mybatis的环境搭建

  1. 创建maven工程并导入坐标
  2. 创建实体类和dao的接口
  3. 创建mybatis的主配置文件:SqlMapConfig.xml
  4. 创建映射配置文件:IUserDao.xml

- 环境搭建的注意事项

  1. IUserDao和IUserMapper是一样的
  2. mybatis的映射配置文件必须和dao接口的包结构相同
  3. 映射配置文件的mapper标签namespace的取值必须是dao接口的全限定类名
  4. 映射配置文件的操作配置(select),id属性的取值必须是dao接口的方法名

- 入门案例步骤

  1. 读取配置文件
     - 使用类加载器,他只能读取类路径的配置文件
     - 使用ServletContext对象的getRealPath()
  2. 创建SqlSessionFactory工厂
     - 创建工厂mybatis使用构建者模式
     - 优势:把对象的创建西街隐藏,使使用者直接调用方法可拿到对象
     - builder就是构建者
  3. 使用工厂生产SqlSession对象
     - 生产SqlSession使用了工厂模式
     - 优势:解耦,降低类之间的依赖关系
  4. 使用SqlSession创建Dao接口的代理对象
     - 创建Dao接口实现类使用了代理模式
     - 优势:不修改源码的基础上对已有方法增强 
  5. 使用代理对象执行方法
  6. 释放资源

  注意事项:

  ​	不要忘记在映射配置中告知Mybatis要封装到哪个实体类中

  配置方式:实体类的全限定类名

  mybatis基于注解的入门案例:

  把IUserDao.xml移除,在dao接口的方法上使用@Select注解,并且指定SQL语句

  同时需要在SqlMapConfig.xml中的mapper配置时,使用class属性指定dao接口的全限定类名.

明确:

​	我们在实际开发中都是越简便越好,所以都是采用不写dao实现类的方式.不管使用XML还是注解配置,mybatis是支持写dao实现类的 

- 自定义Mybatis分析

  Mybatis在使用代理dao的方式实现增删改查时做了什么事呢?

  只有两件事:第一.创建代理对象

  ​					第二.在代理对象中调用selectList

#### OGNL(Object Graphic Navigation Language)表达式

对象图导航语言

它是通过对象的取值方法来获取数据,在写法上把get省略了。

比如:我们获取用户的名称
			类中的写法:user.getUsername();
			OGNL表达式写法:user.username
mybatis中为什么能直接写username,而不用user.呢:因为在parameterType中已经提供了属性所属的类,所以此时不需要写对象名,而是直接写属性名。

## Mapper动态代理的方式

> Mapper接口开发方法只需要程序员编写Mapper接口（相当于Dao接口），由mybatis框架根据接口定义创建接口的动态代理对象，代理对象的方法体同上边Dao接口实现类方法
> Mapper接口开发需要遵循的规范
> 1、Mapper.xml文件中namespace与mapper接口的类路径相同
> 2、Mapper接口方法名和Mapper.xml中定义的每个statement的id相同
> 3、Mapper接口方法的输入参数类型和mapper.xml中定义的每个sql的parameterType的类型相同
> 4、Mapper接口方法的输出参数类型和mapper.xml中定义的每个sql的resultType的类型相同
>
> 
>
>
> 注意：输入参数可以使用pojo包装对象或map对象，保证dao的通用性

- Mybatis插入为NULL处理

  > 一、指定插入值得jdbcType，将sql改成 insert into user(id,name) values(#{id,jdbcType=VARCHAR},#{name,jdbcType=VARCHAR}) 
  >
  > 二、在mybatis-config.xml配置文件中添加：
  >
  > <configuration> 
  > ......
  > <settings>
  >     <setting name="jdbcTypeForNull" value="NULL" />
  > </settings>
  > ......
  > </configuration>

## SqlMapConfig配置文件

- properties

  > 引入java属性文件信息
  >
  > 如:引入jdbc数据库连接的信息:
  >
  > <properties resource="db.properties"></properties>

- settings

  > Mybatis的全局配置参数,影响mybatis的运行行为

- typeAliases

  > 自定义别名:
  >
  > <typeAliases>
  >         <!--单个自定义别名
  >         type:是要定义的别名类型，alias是定义的别名
  >         -->
  >         <!--<typeAlias type="com.ychs.pojo.User" alias="user"></typeAlias>-->
  >         <!--批量自定义别名，扫描整个包下的类-->
  >         <package name="com.ychs.pojo"></package>
  >     </typeAliases>

  ```
  指定报名批量定义别名,别名自动为对应包装类的类名首字母改为小写
  ```

- typeHandler

  > 实现数据库的Java的类型转换

- mappers

  > 映射文件的引入

## mybatis的#{}占位符和${}拼接符的区别

> **#{}占位符:占位** 
> 如果传入的是基本类型,那么#{}中的变量名称可以随意写 
> 如果传入的参数是pojo类型,那么#{}中的变量名称必须是pojo中的属性.属性.属性…
>
> **`${}`拼接符:字符串原样拼接** 
> **如果传入的是基本类型,那么`${}`中的变量名必须是value** 
> 如果传入的参数是pojo类型,那么`${}`中的变量名称必须是pojo中的属性.属性.属性…

<span style='color:red;font-weight:bold;font-size:50px'>注意:使用拼接符有可能造成sql注入</span>

## 开发的过程

1. 加载配置文件(SqlMapConfig.xml)
2. 创建sqlSessionFactory
3. 创建sqlSession
4. mapper的代理对象
5. 代理对象执行方法

