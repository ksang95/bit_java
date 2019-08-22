######################
view
######################

select ename, sal, d.deptno, dname, loc
from emp e, dept d
where e.deptno=d.deptno;

conn system/1234;
grant dba to SCOTT;
conn SCOTT/TIGER;

create or replace view emp_dept
as select ename, sal, d.deptno, dname, loc
from emp e, dept d
where e.deptno=d.deptno;

drop view emp_dept;

create or replace view emp_dept
as select ename, sal, hiredate, d.deptno, dname, loc
from emp e, dept d
where e.deptno=d.deptno;

select * from emp_dept;
select * from tab;
select user from dual;

## 자기가 속한 부서의 평균 급여보다 많이 받는 사람들의 명단을 view로 만드세요. highsalavg
create or replace view highsalavg
as select ename, sal, deptno
from emp e
where sal>(select avg(sal) from emp where e.deptno=deptno);

select * from highsalavg;
select avg(sal) from emp;
select avg(sal) from emp where deptno=10;

create or replace view vvvv
as
select * from emp outer where sal>(select (avg)sal from emp where deptno=outer.deptno);

#############################################
sequence
#############################################

delete from dept2;
select * from dept2;
select * from emp2;

create sequence deptno_seq;
insert into dept2 (deptno, dname, loc) values (deptno_seq.nextval,'인사부','비트');
select deptno_seq.currval from dual;
drop sequence deptno_seq;

create sequence deptno_seq start with 10 increment by 10;
insert into dept2 (deptno, dname, loc) values (deptno_seq.nextval,'인사부','비트');

delete from dept2;


insert into dept2 (deptno, dname, loc) values ((select nvl(MAX(deptno),0)+10 from dept2),'인사부','비트');



###########################################
index
###########################################


select * from emp;

set autotrace on;

select * from emp where empno=7698; //index 기반
select * from emp where ename='FORD'; //full scan

create index emp_ename_idx on emp(ename);
drop index emp_ename_idx;

set autotrace off;


select index_name, table_name from user_indexes;