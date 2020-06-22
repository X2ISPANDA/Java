### 一、PL/SQL介绍

#### 1.相关定义

 - PL/SQL也是一种程序语言，被叫做支持SQL的程序语言。

 - PL/SQL 是 Oracle 数据库独有的一种程序语言，是 Oracle 数据库对 SQL 语句的扩展。

 - 是把数据操作和查询语句组织在PL/SQL代码的过程性单元中，通过逻辑判断，循环等操作实现复杂的功能或者计算的程序语言。

#### 2.编写规则

##### （1）标识符命名规则

 - 标识符名称必须以字符开头，并且长度不能超过30个字符。

 - 当定义变量时，建议使用v_作为前缀，例如：v__sal 、v_job等

 - 当定义常量时，建议使用c_作为前缀，例如：c_rate

 - 当定义游标时，建议使用_cursor作为后缀或前缀，例如emp_cursor

 - 当定义异常时，建议使用e_作为前缀，例如e_integrity_error

 - 当定义PL/SQL类型时，建议使用_table_type作为后缀，例如: sal_table_type

 - 当定义PL/SQL表变量时，建议使用_tablename作为后缀，例如sal_emp

 - 当定义PL/SQL记录类型时，建议使用_record_type作为后缀，例如：emp_record_type

 - 当定义PL/SQL记录变量时，建议使用_record作为后缀，例如emp_record

 - 存储函数名称建议使用_func作为后缀，例如： raiseSal_func

 - 存储过程名称建议使用_proc作为后缀，例如：raiseSal_proc

#####（2）程序书写规则

 - SQL关键字采用大写格式，例如SELECT  、UPDATE等

 - PL/SQL关键字采用大写格式，例如DECLARE、BEGIN、END等

 - 数据类型采用大写格式，例如NUMBER、VARCHAR2、DATE等

 - 标识符和参数采用小写格式，例如v_sal 、c_rate等

 - 数据库对象和列采用小写格式，例如：emp、sal、ename等

 - PL/SQL里的存储函数名称和存储过程名称如果是由多个单词组成，第一个单词小写，后面的单词首字母大写。

#### 3.PL/SQL的基本结构

##### （1）组成

 - 块是PL/SQL的基本执行单元。

 - PL/SQL程序由三个块组成：声明定义部分（DECLARE）、执行部分（执行体开始BEGIN
 、执行体结束END）、异常处理部分(EXCEPTION)。

 - DECLARE – 可选部分：变量、常量、复合数据类型、游标、用户定义异常的声明

 - BEGIN – 必要部分

 - SQL语句和PL/SQL语句构成的执行程序：[EXCEPTION--异常处理部分]

 - END - 必要部分。

##### （2）相关注意

 - dbms_output 是 Oracle 所提供的系统包

 - put_line 是该包所包含的过程，用于输出字符串信息，输出后换行dbms_output.put(); 输出不换行。

 - 在SQL Plus或SQL Developer 想在控制台输出信息，需先执行SET SERVEROUTPUT ON; 打开输入输出方法但是在PL/SQL工具中不需要，也不支持，PL/SQL有自己的输入输出控制台。

### 二、常量和变量

#### 1.变量的定义

 - 格式：
```
变量名 数据类型  :=  值;
```

 - 所有变量必须在 DECLARE 中声明，程序中不允许声明。

 - 没有初始值的变量默认值为 NULL，PL/SQL 中变量一般以 v_ 开头

 - 可通过控制台接收用户输入信息  &变量名
 - 案例
```
定义一个变量v_name表示一个人的姓名，
再定义一个变量v_age表示这个人的年龄，
并在控制台输出这个人的姓名和年龄
    DECLARE
      v_name VARCHAR2(15):='zhangsan';
      v_age NUMBER(3):=25;
    BEGIN
      DBMS_OUTPUT.PUT_LINE('姓名：'||v_name);
      DBMS_OUTPUT.PUT_LINE('年龄:'||v_age);
    END;
```

#### 2.变量的赋值方式

##### （1）直接赋值

 - 可以定义的时候同时赋值
```
案例：定义一个变量并在控制台输出。
		  DECLARE
			v_age  NUMBER(3) :=26;--长度为3，初始值为26
		  BEGIN
			dbms_output.put_line(v_age);
		  END;
```
 - 可以先定义，后赋值
```
     DECLARE
     v_age  NUMBER(3);--长度为3，初始值为26
     BEGIN
       v_age:=26;
     dbms_output.put_line(v_age);
     END;
```

##### （2）SQL赋值

 - 数据库赋值是通过 SELECT语句来完成的，每次执行SELECT语句就赋值一次，一般要求被赋值的变量与SELECT中的列名要一一对应
 - 格式：
