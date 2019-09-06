--查询表空间通过数据字典
SELECT * FROM DBA_TABLESPACES;
--查询所有用户通过数据字典
SELECT * FROM dba_users WHERE USERNAME='SCOTT';
SELECT * FROM dba_tables WHERE OWNER='SCOTT';
--查询数据库信息
SELECT * FROM v$database;
SELECT * FROM v$datafile;
--USER_开头表示当前用户下的信息
SELECT * FROM USER_TABLESPACES;
--表示当前所登录的用户
SELECT * FROM USER_USERS;
--表示当前登陆的用户所包含的表
SELECT * FROM USER_TABLES;
--创建表空间(SYS)
CREATE TABLESPACE myspace DATAFILE 'D:\app\XMY\oradata\orcl\myspace.dbf'
SIZE 20M AUTOEXTEND ON NEXT 5M MAXSIZE 100M;
--创建用户
CREATE USER myuser IDENTIFIED BY myuser DEFAULT TABLESPACE users;
--授权
GRANT CREATE SESSION TO myuser;
SELECT * FROM dba_role_privs;
GRANT CREATE TABLE TO myuser;
GRANT UNLIMITED TABLESPACE TO myuser;
GRANT connect,resource,dba TO myuser;
--收回权限
REVOKE connect,resource,dba FROM myuser;
REVOKE CREATE TABLE FROM myuser;
REVOKE CREATE SESSION FROM myuser;
--删除用户
DROP USER myuser CASCADE;
SELECT * FROM DBA_USERS;
--为某一用户解锁
ALTER USER hr ACCOUNT LOCK;
ALTER USER hr ACCOUNT UNLOCK;
--修改Hr账户的密码
ALTER USER hr IDENTIFIED BY hr;
