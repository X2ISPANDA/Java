# 一、连接池

1. 使用连接池的原因

  - 数据库连接（Connection）频繁的打开关闭相当耗费资源。为解决这个问题，数据库连接池的原理是系统开启时主动建立足够数额的连接，并且将这些连接组成连接池，每次数据库使用连接的时候从连接池中取出，用完之后再归还给连接池

2. 连接池的作用

  - 提高项目的性能，就是在连接池初始化时存入一定数量的连接，用的时候通过方法获取，不用的时候归还连接即可

3. 自定义简易连接池

  - 实现一个接口：javax.sql.DataSource接口

  - 获取连接方法：Connection getConnection()

  - 归还连接方法就是以前释放资源的方法，调用connection.close()
***
# 二、常用连接池

1. dbcp与c3p0区别

  - dbcp没有自动回收空闲连接的功能

  - c3p0有自动回收空闲连接功能

2. 连接池的常设属性

  - DBCP连接池常见的配置

    ```
    必须项   
    driverClassName	 数据库驱动名称
    url	 数据库的地址
    username	用户名
    password	密码
    基本项
    maxActive	 最大连接数量
    initialSize	 连接池中初始化多少个Connection连接对象
    扩展项
    maxWait	超时等待时间以毫秒为单位 1000等于1秒
    ```

  - C3P0连接池的常设属性

    ```
    必须项   
    driverClass	 数据库驱动名称
    jdbcUrl	 数据库的地址
    user	用户名
    password	密码
    基本项
    initialPoolSize  设置初始化连接数
    maxPoolSize  连接池的最大连接数  
    minPoolSize   连接池的最小连接数
    ```
***
# 三、DBCP连接池

1. 所需 jar

  - commons-dbcp2-2.1.1.jar

  - commons-pool2-2.4.2.jar

2. DBCP的两种配置方式

  - 硬编码setter方式

    ```
    //创建数据库连接池
    BasicDataSource bds = new BasicDataSource();
    //对连接池进行基本配置
    bds.setDriverClassName(DRIVER);//这是要连接的数据库的驱动
    bds.setUrl(URL);//指定要连接的数据库地址
    bds.setUsername(USERNAME);//指定要连接数据库的用户名
    bds.setPassword(PASSWORD);//指定要连接数据库的密码
    ```

  - 使用配置文件dbcp.properties

    ```
    1. 类路径下提供一个dbcp.properties文件
    编写配置文件，文件的命名必须是dbcp.properties，里面配置项的格式为：
    driverClassName = com.mysql.jdbc.Driver
    url = jdbc:mysql://localhost:3306/test
    username =root
    password =root
    2、编码
    Properties prop = new Properties();
    prop.load(new FileInputStream("src/dbcp.properties"));
    DataSource ds = new BasicDataSourceFactory().createDataSource(prop);
    Connection conn = ds.getConnection();
    ```
***
# 四、C3P0连接池

1. 所需jar包

  - c3p0-0.9.5.2.jar

  - mchange-commons-java-0.2.11.jar

  - c3p0-oracle-thin-extras-0.9.5.2.jar

2. C3P0的三种配置方式

  - 硬编码setter方式

    ```
    ComboPooledDataSource cpds = new ComboPooledDataSource();
    cpds.setDriverClass(“oracle.jdbc.OracleDriver”);
    cpds.setJdbcUrl(“jdbc:oracle:thin:@localhost:1521:orcl”);
    cpds.setUser("scott");
    cpds.setPassword("oracle");
    ```

  - 使用配置文件c3p0.properties

    ```
    1、类路径src下提供一个c3p0.properties文件,文件的命名必须是c3p0.properties
    c3p0.driverClass=oracle.jdbc.OracleDriver
    c3p0.jdbcUrl=jdbc:oracle:thin:@localhost:1521:orcl
    c3p0.user=myuser
    c3p0.password=myuser
    2、编码
    ComboPooledDataSource cpds = new ComboPooledDataSource();
    public static Connection getConnection() {
      try {
        return ds.getConnection();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
    ```

  - 使用配置文件c3p0-config.xml

    1. 类路径下提供一个c3p0-config.xml文件

      ```
        <c3p0-config>
          <default-config>
            <property name="driverClass">oracle.jdbc.OracleDriver</property>
            <property name="jdbcUrl">jdbc:oracle:thin:@localhost:1521:orcl</property>
            <property name="user">myuser</property>
            <property name="password">myuser</property>
          </default-config>
          <named-config name="yc">
            ...
          </named-config>
        </c3p0-config>
      ```

    2. 如果要使用default-config则初始化数据源的方式与第二种一样，如果要使用named-config里面配置初始化数据源，则只要使用一个带参数的ComboPooledDataSource构造器就可以了

      ```
      //ComboPooledDataSource cpds = new ComboPooledDataSource();
      ComboPooledDataSource cpds = new ComboPooledDataSource("yc");
      public static Connection getConnection() {
        try {
          return ds.getConnection();
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
      }
      ```
