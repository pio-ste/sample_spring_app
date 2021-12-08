insert into "teacher" (id, age, email, first_name, last_name, school_subject)
values (1, 29, 'adam.nowak@gmail.com', 'Adam', 'Nowak', 'Matematyka'),
       (2, 39, 'robert.nowak@gmail.com', 'Robert', 'Nowak', 'Fizyka'),
       (3, 49, 'karol.kowalski@gmail.com', 'Karol', 'Kowalski', 'Matematyka'),
       (4, 39, 'robert.kowalski@gmail.com', 'Robert', 'Kowalski', 'Fizyka'),
       (5, 35, 'adam.kowalski@gmail.com', 'Adam', 'Kowalski', 'Informatyka');

insert into "student" (id, age, email, field_of_study, first_name, last_name)
values (1, 22, 'adam.krawczyk@gmail.com', 'Informatyka', 'Adam', 'Krawczyk'),
       (2, 21, 'karol.nowak@gmail.com', 'Budownictwo', 'Karol', 'Nowak'),
       (3, 20, 'szymon.kowalski@gmail.com', 'Informatyka', 'Szymon', 'Kowalski'),
       (4, 23, 'mateusz.kowalski@gmail.com', 'Informatyka', 'Mateusz', 'Kowalski'),
       (5, 20, 'rafal.kowalski@gmail.com', 'Ekonomia', 'Rafał', 'Kowalski');

insert into "teachers_students" (id_teacher, id_student)
values (1,1),
       (1,2),
       (2,1),
       (2,2),
       (2,3);