#################################
table 생성   ddl (auto commit)
#################################

drop table book;
create table book(
	bookno number(5),
	title varchar2(30),
	author varchar2(30),
	pubdate date
);

select * from book;

insert into book values (1,'java','kim',sysdate);
insert into book values (2,'jsp','홍',sysdate);
insert into book values (2,'jsp','홍',sysdate);
insert into book values (2,'jsp','홍','19/02/02');
commit;
rollback;

insert into book(bookno,title) values(3,'db');
insert into book(bookno,title,author,pubdate) values(4,'db',null,null);

delete from book where title='db';
delete from book where author is null;
delete from book where author='홍';

desc book;

alter table book add (price number(7));
insert into book(bookno,title,author,pubdate,price) values(4,'db',null,null,900);

update book set price=1000.99

update book set price=900 where title='db';
update book set author='~~~~', price=900, pubdate=sysdate where bookno=3;

update book set price=null;
alter table book modify (price number(7,2));
update book set price=1000.99;
alter table book drop column price;

####################################################################################
drop table book;
create table book(
	bookno number(5),
	title varchar2(30),
	author varchar2(30),
	pubdate date
);
alter table book add (price number(7));
alter table book modify (price number(7,2));
alter table book drop column price;
rename book to book2;
rename book2 to book;

insert into book(bookno,title,author,pubdate) values(4,'db',null,null);
delete from book where author='홍';
update book set author='~~~~', price=900, pubdate=sysdate where bookno=3;

delete from book; rollback;
truncate table book;
###################################################################################

select * from emp;
select * from dept;
create table emp2 as select * from emp;
create table dept2 as select * from dept;

insert into dept values(50,'EDU','SEOUL');
insert into dept2 values(50,'EDU','SEOUL');
commit;

insert into dept values(10,'EDU','SEOUL');
insert into dept2 values(10,'EDU','SEOUL');

insert into emp (empno, ename,hiredate,sal,deptno) values(9999,'홍길동',sysdate,0,40);


drop table book;
create table book(
	bookno number(5) constraint scott_book_pk primary key,
	title varchar2(30) constraint scott_book_title_unique unique,
	author varchar2(30),
	price number(7,2) constraint book_price_check check(price>0),
	pubdate date default sysdate
);

insert into book(bookno,title,author,price,pubdate) values(1,'db','홍길동',900,sysdate);
insert into book(bookno,title,author,price,pubdate) values(2,'jsp','홍길동',22000,sysdate);
insert into book(bookno,title,author,price,pubdate) values(3,'java','김길동',32000,default);


select CONSTRAINT_name
from user_cons_columns
where table_name='BOOK';

drop table book;
create table book(
	bookno number(5),
	title varchar2(30) unique,
	author varchar2(30),
	price number(7,2) check(price>0),
	pubdate date default sysdate
);

alter table book add constraint book_bookno_pk primary key(bookno);
alter table book drop constraint book_bookno_pk;


insert into book(bookno,title,author,price) values(5,null,'최길동',32000);


##############################################
emp dept
##############################################

drop table dept2;
create table dept2 as select * from dept;
alter table dept2 add constraint dept2_pk primary key(deptno);

drop table emp2;
create table emp2 as select * from emp;
alter table emp2 add constraint emp2_pk primary key(empno);

alter table emp2 add constraint emp2_fk_mgr foreign key(mgr) references emp2;

alter table emp2 add constraint emp2_fk1 foreign key(deptno) references dept2;


alter table emp2 drop constraint emp2_fk1;

alter table emp2
add constraint emp2_fk1
foreign key(deptno) references dept2 on delete set null;
delete from dept2 where deptno=20;

alter table emp2
add constraint emp2_fk1
foreign key(deptno) references dept2 on delete cascade;
delete from dept2 where deptno=20;

select * from dept2;
insert into dept2 values(50,'EDU','SEOUL');

select * from emp2;
insert into emp2 (empno, ename,hiredate,sal,deptno) values(9999,'홍길동',sysdate,0,50);
insert into emp2 (empno, ename,hiredate,sal,deptno) values(7777,'고길동',sysdate,0,null);
insert into emp2 (empno, ename,hiredate,sal,deptno,mgr) values(8888,'이길동',sysdate,0,null,10);


drop table emp2 cascade CONSTRAINT;
drop table dept2 cascade CONSTRAINT;

##############################################
트랜잭션
##############################################

create table emp2 as select * from emp;
select * from emp2;

창1
delete from emp2 where deptno=10;

창2
update emp2 set comm=0 where deptno=10;

block->commit/rollback 명령 수행하면 lock 풀림

