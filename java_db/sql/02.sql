select * from employees;

select * from emp;
select * from dept;
select ename,hiredate from emp; 
select ENAME,HIREDATE from EMP;
SELECT ENAME,HIREDATE FROM EMP;

desc dept;
select ename,sal,comm from emp; 
select ename,sal,sal*12,comm from emp; 
select ename,sal,sal*12 as 년봉,comm from emp; 

select ename,sal,sal*12 as "년  봉",comm from emp; 
select ename,sal,sal*12 "년  봉",comm from emp; 

select dname,loc from dept;


conn hr/hr
select * from employees;
select first_name,job_id,department_id from employees;


conn SCOTT/TIGER

### null을 포함한 산술식은 null
select empno, ename,sal,comm from emp; 
select empno, ename,sal,comm ,sal+comm  from emp; 
select empno, ename,sal,comm ,sal+comm 월급여 from emp; 

select empno, ename,sal,comm ,nvl(comm,0) ,sal+nvl(comm,0) 월급여 from emp; 
select empno, ename,sal,comm ,(sal+nvl(comm,0))*12 년봉  from emp; 

select empno, ename,mgr,deptno from emp; 
select empno, ename,nvl(mgr,'CEO'),deptno from emp;  X
select empno, ename,nvl(to_char(mgr),'CEO') as mgr,deptno from emp; 

### 문자열 연결 연산자  ||

select empno, ename,deptno from emp; 
select empno||'  '||ename||'  '||deptno from emp; 

select empno, ename,sal||'원' from emp; 

## dual 가상의 테이블
select 10*24*24 from dept; 
select 10*24*24 from dual; 

select sysdate from dual;

## 중복제거 (distinct)

select job from emp;
select distinct job from emp;

select deptno from emp;
select distinct deptno from emp;

select * from emp;

## row 제한  where 절 사용 , 별칭 사용 안됨

select
from
where

select *
from emp
where deptno=10;

select *
from emp
where job='manager';


## 대소문자 구분하지 않고 검색 가능 하도록 합니다.
select *
from emp
where upper(job)=upper('Manager');

select sysdate from dual;

select *
from emp
where hiredate = '81/09/28';  

select *
from emp
where hiredate <> '81/09/28';

select *
from emp
where hiredate != '81/09/28';


## between and  하한값 먼저 지정한다.
select *
from emp
where sal >= 3000 and sal <= 5000;

select *
from emp
where sal  between 3000 and  5000;

select *
from emp
where sal  not between 3000 and  5000;

select *
from emp
where deptno=10 or deptno=20;

## 집합연산자 IN

select *
from emp
where deptno IN(10,20);

select *
from emp
where deptno not IN(10,20);

select *
from dept
where (deptno,loc ) IN((10,'DALLAS'),(30,'CHICAGO'));

## like 연산자
select *
from emp
where ename = 'ALLEN';

select *
from emp
where ename like '%S%';

select *
from emp
where ename like '%M_T%';

## 81년도에 입사한 사원 목록 추출
select *
from emp
where hiredate like '82%';

## 이름이 A B C d 로 시작하는 사원의 목록
select *
from emp
where ename like 'A%' or ename like 'B%' or ename like 'C%' or ename like 'D%';


##정규식 사용
select *
from emp
where regexp_like(ename,'A|B|C|D');

select *
from emp
where regexp_like(ename,'[A-D]');

select *
from emp
where regexp_like(ename,'^[A-D]');

select *
from emp
where regexp_like(ename,'[A-D]$');

## is null
select *
from emp
where comm is null;

select *
from emp
where comm is not null;

## row 제한  where 절 사용 , 별칭 사용 안됨

select ename , sal,comm,sal+nvl(comm,0) total
from emp
where sal+nvl(comm,0) >3000;

select ename , sal,comm,sal+nvl(comm,0) total
from emp
where deptno=20;

## 정렬   order by   기본 오름차순 , 

select ename , sal,comm,sal+nvl(comm,0) total,deptno
from emp
order by deptno;

select ename , sal,comm,sal+nvl(comm,0) total,deptno
from emp
order by deptno desc;

select ename , sal,comm,sal+nvl(comm,0) total,deptno
from emp
order by total;

select ename , sal,comm,sal+nvl(comm,0) total,deptno
from emp
order by 2;

select ename , sal,comm,sal+nvl(comm,0) total,deptno
from emp
order by deptno desc,total;


select *
from emp
where deptno = 30
order by sal;

select *
from emp
where deptno in (20,30)
order by sal;

select *
from emp
where deptno = any(20,30)
order by sal;

select *
from emp
where deptno != all(20,30)
order by sal;

select *
from emp
where dep
tno <> all(20,30)
order by sal;

## 내장함수 p204   single row function

select * from dept;
select dname,loc from dept;
select dname,lower(dname),loc,lower(loc) from dept;

select round(45.5678) ,trunc(45.5678) from dual;
select round(45.5678,2) ,trunc(45.5678,2) from dual;

select sysdate , sysdate+30 from dual;

select ename , hiredate from emp;
select ename , hiredate ,substr(hiredate,1,2) 입사연도 from emp;

select sysdate ,to_char(sysdate,'YYYY') from dual;
select sysdate ,to_char(sysdate,'YY') from dual;
select sysdate ,to_char(sysdate,'day') from dual;

## emp 테이블에서 사원들의 입사월을 출력해보세요.
select ename , hiredate ,to_char(hiredate,'mm') from emp;

select sysdate,to_date('2019/08/14') from dual;

select sysdate,to_date('08/04/19') from dual;
select sysdate,to_date('08/04/19','mm/dd/yy') from dual;

## nvl(a,b) 함수 
select ename , mgr ,nvl(to_char(comm),'_') from emp;
select ename , mgr ,nvl(comm,0) from emp;

##nvl2(a,b,c);
select ename , nvl2(mgr,'O','X') ,nvl(comm,0) from emp;


## decode 함수

select ename ,sal ,deptno,decode(deptno, 10 , sal*1,
                                         20 , sal*2,
                                         30 , sal*3,
                                         sal) 계산 from emp;


