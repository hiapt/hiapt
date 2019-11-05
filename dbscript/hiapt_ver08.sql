
--홍승희 ----------------------------------------------------------------------
DROP TABLE aptuser cascade CONSTRAINTS;

CREATE TABLE aptuser (
   userid   VARCHAR2(10)      NOT NULL,
  userpwd varchar2(10) not null,
   username   VARCHAR2(20)      NOT NULL,
   userenroll   DATE,
   userbirth   DATE,
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
START WITH 10010
MAXVALUE 29999
NOCYCLE
NOCACHE
INCREMENT BY 1;

CREATE SEQUENCE SEQ_ACCOUNTANCY
START WITH 30010
MAXVALUE 49999
NOCYCLE
NOCACHE
INCREMENT BY 1;

CREATE SEQUENCE SEQ_FACILITY
START WITH 50010
MAXVALUE 69999
NOCYCLE
NOCACHE
INCREMENT BY 1;

CREATE SEQUENCE SEQ_READING
START WITH 70010
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
   empphone   varchar2(50)  UNIQUE    NOT NULL,
   empssn   varchar2(50)   UNIQUE   NOT NULL,
  empzipcode varchar2(10) NULL,
   empaddress   varchar2(100)  NULL,
   empemail   varchar2(50)   UNIQUE    NULL,
   empgender CHAR(1) NOT NULL,
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

COMMENT ON COLUMN employee.empgender IS '성별';

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


Insert into EMPLOYEE (EMPNO,EMPPWD,EMPNAME,EMPID,EMPHIREDATE,EMPPHONE,EMPSSN,EMPZIPCODE,EMPADDRESS,EMPEMAIL,EMPGENDER,EMPETC,SALARY,PENSION,INSURANCE,LONGINS,HIREINS,INCOMETAX,LOCALTAX,SALARYTOT,MINUSTOT,REALSALARY) values ('admin','admin','관리자','관리자',to_date('19/10/01','RR/MM/DD'),'010-1234-5678','921002-1234567',15540,'서울특별시 테헤란로126,dd,dd','abc@hiapt.com','M','관리자입니다.',9000000,405000,290700,765900,72000,0,0,9000000,1533600,7466400);

Insert into EMPLOYEE (EMPNO,EMPPWD,EMPNAME,EMPID,EMPHIREDATE,EMPPHONE,EMPSSN,EMPZIPCODE,EMPADDRESS,EMPEMAIL,EMPGENDER,EMPETC,SALARY,PENSION,INSURANCE,LONGINS,HIREINS,INCOMETAX,LOCALTAX,SALARYTOT,MINUSTOT,REALSALARY) values ('10001','10001','김보안','보안직원',to_date('19/10/01','RR/MM/DD'),'010-7410-8520','891115-9876543',15540,'서울특별시 구로구 54,d,d','qwrds@hiapt.com','M','보안직원입니다.',8500000,382500,274550,723350,68000,0,0,8500000,1448400,7051600);

Insert into EMPLOYEE (EMPNO,EMPPWD,EMPNAME,EMPID,EMPHIREDATE,EMPPHONE,EMPSSN,EMPZIPCODE,EMPADDRESS,EMPEMAIL,EMPGENDER,EMPETC,SALARY,PENSION,INSURANCE,LONGINS,HIREINS,INCOMETAX,LOCALTAX,SALARYTOT,MINUSTOT,REALSALARY) values ('30001','30001','이경리','경리',to_date('19/10/01','RR/MM/DD'),'010-9876-5432','900215-4567125',15540,'인천광역시 논현동 21,d,d','rudfl@hiapt.com','M','경리입니다.',8500000,382500,274550,723350,68000,0,0,8500000,1448400,7051600);
Insert into EMPLOYEE (EMPNO,EMPPWD,EMPNAME,EMPID,EMPHIREDATE,EMPPHONE,EMPSSN,EMPZIPCODE,EMPADDRESS,EMPEMAIL,EMPGENDER,EMPETC,SALARY,PENSION,INSURANCE,LONGINS,HIREINS,INCOMETAX,LOCALTAX,SALARYTOT,MINUSTOT,REALSALARY) values ('50001','50001','박설비','설비과장',to_date('19/10/01','RR/MM/DD'),'010-2145-5647','850319-7425632',15540,'경기도 수원시 96,dd,ggg','tjfql@hiapt.com','M','설비과장입니다.',8500000,382500,274550,723350,68000,0,0,8500000,1448400,7051600);

Insert into EMPLOYEE (EMPNO,EMPPWD,EMPNAME,EMPID,EMPHIREDATE,EMPPHONE,EMPSSN,EMPZIPCODE,EMPADDRESS,EMPEMAIL,EMPGENDER,EMPETC,SALARY,PENSION,INSURANCE,LONGINS,HIREINS,INCOMETAX,LOCALTAX,SALARYTOT,MINUSTOT,REALSALARY) values ('70001','70001','전검침','검침기사',to_date('19/10/01','RR/MM/DD'),'010-3658-7854','840522-2365897',15540,'경상북도 구미시 88,gg,gg','rjacla@hiapt.com','M','검침기사입니다.',8500000,0.045,0.323,0.04255,0.065,null,null,1,1,1);


---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE family cascade CONSTRAINTS;

CREATE TABLE family (
    empno   varchar2(20) NOT NULL,
   frelation   VARCHAR2(50) NULL,
   fname   VARCHAR2(20) NULL,
   fssn   VARCHAR2(50) NULL,
   fdisability CHAR(1) NULL,
   fdeduction CHAR(1) NULL,
   ftogether CHAR(1) NULL,
   ftax CHAR(1) NULL,
   fchild CHAR(1)  NULL,
  
  CONSTRAINT FEMPNO_FK FOREIGN KEY (EMPNO) REFERENCES EMPLOYEE ON DELETE CASCADE
);

COMMENT ON COLUMN family.empno IS '사번';

COMMENT ON COLUMN family.frelation IS '관계';

COMMENT ON COLUMN family.fname IS '부양가족명';

COMMENT ON COLUMN family.fssn IS '부양가족주민번호';

COMMENT ON COLUMN family.fdisability IS '장애여부';

COMMENT ON COLUMN family.fdeduction IS '인적공제';

COMMENT ON COLUMN family.ftogether IS '동거여부';

COMMENT ON COLUMN family.ftax IS '갑근세';

COMMENT ON COLUMN family.fchild IS '다자녀';

insert into family (empno, frelation, fname, fssn, fdisability, fdeduction, ftogether, ftax, fchild) values('admin', '', '', '','N','N','N','N','N');
insert into family (empno, frelation, fname, fssn, fdisability, fdeduction, ftogether, ftax, fchild) values('10001', '', '', '','N','N','N','N','N');
insert into family (empno, frelation, fname, fssn, fdisability, fdeduction, ftogether, ftax, fchild) values('30001', '', '', '','N','N','N','N','N');
insert into family (empno, frelation, fname, fssn, fdisability, fdeduction, ftogether, ftax, fchild) values('50001', '', '', '','N','N','N','N','N');
insert into family (empno, frelation, fname, fssn, fdisability, fdeduction, ftogether, ftax, fchild) values('70001', '', '', '','N','N','N','N','N');




commit;

--====================================================================================
-- 달력
----------------------------------------------------------------------------------------------------------------------------------------------------
drop table SCHEDULE;

CREATE TABLE SCHEDULE (
	SCH_NO  	NUMBER	CONSTRAINT SCH_PK PRIMARY KEY,
	SCH_TITLE	VARCHAR2(30)		NOT NULL,
	SCH_TYPE	VARCHAR2(10)	 DEFAULT '����' NOT NULL,
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
COMMENT ON COLUMN SCHEDULE.SCH_NO IS '������ȣ';

COMMENT ON COLUMN SCHEDULE.SCH_TITLE IS '������';

COMMENT ON COLUMN SCHEDULE.SCH_TYPE IS '����';

COMMENT ON COLUMN SCHEDULE.SCH_START IS '������';

COMMENT ON COLUMN SCHEDULE.SCH_END IS '������';

COMMENT ON COLUMN SCHEDULE.SCH_MEMO IS '�޸�';

COMMENT ON COLUMN SCHEDULE.SCH_OPEN IS '��������';

COMMENT ON COLUMN SCHEDULE.SCH_ALARM IS '�˶�����';

COMMENT ON COLUMN SCHEDULE.SCH_COLOR IS '����';

COMMENT ON COLUMN SCHEDULE.EMPNO IS '���';

COMMENT ON COLUMN SCHEDULE.IMPORTANCE IS '�߿䵵';

DROP SEQUENCE SCH_SEQ;

CREATE SEQUENCE SCH_SEQ
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCYCLE  
NOCACHE;


--��������
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '���ֹ�ȸ��', DEFAULT, TO_DATE(20191101), TO_DATE(20191101), '11�� 3��', 'Y', DEFAULT, '#D25565', DEFAULT, 'admin'); 
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '��ü����ȸ��', DEFAULT, TO_DATE(20191108), TO_DATE(20191108), '11�� 3��', 'Y', DEFAULT, '#D25565', DEFAULT, 'admin');
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '�����������', DEFAULT, TO_DATE(20191104), TO_DATE(20191104), '��������', DEFAULT, DEFAULT, '#D25565', DEFAULT, 'admin');
--�渮
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '��û�湮', DEFAULT, TO_DATE(20191105), TO_DATE(20191105), '��������', DEFAULT, DEFAULT, '#9775fa', DEFAULT, '30001'); 
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '��û��', DEFAULT, TO_DATE(2019115), TO_DATE(20191115), '4�ÿ�����', 'Y', DEFAULT, '#9775fa', DEFAULT, '30001'); 
--��ħ
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '101����ħ', DEFAULT, TO_DATE(20191107), TO_DATE(20191107), '101�� ��ħ����', 'Y', DEFAULT, '#ffa94d', DEFAULT, '70001'); 
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '������', DEFAULT, TO_DATE(20191114), TO_DATE(20191114), '��������', DEFAULT, DEFAULT, '#ffa94d', DEFAULT, '70001'); 
--����
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '2���� ����������', DEFAULT, TO_DATE(20191111), TO_DATE(20191111), '2���� ��������', 'Y', DEFAULT, '#74c0fc', DEFAULT, '50001');
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, 'ū�� ����', DEFAULT, TO_DATE(20191122), TO_DATE(20191122), '��������', DEFAULT, DEFAULT, '#74c0fc', DEFAULT, '50001');
--��������
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, 'CCTV����', DEFAULT, TO_DATE(20191112), TO_DATE(20191112), 'CCTV ����', 'Y', DEFAULT, '#f06595', DEFAULT, '10001'); 
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '���� ����', DEFAULT, TO_DATE(20191122), TO_DATE(20191122), '��������', DEFAULT, DEFAULT, '#f06595', DEFAULT, '10001'); 

