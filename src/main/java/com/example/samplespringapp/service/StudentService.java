package com.example.samplespringapp.service;

import com.example.samplespringapp.model.filter.SearchCriteria;
import com.example.samplespringapp.service.dto.StudentDTO;
import com.example.samplespringapp.service.dto.StudentWithTeachersDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface StudentService {

    StudentDTO saveStudent(StudentDTO studentDTO);

    StudentDTO updateStudent(StudentDTO studentDTO);

    void deleteStudent(Long idStudent);

    Page<StudentDTO> getSortedStudent(Pageable pageable, Sort.Direction sortDirection, String arg);

    StudentWithTeachersDTO addTeacherToStudent(Long idStudent, Long idTeacher);

    List<StudentWithTeachersDTO> getStudentByFirstNameAndLastName(String firstName, String lastName);

    List<StudentDTO> filterStudent(List<SearchCriteria> searchCriteriaList);
}
