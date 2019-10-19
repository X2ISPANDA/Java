# SQL总复习

- SQL语言分类
  - DDL数据定义语言	
  - DML数据操纵语言
  - DQL数据查询语言
  - DCL数据控制语言
  - TCL事务控制语言
- 常见数据类型
  - CHAR()定长字符串
  - VARCHAR2()变长字符串,建议在ORACLE中使用VARCHAR2()
  - NUMBER()数值类型
  - DATE日期类型
  - BLOB大数据类型
  - CLOB大数据类型

## DDL

- 创建数据表
  - 约束
    - NOT NULL 非空约束
    - UNIQUE 唯一约束
    - PRIMARY KEY 主键约束
    - FOREIGN KEY 外键约束
    - CHECK() 条件约束
  - 创建约束
    - 列级约束:`CREATE TABLE 表名1(
      字段1  数据类型1  PRIMARY KEY  ，
      字段2   数据类型2   NOT NULL，
      字段3    数据类型3   UNIQUE，
      字段4    数据类型4   CHECK(条件),
      字段5    数据类型5   DEFAULT,
      字段6    数据类型6  REFERENCES 表名2（字段）
      );`
    - 表级约束:`CREATE TABLE 表名(
      字段1  数据类型1  ，
      字段2   数据类型2，
      字段3    数据类型3，
      字段4    数据类型4,
      CONSTRAINT 约束名  PRIMARY KEY(字段1) ,
      CONSTRAINT  约束名  FOREIGN KEY(字段4) REFERENCES 表名2(字段)
      ）；`
    - 增加约束:`ALTER TABLE 表名 ADD CONSTRAINT 约束名 PRIMARY KEY(); `
- 修改数据表
  - 增加字段:`ALTER TABLE 表名 ADD(列名 数据类型(长度),……)`
  - 删除字段:`ALTER TABLE 表名 DROP(列名)或者 ALTER TABLE 表名 DROP COLUMN 列名`
  - 修改表名:`RENAME 表名 TO 新表名`或`ALTER TABLE 表名 RENAME TO 新表名`
- 删除数据表
  - DROP TABLE 表名
  - TRUNCATE TABLE 表名 `清空数据`

## DML 

- 插入数据INSERT

  - 插入完整记录:`INSERT INTO 表名 VALUES (,,,)`
  - 插入指定列数:`INSERT INTO 表名 (字段1,字段2,字段3,....) VALUES (v1,v2,v3,....)`

  > 字符串和日期类型需要用单引号

- 修改更新数据UPDATE

  - 更新单列:`UPDATE 表名 SET 列名= 新值`
  - 更新多列:`UPDATE 表名 SET 列名1=新值,列名2= 新值,...`
  - 更新指定记录:`UPDATE 表名 SET 字段名 = 新值 WHERE 条件`

- 删除数据DELETE

  - 删除所有记录:`DELETE FROM 表名`
  - 删除指定记录`DELETE FROM 表名 WHERE ...`

## 序列

- 创建序列

  - `CREATE SEQUENCE 序列名
    INCREMENT BY n
    START WITH n
    [MAXVALUE n][MINVALUE n]
    [CYCLE|NOCYCLE]
    [CACHE n|NOCACHE];`

    > 若未指定cycle,当值大于maxvalue将直接报错

- 使用序列

  1. 初始化 ` SELECT 序列名.nextval FROM dual`
  2. 直接使用nextval或currval

- 删除序列

  `DROP SEQUENCE 序列名`

## TCL

> 事务是对数据库操作的逻辑单位。

### 事务的操作

- 提交COMMIT
- 回滚事务ROLLBACK
- 保存点SAVEPOINT

### 事务的特性ACID

- Atomicity原子性
- Consistency一致性
- Isolation隔离性
- Durability持久性

## DQL

1. 查询所有、指定字段

   SELECT * FROM 表名【WHERE ...】

2. 定义别名

   SELECT 字段 【AS】 别名 FROM 表名 别名

   ***定义表别名不能有AS***

3. 连接符||

4. 去掉重复行DISTINCT

   SELECT DISTINCT 列名 FROM 表名

5. 比较运算符

   - ANY()
   - ALL()

6. 逻辑运算符

   - NOT
   - AND
   - OR

   > 执行顺序：１.比较运算符２.非与或

7. 特殊关键字

   - BETWEEN...AND...  包含边界
   - IN(V1,V2,V3,...) 匹配列出的值
   - LIKE 匹配字符
   - IS NULL/ NOT NULL 是空值/不是空值

8. ORDER BY排序

   - 升序ASC
   - 降序DESC

