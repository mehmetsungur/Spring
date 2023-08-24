package com.modulcar.controller;

import jakarta.validation.Valid;
import com.modulcar.domain.Student;
import lombok.RequiredArgsConstructor;
import com.modulcar.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students") //localhost:8080/students
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    // getAll()
    @GetMapping
    public ResponseEntity<List<Student>> getAll(){
        List<Student> students = studentService.getAll();
        return ResponseEntity.ok(students); //200 + students
    }

    // createStudent()
    @PostMapping
    public ResponseEntity<Map<String,String>> createStudent(@RequestBody @Valid Student student){
        studentService.createStudent(student);

        Map<String,String> map = new HashMap<>();
        map.put("message","Student is created successfully");
        map.put("status","true");

        return new ResponseEntity<>(map, HttpStatus.CREATED); // map + 201
    }
}