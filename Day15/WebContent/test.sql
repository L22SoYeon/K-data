select * from tab;

create table users
(
	id varchar2(10) primary key,
	pwd varchar2(10),
	name varchar2(10),
	profile varchar2(15),
	reg_date date default sysdate
)

-- 회원가입, 로그인, 로그아웃, 리스트, 삭제, 상세보기
-- 보여지는 페이지는 jsp로
-- 요청은 servlet으로 memberservlet
-- 로그아웃은 DB와 관련 X
-- dao(데이터베이스에 접근하는 코드)는 6개 중 5개만 작성 - 자바로작성
-- kdata.project.dao
-- kdata.project.dto

SELECT * FROM USERS;