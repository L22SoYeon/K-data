select * from tab;

create table users
(
	id varchar2(10) primary key,
	pwd varchar2(10),
	name varchar2(10),
	profile varchar2(15),
	reg_date date default sysdate
)

-- ȸ������, �α���, �α׾ƿ�, ����Ʈ, ����, �󼼺���
-- �������� �������� jsp��
-- ��û�� servlet���� memberservlet
-- �α׾ƿ��� DB�� ���� X
-- dao(�����ͺ��̽��� �����ϴ� �ڵ�)�� 6�� �� 5���� �ۼ� - �ڹٷ��ۼ�
-- kdata.project.dao
-- kdata.project.dto

SELECT * FROM USERS;

create table board(
num number primary key,
id varchar2(10),
subject varchar2(10),
content varchar2(1000),
write_data date default sysdate,
read_count number default 0
)

create sequence board_seq
start with 1
increment by 1

insert into board values(board_seq.nextval, 'test', '�ȳ��ϼ���', '�ȳ��ϼ���', default, default)