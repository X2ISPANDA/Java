--隐式游标
--隐式游标的名称是SQL
BEGIN
   UPDATE emp1 SET sal=sal+200 WHERE sal<2000;
   DELETE FROM emp;
   DBMS_OUTPUT.put_line(SQL%ROWCOUNT);
   END;
   SELECT * FROM emp;

--显式游标
--1.声明一个游标
--2.打开游标
--3.抓取数据
--4.关闭游标
--任务： 使用游标在控制台输出所有员工的姓名和部门号。
DECLARE
      --声明部分
      CURSOR c_ename_deptno IS SELECT ename,deptno FROM emp;
      --定义两个变量
      v_ename emp.ename%Type;
      v_deptno emp.deptno%Type;
BEGIN
  --打开游标
  --OPEN c_ename_deptno;
  IF c_ename_deptno%ISOPEN THEN
    dbms_output.put_line('======');
    ELSE
      OPEN c_ename_deptno;
  LOOP
    --抓取数据并且移动游标的指针到下一条记录
    FETCH c_ename_deptno INTO v_ename,v_deptno;
    EXIT WHEN c_ename_deptno%NOTFOUND;
    dbms_output.put_line(v_ename || ',' || v_deptno);
    END LOOP;
     END IF;
    CLOSE c_ename_deptno;
  END;

--任务： 使用游标在控制台输出所有部门的部门名称。（使用WHILE循环语句）
DECLARE
      CURSOR c_dept IS SELECT * FROM dept;
     -- v_dept dept%rowtype;
     v_dept c_dept%rowtype;--可以参照游标类型
        -- dbms_output.put_line(v_dept.dname || ',' || v_dept.deptno || ',' || c_dept%rowcount );--无法编译出来
BEGIN
  OPEN c_dept;
  FETCH c_dept INTO v_dept;
     -- dbms_output.put_line(v_dept.dname || ',' || v_dept.deptno || ',' || c_dept%rowcount );
  WHILE c_dept%FOUND LOOP
    dbms_output.put_line(v_dept.dname || ',' || v_dept.deptno || ',' || c_dept%rowcount );
      FETCH c_dept INTO v_dept;
    END LOOP;
       -- dbms_output.put_line(v_dept.dname || ',' || v_dept.deptno || ',' || c_dept%rowcount );--输出OPERATIONS,40,4
  CLOSE c_dept;
  --dbms_output.put_line(v_dept.dname || ',' || v_dept.deptno || ',' || c_dept%rowcount );--无效字段
  END;

--任务： 使用游标在控制台输出员工的所有信息包括部门信息。
DECLARE
  CURSOR c_ed IS SELECT e.*,d.loc,d.dname FROM emp e,dept d WHERE e.deptno=d.deptno;
  v_ED c_ed%rowtype;
BEGIN
  OPEN c_ed;
  FETCH c_ed INTO v_ED;
  WHILE c_ed%FOUND LOOP
    dbms_output.put_line( v_ED.EMPNO);
    FETCH c_ed INTO v_ED;
    END LOOP;
  END;

--任务： 使用游标在控制台输出所有部门的部门名称。（使用FOR循环语句）
--for循环是隐式游标，不需要打开，关闭，以及移动游标。
DECLARE
      CURSOR c_dept IS SELECT * FROM dept;
      v_dept c_dept%rowtype;
BEGIN
  FOR v_dept IN c_dept LOOP
    dbms_output.put_line(v_dept,dname);
    END LOOP;
  END;

--带参数的游标
DECLARE
  CURSOR c_emp_deptno(v_deptno emp.deptno%type) IS SELECT * FROM emp WHERE deptno=v_deptno;
  v_emp emp%rowtype;
BEGIN
  OPEN c_emp_deptno(10);
  LOOP
   FETCH c_emp_deptno INTO v_emp;
    EXIT WHEN c_emp_deptno%NOTFOUND;
    dbms_output.put_line(v_emp.ename);
    END LOOP;
  CLOSE c_emp_deptno;
  END;

