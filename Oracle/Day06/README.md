### 一、子查询相关知识

#### 1.定义

子查询是指插入在其他SQL语句中的SELECT语句，也称为嵌套查询。

#### 2.使用子查询的场合

 - 当要显示的数据在表里并不存在，但可以通过对已有数据的加工获得，可通过子查询实现。

 - 子查询可以出现在SELECT、WHERE子句、FROM子句、DML语句、DDL语句中。

 - 在SELECT、INSERT、UPDATE或DELETE命令中允许是一个表达式的地方都可以包含子查询，子查询甚至可以包含在另外一个子查询中。

#### 3.编写思路

 - 仔细分析题目，确定要查询的表及字段（数据）

 - 分析要查询的字段（数据）哪些在表里直接存在，哪些不存在

 - 考虑如何把要显示的数据造出来（通过查询语句获得）

 - 考虑子查询与表的连接点是什么(通常是主外键、共有字段)

 - 考虑子查询放在什么位置

 - 组合成完整的SQL语句

### 二、按照子查询所在位置

#### 1.在查询条件中使用子查询

##### （1）单行子查询：子查询只返回一行。

 - 在WHERE子句中的单行子查询
```
1、子查询与主查询使用同一张表：
任务一：查询与SCOTT在同一部门的员工的姓名，薪水。
    SELECT ename,sal
    FROM emp
    WHERE deptno=(SELECT deptno FROM emp WHERE ename='SCOTT');
2、子查询与主查询不是使用的同一张表：
任务二：查询部门名称为"RESEARCH"的员工信息(显示员工号，姓名，职位)。
    SELECT empno,ename,sal
    FROM emp
    WHERE deptno = (SELECT deptno FROM dept WHERE dname='RESEARCH');
```

 - 在HAVING子句中的单行子查询
```
任务：在SCOTT用户模式下查询出各部门员工的平均工资低于各部门最高平均工资的部门号和部门的平均工资。
    SELECT deptno,AVG(sal) avgsal
    FROM emp
    GROUP BY deptno
    HAVING  AVG(sal)<( SELECT  MAX(AVG(sal)) FROM emp GROUP BY deptno);
```

 - 容易遇到的错误
```
1、因为WHERE条件限定不规范而返回多行，就会出现单行子查询返回多行的错误。
2、子查询中不能包含ORDER BY 子句，相反任何排序都必须在外部查询中完成。
```

##### （2）多行子查询：子查询返回多行。

 - 多行子查询中使用IN操作符
```
任务一.列出薪金与30号部门员工的薪金相同的所有员工的姓名和薪金。
    SELECT ename,sal
    FROM emp
    WHERE sal IN (SELECT sal FROM emp WHERE deptno = 30);
标准嵌套子查询多层嵌套案例：
任务二.列出薪水与销售部门的员工薪水相同的所有员工的姓名和薪金。
    SELECT ename,sal
    FROM emp
    WHERE sal  IN (SELECT sal FROM emp WHERE deptno =   
    (SELECT   deptno  FROM dept WHERE  dname = 'SALES'));
```

 - 多行子查询中使用ANY操作符：<ANY 比任何一个值都小，>ANY 比任何一个值都大
，=ANY 等效于IN。
```
任务：在emp表中，查询工资大于部门编号为10的任意一个员工工资的其他部门的员工信息。
    SELECT deptno,ename,sal
    FROM emp
    WHERE sal>ANY(SELECT sal FROM emp WHERE deptno=10)
    AND deptno<>10;
```

 - 多行子查询中使用ALL操作符：<ALL 比最小值小，>ALL 比最大值大，<>ALL等效于NOT IN
```
任务：显示工资大于所有部门平均工资的雇员姓名,工资
    SELECT  ename,sal
    FROM emp  
    WHERE  sal>ALL（SELECT AVG(sal) FROM emp GROUP BY deptno);
```

 - 子查询中使用EXISTS操作符：用于检查子查询返回行的存在性。如果子查询返回一行或者多行，EXISTS返回TRUE;如果子查询未返回行，EXISTS返回FALSE。
```
任务：查询在“SALES"销售部门的所有员工信息。
    SELECT  * FROM emp e WHERE  EXISTS (
    SELECT deptno FROM dept d WHERE e.deptno = d.deptno AND d.dname='SALES');
```

##### （3）多列子查询：子查询返回多列。
```
任务：在SCOTT用户模式下查询显示和ALLEN同部门同职位的员工姓名、职位、部门编号
    SELECT  ename,job,deptno
    FROM emp
    WHERE (deptno,job)=(SELECT deptno,job
    FROM emp WHERE ename = 'ALLEN');
```

##### （4）关联子查询

 - 内查询与外查询是相互关联的。

 - 内查询的执行需要借助于外查询，而外查询的执行又离不开内查询的执行。

 - 例子：
```
任务： 在emp表中，使用“关联子查询”检索工资大于同职位的平均工资的员工信息(显示字段：员工编号，姓名，工资）。
    SELECT empno,ename,sal
    FROM emp e
    WHERE  sal>(SELECT AVG(sal) FROM emp WHERE job=e.job);
```

#### 2.在建表语句中使用子查询

 - 表的复制:
