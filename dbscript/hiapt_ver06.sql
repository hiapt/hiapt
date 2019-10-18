--홍승희 ----------------------------------------------------------------------
DROP TABLE aptuser cascade CONSTRAINTS;

CREATE TABLE aptuser (
   userid   VARCHAR2(10)      NOT NULL,
  userpwd varchar2(10) not null,
   username   VARCHAR2(20)      NOT NULL,
   userenroll   DATE   DEFAULT SYSDATE   NOT NULL,
   userbirth   DATE      NULL,
   userphone   VARCHAR2(50)      NOT NULL,
   useremail   varchar2(50)      NULL,
   useretc   varchar2(500)      NULL,
   cartype   varchar2(50)      NULL,
   carno   varchar2(50)      NULL,
   carenroll   date   DEFAULT sysdate   NULL,
  
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
   emphiredate   date   DEFAULT sysdate   NOT NULL,
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

insert into employee(empno, emppwd, empname, empid, emphiredate, empphone, empssn, empzipcode, empaddress, empemail, empfamily, empetc, 
salary, pension, insurance, longins, hireins) 
values('admin', 'admin', '관리자', '관리자', '2019-10-01', '010-1234-5678', '921002-1234567', '15540', '서울특별시 테헤란로126', 'abc@naver.com', 0, '관리자입니다.', 
8500000, 0.045, 0.323, 0.04255, 0.065);

insert into employee(empno, emppwd, empname, empid, emphiredate, empphone, empssn, empzipcode, empaddress, empemail, empfamily, empetc, 
salary, pension, insurance, longins, hireins) 
values('10001', '10001', '김보안', '보안직원', '2019-10-01', '010-7410-8520', '891115-9876543', '15540', '서울특별시 구로구 54', 'qwrds@daum.net', 0, '보안직원입니다.', 
3000000, 0.045, 0.323, 0.04255, 0.065);

insert into employee(empno, emppwd, empname, empid, emphiredate, empphone, empssn, empzipcode, empaddress, empemail, empfamily, empetc, 
salary, pension, insurance, longins, hireins) 
values('30001', '30001', '이경리', '경리', '2019-10-01', '010-9876-5432', '900215-4567125', '15540', '인천광역시 논현동 21', 'rudfl@daum.net', 0, '경리입니다.', 
3000000, 0.045, 0.323, 0.04255, 0.065);

insert into employee(empno, emppwd, empname, empid, emphiredate, empphone, empssn, empzipcode, empaddress, empemail, empfamily, empetc, 
salary, pension, insurance, longins, hireins) 
values('50001', '50001', '박설비', '설비과장', '2019-10-01', '010-2145-5647', '850319-7425632', '15540', '경기도 수원시 96', 'tjfql@gmail.com', 0, '설비과장입니다.', 
3000000, 0.045, 0.323, 0.04255, 0.065);

insert into employee(empno, emppwd, empname, empid, emphiredate, empphone, empssn, empzipcode, empaddress, empemail, empfamily, empetc, 
salary, pension, insurance, longins, hireins) 
values('70001', '70001', '전검침', '검침기사', '2019-10-01', '010-3658-7854', '840522-2365897', '15540', '경상북도 구미시 88', 'rjacla@gmail.com', 0, '검침기사입니다.', 
3000000, 0.045, 0.323, 0.04255, 0.065);

commit;

--굼--------------------------------------------------------------------------------------------------------------------------------------------------
drop table SCHEDULE;

CREATE TABLE SCHEDULE (
	SCH_NO  	NUMBER	CONSTRAINT SCH_PK PRIMARY KEY,
	SCH_TITLE	VARCHAR2(30)		NOT NULL,
	SCH_TYPE	VARCHAR2(10)	 DEFAULT '업무' NOT NULL,
	SCH_START	DATE		NOT NULL,
	SCH_END	DATE 	NOT NULL,
	SCH_MEMO	VARCHAR2(100)	 NULL,
	SCH_OPEN	CHAR(1)		DEFAULT 'N' NOT NULL,
	SCH_ALARM CHAR(1)		DEFAULT 'N' NOT NULL,
	SCH_COLOR	VARCHAR2(20)		DEFAULT 'GRAY' NOT NULL,
  IMPORTANCE CHAR(1) DEFAULT '2',
	EMPNO	VARCHAR2(20)	 NOT NULL,
  
  CONSTRAINT EMPNO_FK FOREIGN KEY(EMPNO) REFERENCES EMPLOYEE ON DELETE CASCADE
);
COMMENT ON COLUMN SCHEDULE.SCH_NO IS '일정번호';

COMMENT ON COLUMN SCHEDULE.SCH_TITLE IS '일정명';

COMMENT ON COLUMN SCHEDULE.SCH_TYPE IS '구분';

COMMENT ON COLUMN SCHEDULE.SCH_START IS '시작일';

COMMENT ON COLUMN SCHEDULE.SCH_END IS '종료일';

COMMENT ON COLUMN SCHEDULE.SCH_MEMO IS '메모';

COMMENT ON COLUMN SCHEDULE.SCH_OPEN IS '공개여부';

COMMENT ON COLUMN SCHEDULE.SCH_ALARM IS '알람여부';

COMMENT ON COLUMN SCHEDULE.SCH_COLOR IS '색상';

COMMENT ON COLUMN SCHEDULE.EMPNO IS '사번';

COMMENT ON COLUMN SCHEDULE.IMPORTANCE IS '중요도';

DROP SEQUENCE SCH_SEQ;

CREATE SEQUENCE SCH_SEQ
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCYCLE  
NOCACHE;

INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '입주민회의', DEFAULT, TO_DATE(20191004), TO_DATE(20191004), '11시 3층', 'Y', DEFAULT, DEFAULT, DEFAULT, 'admin'); 
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '구청방문', DEFAULT, TO_DATE(20191001), TO_DATE(20191001), '3시에 외근', DEFAULT, DEFAULT, DEFAULT, DEFAULT, 'A001'); 
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '101동검침', DEFAULT, TO_DATE(20190930), TO_DATE(20190930), '101동 검침예정', DEFAULT, DEFAULT, DEFAULT, DEFAULT, 'R001'); 
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '2단지 놀이터점검', DEFAULT, TO_DATE(20190928), TO_DATE(20190928), '2단지 설비점검', DEFAULT, DEFAULT, DEFAULT, DEFAULT, 'F001'); 
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, 'CCTV점검', DEFAULT, TO_DATE(20191002), TO_DATE(20191002), 'CCTV 점검', DEFAULT, DEFAULT, DEFAULT, DEFAULT, 'S001'); 

commit;
--  관리비 및 결제  db 시작*********************************************************
--  관리비 및 결제  db 시작*********************************************************

