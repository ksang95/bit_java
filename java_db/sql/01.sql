

alter user hr identified by hr account unlock;
sqlplus hr/hr
select * from tab;

conn system/1234
-- tablespace 생성
create tablespace bit
datafile 'c:\lib\bit.dbf'
size 30M
autoextend on next 2M maxsize UNLIMITED;

-- 계정 생성
create user test01 identified by 1234
default tablespace bit;

grant connect to test01;
select * from tab;
revoke connect from test01;

grant connect,resource to test01;

-- 계정 삭제
drop user test01 cascade;


create user SCOTT identified by TIGER
default tablespace bit;

@c:\lib\scott.sql

show linesize;
set linesize 300;

show pagesize;
set pagesize 20;

purge recyclebin;

select tablespace_name from dba_tablespaces;

