--����-----------------------------------------------------------------

-- ���Ϲ�ȣ ������
drop SEQUENCE mailno_seq;

CREATE SEQUENCE mailno_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
NOCYCLE
NOCACHE;

--�����ڵ� ������
drop SEQUENCE mailcode_seq;

CREATE SEQUENCE mailcode_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
NOCYCLE
NOCACHE;


--�ּҷ��ڵ� ������
drop SEQUENCE addressbook_code_seq;

CREATE SEQUENCE addressbook_code_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
NOCYCLE
NOCACHE;

--�ּҷϹ�ȣ ������
drop SEQUENCE addressbook_no_seq;

CREATE SEQUENCE addressbook_no_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
NOCYCLE
NOCACHE;

-- ������
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

insert into mailboxtype values(mailcode_seq.nextval, '�ӽ�������', 'abc@naver.com');
insert into mailboxtype values(mailcode_seq.nextval, '���� �� ������', 'abc@naver.com');
insert into mailboxtype values(mailcode_seq.nextval, '������', 'abc@naver.com');
insert into mailboxtype values(mailcode_seq.nextval, '����', 'abc@naver.com');
insert into mailboxtype values(mailcode_seq.nextval, 'ȸ��', 'abc@naver.com');
insert into mailboxtype values(mailcode_seq.nextval, '�ŷ�ó', 'abc@naver.com');

--select * from mailboxtype;

-- ����

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

insert into mail values(mailno_seq.nextval, null, 'abc@naver.com', '�ʿ��Է� ���� ��', '19/01/01',
'�ʿ��Է� ���� �濣 ���۳��� ���� �ְ�', 'qwrds@daum.net', 'abc@naver.com');
insert into mail values(mailno_seq.nextval, null, 'abc@naver.com', '��Ӵ�', '19/01/02',
'��� ���� ���� ����', 'rudfl@daum.net', 'abc@naver.com');
insert into mail values(mailno_seq.nextval, null, 'abc@naver.com', '��� ����� ��', '19/01/03',
'��, �ٽ� �¾�ٸ�', 'tjfql@gmail.com', 'abc@naver.com');
insert into mail values(mailno_seq.nextval, null, 'abc@naver.com', '���һ��� ��', '19/01/04',
'���һ� ���� �㿡 ������ ǳ��Ҹ�', 'rjacla@gmail.com', 'abc@naver.com');
insert into mail values(mailno_seq.nextval, null, 'abc@naver.com', '����� �뷡', '19/01/05', '����� ���� ����� �����', NULL, 'abc@naver.com');
insert into mail values(mailno_seq.nextval, 1, 'abc@naver.com', '�ӽ� ������', '19/01/06', '�ӽ������� Ȯ�ο��Դϴ�.', 'qwrds@daum.net', 'abc@naver.com');
insert into mail values(mailno_seq.nextval, null, 'qwrds@daum.net', '�콼 ���Ǽ�', '19/01/07',
'����, �λ� �����ֱ���', 'abc@naver.com', 'abc@naver.com');
insert into mail values(mailno_seq.nextval, null, 'rudfl@daum.net', '�ٽ� �������', '19/01/08',
'�ν�Ÿ�� ���� ���� ���� �Ϸ��', 'abc@naver.com', 'abc@naver.com');
insert into mail values(mailno_seq.nextval, 2, 'abc@naver.com', '���� ��������', '19/01/09', '���� �� ������ Ȯ�ο��Դϴ�.', 'abc@naver.com', 'abc@naver.com');
insert into mail values(mailno_seq.nextval, null, 'qwrds@daum.net', '���� ���߾�', '19/01/11',
'���� �������� �ϰ� ���� ���� ��','abc@naver.com', 'abc@naver.com');
insert into mail values(mailno_seq.nextval, null, 'rudfl@daum.net', '�õ� �ɿ� ���� �ֵ�', '19/01/21',
'�ƹ����� �ƹ��͵� ������ �� ���� ����', 'abc@naver.com', 'abc@naver.com');
insert into mail values(mailno_seq.nextval, 3, 'abc@naver.com', '������', '19/02/01', '������ Ȯ�ο� �Դϴ�.', null, 'abc@naver.com');
insert into mail values(mailno_seq.nextval, 4, 'abc@naver.com', '����', '19/03/01', '���� �׷� Ȯ�ο� �Դϴ�.', null, 'abc@naver.com');
insert into mail values(mailno_seq.nextval, 5, 'abc@naver.com', 'ȸ��', '19/04/01', '���� �׷� Ȯ�ο� �Դϴ�.', null, 'abc@naver.com');
insert into mail values(mailno_seq.nextval, 6, 'abc@naver.com', '�ŷ�ó', '19/05/01', '���� �׷� Ȯ�ο� �Դϴ�.', null, 'abc@naver.com');

-- ���� ������

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

-- �ּҷ� �׷�

drop table addressbook_type cascade constraints;

CREATE TABLE addressbook_type (
   addressbook_code   number primary key   NOT NULL,
   addressbook_name   varchar2(50)   NOT NULL
);

insert into addressbook_type values(addressbook_code_seq.nextval, '����');
insert into addressbook_type values(addressbook_code_seq.nextval, 'ģ��');
insert into addressbook_type values(addressbook_code_seq.nextval, 'ȸ��');
insert into addressbook_type values(addressbook_code_seq.nextval, '�ŷ�ó');
insert into addressbook_type values(addressbook_code_seq.nextval, '��ȸ');

-- �ּҷ�
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

insert into addressbook values(addressbook_no_seq.nextval, '��⵵ ������ ������', '����', 'ȫ�浿', '010-1234-5678', 'tjfql@gmail.com', 1, null);
insert into addressbook values(addressbook_no_seq.nextval, '��⵵ ������ �߿���', 'ģ��', '�̼���', '010-3242-5678', 'soon@gmail.com', 2, null);
insert into addressbook values(addressbook_no_seq.nextval, '��⵵ ������ �д籸', 'ȸ��', '�Ż��Ӵ�', '010-5432-5678', 'sin@gmail.com', 3, null);
insert into addressbook values(addressbook_no_seq.nextval, '����Ư���� �����', '�ŷ�ó', '����', '010-8965-5678', 'won@gmail.com', 4, null);
insert into addressbook values(addressbook_no_seq.nextval, '����Ư���� ������', '��ȸ', '������', '010-1232-5678', 'you@gmail.com', 5, null);

-----추가


COMMIT;