9. GROUP BY分组

   - 分组函数

     - MIN()
     - MAX()
     - AVG()
     - SUM()
     - COUNT()

     `SELECT中没有在分组函数中出现的列必须在GROUP BY中出现`

   - HAVING子句：对分组后的结果再进行筛选

10. 书写顺序和执行顺序

    > 书写顺序:SELECT-FROM-WHERE-GROUP BY-HAVING-ORDER BY
    >
    > 执行顺序:FROM-WHERE-GROUP BY-HAVING-SELECT-ORDER BY

11. 常用函数

    - 字符函数
      - LOWER()
      - UPPER()
      - INITCAP()返回首字母大写
      - LENGTH()
      - SUBSTR(String,start_index,length)
      - TRIM(String)
    - 数值函数
      - 四舍五入ROUND()
      - 取模操作MOD()
      - 截取数字TRUNC(0
    - 日期函数
      - SYSDATE当前日期
      - TO_DATE(StrDate，格式)将字符串转换成日期
      - ADD_MONTHS(date，n) 为指定日期加上月份
      - LAST_DAY(date,n) 为日期加上指定月份
      - LAST_DAY(date) 返回该月份最后一天
      - MONTHS_BETWEEN(date1，date2)返回两个日期所差的月数
      - NEXT_DAY(date，n)返回特定日期之后的一周内的日期
      - EXTRACT()返回日期的某个域
    - 转换函数
      - TO_CHAR() 把日期型或数值型数据转换成变长字符串
      - TO_NUMBER() 字符串转数字
      - TO_DATE() 把字符串转换成日期
    - 通用函数
      - 空值处理函数NVL()
      - 结果集的行号ROWNUM

12. CASE WHEN 表达式

    SELECT CASE 字段 WHEN .... THEN....  WHEN  ....  THEN... ELSE ... END

    SELECT CASE WHEN ...THEN... WHEN .... THEN ELSE ... END 

13. DECODE 函数

    DECODE(条件,v1,r1,v2,r2,.......,vn,rn,缺省值)

14. 内连接

    SELECT  字段列表 FROM 表名1 INNER JOIN 表名2 ON ...

15. 自连接

    SELECT 字段列表 FROM 表名 t1,表名 t2 WHERE ....

16. 外连接

    左外连接:`SELECT 字段列表 FROM 表名1 LEFT OUTER JOIN 表2 t2 ON t1.字段 = t2.字段`

    右外连接:`SELECT 字段列表 FROM 表名1 RIGHT OUTER JOIN 表2 t2 ON t1.字段 = t2.字段`<=> `SELECT 字段列表 FROM 表名1 t1.字段(+) = t2.字段`

    完全外连接:`SELECT 列名列表 FROM 表名1 FULL OUTER JOIN 表名2 ON 表名1.列名=表名2.列名`

17. 视图

    - 创建视图

      CREATE VIEW 视图名 AS SELECT语句 [WITH READ ONLY] [WITH CHECK OPTION]

18. 集合操作

    - 并集

      SELECT 语句1 UNION [ALL](去除结果集) SELECT 语句2

    - 交集

      SELECT 语句1 INTERSECT SELECT 语句2

    - 差集

      SELECT 语句1 MINUS SELECT 语句2

19. 分页查询

    `SELECT  *  FROM
     (SELECT  ROWNUM r,s_id,s_name,sex,phone FROM  student1) t 
    WHERE  t.r>20*(3-1)  AND  t.r<=20*3;`

20. 索引

    - 创建索引

      > CREATE INDEX 索引名称 ON 表名(字段1,字段2) 

## PL/SQL

### 基本结构

> DECLARE – 可选部分
>
> 变量、常量、复合数据类型、游标、用户定义异常的声明
> 	
> BEGIN – 必要部分
> SQL语句和PL/SQL语句构成的执行程序
> [EXCEPTION --异常处理部分]
>
> END; - 必要部分。



### 变量和常量

- 变量的定义

  变量名 数据类型 := 值

- 变量的赋值

  - 直接赋值

  - SQL中赋值

  - 从控制台输入值

    使用&变量名

- 常量的定义

  常量名 CONSTANT 数据类型 := 常量值;

### 数据类型

- 复合数据类型(RECORD)

  TYPE 记录名 IS RECORD (

  变量名 数据类型  [NOT NULL] [:= exp1 ],

  变量名 数据类型  [NOT NULL] [:= exp2 ],

  ....

  )

- 参照数据类型

  参照变量类型%TYPE

  参照记录类型%ROWTYPE

### 流程控制

- 选择语句

  - IF

    > 案例:比较两个数的大小
    >
    > DECLARE
    >
    > v_num1 INTEGER :=800;
    >
    > v_num2 INTEGER :=90
    >
    > BEGIN
    >
    > ​	IF v_num1>=v_num2
    >
    > ​		THEN 
    >
    > ​			dbms_output.put_line(v_num1 ||'>='|| v_num2);
    >
    > ​	END IF;
    >
    > END;

  - IF......ELSE

  - IF......ELSIF......ELSE

  - CASE语句

    > 案例:判断ALLEN员工工资等级,薪水在1000以下，等级为1，
    > 1000~2000之间，等级为2，薪水在2000~3000之间，等级为3，
    > 薪水在3000~5000之间，等级为4, 5000以上（含5000）等级为5
    >
    >
    > DECLARE
    > v_sal NUMBER(7,2);
    > v_grade NUMBER(5);
    > BEGIN
    > SELECT sal INTO v_sal FROM emp WHERE ename = 'ALLEN';
    > CASE WHEN v_sal<1000  THEN v_grade:=1; 
    >     WHEN v_sal>=1000 AND v_sal<2000 THEN v_grade:=2;
    >     WHEN v_sal>=2000 AND v_sal<3000 THEN v_grade:=3;
    >     WHEN v_sal>=3000 AND v_sal<5000 THEN v_grade:=4;
    >     ELSE v_grade:=5;
    > END CASE;
    > dbms_output.put_line('ALLEN的工资等级是'||v_grade);
    >
    > END;

- 循环语句

  - LOOP

    > 案例:比较两个数的大小，如果第一个数小于第二个数，第一个就自动加1，如果第一个数大于第二个数，第一个数自动减1 ,直到两个数相等，跳出循环。
    >
    > DECLARE
    > v_first INTEGER := 80;
    > v_second INTEGER := 90;
    > BEGIN
    > DBMS_OUTPUT.PUT_LINE('循环前'||v_first);
    > LOOP
    > IF v_first  < v_second  THEN
    >   v_first := v_first+1;   
    >   DBMS_OUTPUT.PUT_LINE(v_first);
    >   IF v_first = v_second THEN
    >   EXIT;     
    >   END IF;
    > END IF;
    >
    > IF v_first = v_second THEN
    >   DBMS_OUTPUT.PUT_LINE(v_first);
    >   EXIT;
    > END IF;
    >
    > IF v_first > v_second THEN
    >   v_first := v_first - 1;
    >   DBMS_OUTPUT.PUT_LINE(v_first);
    >   IF v_first = v_second THEN
    >     EXIT;
    >   END IF;
    > END IF;      
    > END LOOP; 
    > DBMS_OUTPUT.PUT_LINE('循环完后'||v_first);  
    > END;

  - WHILE

    > 案例:使用WHILE循环比较两个数字v_num1和v_num2,v_num1初始值为80，v_num2的值为90，循环加1，当v_num1等于v_num2时退出循环。
    > 	DECLARE
    > 		    v_num1 INTEGER:= 80;
    > 		    v_num2 INTEGER := 90;
    > 	BEGIN
    > 		    WHILE v_num1 < v_num2 LOOP
    > 	  v_num1 := v_num1 + 1;
    > 	  dbms_output.put_line(v_num1);
    > 	 END LOOP;
    > END;`

  - FOR

    `案例：用FOR循环写出从1+2+3…+100。`
    `DECLARE 
        v_sum INTEGER := 0;
    BEGIN
        FOR v_num IN 1..100  LOOP 
        v_sum := v_sum + v_num;      
        END LOOP;    
        DBMS_OUTPUT.PUT_LINE(v_sum);
    END;`

  ### 游标

  > 游标是从数据表中提取出来的数据，以临时表的形式存放在内存中，在游标中有一个数据指针，在初始状态下指向的是首记录，利用 FETCH 语句可以移动该指针，从而可以对游标的数据进行各种操作。

  #### 游标使用基本步骤

  1. 声明游标
  2. 打开游标
  3. 向游标中读取数据
  4. 关闭游标

  > 案例:使用游标在控制台输出所有员工的姓名和部门号。
  > DECLARE
  >  CURSOR  c_emp IS SELECT * FROM emp;
  >  v_emp emp%ROWTYPE;
  > BEGIN
  >    OPEN c_emp; 
  >    LOOP  
  >      FETCH c_emp INTO v_emp;  
  >      EXIT WHEN c_emp%NOTFOUND ;      
  >      dbms_output.put_line(v_emp.ename||' '||v_emp.deptno); 
  >    END LOOP;   
  >    CLOSE c_emp;
  > END;

  #### 游标的属性

  1. %ISOPEN 属性:测试游标是否打开
  2. %FOUND属性:测试前一个 FETCH语句是否有值
  3. %NOTFOUND属性:该属性是%FOUND的反逻辑
  4. %ROWCOUNT属性:用于返回游标的数据行数

  #### LOOP语句循环游标

  ``````sql
  DECLARE
  	CURSOR c_dept IS SELECT * FROM dept;
  	v_dept c_dept%ROWTYPE;
  BEGIN
  	OPEN c_dept;
  	LOOP
  		FETCH c_dept INTO v_dept; 
  		EXIT WHEN c_dept%NOTFOUND;
  		dbms_output.put_line(v_dept.dname);
  	END LOOP;
  	CLOSE 
  END;
  ``````

  #### WHILE语句循环游标

  > DECLARE
  > CURSOR  c_dept IS SELECT * FROM dept;
  > v_dept dept%ROWTYPE;
  > BEGIN
  >  OPEN c_dept; 
  >  FETCH c_dept INTO v_dept;     
  >  WHILE c_dept%FOUND  LOOP     
  >    dbms_output.put_line(v_dept.dname);
  >   FETCH c_dept INTO v_dept;             
  >  END LOOP;   
  >  CLOSE c_dept;
  > END;

  #### FOR语句循环游标

  > DECLARE
  > CURSOR  c_dept IS SELECT * FROM dept;
  > v_dept  c_dept%ROWTYPE;
  > BEGIN
  > FOR v_dept IN c_dept LOOP       
  >  dbms_output.put_line(v_dept.dname);             
  > END LOOP;        
  > END;                                                  

  #### 带参数的游标

  > 案例:显示10号部门的员工姓名和薪水。
  >
  > DECLARE 
  > CURSOR cur_emp(dno NUMBER) IS SELECT * FROM emp WHERE deptno = dno;
  > row_emp  cur_emp%ROWTYPE ;
  > BEGIN
  > OPEN cur_emp(10);
  > LOOP 
  >  FETCH cur_emp INTO row_emp;
  >  EXIT WHEN cur_emp%NOTFOUND;
  >  dbms_output.put_line(row_emp.ename||'的薪水是'||row_emp.sal);
  > END LOOP;
  > END;

### 异常处理

> 案例：以下代码中，出现了除数不能为零的异常
> BEGIN
> DBMS_OUTPUT.PUT_LINE('出现异常前'); 
> DBMS_OUTPUT.PUT_LINE(10/0);
> DBMS_OUTPUT.PUT_LINE('出现异常后');
> EXCEPTION
>  WHEN ZERO_DIVIDE THEN   
>  DBMS_OUTPUT.PUT_LINE('除数不能为零');
> END;

### 触发器

> 发生了相应的DML操作，那么会自动执行触发的相应代码

#### 语句触发器

> 案例:为公司的员工表t_emp建一个触发器，员工不得在非上班时间修改表里的数据。（以 t_emp 表为例）
> 	CREATE OR REPLACE TRIGGER deal_emp_trigger
> 	BEFORE INSERT OR UPDATE OR DELETE
> 	ON t_emp
> 	BEGIN
> 	  IF (TO_CHAR(sysdate,'day')  IN ('星期六','星期日')  OR     TO_NUMBER(TO_CHAR(sysdate,'hh24')) NOT BETWEEN 9  AND 17)
> 	         raise_application_error(-20000,'非法时间不得操作!!!');
> 	  END IF ;
> 	END;

#### 行触发器

> 案例:针对备份表emp1创建一个行触发器，如果执行插入，更新或删除操作就触发该行触发器，在控制台打印“测试”
> CREATE OR REPLACE TRIGGER del_emp_trigger
>  BEFORE INSERT OR UPDATE OR DELETE
>  ON emp1 
>  FOR EACH ROW
>  BEGIN      
>      DBMS_OUTPUT.PUT_LINE('测试');
>  END;

### 自定义函数

> 案例1:创建一个函数，根据输入的员工 id，具有输出某个员工的员工姓名的功能。
> --创建函数
> CREATE FUNCTION  emp_ename_func(fid  emp.empno%TYPE)
> RETURN VARCHAR2
> IS
> v_ename emp.ename%TYPE;
> BEGIN
> SELECT ename  INTO v_name
> FROM emp
> WHERE empno = fid;
> RETURN v_ename;
> END emp_ename_func;    

