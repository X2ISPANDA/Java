--1、order by排序 ASC缺省（默认状态是升序），DESC（降序）,只会作用于他之前的一个字段
--任务1：查询出部门表的部门编号，部门名称，并按着部门编号升序排序
SELECT deptno,dname FROM dept ORDER BY deptno;
--任务2：查询每个员工的姓名，工资，年薪（别名ysal）, 并按年薪降序排序
SELECT ename,sal,sal*12 ysal FROM emp ORDER BY ysal DESC;
--执行顺序：from...select...order by...
--任务3：查询出每个员工的薪水与部门，并按着部门编号降序排序,工资降序
SELECT sal,deptno FROM emp ORDER BY deptno DESC,sal DESC;


SELECT ename,job,hiredate,deptno FROM emp ORDER BY  hiredate,deptno DESC;
SELECT ename,sal*12+NVL(comm,0) annualIncome,deptno FROM emp ORDER BY annualIncome DESC,deptno DESC;
SELECT ename,sal*12 ysal,deptno FROM emp WHERE sal>1200 AND deptno=20 ORDER BY ysal DESC;

--2、GROUP BY 。。。分组
--分组函数：5个，max(),min(),avg(),sum(),count()
--任务1、查询各个部门的员工的平均工资。
--在GROUP BY中出现的字段才能在SELECT中单独出现，没出现的字段只能和组函数一起使用
SELECT deptno,avg(sal)
FROM emp
GROUP BY deptno;
--任务2、查询各个部门各个职位的平均工资和最大工资
SELECT deptno,job, avg(sal),max(sal)
FROM emp
GROUP BY deptno,job;
--任务3、查询各个部门的平均工资，并按照平均工资升序排序
SELECT deptno,avg(sal) avgSal
FROM emp
GROUP BY deptno
ORDER BY avgSal;
--执行顺序：from...where...group by...delect...order by...
--组函数出现在select语句，order by语句中，having语句中
--COUNT(*)将返回表格中所有存在的行的总数包括值为NULL的行
--COUNT(列名)将返回表格中除去NULL以外的所有行的总数
--COUNT(DISTINCT 列名),得到的结果将是除去值为NULL和重复数据后的结果

--任务1 、统计10，20, 30 号部门的员工人数。
SELECT deptno,count(empno)
FROM emp
WHERE deptno IN (10,20,30)
GROUP BY deptno;
--任务2、统计各个职位的员工人数和平均工资。
SELECT job,count(empno),avg(sal)
FROM emp
GROUP BY job;
--任务3、查询各个部门各个岗位的平均工资。
SELECT empno,job,avg(sal)
FROM emp
GROUP BY empno,job;
--任务4、统计员工表中有奖金（包括奖金不能为0）的员工人数
SELECT count(comm)
FROM emp
WHERE comm<>0;
--任务5、统计员工表所有员工的人数
SELECT count(empno) FROM emp;
--任务6、统计职位的个数
SELECT COUNT(DISDINCT job) FROM emp;


--任务1：查询各个部门平均工资小于2500的员工的平均工资和最高工资
SELECT deptno,AVG(sal),MAX(sal)
FROM emp
GROUP BY deptno
HAVING  AVG(sal)<2500;
--列出至少有四个员工的所有部门号和所在部门的员工人数
SELECT deptno,COUNT(empno)
FROM emp
GROUP BY deptno
HAVING COUNT(empno)>3;

--执行顺序：from...where...group by...having...select...order by...
--因为执行顺序，所以 别名只能用在order by中和select后面

--4、rownum伪列：表示行号,只能使用<或<=
SELECT e.*,rownum FROM emp e WHERE rownum<10;

--5、单行函数  字符函数
--把hello world 变成大写
SELECT lower('HELLO WORLD'),upper('hello world'),initcap('hello world'),length('hello world') FROM dual;
SELECT SUBSTR('Hello World',3,8)
FROM dual;
--5.2 单行函数--数值函数
SELECT ROUND(3.14) FROM dual;
SELECT ROUND(3.1415926,2) FROM dual;
SELECT ROUND(123.1415926,-1) FROM dual;

