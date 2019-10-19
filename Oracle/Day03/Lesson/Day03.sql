--往班级表插入数据
--全部插入
SELECT * FROM t_class;
INSERT INTO t_class VALUES('1003','3班');

--插入一条不完整的记录
SELECT * FROM t_student;
INSERT INTO t_student(stuno,stuname) VALUES ('7','肖浩锋');


CREATE TABLE t_course(
  cno NUMBER(5) PRIMARY KEY,
  cname VARCHAR2(20),
  cscore VARCHAR2(2),
  cteacher VARCHAR2(10)
);

CREATE TABLE t_scgrade(
  sno NUMBER(10),
  cno NUMBER(5) REFERENCES t_course(cno),
  grade NUMBER(4)
);

ALTER TABLE t_scgrade ADD CONSTRAINT zj PRIMARY KEY(sno,cno);
ALTER TABLE t_course MODIFY (cscore NUMBER(2,1));
ALTER TABLE t_course ADD CONSTRAINT

INSERT INTO t_course VALUES(1,'计算机科学',2.5,'张学友');

--更新单列
--UPDATE 表名 SET 字段名=值,字段名=值
--把所有学生的名字改成张三丰
UPDATE t_student SET stuname='张三丰';

--删除记录
--DELETE FROM 表名 WHERE 条件
DELETE FROM t_student;

ROLLBACK;

--UPDATE 表名 SET account=account-50 WHERE ...;
--UPDATE 表名 SET account=account+50 WHERE ...;

SELECT * FROM EMP;
SELECT empno,ename,job,mgr,hiredate FROM emp;
SELECT  deptno, ename ，rowid FROM  emp;

SELECT ename,sal,12*sal as ysal FROM emp;
SELECT empno,ename,sal,sal*12 as ysal,comm,sal*12+NAVL(comm,0) FROM emp;

SELECT SYSDATE-1 as 昨天,SYSDATE as 今天,SYSDATE+1 as 明天 FROM dual;

SELECT * FROM dual;
insert into dual values('Y');
SELECT * FROM dual;

SELECT 'HELLO'||'WORLD' FROM dual;
SELECT ename||'的工资是：'||sal
FROM emp;

SELECT DISTINCT job
FROM emp;

SELECT ename,sal FROM emp WHERE sal>1500;
SELECT empno,ename,sal FROM emp WHERE sal=ANY(1500,3000);

SELECT ename,sal,deptno FROM emp WHERE deptno=20 AND sal>=2000;
SELECT ename,sal,deptno FROM emp WHERE deptno=20 OR sal>=1500;
SELECT ename,sal,deptno FROM emp WHERE deptno=30 AND sal>1000 OR sal>2000;
SELECT ename,sal,deptno FROM emp WHERE deptno!=10 AND deptno!=20;
SELECT ename,deptno FROM emp WHERE deptno=10 OR  deptno=20;

SELECT ename,sal,deptno FROM emp WHERE ename LIKE '_A%';
SELECT empno,ename,sal,comm FROM emp WHERE comm IS NOT NULL AND comm<>0;
SELECT ename,deptno FROM emp WHERE deptno IN(20,30);
SELECT ename,sal FROM emp WHERE sal NOT BETWEEN 2000 AND 3000;

SELECT * FROM dept;
SELECT deptno,dname FROM dept ORDER BY deptno ASC;

SELECT ename,sal,sal*12 ysal FROM emp ORDER BY ysal DESC;
SELECT deptno, AVG(sal) avgsal FROM emp GROUP BY deptno;
SELECT deptno,AVG(sal) avgsal,MAX(sal) maxsal FROM emp GROUP BY deptno;
SELECT deptno,AVG(sal) avgsal FROM emp GROUP BY deptno ORDER BY avgsal ASC;
SELECT ename,sal FROM emp
WHERE ename LIKE '%\_%' ESCAPE '\'; --转义ESCAPE '\'

SELECT deptno,COUNT(empno) count FROM emp WHERE deptno IN(10,20,30) GROUP BY deptno;
--统计各个职位的员工人数和平均工资。
SELECT job,COUNT(empno),AVG(sal) FROM emp GROUP BY job;

--查询各个部门各个岗位的平均工资。
SELECT deptno,job,AVG(sal) AVGSAL FROM emp GROUP BY deptno,job;

--统计员工表中有奖金（包括奖金不能为0）的员工人数
SELECT COUNT(comm) FROM emp WHERE comm!=0;

--统计员工表所有员工的人数
SELECT COUTN(*) FROM emp;
--统计职位的个数
SELECT COUNT(DISDINCT job) FROM emp;

--HAVING语句:对分组后的结果进行筛选
--查询各个部门平均工资小于2500的员工的平均工资和最高工资。
SELECT deptno,AVG(sal) avgsal,MAX(sal) maxsal FROM emp GROUP BY deptno HAVING AVG(sal)<2500;

--列出至少有四个员工的所有部门号和所在部门的员工人数
SELECT deptno,COUNT(ename) FROM emp GROUP BY deptno HAVING COUNT(ename)>=4;
