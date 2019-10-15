### 一、游标

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

### 二、异常

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

### 三、触发器

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

### 四、自定义函数

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

### 五、存储过程

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
