--허용순-----------------------------------------------------------------

-- 메일번호 시퀀스
drop SEQUENCE mailno_seq;

CREATE SEQUENCE mailno_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
NOCYCLE
NOCACHE;

--메일코드 시퀀스
drop SEQUENCE mailcode_seq;

CREATE SEQUENCE mailcode_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
NOCYCLE
NOCACHE;


--주소록코드 시퀀스
drop SEQUENCE addressbook_code_seq;

CREATE SEQUENCE addressbook_code_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
NOCYCLE
NOCACHE;

--주소록번호 시퀀스
drop SEQUENCE addressbook_no_seq;

CREATE SEQUENCE addressbook_no_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
NOCYCLE
NOCACHE;

-- 메일함
drop table mailboxtype cascade CONSTRAINTS;
drop table mail cascade CONSTRAINTS;
drop table mailfilebox cascade CONSTRAINTS;
drop view mailm;
create table mailboxtype(
    mailcode number unique,
    mailboxname varchar2(50), 
    empemail varchar2(50) references employee (empemail),
    constraint a primary key (mailcode, mailboxname)
);

insert into mailboxtype values(mailcode_seq.nextval, '임시편지함', 'abc@naver.com');
insert into mailboxtype values(mailcode_seq.nextval, '내게 쓴 편지함', 'abc@naver.com');
insert into mailboxtype values(mailcode_seq.nextval, '휴지통', 'abc@naver.com');
insert into mailboxtype values(mailcode_seq.nextval, '가족', 'abc@naver.com');
insert into mailboxtype values(mailcode_seq.nextval, '회사', 'abc@naver.com');
insert into mailboxtype values(mailcode_seq.nextval, '거래처', 'abc@naver.com');

--select * from mailboxtype;

-- 메일

create table mail(
  mailno number primary key,
  mailcode number references mailboxtype (mailcode),
  empemail varchar2(50) references employee (empemail),
  mailtitle varchar2(50),
  mailtime date default sysdate,
  mailcontents varchar2(600),
  recipient varchar2(50) references employee (empemail),
  separator varchar2(50) references employee (empemail)
);

insert into mail values(mailno_seq.nextval, null, 'abc@naver.com', '너에게로 가는 길', '19/01/01',
'너에게로 가는 길엔 자작나무 숲이 있고', 'qwrds@daum.net', 'abc@naver.com');
insert into mail values(mailno_seq.nextval, null, 'abc@naver.com', '어머니', '19/01/02',
'들로 가신 엄마 생각', 'rudfl@daum.net', 'abc@naver.com');
insert into mail values(mailno_seq.nextval, null, 'abc@naver.com', '운문사 비밀의 숲', '19/01/03',
'나, 다시 태어난다면', 'tjfql@gmail.com', 'abc@naver.com');
insert into mail values(mailno_seq.nextval, null, 'abc@naver.com', '성불사의 밤', '19/01/04',
'성불사 깊은 밤에 그윽한 풍경소리', 'rjacla@gmail.com', 'abc@naver.com');
insert into mail values(mailno_seq.nextval, null, 'abc@naver.com', '사월의 노래', '19/01/05', '사월이 오면 사월이 오며는', NULL, 'abc@naver.com');
insert into mail values(mailno_seq.nextval, 1, 'abc@naver.com', '임시 편지함', '19/01/06', '임시편지함 확인용입니다.', 'qwrds@daum.net', 'abc@naver.com');
insert into mail values(mailno_seq.nextval, null, 'qwrds@daum.net', '녹슨 경의선', '19/01/07',
'서울, 부산 신의주까지', 'abc@naver.com', 'abc@naver.com');
insert into mail values(mailno_seq.nextval, null, 'rudfl@daum.net', '다시 만날까봐', '19/01/08',
'인스타로 몰래 보는 너의 하루들', 'abc@naver.com', 'abc@naver.com');
insert into mail values(mailno_seq.nextval, 2, 'abc@naver.com', '내게 쓴편지함', '19/01/09', '내게 쓴 편지함 확인용입니다.', 'abc@naver.com', 'abc@naver.com');
insert into mail values(mailno_seq.nextval, null, 'qwrds@daum.net', '조금 취했어', '19/01/11',
'내가 망가지면 니가 나를 볼까 봐','abc@naver.com', 'abc@naver.com');
insert into mail values(mailno_seq.nextval, null, 'rudfl@daum.net', '시든 꽃에 물을 주듯', '19/01/21',
'아무말도 아무것도 여전히 넌 여기 없고', 'abc@naver.com', 'abc@naver.com');
insert into mail values(mailno_seq.nextval, 3, 'abc@naver.com', '휴지통', '19/02/01', '휴지통 확인용 입니다.', null, 'abc@naver.com');
insert into mail values(mailno_seq.nextval, 4, 'abc@naver.com', '가족', '19/03/01', '메일 그룹 확인용 입니다.', null, 'abc@naver.com');
insert into mail values(mailno_seq.nextval, 5, 'abc@naver.com', '회사', '19/04/01', '메일 그룹 확인용 입니다.', null, 'abc@naver.com');
insert into mail values(mailno_seq.nextval, 6, 'abc@naver.com', '거래처', '19/05/01', '메일 그룹 확인용 입니다.', null, 'abc@naver.com');

