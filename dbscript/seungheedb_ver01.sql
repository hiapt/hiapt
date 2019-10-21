--ȫ���� ----------------------------------------------------------------------
DROP TABLE aptuser cascade CONSTRAINTS;

CREATE TABLE aptuser (
   userid   VARCHAR2(10)      NOT NULL,
  userpwd varchar2(10) not null,
   username   VARCHAR2(20)      NOT NULL,
   userenroll   DATE    NOT NULL,
   userbirth   DATE      NULL,
   userphone   VARCHAR2(50)      NOT NULL,
   useremail   varchar2(50)      NULL,
   useretc   varchar2(500)      NULL,
   cartype   varchar2(50)      NULL,
   carno   varchar2(50)      NULL,
   carenroll   date    NULL,
  
  CONSTRAINT aptuser_pk PRIMARY KEY (userid)
);

COMMENT ON COLUMN aptuser.userid IS '��ȣ��';

COMMENT ON COLUMN aptuser.userpwd IS '��й�ȣ';

COMMENT ON COLUMN aptuser.username IS '�����ָ�';

COMMENT ON COLUMN aptuser.userenroll IS '������';

COMMENT ON COLUMN aptuser.userbirth IS '�������';

COMMENT ON COLUMN aptuser.userphone IS '����ó';

COMMENT ON COLUMN aptuser.useremail IS '�̸���';

COMMENT ON COLUMN aptuser.useretc IS '�޸�';

COMMENT ON COLUMN aptuser.cartype IS '����';

COMMENT ON COLUMN aptuser.carno IS '������ȣ';

COMMENT ON COLUMN aptuser.carenroll IS '�����';

insert into aptuser(userid,   userpwd, username,   userenroll,   userbirth,   userphone,   useremail,   useretc,   cartype,   carno,   carenroll)
values('101-101', '101-101', '������1', '2019-10-01', '1992-10-02', '010-6547-3214', 'dlqwnwk@naver.com', 'ù��° �������Դϴ�.', 'Ƽ����', '32�� 3210', sysdate);

insert into aptuser(userid,   userpwd, username,   userenroll,   userbirth,   userphone,   useremail,   useretc,   cartype,   carno,   carenroll)
values('101-102', '101-102', '���̿�', '2019-10-01', '1992-07-30', '010-8989-6209', 'rnaldud89@gmail.com', '�ι�° �������Դϴ�.', 'GV80', '89�� 8962', sysdate);

insert into aptuser(userid,   userpwd, username,   userenroll,   userbirth,   userphone,   useremail,   useretc,   cartype,   carno,   carenroll)
values('102-101', '102-101', '������', '2019-10-01', '1992-08-05', '010-8431-1257', 'ess5700@naver.com', '����° �������Դϴ�.', '���Ϻ�', '84�� 3112', sysdate);

insert into aptuser(userid,   userpwd, username,   userenroll,   userbirth,   userphone,   useremail,   useretc,   cartype,   carno,   carenroll)
values('201-101', '201-101', '�̿���', sysdate, '1992-04-12', '010-6393-9273', 'dldudtn118@naver.com', '�׹�° �������Դϴ�.', '������', '63�� 9392', sysdate);

insert into aptuser(userid,   userpwd, username,   userenroll,   userbirth,   userphone,   useremail,   useretc,   cartype,   carno,   carenroll)
values('201-201', '201-201', '������', sysdate, '1992-05-25', '010-8001-6812', 'dd55555bb@gmail.com', '�ټ���° �������Դϴ�.', '�ڳ�', '80�� 0168', sysdate);

insert into aptuser(userid,   userpwd, username,   userenroll,   userbirth,   userphone,   useremail,   useretc,   cartype,   carno,   carenroll)
values('202-101', '202-101', '����', '2019-10-01', '1992-01-14', '010-2685-4111', 'horse4797@naver.com', '������° �������Դϴ�.', '����Ƽ��', '85�� 8541', sysdate);

insert into aptuser(userid,   userpwd, username,   userenroll,   userbirth,   userphone,   useremail,   useretc,   cartype,   carno,   carenroll)
VALUES('202-201', '202-201', 'ȫ����', '2019-10-01', '1992-09-21', '010-2291-5428', 'someday921@nate.com', '�ϰ���° �������Դϴ�.', '�ڶ���', '91�� 9154', SYSDATE);


-------------------------------------------------------------------------------------------------------------------------------------------------------
DROP SEQUENCE SEQ_SECURITY;
DROP SEQUENCE SEQ_ACCOUNTANCY;
DROP SEQUENCE SEQ_FACILITY;
DROP SEQUENCE SEQ_READING;

CREATE SEQUENCE SEQ_SECURITY
START WITH 10002
MAXVALUE 29999
NOCYCLE
INCREMENT BY 1;

CREATE SEQUENCE SEQ_ACCOUNTANCY
START WITH 30002
MAXVALUE 49999
NOCYCLE
INCREMENT BY 1;

CREATE SEQUENCE SEQ_FACILITY
START WITH 50002
MAXVALUE 69999
NOCYCLE
INCREMENT BY 1;

CREATE SEQUENCE SEQ_READING
START WITH 70002
MAXVALUE 89999
NOCYCLE
INCREMENT BY 1;

DROP TABLE employee cascade CONSTRAINTS;

