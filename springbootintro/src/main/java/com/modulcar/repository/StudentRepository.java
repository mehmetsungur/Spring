package com.modulcar.repository;

import com.modulcar.domain.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByEmail(String email);

    @Query(value = "SELECT s FROM Student s WHERE s.grade=:pGrade") //JPQL
    List<Student> findAllEqualsGrade(@Param("pGrade") Integer grade);
}