```
 SELECT  字段1 ，字段2，... INTO 变量1，变量2，...  FROM  表名……
```
 - 案例
```
案例：编写一个PL/SQL程序输出7369的姓名和薪水。
    DECLARE
      v_id  NUMBER(6):=7369;--定义一个变量v_id存储员工编号
      v_name  VARCHAR2(10);--定义一个v_name存储员工姓名
      v_sal   NUMBER(7,2);--定义一个变量存储员工薪水
    BEGIN
    --检索指定的值并存储到变量中
      SELECT ename,sal INTO v_name,v_sal FROM emp WHERE empno = v_id;
    --输出变量的值  
    dbms_output.put_line(v_name||'的薪水是'||v_sal);
    END;
```

##### （3）通过控制台接收用户输入信息：&变量名
 - 案例
```
输入一个整数和一个字符串，并输出这个整数和字符串的值
    DECLARE
      v_num NUMBER:=&NUMBER;
      v_char VARCHAR2(10):=&VARCHAR2;
    BEGIN
      dbms_output.put_line('v_num值为'||v_num);
      dbms_output.put_line('v_char的值为'||v_char);
    END;
```

#### 3.常量

 - 常量是指其值在程序运行过程中不可改变的数据存储结果。

 - 定义常量的标准语法格式如下：
```
  <常量名> CONSTANT <数据类型>:=<常量值>;
```
 - 案例
```
--案例：定义一个常量表示圆周率
    DECLARE
      c_pi CONSTANT NUMBER(8,5):=3.14159;
    BEGIN
      DBMS_OUTPUT.PUT_LINE(c_pi);
    END;
```

### 三、PL/SQL的数据类型

#### 1.简单数据类型(基本数据类型)

 - 数值类型：NUMBER[(precision,scale)]固定长度的整数和浮点数

 - 字符类型：CHAR[(maxlength)] 定长字符串类型，最大存2000字节。

 - VARCHAR2(maxlength) 变长字符串类型，最大长度是4000字节。

 - LONG类型：表示一个可变的字符串，最大长度是32767字节，而数据库类型的LONG最大长度可达2GB。

 - NCHAR和NVARCHAR2类型，根据各国字符集确定其长度。

 - 日期类型：DATE 类型：用来存储日期和时间，存储空间是7个字节。

 - 布尔类型：BOOLEAN类型：主要用于程序的流程控制和业务逻辑判断，其变量的值可以是TRUE、FALSE或NULL中的一种。

#### 2.复合数据类型

 - 与简单类型不同，复合变量类型不是数据库中已经存在的数据类型，所以复合变量在声明类型之前，首先要创建使用到的复合类型，然后将变量声明为复合类型。

 - RECORD:记录类型

 - 记录类型：记录是由一组相关的记录成员（Field）组成的.

 - 创建类型格式：
```
    TYPE 记录类型名 IS RECORD(  
    Field1 type1 [NOT NULL] [:= exp1 ],
    Field2 type2 [NOT NULL] [:= exp2 ],
    ...
    Fieldn typen [NOT NULL] [:= expn ] );
```

 - RECORD 类型变量声明时可以为 NULL，但必须赋初始值，引用记录型变量的方法是“记录变量名.基本类型变量名”

#### 3.参照数据类型

##### （1）%TYPE

 - 与某个表中的某个字段相匹配

 - 使用%TYPE特性的优点：所引用的数据库列的数据类型可以不必知道；所引用的数据库列的数据类型可以实时改变。
```
案例：在SCOTT模式下，使用%TYPE类型的变量输出emp表中编号为7369的员工姓名和职务信息。
    DECLARE
      v_name emp.ename%TYPE;
      v_job  emp.job%TYPE;
    BEGIN
      SELECT ename,job INTO v_name,v_job FROM emp WHERE empno=7369;
      DBMS_OUTPUT.PUT_LINE(v_name||'的职务是'||v_job );
    END;
```

##### （2）%ROWTYPE

 - 与某个表相匹配

 - 使用%ROWTYPE特性的优点：所引用的数据库列的数据类型可以不必知道；所引用的数据库列的数据类型可以实时改变。
```
案例：
声明一个%ROWTYPE类型的变量v_rowVar_emp,
然后使用该变量存储emp表中员工编号为7369的一行数据，
输出这个雇员的姓名，编号，职务。
    DECLARE
      v_rowVar_emp emp%ROWTYPE;
    BEGIN
      SELECT * INTO v_rowVar_emp FROM emp WHERE empno = 7369;
      dbms_output.put_line(v_rowVar_emp.ename
        ||v_rowVar_emp.empno||v_rowVar_emp.job);
    END;
```

