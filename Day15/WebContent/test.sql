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