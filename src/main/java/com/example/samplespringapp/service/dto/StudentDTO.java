package com.example.samplespringapp.service.dto;


public class StudentDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String fieldOfStudy;

    public StudentDTO() {
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

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
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

        public StudentDTO build() {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.id = this.id;
            studentDTO.firstName = this.firstName;
            studentDTO.lastName = this.lastName;
            studentDTO.age = this.age;
            studentDTO.email = this.email;
            studentDTO.fieldOfStudy = this.fieldOfStudy;

            return studentDTO;
        }
    }
}
