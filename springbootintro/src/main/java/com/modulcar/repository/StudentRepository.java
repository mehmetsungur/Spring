package com.modulcar.repository;

import java.util.List;
import java.util.Optional;
import com.modulcar.domain.Student;
import com.modulcar.dto.StudentDTO;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByEmail(String email);

    @Query(value = "SELECT s FROM Student s WHERE s.grade=:pGrade") //JPQL
    List<Student> findAllEqualsGrade(@Param("pGrade") Integer grade);

    @Query(value = "SELECT new com.modulcar.StudentDTO(s) FROM Student s WHERE s.id=:pid") //JPQL
    Optional<StudentDTO> findStudentDtoById(@Param("id") Long id);
}