drop table bill cascade constraints;
-- BILL 테이블 생성(NULL로)
create table bill(
	MERCHANT_UID NUMBER		NOT NULL,
  USERID 	VARCHAR2(10)		NULL,
	USERNAME VARCHAR2(20)		NULL,
	BILL_YEAR_MONTH	DATE NULL,
	CALCULATE_START_DAY	DATE NULL,
	CALCULATE_END_DAY	DATE NULL,
	IMPOSE_END_DATE DATE NULL,	
	ACCEPT_DATE	DATE NULL,
  CUTOFF_DATE	DATE NULL,
	IMPOSE_STATUS	VARCHAR2(12) NULL,
	IMPOSE_COUNT NUMBER DEFAULT 0	NULL,
	IMPOSE_FINISH	CHAR	DEFAULT 'N'	NULL,
	GENERAL_COST 	NUMBER	DEFAULT 0	NULL,
  guard_cost 	NUMBER	DEFAULT 0	NULL,
	clean_cost	 NUMBER	DEFAULT 0	NULL,
	DISINFECT_COST 	NUMBER	DEFAULT 0	NULL,
	ELEVATOR_COST 	NUMBER	DEFAULT 0	NULL,
	REPAIR_COST 	NUMBER	DEFAULT 0	NULL,
	commission 	NUMBER	DEFAULT 0	NULL,
	FIREINSURANCE_COST	NUMBER	DEFAULT 0	NULL,	
	electric_cost 	NUMBER	DEFAULT 0	NULL,	
	TV_COST	NUMBER	DEFAULT 2500	NULL,
  WATER_COST 	NUMBER	DEFAULT 0	NULL,
	heating_cost 	NUMBER	DEFAULT 0	NULL,
	HWATER_COST	NUMBER	DEFAULT 0	NULL,	  
  ALLELECTRIC_COAT	NUMBER	DEFAULT 0	NULL,	
  ALLWATER_COST 	NUMBER	DEFAULT 0	NULL,  
	ELECTRIC_USAGE 	NUMBER	DEFAULT 0	NULL,	
	water_usage	NUMBER	DEFAULT 0	NULL,
  HEATING_USAGE	NUMBER	DEFAULT 0	NULL,  
	HWATER_USAGE 	NUMBER	DEFAULT 0	NULL,  
	ARREARS	NUMBER DEFAULT 0 NULL,  
	ETC	VARCHAR2(20) NULL,
	VBANK_NUM	VARCHAR2(20) NULL,
  CONSTRAINT PK_BILL PRIMARY KEY(MERCHANT_UID), 
  CONSTRAINT CK_BILL CHECK (IMPOSE_FINISH IN ('Y', 'N'))
);

--  BILL COMMENT
COMMENT ON COLUMN bill.merchant_uid IS '고유고지서번호';
COMMENT ON COLUMN bill.userid IS '동/호수';
COMMENT ON COLUMN BILL.USERNAME IS '이름';
COMMENT ON COLUMN BILL.BILL_YEAR_MONTH IS '고지서부과월';
COMMENT ON COLUMN BILL.CALCULATE_START_DAY IS '산출기간시작일';
COMMENT ON COLUMN BILL.CALCULATE_END_DAY IS '산출기간마감일';
COMMENT ON COLUMN BILL.IMPOSE_END_DATE IS '부과마감일';
COMMENT ON COLUMN bill.accept_date IS '출력의뢰일시';
COMMENT ON COLUMN bill.cutoff_date IS '납부마감일';
COMMENT ON COLUMN bill.impose_status IS '부과진행';
COMMENT ON COLUMN bill.impose_count IS '부과마감횟수';
COMMENT ON COLUMN BILL.IMPOSE_FINISH IS '부과완료';
COMMENT ON COLUMN bill.general_cost IS '일반관리비';
COMMENT ON COLUMN bill.clean_cost IS '청소비';
COMMENT ON COLUMN bill.disinfect_cost IS '소독비';
COMMENT ON COLUMN bill.elevator_cost IS '승강기유지비';
COMMENT ON COLUMN bill.repair_cost IS '수선유지비';
COMMENT ON COLUMN BILL.GUARD_COST IS '경비비';
COMMENT ON COLUMN bill.fireinsurance_cost IS '화재보험료';
COMMENT ON COLUMN BILL.COMMISSION IS '위탁관리수수료';
COMMENT ON COLUMN bill.electric_cost IS '세대전기료';
COMMENT ON COLUMN bill.allelectric_coat IS '공동전기료';
COMMENT ON COLUMN bill.tv_cost IS 'TV수신료';
COMMENT ON COLUMN bill.heating_cost IS '난방사용료';
COMMENT ON COLUMN bill.hwater_cost IS '온수사용료';
COMMENT ON COLUMN bill.water_cost IS '세대수도료';
COMMENT ON COLUMN BILL.ALLWATER_COST IS '공동수도료';
COMMENT ON COLUMN bill.electric_usage IS '전기사용량';
COMMENT ON COLUMN bill.heating_usage IS '난방사용량';
COMMENT ON COLUMN BILL.HWATER_USAGE IS '온수사용량';
COMMENT ON COLUMN bill.water_usage IS '수도사용량';
COMMENT ON COLUMN bill.arrears IS '미납액';
COMMENT ON COLUMN BILL.ETC IS '비고';
COMMENT ON COLUMN BILL.VBANK_NUM IS '계좌번호';
--------------------------------------------------------------
DROP SEQUENCE BILL_SEQ;
--BILL 시퀀스 생성
CREATE SEQUENCE BILL_SEQ
START WITH 10000000000001
INCREMENT BY 1
MAXVALUE 90000000000000
MINVALUE 1
NOCYCLE
NOCACHE;

-- bill insert
INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','전로하','2019/09/01',
'2019/08/01','2019/08/31','2019/08/31','2019/08/31','2019/09/30',
  '완료',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  73510, 13970, DEFAULT, 0, 0, 1710, 860,
  404, 15, 0, 0,DEFAULT, NULL,'110-23-0310818'
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','전로하','2019/08/01',
'2019/07/01','2019/07/31','2019/07/31','2019/07/31','2019/08/31',
  '완료',1,'Y',
  20520, 20870, 13500, 770, 3920, 2080, 650, 960,
  73510, 2140, DEFAULT, 0, 0, 1710, 860,
  404, 32, 0, 0,DEFAULT, NULL,'110-23-0310818'
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'202-101','허용순','2019/08/01',
'2019/07/01','2019/07/31','2019/07/31','2019/07/31','2019/08/31',
  '완료',1,'Y',
  29040, 29530, 19110, 1080, 4660, 2940, 2570, 910,
  73510, 2140, DEFAULT, 0, 0, 1710, 860,
  404, 32, 0, 0,DEFAULT, NULL,'110-23-0310818'
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','전로하','2019/07/01',
'2019/06/01','2019/06/30','2019/06/30','2019/06/30','2019/07/31',
  '완료',1,'Y',
  20390, 20870, 13500, 770, 3290, 1810, 650, 810,
  73510, 13830, DEFAULT, 0, 0, 1610, 890,
  404, 15, 0, 0,DEFAULT, NULL,'110-23-0310818'
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','전로하','2019/06/01',
'2019/05/01','2019/05/31','2019/05/31','2019/05/31','2019/06/30',
  '완료',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  73510, 13830, DEFAULT, 0, 0, 1850, 860,
  404, 15, 0, 0,DEFAULT, NULL,'110-23-0310818'
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','전로하','2019/05/01',
'2019/04/01','2019/04/30','2019/04/30','2019/04/30','2019/05/31',
  '완료',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  73510, 13830, DEFAULT, 0, 0, 1850, 860,
  404, 15, 0, 0,DEFAULT, NULL,'110-23-0310818'
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','전로하','2019/04/01',
'2019/03/01','2019/03/31','2019/03/31','2019/03/31','2019/04/30',
  '완료',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  73510, 13830, DEFAULT, 9680, 23100, 1850, 860,
  404, 15,1.2, 5.5,DEFAULT, NULL,'110-23-0310818'
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','전로하','2019/03/01',
'2019/02/01','2019/02/28','2019/02/28','2019/02/28','2019/03/31',
  '완료',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  73510, 13830, DEFAULT, 12280, 31820, 1850, 860,
  404, 15,1.5, 6.5,DEFAULT, NULL,'110-23-0310818'
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','전로하','2019/02/01',
'2019/01/01','2019/01/31','2019/01/31','2019/01/31','2019/02/28',
  '완료',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  86410, 16300, DEFAULT, 60760, 42000, 1850, 860,
  410, 27, 37, 12,DEFAULT, NULL,'110-23-0310818'
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','전로하','2019/01/01',
'2018/12/01','2018/12/31','2018/12/31','2018/12/31','2019/01/31',
  '완료',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  86410, 16300, DEFAULT, 60760, 42000, 1850, 860,
  410, 27, 37, 12,DEFAULT, NULL,'110-23-0310818'
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','전로하','2018/12/01',
'2018/11/01','2018/11/30','2018/11/30','2018/11/30','2018/12/31',
  '완료',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  86410, 16300, DEFAULT, 23547, 15034, 1850, 860,
  410, 27, 17, 5,DEFAULT, NULL,'110-23-0310818'
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','전로하','2018/11/01',
'2018/10/01','2018/10/31','2018/10/31','2018/10/31','2018/11/30',
  '완료',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  86410, 16300, DEFAULT, 15300, 12000, 1850, 860,
  410, 27, 12, 10,DEFAULT, NULL,'110-23-0310818'
);


INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','전로하','2018/10/01',
'2018/09/01','2018/09/30','2018/09/30','2018/09/30','2018/10/31',
  '완료',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  52770, 20850, DEFAULT, 4470, 6090, 1850, 860,
  386, 15, 12, 4,DEFAULT, NULL,'110-23-0310818'
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','전로하','2018/09/01',
'2018/08/01','2018/08/31','2018/08/31','2018/08/31','2018/09/30',
  '완료',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  52770, 20850, DEFAULT, 4470, 6090, 1850, 860,
  386, 15, 12, 4,DEFAULT, NULL,'110-23-0310818'
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'202-101','허용순','2018/11/01',
'2018/10/01','2018/10/31','2018/10/31','2018/10/31','2018/11/30',
  '완료',1,'Y',
 29290, 29310, 19110, 1080, 4660, 2950, 2420, 1200,
  86410, 16300, DEFAULT, 15300, 12000, 1850, 860,
  410, 27, 12, 10,DEFAULT, NULL,'110-23-0310818'
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'202-101','허용순','2018/10/01',
'2018/09/01','2018/09/30','2018/09/30','2018/09/30','2018/10/31',
  '완료',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  52770, 20850, DEFAULT, 4470, 6090, 1850, 860,
  386, 15, 12, 4,DEFAULT, NULL,'110-23-0310818'
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'202-101','허용순','2018/09/01',
'2018/08/01','2018/08/31','2018/08/31','2018/08/31','2018/09/30',
  '완료',1,'Y',
  29290, 29310, 19110, 1080, 4660, 2950, 2420, 1200,
  52770, 20850, DEFAULT, 4470, 6090, 1850, 860,
  386, 15, 12, 4,DEFAULT, NULL,'110-23-0310818'
);

--================================================================================

DROP TABLE VBANK cascade constraints;
-- 가상계좌 테이블 생성
CREATE TABLE VBANK (
	VBANK_NUM	VARCHAR2(20) NOT NULL,
	VBANK_NAME VARCHAR2(20) NOT NULL,
	VBANK_HOLDER VARCHAR2(15) DEFAULT '하이아파트'	NOT NULL,
	VBANK_DATE DATE NULL,
  CONSTRAINT PK_VB PRIMARY KEY(VBANK_NUM)
);

-- COMMENT 삽입
COMMENT ON COLUMN vbank.vbank_num IS '계좌번호';
COMMENT ON COLUMN vbank.vbank_name IS '은행명';
COMMENT ON COLUMN VBANK.VBANK_HOLDER IS '예금주';
COMMENT ON COLUMN VBANK.VBANK_DATE IS '입금기한';

-- vbank insert

INSERT INTO VBANK VALUES(
'110-23-0310818', '신한은행', DEFAULT, '19/09/30'
);

INSERT INTO VBANK VALUES(
'763201-01-148210', '국민은행', DEFAULT, '19/09/30'
);

INSERT INTO VBANK VALUES(
'175320-51-018603', '하나은행', DEFAULT, '19/09/30'
);

INSERT INTO VBANK VALUES(
'402172-01-001467', '우체국', DEFAULT, '19/09/30'
);

---=============================================================================
-- SMS 테이블 생성

drop table sms cascade constraints;

CREATE TABLE SMS (
	EMPNO	VARCHAR2(20) NOT NULL,
	TEL	VARCHAR2(12)	DEFAULT '02-751-1114'	NOT NULL,
	userphone	VARCHAR2(20)		NOT NULL,
	TEXT	VARCHAR2(80)		NULL,
	TYPE	VARCHAR2(10)	DEFAULT 'SMS'	NULL,
	STATE_MESSAGE	VARCHAR2(10)		NULL,
	COUNTRY	VARCHAR2(5)	DEFAULT '82'	NOT NULL,
	STATUS_CODE	VARCHAR2(5)		NOT NULL,
  CONSTRAINT FK_EMPLOYEE FOREIGN KEY(EMPNO) REFERENCES EMPLOYEE(EMPNO) ON DELETE CASCADE
);

COMMENT ON COLUMN SMS.EMPNO IS '사번';
COMMENT ON COLUMN SMS.TEL IS '관리소대표번호';
COMMENT ON COLUMN SMS.userphone IS '발신자번호';
COMMENT ON COLUMN SMS.text IS '메세지';
COMMENT ON COLUMN SMS.type IS '메세지타입';
COMMENT ON COLUMN SMS.state_message IS '접수상태';
COMMENT ON COLUMN SMS.COUNTRY IS '국가번호';
COMMENT ON COLUMN SMS.status_code IS '접수코드';

-- insert sms
INSERT INTO SMS VALUES(
 'S001', DEFAULT, '010-6547-3214', 
 '2019년08월분 관리비고지서입니다.',
 DEFAULT, '성공', DEFAULT, '2000' 
);

INSERT INTO SMS VALUES(
 'S001', DEFAULT, '010-6547-3214', 
 '2019년07월분 관리비고지서입니다.',
 DEFAULT, '성공', DEFAULT, '2000' 
);

INSERT INTO SMS VALUES(
 'S001', DEFAULT, '010-6547-3214', 
 '2019년06월분 관리비고지서입니다.',
 DEFAULT, '성공', DEFAULT, '2000' 
);

INSERT INTO SMS VALUES(
 'S001', DEFAULT, '010-6547-3214', 
 '2019년05월분 관리비고지서입니다.',
 DEFAULT, '성공', DEFAULT, '2000' 
);

INSERT INTO SMS VALUES(
 'S001', DEFAULT, '010-6547-3214', 
 '2019년04월분 관리비고지서입니다.',
 DEFAULT, '성공', DEFAULT, '2000' 
);

--============================================================================
-- PAYMENT 테이블 생성

drop table payment cascade constraints;

CREATE TABLE PAYMENT (
	MERCHANT_UID	NUMBER		NOT NULL,
	name	VARCHAR2(20)	DEFAULT '관리비고지서'	NOT NULL,
	AMOUNT	NUMBER		NOT NULL,
	currency	VARCHAR2(10)	DEFAULT 'KRW'	NOT NULL,
	PG	VARCHAR2(30)		NOT NULL,
	pay_method	VARCHAR2(50)	DEFAULT 'card'	NOT NULL,
	card_quota	NUMBER		NULL,
	buyer_name	VARCHAR2(20)		NULL,
	BUYER_TEL	VARCHAR2(20)		NOT NULL,
	BUYER_EMAIL	VARCHAR2(50)		NULL
);

-- comment
COMMENT ON COLUMN payment.merchant_uid IS '고유고지서번호';
COMMENT ON COLUMN payment.name IS '고지서명';
COMMENT ON COLUMN payment.amount IS '결제금액';
COMMENT ON COLUMN payment.currency IS '화폐단위';
COMMENT ON COLUMN payment.pg IS 'PG';
COMMENT ON COLUMN payment.pay_method IS '결제수단';
COMMENT ON COLUMN payment.card_quota IS '할부금액';
COMMENT ON COLUMN payment.buyer_name IS '결제자이름';
COMMENT ON COLUMN PAYMENT.BUYER_TEL IS '결제자연락처';
COMMENT ON COLUMN payment.buyer_email IS '결제자이메일';

-- INSERT PAYMENT

INSERT INTO PAYMENT VALUES(
'10000000000001', DEFAULT, 152560, DEFAULT, 'PG', '가상계좌',
NULL, '전로하', '010-8001-6812', 'dd55555bb@gmail.com'
);

INSERT INTO PAYMENT VALUES(
'10000000000002', DEFAULT, 141490, DEFAULT, '카카오페이', '간편결제',
NULL, '전로하', '010-8001-6812', 'dd55555bb@gmail.com'
);

