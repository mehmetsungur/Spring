package com.modulcar.service;

import com.modulcar.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.modulcar.exception.ConflictException;
import com.modulcar.repository.StudentRepository;
import com.modulcar.exception.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll(); // SELECT * FROM students
    }

    public void createStudent(Student student) {
        // Email conflict control
        if(studentRepository.existsByEmail(student.getEmail())){
            throw new ConflictException("Email is already exist!");
        }
        studentRepository.save(student);
    }

    public Student findStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Student not found with id: " + id));
    }

    public void deleteStudent(Long id) {
        Student student = findStudent(id);
        studentRepository.delete(student);
    }
}
