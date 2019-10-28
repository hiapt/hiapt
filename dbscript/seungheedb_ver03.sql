--홍승희 ----------------------------------------------------------------------
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

COMMENT ON COLUMN aptuser.userid IS '동호수';

COMMENT ON COLUMN aptuser.userpwd IS '비밀번호';

COMMENT ON COLUMN aptuser.username IS '세대주명';

COMMENT ON COLUMN aptuser.userenroll IS '입주일';

COMMENT ON COLUMN aptuser.userbirth IS '생년월일';

COMMENT ON COLUMN aptuser.userphone IS '연락처';

COMMENT ON COLUMN aptuser.useremail IS '이메일';

COMMENT ON COLUMN aptuser.useretc IS '메모';

COMMENT ON COLUMN aptuser.cartype IS '차종';

COMMENT ON COLUMN aptuser.carno IS '차량번호';

COMMENT ON COLUMN aptuser.carenroll IS '등록일';

insert into aptuser(userid,   userpwd, username,   userenroll,   userbirth,   userphone,   useremail,   useretc,   cartype,   carno,   carenroll)
values('101-101', '101-101', '입주자1', '2019-10-01', '1992-10-02', '010-6547-3214', 'dlqwnwk@naver.com', '첫번째 입주자입니다.', '티볼리', '32가 3210', sysdate);

insert into aptuser(userid,   userpwd, username,   userenroll,   userbirth,   userphone,   useremail,   useretc,   cartype,   carno,   carenroll)
values('101-102', '101-102', '구미영', '2019-10-01', '1992-07-30', '010-8989-6209', 'rnaldud89@gmail.com', '두번째 입주자입니다.', 'GV80', '89라 8962', sysdate);

insert into aptuser(userid,   userpwd, username,   userenroll,   userbirth,   userphone,   useremail,   useretc,   cartype,   carno,   carenroll)
values('102-101', '102-101', '김은솔', '2019-10-01', '1992-08-05', '010-8431-1257', 'ess5700@naver.com', '세번째 입주자입니다.', '모하비', '84아 3112', sysdate);

insert into aptuser(userid,   userpwd, username,   userenroll,   userbirth,   userphone,   useremail,   useretc,   cartype,   carno,   carenroll)
values('201-101', '201-101', '이영수', sysdate, '1992-04-12', '010-6393-9273', 'dldudtn118@naver.com', '네번째 입주자입니다.', '렉스턴', '63고 9392', sysdate);

insert into aptuser(userid,   userpwd, username,   userenroll,   userbirth,   userphone,   useremail,   useretc,   cartype,   carno,   carenroll)
values('201-201', '201-201', '전로하', sysdate, '1992-05-25', '010-8001-6812', 'dd55555bb@gmail.com', '다섯번째 입주자입니다.', '코나', '80다 0168', sysdate);

insert into aptuser(userid,   userpwd, username,   userenroll,   userbirth,   userphone,   useremail,   useretc,   cartype,   carno,   carenroll)
values('202-101', '202-101', '허용순', '2019-10-01', '1992-01-14', '010-2685-4111', 'horse4797@naver.com', '여섯번째 입주자입니다.', '스포티지', '85아 8541', sysdate);

insert into aptuser(userid,   userpwd, username,   userenroll,   userbirth,   userphone,   useremail,   useretc,   cartype,   carno,   carenroll)
VALUES('202-201', '202-201', '홍승희', '2019-10-01', '1992-09-21', '010-2291-5428', 'someday921@nate.com', '일곱번째 입주자입니다.', '코란도', '91다 9154', SYSDATE);


-------------------------------------------------------------------------------------------------------------------------------------------------------
DROP SEQUENCE SEQ_SECURITY;
DROP SEQUENCE SEQ_ACCOUNTANCY;
DROP SEQUENCE SEQ_FACILITY;
DROP SEQUENCE SEQ_READING;

CREATE SEQUENCE SEQ_SECURITY
START WITH 10002
MAXVALUE 29999
NOCYCLE
NOCACHE
INCREMENT BY 1;

CREATE SEQUENCE SEQ_ACCOUNTANCY
START WITH 30002
MAXVALUE 49999
NOCYCLE
NOCACHE
INCREMENT BY 1;

CREATE SEQUENCE SEQ_FACILITY
START WITH 50002
MAXVALUE 69999
NOCYCLE
NOCACHE
INCREMENT BY 1;

CREATE SEQUENCE SEQ_READING
START WITH 70002
MAXVALUE 89999
NOCYCLE
NOCACHE
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

COMMENT ON COLUMN employee.empno IS '사번';

COMMENT ON COLUMN employee.emppwd IS '비밀번호';

COMMENT ON COLUMN employee.empname IS '이름';

COMMENT ON COLUMN employee.empid IS '직급';

COMMENT ON COLUMN employee.emphiredate IS '입사일';

