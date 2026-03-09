use ex0227;

select * from course;
select * from classroom;
select * from instructor;
select * from student;
select * from enrollment;
select * from course_class;

-- 1. 성별이 여자인 학생의 정보 검색
select * from student where substring(reg_number, 8,1) = 2;
-- 2. 생년월일이 1973년인 수강생 정보를 검색
select * from student where substring(reg_number, 1, 2) = 73;
-- 3. 성이 '홍'이 아닌 강사의 정보 검색
select * from instructor where name not like '홍%';
-- 4. 강남구에 거주하는 강사의 정보 검색
select * from instructor where substring(address, instr(address, '강남구'), 3) = '강남구';
-- 5. Java를 강의하는 강사 정보 검색(서브쿼리 이용)
select * from instructor where course_code = (select course_code from course where course_name = 'java');
-- 6. 주소가 null이 아닌 강사의 정보 검색
select * from instructor where address is not null;
-- 7. SQL 수업을 수강하고 있는 학생의 정보를 검색하는 뷰 작성
create or replace view v_student
as
select * from student 
where student_id in (select student_id from enrollment where course_code in 
							(select course_code from course where course_name = 'sql'));

select * from v_student;
-- 8. 강사가 담당하는 과목과 그 과목이 어느 강의실에서 진행되며 수용인원이 몇 명인지 검색(join 이용하여 뷰 작성)
create or replace view v_instructor_course
as 
select a.name, a.course_name, b.classroom_no, b.capacity
from (select course_code, name, course_name from instructor join course using(course_code)) a
	 join 
     (select course_code, classroom_no, capacity from course_class join classroom using(classroom_no)) b
     using(course_code);

select * from v_instructor_course;

-- 9. 학생의 이름 주민번호 성별을 출력
select name, reg_number, gender 
from student join 
(select student_id, if( substring(reg_number, 8, 1) = '1', '남자', '여자') as gender from student) a 
using(student_id); 

-- 10. 강사이름을 기준으로 올림차순으로 정렬하여 정렬된 순서대로 출력
select * from instructor order by name;