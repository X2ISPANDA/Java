### 一、DML数据操纵语言

#### 1.插入数据--INSERT操作

 - 默认输入一条完整记录，并且输入值的顺序和表的字段顺序一致
```
格式1：INSERT INTO 表名 VALUES（值1，值2，值3，值4……）；
例子1：INSERT INTO t_class VALUES('1001','计科一班');
注意：字符串和日期类型需要用单引号；
```

 - 输入一条不完整的记录，就需要明确的指定出字段名和值，并且前后顺序一致
```
格式2：INSERT INTO 表名（字段名1，字段名2，字段名3，字段名4）VALUES（值1，值2，值3，值4）；
例子2：INSERT INTO t_student1(sno,sname,cno) VALUES ('7','zs','1003');
```
 - 在插入中使用默认值DEFAULT
```
INSERT INTO t_student(sid,sname,sex) VALUES('1001','zs', DEFAULT);
```

#### 2.修改更新数据--UPDATE操作
 - 格式1—更新单列：（更新了所有行的某一列）
```
  UPDATE 表名 SET 字段名 = 新值;
  UPDATE t_class SET cname = '3班';
```
 - 格式2—更新多列：
```
  UPDATE  表名 SET 字段名1 = 新值1，字段名2 = 新值2，字段名3 = 新值3;
  UPDATE t_class SET cname = '3班',cno = '1';
```
 - 格式3—更新指定记录：
```
 UPDATE 表名 SET 字段名 = 新值 WHERE  条件;
 UPDATE t_student1 SET sname='张三丰',age=20 WHERE age=18;
```

#### 3.删除数据--DELETE操作
 - 格式1—删除所有记录：
```
  DELETE FROM 表名;
  DELETE FROM t_student1;
```
 - 格式2—删除指定记录：
```
  DELETE FROM 表名 WHERE 条件;
  DELETE FROM  t_student1 WHERE sno = '1001';
```
 - 当对表的所有行全部删除时，除了DELETE操作之外，还可以使用TRUNCATE TABLE
```
  TRUNCATE TABLE 表名;
  TRUNCATE TABLE t_student1;
```

#### 4.TRUNCATE和DELETE的区别：

 - 相同点：DELETE与TRUNCATE都可以删除表里数据,删除数据后表结构还在；

 - 不同点：TRUNCATE TABLE属于DDL语言，自动提交；而DELETE FROM属于DML语言，需要COMMIT提交；

 - DELETE可以带WHERE条件删除指定记录，但是TRUNCATE不可以删除指定记录，而是全部删除；

### 二、TCL事务控制语言
#### 1.定义

 - TCL（Transaction Control Language）事务控制语言用于维护数据的一致性，包括COMMIT、ROLLBACK和SAVEPOINT 语句。

 - COMMIT语句用于提交对数据库的更改

 - ROLLBACK语句用于取消对数据库的更改

 - SAVEPOINT语句则用于设置保存点

#### 2.事务
 - 定义：事务是对数据库操作的逻辑单位，在一个事务中可以包含一条或多条DML （数据操纵语言）这些语句组成一个逻辑整体。
 - 在关系数据库中，一个事务可以是一条SQL语句，一组SQL语句或整个程序。
 - 事务是恢复和并发控制的基本单位。

#### 3.事务的操作
 - COMMIT提交事务：提交事务时，对数据库所做的修改便永久写入数据库。
```
INSERT INTO t_test VALUES(9,'Mary', ’女’);
COMMIT;
```
 - ROLLBACK回退（回滚）事务:回滚事务时，对数据库所做的修改全部撤销，数据库恢复到操作前的状态。
```
例如：当执行删除事务后如果想撤销之前的操作，就可以回滚。
UPDATE t_test SET tname = 'huangjiang' WHERE tid = 15;
ROLLBACK;
```
 - 保存点(SAVEPOINT)：是事务过程中的一个逻辑点，我们可以把事务回退到这个点，而不必回退整个事务。

#### 4.事务的特性ACID：

 - 原子性（Atomicity):事务必须是原子工作单元，对于其数据修改，要么全部执行，要么全都不执行。

 - 一致性（Consistency):事务在完成时，必须使所有的数据都保持一致状态。

 - 隔离性(Isolation):由并发事务所作的修改必须与任何其它并发事务所作的修改隔离。

 - 持久性（Durability):事务完成之后，它对应系统的影响是永久性的。

#### 5.在企业应用中，多个事务并发所可能存在的问题如下：

 - 脏读：一个事务读到另一个事务未提交的更新数据。

 - 不可重复读：一个事务两次读同一行数据，可是这两次读到的数据不一样。

 - 幻读：一个事务执行两次查询，但第二次查询比第一次查询多出了一些数据行。

 - 丢失更新：撤销一个事务时，把其他事务已提交的更新的数据覆盖了。