COMMENT ON COLUMN employee.empphone IS '휴대전화';

COMMENT ON COLUMN employee.empssn IS '주민번호';

COMMENT ON COLUMN employee.empzipcode IS '우편번호';

COMMENT ON COLUMN employee.empaddress IS '주소';

COMMENT ON COLUMN employee.empemail IS '이메일';

COMMENT ON COLUMN employee.empfamily IS '부양가족수';

COMMENT ON COLUMN employee.empetc IS '기타정보';

COMMENT ON COLUMN employee.salary IS '기본급';

COMMENT ON COLUMN employee.pension IS '국민연금';

COMMENT ON COLUMN employee.insurance IS '건강보험';

COMMENT ON COLUMN employee.longins IS '장기요양보험';

COMMENT ON COLUMN employee.hireins IS '고용보험';

COMMENT ON COLUMN employee.incometax IS '소득세';

COMMENT ON COLUMN employee.localtax IS '지방소득세';

COMMENT ON COLUMN employee.salarytot IS '지급총액';

COMMENT ON COLUMN employee.minustot IS '공제총액';

COMMENT ON COLUMN employee.realsalary IS '실지급액';


Insert into EMPLOYEE (EMPNO,EMPPWD,EMPNAME,EMPID,EMPHIREDATE,EMPPHONE,EMPSSN,EMPZIPCODE,EMPADDRESS,EMPEMAIL,EMPFAMILY,EMPETC,SALARY,PENSION,INSURANCE,LONGINS,HIREINS,INCOMETAX,LOCALTAX,SALARYTOT,MINUSTOT,REALSALARY) values ('admin','admin','관리자','관리자',to_date('19/10/01','RR/MM/DD'),'010-1234-5678','921002-1234567',15540,'서울특별시 테헤란로126,dd,dd','abc@naver.com',0,'관리자입니다.',9000000,405000,290700,765900,72000,0,0,9000000,1533600,7466400);

Insert into EMPLOYEE (EMPNO,EMPPWD,EMPNAME,EMPID,EMPHIREDATE,EMPPHONE,EMPSSN,EMPZIPCODE,EMPADDRESS,EMPEMAIL,EMPFAMILY,EMPETC,SALARY,PENSION,INSURANCE,LONGINS,HIREINS,INCOMETAX,LOCALTAX,SALARYTOT,MINUSTOT,REALSALARY) values ('10001','10001','김보안','보안직원',to_date('19/10/01','RR/MM/DD'),'010-7410-8520','891115-9876543',15540,'서울특별시 구로구 54,d,d','qwrds@daum.net',0,'보안직원입니다.',8500000,382500,274550,723350,68000,0,0,8500000,1448400,7051600);

Insert into EMPLOYEE (EMPNO,EMPPWD,EMPNAME,EMPID,EMPHIREDATE,EMPPHONE,EMPSSN,EMPZIPCODE,EMPADDRESS,EMPEMAIL,EMPFAMILY,EMPETC,SALARY,PENSION,INSURANCE,LONGINS,HIREINS,INCOMETAX,LOCALTAX,SALARYTOT,MINUSTOT,REALSALARY) values ('30001','30001','이경리','경리',to_date('19/10/01','RR/MM/DD'),'010-9876-5432','900215-4567125',15540,'인천광역시 논현동 21,d,d','rudfl@daum.net',0,'경리입니다.',8500000,382500,274550,723350,68000,0,0,8500000,1448400,7051600);
Insert into EMPLOYEE (EMPNO,EMPPWD,EMPNAME,EMPID,EMPHIREDATE,EMPPHONE,EMPSSN,EMPZIPCODE,EMPADDRESS,EMPEMAIL,EMPFAMILY,EMPETC,SALARY,PENSION,INSURANCE,LONGINS,HIREINS,INCOMETAX,LOCALTAX,SALARYTOT,MINUSTOT,REALSALARY) values ('50001','50001','박설비','설비과장',to_date('19/10/01','RR/MM/DD'),'010-2145-5647','850319-7425632',15540,'경기도 수원시 96,dd,ggg','tjfql@gmail.com',0,'설비과장입니다.',8500000,382500,274550,723350,68000,0,0,8500000,1448400,7051600);

Insert into EMPLOYEE (EMPNO,EMPPWD,EMPNAME,EMPID,EMPHIREDATE,EMPPHONE,EMPSSN,EMPZIPCODE,EMPADDRESS,EMPEMAIL,EMPFAMILY,EMPETC,SALARY,PENSION,INSURANCE,LONGINS,HIREINS,INCOMETAX,LOCALTAX,SALARYTOT,MINUSTOT,REALSALARY) values ('70001','70001','전검침','검침기사',to_date('19/10/01','RR/MM/DD'),'010-3658-7854','840522-2365897',15540,'경상북도 구미시 88,gg,gg','rjacla@gmail.com',0,'검침기사입니다.',8500000,0.045,0.323,0.04255,0.065,null,null,1,1,1);

