# 一 、PreparedStatement预编译

1. sql注入问题

    Statement是的SQL语句是使用字符串拼接实现的，当在WHERE子句后面添加了OR 1 = 1后，其他条件将会失效，这样回引发数据的泄露。

2. 如何防止sql注入

    使用PreparedStatement对SQL语句进行“预编译”

3. 预编译的优势有哪些？

  -  预先进行SQL语句的编译，对于同类SQL多次执行，速度要更快

  -  不会出现因“SQL拼接”出现的错误

  - 可防止sql的注入问题

4. 使用PreparedStatement“预编译”的步骤

  - 注册JDBC驱动程序（加载驱动）

  - 建立数据库连接

  - 准备sql语句

    ```
    String sql = "UPDATE t_user SET username=?,password=? WHERE userid=?";
    ```

  - 准备预编译sql语句的发送对象,对sql预编译

    ```
    prep = conn.prepareStatement(sql);
    ```

  - 设置参数，通过预编译对象赋值

    ```
    prep.setString(1, "刘德华");
    prep.setString(2, "123456");
    prep.setInt(3, 2);
    ```
  - 执行sql语句

    ```
    //预编译后，executeUpdate()里面不能再使用sql作参数了
    int res = prep.executeUpdate();
    ```

  - 执行结果及数据处理

  - 释放资源

5. 使用JDBC完成分页查询

  - Oracle

    ```
    SELECT *
    FROM (SELECT rownum rn , t.*
      FROM  （SELECT * FROM 表名 ORDER BY 字段）t)  
    WHERE rn>pageSize*(currPage-1) AND rn<=pageSize*currPage;

    currPage :第几页
    pageSize:一页显示多少条记录
    ```

  - MySQL

    ```
    //查看从(currPage-1)*pageSize后一条记录开始往后的pageSize的记录
    SELECT * FROM t_test LIMIT (currPage-1)*pageSize, pageSize;

    SELECT * FROM t_test LIMIT 20; //查看前20条信息
    ```
***
# 二 、数据库信息持久化到DB.properties配置文件中

* 读取DB.properties配置文件的两种方式

  - 方式一

    ```
    //1、创建Properties对象
    Properties prop = new Properties();
    //2、创建输入流对象
    InputStream is = new FileInputStream("src/DB.properties");
    //3、将is加载到prop里
    prop.load(is);
    //4、获取Properties属性集合里的属性值
    String driverName = prop.getProperty("driverName");
    String url = prop.getProperty("url");
    String user = prop.getProperty("user");
    String password = prop.getProperty("password");
    ```

  - 方式二

    ```
    //使用ResourceBandle读取DB.properties文件
    //DB.properties配置文件必须放在src下面，读的时省略后缀名.properties
    bundle = ResourceBundle.getBundle("DB");
    //获取属性值
    String driverName = bundle.getString("driverName");
    String url = bundle.getString("url");
    String user = bundle.getString("user");
    String password = bundle.getString("password");
    ```
***

# 三  、JDBC中的事务处理

1. 事务的用法

  - 强制禁用掉 Java程序自动提交功能 conn.setAutoCommit(false);

  - 当所有代码执行成功时提交 conn.commit();

  - 当程序出问题时回滚 conn.rollback();

  - 设置事务隔离级别 conn.setTransactionIsolation

2. 隔离级别参数说明

  - TRANSACTION_READ UNCOMMITED（读取未提交内容）

    在该隔离级别，所有事务都可以看到其他未提交事务的执行结果。本隔离级别很少用于实际应用，因为它的性能也不比其他级别好多少。读取未提交的数据，也被称之为脏读（Dirty Read）

  - TRANSACTION_READ_COMMTIED（读取提交内容）

    这是大多数数据库系统的默认隔离级别（但不是MySQL默认的）。它满足了隔离的简单定义：一个事务只能看见已经提交事务所做的改变。这种隔离级别 也支持所谓的不可重复读（Nonrepeatable Read），因为同一事务的其他实例在该实例处理其间可能会有新的commit，所以同一select可能返回不同结果

  - TRANSACTION_REPEATABLE_READ（可重读）

    这是MySQL的默认事务隔离级别，它确保同一事务的多个实例在并发读取数据时，会看到同样的数据行。不过理论上，这会导致另一个棘手的问题：幻读 （Phantom Read）。简单的说，幻读指当用户读取某一范围的数据行时，另一个事务又在该范围内插入了新行，当用户再读取该范围的数据行时，会发现有新的“幻影” 行。InnoDB和Falcon存储引擎通过多版本并发控制（MVCC，Multiversion Concurrency Control）机制解决了该问题

  - TRANSACTION_SERIALIZABLE（可串行化）

    这是最高的隔离级别，它通过强制事务排序，使之不可能相互冲突，从而解决幻读问题。简言之，它是在每个读的数据行上加上共享锁。在这个级别，可能导致大量的超时现象和锁竞争

***