commit;

-- 공지사항 추가

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


--관리소장
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '입주민회의', DEFAULT, TO_DATE(20191101), TO_DATE(20191101), '11시 3층', 'Y', DEFAULT, '#D25565', DEFAULT, 'admin'); 
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '업체선정회의', DEFAULT, TO_DATE(20191108), TO_DATE(20191108), '11시 3층', 'Y', DEFAULT, '#D25565', DEFAULT, 'admin');
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '관리소장모임', DEFAULT, TO_DATE(20191104), TO_DATE(20191104), '개인일정', DEFAULT, DEFAULT, '#D25565', DEFAULT, 'admin');
--경리
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '구청방문', DEFAULT, TO_DATE(20191105), TO_DATE(20191105), '개인일정', DEFAULT, DEFAULT, '#9775fa', DEFAULT, '30001'); 
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '대청소', DEFAULT, TO_DATE(20191105), TO_DATE(20191115), '4시에시작', 'Y', DEFAULT, '#9775fa', DEFAULT, '30001'); 
--검침
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '101동검침', DEFAULT, TO_DATE(20191107), TO_DATE(20191107), '101동 검침예정', 'Y', DEFAULT, '#ffa94d', DEFAULT, '70001'); 
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '저녁약속', DEFAULT, TO_DATE(20191114), TO_DATE(20191114), '개인일정', DEFAULT, DEFAULT, '#ffa94d', DEFAULT, '70001'); 
--설비
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '2단지 놀이터점검', DEFAULT, TO_DATE(20191111), TO_DATE(20191111), '2단지 설비점검', 'Y', DEFAULT, '#74c0fc', DEFAULT, '50001');
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '큰집 제사', DEFAULT, TO_DATE(20191122), TO_DATE(20191122), '개인일정', DEFAULT, DEFAULT, '#74c0fc', DEFAULT, '50001');
--보안직원
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, 'CCTV점검', DEFAULT, TO_DATE(20191112), TO_DATE(20191112), 'CCTV 점검', 'Y', DEFAULT, '#f06595', DEFAULT, '10001'); 
INSERT INTO SCHEDULE VALUES(SCH_SEQ.NEXTVAL, '적금 만기', DEFAULT, TO_DATE(20191122), TO_DATE(20191122), '개인일정', DEFAULT, DEFAULT, '#f06595', DEFAULT, '10001'); 

commit;
--공지사항
DROP SEQUENCE NOTICE_SEQ;
CREATE SEQUENCE  "HIAPT"."NOTICE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

DROP TABLE NOTICE CASCADE CONSTRAINTS;

CREATE TABLE NOTICE (
	NOTICE_NO	NUMBER CONSTRAINT PK_NOTICE PRIMARY KEY,
	NOTICE_TITLE	VARCHAR2(100) NOT NULL,
	NOTICE_DATE DATE	DEFAULT SYSDATE,
	NOTICE_READ_COUNT NUMBER DEFAULT 0,
	NOTICE_WRITER 	VARCHAR2(20)	CONSTRAINT FK_NOTICE REFERENCES EMPLOYEE (EMPNO),
  NOTICE_CONTENTS LONG NOT NULL
);

COMMENT ON COLUMN notice. notice_no IS '글번호';
COMMENT ON COLUMN notice.notice_title IS '제목';
COMMENT ON COLUMN notice.notice_date IS '작성일';
COMMENT ON COLUMN notice.notice_contents IS '내용';
COMMENT ON COLUMN notice.notice_read_count IS '조회수';
COMMENT ON COLUMN notice.notice_writer IS '작성자';

INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '공지사항 서비스 오픈', DEFAULT, DEFAULT,
'admin', '안녕하세요. 하이아파트 관리소장입니다. <br> 앞으로 세대주민에게 안내드릴 사항은 해당 게시판을 통해 안내드리겠습니다. <br> 감사합니다. ');

--공지사항파일
DROP TABLE NOTICEFILES CASCADE CONSTRAINTS;

CREATE TABLE noticefiles (
	notice_no	number CONSTRAINT FK_NOTICEFILES REFERENCES NOTICE (NOTICE_NO),
	notice_original_file_name varchar2(100)	NOT NULL,
	NOTICE_RENAME_FILE_NAME VARCHAR2(100)	NOT NULL
);

commit;

--==============================================================================================================
-- 행정 및 채팅
--주민투표
DROP SEQUENCE vote_seq;
CREATE SEQUENCE  "HIAPT"."VOTE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

DROP TABLE uservote CASCADE CONSTRAINTS;

