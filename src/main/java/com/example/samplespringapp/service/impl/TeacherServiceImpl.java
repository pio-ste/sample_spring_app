package com.example.samplespringapp.service.impl;

import com.example.samplespringapp.model.entity.Student;
import com.example.samplespringapp.model.entity.Teacher;
import com.example.samplespringapp.model.repository.StudentRepository;
import com.example.samplespringapp.model.repository.TeacherRepository;
import com.example.samplespringapp.service.TeacherService;
import com.example.samplespringapp.service.dto.TeacherDTO;
import com.example.samplespringapp.service.dto.TeacherWithStudentsDTO;
import com.example.samplespringapp.service.filter.QuerySpecification;
import com.example.samplespringapp.model.filter.SearchCriteria;
import com.example.samplespringapp.service.filter.SearchOperation;
import com.example.samplespringapp.service.mapper.TeacherMapper;
import com.example.samplespringapp.service.validation.TeacherValidation;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.samplespringapp.service.mapper.TeacherMapper.*;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    private final StudentRepository studentRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository, StudentRepository studentRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public TeacherDTO saveTeacher(TeacherDTO teacherDTO) {
        var teacherValidation = new TeacherValidation(teacherDTO);
        teacherValidation.validate();
        var teacher = mapFromDtoToEntity(teacherDTO);
        return mapFromEntityToDto(teacherRepository.save(teacher));
    }

    @Override
    public TeacherDTO updateTeacher(TeacherDTO teacherDTO) {
        var teacherValidation = new TeacherValidation(teacherDTO);
        teacherValidation.validate();
        var teacher = teacherRepository.getByIdOrThrow(teacherDTO.getId());
        teacher.setFirstName(teacherDTO.getFirstName());
        teacher.setLastName(teacherDTO.getLastName());
        teacher.setAge(teacher.getAge());
        teacher.setEmail(teacherDTO.getEmail());
        teacher.setSchoolSubject(teacherDTO.getSchoolSubject());
        return mapFromEntityToDto(teacher);
    }

    @Override
    public void deleteTeacher(Long idTeacher) {
        teacherRepository.deleteOrThrow(idTeacher);
    }

    @Override
    public Page<TeacherDTO> getSortedTeacher(Pageable pageable, Sort.Direction sortDirection,String arg) {
        Page<Teacher> teachers = teacherRepository.findAll(PageRequest.of(pageable.getPageNumber(), 2,
                Sort.by(sortDirection, arg)));
        List<TeacherDTO> teacherDTOList = teachers.stream().map(TeacherMapper::mapFromEntityToDto).collect(Collectors.toList());
        return new PageImpl<>(teacherDTOList, pageable, teachers.getTotalElements());
    }

    @Override
    public TeacherWithStudentsDTO addStudentToTeacher(Long idTeacher, Long idStudent) {
        var teacher = teacherRepository.getByIdOrThrow(idTeacher);
        var student = studentRepository.getByIdOrThrow(idStudent);
        Set<Student> students = teacher.getStudents();
        students.add(student);
        return mapFromEntityToDtoWith(teacher);
    }

    @Override
    public List<TeacherWithStudentsDTO> getTeacherByFirstNameAndLastName(String firstName, String lastName) {
        return teacherRepository.getByFirstNameAndLastName(firstName, lastName).stream()
                .map(TeacherMapper::mapFromEntityToDtoWith).collect(Collectors.toList());
    }

    @Override
    public List<TeacherDTO> filterTeacher(List<SearchCriteria> searchCriteriaList) {
        QuerySpecification<Teacher> specification = new QuerySpecification<>(searchCriteriaList);
        return teacherRepository.findAll(specification).stream()
                .map(TeacherMapper::mapFromEntityToDto).collect(Collectors.toList());
    }
}
