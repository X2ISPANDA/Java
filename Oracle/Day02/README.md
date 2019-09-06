# SQL

*结构化查询语言(Structured Query Language)*

RDBMS关系型数据库管理系统(Relational Database Management System)

## SQL语言分类

- DDL（Data Define Language）数据定义语言
- DML（Data Manipulation Language）数据操纵语言
- DQL（Data Query Language）数据查询语言
- DCL（Data Control Language）数据控制语言
- TCL(Transaction Control Language）事务控制语言

**SQL语句的执行过程**

![1567303931124](C:\Users\XMY\AppData\Roaming\Typora\typora-user-images\1567303931124.png)

## 常用数据类型

- CHAR(size) 定长字符串	
- VARCHAR2(size)变长字符串
- NUMBER数值类型
- DATE 日期类型
- BLOB大数据类型
- CLOB大数据类型

## SQL编码规则

- 命名规则

  > 命名规则注意事项：
  > 1、必须以字符开头, 不能以数字开头
  > 2、只能包含A-Z,a-z,0-9,_,$,#
  > 3、长度不超过30个字符
  > 4、不要使用Oracle的保留字
  > 5、同一用户下的对象不能同名
  > 6、有意义易于理解
  >
  > 为了提高程序可读性，除了满足上面命名规则外，建议按照下面规则命名：
  > 1、项目系统模块以公司名称缩写开头，例如：YCKJ_
  > 2、数据库表名以 t_为前缀命名，_例如：t_student ；
  > 3、对于有主明细的表来说。明细表的名称为：主表的名称 + 字符Dts。例如：采购定单的名称为：PO_order，则采购定单的明细表为：PO_orderDts
  > 4、字段（列名）要命名有意义，例如
  >   name, sex等
  > 5、约束名以 pk_,fk_, en_, ck_ ,nn_为前缀
  > 主键约束以pk_为前缀，外键约束以fk_为前缀，唯一约束以en_为前缀，检查约束以ck_为前缀，非空约束nn_为前缀
  > 6、视图以view_作为前缀，例如：
  > view_emp
  > 7、序列以seq_为前缀,例如：
  >  seq_test
  > 8、索引以index_为前缀，例如：
  >   index_stu_cno
  > 9、触发器以trigger_为前缀,例如：
  >   trigger_emp

- 书写规则

  > 为了提高程序的可读性和性能，Oracle建议用户按照以下书写规则编写代码：
  > 1、SQL的所有关键字采用大写格式，例如CREATE 、SELECT  、UPDATE、INSERT INTO等
  >
  > 2、数据类型采用大写格式，例如NUMBER、VARCHAR2、DATE等
  >
  > 3、Oracle常用函数名称采用大写格式
  >
  > 4、数据表和列名采用小写格式，例如：t_emp、sal、ename等
  >
  > 5、视图、序列、索引、触发器等数据库对象的名称采用小写，例如view_emp 、emp_deptno_index
  > 6、约束名称采用小写，例如：fk_emp_deptno
  > 7、SQL语句以分号;结尾。

## 约束

- 主键约束

  a. 唯一标识表中的某一条记录，相当于非空+唯一，用PRIMARY KEY表示

  b. 一个表中只能有一个主键，可以由一个字段表示，也可以由多个字段联合组成

  c. 如果采用联合主键时，每个字段都不能为空。

- 非空约束

- 唯一约束

- 条件约束

- 外键约束

**创建表约束**

- 列级约束

  在每列定义完后马上定义的约束，在逗号之前就定义好了。不可以定义联合主键。

- 表级约束

**增加或修改约束**

`ALTER TABLE 表名 ADD CONSTRAINT 约束名 PRIMARY KEY(主键列名)`

`ALTER TABLE 表名1 ADD CONSTRAINT 约束名 FOREIGN KEY(外键列名) REFRENCES 表名2(主键名)`

**删除约束**

1. 找出你需要删除的约束的名字

`SELECT  constraint_name,constraint_type 
FROM  user_constraints 
WHERE table_name='T_STUDENT2';`

2. 删除约束

`ALTER TABLE 表名 DROP  CONSTRAINT 约束名称;`

**修改数据表**

`ALTER TABLE table_name
ADD(列名1  数据类型（长度），列名2  数据类型（长度） ...);`

`ALTER TABLE table_name
DROP COLUMN 列名;`或者`ALTER TEBLE table_name DROP(列名);`

`RENAME table_name TO new_table_name;`

**删除数据表**

`DROP TABLE table_name;`

`删除回收站里的信息 PURGE TABLE <table_name>;`

`彻底删除 DROP TABLE table_name PURGE;`

TRUNCATE TABLE table_name;

> DROP和TRUNCATE的区别
>
> DROP TABLE :
> 表中所有数据将被删除
> 1、没有完成的事务被提交
> 2、表的结构、属性以及索引也会被删除
> 3、删除的表有时候是可以闪回的
> FLASHBACK TABLE  t_student TO BEFORE DROP;
>
> TRUNCATE  TABLE:
> 1、表中所有数据将被删除,但是表结构还在。
> 2、数据所占用的存储空间会被释放。其他索引等所有一些表空间不会被释放，如果要被释放 使用TRUNCATE TABLE 表名  DROP STORAGE
> 3、运行后会自动提交，包括之前其它未提交的会话，因而一旦清空无法回退。
> 只有表格的创建者或者其他拥有删除任意表格权限的用户（如DBA）才能清空表格。

## DML数据操纵语言

- 插入数据

  INSERT INTO table_name VALUES(值1,值2,...);

  INSERT INTO 表名 （字段名1，字段名2，字段名3，字段名4） VALUES（值1，值2，值3，值4）；

  COMMIT

  默认值DEFAULT如果有默认值，就会使用默认值；如果没有默认值就使用NULL

- 修改更新数据
  - 更新单列 UPDATE 表名 SET 字段名 = 新值; 
  - 更新多列 UPDATE  表名 SET 字段名1 = 新值1，字段名2 = 新值2，字段名3 = 新值3;
  - 更新指定记录 UPDATE 表名 SET 字段名 = 新值 WHERE  条件;
- 删除数据
  - 删除所有记录 DELETE FROM 表名;
  - 删除指定记录 DELETE FROM 表名 WHERE 条件;

## 序列

`CREATE SEQUENCE <sequencen_name> 
INCREMENT BY n
START WITH n
[MAXVALUE n][MINVALUE n]
[CYCLE|NOCYCLE]
[CACHE n|NOCACHE];`

**序列的使用**

序列名 . currval     获取当前序列号返回序列的当前值.

注意在刚建立序列后,序列的CURRVAL值为NULL，所以不能直接使用。
需要先初始化序列:
方法:SELECT  <sequence_name>.nextval FROM  dual;
示例:SELECT  t_seq.nextval FROM dual;
之后就可以使用CURRVAL属性了
序列名 . nextval 获取下一个序列值 

**删除序列**

DROP SEQUENCE 序列名称;

## TCL事务控制语言

> 事务是对数据库操作的逻辑单位，在一个事务中可以包含一条或多条DML （数据操纵语言）这些语句组成一个逻辑整体。

- 提交事务 COMMIT
- 回滚 ROLLBACK
- 保存点 SAVEPOINT 

## 事务的特性

事务的特性ACID：
1、原子性（Atomicity):事务必须是原子工作单元，对于其数据修改，要么全部执行，要么全都不执行。
2、一致性（Consistency):事务在完成时，必须使所有的数据都保持一致状态。
3、隔离性(Isolation):由并发事务所作的修改必须与任何其它并发事务所作的修改隔离。
4、持久性（Durability):事务完成之后，它对应系统的影响是永久性的。


在企业应用中，多个事务并发所可能存在的问题如下：
1. 脏读：一个事务读到另一个事务未提交的更新数据。
2.不可重复读：一个事务两次读同一行数据，可是这两次读到的数据不一样。
3.幻读：一个事务执行两次查询，但第二次查询比第一次查询多出了一些数据行。
4.丢失更新：撤销一个事务时，把其他事务已提交的更新的数据覆盖了。