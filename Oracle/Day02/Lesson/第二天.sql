--建表语句
--CREATE TABLE 表名(字段1 数据类型,字段2 数据类型);
/*任务一:添加专业 special
           专业名称、备注
           specialId,specialName,description*/
CREATE TABLE t_special(
    specailId VARCHAR2(35),
    specialName VARCHAR(20),
    description VARCHAR(100)
);

CREATE TABLE t_student(
       stuNo NUMBER(10),
       stuName VARCHAR2(50),
       sex CHAR(2),
       birthday DATE,
       phone NUMBER(11),
       qq VARCHAR2(12),
       location VARCHAR2(100),
       specialId VARCHAR2(35),
       description VARCHAR(100)
);

CREATE TABLE t_student1(
       sno NUMBER(12) CONSTRAINT sno_pk PRIMARY KEY,
       sname VARCHAR2(20) NOT NULL,
       sex CHAR(2),
       age NUMBER(2),
       phone NUMBER(13) CHECK(LENGTH(phone)>11),
       email VARCHAR2(20) UNIQUE,--唯一约束
       cno VARCHAR2(20)
);

INSERT INTO t_student1(sno,sname) VALUES(1001,'zs');
INSERT INTO t_student1(sno,sname) VALUES(1001,'ls');

SELECT * FROM hr.employees;
GRANT CONNECT,RESOURCE,DBA TO scott;

CREATE TABLE t_class(
    cno VARCHAR2(4) PRIMARY KEY，
    cname  VARCHAR2(15) NOT NULL
);


CREATE TABLE t_student2(
       sno  VARCHAR2(10)  ,
       sname  VARCHAR2(20) NOT NULL,
       sex    VARCHAR2(2),
       telephone  NUMBER(13) CHECK(length(telephone)<=11)    ,
       email   VARCHAR2(20)   ,
       cno   VARCHAR2(20)   ,
       CONSTRAINT pk_stu_sno PRIMARY KEY(sno),
       CONSTRAINT uk_stu_email UNIQUE(email), 
       CONSTRAINT fk_stu_cno FOREIGN KEY（cno）REFERENCES t_class(cno)
);

--添加约束
ALTER TABLE t_student2 ADD CONSTRAINT stu2_sno_pk
PRIMARY KEY(sno);

ALTER TABLE t_student2 MODIFY (sname NULL);
--删除约束 
--查看约束
SELECT * FROM user_constraints;
ALTER TABLE t_student2 DROP CONSTRAINT stu2_sno_pk;

--创建序列
--CREATE SEQUENCE 序列名称
CREATE SEQUENCE stu_seq;

SELECT stu_seq.nextval FROM dual;

INSERT INTO t_student2(sno)
VALUES(stu_seq.nextval);
SELECT * FROM t_student2;
INSERT INTO t_class VALUES(stu_seq.nextval,stu_seq.currval||'班');
SELECT ROWID,t_class.* FROM t_class;

--从1开始生成一个数,步长是2,最大值20,循环生成
CREATE SEQUENCE test_seq
INCREMENT BY 2 
START WITH 1
MINVALUE 1
MAXVALUE 20
CYCLE
NOCACHE

SELECT test_seq.nextval FROM dual;

SELECT 'HELLO WORLD' FROM dual;

SELECT * FROM emp;


SELECT 'HELLO WORLD' FROM emp;

SELECT sysdate from dual;