### 四、流程控制

#### 1.选择

##### （1）IF

 - 语法格式
```
  IF 布尔表达式 THEN 执行语句；
  END IF;
```

##### （2）IF……ELSE 语句

 - 语法格式：
```
	IF 布尔表达式 THEN 执行语句;
		ELSE 执行语句;
    END IF;
```

##### （3）IF……ELSIF……ELSE语句

 - 语法格式：
```
	IF 布尔表达式 THEN 执行语句;
		ELSIF 布尔表达式 THEN 执行语句;
		ELSE 执行语句;
		END IF;
```

 - 案例
```
例如：数字比较
		DECLARE
 		v_num1 INTEGER := 700;
 		v_num2 INTEGER := 80;
		BEGIN
  		IF v_num1 < v_num2 THEN
     	 dbms_output.put_line(v_num1 ||'<'|| v_num2);
       ELSIF v_num1 > v_num2 THEN
        dbms_output.put_line(v_num1 ||'>'|| v_num2);
        ELSE
      dbms_output.put_line(v_num1 ||'='|| v_num2);
        END IF;
      END;
```

##### （4）简单CASE语句语法：

 - 语法格式
```
CASE search_expression
     WHEN expression1 THEN  result1;
     WHEN expression2 THEN  result2;
    ...
    WHEN expressionn THEN resultn;
    [ELSE default_result;]
END CASE;
```

##### （5）搜索CASE语句语法：

 - 语法格式
```
CASE
     WHEN condition1  THEN result1;
     WHEN condition2  THEN result2;
      ...
     WHEN conditionn  THEN resultn;
     [ELSE default_result;]
END CASE;
```

#### 2.循环

##### （1）LOOP

 - 循环一：LOOP…EXIT…END…LOOP;
```
格式：
		LOOP   
			循环语句段;
			IF 条件语句  THEN  
				EXIT;
			ELSE
			不退出循环的处理语句段;
			END IF;
		END LOOP;
```
```
案例1：比较两个数的大小，如果第一个数小于第二个数，第一个就自动加1，
      如果第一个数大于第二个数，第一个数自动减1 ,直到两个数相等，跳出循环.
    DECLARE
        v_first INTEGER := 80;
        v_second INTEGER := 90;
      BEGIN
        DBMS_OUTPUT.PUT_LINE('循环前'||v_first);
        LOOP
          IF v_first  < v_second  THEN
            v_first := v_first+1;   
            DBMS_OUTPUT.PUT_LINE(v_first);
            IF v_first = v_second THEN
            EXIT;     
            END IF;
          END IF;
```

 - 循环二：LOOP…EXIT WHEN…END…LOOP
```
格式：
		LOOP      
 			要执行的语句;  
    	  EXIT WHEN <条件语句>  /*条件满足，退出循环语句*/  
		END LOOP;
```
```
例如：当两个数相等时跳出循环
     DECLARE
        v_first INTEGER := 80;
        v_second INTEGER := 90;
      BEGIN
        DBMS_OUTPUT.PUT_LINE('循环前'||v_first);
        LOOP
          IF v_first < v_second  THEN
            DBMS_OUTPUT.PUT_LINE(v_first);
            v_first := v_first+1;   
          ELSIF v_first > v_second THEN
            DBMS_OUTPUT.PUT_LINE(v_first);
            v_first := v_first - 1;      
          ELSE
             DBMS_OUTPUT.PUT_LINE(v_first);
             EXIT WHEN v_first = v_second;
          END IF;          
        END LOOP;
        DBMS_OUTPUT.PUT_LINE('循环完后'||v_first);
      END;
```

##### （2）WHILE…LOOP…END LOOP

 - 语法格式：
```
	WHILE <布尔表达式>  LOOP 要执行的语句; END LOOP;
```

 - 案例
```
使用WHILE循环比较两个数字v_num1和v_num2,
v_num1初始值为80，v_num2的值为90，循环加1，
当v_num1等于v_num2时退出循环。
		DECLARE
  		    v_num1 INTEGER:= 80;
  		    v_num2 INTEGER := 90;
		BEGIN
  		    WHILE v_num1 < v_num2 LOOP
         v_num1 := v_num1 + 1;
         dbms_output.put_line(v_num1);
        END LOOP;
    END;
```

##### （3）FOR
 - 格式：
```
		FOR 循环计数器（变量） IN [ REVERSE ] 下限 .. 上限
        LOOP   要执行的语句;
       END LOOP;
```

 - 案例
