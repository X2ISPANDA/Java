--1.多表查询
SELECT count(*) FROM emp,dept;
SELECT * FROM emp,dept WHERE emp.deptno=dept.deptno;
SELECT * FROM dept;
--（1 ）等值连接：用 =来做关联
--任务1 ：查询所有员工所在的部门的员工姓名和部门名称。
SELECT e.ename,d.dname FROM emp e,dept d WHERE e.deptno=d.deptno;
--任务2 ：查询10号部门的所有员工信息，显示员工姓名，部门编号，部门名称。
SELECT e.ename,d.deptno,d.dname FROM emp e,dept d WHERE e.deptno=d.deptno AND d.deptno=10;
--where后面可能跟着关联条件，也可能是筛选条件。
--任务一  显示销售部('SALES')员工的姓名
SELECT e.ename FROM emp e,dept d WHERE e.deptno=d.deptno AND d.dname='SALES';
--任务二  查询20号部门的员工的员工姓名，职位，平均工资，所在部门名称。
SELECT e.ename,e.job,d.dname,d.deptno,avg(sal)
FROM emp e,dept d
WHERE e.deptno=d.deptno AND d.deptno=20
GROUP BY e.ename,e.job,d.dname,d.deptno;

SELECT avg(sal) FROM emp WHERE deptno=20;

--（2）不等值连接：使用除了等号以外的运算符连接
--任务 ：查询出员工的姓名，薪水及薪水等级。
SELECT * FROM salgrade;
SELECT e.ename,e.sal,s.grade FROM emp e,salgrade s WHERE e.sal BETWEEN s.losal AND s.hisal;
--任务1：  查询 10 号部门工资小于2000 的员工的姓名，工资及工资等级,部门名称。
SELECT e.ename,e.sal,s.grade,d.dname
FROM emp e,salgrade s,dept d
WHERE e.deptno=d.deptno AND d.deptno = 10 AND e.sal<2000 AND e.sal BETWEEN s.losal AND s.hisal;
--任务2：查询工资等级处于第四级别的员工的姓名。
SELECT e.ename,e.sal
FROM emp e,salgrade s
WHERE s.grade=4 AND e.sal BETWEEN s.losal AND s.hisal;

--（3）内连接：一般使用关键字INNER JOIN来实现，ON 后面跟着连接条件
--select 字段名 from 表名1 [inner] join 表2 on 表1.字段名=表2.字段名（连接条件）；
SELECT e.empno,e.ename,d.deptno,d.dname
FROM emp e INNER JOIN dept d ON e.deptno=d.deptno;

SELECT e.ename,d.dname FROM emp e,dept d WHERE e.deptno=d.deptno;

SELECT * FROM emp;
SELECT * FROM dept;

--外连接：左外连接（左连接），右外连接（右连接），完全外连接
--左外连接：SELECT 字段列表 FROM 表1 t1  LEFT OUTER JOIN 表2 t2  ON t1.字段 = t2.字段;
--左边的表是主表，右边的表是从表也叫匹配表
--左连接注意：左表中的数据全部显示，右表中的数据只显示匹配上的，匹配不上的不显示，对于左表来说额外的数据右表填空
SELECT *
FROM emp e LEFT OUTER JOIN dept d ON e.deptno=d.deptno;
--另一种写法：SELECT  字段列表 FROM  表1  t1  ， 表2  t2  WHERE t1.字段 = t2.字段(+);
SELECT *
FROM emp e,dept d
WHERE e.deptno=d.deptno(+);
--dept表作为主表，emp表作为匹配表，+ 表示补充，即哪个表有加号，这个表就是匹配表。
SELECT *
FROM emp e,dept d
WHERE d.deptno= e.deptno(+);
SELECT *
FROM dept d LEFT OUTER JOIN emp e ON d.deptno=e.deptno;

--右外连接：SELECT  字段列表 FROM 表1  t1 RIGHT OUTER JOIN  表2  t2  ON t1.字段 = t2.字段;
--右外连接右表是主表，左边的表是匹配表

SELECT *
FROM dept d RIGHT OUTER JOIN emp e ON e.deptno=d.deptno;

--完全外连接：SELECT 列名列表 FROM  表名1 FULL [OUTER]  JOIN  表名2 ON 表名1.列名 = 表名2. 列名;
--只有以上一种写法
SELECT *
FROM emp e FULL OUTER JOIN dept d ON e.deptno=d.deptno;

--使用内连接：任务1 ：检索从事CLERK工作的员工姓名和所在部门名称。
SELECT e.ename,d.dname,e.job
FROM emp e INNER JOIN dept d ON e.deptno=d.deptno AND e.job='CLERK';

SELECT e.ename,d.dname
FROM emp e INNER JOIN dept d ON e.deptno=d.deptno
WHERE e.job='CLERK';

--任务：on后面的条件与where里面的条件的区别
--Oracle特有的层次查询

