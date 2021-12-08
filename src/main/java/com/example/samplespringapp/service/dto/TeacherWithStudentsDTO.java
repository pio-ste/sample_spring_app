package com.example.samplespringapp.service.dto;

import com.example.samplespringapp.model.entity.Teacher;

import java.util.Set;

public class TeacherWithStudentsDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String schoolSubject;
    private Set<StudentDTO> studentsDTO;

    public TeacherWithStudentsDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchoolSubject() {
        return schoolSubject;
    }

    public void setSchoolSubject(String schoolSubject) {
        this.schoolSubject = schoolSubject;
    }

    public Set<StudentDTO> getStudentsDTO() {
        return studentsDTO;
    }

    public void setStudentsDTO(Set<StudentDTO> studentsDTO) {
        this.studentsDTO = studentsDTO;
    }

    public static Builder builder() { return new Builder();}

    public static final class Builder {

        private Long id;
        private String firstName;
        private String lastName;
        private Integer age;
        private String email;
        private String schoolSubject;
        private Set<StudentDTO> studentsDTO;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }


        public Builder schoolSubject(String schoolSubject){
            this.schoolSubject = schoolSubject;
            return this;
        }

        public Builder studentsDTO(Set<StudentDTO> studentsDTO){
            this.studentsDTO = studentsDTO;
            return this;
        }

        public TeacherWithStudentsDTO build() {
            TeacherWithStudentsDTO teacherWithStudentsDTO = new TeacherWithStudentsDTO();
            teacherWithStudentsDTO.id = this.id;
            teacherWithStudentsDTO.firstName = this.firstName;
            teacherWithStudentsDTO.lastName = this.lastName;
            teacherWithStudentsDTO.age = this.age;
            teacherWithStudentsDTO.email = this.email;
            teacherWithStudentsDTO.schoolSubject = this.schoolSubject;
            teacherWithStudentsDTO.studentsDTO = this.studentsDTO;

            return teacherWithStudentsDTO;
        }
    }
}
