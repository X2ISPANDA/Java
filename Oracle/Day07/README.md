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