INSERT INTO PAYMENT VALUES(
'10000000000003', DEFAULT, 168060, DEFAULT, '나이스정보통신', '가상계좌',
NULL, '허용순', '010-2685-4111', 'horse4797@naver.com'
);

INSERT INTO PAYMENT VALUES(
'10000000000004', DEFAULT, 151930, DEFAULT, '이니시스', '카드결제',
NULL, '전로하', '010-8001-6812', 'dd55555bb@gmail.com'
);

INSERT INTO PAYMENT VALUES(
'10000000000005', DEFAULT, 152560, DEFAULT, '나이스정보통신', '카드결제',
NULL, '전로하', '010-8001-6812', 'dd55555bb@gmail.com'
);

INSERT INTO PAYMENT VALUES(
'10000000000006', DEFAULT, 152560, DEFAULT, 'PAYCO', '간편결제',
NULL, '전로하', '010-8001-6812', 'dd55555bb@gmail.com'
);

INSERT INTO PAYMENT VALUES(
'10000000000007', DEFAULT, 185340, DEFAULT, 'PAYCO', '간편결제',
NULL, '전로하', '010-8001-6812', 'dd55555bb@gmail.com'
);

INSERT INTO PAYMENT VALUES(
'10000000000008', DEFAULT, 196660, DEFAULT, 'LGU+', '카드수기결제',
NULL, '전로하', '010-8001-6812', 'dd55555bb@gmail.com'
);

INSERT INTO PAYMENT VALUES(
'10000000000009', DEFAULT, 270690, DEFAULT, '나이스정보통신', '카드결제',
NULL, '전로하', '010-8001-6812', 'dd55555bb@gmail.com'
);

INSERT INTO PAYMENT VALUES(
'10000000000010', DEFAULT, 270690, DEFAULT, 'PG', '가상계좌',
NULL, '전로하', '010-8001-6812', 'dd55555bb@gmail.com'
);

INSERT INTO PAYMENT VALUES(
'10000000000011', DEFAULT, 206511, DEFAULT, '나이스정보통신', '카드결제',
NULL, '전로하', '010-8001-6812', 'dd55555bb@gmail.com'
);

INSERT INTO PAYMENT VALUES(
'10000000000012', DEFAULT, 195230, DEFAULT, '다날', '실시간계좌이체',
NULL, '전로하', '010-8001-6812', 'dd55555bb@gmail.com'
);

INSERT INTO PAYMENT VALUES(
'10000000000013', DEFAULT, 149400, DEFAULT, 'LGU+', '카드결제',
NULL, '전로하', '010-8001-6812', 'dd55555bb@gmail.com'
);

INSERT INTO PAYMENT VALUES(
'10000000000014', DEFAULT, 149400, DEFAULT, 'KCP', '카드결제',
NULL, '전로하', '010-8001-6812', 'dd55555bb@gmail.com'
);

INSERT INTO PAYMENT VALUES(
'10000000000015', DEFAULT, 222740, DEFAULT, '카카오페이', '간편결제',
NULL, '전로하', '010-8001-6812', 'dd55555bb@gmail.com'
);

--=============================================================================
drop table receipt cascade constraints;
-- RECEIPT 테이블 생성
CREATE TABLE RECEIPT (
	imp_uid	VARCHAR2(40)		NOT NULL,
  MERCHANT_UID NUMBER		NOT NULL,
	apply_num	VARCHAR2(40)		NULL,
	VBANK_NUM	VARCHAR2(20)		NULL,
	NAME	VARCHAR2(20)	DEFAULT '관리비고지서'	NOT NULL,
	pay_method	VARCHAR2(30)	DEFAULT 'card'	NOT NULL,
	PAID_AMOUNT	NUMBER		NOT NULL,
	PG_PROVIDER	VARCHAR2(40)		NOT NULL,
	pai_date	DATE		NOT NULL,
	receipt_url	VARCHAR2(100)		NULL,
	buyer_name	VARCHAR2(20)		NULL,
	buyer_tel	VARCHAR2(20)		NOT NULL,
	BUYER_EMAIL	VARCHAR2(30)		NULL,
	company	VARCHAR2(15)	DEFAULT '하이아파트'	NOT NULL,
	STATUS	VARCHAR2(20)		NOT NULL,	
  CONSTRAINT PK_RECEIPT PRIMARY KEY(IMP_UID)
);

--COMMIT
COMMENT ON COLUMN receipt.imp_uid IS '고유영수증ID';
COMMENT ON COLUMN receipt.apply_num IS '카드승인번호';
COMMENT ON COLUMN receipt.vbank_num IS '가상계죄입금번호';
COMMENT ON COLUMN receipt.name IS '고지서명';
COMMENT ON COLUMN receipt.pay_method IS '결제수단';
COMMENT ON COLUMN receipt.paid_amount IS '결제금액';
COMMENT ON COLUMN RECEIPT.PG_PROVIDER IS '결제PG종류';
COMMENT ON COLUMN receipt.pai_dat IS '결제승인시각';
COMMENT ON COLUMN receipt.receipt_url IS '매출전표URL';
COMMENT ON COLUMN receipt.buyer_name IS '결제자이름';
COMMENT ON COLUMN receipt.buyer_tel IS '결제자전화번호';
COMMENT ON COLUMN receipt.buyer_email IS '결제자이메일';
COMMENT ON COLUMN receipt.company IS '아파트명';
COMMENT ON COLUMN RECEIPT.STATUS IS '결제상태';
COMMENT ON COLUMN receipt.merchant_uid IS '고유고지서번호';

-- INSERT

INSERT INTO RECEIPT VALUES(
'5d8b920eb1b56e000675bc59', 10000000000015, NULL, NULL, 	
DEFAULT, '간편결제', 222740, '카카오페이', '2018/11/10',	NULL, '전로하', '010-8001-6812',
'dd55555bb@gmail.com', DEFAULT, '결제완료' 
);

INSERT INTO RECEIPT VALUES(
'5d8b920eb1b56e000675bc57', 10000000000014, '5d8b920eb1b56e000675bc59', NULL, 	
DEFAULT, '카드결제', 149400, 'KCP', '2018/09/11',	NULL, '전로하', '010-8001-6812',
'dd55555bb@gmail.com', DEFAULT, '결제완료' 
);

INSERT INTO RECEIPT VALUES(
'5d8b904eb1b56e000675bbbd', 10000000000013, '5d8b920eb1b56e000675bc59', NULL, 	
DEFAULT, '카드결제', 149400, 'LGU+', '2018/10/05',	NULL, '전로하', '010-8001-6812',
'dd55555bb@gmail.com', DEFAULT, '결제완료' 
);

INSERT INTO RECEIPT VALUES(
'5d8b95aeb1b56e000675bd6d', 10000000000012, NULL, '110-23-0310818', 	
DEFAULT, '실시간계좌이체', 195230, '다날', '2018/11/23',	NULL, '전로하', '010-1234-2222',
'dd55555bb@gmail.com', DEFAULT, '결제완료' 
);

INSERT INTO RECEIPT VALUES(
'5d8b8a28b1b56e000675ba80', 10000000000011, '5d8b8a28b1b56e000675ba80', NULL, 	
DEFAULT, '카드결제', 206511, '나이스정보통신', '2018/12/23',	NULL, '전로하', '010-1234-2222',
'dd55555bb@gmail.com', DEFAULT, '결제완료' 
);

INSERT INTO RECEIPT VALUES(
'5d95c71bb1b56e00068008de', 10000000000010, NULL, '110-23-0310818',	
DEFAULT, '가상계좌', 270690, 'PG', '2019/01/23',	NULL, '전로하', '010-1234-2222',
'dd55555bb@gmail.com', DEFAULT, '결제완료' 
);

INSERT INTO RECEIPT VALUES(
'5d95c599b1b56e00068006b9', 10000000000001, NULL, '110-23-0310818',	
DEFAULT, '가상계좌', 152560, 'PG', '2019/09/23',	NULL, '전로하', '010-1234-2222',
'dd55555bb@gmail.com', DEFAULT, '결제완료' 
);

