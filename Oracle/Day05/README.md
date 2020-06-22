### 一、多表查询

#### 1.定义

 - 在查询时，需要涉及到两个以上表的查询。


#### 2.如何建立多表连接

 - 通过主键-外键连接。

 - 通过相同（相关）字段连接。

 - 注意：主键与外键名称必须相同吗？不是必须相同，习惯相同

 - 外键取值能为空吗？可以

#### 3.等值连接

 - 多张表的连接值相等，WHERE子句中写的多表连接的条件，用等号连接相同的两个字段。
```
表1.字段 = 表2.字段
```

 - 连接条件的个数有N-1个（N表示数据表的数目）

 - 例子：
```
任务1：查询所有员工所在的部门的员工姓名和部门名称。
    SELECT e.ename,d.dname
    FROM emp e, dept d
    WHERE e.deptno=d.deptno;
```
```
任务2：显示销售部('SALES')员工的姓名
    SELECT  ename
    FROM emp e, dept d
    WHERE e.deptno = d.deptno and d.dname='SALES';
```

#### 4.不等值连接

 - 多张表的连接值不相等，WHERE子句中写的多表连接的条件，使用除了等号以外的运算符连接多张表的连接值。

 - 在连接条件中可以使用的运算符有:>,<,<=,>= ,<>,BETWEEN...AND

 - 例子：
```
任务1：查询出员工的姓名，薪水及薪水等级。
    SELECT e.ename,e.sal,s.grade
    FROM emp e, salgrade s
    WHERE e.sal BETWEEN s.losal AND s.hisal;
```
```
任务2：查询工资等级处于第四级别的员工的姓名。
    SELECT e.ename
    FROM emp e,salgrade s
    WHERE s.grade=4 AND e.sal BETWEEN s.losal AND hisal;
```

#### 5.内连接

 - 内连接是一种多表关联查询方式，一般使用关键字INNER JOIN来实现。

 - 其中，INNER关键字可以省略，当只使用JOIN关键字时，语句只表示内连接操作。

 - 在使用内连接查询多个表时，必须在FROM子句之后定义一个ON子句，该子句用来指定两个表实现内连接的“连接条件”。

 - 需要注意的是，在内连接的检索结果中，所有记录行都是满足连接条件的。

 - 内连接的语法格式如下：
```
    SELECT column_list
    FROM table_name1  [INNER]  JOIN  table_name2
    ON join_condition;
```

 - 例子：
```
任务： 在SCOTT模式下，通过deptno字段来内连接emp表和dept表，并检索这两个表中员工编号，员工姓名，部门名称的信息。
    SELECT e.empno,e.ename,d.dname
    FROM emp e INNER OUTER JOIN dept d ON e.deptno=d.deptno;
```

#### 6.自连接

 - 定义：把一张表当成两张表用，自己和自己连接。给两张表取别名。

 - 语法：
```
    SELECT  select_list
    FROM  table_name  t1，table_name  t2
    WHERE  search_condition;
```

 - 例子：
```
任务：检索员工和所属领导的姓名。
    SELECT e1.ename,e2.ename
    FROM emp e1,emp e2
    WHERE e1.mgr=e2.ename;
```

#### 7. 外连接

##### 7.1 左外连接

 - 语法：
```
    SELECT  字段列表
    FROM
    表1  t1 LEFT OUTER JOIN  表2  t2  ON
    t1.字段 = t2.字段;
等价于
    SELECT  字段列表
    FROM  
    表1  t1  ， 表2  t2
    WHERE t1.字段 = t2.字段(+);附加一个条件
```

 - 注意： 在左外连接查询中，左表是主表，右表是从表。左外连接返回关键字LEFT JOIN左边的表中的所有行，但是这些行必须符合查询条件。如果左表中某数据行没有在右表中找到相应的匹配的数据行，则结果集中右表对应位置使用空值。

 - (+)：+ 表示补充，即哪个表有加号，这个表就是匹配表。如果加号写在右表，左表就是全部显示，所以是左连接。

##### 7.2 右外连接

 - 语法：
```
    SELECT  字段列表
    FROM
    表1  t1 RIGHT OUTER JOIN  表2  t2  ON
    t1.字段 = t2.字段;
等价于
    SELECT  字段列表
    FROM  
    表1  t1  ， 表2  t2
    t1.字段 (+)= t2.字段;
```

 - 注意：在右外连接查询中，右表是主表，左表是从表。右外连接返回关键字RIGHT JOIN右边的表中的所有行，但是这些行必须符合查询条件。如果右表中某数据行没有在左表中找到相应的匹配的数据行，则结果集中左表对应位置使用空值。

