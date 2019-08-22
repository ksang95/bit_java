select * from EMP;

select
from
where
order by

select ename,sal from emp; 
select ename,sal from emp order by deptno;
select ename,sal,deptno from emp order by deptno;

select ename,dname
from emp,dept
where emp.deptno=dept.deptno;

select ename,dname,emp.deptno
from emp,dept
where emp.deptno=dept.deptno;

select ename,dname,d.deptno as 부서번호, dname,loc
from emp e,dept d
where e.deptno=d.deptno;

select *
from emp e,dept d
where e.deptno=d.deptno and sal>2500;

#################################
ANCI join 표준   ,=>join where=>on
#################################

select ename,dname,d.deptno, dname,loc
from emp e,dept d
where e.deptno=d.deptno;


select ename,dname,d.deptno, dname,loc
from emp e join dept d
on e.deptno=d.deptno;



select ename,dname,d.deptno, dname,loc
from emp e inner join dept d
on e.deptno=d.deptno
where sal>2500;


##########################################
outer join
##########################################

select ename, sal, dname, loc, e.deptno
from emp e, dept d
where e.deptno(+)=d.deptno;

select ename, sal, dname, loc, e.deptno
from emp e right outer join dept d
on e.deptno=d.deptno;

select ename, sal, dname, loc, e.deptno
from emp e left outer join dept d
on e.deptno=d.deptno;

####################################
non-equi join
####################################
select * from salgrade;

select ename, sal, grade
from emp e, salgrade s
where sal between losal and hisal;


select ename, sal, grade
from emp e join salgrade s
on sal between losal and hisal;

####################################
세 개의 테이블 join
####################################

select ename, sal, dname, loc, grade
from emp e, dept d, salgrade s
where e.deptno=d.deptno and sal between losal and hisal
order by d.deptno;

select ename, sal, dname, loc, grade
from emp e, dept d, salgrade s
where e.deptno=d.deptno and sal between losal and hisal and e.deptno=20
order by d.deptno;

select ename, sal, dname, loc, grade
from emp e join dept d on e.deptno=d.deptno 
join salgrade s on sal between losal and hisal
order by d.deptno;

select ename, sal, dname, loc, grade
from emp e join dept d on e.deptno=d.deptno 
join salgrade s on sal between losal and hisal
where d.deptno=10
order by d.deptno;

####################################
self join
####################################

select a.empno, a.ename, a.mgr, b.empno, b.ename as 상사
from emp a, emp b
where a.mgr=b.empno(+);

select a.empno, a.ename, a.mgr, b.empno, b.ename as 상사
from emp a inner join emp b
on a.mgr=b.empno;

select a.empno, a.ename as 사원, b.ename as 상사
from emp a left outer join emp b
on a.mgr=b.empno;

select a.empno, a.ename as 사원, nvl(b.ename,'<CEO>') as 상사
from emp a left outer join emp b
on a.mgr=b.empno;


##상사보다 급여가 많은 사원 목록

select e.ename 사원, e.sal 사원급여, m.ename 상사, m.sal 상사급여
from emp e, emp m
where e.mgr=m.empno(+) and e.sal>m.sal;

select e.ename 사원, e.sal 사원급여, d.dname, loc, m.ename 상사, m.sal 상사급여
from emp e join emp m
on e.mgr=m.empno
join dept d
on e.deptno=d.deptno
where e.sal>m.sal;


#####################################
집계함수
#####################################

select ename, round(sal) from emp;
select avg(sal) from emp;
select round(avg(sal)) 평균급여 from emp;

select count(empno),count(comm),count(*),count(mgr),round(avg(sal)) 평균급여  from emp;


select count(distinct job) from emp;

select sum(sal), count(*), round(avg(sal)), sum(sal)/count(*) from emp;

select round(avg(sal)) 평균급여 from emp;
select round(avg(sal)) 평균급여 from emp where deptno=10;
select round(avg(sal)) 평균급여 from emp where deptno=20;
select round(avg(sal)) 평균급여 from emp where deptno=30;
select round(avg(sal)) 평균급여 from emp where deptno=40;

select * from emp order by deptno;
select deptno, round(avg(sal)) 평균급여 from emp group by deptno order by deptno;

--haaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaah


## 부서 이름 별 평균 급여 구하기
select emp.deptno, dname, round(avg(sal)) 평균급여
from emp, dept
where emp.deptno=dept.deptno
group by dname, emp.deptno
order by emp.deptno;

select max(sal), min(sal), count(*), avg(sal) from emp;

select deptno, max(sal), min(sal), count(*), avg(sal) from emp group by deptno;

select emp.deptno, dname, round(avg(sal)) 평균급여
from emp join dept
on emp.deptno=dept.deptno
group by dname, emp.deptno
order by 1;

## 부서별 평균 급여가 2000 이상인 리스트
select emp.deptno, dname, round(avg(sal)) 평균급여
from emp join dept
on emp.deptno=dept.deptno
group by dname, emp.deptno
having avg(sal)>=2000
order by 1;

select
from
where
group by
having
order by

select emp.deptno, dname, round(avg(sal)) 평균급여
from emp join dept
on emp.deptno=dept.deptno
where sal>1000
group by dname, emp.deptno
having avg(sal)>=2000
order by 1;

## FORD 보다 급여를 많이 받는 사원 리스트
select sal from emp where ename='FORD';
select * from emp where sal>3000;
select * from emp where sal>(select sal from emp where ename='FORD');

## 평균 급여보다 적게 받는 사원 목록
select * from emp where sal<(select avg(sal) from emp);

select * from emp where sal=(select min(sal) from emp);

## 각각의 부서에서 급여가 가장 작은 사원 리스트
select deptno,ename,sal from emp where (deptno,sal) IN (select deptno,min(sal) from emp group by deptno);

## 각각의 부서에서 급여가 가장 많은 사원 리스트
select deptno,ename,sal from emp where (deptno,sal) IN (select deptno,max(sal) from emp group by deptno);

##################################################################
상관관계 서브쿼리 : outer 쿼리의 컬럼 중 하나가 inner 쿼리문에서 사용되는 쿼리문
##################################################################

## 자신이 속한 부서의 평균 급여보다 적은 사원 리스트
select deptno,ename,sal from emp outer
where sal < (select avg(sal) from emp where deptno=outer.deptno);

####################
rownum
####################

select rownum,ename,sal,hiredate
from emp;

select rownum,ename,sal,hiredate
from emp
order by sal desc;

select rownum,ename,sal,hiredate
from (select * from emp order by sal desc);

select rownum,ename,sal,hiredate
from (select * from emp order by sal desc)
where rownum<4;

select rownum,ename,sal,hiredate
from (select * from emp order by sal desc)
where rownum>4; --x

select rownum,ename,sal,hiredate
from (select * from emp order by sal desc)
where rownum between 1 and 4;

select rownum,ename,sal,hiredate
from (select * from emp order by sal desc)
where rownum between 4 and 7; --x


########################################
page 처리
########################################

select * from (
select rownum row#,ename,sal,hiredate
from (select * from emp order by sal desc))
where row# between 5 and 9;


                  start        end
1page 1~5         5*0+1        +4
2page 6~10        5*1+1        +4
3page 11~15       5*2+1        +4

