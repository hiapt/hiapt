DROP TABLE chatrooms CASCADE CONSTRAINTS;
DROP TABLE CHAT_ROOM_PERSON CASCADE CONSTRAINTS;
DROP TABLE chatmessage CASCADE CONSTRAINTS;
DROP SEQUENCE CHATNO_SEQ;
DROP SEQUENCE CHATMESSAGE_SEQ;
CREATE SEQUENCE  "HIAPT"."CHATNO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
CREATE SEQUENCE  "HIAPT"."CHATMESSAGE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;


CREATE TABLE CHAT_ROOM_PERSON (
	CHATNO NUMBER ,
	EMPNO varchar2(20) REFERENCES EMPLOYEE(EMPNO),
  CHATTITLE VARCHAR2(100) default '방제목을 정해주세요',
  CONSTRAINT pri_chat primary key (chatno,empno)
);

COMMENT ON COLUMN CHAT_ROOM_PERSON.chatno IS '방번호';
COMMENT ON COLUMN CHAT_ROOM_PERSON.empno IS '사번';
COMMENT ON COLUMN CHAT_ROOM_PERSON.chattitle IS '방제목';

insert into CHAT_ROOM_PERSON values(CHATNO_SEQ.nextval, 'admin', default);
insert into CHAT_ROOM_PERSON values(CHATNO_SEQ.currval, '10001', default);
insert into CHAT_ROOM_PERSON values(2, '30001', default);

insert into CHAT_ROOM_PERSON values(3, 'admin', '3번방');
insert into CHAT_ROOM_PERSON values(3, '10001', 'ㅋㅋㅋ');

insert into CHAT_ROOM_PERSON values(4, 'admin', '4번방');
insert into CHAT_ROOM_PERSON values(4, '10001', 'ㅎㅎㅎ');
insert into CHAT_ROOM_PERSON values(4, '30001', default);


CREATE TABLE chatmessage (
	chatwritedate	date	DEFAULT sysdate,
	chatcontents	varchar2(500)	NOT NULL,
	chatorder	number	NOT NULL,
	chatno NUMBER,
	empno	varchar2(20),
  foreign key(chatno,empno) references chat_room_person(chatno,empno)
);

COMMENT ON COLUMN chatmessage.chatwritedate IS '작성날짜';
COMMENT ON COLUMN chatmessage.chatcontents IS '작성내용';
COMMENT ON COLUMN chatmessage.chatorder IS '글순서';
COMMENT ON COLUMN chatmessage.chatno IS '방번호';
COMMENT ON COLUMN chatmessage.empno IS '사번';


insert into CHAT_ROOM_PERSON values(CHATNO_SEQ.nextval, 'admin', default);
insert into CHAT_ROOM_PERSON values(CHATNO_SEQ.currval, '10001', default);
insert into CHAT_ROOM_PERSON values(2, '30001', default);

insert into CHAT_ROOM_PERSON values(3, 'admin', '3번방');
insert into CHAT_ROOM_PERSON values(3, '10001', 'ㅋㅋㅋ');

insert into CHAT_ROOM_PERSON values(4, 'admin', '4번방');
insert into CHAT_ROOM_PERSON values(4, '10001', 'ㅎㅎㅎ');
insert into CHAT_ROOM_PERSON values(4, '30001', default);

insert into chatmessage values(default, 'ㅎㅎ',CHATMESSAGE_SEQ.nextval,2,'admin');
insert into chatmessage values(default, '1001',CHATMESSAGE_SEQ.nextval,2,'10001');

insert into chatmessage values(default, 'ㅎsafㅎ',CHATMESSAGE_SEQ.nextval,3,'admin');
insert into chatmessage values(default, '10sfb01',CHATMESSAGE_SEQ.nextval,3,'10001');
insert into chatmessage values(default, 'ㅎㅎ',CHATMESSAGE_SEQ.nextval,3,'admin');
insert into chatmessage values(default, '1001',CHATMESSAGE_SEQ.nextval,3,'10001');

insert into chatmessage values(default, 'bfad',CHATMESSAGE_SEQ.nextval,4,'10001');
insert into chatmessage values(default, 'adf',CHATMESSAGE_SEQ.nextval,4,'admin');
insert into chatmessage values(default, '1adf01',CHATMESSAGE_SEQ.nextval,4,'30001');

commit;



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

insert into board values(BOARD_SEQ.nextval,'연습1', default, '연습', default, '101-101');
insert into board values(BOARD_SEQ.nextval,'연습2', default, '연습', default, '101-101');
insert into board values(BOARD_SEQ.nextval,'연습3', default, '연습', default, '101-101');
insert into board values(BOARD_SEQ.nextval,'연습4', default, '연습', default, '101-101');
insert into board values(BOARD_SEQ.nextval,'연습5', default, '연습', default, '101-101');
insert into board values(BOARD_SEQ.nextval,'연습6', default, '연습', default, '101-101');
insert into board values(BOARD_SEQ.nextval,'연습7', default, '연습', default, '101-101');
insert into board values(BOARD_SEQ.nextval,'연습8', default, '연습', default, '101-101');
insert into board values(BOARD_SEQ.nextval,'연습9', default, '연습', default, '101-101');
insert into board values(BOARD_SEQ.nextval,'연습15', default, '연습', default, '101-101');

commit;