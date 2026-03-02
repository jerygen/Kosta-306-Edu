create database school;
use school;

create table course(
	course_code varchar(5) primary key,
    course_name varchar(20) not null
);

desc course;

insert into course values('j1001','sql');
insert into course values('j1002','Win200');
insert into course values('j1003','ASP');
insert into course values('j1004','Php');
insert into course values('j1005','java');
insert into course values('j1006','javascript');


create table classroom(
	classroom_no int primary key,
    capacity int not null
);

desc classroom;

insert into classroom values(901,34);
insert into classroom values(902,35);
insert into classroom values(903,25);
insert into classroom values(904,32);
insert into classroom values(905,30);
insert into classroom values(906,35);


create table instructor(
	instructor_id int primary key,
    name varchar(12) not null,
	reg_number varchar(14) not null,
    phone varchar(14) not null,
    address varchar(50),
    email varchar(20),
    course_code varchar(5) not null,
    foreign key (course_code) references course(course_code)
);

desc instructor;

insert into instructor values(1, '홍길동', '700918-1622011', '031-295-1234', '성남시 중원구 신흥동', 'kkk@jok.or.kr', 'j1001');
insert into instructor values(2, '유관순', '710419-2018916', '02-345-2345', '서울 강남구 개포동', 'kkk@jok.or.kr', 'j1002');
insert into instructor values(3, '이승복', '730112-1344911', '031-1234-6789', '서울시 강남구 논현동', 'sss@jok.or.kr', 'j1003');
insert into instructor values(4, '모택동', '730301-1167623', '031-567-5678', '서울시 서초구 서초동', 'mmm@jok.or.kr', 'j1004');
insert into instructor values(5, '주롱지', '730322-2037921', '031-789-3456', '서울시 강서구 가양동', 'xxx@jok.or.kr', 'j1005');
insert into instructor values(6, '이순신', '731122-1646213', '031-234-8901', '서울시 강북구 미아동', 'ppp@jok.or.kr', 'j1006');


create table student(
	student_id int primary key,
    name varchar(12) not null,
    reg_number varchar(14) not null, 
    phone varchar(14) not null,
    address varchar(50),
    email varchar(20)
);

desc student;

insert into student values(1, '김현진', '771212-2346111', '017-888-8888', '부산', 'aaa@hanmail.net');
insert into student values(2, '김석주', '720112-1234812', '016-999-9999', '경기', 'bbb@hanmail.net');
insert into student values(3, '고훈기', '730102-1555555', '017-555-5555', '서울', 'ccc@hanmail.net');
insert into student values(4, '유민경', '801111-2222222', '017-222-2222', '전남', 'ddd@hanmail.net');
insert into student values(5, '김영수', '811231-1777777', '017-777-7777', '충주', 'eee@hanmail.net');
insert into student values(6, '박상원', '790915-1333333', '017-333-3333', '강원', 'fff@hanmail.net');


create table enrollment(
	student_id int primary key,
    course_code varchar(5),
    foreign key (student_id) references student(student_id),
    foreign key (course_code) references course(course_code)
);

desc enrollment;

insert into enrollment values(1, 'j1001');
insert into enrollment values(2, 'j1002');
insert into enrollment values(3, 'j1003');
insert into enrollment values(4, 'j1004');
insert into enrollment values(5, 'j1005');
insert into enrollment values(6, 'j1006');


create table course_class(
	course_code varchar(5) primary key,
    classroom_no int,
    class_time int not null,
    instructor_id int,
    foreign key (course_code) references course(course_code),
    foreign key (classroom_no) references classroom(classroom_no),
    foreign key (instructor_id) references instructor(instructor_id)
);

desc course_class;

insert into course_class values('j1001', 901, 2, 1);
insert into course_class values('j1002', 902, 2, 2);
insert into course_class values('j1003', 903, 2, 3);
insert into course_class values('j1004', 904, 2, 4);
insert into course_class values('j1005', 905, 2, 5);
insert into course_class values('j1006', 906, 2, 6);

select * from course;
select * from classroom;
select * from instructor;
select * from student;
select * from enrollment;
select * from course_class;