```
    CREATE TABLE 表名 AS SELECT 语句;
```

 - 只复制表结构
```
    CREATE TABLE 表名1 AS SELECT 字段名 FROM 表名 WHERE 条件;
    CREATE TABLE emp2 AS SELECT empno,ename,deptno FROM emp WHERE 1=2;
```

 - 表结构和数据一起复制
```
    CREATE TABLE 表名1	AS SELECT 字段名 FROM 表名;
    CREATE TABLE emp1 as SELECT empno,ename,deptno FROM emp;
```

#### 3.插入语句中（在INSERT语句中使用子查询）

 - 在插入语句中使用子查询：
```
    INSERT INTO 表名(字段列表) [SELECT 字段名 FROM 表名 WHERE..];
    INSERT INTO emp2 SELECT empno,ename,deptno FROM emp WHERE deptno=30;
```

 - 使用INSERET SELECT 语句可以将一个数据表中的数据插入到另一个新的数据表中，插入时要注意以下几点：
```
1、必须保证插入的表已经存在。
2、对于插入新数据的表，各个需要插入数据的列与类型必须与源数据表中各列数据类型保持一致。
3、必须明确是否存在默认值，是否允许为NULL值，如果不允许为空，则必须在插入的时候，为这些列提供列值。
```

 - 注意：插入表的字段个数和类型与SELECT语句中的字段个数和类型要匹配

#### 4.更新语句中（在UPDATE语句中使用子查询）

 - 语法：
```
    UPDATE 表名 SET 字段1 = (SELECT  语句）；
```

 - 例子：
```
任务：将emp1表里JAMES的职位，薪水，奖金更改为和SCOTT一样的职位，薪水，奖金。
    UPDATE emp SET ( job,sal,comm)=(
    SELECT job,sal,comm FROM emp WHERE ename='SCOTT')
    WHERE ename='JAMES';
```

#### 5.删除语句中（在DELETE语句中使用子查询）

 - 语法
```
    DELETE FROM 表名;
```

 - 例子：
```
任务：删除部门名称是'SALES' 的所有员工，用emp1。
    DELETE FROM emp WHERE deptno=(
    SELECT deptno FROM dept WHERE dname='SALES');
```

#### 6.在SELECT中使用子查询
```
任务：统计出有奖金和没有奖金的人数
    SELECT
    (SELECT count(comm) FROM emp WHERE comm!=0) A,(
    SELECT count(comm) FROM emp WHERE comm=0 AND comm is not null) B
    FROM emp;
```

#### 7.分页查询

 - 当前页，每页显示的条数 rownum 只能用<或者<=；

 - 假设每页最多显示m条，第n页的记录范围(m*(n-1) ,m*n]；

 - 例子1：
```
任务：员工表emp中有14条记录，假设分页显示，每页最多显示3条记录，显示第4页的记录。
    SELECT * FROM(
    SELECT e.*,rownum rn FROM emp) a
    WHERE a.rn>9 AND a.rn<=12;
```

 - 原因：最外层和中间层嵌套是因为rownum的特性，只能使用<或<=的特性。

 - 中间层和最里层的嵌套是因为SQL语句的执行顺序，先进行排序，在出现rownum，否则num是乱序。

 - 例子2：
```
任务：员工表emp中有14条记录，并按工资降序排序，假设分页显示，每页最多显示3条记录，显示第4页的记录。
    SELECT b.* FROM(
    SELECT a.*,rownum rn FROM(
    (SELECT deptno FROM emp WHERE sal DESC)a)b
    WHERE b.rn>9 AND b.rn<=12;
```

 - Oracle分页：最里层写排序，中间层出现rownum，最外层查询从第几条到第几条。

#### 8.FROM子句中使用子查询：同上

#### 9.使用子查询注意的事项

 - 要将子查询放入圆括号中。

 - 子查询可出现在WHERE子句、FROM子句、SELECT 列表（此处只能是一个单行子查询）和HAVING子句,DDL,DML中。

 - 子查询不能出现在主查询的GROUP BY语句中

 - 子查询和主查询可以使用不同表，只要子查询返回的结果能够被主查询使用即可。

 - 单行子查询只能使用单行操作符，多行子查询只能使用多行操作符。

 - 在多行子查询中，ALL和ANY操作符不能单独使用，而只能与单行比较符（=、<、>、<=、>=、<>)结合使用。

 - 要注意子查询中的空值问题。如果子查询返回了一个空值，则主查询将不会查询任何结果。

 - 子查询允许嵌套多层，但不能超过255层。

### 三、索引
#### 1.定义
类似“目录”，给一张表添加了一个目录。
#### 2.索引的作用
 - 为了提高查询效率
 - 通过快速定位数据的方法，减少磁盘I/O操作
#### 3.索引的创建
 - 语法
```
    CREATE INDEX 索引名称 ON 表名（字段1，字段2）;
```
 - 例子
```
任务： 给员工表的字段（部门号）创建索引。
    CREATE INDEX emp_index ON emp (deptno);
```
#### 4.索引的删除
 - 语法
```
    DROP INDEX 索引名称;
    DROP INDEX emp_index;
```
 - 为了删除索引,必须拥有索引或者拥有 DROP ANY INDEX 权限.