***
# 五、Druid连接池

1. 所需jar包：druid-1.1.6.jar

2. 两种配置方式

  - 硬编码方式

    ```
    DruidDataSource dataSource = new DruidDataSource();

    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
    dataSource.setUsername("myuser");
    dataSource.setPassword("myuser");

    //dataSource.getConnection获取到的是DruidPooledConnection对象，需再次getConnection
    ```

  - 使用配置文件druid.properties

    1. 类路径下提供一个c3p0-config.xml文件

      ```
      driverClassName=oracle.jdbc.OracleDriver
      url=jdbc:oracle:thin:@localhost:1521:orcl
      username=myuser
      password=myuser
      filters=stat
      initialSize=2
      maxActive=300
      maxWait=60000
      ```

    2. 编码

      ```
      Properties prop = new Properties();
      prop.load(new FileInputStream("src/dbcp.properties"));
      DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
      Connection conn = dataSource.getConnection();
      ```
***
# 六、DbUtils 开源组件

1. 使用步骤

  - 导入jar包（commons-dbutils-1.4.jar）

  - 创建一个QueryRunner类 （QueryRunner作用：操作sql语句）

    new QueryRunner(DataSource ds)

  - 编写sql语句   (带？的用于预编译的sql语句)

  - 执行sql语句

    使用QueryRunner里的方法：query(...):执行查询操作；update(...): 执行增删改操作

2. JavaBean的介绍

  - 需要实现接口：java.io.Serializable ，通常实现接口这步骤省略了，不会影响程序

  - 提供私有字段：private 类型 字段名   该类中的成员变量与数据库表中的字段相对应

  - 提供公共的getter/setter方法

  - 提供无参构造方法

3. QueryRunner类

  - 用于操作sql语句

  - 构造器（构造方法）

    ```
    QueryRunner qr = new QueryRunner();   //手动提交事务
    QueryRunner  qr = new QueryRunner(DataSource ds);  //自动提交事务
    ```

  - 常用方法

    ```
    //增删改
    update(String sql,Object... params)
    update(Connection conn, String sql, Object... params)
    //查
    query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params)
    query (String sql,ResultSetHandle<T> rsh )
    ```

  - 注意：QueryRunner类底层已经帮助我们创建了连接，创建了语句执行者，释放资源。

4. ResultSetHandler结果集处理类

  - ArrayHandler：将结果集中的第一条记录封装到一个Object[]数组中，数组中的每一个元素就是这条记录中的每一个字段的值

  - ArrayListHandler：将结果集中的每一条记录都封装到一个Object[]数组中，将这些数组再封装到List集合中

  - BeanHandler：将结果集中第一条记录封装到一个指定的JavaBean中

  - BeanListHandler：将结果集中每一条记录封装到指定的JavaBean中，将这些JavaBean在封装到List集合中

  - ColumnListHandler：将结果集中指定的列的字段值，封装到一个List集合中

  - ScalarHandler：针对聚合函数，它是用于单数据。MySQL返回的是Long类型的值，Oracle数据库返回的是BigDecimal类型的数值

  - MapHandler：将结果集第一行封装到Map集合中,Key 列名, Value 该列数据

  - MapListHandler：将结果集第一行封装到Map集合中,Key 列名, Value 该列数据,Map集合存储到List集合

  - KeyedHandler：将结果集中指定的key的值封装到一个Map集合中

***