CREATE TABLE uservote (
vote_no	NUMBER CONSTRAINT pk_uservote PRIMARY KEY,
vote_title	VARCHAR2(100) NOT NULL,
vote_writer VARCHAR2(20) CONSTRAINT fk_uservote REFERENCES employee (empno) ON DELETE CASCADE,
vote_date	 DATE DEFAULT SYSDATE,
vote_final_date DATE DEFAULT SYSDATE,
vote_read_count NUMBER DEFAULT 0,
vote_secret CHAR(1) DEFAULT 'N' CHECK (vote_secret IN ('Y','N')),
vote_contents VARCHAR2(3000) NOT NULL,
voteone VARCHAR2(50),
votetwo VARCHAR2(50),
votethree VARCHAR2(50),
votefour VARCHAR2(50),
votefive VARCHAR2(50)	
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

DROP TABLE voteresult CASCADE CONSTRAINTS;

CREATE TABLE voteresult (
vote_no	NUMBER CONSTRAINT fk_voteresult REFERENCES uservote (vote_no) ON DELETE CASCADE,
voteone_result NUMBER DEFAULT 0,
votetwo_result NUMBER DEFAULT 0,
votethree_result NUMBER DEFAULT 0,
votefour_result NUMBER DEFAULT 0,
votefive_result NUMBER DEFAULT 0
);
ALTER TABLE voteresult ADD CONSTRAINT pk_voteresult PRIMARY KEY (
	vote_no
);
COMMENT ON COLUMN voteresult.vote_no IS '글번호';
COMMENT ON COLUMN voteresult.voteone_result IS '투표결과1';
COMMENT ON COLUMN voteresult.votetwo_result IS '투표결과2';
COMMENT ON COLUMN voteresult.votethree_result IS '투표결과3';
COMMENT ON COLUMN voteresult.votefour_result IS '투표결과4';
COMMENT ON COLUMN voteresult.votefive_result IS '투표결과5';


--주민투표중복체크

DROP TABLE votecheck CASCADE CONSTRAINTS;
CREATE TABLE votecheck (
userid VARCHAR2(10) CONSTRAINT fk_votecheck_userid REFERENCES aptuser (userid),
vote_no NUMBER CONSTRAINT fk_votecheck_vote_no REFERENCES uservote (vote_no) ON DELETE CASCADE,
vote_result VARCHAR2(50) NULL
);

COMMENT ON COLUMN votecheck.userid IS '동/호수';
COMMENT ON COLUMN votecheck.vote_no IS '글번호';
COMMENT ON COLUMN votecheck.vote_result IS '선택한투표값';

CREATE OR REPLACE TRIGGER trigger_voteresult 
AFTER INSERT ON uservote
FOR EACH ROW
BEGIN
  INSERT INTO voteresult
  VALUES (:NEW.vote_no, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
END;
/

INSERT INTO uservote VALUES(vote_seq.nextval, '테스트 글입니다.', 'admin', '19/11/03', '19/11/03', DEFAULT, DEFAULT,'테스용글', '테스트1','테스트2','테스트3','테스트4','테스트5');
INSERT INTO uservote VALUES(vote_seq.nextval, '테스트2 입니다.', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT,'테스용글(삭제x)', '테스트1','테스트2','테스트3','테스트4','테스트5');
commit;

---------------------------------------------------------------------------------------
--채팅
DROP TABLE CHATGROUP CASCADE CONSTRAINTS;
DROP TABLE chatmaker CASCADE CONSTRAINTS;

DROP TABLE CHAT_ROOM_PERSON CASCADE CONSTRAINTS;
DROP TABLE CHAT_ROOM_master CASCADE CONSTRAINTS;
DROP TABLE chatmessage CASCADE CONSTRAINTS;
DROP SEQUENCE CHATMESSAGE_SEQ;
DROP SEQUENCE CHATNO_SEQ;
CREATE SEQUENCE  "HIAPT"."CHATMESSAGE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
CREATE SEQUENCE  "HIAPT"."CHATNO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

--채팅방 생성자
CREATE TABLE CHAT_ROOM_MASTER (
 CHATNO NUMBER PRIMARY KEY,
 EMPNO varchar2(20) REFERENCES EMPLOYEE(EMPNO) on delete cascade
);
--채팅방 참여자
CREATE TABLE CHAT_ROOM_PERSON (
	CHATNO NUMBER REFERENCES CHAT_ROOM_MASTER(CHATNO),
	EMPNO varchar2(20) REFERENCES EMPLOYEE(EMPNO) on delete cascade,
  CHATTITLE VARCHAR2(100) default '방제목을 정해주세요',
  CONSTRAINT pri_chat primary key (chatno,empno)
);

--채팅메세지
CREATE TABLE chatmessage (
	chatwritedate	date	DEFAULT sysdate,
	chatcontents	varchar2(500)	NOT NULL,
	chatorder	number	NOT NULL,
	chatno NUMBER references chat_room_master(chatno),
	empno	varchar2(20) REFERENCES EMPLOYEE(EMPNO) on delete cascade
);

create or replace TRIGGER TRIGGER_CHAT
AFTER INSERT ON chat_room_master
FOR EACH ROW
BEGIN
  INSERT INTO chat_room_person
  VALUES (:NEW.chatno, :NEW.empno, DEFAULT);
END;
/

COMMENT ON COLUMN CHAT_ROOM_master.chatno IS '방번호';
COMMENT ON COLUMN CHAT_ROOM_Master.empno IS '방장사번';

COMMENT ON COLUMN CHAT_ROOM_PERSON.chatno IS '방번호';
COMMENT ON COLUMN CHAT_ROOM_PERSON.empno IS '사번';
COMMENT ON COLUMN CHAT_ROOM_PERSON.chattitle IS '방제목';

COMMENT ON COLUMN chatmessage.chatwritedate IS '작성날짜';
COMMENT ON COLUMN chatmessage.chatcontents IS '작성내용';
COMMENT ON COLUMN chatmessage.chatorder IS '글순서';
COMMENT ON COLUMN chatmessage.chatno IS '방번호';
COMMENT ON COLUMN chatmessage.empno IS '사번';

insert into CHAT_ROOM_Master values(CHATNO_SEQ.nextval,'admin');
insert into CHAT_ROOM_Master values(CHATNO_SEQ.nextval,'admin');
insert into CHAT_ROOM_Master values(CHATNO_SEQ.nextval,'10001');


insert into CHAT_ROOM_PERSON values(1, '10001', '100011');
insert into CHAT_ROOM_PERSON values(1, '30001', '300011');

insert into CHAT_ROOM_PERSON values(2, '10001', '100012');

insert into CHAT_ROOM_PERSON values(3, 'admin', 'admin3');
insert into CHAT_ROOM_PERSON values(3, '30001', '300013');

insert into chatmessage values(default, '테스트',CHATMESSAGE_SEQ.nextval,1,'admin');
insert into chatmessage values(default, '테스트',CHATMESSAGE_SEQ.nextval,1,'10001');
insert into chatmessage values(default, '테스트',CHATMESSAGE_SEQ.nextval,1,'30001');

insert into chatmessage values(default, '테스트',CHATMESSAGE_SEQ.nextval,2,'admin');
insert into chatmessage values(default, '테스트',CHATMESSAGE_SEQ.nextval,2,'10001');
insert into chatmessage values(default, '테스트',CHATMESSAGE_SEQ.nextval,2,'10001');

insert into chatmessage values(default, '테스트',CHATMESSAGE_SEQ.nextval,3,'admin');
insert into chatmessage values(default, '테스트',CHATMESSAGE_SEQ.nextval,3,'10001');
insert into chatmessage values(default, '테스트',CHATMESSAGE_SEQ.nextval,3,'admin');
insert into chatmessage values(default, '테스트',CHATMESSAGE_SEQ.nextval,3,'10001');

commit;

-------------------------------------------------------------------------------------------------------------------------------------------------

--민원
DROP SEQUENCE COMPLAIN_SEQ;
CREATE SEQUENCE  "HIAPT"."COMPLAIN_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

DROP TABLE complain CASCADE CONSTRAINTS;

CREATE TABLE complain (
	comp_no	number	CONSTRAINT PK_COMPLAIN PRIMARY KEY,
	comp_title	varchar2(100)		NOT NULL,
	comp_date	date 	DEFAULT sysdate,
	comp_contents	varchar2(3000)		NOT NULL,
	comp_result_status 	char(1)	DEFAULT 'N' CHECK(comp_result_status IN ('Y','N')),
  comp_secret 	char(1)	DEFAULT 'N' CHECK(comp_secret IN ('Y','N')),
	comp_response	varchar2(3000)		NULL,
	empno	varchar2(20)		CONSTRAINT FK_COMP_EMPNO REFERENCES EMPLOYEE(EMPNO) on delete cascade,
	userid VARCHAR2(10)	CONSTRAINT FK_COMP_USERID REFERENCES APTUSER(USERID) on delete cascade
);

COMMENT ON COLUMN complain.comp_no IS '글번호';
COMMENT ON COLUMN complain.comp_title IS '제목';
COMMENT ON COLUMN complain.comp_date IS '작성일';
COMMENT ON COLUMN complain.comp_contents IS '내용';
COMMENT ON COLUMN complain.comp_result_status IS '처리상태';
COMMENT ON COLUMN complain.comp_secret IS '공개여부';
COMMENT ON COLUMN complain.comp_response IS '답글';
COMMENT ON COLUMN complain.empno IS '사번';
COMMENT ON COLUMN complain.userid IS '동/호수';

DROP TABLE complainimg CASCADE CONSTRAINTS;

CREATE TABLE complainimg (
	comp_no	number CONSTRAINT FK_COMPIMG REFERENCES COMPLAIN(COMP_NO) on delete cascade,
	comp_original_imgname	varchar2(100)		NOT NULL,
	comp_rename_imgname	varchar2(100)		NOT NULL
);

COMMENT ON COLUMN complainimg.comp_no IS '글번호';
COMMENT ON COLUMN complainimg.comp_original_imgname IS '원본이미지이름';
COMMENT ON COLUMN complainimg.comp_rename_imgname IS '저장된이미지이름';

insert into complain values(COMPLAIN_SEQ.nextval, '테스트용글', default, '테스트용글 삭제X', default,default, null, 'admin','101-101');
commit;

---------------------------------------------------------
-------------------------------------------------------
DROP SEQUENCE BOARD_SEQ;
CREATE SEQUENCE  "HIAPT"."BOARD_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
DROP SEQUENCE BOARDREPLY_SEQ;
CREATE SEQUENCE  "HIAPT"."BOARDREPLY_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;



DROP TABLE board CASCADE CONSTRAINTS;

CREATE TABLE board (
	boardno	number CONSTRAINT PK_BOARD PRIMARY KEY,
	boardtitle varchar2(100)		NOT NULL,
	boarddate date DEFAULT sysdate	NULL,
	boardcontents varchar2(4000)		NOT NULL,
	boardreadcount number DEFAULT 0,
	userid VARCHAR2(10) CONSTRAINT FK_BOARD REFERENCES APTUSER(USERID) on delete cascade
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
	board_no	number CONSTRAINT FK_BOARDNO_REPLY REFERENCES BOARD(BOARDNO) ON DELETE CASCADE,
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
	boardno	number CONSTRAINT FK_BOARDFILES REFERENCES BOARD(BOARDNO) ON DELETE CASCADE,
	board_original_file_name VARCHAR(255)		NOT NULL,
	board_rename_file_name	VARCHAR(255)		NOT NULL,
  board_file_size varchar2(20) NOT NULL
);

COMMENT ON COLUMN boardfiles.boardno IS '글번호';
COMMENT ON COLUMN boardfiles.board_original_file_name IS '원본파일이름';
COMMENT ON COLUMN boardfiles.board_rename_file_name IS '저장된파일이름';
COMMENT ON COLUMN boardfiles.board_file_size IS '파일크기(MB)';

insert into board values(BOARD_SEQ.nextval,'테스트용 ', default, '테스트(삭제x)', default, '101-101');


insert into BOARDREPLY values(1, BOARDREPLY_SEQ.nextval, 1, 0, 0, sysdate, '1번댓글', '101-101');
insert into BOARDREPLY values(1, BOARDREPLY_SEQ.nextval, 2, 0, 0, sysdate, '2번댓글', '101-101');
insert into BOARDREPLY values(1, BOARDREPLY_SEQ.nextval, 3, 0, 0, sysdate, '3번댓글', '101-101');
insert into BOARDREPLY values(1, BOARDREPLY_SEQ.nextval, 1, 1, 1, sysdate, '4번댓글', '101-101');
INSERT INTO BOARDREPLY VALUES(1, BOARDREPLY_SEQ.NEXTVAL, 1, 2, 2, SYSDATE, '5번댓글', '101-101');

commit;

--====================================================================================================
-- 전자결제
DROP TABLE MYBOX CASCADE CONSTRAINTS; 
DROP TABLE MYBOXLIST CASCADE CONSTRAINTS;
DROP TABLE BUSINESSLOG CASCADE CONSTRAINTS;
DROP TABLE LINELIST CASCADE CONSTRAINTS;
DROP TABLE PROCESS CASCADE CONSTRAINTS;
DROP TABLE DRAFT CASCADE CONSTRAINTS;
DROP TABLE FORMBOX cascade constraints;

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
 FORMCONTENT LONG NOT NULL,

 CONSTRAINT FORMBOX_PK PRIMARY KEY (FORMCODE)
);

COMMENT ON COLUMN FORMBOX.FORMCODE IS '문서양식코드';
COMMENT ON COLUMN FORMBOX.FORMTYPE IS '문서분류';
COMMENT ON COLUMN FORMBOX.FORMNAME IS '문서양식명';
COMMENT ON COLUMN FORMBOX.FORMCONTENT IS '문서양식내용';


--결재라인 목록

CREATE TABLE LINELIST  (
 LINENO NUMBER	NOT NULL,
 EMPNO VARCHAR2(20)	 NOT NULL,
 LINENAME VARCHAR2(100)	NOT NULL,
 LINECONTENT VARCHAR2(200) NOT NULL,
 LINEVALUE VARCHAR2(200) NOT NULL,

 CONSTRAINT LINELIST_PK PRIMARY KEY (LINENO, EMPNO),
 CONSTRAINT LEMONO_FK FOREIGN KEY (EMPNO) REFERENCES EMPLOYEE ON DELETE CASCADE
);

COMMENT ON COLUMN LINELIST.LINENO IS '결재선 코드';
COMMENT ON COLUMN LINELIST.EMPNO IS '사번';
COMMENT ON COLUMN LINELIST.LINENAME IS '결재선명';
COMMENT ON COLUMN LINELIST.LINECONTENT IS '결재선 내용';
COMMENT ON COLUMN LINELIST.LINEVALUE IS '결재선 값';


-- 전자결재 기안 테이블 
CREATE TABLE DRAFT  (
 DOCNO NUMBER,
 EMPNO VARCHAR2(20)	 NOT NULL,
 FORMCODE NUMBER	NOT NULL,
 DOCTITLE VARCHAR2(150)	NOT NULL,
 DOCCONTENT LONG	NOT NULL,
 ORIGINFILE VARCHAR2(100)	NULL,
 RENAMEFILE VARCHAR2(100)	NULL,
 DRAFTDATE DATE	DEFAULT SYSDATE	NOT NULL,
 DOCSTATUS CHAR(1)	DEFAULT 0	NOT NULL, -- 현재 문서 상태... 0 : 대기중, 1 : 진행중, 2 : 완료됨, 3 : 반려됨, 4 : 보류중 5 : 임시저장
 APPROVER VARCHAR2(1000) NOT NULL, -- 결재자 경로 지정... 최대 5명까지 지정
 DEADLINE DATE NOT NULL,
 DISPLAY VARCHAR(1000) NULL, --공람자 지정... 최대 5명까지 지정 --> 없으면 none  
 
 CONSTRAINT DRAFT_PK PRIMARY KEY (DOCNO),
 CONSTRAINT DEMPNO_FK FOREIGN KEY (EMPNO) REFERENCES EMPLOYEE ON DELETE SET NULL,
 CONSTRAINT FORMCODE_FK FOREIGN KEY (FORMCODE) REFERENCES FORMBOX ON DELETE SET NULL
);

COMMENT ON COLUMN DRAFT.DOCNO IS '문서번호';
COMMENT ON COLUMN DRAFT.EMPNO IS '기안자';
COMMENT ON COLUMN DRAFT.FORMCODE IS '문서양식코드';
COMMENT ON COLUMN DRAFT.DOCTITLE IS '문서제목';
COMMENT ON COLUMN DRAFT.DOCCONTENT IS '문서내용';
COMMENT ON COLUMN DRAFT.ORIGINFILE IS '원래파일명';
COMMENT ON COLUMN DRAFT.RENAMEFILE IS '변경된파일명';
COMMENT ON COLUMN DRAFT.DRAFTDATE IS '문서작성날짜';
COMMENT ON COLUMN DRAFT.DOCSTATUS IS '문서진행상태';
COMMENT ON COLUMN DRAFT.APPROVER IS '결재자경로';
COMMENT ON COLUMN DRAFT.DEADLINE IS '결재기한';
COMMENT ON COLUMN DRAFT.DISPLAY IS '공람자지정';


CREATE TABLE PROCESS (
 DOCNO NUMBER NOT NULL,
 APPNO VARCHAR2(20) NULL,  -- 결재자번호
 APPSTEP CHAR(1) NOT NULL, -- 결재 단계 : 1~5명의 결재자 순서별 진행
 SIGNRESULT CHAR(1) NULL, -- 현재까지의 결재 결과 1 : 승인, 2 : 반려, 3 : 보류 
 APPDATE DATE DEFAULT SYSDATE NULL, -- 결재날짜 --> 받은날짜는?
 FEEDBACK VARCHAR2(2000)	NULL,
 
 CONSTRAINT PDOCNO_FK FOREIGN KEY (DOCNO) REFERENCES DRAFT ON DELETE CASCADE,
 CONSTRAINT PPRODOC_PK PRIMARY KEY (DOCNO)
);

COMMENT ON COLUMN PROCESS.DOCNO IS '문서번호';
COMMENT ON COLUMN PROCESS.APPNO IS '결재자번호';
COMMENT ON COLUMN PROCESS.APPSTEP IS '결재단계';
COMMENT ON COLUMN PROCESS.SIGNRESULT IS '결재결과';
COMMENT ON COLUMN PROCESS.APPDATE IS '결재완료날짜';


-- 전자결재 테이블 - 내문서함
CREATE TABLE MYBOXLIST  (
 MYBOXCODE CHAR(1)	NOT NULL,
 EMPNO VARCHAR2(20)	 NOT NULL,
 MYBOXNAME VARCHAR2(30)	NOT NULL,
 
 CONSTRAINT MLEMPNO_FK FOREIGN KEY (EMPNO) REFERENCES EMPLOYEE ON DELETE CASCADE,
 CONSTRAINT MLYBOX_PK PRIMARY KEY (MYBOXCODE, EMPNO)

);

COMMENT ON COLUMN MYBOXLIST.MYBOXCODE IS '내문서함코드';
COMMENT ON COLUMN MYBOXLIST.EMPNO IS '사번';
COMMENT ON COLUMN MYBOXLIST.MYBOXNAME IS '내문서함명';

-- 전자결재 테이블 - 내문서함 목록
CREATE TABLE MYBOX  (
 MYBOXCODE CHAR(1)	NOT NULL,
 EMPNO VARCHAR2(20)	 NOT NULL,
 DOCNO NUMBER NULL,
 SAVEDATE DATE DEFAULT SYSDATE NOT NULL,
 
 CONSTRAINT MYBOXNO_FK FOREIGN KEY (MYBOXCODE, EMPNO) REFERENCES MYBOXLIST ON DELETE CASCADE,
 CONSTRAINT MYBDOCNO_FK FOREIGN KEY (DOCNO) REFERENCES DRAFT ON DELETE CASCADE
);

COMMENT ON COLUMN MYBOX.MYBOXCODE IS '내문서함코드';
COMMENT ON COLUMN MYBOX.EMPNO IS '사번';
COMMENT ON COLUMN MYBOX.DOCNO IS '문서번호';
COMMENT ON COLUMN MYBOX.SAVEDATE IS '결재일';

INSERT INTO FORMBOX VALUES (FORMCODE_SEQ.NEXTVAL, '공용', '일반 기안서', '공용 양식');
INSERT INTO FORMBOX VALUES (FORMCODE_SEQ.NEXTVAL, '공용', '휴가 신청서', '공용 양식');
INSERT INTO FORMBOX VALUES (FORMCODE_SEQ.NEXTVAL, '공용', '기타1', '공용 양식');
INSERT INTO FORMBOX VALUES (FORMCODE_SEQ.NEXTVAL, '공용', '기타2', '공용 양식');
INSERT INTO FORMBOX VALUES (FORMCODE_SEQ.NEXTVAL, '공용', '기타3', '공용 양식');
INSERT INTO FORMBOX VALUES (FORMCODE_SEQ.NEXTVAL, '공용', '기타4', '공용 양식');
INSERT INTO FORMBOX VALUES (FORMCODE_SEQ.NEXTVAL, '공용', '기타5', '공용 양식');
INSERT INTO FORMBOX VALUES (FORMCODE_SEQ.NEXTVAL, '업무일지', '직원 업무일지', '업무일지 양식');
INSERT INTO FORMBOX VALUES (FORMCODE_SEQ.NEXTVAL, '업무일지', '관리자 업무일지', '업무일지 양식');

-- 업무일지 테이블 
CREATE TABLE BUSINESSLOG (
 LOGNO NUMBER,
 EMPNO VARCHAR2(20)	 NOT NULL,
 FORMCODE NUMBER	NOT NULL,
 DOCTITLE VARCHAR2(150)	NOT NULL,
 DOCCONTENT LONG	NOT NULL,
 ORIGINFILE VARCHAR2(100)	NULL,
 RENAMEFILE VARCHAR2(100)	NULL,
 WRITEDATE DATE	DEFAULT SYSDATE	NOT NULL,
 PROGRESS CHAR(1)	DEFAULT 0	NOT NULL,
 APPROVER VARCHAR2(1000) NULL,
 APPDATE DATE DEFAULT SYSDATE NULL,
 FEEDBACK VARCHAR2(2000)	NULL,
 
CONSTRAINT LOGNO_PK PRIMARY KEY (LOGNO),
CONSTRAINT LEMPNO_FK FOREIGN KEY (EMPNO) REFERENCES EMPLOYEE ON DELETE SET NULL,
CONSTRAINT BFORMCODE_FK FOREIGN KEY (FORMCODE) REFERENCES FORMBOX ON DELETE SET NULL,
CONSTRAINT BEMPNO_FK FOREIGN KEY (APPROVER) REFERENCES EMPLOYEE ON DELETE SET NULL
);

COMMENT ON COLUMN BUSINESSLOG.LOGNO IS '문서번호';
COMMENT ON COLUMN BUSINESSLOG.EMPNO IS '기안자';
COMMENT ON COLUMN BUSINESSLOG.FORMCODE IS '문서양식코드';
COMMENT ON COLUMN BUSINESSLOG.DOCTITLE IS '문서제목';
COMMENT ON COLUMN BUSINESSLOG.DOCCONTENT IS '문서내용';
COMMENT ON COLUMN BUSINESSLOG.ORIGINFILE IS '원래파일명';
COMMENT ON COLUMN BUSINESSLOG.RENAMEFILE IS '변경된파일명';
COMMENT ON COLUMN BUSINESSLOG.WRITEDATE IS '문서작성날짜';
COMMENT ON COLUMN BUSINESSLOG.PROGRESS IS '문서진행상태';
COMMENT ON COLUMN BUSINESSLOG.APPROVER IS '결재자';
COMMENT ON COLUMN BUSINESSLOG.APPDATE IS '최종결재날짜';
COMMENT ON COLUMN BUSINESSLOG.FEEDBACK IS '첨삭및의견';



 
INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'10001', 
'100', 
'기안1', 
'기안내용1', 
NULL, 
NULL, 
SYSDATE, 
'3',  
'admin',
'19/12/01',
'30001, 50001'
);

INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'30001', 
'110', 
'기안2', 
'기안내용2', 
NULL, 
NULL, 
SYSDATE, 
'0', 
'admin',
'19/12/01',
'70001');

INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'10001', 
'100', 
'기안3', 
'기안내용3', 
NULL, 
NULL, 
SYSDATE, 
'1', 
'admin',
'19/12/01',
'30001,70001');


INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'50001', 
'170', 
'기안4', 
'기안내용4', 
NULL, 
NULL, 
SYSDATE, 
'1', 
'admin',
'19/12/31',
'30001,10001');


INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'70001', 
'110', 
'기안5', 
'기안내용5', 
NULL, 
NULL, 
SYSDATE, 
'2', 
'10001,30001,admin',
'19/12/01',
'10001, 50001');


INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'30001', 
'100', 
'기안6', 
'기안내용6', 
NULL, 
NULL, 
SYSDATE, 
'1', 
'admin',
'19/12/01',
'10001,50001,70001');

INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'30001', 
'110', 
'기안7', 
'기안내용7', 
NULL, 
NULL, 
SYSDATE, 
'2', 
'50001,admin',
'19/12/08',
'50001,10001');

INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'50001', 
'170', 
'기안8', 
'기안내용8', 
NULL, 
NULL, 
SYSDATE, 
'1', 
'admin',
'19/12/25',
NULL);

INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'70001', 
'170', 
'기안9', 
'기안내용9', 
NULL, 
NULL, 
SYSDATE, 
'0', 
'admin',
'19/12/01',
NULL);


INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'50001', 
'120', 
'기안10', 
'기안내용10', 
NULL, 
NULL, 
SYSDATE, 
'0', 
'admin',
'19/12/01',
'30001');

INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'10001', 
'120', 
'임시저장1', 
'기안내용10', 
NULL, 
NULL, 
SYSDATE, 
'5', 
'admin',
'19/12/01',
'30001');

INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'10001', 
'120', 
'임시저장2', 
'ㅇㅇㅇㅇㅇ', 
NULL, 
NULL, 
SYSDATE, 
'5', 
'admin',
'19/12/01',
'30001');


INSERT INTO DRAFT VALUES (
DOCNO_SEQ.NEXTVAL, 
'10001', 
'120', 
'임시저장3', 
'???????????????', 
NULL, 
NULL, 
SYSDATE, 
'5', 
'admin',
'19/12/01',
'30001');

 
COMMIT;

--=======================================================================================================================
-- 관리비 테이블
--  ������ �� ����  db ����*********************************************************

drop table bill cascade constraints;
-- BILL ���̺� ����(NULL��)
CREATE TABLE BILL(
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
	IMPOSE_FINISH	varchar2(1)	DEFAULT 'N'	NULL,
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
  ALLELECTRIC_COsT NUMBER	DEFAULT 0	NULL,	
  ALLWATER_COST 	NUMBER	DEFAULT 0	NULL,  
	ELECTRIC_USAGE 	NUMBER	DEFAULT 0	NULL,	
	water_usage	NUMBER	DEFAULT 0	NULL,
  HEATING_USAGE	NUMBER	DEFAULT 0	NULL,  
	HWATER_USAGE 	NUMBER	DEFAULT 0	NULL,  
	ARREARS	NUMBER DEFAULT 0 NULL,  
	ETC	VARCHAR2(20) NULL,
	VBANK_NUM	VARCHAR2(20) NULL,
  AMOUNT	NUMBER	DEFAULT 0	NULL,
  before_amount	number	DEFAULT 0	NULL,
	arrears_fine	number	DEFAULT 0	NULL,
	after_amount	number	DEFAULT 0	NULL,	
  CONSTRAINT PK_BILL PRIMARY KEY(MERCHANT_UID), 
  CONSTRAINT CK_BILL CHECK (IMPOSE_FINISH IN ('Y', 'N'))
);

--  BILL COMMENT
COMMENT ON COLUMN bill.merchant_uid IS '������������ȣ';
COMMENT ON COLUMN bill.userid IS '��/ȣ��';
COMMENT ON COLUMN BILL.USERNAME IS '�̸�';
COMMENT ON COLUMN BILL.BILL_YEAR_MONTH IS '�������ΰ���';

COMMENT ON COLUMN BILL.CALCULATE_START_DAY IS '����Ⱓ������';
COMMENT ON COLUMN BILL.CALCULATE_END_DAY IS '����Ⱓ������';
COMMENT ON COLUMN BILL.IMPOSE_END_DATE IS '�ΰ�������';
COMMENT ON COLUMN bill.accept_date IS '����Ƿ��Ͻ�';
COMMENT ON COLUMN BILL.CUTOFF_DATE IS '���θ�����';

COMMENT ON COLUMN BILL.IMPOSE_STATUS IS '�ΰ�����';
COMMENT ON COLUMN bill.impose_count IS '�ΰ�����Ƚ��';
COMMENT ON COLUMN BILL.IMPOSE_FINISH IS '�ΰ��Ϸ�';

COMMENT ON COLUMN bill.general_cost IS '�Ϲݰ�����';
COMMENT ON COLUMN bill.clean_cost IS 'û�Һ�';
COMMENT ON COLUMN bill.disinfect_cost IS '�ҵ���';
COMMENT ON COLUMN bill.elevator_cost IS '�°���������';
COMMENT ON COLUMN bill.repair_cost IS '����������';
COMMENT ON COLUMN BILL.GUARD_COST IS '����';
COMMENT ON COLUMN bill.fireinsurance_cost IS 'ȭ�纸���';
COMMENT ON COLUMN BILL.COMMISSION IS '��Ź����������';

COMMENT ON COLUMN BILL.ELECTRIC_COST IS '���������';
COMMENT ON COLUMN bill.allelectric_cost IS '���������';
COMMENT ON COLUMN bill.tv_cost IS 'TV���ŷ�';
COMMENT ON COLUMN bill.heating_cost IS '�������';
COMMENT ON COLUMN bill.hwater_cost IS '�¼�����';
COMMENT ON COLUMN BILL.WATER_COST IS '���������';

COMMENT ON COLUMN BILL.ALLWATER_COST IS '����������';

COMMENT ON COLUMN bill.electric_usage IS '�����뷮';
COMMENT ON COLUMN bill.heating_usage IS '�����뷮';
COMMENT ON COLUMN BILL.HWATER_USAGE IS '�¼���뷮';
COMMENT ON COLUMN BILL.WATER_USAGE IS '������뷮';

COMMENT ON COLUMN BILL.ARREARS IS '�̳���';

COMMENT ON COLUMN BILL.ETC IS '���';
COMMENT ON COLUMN BILL.VBANK_NUM IS '���¹�ȣ';

COMMENT ON COLUMN bill.arrears_fine IS '�̳��ıݾ�';

COMMENT ON COLUMN bill.after_amount IS '�����ıݾ�';

COMMENT ON COLUMN BILL.AMOUNT IS '�ΰ��ݾ�';

COMMENT ON COLUMN BILL.before_AMOUNT IS '���⳻�ݾ�';
--------------------------------------------------------------
DROP SEQUENCE BILL_SEQ;
--BILL ������ ����
CREATE SEQUENCE BILL_SEQ
START WITH 10000000000001
INCREMENT BY 1
MAXVALUE 90000000000000
MINVALUE 1
NOCYCLE
NOCACHE;

-- bill insert
INSERT INTO BILL VALUES(
 BILL_SEQ.NEXTVAL,'201-201','������','2019/09/01',
'2019/08/01','2019/08/31','2019/08/31','2019/08/31','2019/09/30',
  '�Ϸ�',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  73510, 13970, DEFAULT, 0, 0, 1710, 860,
  404, 15, 0, 0,DEFAULT, NULL,'110-23-0310818',
  152560,	152560,	0,	167816
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','������','2019/08/01',
'2019/07/01','2019/07/31','2019/07/31','2019/07/31','2019/08/31',
  '�Ϸ�',1,'Y',
  20520, 20870, 13500, 770, 3920, 2080, 650, 960,
  73510, 2140, DEFAULT, 0, 0, 1710, 860,
  404, 32, 0, 0,DEFAULT, NULL,'110-23-0310818',0, 0, 0, 0
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'202-101','����','2019/08/01',
'2019/07/01','2019/07/31','2019/07/31','2019/07/31','2019/08/31',
  '�Ϸ�',1,'Y',
  29040, 29530, 19110, 1080, 4660, 2940, 2570, 910,
  73510, 2140, DEFAULT, 0, 0, 1710, 860,
  404, 32, 0, 0,DEFAULT, NULL,'110-23-0310818',141490, 141490, 0,	155639
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','������','2019/07/01',
'2019/06/01','2019/06/30','2019/06/30','2019/06/30','2019/07/31',
  '�Ϸ�',1,'Y',
  20390, 20870, 13500, 770, 3290, 1810, 650, 810,
  73510, 13830, DEFAULT, 0, 0, 1610, 890,
  404, 15, 0, 0,DEFAULT, NULL,'110-23-0310818',168060, 168060,	0,	184866
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','������','2019/06/01',
'2019/05/01','2019/05/31','2019/05/31','2019/05/31','2019/06/30',
  '�Ϸ�',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  73510, 13830, DEFAULT, 0, 0, 1850, 860,
  404, 15, 0, 0,DEFAULT, NULL,'110-23-0310818',151930,	151930,	0,	167123
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','������','2019/05/01',
'2019/04/01','2019/04/30','2019/04/30','2019/04/30','2019/05/31',
  '�Ϸ�',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  73510, 13830, DEFAULT, 0, 0, 1850, 860,
  404, 15, 0, 0,DEFAULT, NULL,'110-23-0310818',152560,	152560,	0,	167816
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','������','2019/04/01',
'2019/03/01','2019/03/31','2019/03/31','2019/03/31','2019/04/30',
  '�Ϸ�',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  73510, 13830, DEFAULT, 9680, 23100, 1850, 860,
  404, 15,1.2, 5.5,DEFAULT, NULL,'110-23-0310818',152560,	152560,	0,	167816
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','������','2019/03/01',
'2019/02/01','2019/02/28','2019/02/28','2019/02/28','2019/03/31',
  '�Ϸ�',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  73510, 13830, DEFAULT, 12280, 31820, 1850, 860,
  404, 15,1.5, 6.5,DEFAULT, NULL,'110-23-0310818',185340,185340,	0,	203874
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','������','2019/02/01',
'2019/01/01','2019/01/31','2019/01/31','2019/01/31','2019/02/28',
  '�Ϸ�',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  86410, 16300, DEFAULT, 60760, 42000, 1850, 860,
  410, 27, 37, 12,DEFAULT, NULL,'110-23-0310818',196660,	196660,	0,	216326
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','������','2019/01/01',
'2018/12/01','2018/12/31','2018/12/31','2018/12/31','2019/01/31',
  '�Ϸ�',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  86410, 16300, DEFAULT, 60760, 42000, 1850, 860,
  410, 27, 37, 12,DEFAULT, NULL,'110-23-0310818',270690,	270690,	0,	297759
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','������','2018/12/01',
'2018/11/01','2018/11/30','2018/11/30','2018/11/30','2018/12/31',
  '�Ϸ�',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  86410, 16300, DEFAULT, 23547, 15034, 1850, 860,
  410, 27, 17, 5,DEFAULT, NULL,'110-23-0310818',270690,270690,	0,	297759
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','������','2018/11/01',
'2018/10/01','2018/10/31','2018/10/31','2018/10/31','2018/11/30',
  '�Ϸ�',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  86410, 16300, DEFAULT, 15300, 12000, 1850, 860,
  410, 27, 12, 10,DEFAULT, NULL,'110-23-0310818',206511,206511,	0,	227162
);


INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','������','2018/10/01',
'2018/09/01','2018/09/30','2018/09/30','2018/09/30','2018/10/31',
  '�Ϸ�',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  52770, 20850, DEFAULT, 4470, 6090, 1850, 860,
  386, 15, 12, 4,DEFAULT, NULL,'110-23-0310818',195230, 195230,	0,	214753
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'201-201','������','2018/09/01',
'2018/08/01','2018/08/31','2018/08/31','2018/08/31','2018/09/30',
  '�Ϸ�',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  52770, 20850, DEFAULT, 4470, 6090, 1850, 860,
  386, 15, 12, 4,DEFAULT, NULL,'110-23-0310818',149400,	149400,	0,	164340
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'202-101','����','2018/11/01',
'2018/10/01','2018/10/31','2018/10/31','2018/10/31','2018/11/30',
  '�Ϸ�',1,'Y',
 29290, 29310, 19110, 1080, 4660, 2950, 2420, 1200,
  86410, 16300, DEFAULT, 15300, 12000, 1850, 860,
  410, 27, 12, 10,DEFAULT, NULL,'110-23-0310818',149400,149400,	0,	164340
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'202-101','����','2018/10/01',
'2018/09/01','2018/09/30','2018/09/30','2018/09/30','2018/10/31',
  '�Ϸ�',1,'Y',
  20690, 20600, 13470, 760, 3290, 2090, 650, 960,
  52770, 20850, DEFAULT, 4470, 6090, 1850, 860,
  386, 15, 12, 4,DEFAULT, NULL,'110-23-0310818',222740,222740,	0,	245014
);

INSERT INTO BILL VALUES(
BILL_SEQ.NEXTVAL,'202-101','����','2018/09/01',
'2018/08/01','2018/08/31','2018/08/31','2018/08/31','2018/09/30',
  '�Ϸ�',1,'Y',
  29290, 29310, 19110, 1080, 4660, 2950, 2420, 1200,
  52770, 20850, DEFAULT, 4470, 6090, 1850, 860,
  386, 15, 12, 4,DEFAULT, NULL,'110-23-0310818',149400,	149400,	0,	164340
);
--==========================================================================

DROP TABLE VBANK cascade constraints;
-- ������� ���̺� ����
CREATE TABLE VBANK (
	VBANK_NUM	VARCHAR2(20) NOT NULL,
	VBANK_NAME VARCHAR2(20) NOT NULL,
	VBANK_HOLDER VARCHAR2(15) DEFAULT '���̾���Ʈ'	NOT NULL,
	VBANK_DATE DATE NULL,
  CONSTRAINT PK_VB PRIMARY KEY(VBANK_NUM)
);

-- COMMENT ����
COMMENT ON COLUMN vbank.vbank_num IS '���¹�ȣ';
COMMENT ON COLUMN vbank.vbank_name IS '�����';
COMMENT ON COLUMN VBANK.VBANK_HOLDER IS '������';
COMMENT ON COLUMN VBANK.VBANK_DATE IS '�Աݱ���';

-- vbank insert

INSERT INTO VBANK VALUES(
'110-23-0310818', '��������', DEFAULT, '19/09/30'
);

INSERT INTO VBANK VALUES(
'763201-01-148210', '��������', DEFAULT, '19/09/30'
);

INSERT INTO VBANK VALUES(
'175320-51-018603', '�ϳ�����', DEFAULT, '19/09/30'
);

INSERT INTO VBANK VALUES(
'402172-01-001467', '��ü��', DEFAULT, '19/09/30'
);

---=============================================================================
-- SMS ���̺� ����

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

COMMENT ON COLUMN SMS.EMPNO IS '���';
COMMENT ON COLUMN SMS.TEL IS '�����Ҵ�ǥ��ȣ';
COMMENT ON COLUMN SMS.userphone IS '�߽��ڹ�ȣ';
COMMENT ON COLUMN SMS.text IS '�޼���';
COMMENT ON COLUMN SMS.type IS '�޼���Ÿ��';
COMMENT ON COLUMN SMS.state_message IS '��������';
COMMENT ON COLUMN SMS.COUNTRY IS '������ȣ';
COMMENT ON COLUMN SMS.status_code IS '�����ڵ�';


--============================================================================
-- PAYMENT ���̺� ����

drop table payment cascade constraints;

CREATE TABLE PAYMENT (
	MERCHANT_UID	NUMBER		NOT NULL,
	name	VARCHAR2(20)	DEFAULT '�����������'	NOT NULL,
	AMOUNT	NUMBER		NOT NULL,
  card_num	VARCHAR2(30)		NOT NULL,
	pay_method	VARCHAR2(50)	DEFAULT 'card'	NOT NULL,
	buyer_name	VARCHAR2(20)		NULL,
	BUYER_TEL	VARCHAR2(20)		NOT NULL,
	BUYER_EMAIL	VARCHAR2(50)		NULL,
  payment_day date default sysdate null
);

-- comment
COMMENT ON COLUMN payment.merchant_uid IS '������������ȣ';
COMMENT ON COLUMN payment.name IS '��������';
COMMENT ON COLUMN PAYMENT.AMOUNT IS '�����ݾ�';
COMMENT ON COLUMN payment.card_num IS 'ī���ȣ';
COMMENT ON COLUMN payment.pay_method IS '��������';
COMMENT ON COLUMN payment.buyer_name IS '�������̸�';
COMMENT ON COLUMN PAYMENT.BUYER_TEL IS '�����ڿ���ó';
COMMENT ON COLUMN PAYMENT.BUYER_EMAIL IS '�������̸���';
COMMENT ON COLUMN payment.payment_day IS '������';

-- INSERT PAYMENT

INSERT INTO PAYMENT VALUES(
'10000000000001', DEFAULT, 152560, '1234123412341234', '�������', '������', '010-8001-6812', 'dd55555bb@gmail.com', default
);

INSERT INTO PAYMENT VALUES(
'10000000000002', DEFAULT, 141490, '1234123412341234', '�������', '������', '010-8001-6812', 'dd55555bb@gmail.com', default
);

INSERT INTO PAYMENT VALUES(
'10000000000003', DEFAULT, 168060, '1234123412341234', '�������', '����', '010-2685-4111', 'horse4797@naver.com', default
);

INSERT INTO PAYMENT VALUES(
'10000000000004', DEFAULT, 151930, '1234123412341234', 'ī�����', '������', '010-8001-6812', 'dd55555bb@gmail.com', default
);

INSERT INTO PAYMENT VALUES(
'10000000000005', DEFAULT, 152560, '1234123412341234', 'ī�����', '������', '010-8001-6812', 'dd55555bb@gmail.com', default
);

INSERT INTO PAYMENT VALUES(
'10000000000006', DEFAULT, 152560, '1234123412341234', '�������', '������', '010-8001-6812', 'dd55555bb@gmail.com', default
);

INSERT INTO PAYMENT VALUES(
'10000000000007', DEFAULT, 185340, '1234123412341234', '�������', '������', '010-8001-6812', 'dd55555bb@gmail.com', default
);

INSERT INTO PAYMENT VALUES(
'10000000000008', DEFAULT, 196660, '1234123412341234', 'ī��������','������', '010-8001-6812', 'dd55555bb@gmail.com',default
);

INSERT INTO PAYMENT VALUES(
'10000000000009', DEFAULT, 270690, '1234123412341234', 'ī�����','������', '010-8001-6812', 'dd55555bb@gmail.com', default
);

INSERT INTO PAYMENT VALUES(
'10000000000010', DEFAULT, 270690, '1234123412341234', '�������', '������', '010-8001-6812', 'dd55555bb@gmail.com',default
);

INSERT INTO PAYMENT VALUES(
'10000000000011', DEFAULT, 206511, '1234123412341234', 'ī�����', '������', '010-8001-6812', 'dd55555bb@gmail.com',default
);

INSERT INTO PAYMENT VALUES(
'10000000000012', DEFAULT, 195230, '1234123412341234', '�ǽð�������ü', '������', '010-8001-6812', 'dd55555bb@gmail.com',default
);

INSERT INTO PAYMENT VALUES(
'10000000000013', DEFAULT, 149400, '1234123412341234', 'ī�����','������', '010-8001-6812', 'dd55555bb@gmail.com',default
);

INSERT INTO PAYMENT VALUES(
'10000000000014', DEFAULT, 149400, '1234123412341234', 'ī�����', '������', '010-8001-6812', 'dd55555bb@gmail.com',default
);

INSERT INTO PAYMENT VALUES(
'10000000000015', DEFAULT, 222740, '1234123412341234', '�������', '������', '010-8001-6812', 'dd55555bb@gmail.com',default
);

--=============================================================================
drop table receipt cascade constraints;
-- RECEIPT ���̺� ����
CREATE TABLE RECEIPT (
	imp_uid	VARCHAR2(40)		NOT NULL,
  MERCHANT_UID NUMBER		NOT NULL,
	apply_num	number	not	NULL,
	NAME	VARCHAR2(20)	DEFAULT '�����������'	NOT NULL,
  pg varchar2(10) default 'kakaopay' not null,
	PAY_METHOD	VARCHAR2(30)	DEFAULT 'card'	NOT NULL,
  amount number not null,
	PAID_AMOUNT	NUMBER		NOT NULL,
	pai_date	DATE		NOT NULL,
	BUYER_NAME	VARCHAR2(20)		NULL,
	BUYER_TEL	VARCHAR2(50)		NOT NULL,
	BUYER_EMAIL	VARCHAR2(50)		NULL,
  BUYER_ADDR VARCHAR2(30) NULL,
  buyer_postcode varchar2(10) null,
  CONSTRAINT PK_RECEIPT PRIMARY KEY(IMP_UID)
);

--COMMIT
COMMENT ON COLUMN receipt.imp_uid IS '����������ID';
COMMENT ON COLUMN receipt.apply_num IS 'ī����ι�ȣ';
COMMENT ON COLUMN receipt.name IS '��������';
COMMENT ON COLUMN RECEIPT.PAY_METHOD IS '��������';
COMMENT ON COLUMN RECEIPT.PG IS 'īī��������';
COMMENT ON COLUMN receipt.amount IS '�����ݾ�';
COMMENT ON COLUMN receipt.paid_amount IS '�����ѱݾ�';
COMMENT ON COLUMN receipt.pai_date IS '�������νð�';
COMMENT ON COLUMN receipt.buyer_name IS '�������̸�';
COMMENT ON COLUMN receipt.buyer_tel IS '��������ȭ��ȣ';
COMMENT ON COLUMN RECEIPT.BUYER_EMAIL IS '�������̸���';
COMMENT ON COLUMN RECEIPT.BUYER_ADDR IS '�������ּ�';
COMMENT ON COLUMN RECEIPT.BUYER_postcode IS '�����ȣ';
COMMENT ON COLUMN receipt.merchant_uid IS '������������ȣ';

