### 一、 排序分组及过滤
#### 1. 排序ORDER BY

 - 使用规则
```
  ASC: 升序,缺省（默认状态）
查询出部门表的部门编号，部门名称，并按着部门编号升序排序。
  SELECT deptno,dname FROM dept ORDER BY deptno ASC;（可以省略）
  DESC: 降序
查询每个员工的姓名，工资，年薪（别名ysal），并按年薪降序排序。
  SELECT ename,sal,sal*12 ysal FROM emp ORDER BY ysal DESC;
```

 - ORDER BY 子句出现在SELECT语句的最后

 - 注意：DESC的作用域是作用在离它最近的列上。
```
查询出每个员工的薪水与部门，并按着部门编号降序排序,工资降序。
  SELECT sal,deptno FROM emp ORDER BY deptno DESC,sal DESC;
  SELECT sal,deptno FROM emp ORDER BY deptno,sal DESC;
```

#### 2.分组GROUP BY和分组函数

 - 语法：
 ```
  SELECT column, group_function
  FROM table
  [WHERE condition]
  [GROUP BY group_by_expression]
  [HAVING group_condition]
  [ORDER BY column]；
 ```

 - 分组函数用于统计表数据
```
    MAX( ) 求最大值，返回表达式中所有值的最大值，适用任何数据类型；
    MIN( ) 求最小值，返回表达式中所有值的最小值，适用任何数据类型；
    AVG( ) 求平均值，返回表达式中所有值的平均值，只能用于数字；
    SUM( ) 求和，返回表达式中所有值的和，只能用于数字求和；
    COUNT( ) 统计计算总行数，返回整数；
    查询各个部门的员工的平均工资。
    SELECT deptno,AVG(sal)
    FROM emp
    GROUP BY deptno;
    查询各个部门各个职位的平均工资和最大工资。
    SELECT deptno,job,avg(sal),max(sal)
    FROM emp
    GROUP BY deptno,job;
    统计10，20, 30 号部门的员工人数。
    SELECT deptno,count(*)
    FROM emp
    WHERE deptno in (10,20,30)
    GROUP BY deptno;
```

 - 注意：COUNT()与COUNT(列名)的区别：
```
（1）COUNT()将返回表格中所有存在的行的总数包括值为NULL的行，
（2）COUNT(列名)将返回表格中除去NULL以外的所有行的总数(有默认值的列也会被计入）.  
（3）COUNT(DISTINCT 列名),得到的结果将是除去值为NULL和重复数据后的结果  
```

 - 分组函数使用注意事项
```
（1）分组函数只能出现在SELECT选择列表、HAVING子句、ORDER BY子句中。
（2）在查询SELECT列表中出现的列没有在分组函数中出现的话，就必须在GROUP BY中出现。不使用组函数的字段，必须在GROUP BY子句中出现
（3）GROUP BY子句的位置在WHERE子句的后面，ORDER  BY的前面
（4）分组结果限制只能使用HAVING。
```

#### 3.HAVING子句：对分组后的结果进行过滤筛选
 - 对分组结果进行限制HAVING
```
查询各个部门平均工资小于2500的员工的平均工资和最高工资。
    SELECT deptno,avg(sal),max(sal)
    FROM emp
    GROUP BY deptno
    HAVING avg(sal)<2500;
```
```
    列出至少有四个员工的所有部门号和所在部门的员工人数。
    SELECT deptno,count(*)
    FROM emp
    GROUP BY deptno
    HAVING count(*)>=5;
```

#### 4.WHERE子句和HAVING子句的区别:

 - WHERE搜索条件在进行分组操作之前应用，而HAVING搜索条件在进行分组操作之后应用；

 - WHERE子句过滤的是行（记录），HAVING子句过滤的是分组（组标识、每组数据的聚合结果）；

 - WHERE子句包含单行函数，HAVING子句只能包含GROUP BY后面的表达式和组函数；

 - WHERE子句执行在前，HAVING子句执行在后；

 - WHERE子句和HAVING子句都不允许用列别名。

#### 5.书写顺序和执行顺序：

 - 查询中用到的关键词主要包含六个，并且SQL语句书写顺序依次为：
```
SELECT--FROM--WHERE--GROUP BY--HAVING--ORDER BY
```

 - 其中SELECT和FROM是必须的，其他关键词是可选的，这六个关键词的执行顺序为：
