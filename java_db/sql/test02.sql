select ename from emp where mgr is null;

select ename, dname from emp join dept on emp.deptno=dept.deptno;

select d.deptno, dname, round(avg(sal),1)||'원' 평균 from emp e,dept d where e.deptno=d.deptno group by d.deptno, dname having avg(sal)>=2000 order by avg(sal);