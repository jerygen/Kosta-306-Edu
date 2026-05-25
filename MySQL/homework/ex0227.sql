use ex0227;

select * from student;
select * from instructor;
select * from classroom;
select * from course;
select * from enrollment;
select * from course_class;

select * from instructor where substring(address, instr(address, '강남구'), 3) = '강남구';
select * from student where substring(reg_number, 8,1) = '2';
select * from v_instructor_course;

CREATE or replace VIEW v_tear
as
select  te.instructor_id , name, te.course_code, course_name, ro.classroom_no, capacity
from instructor te
	inner join course su on te.course_code=su.course_code
	inner join course_class sug on su.course_code=sug.course_code
	inner join classroom ro on sug.classroom_no=ro.classroom_no;
    
select * from v_tear;