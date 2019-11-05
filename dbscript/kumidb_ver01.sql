
--��--------------------------------------------------------------------------------------------------------------------------------------------------
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