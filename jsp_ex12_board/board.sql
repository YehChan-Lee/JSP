create table board(
num number(10) primary key,
author varchar2(100) not null,
email varchar2(200),
title varchar2(500) not null,
content varchar2(4000),
passwd varchar2(12),
writeday date,
readcnt number(10),
rep_root number(10),
rep_step number(10),
rep_indent number(10)
);

create sequence seq_board start with 1 increment by 1;

insert into board values(seq_board.nextval,'test','test@test.com','testTitle','testcontent','12345',sysdate,0,0,0,0);

select * from board;