##### 7.3 完全外连接

 - 完全外连接的结果集中包括了左表和右表的所有记录。当某记录在另一个表中没有匹配记录时，则另一个表的相应列值为空。

 - 语法：
```
    SELECT 列名列表
    FROM  表名1 FULL [OUTER]  JOIN  表名2
    ON 表名1.列名 = 表名2. 列名;
```
```
任务：使用完全外连接统计每个部门的员工人数。
    SELECT  d.deptno,  count(e.empno)
    FROM  dept d FULL JOIN  emp  e
    ON   d.deptno = e.deptno
    GROUP BY d.deptno;
```

### 二、视图

#### 1. 定义

 - 视图是由一个或者多个表组成的虚拟表，视图本身并不包含数据，但是却像一个窗口，通过它可以查询或修改表中的数据。

 - 视图所基于的表称为基表，视图是存储在数据字典中的一条SELECT语句。

#### 2. 视图作用

 - 简单性：看到的就是需要的。视图不仅可以简化用户对数据的理解，也可以简化他们的操作。

 - 安全性：通过视图用户只能查询和修改他们所能见到的数据。

 - 逻辑数据独立性：视图可帮助用户屏蔽真实表结构变化带来的影响。

 - 通过创建视图可以提取出数据逻辑上的集合或组合。

#### 3. 使用视图的优点：

 - 为用户集中数据，简化用户的数据查询和处理。

 - 屏蔽数据库的复杂性，用户不必了解数据库的复杂性。

 - 简化用户权限的管理，只授予用户使用视图的权限。

 - 便于数据共享，多个用户不必都定义所需的数据。

 - 可以重新组织数据，以便关联到其他应用中。

#### 4. 视图的创建：

 - 语法：

```
CREATE VIEW 视图名
AS SELECT 语句
[WITH READ ONLY]
[WITH CHECK OPTION];

CREATE VIEW v_emp_detail
AS SELECT e.empno,e.ename,e.sal,e.deptno FROM emp e;
```

 - WITH READ ONLY子句用于定义只读视图。

 - 定义视图使用WITH CHECK OPTION，则插入数据应符合相应条件。

 - 创建视图原则
```
（1）定义视图的查询可以采用复杂的SELECT语法，可以包含连接、分组、子查询。
（2）定义视图的查询中不能使用ORDER BY子句，因为ORDER BY子句可以在从视图中查询数据时使用。
```

#### 5.使用视图

像使用表一样使用就可以。

 - 可以查看视图
 ```
SELECT * FROM view_name;
 ```

 - 可以使用视图操作表数据，通过视图添加表数据，使用INSERT语句实现。
```
INSERT INTO emp_view VALUES('9001','ZS',500,10);
注意：视图是虚拟表，其本身不存储数据（来自其引用表),添加的数据是存储于视图参照的数据表中。
```

#### 6. 简单视图

 - 简单视图：它是指基于单个表所建立的，不包含任何函数，表达式以及分组数据的视图。在该视图上可以执行DML语句（即可执行增、删、改操作）。

 - 例子：
```
创建一个简单视图，查询员工的姓名，工资，部门号
    CREATE VIEW view_emp1
    AS
    SELECT ename,sal,deptno
    FROM emp;
```

#### 7. 复杂视图

 - 复杂视图：它指包含函数、表达式或者分组函数的视图，使用复杂视图的主要目的是为了简化查询操作。

 - 在该视图上执行DML语句时必须要符合特定条件。

 - 复杂视图有部分可以DML操作，若复杂视图中有分组函数、GROUPBY子句、DISTINCT、伪列等则不可以做DML操作。

 - 注：在定义复杂视图时必须为函数或表达式定义别名。

 - 例子
```
创建一个视图查询各个部门的部门名称和各部门的平均工资
    CREATE VIEW v_dept1
    AS
    SELECT d.deptno,d.dname,AVG(e.sal) avgsal
    FROM emp e,dept d
    WHERE e.deptno(+) = d.deptno
    GROUP BY d.deptno,d.dname;
```

#### 8. 只读视图：

 - 它是指只允许SELECT操作，而禁止使用任何DML操作的视图。在该视图定义时指定WITH READ ONLY选项。

 - 语法：
```
    CREATE VIEW 视图名称 AS SELECT语法
    WITH READ ONLY
```

 - 例子
