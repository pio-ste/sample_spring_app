package com.example.samplespringapp.service.dto;


import java.util.Set;

public class StudentWithTeachersDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String fieldOfStudy;
    private Set<TeacherDTO> teachersDTO;

    public StudentWithTeachersDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public Set<TeacherDTO> getTeachersDTO() {
        return teachersDTO;
    }

    public void setTeachersDTO(Set<TeacherDTO> teachersDTO) {
        this.teachersDTO = teachersDTO;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private Long id;
        private String firstName;
        private String lastName;
        private Integer age;
        private String email;
        private String fieldOfStudy;
        private Set<TeacherDTO> teachersDTO;

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

        public Builder fieldOfStudy(String fieldOfStudy){
            this.fieldOfStudy = fieldOfStudy;
            return this;
        }

        public Builder teachersDTO(Set<TeacherDTO> teachersDTO){
            this.teachersDTO = teachersDTO;
            return this;
        }

        public StudentWithTeachersDTO build() {
            StudentWithTeachersDTO studentWithTeachersDTO = new StudentWithTeachersDTO();
            studentWithTeachersDTO.id = this.id;
            studentWithTeachersDTO.firstName = this.firstName;
            studentWithTeachersDTO.lastName = this.lastName;
            studentWithTeachersDTO.age = this.age;
            studentWithTeachersDTO.email = this.email;
            studentWithTeachersDTO.fieldOfStudy = this.fieldOfStudy;
            studentWithTeachersDTO.teachersDTO = this.teachersDTO;

            return studentWithTeachersDTO;
        }
    }
}
