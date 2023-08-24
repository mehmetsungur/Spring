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

    // getById()
    @GetMapping("/query") //localhost:8080/students/query?id=1
    public ResponseEntity<Student> getStudent(@RequestParam("id") Long id){
        Student student = studentService.findStudent(id);
        return ResponseEntity.ok(student);
    }

    // getStudentWithPath()
    @GetMapping("/{id}") //localhost:8080/students/1
    public ResponseEntity<Student> getStudentWithPath(@PathVariable("id") Long id){
        Student student = studentService.findStudent(id);
        return ResponseEntity.ok(student);
    }

    // deleteStudent()
    @DeleteMapping("/{id}") //localhost:8080/students/1
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        String message = "Student is deleted successfully";
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    // updateStudent()
    @PutMapping("/{id}") //localhost:8080/students/1
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Student student){
        studentService.updateStudent(id);
        String message = "Student is deleted successfully";
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
}