```
FROM--WHERE--GROUP BY--HAVING--SELECT--ORDER BY
```

### 二、常用函数
#### 1.字符函数

 - 返回字符串的小写形式：LOWER(String)
```
SELECT LOWER('HELLO') from dual;
```

 - 返回字符串的大写形式：UPPER(String)
```
例子：SELECT UPPER('hello') from dual;
```

 - 单词首字母大写：INITCAP(String)
```
SELECT INITCAP('hello') FROM dual;
```

 - 返回字符串的长度：LENGTH(String)
```
SELECT LENGTH('HELLO WORLD') from dual;
```

 - 截取字符串：SUBSTR(String,start_index,length)
```
SELECT SUBSTR('Hello World',3,8) FROM dual;
```

 - 删除字符串两侧空格：TRIM(String)
```
SELECT TRIM('   HELLO WORLD    ') FROM dual;
```

#### 2.数值函数

 - 四舍五入：ROUND(源数值[,小数位数])
```
SELECT ROUND(4.67) FROM dual;
```

 - 取模操作:MOD(被除数，除数)：余数的结果的符号和被除数相同
```
    SELECT MOD(17,8) FROM dual;
    SELECT MOD(-17,8) FROM dual;
    SELECT MOD(17,-8) FROM dual;
    SELECT MOD(-17,-8) FROM dual;  
```

 - 截取数字：TRUNC(源数值[,小数位数])，直接向下取整
```
SELECT TRUNC(4.67) FROM dual;
```

#### 3.日期函数

 - 获取系统当前日期：SYSDATE
```
SELECT sysdate FROM dual;
```

 - 将字符串转换成日期：TO_DATE(StrDate，格式)
```
SELECT TO_DATE('2019-02-06','yyyy-mm-dd') FROM dual;
```

 - 为日期加上指定月份：ADD_MONTHS(date，n)
```
SELECT ADD_MONTHS(SYSDATE,2) FROM dual;
```

 - 返回特定日期所在月份的最后一天：LAST_DAY(date)
```
SELECT LAST_DAY(SYSDATE) FROM dual;
```

 - 返回两个日期所差的月数：MONTHS_BETWEEN(date1，date2)
```
SELECT ename, TRUNC(MONTHS_BETWEEN(SYSDATE,hiredate)) FROM emp;
```

 - 返回特定日期之后的一周内的日期：NEXT_DAY(date，n)
```
SELECT NEXT_DAY(SYSDATE,2) FROM dual;
```

 - 返回日期的某个域--EXTRACT()函数
```
      SELECT EXTRACT(YEAR FROM SYSDATE) FROM dual;
      SELECT EXTRACT(MONTH FROM SYSDATE) FROM dual;
      SELECT EXTRACT(DAY FROM SYSDATE) FROM dual;
```

#### 4.转换函数

 - 把日期型或数值型数据转换成变长的字符串：TO_CHAR(日期格式，格式)
```
      字符串转换函数用法（TO_CHAR）
      SELECT TO_CHAR(sysdate,’yyyy-mm-dd hh24:mi:ss’) as nowTime FROM dual; //日期
      SELECT TO_CHAR(SYSDATE,'yyyy') as nowYear FROM dual;
```

 - 把一个数字组成的字符串转换成数值：TO_NUMBER(字符串)
```
  SELECT TO_NUMBER('1236') FROM dual;
```

 - 将字符串转换成日期：TO_DATE(StrDate，格式)
```
SELECT  TO_DATE('201-09-12','yyyy-mm-dd') FROM dual;
```

#### 5.通用函数

 - 空值处理：NVL()
```
查询所有员工的姓名，工资，奖金，年收入。
SELECT ename,sal,comm,sal*12+nvl(comm,0) FROM emp;
```

 - 结果集的行号：ROWNUM
```
（1）ROWNUM也是伪列，表示行号，但与ROWID有区别。
（2）ROWID表示唯一行标识，伪列ROWID长度为18位字符，包含了该行数据在Oracle数据库中的物理地址。
（3）注意:使用ROWNUM不能使用>，>=，ROWNUM始终从1开始的，只能使用<。
查询员工表前三条记录。
    SELECT * FROM emp WHERE ROWNUM<3;
```

#### 6.分组函数

 - 最小值:MIN()，适用于任何数据类型