```
用FOR循环写出从1+2+3…+100
    DECLARE
        v_sum INTEGER := 0;
    BEGIN
        FOR v_num IN 1..100  LOOP
        v_sum := v_sum + v_num;      
        END LOOP;    
        DBMS_OUTPUT.PUT_LINE(v_sum);
    END;
```

### 五、游标

#### 1.游标相关知识

##### （1）定义

 - 游标是从数据表中提取出来的数据

 - 在游标中有一个数据指针，在初始状态下指向的是首记录，

 - 利用 FETCH 语句可以移动该指针，从而可以对游标的数据进行各种操作。

##### （2）游标的分类

 - 显式游标主要是用于对查询语句的处理，尤其是在查询结果为多条记录的情况下；而
 对于非查询语句，如修改、删除操作，则由ORACLE 系统自动地为这些操作设置游标并创
 建其工作区，隐式游标的名字为SQL，这是由ORACLE 系统定义的。

 - 对于隐式游标的操作，如定义、打开、取值及关闭操作，都由ORACLE 系统自动地完成，无需用户进行处理。

#### 2.显式游标的基本步骤

##### （1）声明游标

 - 格式：
```
    CURSOR 游标名 IS SELECT 语句
```

 - CURSOR 是定义游标的关键字

 - SELECT 是建立游标的数据表查询命令

##### （2）打开游标

 - 格式：
```
    OPEN  游标名;
```

 - 打开游标的过程有两个步骤：
```
    1.将符合条件的记录送入内存
    2.将指针指向第一个记录
```

##### （3）提取数据（检索游标）

 - 格式：
```
    FETCH 游标名 INTO 记录型变量名;
```

##### （4）关闭游标

 - 格式：
```
    CLOSE 游标名;
```
```
任务1： 使用游标在控制台输出所有员工的姓名和部门号。
    DECLARE
    CURSOR c_emp IS SELECT * FROM emp;
    v_emp emp%rowtype;
    BEGIN
    OPEN c_emp;
    LOOP
    FETCH c_emp INTO v_emp;
    EXIT WHEN c_emp%NOTFOUND;
    dbms_output.put_line(v_emp.ename || ',' || v_emp.deptno);
    END LOOP;
    CLOSE c_emp;
    END;
```

#### 3.游标的属性

##### （1）%ISOPEN 属性

 - 属性功能：测试游标是否打开，如果没有打开就是用 FETCH 语句会提示错误；

 - 案例
```
测试游标是否打开
    DECLARE
    CURSOR c_emp IS SELECT * FROM emp;
    v_emp emp%rowtype;
    BEGIN
    OPEN c_emp;
    IF c_emp%ISOPEN THEN
    dbms_output.put_line('打开');
    ELSE
    dbms_output.put_line('未打开');
    END IF;
    END;
```

##### （2）%FOUND 属性

 - 属性功能：测试前一个 FETCH语句是否有值，有则返回 TRUE，否则返回 FALSE

 - 案例
```
任务2：使用游标在控制台输出所有员工的姓名和部门号。（使用WHILE循环语句）
    DECLARE
    CURSOR c_emp IS SELECT * FROM emp;
    v_emp emp%rowtype;
    BEGIN
    OPEN c_emp;
    FETCH c_emp INTO v_emp;
    WHILE c_emp%FOUND LOOP
    dbms_output.put_line(v_emp.ename || ',' || v_emp.deptno);
    FETCH c_emp INTO v_emp;
    END LOOP;
    CLOSE C_EMP;
    END;
```

##### （3）%NOTFOUND

 - 属性：该属性是%FOUND的反逻辑

##### （4）%ROWCOUND

 - 属性：属性功能：用于返回游标的数据行数

 - 案例
```
任务： 使用游标在控制台输出所有员工的姓名和部门号,并打印返回的游标数据记录。
DECLARE   
    CURSOR  c_emp IS SELECT * FROM emp;
    v_emp c_emp%ROWTYPE;
  BEGIN
    OPEN c_emp;
    LOOP  
      FETCH c_emp INTO v_emp;  
      EXIT WHEN c_emp%NOTFOUND ;      
        dbms_output.put_line(v_emp.ename||' '||v_emp.deptno);
        dbms_output.put_line(c_emp%ROWCOUNT);
      END LOOP;     
      dbms_output.put_line(c_emp%ROWCOUNT);
      CLOSE c_emp;
  END;
```

#### 4.循环语句