-- 메일 파일함

create table mailfilebox(
  mailno number references mail (mailno),
  originalfile varchar2(50),
  renamefile varchar2(50),
  filesize number,
  downloadterm date  
);

insert into mailfilebox values(1, 'a.txt', '201910031000.txt', 100, null);
insert into mailfilebox values(1, 'b.txt', '201910031100.txt', 100, null);
insert into mailfilebox values(2, 'c.txt', '201910031200.txt', 200, null);
insert into mailfilebox values(3, 'd.txt', '201910031300.txt', 300, null);
insert into mailfilebox values(4, 'e.txt', '201910031400.txt', 1024 * 10, sysdate + 30);



create view mailm 
as select mail.mailno, mail.mailcode, mail.empemail, mail.mailtitle, mail.mailtime, mail.mailcontents, mail.recipient, mail.separator, mailboxtype.mailboxname
from mail left join mailboxtype
on mail.mailcode = mailboxtype.mailcode and mail.empemail = mailboxtype.empemail;

select * from mailm order by mailno;
select * from mailm where separator = 'abc@naver.com' and recipient = 'abc@naver.com' and mailcode is null;
select * from mailm order by mailtime desc;
select *
from(select rownum rnum, empemail, mailtitle, mailtime
       from(select * 
        from mailm 
        where separator = 'abc@naver.com' and recipient = 'abc@naver.com' and mailcode is null
        order by mailtime desc))
 where rnum >= 1 and rnum <= 3;

-- 주소록 그룹

drop table addressbook_type cascade constraints;

CREATE TABLE addressbook_type (
   addressbook_code   number primary key   NOT NULL,
   addressbook_name   varchar2(50)   NOT NULL
);

insert into addressbook_type values(addressbook_code_seq.nextval, '가족');
insert into addressbook_type values(addressbook_code_seq.nextval, '친구');
insert into addressbook_type values(addressbook_code_seq.nextval, '회사');
insert into addressbook_type values(addressbook_code_seq.nextval, '거래처');
insert into addressbook_type values(addressbook_code_seq.nextval, '교회');

-- 주소록
drop table addressbook cascade CONSTRAINTS;

CREATE TABLE addressbook (
   addressbook_no number primary key   NOT NULL,
   addressbook_address varchar2(100)   NULL,
   addressbook_etc   varchar2(100)   NULL,
   addressbook_name   varchar2(20)   NULL,
   addressbook_phone   varchar2(20)   NULL,
   addressbook_mail   varchar2(30)   NULL,
   addressbook_code   number NOT NULL references addressbook_type (addressbook_code),
   empno   varchar2(20)   NULL references employee (empno)
);

insert into addressbook values(addressbook_no_seq.nextval, '경기도 성남시 수정구', '가족', '홍길동', '010-1234-5678', 'tjfql@gmail.com', 1, null);
insert into addressbook values(addressbook_no_seq.nextval, '경기도 성남시 중원구', '친구', '이순신', '010-3242-5678', 'soon@gmail.com', 2, null);
insert into addressbook values(addressbook_no_seq.nextval, '경기도 성남시 분당구', '회사', '신사임당', '010-5432-5678', 'sin@gmail.com', 3, null);
insert into addressbook values(addressbook_no_seq.nextval, '서울특별시 노원구', '거래처', '원균', '010-8965-5678', 'won@gmail.com', 4, null);
insert into addressbook values(addressbook_no_seq.nextval, '서울특별시 도봉구', '교회', '유성룡', '010-1232-5678', 'you@gmail.com', 5, null);


COMMIT;