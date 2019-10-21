
--�̿��� -------------------------------------------------------------
--��������
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

COMMENT ON COLUMN notice. notice_no IS '�۹�ȣ';
COMMENT ON COLUMN notice.notice_title IS '����';
COMMENT ON COLUMN notice.notice_date IS '�ۼ���';
COMMENT ON COLUMN notice.notice_contents IS '����';
COMMENT ON COLUMN notice.notice_read_count IS '��ȸ��';
COMMENT ON COLUMN notice.notice_writer IS '�ۼ���';

INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '���������Դϴ�','18/09/20','��������������',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '102������','18/10/10','�Ϸ�',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '108������','19/1/01','�Ϸ�',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '1���� ����������','19/02/16','�Ϸ�',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '2���� ����������','19/03/12','�Ϸ�',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '1���� ��������','19/04/10','�Ϸ�',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '1���� ��������','19/05/11','�Ϸ�',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '5���� ����������','19/06/04','�Ϸ�',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '1���� ��������','19/07/04','�Ϸ�',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '1���� ��������','19/08/04','�̻�',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '4���� ����������','19/09/05','�̻�',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '2���� ����������','19/10/03','�Ϸ�',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '1���� ��������','19/10/04','�̻�',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '1���� ����������',default,'�̻�',default,'admin');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '1���� ��������',default,'�Ϸ�',default,'admin');

--������������
DROP TABLE NOTICEFILES CASCADE CONSTRAINTS;

CREATE TABLE noticefiles (
	notice_no	number CONSTRAINT FK_NOTICEFILES REFERENCES NOTICE (NOTICE_NO),
	notice_original_file_name varchar2(100)	NOT NULL,
	notice_rename_file_name varchar2(100)	NOT NULL
);
-----------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------
--�ֹ���ǥ
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

COMMENT ON COLUMN uservote.vote_no IS '�۹�ȣ';
COMMENT ON COLUMN uservote.vote_title IS '����';
COMMENT ON COLUMN uservote.vote_writer IS '�ۼ���';
COMMENT ON COLUMN uservote.vote_date IS '�ۼ���¥';
COMMENT ON COLUMN uservote.vote_final_date IS '��ǥ������';
COMMENT ON COLUMN uservote.vote_read_count IS '��ȸ��';
COMMENT ON COLUMN uservote.vote_secret IS '�������';
COMMENT ON COLUMN uservote.vote_contents IS '����';
COMMENT ON COLUMN uservote.voteone IS '��ǥ1';
COMMENT ON COLUMN uservote.votetwo IS '��ǥ2';
COMMENT ON COLUMN uservote.votethree IS '��ǥ3';
COMMENT ON COLUMN uservote.votefour IS '��ǥ4';
COMMENT ON COLUMN uservote.votefive IS '��ǥ5';

--�ֹ���ǥ���üũ

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
COMMENT ON COLUMN voteresult.vote_no IS '�۹�ȣ';
COMMENT ON COLUMN voteresult.voteone_result IS '��ǥ���1';
COMMENT ON COLUMN voteresult.votetwo_result IS '��ǥ���2';
COMMENT ON COLUMN voteresult.votethree_result IS '��ǥ���3';
COMMENT ON COLUMN voteresult.votefour_result IS '��ǥ���4';
COMMENT ON COLUMN voteresult.votefive_result IS '��ǥ���5';


--�ֹ���ǥ�ߺ�üũ

DROP TABLE VOTECHECK CASCADE CONSTRAINTS;
CREATE TABLE votecheck (
	userid VARCHAR2(10)	CONSTRAINT FK_VOTECHECK_USERID REFERENCES APTUSER (USERID),
	vote_no	number CONSTRAINT FK_VOTECHECK_VOTE_NO REFERENCES USERVOTE (VOTE_NO) ON DELETE CASCADE,
	vote_result 	varchar2(50)		NULL
);

COMMENT ON COLUMN votecheck.userid IS '��/ȣ��';
COMMENT ON COLUMN votecheck.vote_no IS '�۹�ȣ';
COMMENT ON COLUMN votecheck.vote_result IS '��������ǥ��';

create or replace TRIGGER TRIGGER_voteresult 
AFTER INSERT ON USERVOTE
FOR EACH ROW
BEGIN
  INSERT INTO VOTERESULT
  VALUES (:NEW.VOTE_NO, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);
END;
/

INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, '����', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '����','�ϳ�','��','��','��','��');
INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, 'zz', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '����','�ϳ�','��','��','��','��');
INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, '33', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '����','�ϳ�','��','��','��','��');
INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, '44', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '����','�ϳ�','��','��','��','��');
INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, '55', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '����','�ϳ�','��','��','��','��');
INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, '66', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '����','�ϳ�','��','��','��','��');
INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, '77', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '����','�ϳ�','��','��','��','��');
INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, '88', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '����','�ϳ�','��','��','��','��');
INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, '99', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '����','�ϳ�','��','��','��','��');
INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, '1010', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '����','�ϳ�','��','��','��','��');
INSERT INTO USERVOTE VALUES(VOTE_SEQ.NEXTVAL, '1111', 'admin', DEFAULT, DEFAULT, DEFAULT, DEFAULT, '����','�ϳ�','��','��','��','��');

