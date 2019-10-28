
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