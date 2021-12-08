package com.example.samplespringapp.model.repository;

import com.example.samplespringapp.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends AbstractJpaRepository<Teacher>, JpaSpecificationExecutor<Teacher> {

    List<Teacher> getByFirstNameAndLastName(String firstName, String lastName);
}