-- INSERT
--
--INSERT INTO RECEIPT VALUES(
--'5d8b920eb1b56e000675bc59', 10000000000015, NULL, NULL, 	
--DEFAULT, '�������', 222740, 'īī������', '2018/11/10',	NULL, '������', '010-8001-6812',
--'dd55555bb@gmail.com', DEFAULT, '�����Ϸ�' 
--);
--
--INSERT INTO RECEIPT VALUES(
--'5d8b920eb1b56e000675bc57', 10000000000014, '5d8b920eb1b56e000675bc59', NULL, 	
--DEFAULT, 'ī�����', 149400, 'KCP', '2018/09/11',	NULL, '������', '010-8001-6812',
--'dd55555bb@gmail.com', DEFAULT, '�����Ϸ�' 
--);
--
--INSERT INTO RECEIPT VALUES(
--'5d8b904eb1b56e000675bbbd', 10000000000013, '5d8b920eb1b56e000675bc59', NULL, 	
--DEFAULT, 'ī�����', 149400, 'LGU+', '2018/10/05',	NULL, '������', '010-8001-6812',
--'dd55555bb@gmail.com', DEFAULT, '�����Ϸ�' 
--);
--
--INSERT INTO RECEIPT VALUES(
--'5d8b95aeb1b56e000675bd6d', 10000000000012, NULL, '110-23-0310818', 	
--DEFAULT, '�ǽð�������ü', 195230, '�ٳ�', '2018/11/23',	NULL, '������', '010-1234-2222',
--'dd55555bb@gmail.com', DEFAULT, '�����Ϸ�' 
--);
--
--INSERT INTO RECEIPT VALUES(
--'5d8b8a28b1b56e000675ba80', 10000000000011, '5d8b8a28b1b56e000675ba80', NULL, 	
--DEFAULT, 'ī�����', 206511, '���̽��������', '2018/12/23',	NULL, '������', '010-1234-2222',
--'dd55555bb@gmail.com', DEFAULT, '�����Ϸ�' 
--);
--
--INSERT INTO RECEIPT VALUES(
--'5d95c71bb1b56e00068008de', 10000000000010, NULL, '110-23-0310818',	
--DEFAULT, '�������', 270690, 'PG', '2019/01/23',	NULL, '������', '010-1234-2222',
--'dd55555bb@gmail.com', DEFAULT, '�����Ϸ�' 
--);
--
--INSERT INTO RECEIPT VALUES(
--'5d95c599b1b56e00068006b9', 10000000000001, NULL, '110-23-0310818',	
--DEFAULT, '�������', 152560, 'PG', '2019/09/23',	NULL, '������', '010-1234-2222',
--'dd55555bb@gmail.com', DEFAULT, '�����Ϸ�' 
--);
--
--INSERT INTO RECEIPT VALUES(
--'5d95c4e8b1b56e0006800558', 10000000000002, NULL, NULL, 	
--DEFAULT, '�������', 141490, 'īī������', '2019/08/10',	NULL, '������', '010-8001-6812',
--'dd55555bb@gmail.com', DEFAULT, '�����Ϸ�' 
--);
--
--INSERT INTO RECEIPT VALUES(
--'5d95c6e1b1b56e0006800871', 10000000000003, NULL,'110-23-0310818',	
--DEFAULT, '�������', 168060, '���̽��������', '2019/08/10',	NULL, '����', '010-2685-4111', 'horse4797@naver.com', DEFAULT, '�����Ϸ�' 
--);
--
--INSERT INTO RECEIPT VALUES(
--'5d95c4e8b1b56e000680055f', 10000000000004, '5d95c4e8b1b56e000680055f', NULL, 	
--DEFAULT, 'ī�����', 151930, '�̴Ͻý�', '2019/07/23',	NULL, '������', '010-1234-2222',
--'dd55555bb@gmail.com', DEFAULT, '�����Ϸ�' 
--);
--
--INSERT INTO RECEIPT VALUES(
--'5d95c5f4b1b56e0006800720', 10000000000005, '5d95c5f4b1b56e0006800720', NULL, 	
--DEFAULT, 'ī�����', 152560, '���̽��������', '2019/06/06',	NULL, '������', '010-1234-2222',
--'dd55555bb@gmail.com', DEFAULT, '�����Ϸ�' 
--);
--
--INSERT INTO RECEIPT VALUES(
--'5d95c533b1b56e00068005de', 10000000000006, NULL, NULL, 	
--DEFAULT, '�������', 152560, 'PAYCO', '2019/05/10',	NULL, '������', '010-8001-6812',
--'dd55555bb@gmail.com', DEFAULT, '�����Ϸ�' 
--);
--
--INSERT INTO RECEIPT VALUES(
--'5d95c484b1b56e00068004b8', 10000000000007, NULL, NULL, 	
--DEFAULT, '�������', 185340, 'PAYCO', '2019/04/10',	NULL, '������', '010-8001-6812',
--'dd55555bb@gmail.com', DEFAULT, '�������' 
--);
--
--INSERT INTO RECEIPT VALUES(
--'5d95c2b3b1b56e00068001d9', 10000000000008, NULL, NULL, 	
--DEFAULT, 'ī��������', 196660, 'LGU+', '2019/03/07',	NULL, '������', '010-8001-6812',
--'dd55555bb@gmail.com', DEFAULT, '�����Ϸ�' 
--);
--
--INSERT INTO RECEIPT VALUES(
--'5d95c074b1b56e00067ffe79', 10000000000009, NULL, NULL, 	
--DEFAULT, 'ī�����', 270690, '���̽��������', '2019/02/10',	NULL, '������', '010-8001-6812',
--'dd55555bb@gmail.com', DEFAULT, '�������' 
--);

---============================================================================
-- ���� ���� ��¿� view ����
DROP VIEW RECEIPT_VIEW;

CREATE VIEW receipt_view
AS
SELECT A.USERID, A.USERNAME, L.BILL_YEAR_MONTH, R.PAID_AMOUNT
FROM APTUSER A, BILL L, RECEIPT R
WHERE A.USERID = L.USERID AND L.MERCHANT_UID = R.MERCHANT_UID
with read only;

-------------------------------
DROP VIEW BASE_VIEW;
-- �ΰ������۾� ���̺�
CREATE VIEW BASE_VIEW
AS
SELECT MERCHANT_UID, IMPOSE_STATUS, BILL_YEAR_MONTH, 
CALCULATE_START_DAY, CALCULATE_END_DAY, IMPOSE_END_DATE,
ACCEPT_DATE, CUTOFF_DATE, IMPOSE_COUNT 
FROM BILL
WITH CHECK OPTION;

INSERT INTO BASE_VIEW VALUES(
BILL_SEQ.NEXTVAL,'����', '2019/11/01',
'2019/10/01','2019/10/30','2019/10/30',
'2019/10/30','2019/10/30',1  
);

---------------------------------
DROP VIEW IMPOSE_VIEW;
-- �������� ó�� �� ���̺�
CREATE VIEW impose_VIEW
AS
SELECT MERCHANT_UID, USERID, username, BILL_YEAR_MONTH,
      GENERAL_COST, guard_cost,	clean_cost	,	DISINFECT_COST,
      ELEVATOR_COST,	REPAIR_COST,	commission,	FIREINSURANCE_COST,	
      ELECTRIC_COST,		TV_COST,  WATER_COST,	HEATING_COST,
      HWATER_COST, ALLELECTRIC_COsT,	ALLWATER_COST,
      ELECTRIC_USAGE,	WATER_USAGE, HEATING_USAGE,  HWATER_USAGE,
      amount
FROM BILL
WITH CHECK OPTION;

COMMENT ON COLUMN IMPOSE_VIEW.MERCHANT_UID IS '��������ȣ';
COMMENT ON COLUMN IMPOSE_VIEW.USERID IS '��/ȣ';
COMMENT ON COLUMN IMPOSE_VIEW.username IS '�����ָ�';
COMMENT ON COLUMN IMPOSE_VIEW.BILL_YEAR_MONTH IS '�ΰ����';
COMMENT ON COLUMN IMPOSE_VIEW.GENERAL_COST IS '�Ϲݰ�����';
COMMENT ON COLUMN IMPOSE_VIEW.CLEAN_COST IS 'û�Һ�';
COMMENT ON COLUMN IMPOSE_VIEW.DISINFECT_COST IS '�ҵ���';
COMMENT ON COLUMN IMPOSE_VIEW.ELEVATOR_COST IS '�°���������';
COMMENT ON COLUMN IMPOSE_VIEW.REPAIR_COST IS '����������';
COMMENT ON COLUMN IMPOSE_VIEW.GUARD_COST IS '����';
COMMENT ON COLUMN IMPOSE_VIEW.FIREINSURANCE_COST IS 'ȭ�纸���';
COMMENT ON COLUMN IMPOSE_VIEW.COMMISSION IS '��Ź����������';
COMMENT ON COLUMN IMPOSE_VIEW.ELECTRIC_COST IS '���������';
COMMENT ON COLUMN IMPOSE_VIEW.ALLELECTRIC_COsT IS '���������';
COMMENT ON COLUMN IMPOSE_VIEW.TV_COST IS 'TV���ŷ�';
COMMENT ON COLUMN IMPOSE_VIEW.HEATING_COST IS '�������';
COMMENT ON COLUMN IMPOSE_VIEW.HWATER_COST IS '�¼�����';
COMMENT ON COLUMN IMPOSE_VIEW.WATER_COST IS '���������';
COMMENT ON COLUMN IMPOSE_VIEW.ALLWATER_COST IS '����������';
COMMENT ON COLUMN IMPOSE_VIEW.ELECTRIC_USAGE IS '�����뷮';
COMMENT ON COLUMN IMPOSE_VIEW.HEATING_USAGE IS '�����뷮';
COMMENT ON COLUMN IMPOSE_VIEW.HWATER_USAGE IS '�¼���뷮';
COMMENT ON COLUMN IMPOSE_VIEW.WATER_USAGE IS '������뷮';
COMMENT ON COLUMN IMPOSE_VIEW.amount IS '���αݾ�';

-- ������ �ݾ� ��Ͻ� ������ �˻���
DROP VIEW IMPOSE_VIEW_aptuser;