### 三、基本查询语句
#### 1.查询所有/指定字段
 - 查询所有字段语句语法：
```
  SELECT * FROM table_name;
  SELECT * FROM t_student1;
```
 - 查询指定字段语句语法：
```
  SELECT 字段1 ，字段2，字段3... FROM table_name;
  SELECT sno,sname FROM t_student1;
```

#### 2.查询列表中使用算术表达式

 - SELECT 语句中算术运算符+、-、* 、/四个算术运算符

 - 对于Date型数据可以使用+、-运算符
```
  查询员工信息：员工号 姓名 月薪 年薪
  SELECT ename , sal, 12*sal FROM emp;
  查询员工信息：员工号 姓名 月薪 年薪 奖金 年收入
  SELECT empno,ename,sal,sal*12,comm,sal*12+comm FROM emp;
```

#### 3.空值NULL的使用要注意:

 - NULL是未知的、不存在、不确定、不可用、未分配的值。

 - 空值不等于零或空格，NULL与空字符串不同，因为空值是不存在的值，而空字符串是长度为0的字符串。

 - 任意类型都可以支持空值。

 - 因为空值代表未知的值，所以并不是所有的空值都相等。所以不可以用“=”运算符来检查空值，要用is null和is not null。

 - 注意：数据库中，任何值和NULL做算术运算结果都为NULL，但是NULL与字符串使用“||”连接结果还是字符串。

#### 4.定义别名
 - 定义列的别名:
```
格式1：SELECT 某字段 AS 别名 FROM 表名；
格式2：SELECT 某字段 别名 FROM 表名；
例子：SELECT ename AS e, sal+ 400  AS newsal FROM emp;
```
 - 定义表的别名 (定义表别名不能用AS)
```
格式：SELECT 字段列表 FROM 表名  表别名；
注意：别名中有特殊字符（如：空格，大小写）时必须加双引号，例如“Salary”,"年薪"
  SELECT e.ename, e.job FROM emp e;
```

#### 5.连接符||

 - 可以连接数字、字符串、日期，例如：‘Hello’ || 'World'

 - 注意：NULL 和任何字符串拼接都是字符串本身

 - 注意：SQL中字符串和日期使用单引号。

```
例子：利用dual表连接字符串‘Hello’与‘World’并显示结果:
SELECT 'Hello'||'World' FROM dual;
```
#### 6.去掉重复行
 - DISTINCT的作用是去重，它可用来限制在查询结果显示不重复的记录，重复的记录就去掉了。
 - DISTINCT的作用范围是后面所有字段的组合。
```
例子：显示emp表中的job(职务）列，要求显示的“职务”记录不重复。
SELECT DISTINCT job FROM emp;
```

#### 7.指定过滤where条件语句

 - 在SELECT 语句中使用WHERE子句可以实现对数据行的筛选操作，只有满足WHERE子句判断条件的行才会显示在结果集中，而那些不满足WHERE子句判断条件的行则不包括在结果集中。
```
基本语法：
SELECT  select_list
FROM   table_name
WHERE  search_condition;
先执行FROM,再执行WHERE,最后执行SELECT
```

 - 注意：WHERE子句中不可以用列的别名。

 - 对于字符串：用单引号' '表示字符串并且严格区分大小写。

#### 8.使用算术比较运算符比较筛选

 - 比较运算符包括:=、>、<、>=、<=、<> (或!=)不等于

 - 两个特殊的“比较筛选”操作：

```
1.any(a,b)两者中的任意一个；
例子1：查询员工工资等于1500或3000的员工记录，显示这些员工的员工号，姓名，工资。
SELECT empno,ename,sal FROM emp WHERE sal = ANY(1500,3000);
2.<>all()都不等于
例子2：使用ALL关键字过滤工资同时不等于3000、950和800的员工记录并显示这些员工的员工号，姓名，工资。
SELECT empno,ename,sal FROM emp WHERE sal <>ALL(3000,950,800);
```
#### 9.使用比较运算符筛选  

 - AND：如果组合的条件都是TRUE,返回TRUE；

 - OR：如果组合的条件之一是TRUE,返回TRUE；   

 - NOT：如果下面的条件是FALSE,返回TRUE；

 - AND优先级比OR的优先级高，如果要转换优先级要加括号；

#### 10.使用特殊关键字筛选

 - IN和LIKE，NULL，BETWEEN...AND前都可以加NOT表示否定的判断；

 - BETWEEN…AND… ：两个值之间包含边界，等价于……<= AND >=……

 - IN：和多个值的任何一个匹配

 - LIKE：匹配（用于模糊查询使用“%”和_进行字符匹配，% 表示零或更多任意的字符，_ 代表一个字符

 - IS NULL：是空值  

 - 注：查询条件可包含文字字符或数字：使用ESCAPE 转义
