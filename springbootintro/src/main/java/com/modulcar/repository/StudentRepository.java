package com.modulcar.repository;

import com.modulcar.domain.Student;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByEmail(String email);

    List<Student> findAllEqualsGrade(Integer grade);
}