CREATE TABLE employee (
   empno   varchar2(20)   NOT NULL,
  emppwd varchar2(20) NOT NULL,
   empname   varchar2(20)      NOT NULL,
   empid   varchar2(20)      NOT NULL,
   emphiredate   date   NOT NULL,
   empphone   varchar2(50)   UNIQUE   NOT NULL,
   empssn   varchar2(50)   UNIQUE   NOT NULL,
  empzipcode number NOT NULL,
   empaddress   varchar2(100)      NOT NULL,
   empemail   varchar2(50)      UNIQUE NOT NULL,
  empfamily number NOT NULL,
   empetc   varchar2(500)      NULL,
   salary   number      NOT NULL,
   pension   number      NULL,
   insurance   number      NULL,
   longins   number      NULL,
   hireins   number      NULL,
   incometax   number      NULL,
   localtax   number      NULL,
   salarytot number null,
   minustot number null,
   realsalary number null,
  
  CONSTRAINT employee_pk PRIMARY KEY (empno)
);

COMMENT ON COLUMN employee.empno IS '���';

COMMENT ON COLUMN employee.emppwd IS '��й�ȣ';

COMMENT ON COLUMN employee.empname IS '�̸�';

COMMENT ON COLUMN employee.empid IS '����';

COMMENT ON COLUMN employee.emphiredate IS '�Ի���';

COMMENT ON COLUMN employee.empphone IS '�޴���ȭ';

COMMENT ON COLUMN employee.empssn IS '�ֹι�ȣ';

COMMENT ON COLUMN employee.empzipcode IS '�����ȣ';

COMMENT ON COLUMN employee.empaddress IS '�ּ�';

COMMENT ON COLUMN employee.empemail IS '�̸���';

COMMENT ON COLUMN employee.empfamily IS '�ξ簡����';

COMMENT ON COLUMN employee.empetc IS '��Ÿ����';

COMMENT ON COLUMN employee.salary IS '�⺻��';

COMMENT ON COLUMN employee.pension IS '���ο���';

COMMENT ON COLUMN employee.insurance IS '�ǰ�����';

COMMENT ON COLUMN employee.longins IS '����纸��';

COMMENT ON COLUMN employee.hireins IS '��뺸��';

COMMENT ON COLUMN employee.incometax IS '�ҵ漼';

COMMENT ON COLUMN employee.localtax IS '����ҵ漼';

COMMENT ON COLUMN employee.salarytot IS '�����Ѿ�';

COMMENT ON COLUMN employee.minustot IS '�����Ѿ�';

COMMENT ON COLUMN employee.realsalary IS '�����޾�';


insert into employee(empno, emppwd, empname, empid, emphiredate, empphone, empssn, empzipcode, empaddress, empemail, empfamily, empetc, 
salary, pension, insurance, longins, hireins, salarytot, minustot, realsalary) 
values('admin', 'admin', '������', '������', '2019-10-01', '010-1234-5678', '921002-1234567', '15540', '����Ư���� �������126', 'abc@naver.com', 0, '�������Դϴ�.', 
8500000, 0.045, 0.323, 0.04255, 0.065, 1, 1, 1);

insert into employee(empno, emppwd, empname, empid, emphiredate, empphone, empssn, empzipcode, empaddress, empemail, empfamily, empetc, 
salary, pension, insurance, longins, hireins, salarytot, minustot, realsalary) 
values('10001', '10001', '�躸��', '��������', '2019-10-01', '010-7410-8520', '891115-9876543', '15540', '����Ư���� ���α� 54', 'qwrds@daum.net', 0, '���������Դϴ�.', 
8500000, 0.045, 0.323, 0.04255, 0.065, 1, 1, 1);

insert into employee(empno, emppwd, empname, empid, emphiredate, empphone, empssn, empzipcode, empaddress, empemail, empfamily, empetc, 
salary, pension, insurance, longins, hireins, salarytot, minustot, realsalary) 
values('30001', '30001', '�̰渮', '�渮', '2019-10-01', '010-9876-5432', '900215-4567125', '15540', '��õ������ ������ 21', 'rudfl@daum.net', 0, '�渮�Դϴ�.', 
8500000, 0.045, 0.323, 0.04255, 0.065, 1, 1, 1);

insert into employee(empno, emppwd, empname, empid, emphiredate, empphone, empssn, empzipcode, empaddress, empemail, empfamily, empetc, 
salary, pension, insurance, longins, hireins, salarytot, minustot, realsalary) 
values('50001', '50001', '�ڼ���', '�������', '2019-10-01', '010-2145-5647', '850319-7425632', '15540', '��⵵ ������ 96', 'tjfql@gmail.com', 0, '��������Դϴ�.', 
8500000, 0.045, 0.323, 0.04255, 0.065, 1, 1, 1);

insert into employee(empno, emppwd, empname, empid, emphiredate, empphone, empssn, empzipcode, empaddress, empemail, empfamily, empetc, 
salary, pension, insurance, longins, hireins, salarytot, minustot, realsalary) 
values('70001', '70001', '����ħ', '��ħ���', '2019-10-01', '010-3658-7854', '840522-2365897', '15540', '���ϵ� ���̽� 88', 'rjacla@gmail.com', 0, '��ħ����Դϴ�.', 
8500000, 0.045, 0.323, 0.04255, 0.065, 1, 1, 1);

commit;