##### （1）LOOP语句循环游标
```
任务： 使用游标在控制台输出所有部门的部门号和部门名称。（使用LOOP循环语句）
    DECLARE
    CURSOR c_dept IS SELECT * FROM dept;
    v_dept dept%rowtype;
    BEGIN
    OPEN c_dept;
    LOOP
    FETCH c_dept INTO v_dept;
    EXIT WHEN c_dept%NOTFOUND;
    dbms_output.put_line(v_dept.deptno || v_dept.dname);
    END LOOP;
    CLOSE c_dept;
    END;
```

##### （2）WHILE语句循环游标
```
任务： 使用游标在控制台输出所有部门的部门名称。（使用WHILE循环语句）
    DECLARE
    CURSOR c_dept IS SELECT * FROM dept;
    v_dept dept%rowtype;
    BEGIN
    OPEN c_dept;
    FETCH c_dept INTO v_dept;
    WHILE c_dept%FOUND LOOP
    dbms_output.put_line(v_dept.dname);
    FETCH c_dept INTO v_dept;
    END LOOP;
    CLOSE c_dept;
    END;
```

##### （3）FOR语句循环游标（隐式游标）
```
任务： 使用游标在控制台输出所有部门的部门名称。（使用FOR循环语句）
    DECLARE
       CURSOR  c_dept IS SELECT * FROM dept;
       v_dept  c_dept%ROWTYPE;
    BEGIN
      FOR v_dept IN c_dept LOOP       
        dbms_output.put_line(v_dept.dname);             
      END LOOP;        
    END;
```

##### （4）带参数的游标
```
任务：显示10号部门的员工姓名和薪水。
    DECLARE
    CURSOR c_emp(v_deptno emp.deptno%type) IS
    SELECT * FROM emp WHERE deptno = v_deptno;
    v_emp emp%rowtype;
    BEGIN
    OPEN c_emp(10);
    LOOP
    FETCH c_emp INTO v_emp;
    EXIT WHEN c_emp%NOTFOUND
    dbms_output.put_line(v_emp.ename || v_emp.sal);             
    END LOOP;
    END;
```

### 六、异常

#### 1.异常处理语句

 - 语法：
```
    DECLARE
    BEGIN
        PL/SQL代码块；
    EXCEPTION
       WHEN exception1 THEN
            statements1;
       WHEN exception2 THEN
            statements2;
       WHEN exception3 THEN
            statements3;
         [  ......  ]
       WHEN OTHERS THEN
            statementsN;
    END;
```

 - 案例
```
案例：以下代码中，出现了除数不能为零的异常
    BEGIN
    DBMS_OUTPUT.PUT_LINE('出现异常前');
    DBMS_OUTPUT.PUT_LINE(10/0);
    DBMS_OUTPUT.PUT_LINE('出现异常后');
    EXCEPTION
        WHEN ZERO_DIVIDE THEN   
        DBMS_OUTPUT.PUT_LINE('除数不能为零');
    END;
```

#### 2.异常分类

##### （1）系统异常

 - 指Oracle系统为一些经常出现的错误定义好的异常（预定义的异常），如被零除或内存溢出等。系统异常无须声明，当系统预定义异常发生时,Oracle系统会自动触发，只需添加相应的异常处理即可。

 - 案例
```
案例2：在以下代码中，出现找不到数据的异常
    DECLARE
      v_sal emp.sal%TYPE;
    BEGIN
      SELECT sal INTO v_sal FROM emp WHERE  empno =6567;
    EXCEPTION
      WHEN NO_DATA_FOUND THEN   
      DBMS_OUTPUT.PUT_LINE('未找到数据');
    END;
```

##### （2）非系统异常

 - 语法：
```
    exception_name  EXCEPTION;
    PRAGMA EXCEPTION_INIT(exception_name,exception_no);
```
 - 案例
```
案例：删除部门表中的数据，会出现异常
    DECLARE
    e_del EXCEPTION;
    PRAGMA EXCEPTION_INIT(e_del,-02292);
    BEGIN
    DELETE FROM emp;
    EXCEPTION
    WHEN e_del THEN
    dbms_output.put_line('异常。。。。');
    END;
```

##### （3）自定义异常

 - 创建自定义异常需要使用语法：
```
    RAISE_APPLICATION_ERROR(error_number,error_massage);
```

 - 案例
```
任务：如果当前用户不是sys用户，不允许删除dept表中的记录
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
            dbms_output.put_line(sqlcode || ',' || sqlerrm);
      END;
```

### 七、触发器

#### 1.相关定义

 - 	触发器是指被隐含执行的存储过程。在建立了触发器之后，如果发生了相应的DML操作，那么会自动执行触发的相应代码。

 - 触发器主要包括：语句触发器和行触发器两种类型。触发器中包含DML语句触发器 ,DDL语句触发器等。

