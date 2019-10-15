### 一、程序包

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

### 二、数据库中的基本概念

#### 1.实体相关概念

##### （1）实体定义

 - 数据库实体就是数据库管理系统中的不同管理对象。

 - 实体是一个带有描述特性的可以辨别的对象。

 - 实体在数据库里面就是数据表。

#### （2）实体属性

 - 实体属性是指实体的特征，所包含的信息，是附加到实体上的数据项。

 - 例如： 学生的学号和姓名就是学生实体的属性。

#### 2.实体关系

##### （1）一对一关系

 - 一个实体对应一个实体。

 - 举例：一个学生只有一个学号

##### （2）一对多的关系：

 - 一个实体对应多个实体，也就是一个实体与多个实体有联系。

 - 举例：班级与学生之间的联系:一个班级中有若干名学生，每个学生只在一个班级中学习 。

##### （3）多对多的关系：

 - 一个实体对应多个实体，而它所对应的实体也与多个实体有联系。

 - 举例：课程与学生之间的联系:一门课程同时有若干个学生选修，一个学生可以同时选修多门课程。

### 三、设计原则

#### 1.三范式

##### （1）第一范式：1NF

 - 基础范式，原则：原子列，一个列不能再被拆分，一个列中不能有多个信息。

 - 数据中的某个字段不能有多个值（不能被拆分）或者不能有重复的字段出现。

##### （2）第二范式：2NF

 - 每个实体可以唯一的被区分（每一条记录可以唯一的被区分），当且仅当实体E满足第一范式，且每一个非主键属性完全依赖主键时，满足第二范式。

 - 每条数据都必须有唯一确定自身的标识——id“主键”PRIMARY KEY。

##### （3）3NF

 - 表中不包含已在其他表中的非主键列，当且仅当实体E是第二范式（2NF），且E中没有非主键属性传递依赖时，满足第三范式。

 - 表中不能包含其他非主键列， 任何字段也不能由其他字段派生出来，它要求字段没有冗余。——fk“外键”FOREIGN KEY。

#### 2.使用Power Designer工具

 - PowerDesigner是Sybase公司的CASE工具集，使用它可以方便地对管理信息系统进行分析设计，它几乎包括了数据库模型设计的全过程。

 - 利用PowerDesigner可以制作数据流程图、概念数据模型、逻辑数据模型（CDM），物理数据模型（PDM），可以生成多种客户端开发工具的应用程序，还可为数据仓库制作结构模型，也能对团队设备模型进行控制。
