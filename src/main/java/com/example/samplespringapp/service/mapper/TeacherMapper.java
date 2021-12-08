package com.example.samplespringapp.service.mapper;

import com.example.samplespringapp.model.entity.Student;
import com.example.samplespringapp.model.entity.Teacher;
import com.example.samplespringapp.service.dto.StudentDTO;
import com.example.samplespringapp.service.dto.TeacherDTO;
import com.example.samplespringapp.service.dto.TeacherWithStudentsDTO;

import java.util.stream.Collectors;

public class TeacherMapper {

    public TeacherMapper() {
    }

    public static TeacherDTO mapFromEntityToDto(Teacher teacher){
        return TeacherDTO.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .age(teacher.getAge())
                .email(teacher.getEmail())
                .schoolSubject(teacher.getSchoolSubject())
                .build();
    }

    public static TeacherWithStudentsDTO mapFromEntityToDtoWith(Teacher teacher) {
        return TeacherWithStudentsDTO.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .age(teacher.getAge())
                .email(teacher.getEmail())
                .schoolSubject(teacher.getSchoolSubject())
                .studentsDTO(teacher.getStudents().stream().map((student) ->
                                StudentDTO.builder()
                                        .id(student.getId())
                                        .firstName(student.getFirstName())
                                        .lastName(student.getLastName())
                                        .age(student.getAge())
                                        .email(student.getEmail())
                                        .fieldOfStudy(student.getFieldOfStudy())
                                        .build())
                        .collect(Collectors.toSet()))
                .build();
    }

    public static Teacher mapFromDtoToEntity(TeacherDTO teacherDTO){
        return Teacher.builder()
                .id(teacherDTO.getId())
                .firstName(teacherDTO.getFirstName())
                .lastName(teacherDTO.getLastName())
                .age(teacherDTO.getAge())
                .email(teacherDTO.getEmail())
                .schoolSubject(teacherDTO.getSchoolSubject())
                .build();
    }

    public static Teacher mapFromDtoWithToEntity(TeacherWithStudentsDTO teacherWithStudentsDTO){
        return Teacher.builder()
                .id(teacherWithStudentsDTO.getId())
                .firstName(teacherWithStudentsDTO.getFirstName())
                .lastName(teacherWithStudentsDTO.getLastName())
                .age(teacherWithStudentsDTO.getAge())
                .email(teacherWithStudentsDTO.getEmail())
                .schoolSubject(teacherWithStudentsDTO.getSchoolSubject())
                .students(teacherWithStudentsDTO.getStudentsDTO().stream().map((studentDTO) ->
                                Student.builder()
                                        .id(studentDTO.getId())
                                        .firstName(studentDTO.getFirstName())
                                        .lastName(studentDTO.getLastName())
                                        .age(studentDTO.getAge())
                                        .email(studentDTO.getEmail())
                                        .fieldOfStudy(studentDTO.getFieldOfStudy())
                                        .build())
                        .collect(Collectors.toSet()))
                .build();
    }
}
