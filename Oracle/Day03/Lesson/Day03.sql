--���༶���������
--ȫ������
SELECT * FROM t_class;
INSERT INTO t_class VALUES('1003','3��');

--����һ���������ļ�¼
SELECT * FROM t_student;
INSERT INTO t_student(stuno,stuname) VALUES ('7','Ф�Ʒ�');


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

INSERT INTO t_course VALUES(1,'�������ѧ',2.5,'��ѧ��');

--���µ���
--UPDATE ���� SET �ֶ���=ֵ,�ֶ���=ֵ
--������ѧ�������ָĳ�������
UPDATE t_student SET stuname='������';

--ɾ����¼
--DELETE FROM ���� WHERE ����
DELETE FROM t_student;

ROLLBACK;

--UPDATE ���� SET account=account-50 WHERE ...;
--UPDATE ���� SET account=account+50 WHERE ...;

SELECT * FROM EMP;
SELECT empno,ename,job,mgr,hiredate FROM emp;
SELECT  deptno, ename ��rowid FROM  emp; 

SELECT ename,sal,12*sal as ysal FROM emp;
SELECT empno,ename,sal,sal*12 as ysal,comm,sal*12+NAVL(comm,0) FROM emp;

SELECT SYSDATE-1 as ����,SYSDATE as ����,SYSDATE+1 as ���� FROM dual;

SELECT * FROM dual;
insert into dual values('Y');
SELECT * FROM dual;

SELECT 'HELLO'||'WORLD' FROM dual;
SELECT ename||'�Ĺ����ǣ�'||sal
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
WHERE ename LIKE '%\_%' ESCAPE '\'; --ת��ESCAPE '\'

SELECT deptno,COUNT(empno) count FROM emp WHERE deptno IN(10,20,30) GROUP BY deptno;
--ͳ�Ƹ���ְλ��Ա��������ƽ�����ʡ�
SELECT job,COUNT(empno),AVG(sal) FROM emp GROUP BY job;

--��ѯ�������Ÿ�����λ��ƽ�����ʡ�
SELECT deptno,job,AVG(sal) AVGSAL FROM emp GROUP BY deptno,job;

--ͳ��Ա�������н��𣨰���������Ϊ0����Ա������
SELECT COUNT(comm) FROM emp WHERE comm!=0;

--ͳ��Ա��������Ա��������
SELECT COUTN(*) FROM emp;
--ͳ��ְλ�ĸ���
SELECT COUNT(DISDINCT job) FROM emp;

--HAVING���:�Է����Ľ������ɸѡ
--��ѯ��������ƽ������С��2500��Ա����ƽ�����ʺ���߹��ʡ�
SELECT deptno,AVG(sal) avgsal,MAX(sal) maxsal FROM emp GROUP BY deptno HAVING AVG(sal)<2500;

--�г��������ĸ�Ա�������в��źź����ڲ��ŵ�Ա������
SELECT deptno,COUNT(ename) FROM emp GROUP BY deptno HAVING COUNT(ename)>=4;