INSERT INTO RECEIPT VALUES(
'5d95c4e8b1b56e0006800558', 10000000000002, NULL, NULL, 	
DEFAULT, '간편결제', 141490, '카카오페이', '2019/08/10',	NULL, '전로하', '010-8001-6812',
'dd55555bb@gmail.com', DEFAULT, '결제완료' 
);

INSERT INTO RECEIPT VALUES(
'5d95c6e1b1b56e0006800871', 10000000000003, NULL,'110-23-0310818',	
DEFAULT, '가상계좌', 168060, '나이스정보통신', '2019/08/10',	NULL, '허용순', '010-2685-4111', 'horse4797@naver.com', DEFAULT, '결제완료' 
);

INSERT INTO RECEIPT VALUES(
'5d95c4e8b1b56e000680055f', 10000000000004, '5d95c4e8b1b56e000680055f', NULL, 	
DEFAULT, '카드결제', 151930, '이니시스', '2019/07/23',	NULL, '전로하', '010-1234-2222',
'dd55555bb@gmail.com', DEFAULT, '결제완료' 
);

INSERT INTO RECEIPT VALUES(
'5d95c5f4b1b56e0006800720', 10000000000005, '5d95c5f4b1b56e0006800720', NULL, 	
DEFAULT, '카드결제', 152560, '나이스정보통신', '2019/06/06',	NULL, '전로하', '010-1234-2222',
'dd55555bb@gmail.com', DEFAULT, '결제완료' 
);

INSERT INTO RECEIPT VALUES(
'5d95c533b1b56e00068005de', 10000000000006, NULL, NULL, 	
DEFAULT, '간편결제', 152560, 'PAYCO', '2019/05/10',	NULL, '전로하', '010-8001-6812',
'dd55555bb@gmail.com', DEFAULT, '결제완료' 
);

INSERT INTO RECEIPT VALUES(
'5d95c484b1b56e00068004b8', 10000000000007, NULL, NULL, 	
DEFAULT, '간편결제', 185340, 'PAYCO', '2019/04/10',	NULL, '전로하', '010-8001-6812',
'dd55555bb@gmail.com', DEFAULT, '결제취소' 
);

INSERT INTO RECEIPT VALUES(
'5d95c2b3b1b56e00068001d9', 10000000000008, NULL, NULL, 	
DEFAULT, '카드수기결제', 196660, 'LGU+', '2019/03/07',	NULL, '전로하', '010-8001-6812',
'dd55555bb@gmail.com', DEFAULT, '결제완료' 
);

INSERT INTO RECEIPT VALUES(
'5d95c074b1b56e00067ffe79', 10000000000009, NULL, NULL, 	
DEFAULT, '카드결제', 270690, '나이스정보통신', '2019/02/10',	NULL, '전로하', '010-8001-6812',
'dd55555bb@gmail.com', DEFAULT, '결제취소' 
);

---============================================================================
-- 결제 내역 출력용 view 쿼리
DROP VIEW RECEIPT_VIEW;

CREATE VIEW receipt_view
AS
SELECT A.USERID, A.USERNAME, L.BILL_YEAR_MONTH, R.PAID_AMOUNT
FROM APTUSER A, BILL L, RECEIPT R
WHERE A.USERID = L.USERID AND L.MERCHANT_UID = R.MERCHANT_UID
with read only;

-------------------------------
DROP VIEW BASE_VIEW;
-- 부과기초작업 테이블
CREATE VIEW BASE_VIEW
AS
SELECT MERCHANT_UID, IMPOSE_STATUS, BILL_YEAR_MONTH, 
CALCULATE_START_DAY, CALCULATE_END_DAY, IMPOSE_END_DATE,
ACCEPT_DATE, CUTOFF_DATE, IMPOSE_COUNT 
FROM BILL
WITH CHECK OPTION;

INSERT INTO BASE_VIEW VALUES(
BILL_SEQ.NEXTVAL,'진행', '2019/11/01',
'2019/10/01','2019/10/30','2019/10/30',
'2019/10/30','2019/10/30',1  
);

---------------------------------
DROP VIEW IMPOSE_VIEW;
-- 관리비부과처리 뷰 테이블
CREATE VIEW impose_VIEW
AS
SELECT MERCHANT_UID, userid, GENERAL_COST,
      guard_cost,	clean_cost	,	DISINFECT_COST,
      ELEVATOR_COST,	REPAIR_COST,	commission,	FIREINSURANCE_COST,	
      ELECTRIC_COST,		TV_COST,  WATER_COST,	HEATING_COST,	HWATER_COST,	  
      ALLELECTRIC_COAT,	ALLWATER_COST,
      ELECTRIC_USAGE,	water_usage, HEATING_USAGE,  HWATER_USAGE
FROM BILL
WITH CHECK OPTION;

-----------------------------------
DROP VIEW IMPOSE_END_VIEW;

-- 부과마감등록 샘플 뷰 테이블
CREATE VIEW impose_end_VIEW
AS
SELECT MERCHANT_UID, USERID, 
        IMPOSE_STATUS, BILL_YEAR_MONTH, 
        CALCULATE_START_DAY, CALCULATE_END_DAY,
        IMPOSE_FINISH as "부과진행",
        CUTOFF_DATE, IMPOSE_END_DATE, IMPOSE_COUNT, accept_date
FROM BILL
WITH CHECK OPTION;

----------------------------------------
DROP VIEW BILL_VIEW;
-- 고지서 샘플 뷰 테이블
CREATE VIEW bill_VIEW
AS
SELECT MERCHANT_UID, USERID, 
       SUM(GENERAL_COST + CLEAN_COST +	DISINFECT_COST +
        ELEVATOR_COST +	REPAIR_COST + GUARD_COST + 	FIREINSURANCE_COST + 
        COMMISSION + ELECTRIC_COST +	ALLELECTRIC_COAT + TV_COST +
      HEATING_COST + 	HWATER_COST +	WATER_COST + ALLWATER_COST + ARREARS) AS "amount",
      ARREARS, 
      SUM(GENERAL_COST + CLEAN_COST +	DISINFECT_COST +
        ELEVATOR_COST +	REPAIR_COST + GUARD_COST + 	FIREINSURANCE_COST + 
        COMMISSION + ELECTRIC_COST +	ALLELECTRIC_COAT + TV_COST +
      HEATING_COST + 	HWATER_COST +	WATER_COST + ALLWATER_COST + ARREARS) AS "before_amount",
      floor((NVL(ARREARS,0)*1.3)) AS "arrears_fine",
      floor((SUM(GENERAL_COST + CLEAN_COST +	DISINFECT_COST +
        ELEVATOR_COST +	REPAIR_COST + GUARD_COST + 	FIREINSURANCE_COST + 
        COMMISSION + ELECTRIC_COST +	ALLELECTRIC_COAT + TV_COST +
      HEATING_COST + 	HWATER_COST +	WATER_COST + ALLWATER_COST + ARREARS))*1.1) AS "after_amount"      
FROM BILL
GROUP BY MERCHANT_UID, USERID, ARREARS
with read only;

--Create Table payment_end();

-- 수납처리 테이블 만들기 receiptf
--userId : String

-- merchantUid : long

-- billYearMonth : Date

-- amout : int

-- arrears : int

-- paidAmount : int

-- -status : String

-- payMethod : String

-- constranits 조건 생성 시작 ==========================================================================
ALTER TABLE bill ADD CONSTRAINT FK_vbank_TO_bill_1 FOREIGN KEY (	vbank_num)
REFERENCES vbank (	vbank_num);

ALTER TABLE payment ADD CONSTRAINT PK_PAYMENT PRIMARY KEY (	merchant_uid);

ALTER TABLE PAYMENT ADD CONSTRAINT FK_BILL_TO_PAYMENT_1 FOREIGN KEY (	MERCHANT_UID)
REFERENCES bill (	merchant_uid) on delete cascade;;

