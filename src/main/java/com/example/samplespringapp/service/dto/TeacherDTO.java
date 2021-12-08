package com.example.samplespringapp.service.dto;

public class TeacherDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String schoolSubject;

    public TeacherDTO() {
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

    public static Builder builder() { return new Builder();}

    public static final class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private Integer age;
        private String email;
        private String schoolSubject;

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

        public TeacherDTO build() {
            TeacherDTO teacherDTO = new TeacherDTO();
            teacherDTO.id = this.id;
            teacherDTO.firstName = this.firstName;
            teacherDTO.lastName = this.lastName;
            teacherDTO.age = this.age;
            teacherDTO.email = this.email;
            teacherDTO.schoolSubject = this.schoolSubject;

            return teacherDTO;
        }
    }
}