```
SELECT MIN(sal)  FROM  emp;
```

 - 最大值：MAX()，适用于任何数据类型
```
SELECT MAX(sal)  FROM  emp;
```

 - 平均值：AVG()，只能用于数字
```
SELECT AVG(sal)  FROM  emp;
```

 - 统计记录数：COUNT()，返回整数
```
SELECT COUNT(*) FROM  emp;
```

 - 总额：SUM()，只能用于数字求和
```
SELECT SUM(sal) FROM emp;
```

#### 7.CASE WHEN表达式

 - 简单CASE函数：相当于switch case，不可以写范围
```
（1）语法：
    CASE search_expression
    WHEN expression1
    THEN result1
    WHEN expression2
    THEN result2
    ...
    ELSE default_result
    END
（2）查询员工表员工涨前与涨后工资情况，根据职位涨工资，职位为PRESIDENT的涨1000，职位是经理的涨800，其他涨400 。
    SELECT empno,job,sal zq,
    CASE job WHEN 'PRESIDENT' THEN sal+1000
    WHEN 'MANAGER' THEN sal+800 ELSE sal+400
    END zh FROM emp;
```

 - CASE搜索函数
```
（1）语法:
    CASE WHEN condition1 THEN result1
    WHEN condition2 THEN result2
    　　...
    WHEN conditionN THEN resultN
    ELSE default_result
    END
（2）查询员工表员工涨前与涨后工资情况，根据职位涨工资，职位为PRESIDENT的涨1000，职位是经理的涨800，其他涨400 。
    SELECT empno,ename,job,sal 涨前,
    CASE  WHEN job='PRESIDENT' THEN sal+1000
    WHEN job='MANAGER'  
    THEN  sal+800
    ELSE sal+400
     END   涨后
    FROM emp;
```

#### 8.DECODE()函数

 - 语法：
```
DECODE(条件,值1,返回值1,值2,返回值2,...值n,返回值n,缺省值)
```

 - 例子：
```
查询员工表员工涨前与涨后工资情况，根据职位涨工资，职位为PRESIDENT的涨1000，职位是经理的涨800，其他涨400
    SELECT empno,ename,job,sal 涨前,
    DECODE(job,'PRESIDENT',sal+1000,
    'MANAGER',sal+800,sal+400) 涨后
    FROM emp;
```


### 三、课后任务

#### 1. null

 - NULL是数据库中特有的数据类型，当一条记录的某个列为NULL，则表示这个列的值是未知的、是不确定的。既然是未知的，就有无数种的可能性。因此，NULL并不是一个确定的值。

 - ORACLE允许任何一种数据类型的字段为空，除了以下两种情况：
```
（1）主键字段（primary key），
（2）定义时已经加了NOT NULL限制条件的字段
```

 - 说明：
```
（1）等价于没有任何值、是未知数。
（2）NULL与0、空字符串、空格都不同。
（3）对空值做加、减、乘、除等运算操作，结果仍为空。
（4）NULL的处理使用NVL函数。
（5）比较时使用关键字用“is null”和“is not null”。
（6）空值不能被索引，所以查询时有些符合条件的数据可能查不出来，count(*)中用nvl(列名,0)处理后再查。
（7）排序时比其他数据都大（索引默认是降序排列，小→大），所以NULL值总是排在最后。
```

#### 2. 4种空值处理函数

 - nvl(exp1,exp2)：如果exp1为空，则返回exp2；否则返回exp1；
```
    SELECT NVL(1,2) FROM dual;//1
    SELECT NVL(NULL,2) FROM dual;//2
```

 - nvl2(exp1,exp2,exp3)：如果exp1为空，则返回exp3；否则返回exp2；
```
    SELECT NVL(1,2,3) FROM dual;//2
    SELECT NVL(NULL,2,3) FROM dual;//3
```

 - nullif(exp1,exp2)：如果exp1等于exp2，则返回空；否则返回exp1；
```
    SELECT NULLIF(1,2) FROM dual;//1
    SELECT NULLIF(2,2) FROM dual;//null
```

 - coalesce(exp1,exp2.....expn)：返回列表中第1个不为空的值，如果全部元素为空，则返回空。
```
    SELECT coalesce(NULL,NULL,2,3);//2
    SELECT coalesce(NULL,NULL,NULL,NULL);//NULL
```
