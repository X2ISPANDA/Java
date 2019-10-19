# JDBC

> ​	JDBC（Java Database Connectivity）,即 Java 数据库连接。JDBC是Oracle公司制定的一套规范（一套接口）。它是一个连接独立数据库的标准Java API，用于Java编程语言和广泛的数据库之间的连接。其主要作用是建立 Java 程序及数据库的桥梁，实现 Java 和 数据库数据的传递。

## 特性

1. 跨平台
2. 跨数据库

## 常用API

> 所在包:java.sql或javax.sql

- DriverManager

  >  public static Connection getConnection(String url,
  >                                        String user,
  >                                        String password)

  url: 

  - mysql:  jdbc:mysql://localhost:3306/数据库名称
  - Oracle: jdbc:oracle:thin@localhost:1521@实例

- Connection

- Statement

- PreparedStatement

- ResultSet

## 操作步骤

1. 注册驱动
2. 获取连接
3. 编写SQL语句
4. 创建SQL语句的执行者
5. 设置参数
6. 执行SQL
7. 遍历结果集
8. 释放资源