#### 2.语句触发器

 - 定义：语句触发器是指当执行DML语句时被隐含执行的触发器。如果在表上针对某
 种DML操作建立了语句触发器，那么当执行DML操作时会自动执行触发器的相应代码。

 - 语句触发器针对某一条语句触发一次。

 - 注意:当使用语句触发器时，不能记录列数据的变化。

 - 语法：
```
    CREATE OR REPLACE TRIGGER trigger_name
    timing event1[OR event2 OR event3]
    ON table_name
    PL/SQL block
```
 - 案例
```
案例：往emp 表中插入一条记录，然后触发触发器去打印一句话
    CREATE OR REPLACE TRIGGER trigger_emp
    BEFORE INSERT OR DELETE
    ON emp
    DECLARE
    BEGIN
      dbms_output.put_line('test....');
      END;
```

#### 3. 行触发器

 - 定义：行触发器是指当执行DML操作时，每作用一行会触发一次触发器。

 - 语法：
```
    CREATE [OR REPLACE] TIRGGER trigger_name
    timing event1 [OR event2 OR event3]
    OF fields
    ON table_name
    FOR EACH ROW
    PL/SQL block;
```

 - 引用变量
```
   :old   修饰符引用旧数据
   :new    修饰符引用新数据
```

 - 总结：
```
    :new在BEFORE触发器中赋值，取值；在AFTER触发器中取值。
    :new是新插入的数据，:old是原来的数据
    INSERT只会有:new，代表着要插入的新记录
    DELETE只会有:old，代表着要删除的记录
```

 - 案例
```
    CREATE OR REPLACE TRIGGER trigger_emp
    BEFORE INSERT OR DELETE OR UPDATE
    ON emp
    FOR EACH ROW
    DECLARE
    BEGIN
      :new.ename:='zs';--赋值
      dbms_output.put_line(:new.empno);--取值
      END;
```

#### 4.编译触发器

 - 当修改表结构时，会导致触发器变为无效状态，必须要重新编译触发器。

 - 语法如下：
```
    ALTER TRIGGER trigger_name COMPILE;
```

#### 5.删除触发器

 - 当触发器不再需要时，可以把触发器删除

 - 语法
```
    DROP TRIGGER trigger_name;
```

### 八、自定义函数

#### 1.定义

 - 它也是一种存储在数据库中的命名程序块，也被称为存储函数。

 - 函数一般用于计算和返回一个值，可以将经常需要使用的计算或功能写成一个函数。

 - 函数可以接受零个或多个输入参数，并且函数必须有返回值。

#### 2.函数的创建及使用

 - 创建的语法：
```
    CREATE [OR REPLACE] FUNCTION 函数名（
    	参数1 数据类型[,参数2  数据类型]
    	……[,参数n 数据类型]）
    RETURN 数据类型
    (IS|AS)
    	声明参数;
    BEGIN
    	执行语句段
    RETURN 参数;
    END;
```

 - 案例
```
任务1：创建一个函数，根据输入的员工 id，具有输出某个员工的员工姓名的功能。
    --创建函数
    CREATE FUNCTION  emp_ename_func(fid  emp.empno%TYPE)
    RETURN VARCHAR2
    IS
    v_ename emp.ename%TYPE;
    BEGIN
    SELECT ename  INTO v_name
    FROM emp
    WHERE empno = fid;
    RETURN v_ename;
    END emp_ename_func;
    --1、在PL/SQL块中调用执行：
    DECLARE
    v_id  NUMBER(6) := 7369;
    BEGIN
    dbms_output.put_line(emp_ename_func(v_id));
    END;
    --2、也可以直接使用SELECT 语句调用函数，它类似于一个表达式。
    SELECT emp_ename_func(7369) FROM dual;
    --3、在SQLPLUS工具中调用函数
    SET SERVEROUTPUT ON
    VAR v_name VARCHAR2(15)
    EXEC :v_name:=emp_ename_func(7369)   
    PRINT v_name
    --4、在SQL Developer工具中调用函数
    SET SERVEROUTPUT ON
    BEGIN
    dbms_output.put_line(emp_ename_func(7369));
    END;
```

#### 3.带有输入输出参数的函数创建
```
任务1、创建一个函数带有IN参数的get_sal()函数，该函数可以根据员工姓名获取员工的工资。
    CREATE FUNCTION get_sal(f_name IN emp.ename%TYPE )
    RETURN NUMBER
    IS
    v_sal emp.sal%TYPE;
    BEGIN
      SELECT sal INTO v_sal FROM emp WHERE ename =f_name;
      RETURN v_sal;
    END get_sal;
    --调用函数
    BEGIN
      DBMS_OUTPUT.PUT_LINE(get_sal('SMITH'));
    END;
```

