package com.example.samplespringapp.service.impl;

import com.example.samplespringapp.model.entity.Student;
import com.example.samplespringapp.model.entity.Teacher;
import com.example.samplespringapp.model.filter.SearchCriteria;
import com.example.samplespringapp.model.repository.StudentRepository;
import com.example.samplespringapp.model.repository.TeacherRepository;
import com.example.samplespringapp.service.StudentService;
import com.example.samplespringapp.service.dto.StudentDTO;
import com.example.samplespringapp.service.dto.StudentWithTeachersDTO;
import com.example.samplespringapp.service.filter.QuerySpecification;
import com.example.samplespringapp.service.mapper.StudentMapper;
import com.example.samplespringapp.service.validation.StudentValidation;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.samplespringapp.service.mapper.StudentMapper.*;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final TeacherRepository teacherRepository;

    public StudentServiceImpl(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        var studentValidation = new StudentValidation(studentDTO);
        studentValidation.validate();
        var student = mapFromDtoToEntity(studentDTO);
        return mapFromEntityToDto(studentRepository.save(student));
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        var studentValidation = new StudentValidation(studentDTO);
        studentValidation.validate();
        var student = studentRepository.getByIdOrThrow(studentDTO.getId());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setAge(studentDTO.getAge());
        student.setEmail(studentDTO.getEmail());
        student.setFieldOfStudy(student.getFieldOfStudy());
        return mapFromEntityToDto(student);
    }

    @Override
    public void deleteStudent(Long idStudent) {
        Student student = studentRepository.getByIdOrThrow(idStudent);
        for (Teacher teacher : student.getTeachers()) {
            student.removeTeacher(teacher);
        }
        studentRepository.deleteOrThrow(idStudent);
    }

    @Override
    public Page<StudentDTO> getSortedStudent(Pageable pageable, Sort.Direction sortDirection, String arg) {
        Page<Student> students = studentRepository.findAll(PageRequest.of(pageable.getPageNumber(), 2,
                Sort.by(sortDirection, arg)));
        List<StudentDTO> studentDTOList = students.stream().map(StudentMapper::mapFromEntityToDto).collect(Collectors.toList());
        return new PageImpl<>(studentDTOList, pageable, students.getTotalElements());
    }

    @Override
    public StudentWithTeachersDTO addTeacherToStudent(Long idStudent, Long idTeacher) {
        var student = studentRepository.getByIdOrThrow(idStudent);
        var teacher = teacherRepository.getByIdOrThrow(idTeacher);
        student.addTeacher(teacher);
        return mapFromEntityToDtoWith(student);
    }

    @Override
    public List<StudentWithTeachersDTO> getStudentByFirstNameAndLastName(String firstName, String lastName) {
        return studentRepository.getByFirstNameAndLastName(firstName, lastName).stream()
                .map(StudentMapper::mapFromEntityToDtoWith).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> filterStudent(List<SearchCriteria> searchCriteriaList) {
        QuerySpecification<Student> specification = new QuerySpecification<>(searchCriteriaList);
        return studentRepository.findAll(specification).stream()
                .map(StudentMapper::mapFromEntityToDto).collect(Collectors.toList());
    }
}
