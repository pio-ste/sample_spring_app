Dodawanie nauczyciela:
localhost:8080/teacher/addTeacher

![image](https://user-images.githubusercontent.com/38383227/145226890-3441d8fb-dcde-443f-948e-fc78fb65b8d7.png)

Walidacja:

![image](https://user-images.githubusercontent.com/38383227/145227114-e1e98417-e745-4949-a11e-d1a12116b1fa.png)

Dodawanie studenta
localhost:8080/student/addStudent

![image](https://user-images.githubusercontent.com/38383227/145227641-b707198f-d35f-4085-a9fc-dd7c6c018f48.png)

Dodawanie relacji pomiędzy studentem a nauczycielem
localhost:8080/student/addTeacherToStudent/{idStudent}/{idTeacher}

![image](https://user-images.githubusercontent.com/38383227/145227932-bbe57c85-87b4-453e-a07b-2e06080da503.png)

Dodawanie relacji pomiędzy nauczycielem a studentem:
localhost:8080/teacher/addStudentToTeacher/{idTeacher}/{idStudent}

![image](https://user-images.githubusercontent.com/38383227/145228087-8514210b-e05f-4de4-bb11-1cd386a8dd57.png)

Usuwanie nauczyciela:
localhost:8080/teacher/deleteTeacher/{idTeacher}

![image](https://user-images.githubusercontent.com/38383227/145228606-cc5851de-226a-4c23-b690-528db23d4223.png)

Usuwanie studenta:
localhost:8080/student/deleteStudent/{idStudent}

![image](https://user-images.githubusercontent.com/38383227/145228716-35e3f670-2915-4127-ab9e-c0c16229d1a4.png)

Edytowanie nauczyciela:
localhost:8080/teacher/updateTeacher

![image](https://user-images.githubusercontent.com/38383227/145229859-d228540e-5959-4fc6-b550-7a24c9f4996e.png)

Edytowanie studenta:
localhost:8080/student/updateStudent

![image](https://user-images.githubusercontent.com/38383227/145230107-15815789-9c7d-4e77-99b8-b78065aef60a.png)

Wyświetlanie nauczycieli za pomocą stronicowania oraz sortowania:
localhost:8080/teacher/getSortedTeachers/{sortDirection}/{arg}

![image](https://user-images.githubusercontent.com/38383227/145230415-e95903af-a3c9-4809-b692-9bba95710105.png)

Wyświetlanie studentów za pomocą stronicowania oraz sortowania:
localhost:8080/students/getSortedStudents/{sortDirection}/{arg}

![image](https://user-images.githubusercontent.com/38383227/145230746-95add63f-e306-4b76-9f12-d2e1166f36de.png)

Wyświetlane nauczycieli po imieniu i nazwisku:
localhost:8080/teacher/getTeacherByFirstNameAndLastName/{firstName}/{lastName}

![image](https://user-images.githubusercontent.com/38383227/145231106-d8b56264-1279-4262-ba91-7f12547f50a5.png)

Wyświetlane studentów po imieniu i nazwisku:
localhost:8080/teacher/getTeacherByFirstNameAndLastName/{firstName}/{lastName}

![image](https://user-images.githubusercontent.com/38383227/145231352-aa550417-28db-4799-97a4-b09c20ae43c2.png)

Filtrowanie nauczycieli z wykorzystaniem interfejsu Specification:
localhost:8080/teacher/getFilteredTeachers

![image](https://user-images.githubusercontent.com/38383227/145231463-86de35f9-30ad-4ce9-bff8-16111a3b09de.png)

Filtrowanie STUDENTÓW z wykorzystaniem interfejsu Specification:
localhost:8080/student/getFilteredStudents

![image](https://user-images.githubusercontent.com/38383227/145231935-3e8b90e1-5873-497d-a5f0-93412163b213.png)







