package com.example.samplespringapp.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String fieldOfStudy;

    @ManyToMany(mappedBy = "students",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Teacher> teachers;

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        teacher.getStudents().add(this);
    }

    public void removeTeacher(Teacher teacher) {
        this.teachers.remove(teacher);
        teacher.getStudents().remove(this);
    }

    public Student() {
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

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public static Builder builder() { return new Builder();}

    public static final class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private Integer age;
        private String email;
        private String fieldOfStudy;
        private Set<Teacher> teachers;


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

        public Builder teachers(Set<Teacher> teachers){
            this.teachers = teachers;
            return this;
        }

        public Student build() {
            Student student = new Student();
            student.id = this.id;
            student.firstName = this.firstName;
            student.lastName = this.lastName;
            student.age = this.age;
            student.email = this.email;
            student.fieldOfStudy = this.fieldOfStudy;
            student.teachers = this.teachers;

            return student;
        }
    }
}