#### 4.函数的删除

 - 语法格式
```
    DROP FUNCTION 函数名;
```

 - 案例
```
任务：删除根据输入员工 id输出某个员工姓名的函数emp_ename_func
    DROP FUNCTION  emp_ename_func;
```

### 九、存储过程

#### 1.定义

 - 存储过程是一种命名的PL/SQL程序块，它既可以没有参数，也可以有若干个输入、输出参数，甚至可以有多个既作输入又作输出的参数

 - 但它没有RETURN返回值,如果需要输出值，可以通过OUT参数。

#### 2.不带参数存储过程的使用

 - 创建格式：
```
    CREATE OR REPLACE  PROCEDURE  过程名 AS
  	声明语句段;
  	BEGIN
  	执行语句段;
  	END;
    调用：
     方法：
    BEGIN
    过程名;
    END;
```

 - 案例
```
案例1：SCOTT用户下创建一存储过程—查询雇员编号为7369的员工的入职时间，
      输出到控制台
    CREATE OR REPLACE PROCEDURE getHiredate_emp_proc
    IS
    v_hiredate emp.hiredate%TYPE;
    BEGIN
      SELECT hiredate INTO v_hiredate FROM emp  WHERE empno=7369;
      DBMS_OUTPUT.PUT_LINE('入职时间是：'||v_hiredate);
    END;
    --调用存储过程
    BEGIN
      getHiredate_emp_proc;
    END;
```

#### 3.带参数的存储过程的使用

##### （1）参数分类：输出参数、输入参数、双向参数

 - IN：输入参数，主程序向过程传递参数值

 - OUT：读出参数，过程像主程序传递参数值

 - IN  OUT：双向参数，过程与主程序双向交流数据

##### （2）创建格式：

 - 语法
```
    CREATE OR REPLACE PROCEDURE  过程名(
       参数1 [IN|OUT|IN OUT] 数据类型
       [,参数2[IN|OUT|IN OUT] 数据类型]
       ...
       [,参数n[IN|OUT|IN OUT]数据类型])
    (IS|AS)
           声明语句段;
    BEGIN
           执行语句段;
    END;
    调用方法：
    BEGIN
    过程名（参数，……）
    END;
```

 - 案例
```
任务1：写一个存储过程，当输入任何一个员工 id 信息，返回这个员工的入职日期
    CREATE OR REPLACE PROCEDURE  mytest2_proc(
    tempdate OUT employees.hire_date%TYPE,
    empno  IN employees.employee_id%TYPE
    )  
     AS
    BEGIN
         SELECT hire_date
         INTO tempdate
         FROM employees
         WHERE employee_id = empno;
    END  mytest2_proc;
    调用：
    DECLARE
        tempdate1  employees.hire_date%TYPE;
        empno  employees.employee_id%TYPE;
    BEGIN
        empno := 101;
        mytest1_proc(tempdate1,empno);
        DBMS_OUTPUT.PUT_LINE(tempdate1);
    END;
```

#### 4.删除存储过程

 - 语法
```
    DROP PROCEDURE 存储过程名称；
```

 - 案例
```
任务：删除存储过程mytest1_proc
    DROP PROCEDURE  mytest1_proc；
```

#### 5.存储函数与存储过程的区别

 - 存储函数可以接受零个或多个输入参数，并且函数必须有返回值。

 - 存储过程既可以没有参数，也可以有若干个输入、输出参数，甚至可以有多个既作输入又作输出的参数，但它可以没有返回值。

 - 但过程和函数都可以通过out指定一个或多个输出参数。我们可以利用out参数，在过程和函数中实现返回多个值。

### 十、程序包

#### 1.创建程序包

##### （1）创建程序包声明

 - 创建程序包声明语法格式如下：
```
    CREATE [OR REPLACE] PACKAGE package_name  [IS|AS]
    package_specification
    END package_name;
```

 - 案例
```
    CREATE OR REPLACE PACKAGE dept_pkg
    IS
        --添加
        FUNCTION add_dept_fun (v_dept IN dept%rowtype)
        RETURN BOOLEAN;
        --修改
        FUNCTION edit_dept_fun(v_dept IN dept%rowtype)
        RETURN BOOLEAN;
        --删除
        procedure del_dept_pro
        (v_deptno dept.deptno%type,v_flag OUT BOOLEAN);
        -- 查询
        PROCEDURE get_deptno_pro
        (v_deptno dept.deptno%type,v_dept OUT dept%rowtype);
        --游标
        PROCEDURE c_dept(v_d ept out dept%rowtype);
    END dept_pkg;
```

