package com.example.samplespringapp.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String schoolSubject;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "teachers_students",
            joinColumns = {@JoinColumn(name = "id_teacher")},
            inverseJoinColumns = {@JoinColumn(name = "id_student")})
    private Set<Student> students;

    public Teacher() {
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private Integer age;
        private String email;
        private String schoolSubject;
        private Set<Student> students;

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

        public Builder students(Set<Student> students) {
            this.students = students;
            return this;
        }

        public Teacher build() {
            Teacher teacher = new Teacher();
            teacher.id = this.id;
            teacher.firstName = this.firstName;
            teacher.lastName = this.lastName;
            teacher.age = this.age;
            teacher.email = this.email;
            teacher.schoolSubject = this.schoolSubject;
            teacher.students = this.students;

            return teacher;
        }
    }
}
