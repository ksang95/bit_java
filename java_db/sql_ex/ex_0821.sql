drop table board;
drop table users;

create table USERS(
id varchar2(10) primary key,
password varchar2(20) not null, 
name varchar2(10), 
role varchar2(10) default 'user' check(role in ('user','admin')));

create table BOARD(
seq number(5) primary key, 
title varchar2(50) not null, 
content varchar2(1000), 
regdate date default sysdate, 
cnt number(10) default 0, 
id varchar2(10),
foreign key (id) references USERS on delete set NULL);

--alter table board modify(regdate default sysdate);

insert into USERS values('java','1234','홍길동',default);
insert into USERS values('sql','8888','박길동',default);
insert into USERS values('html','1111','김길동',default);
insert into USERS values('jsp','3535','이길동',default);
insert into USERS values('db','0000','고길동',default);
insert into USERS values('king','9999','왕길동','admin');
commit;

update users set password='5678' where id='db';
commit;

select * from users where id='html' and password='1234';
select * from users where id='html' and password='1111';

drop sequence board_seq; 
create sequence board_seq; 
insert into BOARD(seq,title,content,regdate,id) values(board_seq.nextval,'데이터베이스','글을 쓴다!!!',sysdate,'db');
insert into BOARD(seq,title,content,regdate,id) values(board_seq.nextval,'데이터베이스','글을 쓴다!!!',sysdate,'db');
insert into BOARD(seq,title,content,regdate,id) values(board_seq.nextval,'데이터베이스','글을 쓴다!!!',sysdate,'db');
insert into BOARD(seq,title,content,regdate,id) values(board_seq.nextval,'집에가자','Going Home',sysdate,'html');
insert into BOARD(seq,title,content,regdate,id) values(board_seq.nextval,'집에가자','Going Home',sysdate,'html');
insert into BOARD(seq,title,content,regdate,id) values(board_seq.nextval,'과거에서 옴','안녕','19/02/21','java');
insert into BOARD(seq,title,content,regdate,id) values(board_seq.nextval,'과거에서 옴','안녕','19/03/21','java');
insert into BOARD(seq,title,content,regdate,id) values(board_seq.nextval,'제목','글글글','19/07/07','king');
insert into BOARD(seq,title,content,regdate,id) values(board_seq.nextval,'제목','글글글','19/07/07','king');
insert into BOARD(seq,title,content,regdate,id) values(board_seq.nextval,'제목','글글글','19/07/07','king');
insert into BOARD(seq,title,content,regdate,id) values(board_seq.nextval,'test','어떻게 쳐요?','19/06/10','html');
insert into BOARD(seq,title,content,regdate,id) values(board_seq.nextval,'test','어떻게 쳐요?','19/06/10','html');
insert into BOARD(seq,title,content,regdate,id) values(board_seq.nextval,'test','어떻게 쳐요?','19/06/10','html');
insert into BOARD(seq,title,content,regdate,id) values(board_seq.nextval,'반가워요','댓주세요',sysdate,'jsp');
insert into BOARD(seq,title,content,regdate,id) values(board_seq.nextval,'count1','글 개수 세는 글','19/01/01','db');
insert into BOARD(seq,title,content,regdate,id) values(board_seq.nextval,'COUNT2','글 개수 세는 글','19/02/01','db');
insert into BOARD(seq,title,content,regdate,id) values(board_seq.nextval,'count3','글 개수 세는 글','19/03/01','db');
insert into BOARD(seq,title,content,regdate,id) values(board_seq.nextval,'count4','글 개수 세는 글','19/04/01','db');
insert into BOARD(seq,title,content,regdate,id) values(board_seq.nextval,'Count5','글 개수 세는 글','19/05/01','db');
insert into BOARD(seq,title,content,regdate,id) values(board_seq.nextval,'글 등록 중입니다','ing','19/02/02','king');
commit;

update board set content='안녕 나는 자바야' where id='java' and title='과거에서 옴';

delete from board where id='html';
commit;

select * from users;
select * from board;

select count(*) 전체게시글 from board;
select id,count(*) 게시글 from board group by id order by id;
select u.id,nvl(게시글,0) from (select id,count(*) 게시글 from board group by id) b, users u where b.id(+)=u.id order by u.id;
select to_char(regdate,'MM') 월,count(*) 게시글 from board group by to_char(regdate,'MM') order by to_char(regdate,'MM');

select seq, title, regdate, id from board where upper(id)=upper('jsp');
select seq, title, regdate, id from board where upper(title) like upper('%count%');

commit;
 