##### （2）创建程序包的主体

 - 需要使用CREATE PACKEAGE BODY语句，其语法格式如下：
```
    CREATE [OR REPLACE] PACKAGE BODY package_name
    [IS/AS]
    package_definition
    END package_name;
```

 - 案例
```
    CREATE OR REPLACE PACKAGE body dept_pkg
    IS
       --添加
       FUNCTION add_dept_fun (v_dept IN dept%rowtype)
       RETURN BOOLEAN
       IS
          v_flag BOOLEAN:=FALSE;
       BEGIN
         INSERT INTO dept VALUES(v_dept.deptno,v_dept.dname,v_dept.loc);
         IF SQL%rowcount>0 THEN
           v_flag:=TRUE;
           END IF;
           RETURN v_flag;
         END;  
       --修改
       FUNCTION edit_dept_fun(v_dept IN dept%rowtype)
       RETURN BOOLEAN
      IS
          v_flag BOOLEAN:=FALSE;
      BEGIN
           UPDATE dept SET dname=v_dept.dname,loc=v_dept.loc WHERE deptno=v_dept.deptno;
           IF SQL%rowcount>0 THEN
           v_flag:=TRUE;
           END IF;
           RETURN v_flag;
           END;
           --删除
           procedure del_dept_pro(v_deptno dept.deptno%type,v_flag OUT BOOLEAN)
             IS     
             BEGIN
               DELETE FROM dept WHERE deptno=v_deptno;
               IF SQL%rowcount>0 THEN
                v_flag:=TRUE;
                ELSE
                  v_flag:=FALSE;
                   END IF;
               END;
            --查询
            PROCEDURE get_deptno_pro(v_deptno dept.deptno%type,v_dept OUT dept%rowtype)
              IS
              BEGIN
                SELECT * INTO v_dept FROM dept WHERE deptno=v_deptno;
                END get_deptno_pro;
                --游标
                PROCEDURE c_dept(v_dept out dept%rowtype)
                  IS
                  CURSOR c_dept_all IS SELECT * FROM dept;
                  v_dept_all dept%rowtype;
                  BEGIN
                    OPEN c_dept_all;
                    LOOP
                      FETCH c_dept_all INTO v_dept_all;
                      EXIT WHEN c_dept_all%NOTFOUND;
                      dbms_output.put_line(v_dept_all.dname || ',' || v_dept_all.deptno || ',' || v_dept_all.loc);
                      END LOOP;
                    CLOSE c_dept_all;
                    END;
                    END dept_pkg;
```

#### 2.调用程序包中的函数

 - 程序包内部的存储过程、函数及其他PL/SQL块，可以在包名后添加点（.）来调用。

 - 其语法格式如下：
```
    package_name.[elemente_name]；
```

 - 案例
```
    -调用
    DECLARE
                  v_flag BOOLEAN;
                  v_dept dept%rowtype;
                  --声明变量同时赋值
    BEGIN
      v_dept.deptno:=90;
      v_dept.dname:='aaa';
      v_dept.loc:='添加';
      v_flag:=dept_pkg.add_dept_fun(v_dept);
      IF v_flag THEN
        dbms_output.put_line('添加成功');
        ELSE
          dbms_output.put_line('添加失败');
          END IF;
      END;

     --调用修改
     DECLARE
          v_flag BOOLEAN;
          v_dept dept%rowtype;
     BEGIN
        v_dept.deptno:=90;
        v_dept.dname:='aaa';
        v_dept.loc:='修改';
       v_flag:=dept_pkg.edit_dept_fun(v_dept);
       IF v_flag THEN
         commit;
        dbms_output.put_line('修改成功');
        ELSE
          dbms_output.put_line('修改失败');
          END IF;
       END;

    --调用查询
    DECLARE
       v_dept dept%rowtype;
    BEGIN
      dept_pkg.get_deptno_pro(10,v_dept);
      dbms_output.put_line(v_dept.deptno || ',' || v_dept.dname || ',' || v_dept.loc);
      END;

    --调用删除
    DECLARE
      v_flag BOOLEAN;
    BEGIN
      dept_pkg.del_dept_pro(90,v_flag);
      END;

    --调用游标
    DECLARE
             v_dept_all dept%rowtype;
    BEGIN
          dept_pkg.c_dept(v_dept_all);
      END;
```

#### 3.删除程序包

 - 格式语法：
```
    DROP PACKAGE package_name;
```
 - 案例
```
    DROP PACKAGE demo1_pkg;
```