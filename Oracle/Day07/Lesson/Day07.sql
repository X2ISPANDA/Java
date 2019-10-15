/*
多表查询  内连接 外连接（左外，右外，完全外）
select * from a,b where a.字段=b.字段（内连接）
select * from a inner join b on a.字段=b.字段  where 子句

左连接：
select * from a,b where a.字段=b.字段（+） 匹配表加+，附加条件
select * from a LEFT join b on a.字段=b.字段  where 子句

右连接：
select * from a,b where a.字段=b.字段（+）
select * from b RIGHT join a on a.字段=b.字段  where 子句

完全外连接：
select * from b FULL join a on a.字段=b.字段  where 子句
视图：
CREATE VIEW 视图名 AS  SELECT 语句
怎么使用视图
增删改查，一般进行查询使用
select * from 视图名称

子查询：
1.子查询位置：select , from , where , having
单行子查询，多行子查询（子查询返回的是多行还是单行）
单行子查询用操作符>,=,<...
多行子查询 any,all,in
非关联子查询--先执行的是子查询，根据子查询结果来执行外查询
关联子查询（exists）--从外部开始查询

分页查询
最内层：排序
中间：出现rownum
最外层：要的第几条到第几条
*/

DECLARE
--声明部分（可以省略）
BEGIN
  --执行体
  dbms_output.put_line('helloworld');
  --异常
END;
--任务   在控制台输出自我介绍内容，输出二句话“你好，我是***”，“我今年**岁了”。
BEGIN
  dbms_output.put('你好，我是禹元宰');
  dbms_output.put_line('我今年25岁了');
  END;
--声明变量
DECLARE
  v_age NUMBER(3) ;--声明
  v_name VARCHAR2(20) :='郑帝元';
BEGIN
  v_age :=25;--赋值
  dbms_output.put_line(v_name || ',' || v_age);
  END;

--用sql语句赋值
DECLARE
  v_name VARCHAR2(10);
  v_sal NUMBER(7,2);
  v_age NUMBER(3) :=&age;
  v_des VARCHAR2(20) :=&des;
  c_pi CONSTANT NUMBER(3,2) :=3.14;--常量不能重复赋值
  v_flag BOOLEAN :=true;
BEGIN
  SELECT ename,sal INTO v_name,v_sal FROM emp WHERE empno=7369;
  dbms_output.put_line(v_name || ',' || v_sal || ',' || v_age || ',' || v_des);
  dbms_output.put_line(c_pi);
  if v_flag then
    dbms_output.put_line('aaaa...');
    else
      dbms_output.put_line('bbbb...');
  end if;
  END;
--复合数据类型
DECLARE
--声明一个记录类型
  TYPE v_record_type IS RECORD(
           v_name VARCHAR2(20),
           v_age NUMBER(3));
           --声明一个变量是上面记录的类型
  v_record v_record_type;
BEGIN
  --给记录类型的变量赋值
  v_record.v_name :='lisi';
  v_record.v_age :=20;
  --取值 记录类型的变量名.属性名
  dbms_output.put_line( v_record.v_name || ',' || v_record.v_age);
  END;

--参照类型%type, %rowtype
--%type 参照某个表里的某个字段
--%rowtype 参照的是某个表
DECLARE
             v_ename emp.ename%type;
             v_sal emp.sal%type;
BEGIN
  SELECT ename,sal INTO v_ename,v_sal FROM emp WHERE empno=7369;
  dbms_output.put_line(v_ename || v_sal);
  END;

DECLARE
  v_emp emp%rowtype;
BEGIN
  SELECT * INTO v_emp FROM emp WHERE empno=7369;
  dbms_output.put_line(v_emp.empno||v_emp.ename||v_emp.sal);
  END;

--任务：声明一个%ROWTYPE类型的变量v_dept, 然后使用该变量存储dept表中的20号部门的一行数据，输出这个部门的部门名称。
DECLARE
    v_dept dept%rowtype;
BEGIN
  SELECT * INTO v_dept FROM dept WHERE deptno=20;
  dbms_output.put_line(v_dept.dname);
  END;

--案例：比较两个数的大小
DECLARE
  v_num1 NUMBER(3) :=&num1;
    v_num2 NUMBER(3) :=&num2;
