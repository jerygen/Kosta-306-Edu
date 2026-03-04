-- WS01 users테이블을 생성한 데이터베이스에서 작업한다.
USE ex0303;

select * from users;

insert into users (user_seq, name, email, phone) values (444, '사길동', 'sa@gildong@com', '010-4444-4444');
insert into users (user_seq, name, email, phone) values (555, '오길동', 'o@gildong@com', '010-5555-5555');

CREATE TABLE account
( 
    account_seq   INT PRIMARY KEY,
    account_number VARCHAR(50) not null,
    balance       INT,
    user_seq      INT ,
    foreign key(user_seq) references users(user_seq)
);

drop table account;
insert into account (account_seq, account_number, balance, user_seq) values (50, '00500505005005', 3000, 222);
insert into account (account_seq, account_number, balance, user_seq) values (10, '00100101001001', 1000, 111);
insert into account (account_seq, account_number, balance, user_seq) values (30, '00300303003003', 5000, 222);
insert into account (account_seq, account_number, balance, user_seq) values (70, '00700707007007', 7000, 444);
insert into account (account_seq, account_number, balance, user_seq) values (40, '00400404004004', 4000, 222);
insert into account (account_seq, account_number, balance, user_seq) values (60, '00600606006006', 2000, 222);
insert into account (account_seq, account_number) values (80, '00800808008008');
insert into account (account_seq, account_number, balance, user_seq) values (20, '00200202002002', 6000, 111);

SELECT * FROM USERS;
SELECT * FROM ACCOUNT;

-- 1. 고객 번호가 111인 계좌 테이블을 조회한다. 
select * from account where user_seq = 111;
-- 2. 잔고가 5000미만인 계좌 테이블을 조회한다.
select * from account where balance<5000;
-- 3. 잔고가 5000 이상 10000 이하인 계좌 테이블을 조회한다.
select * from account where balance between 5000 and 10000;
-- 4. 게좌번호 중 '4'를 포함하는 계좌 테이블을 조회한다.
select * from account where account_number like '%4%';
-- 5. 고객명이 '삼'으로 시작하는 고객 테이블을 조회한다.
select * from users where name like '삼%';
-- 6. 계좌 테이블에 있는 고객 번호를 중복없이 조회한다.
select distinct user_seq from account;
-- 7. 잔고가 없는 계좌 테이블을 조회한다.
select * from account where balance is null;
-- 8. 고객번호가 있는 계좌 테이블을 조회한다.
select * from account where user_seq is not null;
-- 9. 고객번호가 있고, 잔고가 4000 이하인 계좌 테이블을 조회한다.
select * from account where user_seq is not null and balance<=4000;
-- 10. 계좌 테이블을 고객번호 기준으로 오름차순으로 정렬하여 조회한다.
select * from account order by user_seq;
-- 11. 계좌 테이블을 고객번호 기준으로 오름차순으로 그리고 그 안에서 잔고 기준으로 내림차순으로 정렬하여 조회한다.
select * from account order by user_seq, balance desc;
-- 12. 계좌 테이블을 조회하되, balance 값이 없으면 0으로 표시한다.
select account_seq, account_number, ifnull(balance, 0) as balance, user_seq from account;
select a.* , ifnull(balance, 0) from account a;
select * , ifnull(balance, 0) from account;
-- 13. 고객 테이블을 조회하되, email은 @포함 뒷 부분은 뺴고 앞 아이디만 표시한다. 컬럼 명도 email 대신 email_id로 변경한다.
select user_seq, name, substring_index(email, '@',1) As email_id from users;











