package com.example.samplespringapp.service.mapper;

import com.example.samplespringapp.model.entity.Student;
import com.example.samplespringapp.service.dto.StudentDTO;
import com.example.samplespringapp.service.dto.StudentWithTeachersDTO;
import com.example.samplespringapp.service.dto.TeacherDTO;

import java.util.stream.Collectors;

public class StudentMapper {

    public StudentMapper() {
    }

    public static StudentDTO mapFromEntityToDto(Student student) {
        return StudentDTO.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .age(student.getAge())
                .email(student.getEmail())
                .fieldOfStudy(student.getFieldOfStudy())
                .build();
    }

    public static StudentWithTeachersDTO mapFromEntityToDtoWith(Student student) {
        return StudentWithTeachersDTO.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .age(student.getAge())
                .email(student.getEmail())
                .fieldOfStudy(student.getFieldOfStudy())
                .teachersDTO(student.getTeachers().stream().map((teacher) ->
                                TeacherDTO.builder()
                                        .id(teacher.getId())
                                        .firstName(teacher.getFirstName())
                                        .lastName(teacher.getLastName())
                                        .age(teacher.getAge())
                                        .email(teacher.getEmail())
                                        .schoolSubject(teacher.getSchoolSubject())
                                        .build())
                        .collect(Collectors.toSet()))
                .build();
    }

    public static Student mapFromDtoToEntity(StudentDTO studentDTO) {
        return Student.builder()
                .id(studentDTO.getId())
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .age(studentDTO.getAge())
                .email(studentDTO.getEmail())
                .fieldOfStudy(studentDTO.getFieldOfStudy())
                .build();
    }
}
