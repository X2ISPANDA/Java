--��ѯ��ռ�ͨ�������ֵ�
SELECT * FROM DBA_TABLESPACES;
--��ѯ�����û�ͨ�������ֵ�
SELECT * FROM dba_users WHERE USERNAME='SCOTT';
SELECT * FROM dba_tables WHERE OWNER='SCOTT';
--��ѯ���ݿ���Ϣ
SELECT * FROM v$database;
SELECT * FROM v$datafile;
--USER_��ͷ��ʾ��ǰ�û��µ���Ϣ
SELECT * FROM USER_TABLESPACES;
--��ʾ��ǰ����¼���û�
SELECT * FROM USER_USERS;
--��ʾ��ǰ��½���û��������ı�
SELECT * FROM USER_TABLES;
--������ռ�(SYS)
CREATE TABLESPACE myspace DATAFILE 'D:\app\XMY\oradata\orcl\myspace.dbf'
SIZE 20M AUTOEXTEND ON NEXT 5M MAXSIZE 100M;
--�����û�
CREATE USER myuser IDENTIFIED BY myuser DEFAULT TABLESPACE users;
--��Ȩ
GRANT CREATE SESSION TO myuser;
SELECT * FROM dba_role_privs;
GRANT CREATE TABLE TO myuser;
GRANT UNLIMITED TABLESPACE TO myuser;
GRANT connect,resource,dba TO myuser;
--�ջ�Ȩ��
REVOKE connect,resource,dba FROM myuser;
REVOKE CREATE TABLE FROM myuser;
REVOKE CREATE SESSION FROM myuser;
--ɾ���û�
DROP USER myuser CASCADE;
SELECT * FROM DBA_USERS;
--Ϊĳһ�û�����
ALTER USER hr ACCOUNT LOCK;
ALTER USER hr ACCOUNT UNLOCK;
--�޸�Hr�˻�������
ALTER USER hr IDENTIFIED BY hr;