ALTER TABLE RECEIPT ADD CONSTRAINT FK_PAYMENT_TO_RECEIPT_1 FOREIGN KEY (	MERCHANT_UID)
REFERENCES payment (	merchant_uid) on delete cascade;

-- constranits 조건 생성 끝 ====================================================


COMMIT;
--  관리비 및 결제  db 끝*********************************************************




--김은솔-----------------------------------------------------------------------------------------------------------

DROP TABLE APPROVAL;
DROP TABLE DRAFT;
DROP TABLE FORMBOX;
DROP TABLE MYBOX; 


DROP SEQUENCE FORMCODE_SEQ;
DROP SEQUENCE DOCNO_SEQ;
DROP SEQUENCE TEMPDOCNO_SEQ;

-- 양식함 코드 시퀀스
CREATE SEQUENCE FORMCODE_SEQ
START WITH 100
INCREMENT BY 10
NOMAXVALUE
MINVALUE 100
NOCYCLE
NOCACHE;


-- 문서번호 시퀀스
CREATE SEQUENCE DOCNO_SEQ
START WITH 1
INCREMENT BY 1
NOMAXVALUE
MINVALUE 1
NOCYCLE
NOCACHE;

-- 임시보관문서번호 시퀀스
CREATE SEQUENCE TEMPDOCNO_SEQ
START WITH 1
INCREMENT BY 1
NOMAXVALUE
MINVALUE 1
NOCYCLE
NOCACHE;


-- 전자결재 양식함 테이블 
CREATE TABLE FORMBOX  (
 FORMCODE NUMBER	NOT NULL,
 FORMTYPE VARCHAR2(100)	NOT NULL,
 FORMNAME VARCHAR2(100)	NOT NULL,
 FORMCONTENT VARCHAR2(1000)	NOT NULL,

 CONSTRAINT FORMBOX_PK PRIMARY KEY (FORMCODE)
);

COMMENT ON COLUMN FORMBOX.FORMCODE IS '문서양식코드';
COMMENT ON COLUMN FORMBOX.FORMTYPE IS '문서양식분류';
COMMENT ON COLUMN FORMBOX.FORMNAME IS '문서양식명';
COMMENT ON COLUMN FORMBOX.FORMCONTENT IS '문서양식내용';

-- 전자결재 테이블 - 내문서함
CREATE TABLE MYBOX  (
 MYBOXCODE CHAR(1)	NOT NULL,
 EMPNO VARCHAR2(20)	NOT NULL,
 MYBOXNAME VARCHAR2(30)	NOT NULL,
 
 CONSTRAINT MEMPNO_FK FOREIGN KEY (EMPNO) REFERENCES EMPLOYEE ON DELETE CASCADE,
 CONSTRAINT MYBOX_PK PRIMARY KEY (MYBOXCODE, EMPNO)

);

COMMENT ON COLUMN MYBOX.MYBOXCODE IS '내문서함코드';
COMMENT ON COLUMN MYBOX.EMPNO IS '사번';
COMMENT ON COLUMN MYBOX.MYBOXNAME IS '내문서함명';

-- 전자결재 기안 테이블 
CREATE TABLE DRAFT  (
 DOCNO NUMBER,
 EMPNO VARCHAR2(20)	 NOT NULL,
 FORMCODE NUMBER	NOT NULL,
 DOCTITLE VARCHAR2(150)	NOT NULL,
 DOCCONTENT VARCHAR2(4000)	NOT NULL,
 ORIGINFILE VARCHAR2(100)	NULL,
 RENAMEFILE VARCHAR2(100)	NULL,
 DRAFTDATE DATE	DEFAULT SYSDATE	NOT NULL,
 PROGRESS CHAR(1)	DEFAULT 0	NOT NULL,
 DISPLAY CHAR(1) NOT NULL,
 MYBOXCODE CHAR(1)	NULL,

CONSTRAINT DRAFT_PK PRIMARY KEY (DOCNO),
CONSTRAINT DEMPNO_FK FOREIGN KEY (EMPNO) REFERENCES EMPLOYEE ON DELETE CASCADE,
CONSTRAINT FORMCODE_FK FOREIGN KEY (FORMCODE) REFERENCES FORMBOX ON DELETE CASCADE,
CONSTRAINT MYBOXCODE_FK FOREIGN KEY (MYBOXCODE, EMPNO) REFERENCES MYBOX ON DELETE SET NULL
);

COMMENT ON COLUMN DRAFT.DOCNO IS '문서번호';
COMMENT ON COLUMN DRAFT.EMPNO IS '사번';
COMMENT ON COLUMN DRAFT.FORMCODE IS '문서양식코드';
COMMENT ON COLUMN DRAFT.DOCTITLE IS '문서제목';
COMMENT ON COLUMN DRAFT.DOCCONTENT IS '문서내용';
COMMENT ON COLUMN DRAFT.ORIGINFILE IS '원래파일명';
COMMENT ON COLUMN DRAFT.RENAMEFILE IS '변경된파일명';
COMMENT ON COLUMN DRAFT.DRAFTDATE IS '문서작성날짜';
COMMENT ON COLUMN DRAFT.PROGRESS IS '문서진행상태';
COMMENT ON COLUMN DRAFT.DISPLAY IS '공개여부';
COMMENT ON COLUMN DRAFT.MYBOXCODE IS '내문서함코드';


-- 전자결재 테이블 - 결재완료
CREATE TABLE APPROVAL  (
 DOCNO NUMBER	NOT NULL REFERENCES DRAFT,
 EMPNO VARCHAR2(20)	NOT NULL REFERENCES EMPLOYEE,
 APPDATE DATE DEFAULT SYSDATE NOT NULL,
 FEEDBACK VARCHAR2(2000)	NULL,
 SIGNIMG VARCHAR2(100)	NOT NULL,
 
 CONSTRAINT ADOCNO_FK FOREIGN KEY (DOCNO) REFERENCES  DRAFT ON DELETE CASCADE,
 CONSTRAINT APPROVAL_PK PRIMARY KEY (DOCNO),
 CONSTRAINT AEMPNO_FK FOREIGN KEY (EMPNO) REFERENCES EMPLOYEE ON DELETE CASCADE 
);

COMMENT ON COLUMN APPROVAL.DOCNO IS '문서번호';
COMMENT ON COLUMN APPROVAL.EMPNO IS '사번';
COMMENT ON COLUMN APPROVAL.APPDATE IS '결재일';
COMMENT ON COLUMN APPROVAL.FEEDBACK IS '첨삭및의견';
COMMENT ON COLUMN APPROVAL.SIGNIMG IS '서명파일명';


INSERT INTO FORMBOX VALUES (FORMCODE_SEQ.NEXTVAL, '기안서 양식 1', '일반 기안서', '공용');
INSERT INTO FORMBOX VALUES (FORMCODE_SEQ.NEXTVAL, '기안서 양식 2', '휴가 신청서', '공용');
INSERT INTO FORMBOX VALUES (FORMCODE_SEQ.NEXTVAL, '기안서 양식 3', '기타1', '공용');
INSERT INTO FORMBOX VALUES (FORMCODE_SEQ.NEXTVAL, '기안서 양식 4', '기타2', '공용');
INSERT INTO FORMBOX VALUES (FORMCODE_SEQ.NEXTVAL, '기안서 양식 5', '기타3', '공용');
INSERT INTO FORMBOX VALUES (FORMCODE_SEQ.NEXTVAL, '기안서 양식 6', '기타4', '공용');
INSERT INTO FORMBOX VALUES (FORMCODE_SEQ.NEXTVAL, '기안서 양식 7', '기타5', '공용');
INSERT INTO FORMBOX VALUES (FORMCODE_SEQ.NEXTVAL, '기안서 양식 8', '직원 업무일지', '업무일지');
INSERT INTO FORMBOX VALUES (FORMCODE_SEQ.NEXTVAL, '기안서 양식 9', '관리자 업무일지', '업무일지');



INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'S001', 
'100', 
'기안1', 
'기안내용1', 
NULL, 
NULL, 
SYSDATE, 
'3', 
'Y', 
NULL);

INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'A001', 
'110', 
'기안2', 
'기안내용2', 
NULL, 
NULL, 
SYSDATE, 
'0', 
'Y', 
NULL);

INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'S001', 
'100', 
'기안3', 
'기안내용3', 
NULL, 
NULL, 
SYSDATE, 
'1', 
'Y', 
NULL);


INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'F001', 
'170', 
'기안4', 
'기안내용4', 
NULL, 
NULL, 
SYSDATE, 
'1', 
'N', 
NULL);


INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'R001', 
'110', 
'기안5', 
'기안내용5', 
NULL, 
NULL, 
SYSDATE, 
'2', 
'Y', 
NULL);


INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'A001', 
'100', 
'기안6', 
'기안내용6', 
NULL, 
NULL, 
SYSDATE, 
'1', 
'N', 
NULL);

INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'A001', 
'110', 
'기안7', 
'기안내용7', 
NULL, 
NULL, 
SYSDATE, 
'1', 
'N', 
NULL);

INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'R001', 
'170', 
'기안8', 
'기안내용8', 
NULL, 
NULL, 
SYSDATE, 
'1', 
'N', 
NULL);

INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'S001', 
'170', 
'기안9', 
'기안내용9', 
NULL, 
NULL, 
SYSDATE, 
'0', 
'N', 
NULL);


INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'F001', 
'120', 
'기안10', 
'기안내용10', 
NULL, 
NULL, 
SYSDATE, 
'0', 
'N', 
NULL);

COMMIT;
--이영수 -------------------------------------------------------------
--공지사항
DROP SEQUENCE NOTICE_SEQ;
CREATE SEQUENCE  "HIAPT"."NOTICE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

DROP TABLE NOTICE CASCADE CONSTRAINTS;

CREATE TABLE NOTICE (
	NOTICE_NO	NUMBER CONSTRAINT PK_NOTICE PRIMARY KEY,
	NOTICE_TITLE	VARCHAR2(100) NOT NULL,
	NOTICE_DATE DATE	DEFAULT SYSDATE,
	NOTICE_CONTENTS VARCHAR2(4000) NOT NULL,
	NOTICE_READ_COUNT NUMBER DEFAULT 0,
	NOTICE_WRITER 	VARCHAR2(20)	CONSTRAINT FK_NOTICE REFERENCES EMPLOYEE (EMPNO)
);

COMMENT ON COLUMN notice. notice_no IS '글번호';
COMMENT ON COLUMN notice.notice_title IS '제목';
COMMENT ON COLUMN notice.notice_date IS '작성일';
COMMENT ON COLUMN notice.notice_contents IS '내용';
COMMENT ON COLUMN notice.notice_read_count IS '조회수';
COMMENT ON COLUMN notice.notice_writer IS '작성자';

INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '공지사항입니다','18/09/20','삭제하지마세요',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '102동점검','18/10/10','완료',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '108동점검','19/1/01','완료',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '1단지 놀이터점검','19/02/16','완료',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '2단지 놀이터점검','19/03/12','완료',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '1단지 옥상점검','19/04/10','완료',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '1단지 옥상점검','19/05/11','완료',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '5단지 놀이터점검','19/06/04','완료',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '1단지 옥상점검','19/07/04','완료',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '1단지 옥상점검','19/08/04','이상',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '4단지 놀이터점검','19/09/05','이상',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '2단지 놀이터점검','19/10/03','완료',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '1단지 옥상점검','19/10/04','이상',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '1단지 놀이터점검',default,'이상',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '1단지 옥상점검',default,'완료',default,'admin');

--공지사항파일
DROP TABLE NOTICEFILES CASCADE CONSTRAINTS;

CREATE TABLE noticefiles (
	notice_no	number CONSTRAINT FK_NOTICEFILES REFERENCES NOTICE (NOTICE_NO),
	notice_original_file_name varchar2(100)	NOT NULL,
	notice_rename_file_name varchar2(100)	NOT NULL
);
-----------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------
--주민투표
DROP SEQUENCE VOTE_SEQ;
CREATE SEQUENCE  "HIAPT"."VOTE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

DROP TABLE USERVOTE CASCADE CONSTRAINTS;

CREATE TABLE uservote (
	vote_no	number CONSTRAINT PK_USERVOTE primary key,
	vote_title	varchar2(100)		NOT NULL,
  vote_writer	varchar2(20) CONSTRAINT fk_uservote references employee (empno),
	vote_date	date	 DEFAULT sysdate,
	vote_final_date	date	 DEFAULT sysdate,
  vote_read_count	number	DEFAULT 0,
	vote_secret char(1)	DEFAULT 'N'	 check (vote_secret in ('Y','N')),
  vote_contents	 varchar2(1000)		NOT NULL,
	voteone	varchar2(50),
	votetwo varchar2(50),
	votethree	varchar2(50),
	votefour	varchar2(50)	,
  votefive	varchar2(50)	
);

COMMENT ON COLUMN uservote.vote_no IS '글번호';
COMMENT ON COLUMN uservote.vote_title IS '제목';
COMMENT ON COLUMN uservote.vote_writer IS '작성자';
COMMENT ON COLUMN uservote.vote_date IS '작성날짜';
COMMENT ON COLUMN uservote.vote_final_date IS '투표종료일';
COMMENT ON COLUMN uservote.vote_read_count IS '조회수';
COMMENT ON COLUMN uservote.vote_secret IS '유기명여부';
COMMENT ON COLUMN uservote.vote_contents IS '내용';
COMMENT ON COLUMN uservote.voteone IS '투표1';
COMMENT ON COLUMN uservote.votetwo IS '투표2';
COMMENT ON COLUMN uservote.votethree IS '투표3';
COMMENT ON COLUMN uservote.votefour IS '투표4';
COMMENT ON COLUMN uservote.votefive IS '투표5';

--주민투표결과체크

DROP TABLE VOTERESULT CASCADE CONSTRAINTS;

CREATE TABLE VOTERESULT (
	vote_no	number constraint fk_voteresult references uservote (vote_no) ON DELETE CASCADE,
	voteone_result	number	DEFAULT 0,
	votetwo_result	number	DEFAULT 0,
	votethree_result	number	DEFAULT 0,
	votefour_result	number	DEFAULT 0,
	votefive_result number		DEFAULT 0
);
ALTER TABLE voteresult ADD CONSTRAINT PK_VOTERESULT PRIMARY KEY (
	vote_no
);
COMMENT ON COLUMN voteresult.vote_no IS '글번호';
COMMENT ON COLUMN voteresult.voteone_result IS '투표결과1';
COMMENT ON COLUMN voteresult.votetwo_result IS '투표결과2';
COMMENT ON COLUMN voteresult.votethree_result IS '투표결과3';
COMMENT ON COLUMN voteresult.votefour_result IS '투표결과4';
COMMENT ON COLUMN voteresult.votefive_result IS '투표결과5';


--주민투표중복체크

DROP TABLE VOTECHECK CASCADE CONSTRAINTS;
CREATE TABLE votecheck (
	userid VARCHAR2(10)	CONSTRAINT FK_VOTECHECK_USERID REFERENCES APTUSER (USERID),
	vote_no	number CONSTRAINT FK_VOTECHECK_VOTE_NO REFERENCES USERVOTE (VOTE_NO) ON DELETE CASCADE,
	vote_result 	varchar2(50)		NULL
);

COMMENT ON COLUMN votecheck.userid IS '동/호수';
COMMENT ON COLUMN votecheck.vote_no IS '글번호';
COMMENT ON COLUMN votecheck.vote_result IS '선택한투표값';

