package com.example.samplespringapp.service;

import com.example.samplespringapp.model.filter.SearchCriteria;
import com.example.samplespringapp.service.dto.TeacherDTO;
import com.example.samplespringapp.service.dto.TeacherWithStudentsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface TeacherService {

    TeacherDTO saveTeacher(TeacherDTO teacherDTO);

    TeacherDTO updateTeacher(TeacherDTO teacherDTO);

    void deleteTeacher(Long idTeacher);

    Page<TeacherDTO> getSortedTeacher(Pageable pageable, Sort.Direction sortDirection, String arg);

    TeacherWithStudentsDTO addStudentToTeacher(Long idTeacher, Long idStudent);

    List<TeacherWithStudentsDTO> getTeacherByFirstNameAndLastName(String firstName, String lastName);

    List<TeacherDTO> filterTeacher(List<SearchCriteria> searchCriteriaList);





}
