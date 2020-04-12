# 一 、JDBC中的批处理

1. 批处理：一次性发送多条sql，批量执行sql语句就是批处理。

2. 静态批处理：Statement stat = conn.createStatement();

  - 步骤

    ```
    1 装载SQL代码：stat.addBatch(SQL语句);
    2 批量执行：stat.executeBatch();
    ```

3. 预编译批处理：PreparedStatement stat = conn.preparedStatement(sql);

  - 步骤

    ```
    1 设置参数
    2 装载SQL代码：prep.addBatch();
    3 批量执行：prep.executeBatch();
    ```

4. 注意：在连接Oracle数据库时调用prep.executeBatch()方法返回值-2的数组，连接MySQL数据库时调用该方法返回值是1的数组；executeBatch方法是提交批处理的命令，返回一个整形数组int[]，数组中的每个数字对应一条命令的影响行数，在Oracle的驱动中没有实现该功能，即提交成功后不能返回影响行数，所以返回-2。在JDBC的规范中Statement.SUCCESS_NO_INFO(-2)代表：执行成功，受影响行数不确定

5. “预编译批处理”和“静态批处理”的区别和各自的优势

  - 静态批处理优势：可以处理不同的SQL语句和相同类型的SQL语句

  - 预编译批处理优势：处理相同的SQL语句时效率高
***
# 二、JDBC调用存储过程和存储函数

1. 使用原因：为了数据安全，不把SQL语句暴露在 Java 代码中。将SQL代码包装在存储过程中。在 Java 中调用存储过程。

2. 好处

  - 数据比较安全

  - SQL语句是在数据库中存放的，执行的时候少了编译的过程，速度较快

3. 使用步骤

  - 编写SQL语句

    ```
    //存储过程
    String sql = "{CALL myproc(?,?,?)}"；
    //存储函数
    String sql = "{?=CALL myproc(?,?)}"；
    ```

  - 建立 CallableStatement 语句发送对象

    ```
    CallableStatement callstatment = conn.prepareCall(sql);
    ```

  - 设置传入参数和传出参数

    ```
    in	参数：callstatment.setXxx(index,values);
    out 参数：callstatment.registerOutParameter(index,sqlType);
    ```

  - 执行

    ```
    callstatment.execute();
    ```

  - 获取返回值

    ```
    callstatment.getType(index);
    //若是调用带out参数（返回游标类型）的存储过程
    ResultSet rs=((OracleCallableStatement)callst).getCursor(index);
    while(rs.next()){

    }
    ```

***