--异常也称为例外
BEGIN
  dbms_output.put_line(1/0);
  EXCEPTION--异常处理部分
    WHEN ZERO_DIVIDE THEN
      dbms_output.put_line('被0除');
  END;

DECLARE
v_emp emp%rowtype;
BEGIN
  SELECT * INTO v_emp FROM emp ;--WHERE ename='ssss';
  END;

--非系统异常：Oracle给了异常的编码和错误的信息，但是没有提供异常的名称，需要咱们自己提供
--提供异常的名称为了处理异常，因为处理异常只能使用异常的名称。
--案例：删除部门表中的数据，会出现异常
delete from dept;
DECLARE
       e_del   EXCEPTION;--异常名称
       PRAGMA EXCEPTION_INIT(e_del,-02292);
BEGIN
  delete from dept;
  EXCEPTION
    WHEN e_del THEN
      dbms_output.put_line('异常。。。。');
  END;

--任务：如果当前用户不是sys用户，不允许删除dept表中的记录
SELECT * FROM User_Users;--查询当前用户
DECLARE
       v_user VARCHAR2(20);
       e_prior EXCEPTION;
       PRAGMA EXCEPTION_INIT(e_prior,-20000);
BEGIN
  --SELECT username INTO v_user FROM user_users;
 -- IF v_user!='SYS' THEN
 IF user!='SYS' THEN
   -- RAISE_APPLICATION_ERROR(-20000,'权限不够');--抛出异常
   RAISE e_prior;
    END IF;
    EXCEPTION
      WHEN e_prior THEN
        dbms_output.put_line('不是SYS用户');
        dbms_output.put_line(sqlcode || ',' || sqlerrm);--把抛出异常的信息和名称打印出来
  END;

--触发器
--案例：往emp 表中插入一条记录，然后触发触发器去打印一句话
--语句触发器
CREATE OR REPLACE TRIGGER trigger_emp
BEFORE INSERT OR DELETE
ON emp
DECLARE
BEGIN
  dbms_output.put_line('test....');
  END;

INSERT INTO emp(empno) VALUES(9999);
DELETE FROM emp;
SELECT * FROM emp;

--行触发器
--:new在BEFORE触发器中赋值，取值；在AFTER触发器中取值。
CREATE OR REPLACE TRIGGER trigger_emp
BEFORE INSERT OR DELETE OR UPDATE
ON emp
FOR EACH ROW
DECLARE
BEGIN
  :new.ename:='zs';--赋值
  dbms_output.put_line(:new.empno);--取值
  END;
INSERT INTO emp(empno) VALUES(9999);
CREATE TABLE emp3 AS SELECT * FROM emp;
SELECT * FROM emp3;

--任务：创建一个AFTER行级触发器，
--更新员工备份表emp1后，
--将员工编号，修改之前的工资和修改后的工资的值及修改的时间保存到备份日志表emp_bak_log里。

--任务：生成自增长的主键
--建表
CREATE TABLE mytable(
       tid NUMBER(10) PRIMARY KEY,
       tname VARCHAR2(20)
       );
--创建序列
CREATE SEQUENCE seq_mytable;
INSERT INTO mytable VALUES(seq_mytable.Nextval,'AAA');
--创建一个触发器，生成主键
CREATE OR REPLACE TRIGGER trigger_mytable
BEFORE INSERT
ON mytable
FOR EACH ROW
  DECLARE
  BEGIN
    :new.tid:=seq_mytable.nextval;
    END;
--执行插入
    INSERT INTO mytable (tname)VALUES('AAA');
    COMMIT;
    SELECT * FROM mytable;
--自动生成序列号语句
SELECT sys_guid() FROM dual;
INSERT INTO t_stu(id) values(sys_guid());

--删除触发器
DROP TRIGGER trigger_mytable;
--查询所有的触发器
SELECT * FROM user_triggers;

-- 存储函数
-- 任务1：创建一个函数，根据输入的员工 id，具有输出某个员工的员工姓名的功能。
CREATE OR REPLACE FUNCTION get_ename_empno(v_empno emp.empno%type)
RETURN VARCHAR2
IS
  -- 声明部分
  v_ename emp.ename%type;
