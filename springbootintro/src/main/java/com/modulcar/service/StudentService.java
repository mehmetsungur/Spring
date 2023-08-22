package com.modulcar.service;

import com.modulcar.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.modulcar.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll(); // SELECT * FROM students
    }
}