Insert into EMPLOYEE (EMPNO,EMPPWD,EMPNAME,EMPID,EMPHIREDATE,EMPPHONE,EMPSSN,EMPZIPCODE,EMPADDRESS,EMPEMAIL,EMPFAMILY,EMPETC,SALARY,PENSION,INSURANCE,LONGINS,HIREINS,INCOMETAX,LOCALTAX,SALARYTOT,MINUSTOT,REALSALARY) values ('50002','50002','ddd','설비과장',to_date('19/10/18','RR/MM/DD'),'010-6523-6548','901225-5482365',17740,'경기 성남시 분당구 판교역로 4,dd,dd','secu@daum.net',1,'dd',1,0,0,0,0,0,0,0,0,0);

Insert into EMPLOYEE (EMPNO,EMPPWD,EMPNAME,EMPID,EMPHIREDATE,EMPPHONE,EMPSSN,EMPZIPCODE,EMPADDRESS,EMPEMAIL,EMPFAMILY,EMPETC,SALARY,PENSION,INSURANCE,LONGINS,HIREINS,INCOMETAX,LOCALTAX,SALARYTOT,MINUSTOT,REALSALARY) values ('30003','30003','테스트','경리',to_date('19/10/21','RR/MM/DD'),'010-1234-8974','652012-5412547',13473,'경기 성남시 분당구 삼평동 421,123,3455','servi@daum.net',1,'ㄴㅇㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹㄴ',300000000,13500000,9690000,25530000,2400000,300000000,300000000,300000000,51120000,248880000);
Insert into EMPLOYEE (EMPNO,EMPPWD,EMPNAME,EMPID,EMPHIREDATE,EMPPHONE,EMPSSN,EMPZIPCODE,EMPADDRESS,EMPEMAIL,EMPFAMILY,EMPETC,SALARY,PENSION,INSURANCE,LONGINS,HIREINS,INCOMETAX,LOCALTAX,SALARYTOT,MINUSTOT,REALSALARY) values ('30004','30004','테스트2','경리',to_date('19/10/21','RR/MM/DD'),'010-1234-8977','652012-5412533',13473,'경기 성남시 분당구 삼평동 421,123,34552','ser22vi@daum.net',1,'ㄴㅇㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹㄴㄷㄷ',2456789,110560,79350,209070,19650,2456790,2456790,0,0,0);

Insert into EMPLOYEE (EMPNO,EMPPWD,EMPNAME,EMPID,EMPHIREDATE,EMPPHONE,EMPSSN,EMPZIPCODE,EMPADDRESS,EMPEMAIL,EMPFAMILY,EMPETC,SALARY,PENSION,INSURANCE,LONGINS,HIREINS,INCOMETAX,LOCALTAX,SALARYTOT,MINUSTOT,REALSALARY) values ('50022','50022','테스트2','설비과장',to_date('19/10/23','RR/MM/DD'),'010-1234-8973','652012-5412512',13536,'경기 성남시 분당구 백현동 575-7,334,22222','wert@daum.net',1,'.03232',3452234,155350,111510,293790,27620,3452230,3452230,0,0,0);

Insert into EMPLOYEE (EMPNO,EMPPWD,EMPNAME,EMPID,EMPHIREDATE,EMPPHONE,EMPSSN,EMPZIPCODE,EMPADDRESS,EMPEMAIL,EMPFAMILY,EMPETC,SALARY,PENSION,INSURANCE,LONGINS,HIREINS,INCOMETAX,LOCALTAX,SALARYTOT,MINUSTOT,REALSALARY) values ('70002','70002','dsdf','검침기사',to_date('19/10/23','RR/MM/DD'),'010-4545-6655','960523-2341234',63308,'제주특별자치도 제주시 영평동 2012-15,ㅇㅇㄴ,ㄴㅇㄹㄴㅇ','sec22u@daum.net',1,'ㅇㅇㅇ',2552236,114850,82440,217200,20420,2552240,2552240,2552236,434910,2117326);

Insert into EMPLOYEE (EMPNO,EMPPWD,EMPNAME,EMPID,EMPHIREDATE,EMPPHONE,EMPSSN,EMPZIPCODE,EMPADDRESS,EMPEMAIL,EMPFAMILY,EMPETC,SALARY,PENSION,INSURANCE,LONGINS,HIREINS,INCOMETAX,LOCALTAX,SALARYTOT,MINUSTOT,REALSALARY) values ('50042','50042','양서연','설비과장',to_date('19/10/25','RR/MM/DD'),'010-9999-8888','891105-2547896',13473,'경기 성남시 분당구 삼평동 421,ㄴㅇㄹ,ㄴㅇㄹ','ser1vi@daum.net',2,null,3000000,135000,96900,255300,24000,6000000,6000000,3000000,511200,2488800);

commit;