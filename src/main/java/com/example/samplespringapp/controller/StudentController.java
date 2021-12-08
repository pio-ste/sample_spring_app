package com.example.samplespringapp.controller;

import com.example.samplespringapp.model.filter.SearchCriteria;
import com.example.samplespringapp.service.StudentService;
import com.example.samplespringapp.service.dto.StudentDTO;
import com.example.samplespringapp.service.dto.StudentWithTeachersDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ResponseStatus(CREATED)
    @PostMapping("/addStudent")
    public StudentDTO addStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.saveStudent(studentDTO);
    }

    @ResponseStatus(CREATED)
    @PutMapping("/updateStudent")
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.updateStudent(studentDTO);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/deleteStudent/{idStudent}")
    public void deleteStudent(@PathVariable long idStudent) {
        studentService.deleteStudent(idStudent);
    }

    @ResponseStatus(CREATED)
    @PostMapping("/addTeacherToStudent/{idStudent}/{idTeacher}")
    public StudentWithTeachersDTO addTeacherToStudent(@PathVariable long idStudent,
                                                      @PathVariable long idTeacher) {
        return studentService.addTeacherToStudent(idStudent, idTeacher);
    }

    @GetMapping("/getSortedStudents/{sortDirection}/{arg}")
    public Page<StudentDTO> getSortedStudents(@PathVariable Sort.Direction sortDirection,
                                              @PathVariable String arg,
                                              Pageable pageable){
        return studentService.getSortedStudent(pageable, sortDirection, arg);
    }

    @GetMapping("/getStudentByFirstNameAndLastName/{firstName}/{lastName}")
    public List<StudentWithTeachersDTO> getStudentByFirstNameAndLastName(@PathVariable String firstName,
                                                                         @PathVariable String lastName){
        return studentService.getStudentByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping("/getFilteredStudents")
    public List<StudentDTO> getFilteredStudents(@RequestBody List<SearchCriteria> searchCriteriaList){
        return studentService.filterStudent(searchCriteriaList);
    }
}
