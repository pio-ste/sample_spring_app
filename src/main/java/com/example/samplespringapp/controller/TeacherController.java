package com.example.samplespringapp.controller;

import com.example.samplespringapp.model.filter.SearchCriteria;
import com.example.samplespringapp.service.TeacherService;
import com.example.samplespringapp.service.dto.StudentDTO;
import com.example.samplespringapp.service.dto.TeacherDTO;
import com.example.samplespringapp.service.dto.TeacherWithStudentsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @ResponseStatus(CREATED)
    @PostMapping("/addTeacher")
    public TeacherDTO addTeacher(@RequestBody TeacherDTO teacherDTO) {
        return teacherService.saveTeacher(teacherDTO);
    }

    @ResponseStatus(CREATED)
    @PutMapping("/updateTeacher")
    public TeacherDTO updateStudent(@RequestBody TeacherDTO teacherDTO) {
        return teacherService.updateTeacher(teacherDTO);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/deleteTeacher/{idTeacher}")
    public void deleteTeacher(@PathVariable long idTeacher) {
        teacherService.deleteTeacher(idTeacher);
    }

    @ResponseStatus(CREATED)
    @PostMapping("/addStudentToTeacher/{idTeacher}/{idStudent}")
    public TeacherWithStudentsDTO addTeacherToStudent(@PathVariable long idTeacher,
                                                      @PathVariable long idStudent) {
        return teacherService.addStudentToTeacher(idTeacher, idStudent);
    }

    @GetMapping("/getSortedTeachers/{sortDirection}/{arg}")
    public Page<TeacherDTO> getSortedTeachers(@PathVariable Sort.Direction sortDirection,
                                             @PathVariable String arg,
                                             Pageable pageable){
        return teacherService.getSortedTeacher(pageable, sortDirection, arg);
    }

    @GetMapping("/getTeacherByFirstNameAndLastName/{firstName}/{lastName}")
    public List<TeacherWithStudentsDTO> getTeacherByFirstNameAndLastName(@PathVariable String firstName,
                                                                         @PathVariable String lastName){
        return teacherService.getTeacherByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping("/getFilteredTeachers")
    public List<TeacherDTO> getFilteredTeachers(@RequestBody List<SearchCriteria> searchCriteriaList){
        return teacherService.filterTeacher(searchCriteriaList);
    }
}
