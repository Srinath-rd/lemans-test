insert into STUDENT
values(1, 'F', 'Wilawon');
insert into STUDENT
values(2, 'M', 'Murali');
insert into STUDENT
values(3, 'M', 'Rajeev');

insert into COURSE
values(1, 'DBA');
insert into COURSE
values(2, 'SQL');
insert into COURSE
values(3, 'BI');

insert into STUDENTCOURSE
values(1,'A+',  '2019-12-01', '99', 1, 1);
insert into STUDENTCOURSE
values(2,'A',  '2020-01-03', '91', 2, 1);
insert into STUDENTCOURSE
values(3, 'A',  '2019-12-15', '90',  2, 2);
insert into STUDENTCOURSE
values(4, 'B',   '2019-12-17', '80', 1, 2);
insert into STUDENTCOURSE
values(5,'A',  '2020-01-01', '94', 3, 2);




-- 1.	 Write a query to list all the students and their courses (columns: Student Name, Course Name, )
-- select student.id, course.course_name from studentcourse
--   inner join student on student.id = studentcourse.student_id
--   inner join course on course.id = studentcourse.course_id;
-- 2.	Write a query to list all the students and the number of courses they registered for
-- select student.id, count(course.course_name) from studentcourse
--   inner join student on student.id = studentcourse.student_id
--   inner join course on course.id = studentcourse.course_id
--   GROUP BY student.id
-- 3.	Get all the courses and the topper of each course
-- select student.id, student.name, studentcourse.course_id , studentcourse.score from studentcourse , student where studentcourse.student_id = student.id and score in
-- (select max(studentcourse.score) from studentcourse
--   inner join course on course.id = studentcourse.course_id
--   GROUP BY course.id);
-- 4.	 Get list of all students whose name starts with “R”
--
-- select * from student where student.name like 'R%';
-- 5.	List of students who did not register for “BI” course.
--
--
-- select distinct(student_id) from studentcourse
--              inner join course on course.id = studentcourse.course_id
--         where course_Id != 3
--
-- 6.	 Number of students registered in last month.
--
-- select distinct(student_id) from studentcourse
--              inner join course on course.id = studentcourse.course_id
--          where REGISTED_DATE > '2020-02-01' and REGISTED_DATE  < '2020-03-01'