BEGIN
  if v_num1>v_num2 THEN
    dbms_output.put_line(v_num1 || '>' || v_num2);
    ELSIF v_num1<v_num2 THEN
        dbms_output.put_line(v_num1 || '<' || v_num2);
        ELSE
              dbms_output.put_line(v_num1 || '=' || v_num2);
              END IF;
  END;

--任务一： 使用CASE条件语句判断ALLEN员工薪水的等级，薪水在1000以下，等级为1，
--1000~2000之间，等级为2，薪水在2000~3000之间，等级为3，
--薪水在3000~5000之间，等级为4,   5000以上（含5000）等级为5
DECLARE
    v_sal emp.sal%type;
BEGIN
  SELECT sal INTO v_sal FROM emp WHERE ename='ALLEN';
  CASE WHEN v_sal<1000 THEN
    dbms_output.put_line('1');
    WHEN v_sal>=1000 AND v_sal<2000 THEN
      dbms_output.put_line('2');
      WHEN v_sal>=2000 AND v_sal<3000 THEN
      dbms_output.put_line('3');
      WHEN v_sal>=3000 AND v_sal<5000 THEN
      dbms_output.put_line('4');
      ELSE
        dbms_output.put_line('5');
        END CASE;
  END;

--案例1：比较两个数的大小，如果第一个数小于第二个数，第一个就自动加1，如果第一个数大于第二个数，第一个数自动减1 ,直到两个数相等，跳出循环,。
DECLARE
      v_num1 NUMBER(3) :=3;
      v_num2 NUMBER(3) :=8;
BEGIN
  LOOP
    IF v_num1<v_num2 THEN
      v_num1 :=v_num1+1;
      ELSIF v_num1>v_num2 THEN
        v_num1 :=v_num1-1;
        ELSE
          EXIT;
          END IF;
    END LOOP;
    dbms_output.put_line(v_num1 || ',' || v_num2);
  END;
--案例：使用WHILE循环比较两个数字v_num1和v_num2,v_num1初始值为80，v_num2的值为90，循环加1，当v_num1等于v_num2时退出循环。
DECLARE
  v_num1 NUMBER(3) :=80;
    v_num2 NUMBER(3) :=90;
BEGIN
  WHILE v_num1<v_num2 LOOP
  v_num1:=v_num1+1;
  END LOOP;
    dbms_output.put_line(v_num1 || ',' || v_num2);
  END;

--例如：用FOR循环写出从1+2+3…+100
DECLARE
  v_sum NUMBER(5) :=0;
BEGIN
  FOR v_num IN REVERSE 1..100--REVERSE倒序相加
    LOOP
      v_sum :=v_sum+v_num;
                dbms_output.put_line(v_sum);
      END LOOP;
          dbms_output.put_line(v_sum);
  END;

--任务一：  用LOOP循环编程输出1+2+3+...+100的值
DECLARE
         v_sum NUMBER(5) :=0;
         v_num1 NUMBER(3) :=0;
         v_num2 NUMBER(3) :=100;
BEGIN
  LOOP
    IF v_num1<v_num2 THEN
      v_num1 :=v_num1+1;
      v_sum :=v_num1+v_sum;
      ELSIF v_num1>v_num2 THEN
        v_num1 :=v_num1-1;
              v_sum :=v_num1+v_sum;
        ELSE
          EXIT;
          END IF;
    END LOOP;
              dbms_output.put_line(v_sum);
  END;
--用WHILE循环编程输出1+2+3+...+100的值
DECLARE
  v_sum NUMBER(5) :=0;
  v_num1 NUMBER(3) :=0;
  v_num2 NUMBER(3) :=100;
BEGIN
  WHILE v_num1<v_num2 LOOP
    v_num1:=v_num1+1;
    v_sum:=v_num1+v_sum;
    END LOOP;
    dbms_output.put_line(v_sum);
  END;
--任务1：打印九九乘法口诀表
DECLARE
BEGIN
  FOR V_NUM IN 1..9
    LOOP
      FOR V_TUM IN 1..V_NUM
        LOOP
        DBMS_OUTPUT.PUT(V_NUM||'*'||V_TUM||'='||V_NUM*V_TUM||'  ');
      END LOOP;
      DBMS_OUTPUT.PUT_LINE(chr(10));
    END LOOP;
END;

