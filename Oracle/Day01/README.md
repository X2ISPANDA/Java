# Oracle

> 注意:oracle用的是单引号,mysql单引号双引号都行
>
> --表示注释.

## 数据字典

> Oracle的数据字典是Oracle数据库安装之后，自动创建的一系列数据库对象。数据字典是Oracle数据库对象结构的元数据信息。熟悉和深入研究数据字典对象，可以很大程度的帮助我们了解Oracle内部机制。

- user_对象视图：描述了当前用户schema下的对象；
- all_对象视图：描述了当前用户有权限访问到的所有对象的信息；
- dba_对象视图：包括了所有数据库对象的信息；

一、数据字典也就是系统表，存放数据库相关信息的表。

1、数据字典是每个Oracle数据库的核心
2、用于描述数据库和它的所有对象
3、包括了只读的表和视图
4、被SYS用户拥有
5、被Oracle Server 维护
6、用户可以使用SELECT访问

 二、 Oracle数据字典的名称由前缀和后缀组成，使用下划线“_”连接，其代表的含义如下：
（1）DBA_：包含数据库实例的所有对象信息。
  (2) V$_：当前实例的动态视图，包含系统管理和系统优化等所使用的视图。
  (3) USER_：记录用户的对象信息。
  (4) GV_：分布式环境下所有实例的动态视图，包含系统管理和系统优化使用的视图。
  (5) ALL_：记录用户的对象信息机被授权访问的对象信息。

三、常用的数据字典：
dba_tablespaces  关于表空间的信息
dba_ts_quotas   所有用户表空间限额
dba_free_space  所有表空间中的自由分区
dba_segments  描述数据库中所有段的存储空间
dba_extents  数据库中所有分区的信息
dba_tables   数据库中所有数据表的描述
v$database  描述关于数据库的相关信息
v$datafile  数据库使用的数据文件信息
v$log      从控制文件中提取有关重做日志组的信息
v$logfile   有关实例重置日志组文件名及其位置的信息

## ORACLE体系结构

1. 物理存储结构

2. 逻辑存储结构

   Oracle数据库由多个表空间组成，而表空间又由多个段组成，段由多个数据区组成，数据区又由多个数据块组成。

3. 数据字典

## Oracle数据库基本操作

- 登录Oracle数据库

  `SQLPLUS 用户名/密码 (AS SYSDBA);`

- 为用户解锁并更改设置用户密码

  `ALTER USER hr ACOUNT UNLOCK;`

  `ALTER USER hr IDENTIFIED BY oracle;`

- 用户的创建管理与删除

  - CREATE USER myuser IDENTIFIED BY *** DEFAULT TABLESPACE users;
  - GRANT ... TO ... ＆ REVOLKE ... FROM ... 
  - DROP USER myuser CASCADE;
  
- 查看用户下有哪些表
  
  `SELECT * FROM tab;`
  
  `SELECT table_name FROM user_tables;`
  
  