```
创建一个只读视图，查询员工的姓名，工资，部门号
    CREATE OR REPLACE VIEW view_emp1
    AS
    SELECT ename,sal,deptno
    FROM emp
    WITH READ ONLY;
```

#### 9. CHECK约束视图

 - WITH CHECK OPTION用于在视图上定义CHECK约束，即在该视图上执行INSERT或UPDATE操作时，数据必须符合查询结果。

 - 语法：
```
    CREATE VIEW 视图名称 AS SELECT语法
    WITH CHECK OPTION
```
```
创建一个CHECK约束视图，查询学生表t_student1的学生姓名和班号
    CREATE OR REPLACE VIEW view_stu1
    AS
    SELECT sno,sname,cno
    FROM t_student1
    WITH CHECK OPTION ;
```

#### 11. 修改视图

 - 语法
```
    CREATE OR REPLACE VIEW view_name AS  SELECT 语句;
```

 - 例子
```
创建一个视图v_emp，可以通过该视图查看所有员工的员工姓名，工资，部门名称，工资等级，按照工资等级降序排序。
    CREATE OR REPLACE VIEW v_emp AS
    SELECT e.ename,e.sal,d.dname, sg.grade  grade
    FROM emp e, dept d, salgrade  sg
    WHERE  e.deptno = d.deptno  AND  (e.sal  BETWEEN sg.losal AND sg.hisal);
```

#### 12. 删除视图

 - 语法
```
    DROP VIEW  视图名;
```
```
    DROP VIEW v_emp1;
```

### 三、集合

#### 1.UNION 并集（去除结果集的重复行，排序）

 - 例子
```
任务：查询工资大于2500或者职位为经理的员工的姓名，工资，职位。
    SELECT ename,sal,job FROM emp WHERE sal>2500
    UNION
    SELECT ename,sal,job FROM emp WHERE job='MANAGER';
```

 - 注意：2个查询的查询列表的个数和类型必须匹配以第一列的结果进行升序排列。

#### 2.UNION ALL并集（不去除结果集的重复行,不排序）

 - 例子
```
任务：查询工资大于2500或者职位为经理的员工的姓名，工资，职位。
    SELECT ename,sal,job FROM emp WHERE sal>2500
    UNION ALL
    SELECT ename,sal,job FROM emp WHERE job='MANAGER';
```

#### 3.INTERSECT  交集

 - 例子
```
任务：查询工资大于2500并且职位为经理的员工的姓名，工资，职位。
    SELECT ename,sal,job FROM emp WHERE sal>2500
    INTERSECT  
    SELECT ename,sal,job FROM emp WHERE job='MANAGER'；
```

 - 最后结果以第一列的结果进行升序排列

#### 4.MINUS 差集

 - 例子
```
任务：查询工资大于2500但是职位不是经理的员工的姓名，工资，职位。
    SELECT ename,sal,job FROM emp WHERE sal>2500
    MINUS
    SELECT ename,sal,job FROM emp WHERE job='MANAGER';
```

 - 显示在A中存在，而在B中不存在的数据。结果以第一列的结果进行升序排列。

### 五、课后任务

#### 1. 任务：on后面的条件与where里面的条件的区别

 - 当使用left join时：
```
当条件放在on后面时，无论on条件的真假，都会返回左表的值；
当条件放在where后面时，只有满足条件的记录会返回。
```

 - 当使用inner join时：
```
无论条件放在哪里，都只会返回满足条件的结果。
```

#### 2. 任务：层次查询

 - 层次查询使用树的遍历，走遍含树形结构的数据集合，来获取树的层次关系报表的方法。

 - 树形结构的父子关系，你可以控制：
```
（1）遍历树的方向，是自上而下，还是自下而上
（2）确定层次的开始点(root)的位置
```

 - 层次查询语句正是从这两个方面来确定的,start with确定开始点,connect by确定遍历的方向。

 - 注释：
```
（1）level是伪列，表示等级；
（2）from后面只能是一个表或视图，对于from是视图的，那么这个view不能包含join；
（3）Where条件限制了查询返回的行，但是不影响层次关系，属于将节点截断，但是这个被截断的节点的下层child不受影响；
（4）prior是个形容词，可放在任何地方；
（5）彻底剪枝条件应放在connect by；单点剪掉条件应放在where子句。但是，connect by的优先级要高于where，也就是sql引擎先执行connect by；
（6）在start with中表达式可以有子查询，但是connect by中不能有子查询。
```
