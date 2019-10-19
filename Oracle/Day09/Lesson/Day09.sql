--例如：定义一个名称为dept_pkg的包，
--两个函数（对dept部门表的添加和修改）和两个过程（对dept表的删除和查询）
-- 程序包里面再加一个存储过程返回的是所有部门的信息（游标），然后测试plsql代码块里遍历输出
--包的声明
CREATE OR REPLACE PACKAGE dept_pkg
IS
      --添加
       FUNCTION add_dept_fun (v_dept IN dept%rowtype)
         RETURN BOOLEAN;
        --修改
       FUNCTION edit_dept_fun(v_dept IN dept%rowtype)
         RETURN BOOLEAN;
        --删除
        procedure del_dept_pro(v_deptno dept.deptno%type,v_flag OUT BOOLEAN);
        -- 查询
        PROCEDURE get_deptno_pro(v_deptno dept.deptno%type,v_dept OUT dept%rowtype);
        --游标
        PROCEDURE c_dept(v_d ept out dept%rowtype);
END dept_pkg;
-- 程序包体的实现
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

--调用
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
