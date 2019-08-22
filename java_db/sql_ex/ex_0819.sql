--1

select e.employee_id 사번, e.first_name 이름, department_name 부서명, m.first_name 매니저이름
from employees e, employees m, departments d
where e.manager_id=m.employee_id and e.department_id=d.department_id;

--2

select e.last_name, e.salary
from employees e, employees m
where e.manager_id=m.employee_id and e.salary>m.salary;

--3

select first_name, last_name, salary
from employees e, jobs j
where e.job_id=j.job_id and j.job_title='Sales Representative' and salary between 9000 and 10000;


where lower(j.job_title) = lower('Sales Representative');

--4

select e.employee_id, e.last_name, e.hire_date
from employees e, employees m
where e.manager_id=m.employee_id and e.hire_date<m.hire_date;

--5

select distinct job_title, department_name
from jobs j, employees e, departments d
where j.job_id=e.job_id and e.department_id=d.department_id
order by job_title;

--6

select to_char(hire_date,'MM') 월, count(*) 입사자수
from employees
group by to_char(hire_date,'MM')
order by to_char(hire_date,'MM');

--7

select e.first_name 직원, e.hire_date 입사일, m.employee_id 관리자사번, m.first_name 관리자
from employees e left outer join employees m
on e.manager_id=m.employee_id
where to_char(e.hire_date,'YY')='08';

--8

select first_name, salary, department_name 
from employees e join departments d
on e.department_id=d.department_id
where d.department_name='Sales';

--9

select employee_id, first_name, last_name, nvl(department_name,'<NOT ASSIGNED') department_name
from employees e join departments d
on e.department_id=d.department_id
where to_char(hire_date,'YYYY')='2004';

--10

select e.first_name, e.hire_date, m.employee_id, m.first_name as first_name_1
from employees e left outer join employees m
on e.manager_id=m.employee_id
where to_char(e.hire_date,'YYYY')='2003';