create or replace TRIGGER TRIGGER_voteresult 
AFTER INSERT ON USERVOTE
FOR EACH ROW
BEGIN
  INSERT INTO VOTERESULT
  VALUES (:NEW.VOTE_NO, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
END;
/

INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, '연습', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '연습','하나','둘','셋','넨','오');
INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, 'zz', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '연습','하나','둘','셋','넨','오');
INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, '33', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '연습','하나','둘','셋','넨','오');
INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, '44', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '연습','하나','둘','셋','넨','오');
INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, '55', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '연습','하나','둘','셋','넨','오');
INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, '66', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '연습','하나','둘','셋','넨','오');
INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, '77', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '연습','하나','둘','셋','넨','오');
INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, '88', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '연습','하나','둘','셋','넨','오');
INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, '99', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '연습','하나','둘','셋','넨','오');
INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, '1010', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '연습','하나','둘','셋','넨','오');
INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, '1111', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '연습','하나','둘','셋','넨','오');

-----------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------
--자유게시판

DROP SEQUENCE BOARD_SEQ;
CREATE SEQUENCE  "HIAPT"."BOARD_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;


DROP TABLE board CASCADE CONSTRAINTS;

CREATE TABLE board (
	boardno	number CONSTRAINT PK_BOARD PRIMARY KEY,
	boardtitle varchar2(100)		NOT NULL,
	boarddate date DEFAULT sysdate	NULL,
	boardcontents varchar2(4000)		NOT NULL,
	boardreadcount number DEFAULT 0,
	userid VARCHAR2(10) CONSTRAINT FK_BOARD REFERENCES APTUSER(USERID)
);

COMMENT ON COLUMN board.boardno IS '글번호';
COMMENT ON COLUMN board.boardtitle IS '제목';
COMMENT ON COLUMN board.boarddate IS '작성일';
COMMENT ON COLUMN board.boardcontents IS '내용';
COMMENT ON COLUMN board.boardreadcount IS '조회수';
COMMENT ON COLUMN board.userid IS '동/호수';


--자유게시판 댓글
DROP TABLE boardreply CASCADE CONSTRAINTS;

CREATE TABLE boardreply (
	board_no	number CONSTRAINT FK_BOARDNO_REPLY REFERENCES BOARD(BOARDNO),
	boardreply_original_no	number		NOT NULL,
	boardreply_group_no	number		NOT NULL,
	boardreply_group_order	number	DEFAULT 0	NULL,
	boardreply_group_layer	number	DEFAULT 0	NULL,
	boardreply_date	date	DEFAULT sysdate	NULL,
	boardreply_contents	varchar2(500)		NOT NULL,
	userid VARCHAR2(10) CONSTRAINT FK_BOARD_REPLY REFERENCES APTUSER(USERID)
);

COMMENT ON COLUMN boardreply.board_no IS '글번호';
COMMENT ON COLUMN boardreply.boardreply_original_no IS '댓글번호';
COMMENT ON COLUMN boardreply.boardreply_group_no IS '댓글그룹';
COMMENT ON COLUMN boardreply.boardreply_group_order IS '그룹내순서';
COMMENT ON COLUMN boardreply.boardreply_group_layer IS '계층별 댓글순위';
COMMENT ON COLUMN boardreply.boardreply_date IS '댓글작성시간';
COMMENT ON COLUMN boardreply.boardreply_contents IS '댓글내용';
COMMENT ON COLUMN boardreply.userid IS '동/호수';

--자유게시판 파일저장
DROP TABLE boardfiles CASCADE CONSTRAINTS;

CREATE TABLE boardfiles (
	boardno	number CONSTRAINT FK_BOARDFILES REFERENCES BOARD(BOARDNO),
	board_original_file_name VARCHAR(255)		NOT NULL,
	board_rename_file_name	VARCHAR(255)		NOT NULL
);

COMMENT ON COLUMN boardfiles.boardno IS '글번호';
COMMENT ON COLUMN boardfiles.board_original_file_name IS '원본파일이름';
COMMENT ON COLUMN boardfiles.board_rename_file_name IS '저장된파일이름';

-----------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------
--민원
DROP SEQUENCE COMPLAIN_SEQ;
CREATE SEQUENCE  "HIAPT"."COMPLAIN_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

DROP TABLE complain CASCADE CONSTRAINTS;

CREATE TABLE complain (
	comp_no	number	CONSTRAINT PK_COMPLAIN PRIMARY KEY,
	comp_title	varchar2(100)		NOT NULL,
	comp_date	date 	DEFAULT sysdate,
	comp_contents	varchar2(2000)		NOT NULL,
	comp_result_status 	char(1)	DEFAULT 'N' CHECK(comp_result_status IN ('Y','N')),
	comp_response	varchar2(2000)		NULL,
	empno	varchar2(20)		CONSTRAINT FK_COMP_EMPNO REFERENCES EMPLOYEE(EMPNO),
	userid	VARCHAR2(10)	CONSTRAINT FK_COMP_USERID REFERENCES APTUSER(USERID)
);

COMMENT ON COLUMN complain.comp_no IS '글번호';
COMMENT ON COLUMN complain.comp_title IS '제목';
COMMENT ON COLUMN complain.comp_date IS '작성일';
COMMENT ON COLUMN complain.comp_contents IS '내용';
COMMENT ON COLUMN complain.comp_result_status IS '처리상태';
COMMENT ON COLUMN complain.comp_response IS '답글';
COMMENT ON COLUMN complain.empno IS '사번';
COMMENT ON COLUMN complain.userid IS '동/호수';

DROP TABLE complainimg CASCADE CONSTRAINTS;

CREATE TABLE complainimg (
	comp_no	number CONSTRAINT FK_COMPIMG REFERENCES COMPLAIN(COMP_NO),
	comp_original_imgname	varchar2(100)		NOT NULL,
	comp_rename_imgname	varchar2(100)		NOT NULL
);

COMMENT ON COLUMN complainimg.comp_no IS '글번호';
COMMENT ON COLUMN complainimg.comp_original_imgname IS '원본이미지이름';
COMMENT ON COLUMN complainimg.comp_rename_imgname IS '저장된이미지이름';


-----------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------
--채팅

DROP TABLE chatmaker CASCADE CONSTRAINTS;

CREATE TABLE chatmaker (
	chattitle 	varchar2(50)	CONSTRAINT PK_CHATMAKER PRIMARY KEY,
	empno	varchar2(20)	 CONSTRAINT FK_CHATMAKER REFERENCES EMPLOYEE(EMPNO)
);

COMMENT ON COLUMN chatmaker.chattitle IS '방제목';
COMMENT ON COLUMN chatmaker.empno IS '사번';

DROP TABLE chatgroup CASCADE CONSTRAINTS;

CREATE TABLE chatgroup (
	chattitle	varchar2(50) REFERENCES CHATMAKER(CHATTITLE),
	empno	varchar2(20)	 REFERENCES EMPLOYEE(EMPNO)
);

ALTER TABLE chatgroup ADD CONSTRAINT PK_CHATGROUB PRIMARY KEY (
	chattitle,
	empno
);

COMMENT ON COLUMN chatgroup.chattitle IS '방제목';
COMMENT ON COLUMN chatgroup.empno IS '사번';

DROP TABLE chatmessage CASCADE CONSTRAINTS;

CREATE TABLE chatmessage (
	chatwritedate	date	DEFAULT sysdate,
	chatcontents	varchar2(500)	NOT NULL,
	chatorder	number	NOT NULL,
	chattitle	varchar2(50),
	empno	varchar2(20)	
);
ALTER TABLE chatmessage ADD CONSTRAINT FK_CHATMESSAGE FOREIGN KEY (
	chattitle,
	empno
) references chatgroup(	chattitle,
	empno);
COMMENT ON COLUMN chatmessage.chatwritedate IS '작성날짜';
COMMENT ON COLUMN chatmessage.chatcontents IS '작성내용';
COMMENT ON COLUMN chatmessage.chatorder IS '글순서';
COMMENT ON COLUMN chatmessage.chattitle IS '방제목';
COMMENT ON COLUMN chatmessage.empno IS '사번';

COMMIT;

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
