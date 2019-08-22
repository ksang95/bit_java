create tablespace java_test
datafile 'c:\temp\oradata\java_test.dbf'
size 10M;

create user java01 identified by 1234
default tablespace java_test;

grant connect,resource to java01;

conn java01/1234;

create table Customer(
custid number primary key,
name varchar2(40),
address varchar2(40),
phone varchar2(30));

create table Orders(
orderid number primary key,
custid number not null references customer on delete cascade,
bookid number not null,
saleprice number,
orderdate date
);

drop table Orders;
drop table Customer;

