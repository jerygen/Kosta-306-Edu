use ex0303;
create table users(
	user_seq int,
    name varchar(10),
    email varchar(20),
    phone varchar(14),
    is_sleep varchar(5)
);

alter table users add constraint primary key(user_seq);

alter table users add constraint unique (email);
alter table users modify email varchar(20) not null;

alter table users alter column is_sleep set default 'N';

desc users;

insert into users(user_seq, name, email, phone) values(111, '홍길동', 'hong@gildong.com','010-1111-1111');
insert into users(user_seq, name, email, phone) values(222, '이길동', 'lee@gildong.com','010-2222-2222');
insert into users(user_seq, name, email, phone) values(333, '삼길동', 'sam@gildong.com','010-3333-3333');

update users
set is_sleep='Y'
where user_seq = 222;

insert into users(user_seq, name, email, phone) values(222, '이길동2', 'lee2@gildong.com', '010-2222-2222'); -- error: primary key는 중복 값 안 됨
insert into users(user_seq, name, email, phone) values(2222, '이길동2', 'lee@gildong.com', '010-2222-2222'); -- error: email에는 중복 안 됨
insert into users(user_seq, name, phone) values(2222, '이길동2', '010-2222-2222'); -- error: email은 기본값이 없고 null이 안 되기 때문에 안 됨
insert into users(user_seq, name, email, phone) values(2222, '이길동2', 'lee2@gildong.com', '010-2222-2222');

delete from users where user_seq = 2222;

select * from users;

drop table users;