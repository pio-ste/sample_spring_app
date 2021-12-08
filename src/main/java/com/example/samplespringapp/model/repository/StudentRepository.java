package com.example.samplespringapp.model.repository;

import com.example.samplespringapp.model.entity.Student;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends AbstractJpaRepository<Student>, JpaSpecificationExecutor<Student> {

    List<Student> getByFirstNameAndLastName(String firstName, String lastName);
}