CREATE VIEW impose_VIEW_aptuser
AS
SELECT DISTINCT USERID, USERNAME, USERPHONE
FROM aptuser
WITH READ ONLY;

COMMENT ON COLUMN impose_VIEW_aptuser.USERID IS '��/ȣ';
COMMENT ON COLUMN impose_VIEW_aptuser.USERNAME IS '�����ָ�';
comment on column impose_VIEW_aptuser.USERPHONE is '��ȭ��ȣ';

-----------------------------------
DROP VIEW IMPOSE_END_VIEW;

-- �ΰ�������� ���� �� ���̺�
CREATE VIEW impose_end_VIEW
AS
SELECT MERCHANT_UID, USERID, 
        IMPOSE_STATUS, BILL_YEAR_MONTH, 
        CALCULATE_START_DAY, CALCULATE_END_DAY,
        IMPOSE_FINISH as "�ΰ�����",
        CUTOFF_DATE, IMPOSE_END_DATE, IMPOSE_COUNT, accept_date
FROM BILL
WITH CHECK OPTION;

----------------------------------------
DROP VIEW BILL_VIEW;
-- ������ ���� �� ���̺�
CREATE VIEW bill_VIEW
AS
SELECT MERCHANT_UID, USERID,AMOUNT, ARREARS, 
      before_amount, arrears_fine, after_amount  
FROM BILL
with read only;

-- constranits ==========================================================================

ALTER TABLE bill ADD CONSTRAINT FK_vbank_TO_bill_1 FOREIGN KEY (	vbank_num)
REFERENCES vbank (	vbank_num);

ALTER TABLE payment ADD CONSTRAINT PK_PAYMENT PRIMARY KEY (	merchant_uid);

ALTER TABLE PAYMENT ADD CONSTRAINT FK_BILL_TO_PAYMENT_1 FOREIGN KEY (	MERCHANT_UID)
REFERENCES bill (	merchant_uid) on delete cascade;;

--ALTER TABLE RECEIPT ADD CONSTRAINT FK_PAYMENT_TO_RECEIPT_1 FOREIGN KEY (	MERCHANT_UID)
--REFERENCES PAYMENT (	MERCHANT_UID) ON DELETE CASCADE;



-- constranits  ====================================================


COMMIT;

--=============================================================================================
-- 메일
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

insert into mailboxtype values(0, '전체메일함', 'abc@hiapt.com');
insert into mailboxtype values(mailcode_seq.nextval, '받는메일함', 'abc@hiapt.com');
insert into mailboxtype values(mailcode_seq.nextval, '보낸메일함', 'abc@hiapt.com');
insert into mailboxtype values(mailcode_seq.nextval, '임시보관함', 'abc@hiapt.com');
insert into mailboxtype values(mailcode_seq.nextval, '내게 쓴 메일함', 'abc@hiapt.com');
insert into mailboxtype values(mailcode_seq.nextval, '휴지통', 'abc@hiapt.com');
insert into mailboxtype values(mailcode_seq.nextval, '가족', 'abc@hiapt.com');
insert into mailboxtype values(mailcode_seq.nextval, '회사', 'abc@hiapt.com');
insert into mailboxtype values(mailcode_seq.nextval, '거래처', 'abc@hiapt.com');

--select * from mailboxtype;

-- 메일

create table mail(
  mailno number primary key,
  mailcode number references mailboxtype (mailcode),
  empemail varchar2(50) references employee (empemail),
  mailtitle varchar2(50),
  mailtime date default sysdate,
  mailcontents varchar2(4000),
  recipient varchar2(50),
  separator varchar2(50) references employee (empemail),
  fileyn CHAR(1) DEFAULT 'N' CONSTRAINT CHK CHECK (fileyn IN ('Y','N'))
);

insert into mail values(mailno_seq.nextval, 2, 'abc@hiapt.com', '너에게로 가는 길', '19/01/01',
'너에게로 가는 길엔 자작나무 숲이 있고', 'qwrds@hiapt.com', 'abc@hiapt.com', default);
insert into mail values(mailno_seq.nextval, 2, 'abc@hiapt.com', '어머니', '19/01/02',
'들로 가신 엄마 생각', 'rudfl@hiapt.com', 'abc@hiapt.com', default);
insert into mail values(mailno_seq.nextval, 2, 'abc@hiapt.com', '운문사 비밀의 숲', '19/01/03',
'나, 다시 태어난다면', 'tjfql@hiapt.com', 'abc@hiapt.com', default);
insert into mail values(mailno_seq.nextval, 2, 'abc@hiapt.com', '성불사의 밤', '19/01/04',
'성불사 깊은 밤에 그윽한 풍경소리', 'rjacla@hiapt.com', 'abc@hiapt.com', default);
insert into mail values(mailno_seq.nextval, 2, 'abc@hiapt.com', '사월의 노래', '19/01/05', '사월이 오면 사월이 오며는', 'rjacla@hiapt.com', 'abc@hiapt.com', default);
insert into mail values(mailno_seq.nextval, 3, 'abc@hiapt.com', '임시 편지함', '19/01/06', '임시편지함 확인용입니다.', 'qwrds@hiapt.com', 'abc@hiapt.com', default);
insert into mail values(mailno_seq.nextval, 1, 'qwrds@hiapt.com', '녹슨 경의선', '19/01/07',
'서울, 부산 신의주까지', 'abc@hiapt.com', 'abc@hiapt.com', default);
insert into mail values(mailno_seq.nextval, 1, 'rudfl@hiapt.com', '다시 만날까봐', '19/01/08',
'인스타로 몰래 보는 너의 하루들', 'abc@hiapt.com', 'abc@hiapt.com', default);
insert into mail values(mailno_seq.nextval, 4, 'abc@hiapt.com', '내게 쓴편지함', '19/01/09', '내게 쓴 편지함 확인용입니다.', 'abc@hiapt.com', 'abc@hiapt.com', default);
insert into mail values(mailno_seq.nextval, 1, 'qwrds@hiapt.com', '조금 취했어', '19/01/11',
'내가 망가지면 니가 나를 볼까 봐','abc@hiapt.com', 'abc@hiapt.com', default);
insert into mail values(mailno_seq.nextval, 1, 'rudfl@hiapt.com', '시든 꽃에 물을 주듯', '19/01/21',
'아무말도 아무것도 여전히 넌 여기 없고', 'abc@hiapt.com', 'abc@hiapt.com', default);
insert into mail values(mailno_seq.nextval, 5, 'abc@hiapt.com', '휴지통', '19/02/01', '휴지통 확인용 입니다.', 'abc@hiapt.com', 'abc@hiapt.com', default);
insert into mail values(mailno_seq.nextval, 6, 'abc@hiapt.com', '가족', '19/03/01', '메일 그룹 확인용 입니다.', 'abc@hiapt.com', 'abc@hiapt.com', default);
insert into mail values(mailno_seq.nextval, 7, 'abc@hiapt.com', '회사', '19/04/01', '메일 그룹 확인용 입니다.', 'abc@hiapt.com', 'abc@hiapt.com', default);
insert into mail values(mailno_seq.nextval, 8, 'abc@hiapt.com', '거래처', '19/05/01', '메일 그룹 확인용 입니다.', 'abc@hiapt.com', 'abc@hiapt.com', default);

-- 메일 파일함

create table mailfilebox(
  mailno number references mail (mailno),
  originalfile varchar2(150),
  renamefile varchar2(150),
  filesize varchar2(30),
  downloadterm date  
);

--insert into mailfilebox values(1, 'a.txt', '201910031000.txt', 100, null);
--insert into mailfilebox values(1, 'b.txt', '201910031100.txt', 100, null);
--insert into mailfilebox values(2, 'c.txt', '201910031200.txt', 200, null);
--insert into mailfilebox values(3, 'd.txt', '201910031300.txt', 300, null);
--insert into mailfilebox values(4, 'e.txt', '201910031400.txt', 1024 * 10, sysdate + 30);

--select * from mailf order by mailno;


create view mailm 
as select mail.mailno, mail.mailcode, mail.empemail, mail.mailtitle, mail.mailtime, mail.mailcontents, mail.recipient, mail.separator, mailboxtype.mailboxname, fileyn
from mail left join mailboxtype
on mail.mailcode = mailboxtype.mailcode and mail.empemail = mailboxtype.empemail;



-- 주소록 그룹

drop table addressbook_type cascade constraints;

CREATE TABLE addressbook_type (
	addressbook_code	number primary key	 NOT NULL,
	addressbook_name	varchar2(50)	NOT NULL
);

insert into addressbook_type values(addressbook_code_seq.nextval, '가족');
insert into addressbook_type values(addressbook_code_seq.nextval, '친구');
insert into addressbook_type values(addressbook_code_seq.nextval, '회사');
insert into addressbook_type values(addressbook_code_seq.nextval, '거래처');
insert into addressbook_type values(addressbook_code_seq.nextval, '교회');

-- 주소록

drop view publicaddrbook cascade constraints;

create view publicaddrbook
as 
select empname, empaddress, empphone, empemail, empetc
from employee;

drop table addressbook cascade CONSTRAINTS;

CREATE TABLE addressbook (
	addressbook_no number primary key	NOT NULL,
	addressbook_address varchar2(100)	NULL,
	addressbook_etc	varchar2(100)	NULL,
	addressbook_name	varchar2(20)	NULL,
	addressbook_phone	varchar2(20)	NULL,
	addressbook_mail	varchar2(30)	NULL,
	addressbook_code	number NOT NULL references addressbook_type (addressbook_code)
);


insert into addressbook values(addressbook_no_seq.nextval, '경기도 성남시 수정구', '가족', '홍길동', '010-1234-5678', 'tjfql@gmail.com', 1);
insert into addressbook values(addressbook_no_seq.nextval, '경기도 성남시 중원구', '친구', '이순신', '010-3242-5678', 'soon@gmail.com', 2);
insert into addressbook values(addressbook_no_seq.nextval, '경기도 성남시 분당구', '회사', '신사임당', '010-5432-5678', 'sin@gmail.com', 3);
insert into addressbook values(addressbook_no_seq.nextval, '서울특별시 노원구', '거래처', '원균', '010-8965-5678', 'won@gmail.com', 4);
insert into addressbook values(addressbook_no_seq.nextval, '서울특별시 도봉구', '교회', '유성룡', '010-1232-5678', 'you@gmail.com', 5);


COMMIT;