SELECT MOD(17,8) FROM dual;
--TRUNC函数和ROUND函数类似，只不过不进行四舍五入操作
SELECT TRUNC(4.67) FROM dual;

--5.3 单行函数--日期函数
SELECT TO_DATE('2019-09-08 14:25:30','yyyy-mm-dd hh24:mi:ss')
FROM dual;
SELECT add_months(sysdate,4) FROM dual;
SELECT last_day(sysdate) FROM dual;
SELECT trunc(months_between(sysdate,emp.hiredate)) FROM emp;
SELECT NEXT_DAY(SYSDATE,3)
FROM dual;
SELECT EXTRACT(YEAR FROM SYSDATE) FROM dual;

--5.4转换函数
SELECT to_char(sysdate,'yyyy:mm:dd hh24:mi:ss')FROM dual;
SELECT to_char(sysdate,'mm')FROM dual;
SELECT to_char(sysdate,'dd')FROM dual;
SELECT to_char(sysdate,'hh24')FROM dual;
SELECT to_char(sysdate,'mi')FROM dual;
SELECT to_char(sysdate,'ss')FROM dual;

SELECT e.*,rownum FROM emp e
WHERE rownum<=5;

SELECT max(sal),min(sal),avg(sal),sum(sal),count(*) FROM emp;

--6、CASE 表达式 WHEN 值一...THEN...WHEN 值二...THEN...ELSE...END
--任务：查询员工表员工涨前与涨后工资情况，根据职位涨工资，职位为PRESIDENT的涨1000，
--职位是经理的涨800，其他涨400
SELECT empno,ename,job,sal zq,CASE job
WHEN 'PRESIDENT' THEN sal+1000
WHEN 'MANAGER' THEN sal+800
ELSE sal+400
END zh
FROM emp;
--case 搜索函数  case when 条件 then ...when 条件.. else...end
SELECT empno,ename,job,sal zq,CASE
WHEN job='PRESIDENT' THEN sal+1000
WHEN job='MANAGER' THEN  sal+800
ELSE sal+400
END zh
FROM emp;

SELECT empno,ename,sal,CASE
WHEN sal<=1000 THEN 'E'
  WHEN sal>1000 AND sal <=2000 THEN 'D'
    WHEN sal>2000 AND sal <=3000 THEN 'C'
      WHEN sal>3000 AND sal <= 4000 THEN 'B'
        WHEN sal>4000 AND sal <= 5000 THEN 'A'
          END salGrade
          FROM emp;

--decode函数  decode（条件，值1，结果，值2，结果，缺省）
SELECT empno,ename,job,sal zq,
DECODE(job,'PRESIDENT',sal+1000,'MANAGER',sal+800,sal+400) zh
FROM emp;

--7、视图：由一个表或多个表的虚拟表，实际上就是一个select语句
--create view 视图名称 as select 语句
--创建一个视图，可以通过该视图查看所有员工的员工号，员工姓名，工资，部门号，部门名称，工资等级
CREATE VIEW v_emp_detail AS
SELECT e.empno,e.ename,e.sal,e.deptno,d.dname,s.grade
FROM emp e,dept d,salgrade s
WHERE e.deptno = d.deptno AND (e.sal BETWEEN s.losal AND s.hisal);

--使用视图
SELECT * FROM v_emp_detail;

--简单视图
--案例：创建一个简单视图，查询员工的姓名，工资，部门号
CREATE VIEW emp_view
AS
SELECT empno,ename,sal,deptno
FROM emp;
--注意：增删改只能针对简单的试图操作，修改的是原始的基表（因为视图就是一条存在数据字典里的sql语句），
--但是视图一般不用做增删改
SELECT * FROM emp_view;

--
INSERT INTO emp_view VALUES('9001','zs',500,10);

--创建一个视图查询各个部门的部门名称和各部门的平均工资
CREATE VIEW v_emp_dept
AS
SELECT dept.dname,avg(emp.sal) avgSal
FROM emp,dept
WHERE emp.deptno = dept.deptno
GROUP BY emp.deptno,dept.dname;

SELECT * FROM v_emp_dept;