--按部门号（deptno） 及 工资（sal）排序检索公司的员工信息
--(要求部门号从大到小 ，部门号相同的按工资由低到高），显示的字段为：员工号、员工姓名、工资、部门名称。
SELECT e.empno,e.ename,e.sal,d.dname,e.deptno
FROM emp e INNER JOIN dept d ON e.deptno=d.deptno
ORDER BY e.deptno DESC,sal ASC;
--任务  查询没有员工的部门信息
SELECT d.*
FROM dept d LEFT OUTER JOIN emp e ON e.deptno=d.deptno
WHERE e.empno IS NULL;

SELECT d.*
FROM emp e,dept d
WHERE d.deptno=e.deptno(+) AND e.empno is null;
--自连接：自己和自己连接，同一张表
--查询员工自己的信息和上级领导的信息
SELECT e1.*,e2.empno,e2.ename
FROM emp e1,emp e2
WHERE e1.mgr=e2.empno;
--任务： 显示BLAKE的上级领导的姓名
SELECT e2.ename
FROM emp e1,emp e2
WHERE e1.mgr=e2.empno AND e1.ename='BLAKE';
--面试：连接分为几种：
--内连接，外连接（左连接，右连接，完全外连接  ）


--创建视图
--CREATE VIEW 视图名称 AS SELECT 语句
--任务：创建一个视图v_emp，可以通过该视图查看所有员工的员工号，员工姓名，工资，部门号，部门名称，工资等级。
SELECT e.empno,e.ename,e.sal,e.deptno,d.dname,s.grade
FROM emp e,dept d,salgrade s
WHERE e.deptno=d.deptno AND e.sal BETWEEN s.losal AND s.hisal;

CREATE VIEW v_emp AS
SELECT e.empno,e.ename,e.sal,e.deptno,d.dname,s.grade
FROM emp e LEFT OUTER JOIN dept d ON e.deptno=d.deptno
LEFT OUTER JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal;

SELECT e.empno,e.ename,e.sal,e.deptno,d.dname,s.grade
FROM emp e,dept d,salgrade s
WHERE e.deptno=d.deptno(+) and e.sal between s.losal(+) and s.hisal(+);

--使用视图
SELECT * FROM v_emp;
--视图注意：表达式用别名
--创建一个简单视图，通过视图做增删改操作
CREATE TABLE emp1 as SELECT * FROM emp;--复制表（复制的是表的结构和数据）
CREATE TABLE emp2 as SELECT * FROM emp WHERE 1=2;--只是复制表结构不复制表里的数据

CREATE VIEW v_emp1 AS
SELECT * FROM emp1;
--通过视图做增删改语句，修改的是原始表
--视图就是一条select语句，操作的是基表
INSERT INTO v_emp1(empno,ename) VALUES ('9002','LISI');
DELETE FROM v_emp1;

--创建一个视图查询各个部门的部门名称和各部门的平均工资（包括没有部门的工资）
CREATE VIEW v_emp_dept AS
SELECT d.dname,d.deptno,avg(sal) avgsal
FROM emp e,dept d
WHERE e.deptno(+)=d.deptno
GROUP BY d.dname,d.deptno;
SELECT * FROM v_emp_dept;

--只读视图 with  read only ：只能进行查询，不能做DML操作
CREATE OR REPLACE VIEW v_emp1 AS SELECT * FROM emp1
with read only;

SELECT * FROM v_emp1;
DELETE FROM v_emp1 WHERE empno='9002';

--检查约束
CREATE OR REPLACE VIEW v_emp1 AS SELECT * FROM emp1
WHERE deptno=20
with check option;
SELECT * FROM v_emp1;
INSERT INTO v_emp1(empno,deptno) VALUES (9004,20);
--以下SQL不满足条件
--插入的数据将来通过视图能够查询
INSERT INTO v_emp1(empno,deptno) VALUES (9005,10);
--删除视图
DROP VIEW v_emp_detail;

--表和表之间的关系
--1:n 之间的关系：学校--院系--专业--班级--学生
--1:1 之间的关系：学生--学生详情表
--n:n 之间的关系：学生--课程


--集合的操作
--union（并集，而且去重，以第一个字段排序）
--任务：查询工资大于2500或者职位为经理的员工的姓名，工资，职位。
SELECT ename,job,sal FROM emp WHERE sal>2500
UNION
SELECT ename,job,sal FROM emp WHERE job='MANAGER';
--union all，不去重，不排序
SELECT ename,job,sal FROM emp WHERE sal>2500
UNION ALL
SELECT ename,job,sal FROM emp WHERE job='MANAGER';
--intersect：交集，排序
SELECT ename,job,sal FROM emp WHERE sal>2500
INTERSECT
SELECT ename,job,sal FROM emp WHERE job='MANAGER';
--minus：差集
SELECT ename,job,sal FROM emp WHERE sal>2500
MINUS
SELECT ename,job,sal FROM emp WHERE job='MANAGER';

SELECT ename,job,sal FROM emp WHERE job='MANAGER'
MINUS
SELECT ename,job,sal FROM emp WHERE sal>2500;




