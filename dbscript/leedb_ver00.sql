
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