-----------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------
--�����Խ���

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

COMMENT ON COLUMN board.boardno IS '�۹�ȣ';
COMMENT ON COLUMN board.boardtitle IS '����';
COMMENT ON COLUMN board.boarddate IS '�ۼ���';
COMMENT ON COLUMN board.boardcontents IS '����';
COMMENT ON COLUMN board.boardreadcount IS '��ȸ��';
COMMENT ON COLUMN board.userid IS '��/ȣ��';


--�����Խ��� ���
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

COMMENT ON COLUMN boardreply.board_no IS '�۹�ȣ';
COMMENT ON COLUMN boardreply.boardreply_original_no IS '��۹�ȣ';
COMMENT ON COLUMN boardreply.boardreply_group_no IS '��۱׷�';
COMMENT ON COLUMN boardreply.boardreply_group_order IS '�׷쳻����';
COMMENT ON COLUMN boardreply.boardreply_group_layer IS '������ ��ۼ���';
COMMENT ON COLUMN boardreply.boardreply_date IS '����ۼ��ð�';
COMMENT ON COLUMN boardreply.boardreply_contents IS '��۳���';
COMMENT ON COLUMN boardreply.userid IS '��/ȣ��';

--�����Խ��� ��������
DROP TABLE boardfiles CASCADE CONSTRAINTS;

CREATE TABLE boardfiles (
	boardno	number CONSTRAINT FK_BOARDFILES REFERENCES BOARD(BOARDNO),
	board_original_file_name VARCHAR(255)		NOT NULL,
	board_rename_file_name	VARCHAR(255)		NOT NULL
);

COMMENT ON COLUMN boardfiles.boardno IS '�۹�ȣ';
COMMENT ON COLUMN boardfiles.board_original_file_name IS '���������̸�';
COMMENT ON COLUMN boardfiles.board_rename_file_name IS '����������̸�';

-----------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------
--�ο�
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

COMMENT ON COLUMN complain.comp_no IS '�۹�ȣ';
COMMENT ON COLUMN complain.comp_title IS '����';
COMMENT ON COLUMN complain.comp_date IS '�ۼ���';
COMMENT ON COLUMN complain.comp_contents IS '����';
COMMENT ON COLUMN complain.comp_result_status IS 'ó������';
COMMENT ON COLUMN complain.comp_response IS '���';
COMMENT ON COLUMN complain.empno IS '���';
COMMENT ON COLUMN complain.userid IS '��/ȣ��';

DROP TABLE complainimg CASCADE CONSTRAINTS;

CREATE TABLE complainimg (
	comp_no	number CONSTRAINT FK_COMPIMG REFERENCES COMPLAIN(COMP_NO),
	comp_original_imgname	varchar2(100)		NOT NULL,
	comp_rename_imgname	varchar2(100)		NOT NULL
);

COMMENT ON COLUMN complainimg.comp_no IS '�۹�ȣ';
COMMENT ON COLUMN complainimg.comp_original_imgname IS '�����̹����̸�';
COMMENT ON COLUMN complainimg.comp_rename_imgname IS '������̹����̸�';


-----------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------
--ä��

DROP TABLE chatmaker CASCADE CONSTRAINTS;

CREATE TABLE chatmaker (
	chattitle 	varchar2(50)	CONSTRAINT PK_CHATMAKER PRIMARY KEY,
	empno	varchar2(20)	 CONSTRAINT FK_CHATMAKER REFERENCES EMPLOYEE(EMPNO)
);

COMMENT ON COLUMN chatmaker.chattitle IS '������';
COMMENT ON COLUMN chatmaker.empno IS '���';

DROP TABLE chatgroup CASCADE CONSTRAINTS;

CREATE TABLE chatgroup (
	chattitle	varchar2(50) REFERENCES CHATMAKER(CHATTITLE),
	empno	varchar2(20)	 REFERENCES EMPLOYEE(EMPNO)
);

ALTER TABLE chatgroup ADD CONSTRAINT PK_CHATGROUB PRIMARY KEY (
	chattitle,
	empno
);

COMMENT ON COLUMN chatgroup.chattitle IS '������';
COMMENT ON COLUMN chatgroup.empno IS '���';

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
COMMENT ON COLUMN chatmessage.chatwritedate IS '�ۼ���¥';
COMMENT ON COLUMN chatmessage.chatcontents IS '�ۼ�����';
COMMENT ON COLUMN chatmessage.chatorder IS '�ۼ���';
COMMENT ON COLUMN chatmessage.chattitle IS '������';
COMMENT ON COLUMN chatmessage.empno IS '���';

COMMIT;