BEGIN
  -- 执行体
  SELECT ename INTO v_ename FROM emp WHERE empno=v_empno;
  RETURN v_ename;
END;

-- 调用存储函数
SELECT get_ename_empno(7369) FROM dual;
-- 通过PL/SQL语句调用存储函数
DECLARE
  v_ename emp.ename%type;
BEGIN
  v_ename := get_ename_empno(7369);
  dbms_output.put_line(v_ename);
END;


-- 通过员工的员工编号，查询出员工的部门名称和该员工的薪水等积极
-- in表示入参，默认就是in，out表示出参
CREATE OR REPLACE FUNCTION getDnameGradeByEmpno(
       v_empno in emp.empno%type,v_grade out salgrade.grade%type)
RETURN dept.dname%type  --return只能返回一个，另一个作为参数输出
AS
  v_dname dept.dname%type;
BEGIN
  SELECT dname,grade INTO v_dname,v_grade FROM emp e,dept d,salgrade s
  WHERE e.deptno=d.deptno AND e.sal BETWEEN s.losal AND s.hisal AND e.empno=v_empno;
  RETURN v_dname;
END;

-- 调用函数
DECLARE
   v_grade salgrade.grade%type;
   v_dname dept.dname%type;
BEGIN
   v_dname := getDnameGradeByEmpno(7369,v_grade);
   dbms_output.put_line(v_dname||','||v_grade);
END;

--任务1：定义一个带有IN参数的函数，用于计算emp表中指定某个部门员工的平均工资 （输入部门号，可以获取该部门的平均工资）
CREATE OR REPLACE FUNCTION getAvgsalByDeptno(
 v_deptno in emp.deptno%type)
 RETURN emp.sal%type
 AS
 v_avgsal emp.sal%type;
 BEGIN
   SELECT AVG(sal) INTO v_avgsal FROM emp
   WHERE deptno=v_deptno;
   RETURN v_avgsal;
   END;
DECLARE
   v_avgsal emp.sal%type;
BEGIN
  v_avgsal := getAvgsalByDeptno(10);
  dbms_output.put_line(v_avgsal);
  END;

--删除存储函数
DROP FUNCTION getDnameGradeByEmpno;

--存储过程
----案例1：SCOTT用户下创建一存储过程—查询雇员编号为7369的员工的入职时间，输出到控制台
CREATE OR REPLACE PROCEDURE getHiredateByEmpno(v_empno emp.empno%type,v_hiredate out emp.hiredate%type)
IS
BEGIN
  SELECT e.hiredate INTO v_hiredate FROM emp e WHERE empno=v_empno;
  END;

DECLARE
  v_hiredate emp.hiredate%type;
BEGIN
  getHiredateByEmpno(7369,v_hiredate);
  dbms_output.put_line(v_hiredate);
  END;

--任务4：写一个存储过程查询某个部门的所有员工信息
CREATE OR REPLACE PROCEDURE getempInfo(v_deptno emp.deptno%type)
AS
       CURSOR c_emp_deptno IS SELECT * FROM emp WHERE deptno=v_deptno;
BEGIN
  FOR mydept IN c_emp_deptno LOOP
    dbms_output.put_line(mydept.ename || ',' || mydept.empno);
    END LOOP;
  END;
 --调用
BEGIN
  getempInfo(10);
  END;

--另一种写法
CREATE OR REPLACE PROCEDURE pro_deptno2(v_deptno emp.deptno%type,
empList out sys_refcursor)--Oracle自动提供的一个游标
IS
BEGIN
  OPEN empList FOR SELECT * FROM emp WHERE deptno=v_deptno;
  END;
  --调用
  DECLARE
  empList SYS_REFCURSOR;--动态游标，值是不确定的
  v_emplist emp%rowtype;
  BEGIN
    pro_deptno2(20,empList);
    FETCH empList INTO v_emplist;
    WHILE empList %FOUND LOOP
      dbms_output.put_line(v_emplist.ename);
        FETCH empList INTO v_emplist;
      END LOOP;
    END;

